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

package com.openingdesign.qna.model.impl;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.persistence.UserUtil;
import com.openingdesign.qna.model.QueryAndResponse;

/**
 * The model implementation for the QueryAndResponse service. Represents a row in the &quot;OD_QueryAndResponse&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.openingdesign.qna.model.QueryAndResponse} interface.
 * </p>
 *
 * <p>
 * Never reference this class directly. All methods that expect a query and response model instance should use the {@link QueryAndResponse} interface instead.
 * </p>
 */
public class QueryAndResponseImpl extends QueryAndResponseModelImpl
	implements QueryAndResponse {
	
	private String stringId;
	
	public QueryAndResponseImpl() {
	}
	
	public void setQueryIdString(String stringId) {
		this.stringId = stringId;
	}
	
	public String getQueryIdString() {
		return stringId;
	}
	
	public String getCreatedByName() {
		try {
			User user = UserUtil.findByPrimaryKey(getUserId());
			return user.getFullName();
		} catch (NoSuchUserException e) {
			e.printStackTrace();
			return "??";
		} catch (SystemException e) {
			e.printStackTrace();
			return "??";
		}
	}
}