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

package com.openingdesign.qna.service.persistence;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.portlet.asset.service.persistence.AssetEntryPersistence;
import com.liferay.portlet.social.service.persistence.SocialActivityPersistence;

import com.openingdesign.qna.NoSuchQueryAndResponseException;
import com.openingdesign.qna.model.QueryAndResponse;
import com.openingdesign.qna.model.impl.QueryAndResponseImpl;
import com.openingdesign.qna.model.impl.QueryAndResponseModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the query and response service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link QueryAndResponseUtil} to access the query and response persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Alacrity Pty (Ltd)
 * @see QueryAndResponsePersistence
 * @see QueryAndResponseUtil
 * @generated
 */
public class QueryAndResponsePersistenceImpl extends BasePersistenceImpl<QueryAndResponse>
	implements QueryAndResponsePersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = QueryAndResponseImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_UUID = new FinderPath(QueryAndResponseModelImpl.ENTITY_CACHE_ENABLED,
			QueryAndResponseModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByUuid",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(QueryAndResponseModelImpl.ENTITY_CACHE_ENABLED,
			QueryAndResponseModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByUuid",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(QueryAndResponseModelImpl.ENTITY_CACHE_ENABLED,
			QueryAndResponseModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(QueryAndResponseModelImpl.ENTITY_CACHE_ENABLED,
			QueryAndResponseModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ALL = new FinderPath(QueryAndResponseModelImpl.ENTITY_CACHE_ENABLED,
			QueryAndResponseModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByAll",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ALL = new FinderPath(QueryAndResponseModelImpl.ENTITY_CACHE_ENABLED,
			QueryAndResponseModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByAll",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_FINDBYURL = new FinderPath(QueryAndResponseModelImpl.ENTITY_CACHE_ENABLED,
			QueryAndResponseModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByfindByURL",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_FINDBYURL = new FinderPath(QueryAndResponseModelImpl.ENTITY_CACHE_ENABLED,
			QueryAndResponseModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByfindByURL",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(QueryAndResponseModelImpl.ENTITY_CACHE_ENABLED,
			QueryAndResponseModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(QueryAndResponseModelImpl.ENTITY_CACHE_ENABLED,
			QueryAndResponseModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	/**
	 * Caches the query and response in the entity cache if it is enabled.
	 *
	 * @param queryAndResponse the query and response to cache
	 */
	public void cacheResult(QueryAndResponse queryAndResponse) {
		EntityCacheUtil.putResult(QueryAndResponseModelImpl.ENTITY_CACHE_ENABLED,
			QueryAndResponseImpl.class, queryAndResponse.getPrimaryKey(),
			queryAndResponse);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] {
				queryAndResponse.getUuid(),
				new Long(queryAndResponse.getGroupId())
			}, queryAndResponse);
	}

	/**
	 * Caches the query and responses in the entity cache if it is enabled.
	 *
	 * @param queryAndResponses the query and responses to cache
	 */
	public void cacheResult(List<QueryAndResponse> queryAndResponses) {
		for (QueryAndResponse queryAndResponse : queryAndResponses) {
			if (EntityCacheUtil.getResult(
						QueryAndResponseModelImpl.ENTITY_CACHE_ENABLED,
						QueryAndResponseImpl.class,
						queryAndResponse.getPrimaryKey(), this) == null) {
				cacheResult(queryAndResponse);
			}
		}
	}

	/**
	 * Clears the cache for all query and responses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(QueryAndResponseImpl.class.getName());
		EntityCacheUtil.clearCache(QueryAndResponseImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the query and response.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(QueryAndResponse queryAndResponse) {
		EntityCacheUtil.removeResult(QueryAndResponseModelImpl.ENTITY_CACHE_ENABLED,
			QueryAndResponseImpl.class, queryAndResponse.getPrimaryKey());

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] {
				queryAndResponse.getUuid(),
				new Long(queryAndResponse.getGroupId())
			});
	}

	/**
	 * Creates a new query and response with the primary key. Does not add the query and response to the database.
	 *
	 * @param queryId the primary key for the new query and response
	 * @return the new query and response
	 */
	public QueryAndResponse create(long queryId) {
		QueryAndResponse queryAndResponse = new QueryAndResponseImpl();

		queryAndResponse.setNew(true);
		queryAndResponse.setPrimaryKey(queryId);

		String uuid = PortalUUIDUtil.generate();

		queryAndResponse.setUuid(uuid);

		return queryAndResponse;
	}

	/**
	 * Removes the query and response with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the query and response to remove
	 * @return the query and response that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a query and response with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public QueryAndResponse remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the query and response with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param queryId the primary key of the query and response to remove
	 * @return the query and response that was removed
	 * @throws com.openingdesign.qna.NoSuchQueryAndResponseException if a query and response with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public QueryAndResponse remove(long queryId)
		throws NoSuchQueryAndResponseException, SystemException {
		Session session = null;

		try {
			session = openSession();

			QueryAndResponse queryAndResponse = (QueryAndResponse)session.get(QueryAndResponseImpl.class,
					new Long(queryId));

			if (queryAndResponse == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + queryId);
				}

				throw new NoSuchQueryAndResponseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					queryId);
			}

			return remove(queryAndResponse);
		}
		catch (NoSuchQueryAndResponseException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected QueryAndResponse removeImpl(QueryAndResponse queryAndResponse)
		throws SystemException {
		queryAndResponse = toUnwrappedModel(queryAndResponse);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, queryAndResponse);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		QueryAndResponseModelImpl queryAndResponseModelImpl = (QueryAndResponseModelImpl)queryAndResponse;

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] {
				queryAndResponseModelImpl.getUuid(),
				new Long(queryAndResponseModelImpl.getGroupId())
			});

		EntityCacheUtil.removeResult(QueryAndResponseModelImpl.ENTITY_CACHE_ENABLED,
			QueryAndResponseImpl.class, queryAndResponse.getPrimaryKey());

		return queryAndResponse;
	}

	public QueryAndResponse updateImpl(
		com.openingdesign.qna.model.QueryAndResponse queryAndResponse,
		boolean merge) throws SystemException {
		queryAndResponse = toUnwrappedModel(queryAndResponse);

		boolean isNew = queryAndResponse.isNew();

		QueryAndResponseModelImpl queryAndResponseModelImpl = (QueryAndResponseModelImpl)queryAndResponse;

		if (Validator.isNull(queryAndResponse.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			queryAndResponse.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, queryAndResponse, merge);

			queryAndResponse.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(QueryAndResponseModelImpl.ENTITY_CACHE_ENABLED,
			QueryAndResponseImpl.class, queryAndResponse.getPrimaryKey(),
			queryAndResponse);

		if (!isNew &&
				(!Validator.equals(queryAndResponse.getUuid(),
					queryAndResponseModelImpl.getOriginalUuid()) ||
				(queryAndResponse.getGroupId() != queryAndResponseModelImpl.getOriginalGroupId()))) {
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
				new Object[] {
					queryAndResponseModelImpl.getOriginalUuid(),
					new Long(queryAndResponseModelImpl.getOriginalGroupId())
				});
		}

		if (isNew ||
				(!Validator.equals(queryAndResponse.getUuid(),
					queryAndResponseModelImpl.getOriginalUuid()) ||
				(queryAndResponse.getGroupId() != queryAndResponseModelImpl.getOriginalGroupId()))) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
				new Object[] {
					queryAndResponse.getUuid(),
					new Long(queryAndResponse.getGroupId())
				}, queryAndResponse);
		}

		return queryAndResponse;
	}

	protected QueryAndResponse toUnwrappedModel(
		QueryAndResponse queryAndResponse) {
		if (queryAndResponse instanceof QueryAndResponseImpl) {
			return queryAndResponse;
		}

		QueryAndResponseImpl queryAndResponseImpl = new QueryAndResponseImpl();

		queryAndResponseImpl.setNew(queryAndResponse.isNew());
		queryAndResponseImpl.setPrimaryKey(queryAndResponse.getPrimaryKey());

		queryAndResponseImpl.setUuid(queryAndResponse.getUuid());
		queryAndResponseImpl.setQueryId(queryAndResponse.getQueryId());
		queryAndResponseImpl.setParentId(queryAndResponse.getParentId());
		queryAndResponseImpl.setTitle(queryAndResponse.getTitle());
		queryAndResponseImpl.setUrl(queryAndResponse.getUrl());
		queryAndResponseImpl.setCreatedAt(queryAndResponse.getCreatedAt());
		queryAndResponseImpl.setCompanyId(queryAndResponse.getCompanyId());
		queryAndResponseImpl.setGroupId(queryAndResponse.getGroupId());
		queryAndResponseImpl.setUserId(queryAndResponse.getUserId());

		return queryAndResponseImpl;
	}

	/**
	 * Finds the query and response with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the query and response to find
	 * @return the query and response
	 * @throws com.liferay.portal.NoSuchModelException if a query and response with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public QueryAndResponse findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the query and response with the primary key or throws a {@link com.openingdesign.qna.NoSuchQueryAndResponseException} if it could not be found.
	 *
	 * @param queryId the primary key of the query and response to find
	 * @return the query and response
	 * @throws com.openingdesign.qna.NoSuchQueryAndResponseException if a query and response with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public QueryAndResponse findByPrimaryKey(long queryId)
		throws NoSuchQueryAndResponseException, SystemException {
		QueryAndResponse queryAndResponse = fetchByPrimaryKey(queryId);

		if (queryAndResponse == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + queryId);
			}

			throw new NoSuchQueryAndResponseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				queryId);
		}

		return queryAndResponse;
	}

	/**
	 * Finds the query and response with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the query and response to find
	 * @return the query and response, or <code>null</code> if a query and response with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public QueryAndResponse fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the query and response with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param queryId the primary key of the query and response to find
	 * @return the query and response, or <code>null</code> if a query and response with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public QueryAndResponse fetchByPrimaryKey(long queryId)
		throws SystemException {
		QueryAndResponse queryAndResponse = (QueryAndResponse)EntityCacheUtil.getResult(QueryAndResponseModelImpl.ENTITY_CACHE_ENABLED,
				QueryAndResponseImpl.class, queryId, this);

		if (queryAndResponse == null) {
			Session session = null;

			try {
				session = openSession();

				queryAndResponse = (QueryAndResponse)session.get(QueryAndResponseImpl.class,
						new Long(queryId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (queryAndResponse != null) {
					cacheResult(queryAndResponse);
				}

				closeSession(session);
			}
		}

		return queryAndResponse;
	}

	/**
	 * Finds all the query and responses where uuid = &#63;.
	 *
	 * @param uuid the uuid to search with
	 * @return the matching query and responses
	 * @throws SystemException if a system exception occurred
	 */
	public List<QueryAndResponse> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the query and responses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid to search with
	 * @param start the lower bound of the range of query and responses to return
	 * @param end the upper bound of the range of query and responses to return (not inclusive)
	 * @return the range of matching query and responses
	 * @throws SystemException if a system exception occurred
	 */
	public List<QueryAndResponse> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Finds an ordered range of all the query and responses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid to search with
	 * @param start the lower bound of the range of query and responses to return
	 * @param end the upper bound of the range of query and responses to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching query and responses
	 * @throws SystemException if a system exception occurred
	 */
	public List<QueryAndResponse> findByUuid(String uuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				uuid,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<QueryAndResponse> list = (List<QueryAndResponse>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_UUID,
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

			query.append(_SQL_SELECT_QUERYANDRESPONSE_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_UUID_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(QueryAndResponseModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				list = (List<QueryAndResponse>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_UUID,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_UUID,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first query and response in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching query and response
	 * @throws com.openingdesign.qna.NoSuchQueryAndResponseException if a matching query and response could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public QueryAndResponse findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchQueryAndResponseException, SystemException {
		List<QueryAndResponse> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchQueryAndResponseException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last query and response in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching query and response
	 * @throws com.openingdesign.qna.NoSuchQueryAndResponseException if a matching query and response could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public QueryAndResponse findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchQueryAndResponseException, SystemException {
		int count = countByUuid(uuid);

		List<QueryAndResponse> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchQueryAndResponseException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the query and responses before and after the current query and response in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param queryId the primary key of the current query and response
	 * @param uuid the uuid to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next query and response
	 * @throws com.openingdesign.qna.NoSuchQueryAndResponseException if a query and response with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public QueryAndResponse[] findByUuid_PrevAndNext(long queryId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchQueryAndResponseException, SystemException {
		QueryAndResponse queryAndResponse = findByPrimaryKey(queryId);

		Session session = null;

		try {
			session = openSession();

			QueryAndResponse[] array = new QueryAndResponseImpl[3];

			array[0] = getByUuid_PrevAndNext(session, queryAndResponse, uuid,
					orderByComparator, true);

			array[1] = queryAndResponse;

			array[2] = getByUuid_PrevAndNext(session, queryAndResponse, uuid,
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

	protected QueryAndResponse getByUuid_PrevAndNext(Session session,
		QueryAndResponse queryAndResponse, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_QUERYANDRESPONSE_WHERE);

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else {
			if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				query.append(_FINDER_COLUMN_UUID_UUID_2);
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
			query.append(QueryAndResponseModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (uuid != null) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(queryAndResponse);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<QueryAndResponse> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds the query and response where uuid = &#63; and groupId = &#63; or throws a {@link com.openingdesign.qna.NoSuchQueryAndResponseException} if it could not be found.
	 *
	 * @param uuid the uuid to search with
	 * @param groupId the group id to search with
	 * @return the matching query and response
	 * @throws com.openingdesign.qna.NoSuchQueryAndResponseException if a matching query and response could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public QueryAndResponse findByUUID_G(String uuid, long groupId)
		throws NoSuchQueryAndResponseException, SystemException {
		QueryAndResponse queryAndResponse = fetchByUUID_G(uuid, groupId);

		if (queryAndResponse == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchQueryAndResponseException(msg.toString());
		}

		return queryAndResponse;
	}

	/**
	 * Finds the query and response where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid to search with
	 * @param groupId the group id to search with
	 * @return the matching query and response, or <code>null</code> if a matching query and response could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public QueryAndResponse fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Finds the query and response where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid to search with
	 * @param groupId the group id to search with
	 * @return the matching query and response, or <code>null</code> if a matching query and response could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public QueryAndResponse fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_QUERYANDRESPONSE_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_G_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_G_UUID_2);
				}
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			query.append(QueryAndResponseModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<QueryAndResponse> list = q.list();

				result = list;

				QueryAndResponse queryAndResponse = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					queryAndResponse = list.get(0);

					cacheResult(queryAndResponse);

					if ((queryAndResponse.getUuid() == null) ||
							!queryAndResponse.getUuid().equals(uuid) ||
							(queryAndResponse.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, queryAndResponse);
					}
				}

				return queryAndResponse;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (QueryAndResponse)result;
			}
		}
	}

	/**
	 * Finds all the query and responses where parentId = &#63;.
	 *
	 * @param parentId the parent id to search with
	 * @return the matching query and responses
	 * @throws SystemException if a system exception occurred
	 */
	public List<QueryAndResponse> findByAll(long parentId)
		throws SystemException {
		return findByAll(parentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the query and responses where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentId the parent id to search with
	 * @param start the lower bound of the range of query and responses to return
	 * @param end the upper bound of the range of query and responses to return (not inclusive)
	 * @return the range of matching query and responses
	 * @throws SystemException if a system exception occurred
	 */
	public List<QueryAndResponse> findByAll(long parentId, int start, int end)
		throws SystemException {
		return findByAll(parentId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the query and responses where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentId the parent id to search with
	 * @param start the lower bound of the range of query and responses to return
	 * @param end the upper bound of the range of query and responses to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching query and responses
	 * @throws SystemException if a system exception occurred
	 */
	public List<QueryAndResponse> findByAll(long parentId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				parentId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<QueryAndResponse> list = (List<QueryAndResponse>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ALL,
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

			query.append(_SQL_SELECT_QUERYANDRESPONSE_WHERE);

			query.append(_FINDER_COLUMN_ALL_PARENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(QueryAndResponseModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentId);

				list = (List<QueryAndResponse>)QueryUtil.list(q, getDialect(),
						start, end);
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
	 * Finds the first query and response in the ordered set where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentId the parent id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching query and response
	 * @throws com.openingdesign.qna.NoSuchQueryAndResponseException if a matching query and response could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public QueryAndResponse findByAll_First(long parentId,
		OrderByComparator orderByComparator)
		throws NoSuchQueryAndResponseException, SystemException {
		List<QueryAndResponse> list = findByAll(parentId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("parentId=");
			msg.append(parentId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchQueryAndResponseException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last query and response in the ordered set where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentId the parent id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching query and response
	 * @throws com.openingdesign.qna.NoSuchQueryAndResponseException if a matching query and response could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public QueryAndResponse findByAll_Last(long parentId,
		OrderByComparator orderByComparator)
		throws NoSuchQueryAndResponseException, SystemException {
		int count = countByAll(parentId);

		List<QueryAndResponse> list = findByAll(parentId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("parentId=");
			msg.append(parentId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchQueryAndResponseException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the query and responses before and after the current query and response in the ordered set where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param queryId the primary key of the current query and response
	 * @param parentId the parent id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next query and response
	 * @throws com.openingdesign.qna.NoSuchQueryAndResponseException if a query and response with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public QueryAndResponse[] findByAll_PrevAndNext(long queryId,
		long parentId, OrderByComparator orderByComparator)
		throws NoSuchQueryAndResponseException, SystemException {
		QueryAndResponse queryAndResponse = findByPrimaryKey(queryId);

		Session session = null;

		try {
			session = openSession();

			QueryAndResponse[] array = new QueryAndResponseImpl[3];

			array[0] = getByAll_PrevAndNext(session, queryAndResponse,
					parentId, orderByComparator, true);

			array[1] = queryAndResponse;

			array[2] = getByAll_PrevAndNext(session, queryAndResponse,
					parentId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected QueryAndResponse getByAll_PrevAndNext(Session session,
		QueryAndResponse queryAndResponse, long parentId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_QUERYANDRESPONSE_WHERE);

		query.append(_FINDER_COLUMN_ALL_PARENTID_2);

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
			query.append(QueryAndResponseModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(queryAndResponse);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<QueryAndResponse> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the query and responses where url = &#63;.
	 *
	 * @param url the url to search with
	 * @return the matching query and responses
	 * @throws SystemException if a system exception occurred
	 */
	public List<QueryAndResponse> findByfindByURL(String url)
		throws SystemException {
		return findByfindByURL(url, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the query and responses where url = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param url the url to search with
	 * @param start the lower bound of the range of query and responses to return
	 * @param end the upper bound of the range of query and responses to return (not inclusive)
	 * @return the range of matching query and responses
	 * @throws SystemException if a system exception occurred
	 */
	public List<QueryAndResponse> findByfindByURL(String url, int start, int end)
		throws SystemException {
		return findByfindByURL(url, start, end, null);
	}

	/**
	 * Finds an ordered range of all the query and responses where url = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param url the url to search with
	 * @param start the lower bound of the range of query and responses to return
	 * @param end the upper bound of the range of query and responses to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching query and responses
	 * @throws SystemException if a system exception occurred
	 */
	public List<QueryAndResponse> findByfindByURL(String url, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				url,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<QueryAndResponse> list = (List<QueryAndResponse>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_FINDBYURL,
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

			query.append(_SQL_SELECT_QUERYANDRESPONSE_WHERE);

			if (url == null) {
				query.append(_FINDER_COLUMN_FINDBYURL_URL_1);
			}
			else {
				if (url.equals(StringPool.BLANK)) {
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
				query.append(QueryAndResponseModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (url != null) {
					qPos.add(url);
				}

				list = (List<QueryAndResponse>)QueryUtil.list(q, getDialect(),
						start, end);
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
	 * Finds the first query and response in the ordered set where url = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param url the url to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching query and response
	 * @throws com.openingdesign.qna.NoSuchQueryAndResponseException if a matching query and response could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public QueryAndResponse findByfindByURL_First(String url,
		OrderByComparator orderByComparator)
		throws NoSuchQueryAndResponseException, SystemException {
		List<QueryAndResponse> list = findByfindByURL(url, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("url=");
			msg.append(url);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchQueryAndResponseException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last query and response in the ordered set where url = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param url the url to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching query and response
	 * @throws com.openingdesign.qna.NoSuchQueryAndResponseException if a matching query and response could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public QueryAndResponse findByfindByURL_Last(String url,
		OrderByComparator orderByComparator)
		throws NoSuchQueryAndResponseException, SystemException {
		int count = countByfindByURL(url);

		List<QueryAndResponse> list = findByfindByURL(url, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("url=");
			msg.append(url);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchQueryAndResponseException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the query and responses before and after the current query and response in the ordered set where url = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param queryId the primary key of the current query and response
	 * @param url the url to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next query and response
	 * @throws com.openingdesign.qna.NoSuchQueryAndResponseException if a query and response with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public QueryAndResponse[] findByfindByURL_PrevAndNext(long queryId,
		String url, OrderByComparator orderByComparator)
		throws NoSuchQueryAndResponseException, SystemException {
		QueryAndResponse queryAndResponse = findByPrimaryKey(queryId);

		Session session = null;

		try {
			session = openSession();

			QueryAndResponse[] array = new QueryAndResponseImpl[3];

			array[0] = getByfindByURL_PrevAndNext(session, queryAndResponse,
					url, orderByComparator, true);

			array[1] = queryAndResponse;

			array[2] = getByfindByURL_PrevAndNext(session, queryAndResponse,
					url, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected QueryAndResponse getByfindByURL_PrevAndNext(Session session,
		QueryAndResponse queryAndResponse, String url,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_QUERYANDRESPONSE_WHERE);

		if (url == null) {
			query.append(_FINDER_COLUMN_FINDBYURL_URL_1);
		}
		else {
			if (url.equals(StringPool.BLANK)) {
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
			query.append(QueryAndResponseModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (url != null) {
			qPos.add(url);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(queryAndResponse);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<QueryAndResponse> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the query and responses.
	 *
	 * @return the query and responses
	 * @throws SystemException if a system exception occurred
	 */
	public List<QueryAndResponse> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the query and responses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of query and responses to return
	 * @param end the upper bound of the range of query and responses to return (not inclusive)
	 * @return the range of query and responses
	 * @throws SystemException if a system exception occurred
	 */
	public List<QueryAndResponse> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Finds an ordered range of all the query and responses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of query and responses to return
	 * @param end the upper bound of the range of query and responses to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of query and responses
	 * @throws SystemException if a system exception occurred
	 */
	public List<QueryAndResponse> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<QueryAndResponse> list = (List<QueryAndResponse>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_QUERYANDRESPONSE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_QUERYANDRESPONSE.concat(QueryAndResponseModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<QueryAndResponse>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<QueryAndResponse>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the query and responses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUuid(String uuid) throws SystemException {
		for (QueryAndResponse queryAndResponse : findByUuid(uuid)) {
			remove(queryAndResponse);
		}
	}

	/**
	 * Removes the query and response where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid to search with
	 * @param groupId the group id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUUID_G(String uuid, long groupId)
		throws NoSuchQueryAndResponseException, SystemException {
		QueryAndResponse queryAndResponse = findByUUID_G(uuid, groupId);

		remove(queryAndResponse);
	}

	/**
	 * Removes all the query and responses where parentId = &#63; from the database.
	 *
	 * @param parentId the parent id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByAll(long parentId) throws SystemException {
		for (QueryAndResponse queryAndResponse : findByAll(parentId)) {
			remove(queryAndResponse);
		}
	}

	/**
	 * Removes all the query and responses where url = &#63; from the database.
	 *
	 * @param url the url to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByfindByURL(String url) throws SystemException {
		for (QueryAndResponse queryAndResponse : findByfindByURL(url)) {
			remove(queryAndResponse);
		}
	}

	/**
	 * Removes all the query and responses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (QueryAndResponse queryAndResponse : findAll()) {
			remove(queryAndResponse);
		}
	}

	/**
	 * Counts all the query and responses where uuid = &#63;.
	 *
	 * @param uuid the uuid to search with
	 * @return the number of matching query and responses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUuid(String uuid) throws SystemException {
		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_QUERYANDRESPONSE_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_UUID_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the query and responses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid to search with
	 * @param groupId the group id to search with
	 * @return the number of matching query and responses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUUID_G(String uuid, long groupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID_G,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_QUERYANDRESPONSE_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_G_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_G_UUID_2);
				}
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the query and responses where parentId = &#63;.
	 *
	 * @param parentId the parent id to search with
	 * @return the number of matching query and responses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByAll(long parentId) throws SystemException {
		Object[] finderArgs = new Object[] { parentId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ALL,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_QUERYANDRESPONSE_WHERE);

			query.append(_FINDER_COLUMN_ALL_PARENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentId);

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
	 * Counts all the query and responses where url = &#63;.
	 *
	 * @param url the url to search with
	 * @return the number of matching query and responses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByfindByURL(String url) throws SystemException {
		Object[] finderArgs = new Object[] { url };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FINDBYURL,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_QUERYANDRESPONSE_WHERE);

			if (url == null) {
				query.append(_FINDER_COLUMN_FINDBYURL_URL_1);
			}
			else {
				if (url.equals(StringPool.BLANK)) {
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

				if (url != null) {
					qPos.add(url);
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
	 * Counts all the query and responses.
	 *
	 * @return the number of query and responses
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

				Query q = session.createQuery(_SQL_COUNT_QUERYANDRESPONSE);

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
	 * Initializes the query and response persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.openingdesign.qna.model.QueryAndResponse")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<QueryAndResponse>> listenersList = new ArrayList<ModelListener<QueryAndResponse>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<QueryAndResponse>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(QueryAndResponseImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST);
	}

	@BeanReference(type = QueryAndResponsePersistence.class)
	protected QueryAndResponsePersistence queryAndResponsePersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@BeanReference(type = AssetEntryPersistence.class)
	protected AssetEntryPersistence assetEntryPersistence;
	@BeanReference(type = SocialActivityPersistence.class)
	protected SocialActivityPersistence socialActivityPersistence;
	private static final String _SQL_SELECT_QUERYANDRESPONSE = "SELECT queryAndResponse FROM QueryAndResponse queryAndResponse";
	private static final String _SQL_SELECT_QUERYANDRESPONSE_WHERE = "SELECT queryAndResponse FROM QueryAndResponse queryAndResponse WHERE ";
	private static final String _SQL_COUNT_QUERYANDRESPONSE = "SELECT COUNT(queryAndResponse) FROM QueryAndResponse queryAndResponse";
	private static final String _SQL_COUNT_QUERYANDRESPONSE_WHERE = "SELECT COUNT(queryAndResponse) FROM QueryAndResponse queryAndResponse WHERE ";
	private static final String _FINDER_COLUMN_UUID_UUID_1 = "queryAndResponse.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "queryAndResponse.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(queryAndResponse.uuid IS NULL OR queryAndResponse.uuid = ?)";
	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "queryAndResponse.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "queryAndResponse.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(queryAndResponse.uuid IS NULL OR queryAndResponse.uuid = ?) AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "queryAndResponse.groupId = ?";
	private static final String _FINDER_COLUMN_ALL_PARENTID_2 = "queryAndResponse.parentId = ?";
	private static final String _FINDER_COLUMN_FINDBYURL_URL_1 = "queryAndResponse.url IS NULL";
	private static final String _FINDER_COLUMN_FINDBYURL_URL_2 = "queryAndResponse.url = ?";
	private static final String _FINDER_COLUMN_FINDBYURL_URL_3 = "(queryAndResponse.url IS NULL OR queryAndResponse.url = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "queryAndResponse.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No QueryAndResponse exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No QueryAndResponse exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(QueryAndResponsePersistenceImpl.class);
}