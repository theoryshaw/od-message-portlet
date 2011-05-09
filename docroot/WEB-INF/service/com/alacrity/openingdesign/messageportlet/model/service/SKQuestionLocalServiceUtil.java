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

package com.alacrity.openingdesign.messageportlet.model.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;

/**
 * The utility for the s k question local service. This utility wraps {@link com.alacrity.openingdesign.messageportlet.model.service.impl.SKQuestionLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * Never modify this class directly. Add custom service methods to {@link com.alacrity.openingdesign.messageportlet.model.service.impl.SKQuestionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Henricor
 * @see SKQuestionLocalService
 * @see com.alacrity.openingdesign.messageportlet.model.service.base.SKQuestionLocalServiceBaseImpl
 * @see com.alacrity.openingdesign.messageportlet.model.service.impl.SKQuestionLocalServiceImpl
 * @generated
 */
public class SKQuestionLocalServiceUtil {
	/**
	* Adds the s k question to the database. Also notifies the appropriate model listeners.
	*
	* @param skQuestion the s k question to add
	* @return the s k question that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.alacrity.openingdesign.messageportlet.model.model.SKQuestion addSKQuestion(
		com.alacrity.openingdesign.messageportlet.model.model.SKQuestion skQuestion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSKQuestion(skQuestion);
	}

	/**
	* Creates a new s k question with the primary key. Does not add the s k question to the database.
	*
	* @param Question_ID the primary key for the new s k question
	* @return the new s k question
	*/
	public static com.alacrity.openingdesign.messageportlet.model.model.SKQuestion createSKQuestion(
		long Question_ID) {
		return getService().createSKQuestion(Question_ID);
	}

	/**
	* Deletes the s k question with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param Question_ID the primary key of the s k question to delete
	* @throws PortalException if a s k question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteSKQuestion(long Question_ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteSKQuestion(Question_ID);
	}

	/**
	* Deletes the s k question from the database. Also notifies the appropriate model listeners.
	*
	* @param skQuestion the s k question to delete
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteSKQuestion(
		com.alacrity.openingdesign.messageportlet.model.model.SKQuestion skQuestion)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteSKQuestion(skQuestion);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the s k question with the primary key.
	*
	* @param Question_ID the primary key of the s k question to get
	* @return the s k question
	* @throws PortalException if a s k question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.alacrity.openingdesign.messageportlet.model.model.SKQuestion getSKQuestion(
		long Question_ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSKQuestion(Question_ID);
	}

	/**
	* Gets a range of all the s k questions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of s k questions to return
	* @param end the upper bound of the range of s k questions to return (not inclusive)
	* @return the range of s k questions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.alacrity.openingdesign.messageportlet.model.model.SKQuestion> getSKQuestions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSKQuestions(start, end);
	}

	/**
	* Gets the number of s k questions.
	*
	* @return the number of s k questions
	* @throws SystemException if a system exception occurred
	*/
	public static int getSKQuestionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSKQuestionsCount();
	}

	/**
	* Updates the s k question in the database. Also notifies the appropriate model listeners.
	*
	* @param skQuestion the s k question to update
	* @return the s k question that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.alacrity.openingdesign.messageportlet.model.model.SKQuestion updateSKQuestion(
		com.alacrity.openingdesign.messageportlet.model.model.SKQuestion skQuestion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSKQuestion(skQuestion);
	}

	/**
	* Updates the s k question in the database. Also notifies the appropriate model listeners.
	*
	* @param skQuestion the s k question to update
	* @param merge whether to merge the s k question with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the s k question that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.alacrity.openingdesign.messageportlet.model.model.SKQuestion updateSKQuestion(
		com.alacrity.openingdesign.messageportlet.model.model.SKQuestion skQuestion,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSKQuestion(skQuestion, merge);
	}

	public static com.alacrity.openingdesign.messageportlet.model.model.SKQuestion getSKQuestionByUrl(
		java.lang.String url)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSKQuestionByUrl(url);
	}

	public static com.alacrity.openingdesign.messageportlet.model.model.SKQuestion createQuestionWithParent(
		java.lang.String title, java.lang.String url, long userId,
		long parentOrZero) {
		return getService()
				   .createQuestionWithParent(title, url, userId, parentOrZero);
	}

	public static void clearService() {
		_service = null;
	}

	public static SKQuestionLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					SKQuestionLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new SKQuestionLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(SKQuestionLocalService service) {
		_service = service;
	}

	private static SKQuestionLocalService _service;
}