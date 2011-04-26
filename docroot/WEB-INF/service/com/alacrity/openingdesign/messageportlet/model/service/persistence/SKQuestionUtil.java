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

package com.alacrity.openingdesign.messageportlet.model.service.persistence;

import com.alacrity.openingdesign.messageportlet.model.model.SKQuestion;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the s k question service. This utility wraps {@link SKQuestionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Henricor
 * @see SKQuestionPersistence
 * @see SKQuestionPersistenceImpl
 * @generated
 */
public class SKQuestionUtil {
	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(SKQuestion skQuestion) {
		getPersistence().clearCache(skQuestion);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SKQuestion> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SKQuestion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SKQuestion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static SKQuestion remove(SKQuestion skQuestion)
		throws SystemException {
		return getPersistence().remove(skQuestion);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static SKQuestion update(SKQuestion skQuestion, boolean merge)
		throws SystemException {
		return getPersistence().update(skQuestion, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static SKQuestion update(SKQuestion skQuestion, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(skQuestion, merge, serviceContext);
	}

	/**
	* Caches the s k question in the entity cache if it is enabled.
	*
	* @param skQuestion the s k question to cache
	*/
	public static void cacheResult(
		com.alacrity.openingdesign.messageportlet.model.model.SKQuestion skQuestion) {
		getPersistence().cacheResult(skQuestion);
	}

	/**
	* Caches the s k questions in the entity cache if it is enabled.
	*
	* @param skQuestions the s k questions to cache
	*/
	public static void cacheResult(
		java.util.List<com.alacrity.openingdesign.messageportlet.model.model.SKQuestion> skQuestions) {
		getPersistence().cacheResult(skQuestions);
	}

	/**
	* Creates a new s k question with the primary key. Does not add the s k question to the database.
	*
	* @param Question_ID the primary key for the new s k question
	* @return the new s k question
	*/
	public static com.alacrity.openingdesign.messageportlet.model.model.SKQuestion create(
		long Question_ID) {
		return getPersistence().create(Question_ID);
	}

	/**
	* Removes the s k question with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param Question_ID the primary key of the s k question to remove
	* @return the s k question that was removed
	* @throws com.alacrity.openingdesign.messageportlet.model.NoSuchQuestionException if a s k question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.alacrity.openingdesign.messageportlet.model.model.SKQuestion remove(
		long Question_ID)
		throws com.alacrity.openingdesign.messageportlet.model.NoSuchQuestionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(Question_ID);
	}

	public static com.alacrity.openingdesign.messageportlet.model.model.SKQuestion updateImpl(
		com.alacrity.openingdesign.messageportlet.model.model.SKQuestion skQuestion,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(skQuestion, merge);
	}

	/**
	* Finds the s k question with the primary key or throws a {@link com.alacrity.openingdesign.messageportlet.model.NoSuchQuestionException} if it could not be found.
	*
	* @param Question_ID the primary key of the s k question to find
	* @return the s k question
	* @throws com.alacrity.openingdesign.messageportlet.model.NoSuchQuestionException if a s k question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.alacrity.openingdesign.messageportlet.model.model.SKQuestion findByPrimaryKey(
		long Question_ID)
		throws com.alacrity.openingdesign.messageportlet.model.NoSuchQuestionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(Question_ID);
	}

	/**
	* Finds the s k question with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param Question_ID the primary key of the s k question to find
	* @return the s k question, or <code>null</code> if a s k question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.alacrity.openingdesign.messageportlet.model.model.SKQuestion fetchByPrimaryKey(
		long Question_ID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(Question_ID);
	}

	/**
	* Finds all the s k questions where Parent_ID = &#63;.
	*
	* @param Parent_ID the parent_ i d to search with
	* @return the matching s k questions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.alacrity.openingdesign.messageportlet.model.model.SKQuestion> findByAll(
		long Parent_ID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAll(Parent_ID);
	}

	/**
	* Finds a range of all the s k questions where Parent_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param Parent_ID the parent_ i d to search with
	* @param start the lower bound of the range of s k questions to return
	* @param end the upper bound of the range of s k questions to return (not inclusive)
	* @return the range of matching s k questions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.alacrity.openingdesign.messageportlet.model.model.SKQuestion> findByAll(
		long Parent_ID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAll(Parent_ID, start, end);
	}

	/**
	* Finds an ordered range of all the s k questions where Parent_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param Parent_ID the parent_ i d to search with
	* @param start the lower bound of the range of s k questions to return
	* @param end the upper bound of the range of s k questions to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching s k questions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.alacrity.openingdesign.messageportlet.model.model.SKQuestion> findByAll(
		long Parent_ID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAll(Parent_ID, start, end, orderByComparator);
	}

	/**
	* Finds the first s k question in the ordered set where Parent_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param Parent_ID the parent_ i d to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching s k question
	* @throws com.alacrity.openingdesign.messageportlet.model.NoSuchQuestionException if a matching s k question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.alacrity.openingdesign.messageportlet.model.model.SKQuestion findByAll_First(
		long Parent_ID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.alacrity.openingdesign.messageportlet.model.NoSuchQuestionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAll_First(Parent_ID, orderByComparator);
	}

	/**
	* Finds the last s k question in the ordered set where Parent_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param Parent_ID the parent_ i d to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching s k question
	* @throws com.alacrity.openingdesign.messageportlet.model.NoSuchQuestionException if a matching s k question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.alacrity.openingdesign.messageportlet.model.model.SKQuestion findByAll_Last(
		long Parent_ID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.alacrity.openingdesign.messageportlet.model.NoSuchQuestionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAll_Last(Parent_ID, orderByComparator);
	}

	/**
	* Finds the s k questions before and after the current s k question in the ordered set where Parent_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param Question_ID the primary key of the current s k question
	* @param Parent_ID the parent_ i d to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next s k question
	* @throws com.alacrity.openingdesign.messageportlet.model.NoSuchQuestionException if a s k question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.alacrity.openingdesign.messageportlet.model.model.SKQuestion[] findByAll_PrevAndNext(
		long Question_ID, long Parent_ID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.alacrity.openingdesign.messageportlet.model.NoSuchQuestionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAll_PrevAndNext(Question_ID, Parent_ID,
			orderByComparator);
	}

	/**
	* Finds all the s k questions where Url = &#63;.
	*
	* @param Url the url to search with
	* @return the matching s k questions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.alacrity.openingdesign.messageportlet.model.model.SKQuestion> findByfindByURL(
		java.lang.String Url)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByfindByURL(Url);
	}

	/**
	* Finds a range of all the s k questions where Url = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param Url the url to search with
	* @param start the lower bound of the range of s k questions to return
	* @param end the upper bound of the range of s k questions to return (not inclusive)
	* @return the range of matching s k questions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.alacrity.openingdesign.messageportlet.model.model.SKQuestion> findByfindByURL(
		java.lang.String Url, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByfindByURL(Url, start, end);
	}

	/**
	* Finds an ordered range of all the s k questions where Url = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param Url the url to search with
	* @param start the lower bound of the range of s k questions to return
	* @param end the upper bound of the range of s k questions to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching s k questions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.alacrity.openingdesign.messageportlet.model.model.SKQuestion> findByfindByURL(
		java.lang.String Url, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByfindByURL(Url, start, end, orderByComparator);
	}

	/**
	* Finds the first s k question in the ordered set where Url = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param Url the url to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching s k question
	* @throws com.alacrity.openingdesign.messageportlet.model.NoSuchQuestionException if a matching s k question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.alacrity.openingdesign.messageportlet.model.model.SKQuestion findByfindByURL_First(
		java.lang.String Url,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.alacrity.openingdesign.messageportlet.model.NoSuchQuestionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByfindByURL_First(Url, orderByComparator);
	}

	/**
	* Finds the last s k question in the ordered set where Url = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param Url the url to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching s k question
	* @throws com.alacrity.openingdesign.messageportlet.model.NoSuchQuestionException if a matching s k question could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.alacrity.openingdesign.messageportlet.model.model.SKQuestion findByfindByURL_Last(
		java.lang.String Url,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.alacrity.openingdesign.messageportlet.model.NoSuchQuestionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByfindByURL_Last(Url, orderByComparator);
	}

	/**
	* Finds the s k questions before and after the current s k question in the ordered set where Url = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param Question_ID the primary key of the current s k question
	* @param Url the url to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next s k question
	* @throws com.alacrity.openingdesign.messageportlet.model.NoSuchQuestionException if a s k question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.alacrity.openingdesign.messageportlet.model.model.SKQuestion[] findByfindByURL_PrevAndNext(
		long Question_ID, java.lang.String Url,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.alacrity.openingdesign.messageportlet.model.NoSuchQuestionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByfindByURL_PrevAndNext(Question_ID, Url,
			orderByComparator);
	}

	/**
	* Finds all the s k questions.
	*
	* @return the s k questions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.alacrity.openingdesign.messageportlet.model.model.SKQuestion> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Finds a range of all the s k questions.
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
	public static java.util.List<com.alacrity.openingdesign.messageportlet.model.model.SKQuestion> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Finds an ordered range of all the s k questions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of s k questions to return
	* @param end the upper bound of the range of s k questions to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of s k questions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.alacrity.openingdesign.messageportlet.model.model.SKQuestion> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the s k questions where Parent_ID = &#63; from the database.
	*
	* @param Parent_ID the parent_ i d to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAll(long Parent_ID)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByAll(Parent_ID);
	}

	/**
	* Removes all the s k questions where Url = &#63; from the database.
	*
	* @param Url the url to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByfindByURL(java.lang.String Url)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByfindByURL(Url);
	}

	/**
	* Removes all the s k questions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the s k questions where Parent_ID = &#63;.
	*
	* @param Parent_ID the parent_ i d to search with
	* @return the number of matching s k questions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAll(long Parent_ID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAll(Parent_ID);
	}

	/**
	* Counts all the s k questions where Url = &#63;.
	*
	* @param Url the url to search with
	* @return the number of matching s k questions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByfindByURL(java.lang.String Url)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByfindByURL(Url);
	}

	/**
	* Counts all the s k questions.
	*
	* @return the number of s k questions
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SKQuestionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SKQuestionPersistence)PortletBeanLocatorUtil.locate(com.alacrity.openingdesign.messageportlet.model.service.ClpSerializer.SERVLET_CONTEXT_NAME,
					SKQuestionPersistence.class.getName());
		}

		return _persistence;
	}

	public void setPersistence(SKQuestionPersistence persistence) {
		_persistence = persistence;
	}

	private static SKQuestionPersistence _persistence;
}