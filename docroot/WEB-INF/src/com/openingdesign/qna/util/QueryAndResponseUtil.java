package com.openingdesign.qna.util;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.persistence.UserUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.openingdesign.qna.model.QueryAndResponse;
import com.openingdesign.qna.model.impl.QueryAndResponseImpl;
import com.openingdesign.qna.service.QueryAndResponseLocalServiceUtil;

public class QueryAndResponseUtil {

	public static String createNewPadId() {
		return RandomPadIdGenerator.nextPadId();
	}
	
	public static List<QueryAndResponse> getQueries(RenderRequest request, int start, int end) {
	
		List<QueryAndResponse> qnrs;
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();
		try {
			// TODO: we should probably use the groupId here? compare the 'slogans' demo portlet.
			qnrs = QueryAndResponseLocalServiceUtil.getQueryAndResponses(start, end);
			for (QueryAndResponse qnr : qnrs) {
				try {
					qnr.setCreatedByName(UserLocalServiceUtil.getUser(qnr.getUserId()).getFullName());
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
		
		QueryAndResponse qnr = new QueryAndResponseImpl();
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		qnr.setCompanyId(themeDisplay.getCompanyId());
		qnr.setGroupId(themeDisplay.getScopeGroupId());
		qnr.setUserId(themeDisplay.getUserId());
		qnr.setQueryIdString(ParamUtil.getString(request, "resourcePrimKey"));
		qnr.setTitle(ParamUtil.getString(request, "title"));
		
		if (qnr.getQueryIdString() != "") {
			qnr.setQueryId(Long.parseLong(qnr.getQueryIdString()));
		}

		// TODO: createdAt is set in com.openingdesign.qna.service.impl.QueryAndResponseLocalServiceImpl.addQueryAndResponse(QueryAndResponse, long, ServiceContext)
//		if (qnr.getQueryId() == 0) {
//			// it is a new query, supposedly
//			qnr.setCreatedAt(new Date());
//		}
		
//		int dateMonth = ParamUtil.getInteger(request, "queryDateMonth");
//		int dateDay = ParamUtil.getInteger(request, "queryDateDay");
//		int dateYear = ParamUtil.getInteger(request, "queryDateYear");
//		try {
//			qnr.setCreatedAt(PortalUtil.getDate(dateMonth, dateDay, dateYear, new PortalException()));
//		} catch (PortalException e) {
//			qnr.setCreatedAt(new Date());
//		}
		
		return qnr;
		
	}
}
