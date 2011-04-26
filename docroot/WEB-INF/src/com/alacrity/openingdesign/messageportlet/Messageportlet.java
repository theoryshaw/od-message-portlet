package com.alacrity.openingdesign.messageportlet;

import java.io.IOException;
import java.util.Date;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.alacrity.openingdesign.messageportlet.model.model.SKQuestion;
import com.alacrity.openingdesign.messageportlet.model.model.impl.SKQuestionImpl;
import com.alacrity.openingdesign.messageportlet.model.service.SKQuestionLocalService;
import com.alacrity.openingdesign.messageportlet.model.service.SKQuestionLocalServiceUtil;
import com.alacrity.openingdesign.messageportlet.modes.Mode;
import com.alacrity.openingdesign.messageportlet.modes.ModeOwner;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

public class Messageportlet extends GenericPortlet implements ModeOwner {

	protected String viewJSP;
	protected String createThreadJSP;
	protected String viewThreadJSP;

	public void init() throws PortletException {
		viewJSP = getInitParameter("view-jsp");
		createThreadJSP = getInitParameter("createThread-jsp");
		viewThreadJSP = getInitParameter("viewThread-jsp");
	}

	private Mode mode = Mode.DEFAULT;
	private ActionRequest action;
	
	private int page = 1;
	private static final int recordLimit = 7;

	private final PadURLGenerator padUrlGenerator = new RandomPadGenerator();

	SKQuestionLocalService access;
	
	private User user;
	private int userTimeOffset=0;
	private int serverTimeOffset=0;//TimeZone.getDefault().getRawOffset();

	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		access = SKQuestionLocalServiceUtil.getService();

		try {
			user = UserLocalServiceUtil.getUserById(Integer.parseInt(renderRequest.getRemoteUser()));
			userTimeOffset=user.getTimeZone().getRawOffset();
			
			
			mode.doMode(renderRequest, renderResponse, this);
			
		} catch (Exception e) {
			throw new PortletException(e);
		}
		
		mode=Mode.DEFAULT;
	}

	public void include(String path, RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		PortletRequestDispatcher portletRequestDispatcher = getPortletContext()
				.getRequestDispatcher(path);
		if (portletRequestDispatcher == null) {
		} else {
			portletRequestDispatcher.include(renderRequest, renderResponse);
		}
	}

	public void processAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {

			this.action = actionRequest;
			mode=Mode.getMode(this);
			
			actionResponse.setPortletMode(PortletMode.VIEW);
	}

	@Override
	public void saveNewThread(final String title,final String url,final Long parentId)
			throws SystemException {

		final SKQuestion q = new SKQuestionImpl();
		q.setTitle(title);
		q.setUrl(url);
		q.setPost_Date(new Date().getTime());
		q.setUser_ID(user.getUserId());
		q.setParent_ID(parentId);

		access.addSKQuestion(q);
		

	}

	@Override
	public final String getUnusedURL() throws PortalException, SystemException {

		do {

			String n = padUrlGenerator.getURL();

			SKQuestion exists = access.getSKQuestionByUrl(n);

			if (exists == null) {
				return n;
			}

		} while (true);

	}

	@Override
	public int getStartFromPage() {
		return (page * recordLimit) - recordLimit;
	}

	@Override
	public int getEndFromPage() {
		return (page * recordLimit) - 1;
	}

	@Override
	public String getCreateThreadURL() {
		return createThreadJSP;
	}

	@Override
	public ActionRequest getCurrentAction() {
		return action;
	}

	@Override
	public String getURL() {
		return viewJSP;
	}

	@Override
	public String getViewThreadURL() {
		return viewThreadJSP;
	}

	@Override
	public void setPageNumber(int page) {
		this.page=page;
	}

	@Override
	public Integer getUserTimeOffset() {
		return userTimeOffset;
	}

	@Override
	public Integer getServerTimeOffset() {
		return serverTimeOffset;
	}

}
