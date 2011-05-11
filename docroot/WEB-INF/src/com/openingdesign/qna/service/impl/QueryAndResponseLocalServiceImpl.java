/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.openingdesign.qna.service.impl;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Date;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;
import com.openingdesign.qna.model.QueryAndResponse;
import com.openingdesign.qna.service.QueryAndResponseLocalServiceUtil;
import com.openingdesign.qna.service.base.QueryAndResponseLocalServiceBaseImpl;
import com.openingdesign.qna.util.QueryAndResponseUtil;
import com.openingdesign.qna.util.RandomPadIdGenerator;

/**
 * The implementation of the query and response local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.openingdesign.qna.service.QueryAndResponseLocalService} interface.
 * </p>
 * 
 * <p>
 * Never reference this interface directly. Always use
 * {@link com.openingdesign.qna.service.QueryAndResponseLocalServiceUtil} to
 * access the query and response local service.
 * </p>
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author Alacrity Pty (Ltd)
 * @see com.openingdesign.qna.service.base.QueryAndResponseLocalServiceBaseImpl
 * @see com.openingdesign.qna.service.QueryAndResponseLocalServiceUtil
 */
public class QueryAndResponseLocalServiceImpl extends
		QueryAndResponseLocalServiceBaseImpl {

	public QueryAndResponse addQueryAndResponse(QueryAndResponse dto,
			long userId, ServiceContext serviceContext) throws SystemException,
			PortalException {

		QueryAndResponse qnr = queryAndResponsePersistence
				.create(counterLocalService.increment(QueryAndResponse.class
						.getName()));

		qnr.setCompanyId(dto.getCompanyId());
		qnr.setGroupId(dto.getGroupId());
		qnr.setUserId(serviceContext.getUserId());
		qnr.setCreatedAt(new Date());
		qnr.setTitle(dto.getTitle());
		qnr.setParentId(dto.getParentId());
		qnr.setUrl(RandomPadIdGenerator.BASE_URL + QueryAndResponseUtil.createNewPadId());

		queryAndResponsePersistence.update(qnr, false);

		resourceLocalService.addResources(qnr.getCompanyId(), qnr.getGroupId(),
				userId, QueryAndResponse.class.getName(), qnr.getPrimaryKey(),
				false, true, true);

		assetEntryLocalService.updateEntry(userId, qnr.getGroupId(),
				QueryAndResponse.class.getName(), qnr.getQueryId(),
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames());

		createPad(qnr);
		
		return qnr;
		
	}
	
	private void createPad(QueryAndResponse qnr) throws PortalException {
	
		DefaultHttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet(qnr.getUrl() + "?createImmediately=true");
		System.out.println("CREATE_PAD, URI=" + get.getURI());
		try {
			HttpResponse response = client.execute(get);
			System.out.println("RESPONSE: status_line=" + response.getStatusLine());
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			throw new PortalException("unable to create pad");
		} catch (IOException e) {
			e.printStackTrace();
			throw new PortalException("unable to create pad");
		}
		
	}
	
	public QueryAndResponse updateQueryAndResponse(QueryAndResponse dto,
			long userId, ServiceContext sc) throws SystemException, PortalException {
		
		QueryAndResponse fromDb = QueryAndResponseLocalServiceUtil.getQueryAndResponse(dto.getQueryId());
		fromDb.setTitle(dto.getTitle());
		fromDb.setCompanyId(dto.getCompanyId());
		fromDb.setGroupId(dto.getGroupId());
		
		fromDb = updateQueryAndResponse(fromDb, false);
		
		assetEntryLocalService.updateEntry(userId, fromDb.getGroupId(),
				QueryAndResponse.class.getName(), fromDb.getQueryId(),
				sc.getAssetCategoryIds(),
				sc.getAssetTagNames());

		return fromDb;

	}
	
	public QueryAndResponse getQueryAndResponse(long qnrId) throws SystemException, PortalException {
		QueryAndResponse qnr = queryAndResponsePersistence.fetchByPrimaryKey(qnrId);
		QueryAndResponseUtil.eagerFetchDetails(qnr);
		return qnr;
	}
	
}