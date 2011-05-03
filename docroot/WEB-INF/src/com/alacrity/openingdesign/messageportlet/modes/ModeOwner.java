package com.alacrity.openingdesign.messageportlet.modes;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

public interface ModeOwner {
	
	String getUnusedURL()throws PortalException, SystemException;
	
	String getURL();
	
	String getCreateThreadURL();
	
	String getViewThreadURL();
	
	void include(String path, RenderRequest renderRequest,
	RenderResponse renderResponse) throws IOException, PortletException;
	
	void saveNewThread(String title, String url, Long parentId)
	throws SystemException;
	
	ActionRequest getCurrentAction();

	int getStartFromPage();

	int getEndFromPage();

	void setPageNumber(int page);

	Integer getUserTimeOffset();

	Integer getServerTimeOffset();

	Long getCurrentUserId();

}
