package com.openingdesign.qna.portlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.openingdesign.qna.NoSuchQueryAndResponseException;
import com.openingdesign.qna.model.QueryAndResponse;
import com.openingdesign.qna.service.QueryAndResponseLocalServiceUtil;
import com.openingdesign.qna.util.QueryAndResponseUtil;
import com.openingdesign.qna.util.QueryAndResponseValidator;
import com.openingdesign.qna.util.WebKeys;

public class QNAOnSketchspaces extends MVCPortlet {

	@Override
	public void render(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		
		try {
			QueryAndResponse qnr = null;
			
			// get query instance (and store in request)
			long resourcePrimKey = ParamUtil.getLong(request, "resourcePrimKey");
			if (resourcePrimKey > 0) {
				qnr = QueryAndResponseLocalServiceUtil.getQueryAndResponse(resourcePrimKey);
				request.setAttribute(WebKeys.QUERY_ENTRY, qnr);
			}
			
			// get response instance (and store in request)
			long responsePrimKey = ParamUtil.getLong(request, "responsePrimKey");
			if (responsePrimKey > 0) {
				qnr = QueryAndResponseLocalServiceUtil.getQueryAndResponse(responsePrimKey);
				request.setAttribute(WebKeys.QUERY_RESPONSE, qnr);
				qnr = QueryAndResponseLocalServiceUtil.getQueryAndResponse(qnr.getParentId());
				request.setAttribute(WebKeys.QUERY_ENTRY, qnr);
			}
		} catch (Exception e) {
			if (e instanceof NoSuchQueryAndResponseException) {
				SessionErrors.add(request, e.getClass().getName());
			} else {
				throw new PortletException(e);
			}
		}
		super.render(request, response);
	}
	
	public void updateQuery(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		
		QueryAndResponse query = QueryAndResponseUtil.queryAndResponseFromRequest(request);
		
		ArrayList<String> errors = new ArrayList<String>();
		ServiceContext serviceContext = ServiceContextFactory.getInstance(QueryAndResponse.class.getName(), request);

		if (QueryAndResponseValidator.validate(query, errors)) {
			System.out.println("query validated: " + query);
			if (query.getQueryId() > 0) {
				// update
				try {
//					QueryAndResponse fromDB = QueryAndResponseLocalServiceUtil.getQueryAndResponse(query.getQueryId());
					// TODO: really check if we got it from the db?
					QueryAndResponseLocalServiceUtil
							.updateQueryAndResponse(query, query.getUserId(),
									serviceContext);
					SessionMessages.add(request, "query-added");
				} catch (PortalException e) {
					e.printStackTrace();
					errors.add("failed-to-update");
				} catch (SystemException e) {
					e.printStackTrace();
					errors.add("failed-to-update");
				}
			} else {
				// add
				QueryAndResponse fromDb = null;
				try {
					fromDb = QueryAndResponseLocalServiceUtil.addQueryAndResponse(query, query.getUserId(), serviceContext);
				} catch (SystemException e) {
					e.printStackTrace();
					errors.add("failed-to-add");
				} catch (PortalException e) {
					e.printStackTrace();
					errors.add("failed-to-add");
				}
				request.setAttribute(WebKeys.QUERY_ENTRY, fromDb);
				response.setRenderParameter("jspPage", "/edit_query_pad.jsp");
				
			}
		} else { // didn't validate
			
			for (String error : errors) {
				SessionErrors.add(request, error);
			}
			
			request.setAttribute(WebKeys.QUERY_ENTRY, query);
			response.setRenderParameter("jspPage", "/edit_query.jsp");
			
		}
	}
	
	public void addResponse(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		
		QueryAndResponse r = QueryAndResponseUtil.newQueryAndResponse(request);
		
		// get the parent (the actual query) and set as parent
		Long parentId = Long.parseLong(ParamUtil.getString(request, "resourcePrimKey"));
		if (parentId == 0) {
			throw new PortalException("parent query id is 0, cannot create response");
		}
		QueryAndResponse parent = QueryAndResponseLocalServiceUtil.getQueryAndResponse(parentId);
		r.setParentId(parentId);
		
		// perform the creation in database and create / copy the pad instance
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				QueryAndResponse.class.getName(), request);
		r = QueryAndResponseLocalServiceUtil.addResponseToQuery(r, parent,
				r.getUserId(), serviceContext);
		QueryAndResponseUtil.eagerFetchDetails(r);
		
		// set attributes in request/response
		request.setAttribute(WebKeys.QUERY_ENTRY,
				QueryAndResponseLocalServiceUtil.getQueryAndResponse(parentId));
		request.setAttribute(WebKeys.QUERY_RESPONSE, r);
		response.setRenderParameter("jspPage", "/edit_response.jsp");
		
	}
	
}
