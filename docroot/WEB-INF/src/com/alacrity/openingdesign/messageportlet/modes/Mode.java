package com.alacrity.openingdesign.messageportlet.modes;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public enum Mode {
	
	DEFAULT{
		
		@Override
		public final void doMode(RenderRequest renderRequest,
				RenderResponse renderResponse, ModeOwner owner) throws IOException, PortletException,
				SystemException, PortalException {
			setup(renderRequest,renderResponse,owner);
			
			PortletURL createThread = renderResponse.createActionURL();
			createThread.setParameter(ACTION, CREATE_NEW_THREAD_ACTION);
			renderRequest.setAttribute(CREATE_THREAD_URL_PARAMETER_NAME, createThread.toString());
			
			PortletURL changePage = renderResponse.createActionURL();
			changePage.setParameter(ACTION, CHANGE_PAGE_NUMBER_ACTION);
			renderRequest.setAttribute(CHANGE_PAGE_NUMBER_URL_PARAMETER_NAME, changePage.toString());
			
			renderRequest.setAttribute(PAGE_START_PARAMETER_NAME, ((Integer) owner.getStartFromPage())
					.toString());
			renderRequest.setAttribute(PAGE_END_PARAMETER_NAME, ((Integer) owner.getEndFromPage())
					.toString());

			PortletURL viewThread = renderResponse.createActionURL();
			viewThread.setParameter(ACTION, VIEW_THREAD_ACTION);
			renderRequest.setAttribute(VIEW_THREAD_URL_OARAMETER_NAME, viewThread.toString());
			
			owner.include(owner.getURL(), renderRequest, renderResponse);
			
		}
		
		
	},
	CREATE_NEW_THREAD{

		@Override
		public final void doMode(RenderRequest renderRequest,
				RenderResponse renderResponse, ModeOwner owner)
				throws IOException, PortletException, SystemException,
				PortalException {

			setup(renderRequest,renderResponse,owner);

			renderRequest.setAttribute(PAD_URL_PARAMETER_NAME, owner.getUnusedURL() + "?docreate=true");

			PortletURL createThread = renderResponse.createActionURL();
			createThread.setParameter(ACTION, SUBMIT_NEW_THREAD_ACTION);
			renderRequest.setAttribute(SUBMIT_THREAD_URL_PARAMETER_NAME, createThread.toString());

			owner.include(owner.getCreateThreadURL(), renderRequest, renderResponse);
			
		}
		
	},
	SUBMIT_NEW_THREAD{

		@Override
		public final void doMode(RenderRequest renderRequest,
				RenderResponse renderResponse, ModeOwner owner) throws IOException, PortletException,
				SystemException, PortalException {
			System.out.println("##########################################");
			setup(renderRequest,renderResponse,owner);
			
			try {
			renderRequest.setAttribute(MESSAGE_PARAMETER_NAME,
			"Your thread has been created<br><br>");

			ActionRequest action = owner.getCurrentAction();
			
			
				owner.saveNewThread(action.getParameter(TITLE_FORM_PARAMETER_NAME), action
						.getParameter(URL_FORM_PARAMETER_NAME), 0L);
				
			} catch (Exception w) {
				renderRequest.setAttribute(MESSAGE_PARAMETER_NAME, w.getMessage());
				w.printStackTrace();
			}
			
			Mode.DEFAULT.doMode(renderRequest, renderResponse, owner);
			
		}
		
	},
	VIEW_THREAD{

		@Override
		public final void doMode(RenderRequest renderRequest,
				RenderResponse renderResponse, ModeOwner owner) throws IOException, PortletException,
				SystemException, PortalException {
			
			setup(renderRequest,renderResponse,owner);
			
			ActionRequest action = owner.getCurrentAction();
			
			renderRequest.setAttribute(THREAD_ID_PARAMETER_NAME, action.getParameter(THREAD_ID_PARAMETER_NAME));

			PortletURL addAwnser = renderResponse.createActionURL();
			addAwnser.setParameter(ACTION, ADD_AWNSER_TO_THREAD_ACTION);
			addAwnser.setParameter(VIEW_TAB_PARAMETER_NAME, VIEW_MY_AWNSERS_ACTION);
			addAwnser.setParameter(THREAD_ID_PARAMETER_NAME, action.getParameter(THREAD_ID_PARAMETER_NAME));
			renderRequest.setAttribute(AWNSER_ACTION_URL_PARAMETER_NAME, addAwnser.toString());
			
			PortletURL viewThreadQuestionAction = renderResponse.createActionURL();
			viewThreadQuestionAction.setParameter(ACTION, VIEW_THREAD_ACTION);
			try {
				viewThreadQuestionAction.setParameter(THREAD_ID_PARAMETER_NAME, action.getParameter(THREAD_ID_PARAMETER_NAME));
			} catch (IllegalArgumentException e) {
				// means that we didn't get the param from 'action'... ignore
			}
			viewThreadQuestionAction.setParameter(VIEW_TAB_PARAMETER_NAME, VIEW_QUESTION_ACTION);
			renderRequest.setAttribute(VIEW_QUESTION_URL_PARAMETER_NAME, viewThreadQuestionAction.toString());
			
			
			
			PortletURL viewThreadAwnsersAction = renderResponse.createActionURL();
			viewThreadAwnsersAction.setParameter(ACTION, VIEW_THREAD_ACTION);
			viewThreadAwnsersAction.setParameter(THREAD_ID_PARAMETER_NAME, action.getParameter(THREAD_ID_PARAMETER_NAME));
			viewThreadAwnsersAction.setParameter(VIEW_TAB_PARAMETER_NAME, VIEW_AWNSERS_ACTION);
			renderRequest.setAttribute(VIEW_AWNSERS_URL_PARAMETER_NAME, viewThreadAwnsersAction.toString());
			
			
			PortletURL viewThreadMyAwnsersAction = renderResponse.createActionURL();
			viewThreadMyAwnsersAction.setParameter(ACTION, VIEW_THREAD_ACTION);
			viewThreadMyAwnsersAction.setParameter(THREAD_ID_PARAMETER_NAME, action.getParameter(THREAD_ID_PARAMETER_NAME));
			viewThreadMyAwnsersAction.setParameter(VIEW_TAB_PARAMETER_NAME, VIEW_MY_AWNSERS_ACTION);
			renderRequest.setAttribute(VIEW_MY_AWNSERS_URL_PARAMETER_NAME, viewThreadMyAwnsersAction.toString());
			
			
			if (action.getParameter(VIEW_TAB_PARAMETER_NAME)!=null){
				renderRequest.setAttribute(VIEW_TAB_PARAMETER_NAME, action.getParameter(VIEW_TAB_PARAMETER_NAME));
			} else {
				renderRequest.setAttribute(VIEW_TAB_PARAMETER_NAME, VIEW_QUESTION_ACTION);
			}

			owner.include(owner.getViewThreadURL(), renderRequest, renderResponse);
			
		}
		
	},
	ADD_AWNSER{

		@Override
		public final void doMode(RenderRequest renderRequest,
				RenderResponse renderResponse, ModeOwner owner) throws IOException, PortletException,
				SystemException, PortalException {
			
			setup(renderRequest,renderResponse,owner);
			
			ActionRequest action = owner.getCurrentAction();
			Log log = LogFactoryUtil.getLog(ADD_AWNSER.getClass());
			log.info("owner: " + owner);
			owner.saveNewThread("Awnser to thread", owner.getUnusedURL() + "?docreate=true", Long.parseLong(action
					.getParameter(THREAD_ID_PARAMETER_NAME).toString()));

			Mode.VIEW_THREAD.doMode(renderRequest, renderResponse, owner);
			
		}
		
		
	},
	CHANGE_PAGE{

		@Override
		public void doMode(RenderRequest renderRequest,
				RenderResponse renderResponse, ModeOwner owner)
				throws IOException, PortletException, SystemException,
				PortalException {
			
			ActionRequest action = owner.getCurrentAction();
			
			final String page=action.getParameter(PAGE_NUMBER_FORM_PARAMETER_NAME).toString();
			final int currentPage=Integer.parseInt(action.getParameter(CURRENT_PAGE_NUMBER_FORM_PARAMETER_NAME).toString());
			final int lastPage=Integer.parseInt(action.getParameter(LAST_PAGE_NUMBER_FORM_PARAMETER_NAME).toString());
			
			if (page.equals(FIRST_PAGE_BUTTON_TEXT)){
				owner.setPageNumber(1);
			} else
			if (page.equals(PREVIOUS_PAGE_BUTTON_TEXT)){
				owner.setPageNumber(currentPage-1);
			} else
			if (page.equals(NEXT_PAGE_BUTTON_TEXT)){
				owner.setPageNumber(currentPage+1);
			} else
			if (page.equals(LAST_PAGE_BUTTON_TEXT)){
				owner.setPageNumber(lastPage);
			} else{
				owner.setPageNumber(Integer.parseInt(page));
			}
			
			
			Mode.DEFAULT.doMode(renderRequest, renderResponse, owner);
		}
		
	}
	;
	
	
	public static final String URL_FORM_PARAMETER_NAME = "url";
	public static final String TITLE_FORM_PARAMETER_NAME = "title";
	public static final String PAGE_NUMBER_FORM_PARAMETER_NAME = "pageNumber";
	public static final String CURRENT_PAGE_NUMBER_FORM_PARAMETER_NAME = "page";
	public static final String LAST_PAGE_NUMBER_FORM_PARAMETER_NAME = "lastPage";
	
	public static final String CURRENT_USER_ID_PARAMETER_NAME="currentUserId";
	
	public static final String RETURN_ACTION_PARAMTER_NAME = "returnAction";
	public static final String VIEW_THREAD_URL_OARAMETER_NAME = "viewThreadURL";
	public static final String PAGE_END_PARAMETER_NAME = "pageEnd";
	public static final String PAGE_START_PARAMETER_NAME = "pageStart";
	public static final String CREATE_THREAD_URL_PARAMETER_NAME = "createThreadURL";
	public static final String AWNSER_ACTION_URL_PARAMETER_NAME = "awnserActionUrl";
	public static final String THREAD_ID_PARAMETER_NAME = "threadId";
	public static final String MESSAGE_PARAMETER_NAME = "message";
	public static final String SUBMIT_THREAD_URL_PARAMETER_NAME = "submitThreadURL";
	public static final String PAD_URL_PARAMETER_NAME = "padURL";
	public static final String CHANGE_PAGE_NUMBER_URL_PARAMETER_NAME = "pageURL";
	public static final String USER_TIME_ZONE_OFFSET_PARAM_NAME="userTime";
	public static final String SERVER_TIME_ZONE_OFFSET_PARAM_NAME="serverTime";
	
	public static final String ACTION = "action";
	public static final String CREATE_NEW_THREAD_ACTION = "createThread";
	public static final String SUBMIT_NEW_THREAD_ACTION = "submitThread";
	public static final String VIEW_THREAD_ACTION = "viewThread";
	public static final String RETURN_THREAD_ACTION = "return";
	public static final String ADD_AWNSER_TO_THREAD_ACTION = "addAwnser";
	public static final String CHANGE_PAGE_NUMBER_ACTION = "changePage";
	
	
	public static final String VIEW_TAB_PARAMETER_NAME="tab";
	public static final String VIEW_QUESTION_ACTION = "viewQuestion";
	public static final String VIEW_QUESTION_URL_PARAMETER_NAME="viewQuestionUrl";
	public static final String VIEW_AWNSERS_ACTION = "viewAwnsers";
	public static final String VIEW_AWNSERS_URL_PARAMETER_NAME="viewAwnsersUrl";
	public static final String VIEW_MY_AWNSERS_ACTION = "viewMyAwnser";
	public static final String VIEW_MY_AWNSERS_URL_PARAMETER_NAME="viewMyAwnserUrl";
	
	public static final String FIRST_PAGE_BUTTON_TEXT="<<";
	public static final String PREVIOUS_PAGE_BUTTON_TEXT="<";
	public static final String NEXT_PAGE_BUTTON_TEXT=">";
	public static final String LAST_PAGE_BUTTON_TEXT=">>";
	
	public abstract void doMode(RenderRequest renderRequest,
	RenderResponse renderResponse,ModeOwner owner) throws IOException,
	PortletException, SystemException,
	PortalException;
	
	private static final void setup(RenderRequest renderRequest,
			RenderResponse renderResponse,ModeOwner owner) throws IOException,
			PortletException, SystemException,
			PortalException{
		
		renderRequest.setAttribute(MESSAGE_PARAMETER_NAME, "");

		PortletURL returnAction = renderResponse.createActionURL();
		returnAction.setParameter(ACTION, RETURN_THREAD_ACTION);
		renderRequest.setAttribute(RETURN_ACTION_PARAMTER_NAME, returnAction.toString());
		
		
		renderRequest.setAttribute(USER_TIME_ZONE_OFFSET_PARAM_NAME, ((Integer) owner.getUserTimeOffset())
				.toString());
		renderRequest.setAttribute(SERVER_TIME_ZONE_OFFSET_PARAM_NAME, ((Integer) owner.getServerTimeOffset())
				.toString());
		
		renderRequest.setAttribute(CURRENT_USER_ID_PARAMETER_NAME, ((Long) owner.getCurrentUserId())
				.toString());
	}
	
	public static final Mode getMode(ModeOwner owner){
		
		String action = owner.getCurrentAction().getParameter(ACTION);
		
		System.out.println("action: " + action);
		
		if (action.equals(CREATE_NEW_THREAD_ACTION)) {
			return Mode.CREATE_NEW_THREAD;
		} else if (action.equals(SUBMIT_NEW_THREAD_ACTION)) {
			return Mode.SUBMIT_NEW_THREAD;
		} else if (action.equals(VIEW_THREAD_ACTION)) {
			return Mode.VIEW_THREAD;
		} else if (action.equals(RETURN_THREAD_ACTION)) {
			return Mode.DEFAULT;
		} else if (action.equals(ADD_AWNSER_TO_THREAD_ACTION)) {
			return Mode.ADD_AWNSER;
		} else if (action.equals(CHANGE_PAGE_NUMBER_ACTION)){
			return Mode.CHANGE_PAGE;
		}
		
		return Mode.DEFAULT;
	}

}
