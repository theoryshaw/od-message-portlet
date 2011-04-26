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

import com.alacrity.openingdesign.messageportlet.model.NoSuchQuestionException;
import com.alacrity.openingdesign.messageportlet.model.model.SKQuestion;
import com.alacrity.openingdesign.messageportlet.model.model.impl.SKQuestionImpl;
import com.alacrity.openingdesign.messageportlet.model.model.impl.SKQuestionModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the s k question service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link SKQuestionUtil} to access the s k question persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Henricor
 * @see SKQuestionPersistence
 * @see SKQuestionUtil
 * @generated
 */
public class SKQuestionPersistenceImpl extends BasePersistenceImpl<SKQuestion>
	implements SKQuestionPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = SKQuestionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_ALL = new FinderPath(SKQuestionModelImpl.ENTITY_CACHE_ENABLED,
			SKQuestionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByAll",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ALL = new FinderPath(SKQuestionModelImpl.ENTITY_CACHE_ENABLED,
			SKQuestionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByAll", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_FINDBYURL = new FinderPath(SKQuestionModelImpl.ENTITY_CACHE_ENABLED,
			SKQuestionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByfindByURL",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_FINDBYURL = new FinderPath(SKQuestionModelImpl.ENTITY_CACHE_ENABLED,
			SKQuestionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByfindByURL", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(SKQuestionModelImpl.ENTITY_CACHE_ENABLED,
			SKQuestionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SKQuestionModelImpl.ENTITY_CACHE_ENABLED,
			SKQuestionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	/**
	 * Caches the s k question in the entity cache if it is enabled.
	 *
	 * @param skQuestion the s k question to cache
	 */
	public void cacheResult(SKQuestion skQuestion) {
		EntityCacheUtil.putResult(SKQuestionModelImpl.ENTITY_CACHE_ENABLED,
			SKQuestionImpl.class, skQuestion.getPrimaryKey(), skQuestion);
	}

	/**
	 * Caches the s k questions in the entity cache if it is enabled.
	 *
	 * @param skQuestions the s k questions to cache
	 */
	public void cacheResult(List<SKQuestion> skQuestions) {
		for (SKQuestion skQuestion : skQuestions) {
			if (EntityCacheUtil.getResult(
						SKQuestionModelImpl.ENTITY_CACHE_ENABLED,
						SKQuestionImpl.class, skQuestion.getPrimaryKey(), this) == null) {
				cacheResult(skQuestion);
			}
		}
	}

	/**
	 * Clears the cache for all s k questions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(SKQuestionImpl.class.getName());
		EntityCacheUtil.clearCache(SKQuestionImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the s k question.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(SKQuestion skQuestion) {
		EntityCacheUtil.removeResult(SKQuestionModelImpl.ENTITY_CACHE_ENABLED,
			SKQuestionImpl.class, skQuestion.getPrimaryKey());
	}

	/**
	 * Creates a new s k question with the primary key. Does not add the s k question to the database.
	 *
	 * @param Question_ID the primary key for the new s k question
	 * @return the new s k question
	 */
	public SKQuestion create(long Question_ID) {
		SKQuestion skQuestion = new SKQuestionImpl();

		skQuestion.setNew(true);
		skQuestion.setPrimaryKey(Question_ID);

		return skQuestion;
	}

	/**
	 * Removes the s k question with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s k question to remove
	 * @return the s k question that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a s k question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SKQuestion remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the s k question with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Question_ID the primary key of the s k question to remove
	 * @return the s k question that was removed
	 * @throws com.alacrity.openingdesign.messageportlet.model.NoSuchQuestionException if a s k question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SKQuestion remove(long Question_ID)
		throws NoSuchQuestionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SKQuestion skQuestion = (SKQuestion)session.get(SKQuestionImpl.class,
					new Long(Question_ID));

			if (skQuestion == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + Question_ID);
				}

				throw new NoSuchQuestionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					Question_ID);
			}

			return remove(skQuestion);
		}
		catch (NoSuchQuestionException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SKQuestion removeImpl(SKQuestion skQuestion)
		throws SystemException {
		skQuestion = toUnwrappedModel(skQuestion);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, skQuestion);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(SKQuestionModelImpl.ENTITY_CACHE_ENABLED,
			SKQuestionImpl.class, skQuestion.getPrimaryKey());

		return skQuestion;
	}

	public SKQuestion updateImpl(
		com.alacrity.openingdesign.messageportlet.model.model.SKQuestion skQuestion,
		boolean merge) throws SystemException {
		skQuestion = toUnwrappedModel(skQuestion);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, skQuestion, merge);

			skQuestion.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(SKQuestionModelImpl.ENTITY_CACHE_ENABLED,
			SKQuestionImpl.class, skQuestion.getPrimaryKey(), skQuestion);

		return skQuestion;
	}

	protected SKQuestion toUnwrappedModel(SKQuestion skQuestion) {
		if (skQuestion instanceof SKQuestionImpl) {
			return skQuestion;
		}

		SKQuestionImpl skQuestionImpl = new SKQuestionImpl();

		skQuestionImpl.setNew(skQuestion.isNew());
		skQuestionImpl.setPrimaryKey(skQuestion.getPrimaryKey());

		skQuestionImpl.setQuestion_ID(skQuestion.getQuestion_ID());
		skQuestionImpl.setParent_ID(skQuestion.getParent_ID());
		skQuestionImpl.setTitle(skQuestion.getTitle());
		skQuestionImpl.setUrl(skQuestion.getUrl());
		skQuestionImpl.setPost_Date(skQuestion.getPost_Date());
		skQuestionImpl.setUser_ID(skQuestion.getUser_ID());
		skQuestionImpl.setCompanyId(skQuestion.getCompanyId());
		skQuestionImpl.setGroupId(skQuestion.getGroupId());

		return skQuestionImpl;
	}

	/**
	 * Finds the s k question with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s k question to find
	 * @return the s k question
	 * @throws com.liferay.portal.NoSuchModelException if a s k question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SKQuestion findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the s k question with the primary key or throws a {@link com.alacrity.openingdesign.messageportlet.model.NoSuchQuestionException} if it could not be found.
	 *
	 * @param Question_ID the primary key of the s k question to find
	 * @return the s k question
	 * @throws com.alacrity.openingdesign.messageportlet.model.NoSuchQuestionException if a s k question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SKQuestion findByPrimaryKey(long Question_ID)
		throws NoSuchQuestionException, SystemException {
		SKQuestion skQuestion = fetchByPrimaryKey(Question_ID);

		if (skQuestion == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + Question_ID);
			}

			throw new NoSuchQuestionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				Question_ID);
		}

		return skQuestion;
	}

	/**
	 * Finds the s k question with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s k question to find
	 * @return the s k question, or <code>null</code> if a s k question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SKQuestion fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the s k question with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param Question_ID the primary key of the s k question to find
	 * @return the s k question, or <code>null</code> if a s k question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SKQuestion fetchByPrimaryKey(long Question_ID)
		throws SystemException {
		SKQuestion skQuestion = (SKQuestion)EntityCacheUtil.getResult(SKQuestionModelImpl.ENTITY_CACHE_ENABLED,
				SKQuestionImpl.class, Question_ID, this);

		if (skQuestion == null) {
			Session session = null;

			try {
				session = openSession();

				skQuestion = (SKQuestion)session.get(SKQuestionImpl.class,
						new Long(Question_ID));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (skQuestion != null) {
					cacheResult(skQuestion);
				}

				closeSession(session);
			}
		}

		return skQuestion;
	}

	/**
	 * Finds all the s k questions where Parent_ID = &#63;.
	 *
	 * @param Parent_ID the parent_ i d to search with
	 * @return the matching s k questions
	 * @throws SystemException if a system exception occurred
	 */
	public List<SKQuestion> findByAll(long Parent_ID) throws SystemException {
		return findByAll(Parent_ID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<SKQuestion> findByAll(long Parent_ID, int start, int end)
		throws SystemException {
		return findByAll(Parent_ID, start, end, null);
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
	public List<SKQuestion> findByAll(long Parent_ID, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				Parent_ID,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<SKQuestion> list = (List<SKQuestion>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SKQUESTION_WHERE);

			query.append(_FINDER_COLUMN_ALL_PARENT_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(SKQuestionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(Parent_ID);

				list = (List<SKQuestion>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_ALL,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ALL,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public SKQuestion findByAll_First(long Parent_ID,
		OrderByComparator orderByComparator)
		throws NoSuchQuestionException, SystemException {
		List<SKQuestion> list = findByAll(Parent_ID, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("Parent_ID=");
			msg.append(Parent_ID);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchQuestionException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public SKQuestion findByAll_Last(long Parent_ID,
		OrderByComparator orderByComparator)
		throws NoSuchQuestionException, SystemException {
		int count = countByAll(Parent_ID);

		List<SKQuestion> list = findByAll(Parent_ID, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("Parent_ID=");
			msg.append(Parent_ID);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchQuestionException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public SKQuestion[] findByAll_PrevAndNext(long Question_ID, long Parent_ID,
		OrderByComparator orderByComparator)
		throws NoSuchQuestionException, SystemException {
		SKQuestion skQuestion = findByPrimaryKey(Question_ID);

		Session session = null;

		try {
			session = openSession();

			SKQuestion[] array = new SKQuestionImpl[3];

			array[0] = getByAll_PrevAndNext(session, skQuestion, Parent_ID,
					orderByComparator, true);

			array[1] = skQuestion;

			array[2] = getByAll_PrevAndNext(session, skQuestion, Parent_ID,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SKQuestion getByAll_PrevAndNext(Session session,
		SKQuestion skQuestion, long Parent_ID,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SKQUESTION_WHERE);

		query.append(_FINDER_COLUMN_ALL_PARENT_ID_2);

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(SKQuestionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(Parent_ID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(skQuestion);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SKQuestion> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the s k questions where Url = &#63;.
	 *
	 * @param Url the url to search with
	 * @return the matching s k questions
	 * @throws SystemException if a system exception occurred
	 */
	public List<SKQuestion> findByfindByURL(String Url)
		throws SystemException {
		return findByfindByURL(Url, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<SKQuestion> findByfindByURL(String Url, int start, int end)
		throws SystemException {
		return findByfindByURL(Url, start, end, null);
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
	public List<SKQuestion> findByfindByURL(String Url, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				Url,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<SKQuestion> list = (List<SKQuestion>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_FINDBYURL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SKQUESTION_WHERE);

			if (Url == null) {
				query.append(_FINDER_COLUMN_FINDBYURL_URL_1);
			}
			else {
				if (Url.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_FINDBYURL_URL_3);
				}
				else {
					query.append(_FINDER_COLUMN_FINDBYURL_URL_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(SKQuestionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (Url != null) {
					qPos.add(Url);
				}

				list = (List<SKQuestion>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_FINDBYURL,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_FINDBYURL,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public SKQuestion findByfindByURL_First(String Url,
		OrderByComparator orderByComparator)
		throws NoSuchQuestionException, SystemException {
		List<SKQuestion> list = findByfindByURL(Url, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("Url=");
			msg.append(Url);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchQuestionException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public SKQuestion findByfindByURL_Last(String Url,
		OrderByComparator orderByComparator)
		throws NoSuchQuestionException, SystemException {
		int count = countByfindByURL(Url);

		List<SKQuestion> list = findByfindByURL(Url, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("Url=");
			msg.append(Url);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchQuestionException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public SKQuestion[] findByfindByURL_PrevAndNext(long Question_ID,
		String Url, OrderByComparator orderByComparator)
		throws NoSuchQuestionException, SystemException {
		SKQuestion skQuestion = findByPrimaryKey(Question_ID);

		Session session = null;

		try {
			session = openSession();

			SKQuestion[] array = new SKQuestionImpl[3];

			array[0] = getByfindByURL_PrevAndNext(session, skQuestion, Url,
					orderByComparator, true);

			array[1] = skQuestion;

			array[2] = getByfindByURL_PrevAndNext(session, skQuestion, Url,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SKQuestion getByfindByURL_PrevAndNext(Session session,
		SKQuestion skQuestion, String Url, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SKQUESTION_WHERE);

		if (Url == null) {
			query.append(_FINDER_COLUMN_FINDBYURL_URL_1);
		}
		else {
			if (Url.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FINDBYURL_URL_3);
			}
			else {
				query.append(_FINDER_COLUMN_FINDBYURL_URL_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(SKQuestionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (Url != null) {
			qPos.add(Url);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(skQuestion);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SKQuestion> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the s k questions.
	 *
	 * @return the s k questions
	 * @throws SystemException if a system exception occurred
	 */
	public List<SKQuestion> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<SKQuestion> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	public List<SKQuestion> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<SKQuestion> list = (List<SKQuestion>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SKQUESTION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SKQUESTION.concat(SKQuestionModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<SKQuestion>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<SKQuestion>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_ALL,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs,
						list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the s k questions where Parent_ID = &#63; from the database.
	 *
	 * @param Parent_ID the parent_ i d to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByAll(long Parent_ID) throws SystemException {
		for (SKQuestion skQuestion : findByAll(Parent_ID)) {
			remove(skQuestion);
		}
	}

	/**
	 * Removes all the s k questions where Url = &#63; from the database.
	 *
	 * @param Url the url to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByfindByURL(String Url) throws SystemException {
		for (SKQuestion skQuestion : findByfindByURL(Url)) {
			remove(skQuestion);
		}
	}

	/**
	 * Removes all the s k questions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (SKQuestion skQuestion : findAll()) {
			remove(skQuestion);
		}
	}

	/**
	 * Counts all the s k questions where Parent_ID = &#63;.
	 *
	 * @param Parent_ID the parent_ i d to search with
	 * @return the number of matching s k questions
	 * @throws SystemException if a system exception occurred
	 */
	public int countByAll(long Parent_ID) throws SystemException {
		Object[] finderArgs = new Object[] { Parent_ID };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ALL,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SKQUESTION_WHERE);

			query.append(_FINDER_COLUMN_ALL_PARENT_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(Parent_ID);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ALL, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the s k questions where Url = &#63;.
	 *
	 * @param Url the url to search with
	 * @return the number of matching s k questions
	 * @throws SystemException if a system exception occurred
	 */
	public int countByfindByURL(String Url) throws SystemException {
		Object[] finderArgs = new Object[] { Url };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FINDBYURL,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SKQUESTION_WHERE);

			if (Url == null) {
				query.append(_FINDER_COLUMN_FINDBYURL_URL_1);
			}
			else {
				if (Url.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_FINDBYURL_URL_3);
				}
				else {
					query.append(_FINDER_COLUMN_FINDBYURL_URL_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (Url != null) {
					qPos.add(Url);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FINDBYURL,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the s k questions.
	 *
	 * @return the number of s k questions
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SKQUESTION);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the s k question persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.alacrity.openingdesign.messageportlet.model.model.SKQuestion")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SKQuestion>> listenersList = new ArrayList<ModelListener<SKQuestion>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SKQuestion>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(SKQuestionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST);
	}

	@BeanReference(type = SKQuestionPersistence.class)
	protected SKQuestionPersistence skQuestionPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_SKQUESTION = "SELECT skQuestion FROM SKQuestion skQuestion";
	private static final String _SQL_SELECT_SKQUESTION_WHERE = "SELECT skQuestion FROM SKQuestion skQuestion WHERE ";
	private static final String _SQL_COUNT_SKQUESTION = "SELECT COUNT(skQuestion) FROM SKQuestion skQuestion";
	private static final String _SQL_COUNT_SKQUESTION_WHERE = "SELECT COUNT(skQuestion) FROM SKQuestion skQuestion WHERE ";
	private static final String _FINDER_COLUMN_ALL_PARENT_ID_2 = "skQuestion.Parent_ID = ?";
	private static final String _FINDER_COLUMN_FINDBYURL_URL_1 = "skQuestion.Url IS NULL";
	private static final String _FINDER_COLUMN_FINDBYURL_URL_2 = "skQuestion.Url = ?";
	private static final String _FINDER_COLUMN_FINDBYURL_URL_3 = "(skQuestion.Url IS NULL OR skQuestion.Url = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "skQuestion.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SKQuestion exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SKQuestion exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(SKQuestionPersistenceImpl.class);
}