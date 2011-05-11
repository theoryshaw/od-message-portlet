package com.openingdesign.qna.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.openingdesign.qna.model.QueryAndResponse;
import com.openingdesign.qna.model.impl.QueryAndResponseImpl;
import com.openingdesign.qna.service.QueryAndResponseLocalServiceUtil;

public class QueryAndResponseUtil {

	public static String createNewPadId() {
		return RandomPadIdGenerator.nextPadId();
	}
	
	public static List<QueryAndResponse> getQueries(RenderRequest request, int start, int end) {
	
		List<QueryAndResponse> qnrs = new ArrayList<QueryAndResponse>();
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();
		try {
			// TODO: we should probably use the groupId here? compare the 'slogans' demo portlet.
		
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(
					QueryAndResponse.class,
					PortalClassLoaderUtil.getClassLoader());
			query.add(PropertyFactoryUtil.forName("parentId").eq(0L));
			query.addOrder(OrderFactoryUtil.desc("createdAt"));
			
			@SuppressWarnings("rawtypes")
			List list = QueryAndResponseLocalServiceUtil.dynamicQuery(query, start, end);
			for (Object o : list) {
				System.out.println("dynamic query, o=" + o);
			}

//			qnrs = QueryAndResponseLocalServiceUtil.getQueryAndResponses(start, end);
			for (Object rawQnr : list) {
				QueryAndResponse qnr = null;
				try {
					qnr = (QueryAndResponse) rawQnr;
					eagerFetchDetails(qnr);
					qnrs.add(qnr);
				} catch (Exception e) {
					e.printStackTrace();
					qnr.setCreatedByName("??");
				}
			}
		} catch (SystemException e) {
			e.printStackTrace();
			qnrs = Collections.emptyList();
		}
		return qnrs;
		
	}
	
	public static List<QueryAndResponse> getResponsesForQuery(RenderRequest request, long queryId) throws PortalException {
		
		List<QueryAndResponse> r = new ArrayList<QueryAndResponse>();
		
		try {
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(
					QueryAndResponse.class,
					PortalClassLoaderUtil.getClassLoader());
			query.add(PropertyFactoryUtil.forName("parentId").eq(queryId));
			query.addOrder(OrderFactoryUtil.desc("createdAt"));
			
			@SuppressWarnings("rawtypes")
			List list = QueryAndResponseLocalServiceUtil.dynamicQuery(query);
			for (Object raw : list) {
				eagerFetchDetails((QueryAndResponse) raw);
				r.add((QueryAndResponse) raw);
			}
		} catch (SystemException e) {
			e.printStackTrace();
			r = Collections.emptyList();
		}
		return r;
		
	}
	
	public static void eagerFetchDetails(QueryAndResponse qnr) throws PortalException, SystemException {
		qnr.setCreatedByName(UserLocalServiceUtil.getUser(qnr.getUserId()).getFullName());
		qnr.setCategoriesDisplayable(determineCategoriesDisplayable(qnr));
	}

	private static String determineCategoriesDisplayable(QueryAndResponse qnr) throws SystemException, PortalException {
		
		long[] categoryIds = AssetCategoryLocalServiceUtil.getCategoryIds(QueryAndResponse.class.getName(), qnr.getPrimaryKey());
		StringBuilder r = new StringBuilder();
		for (long categoryId : categoryIds) {
			String name = AssetCategoryLocalServiceUtil.getCategory(categoryId).getName();
			if (r.length() > 0) {
				r.append(", ");
			}
			r.append(name);
		}
		return r.toString();
		
	}

	public static int getQueriesCount(RenderRequest request) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();
		try {
			// TODO: should we use groupId?
			return QueryAndResponseLocalServiceUtil.getQueryAndResponsesCount();
		} catch (SystemException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public static QueryAndResponse queryAndResponseFromRequest(ActionRequest request) {
		
		
		QueryAndResponse qnr = newQueryAndResponse(request);
		
		qnr.setQueryIdString(ParamUtil.getString(request, "resourcePrimKey"));
		qnr.setTitle(ParamUtil.getString(request, "title"));
		
		if (qnr.getQueryIdString() != "") {
			qnr.setQueryId(Long.parseLong(qnr.getQueryIdString()));
		}

		// TODO: createdAt is set in
		// com.openingdesign.qna.service.impl.QueryAndResponseLocalServiceImpl.addQueryAndResponse(QueryAndResponse,
		// long, ServiceContext)
		return qnr;
		
	}
	
	public static QueryAndResponse newQueryAndResponse(ActionRequest request) {
		
		QueryAndResponse qnr = new QueryAndResponseImpl();
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		qnr.setCompanyId(themeDisplay.getCompanyId());
		qnr.setGroupId(themeDisplay.getScopeGroupId());
		qnr.setUserId(themeDisplay.getUserId());
		return qnr;
		
	}
}
