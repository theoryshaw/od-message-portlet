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

package com.openingdesign.qna.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.openingdesign.qna.model.QueryAndResponse;
import com.openingdesign.qna.model.QueryAndResponseModel;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.Date;

/**
 * The base model implementation for the QueryAndResponse service. Represents a row in the &quot;OD_QueryAndResponse&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.openingdesign.qna.model.QueryAndResponseModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link QueryAndResponseImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this class directly. All methods that expect a query and response model instance should use the {@link com.openingdesign.qna.model.QueryAndResponse} interface instead.
 * </p>
 *
 * @author Alacrity Pty (Ltd)
 * @see QueryAndResponseImpl
 * @see com.openingdesign.qna.model.QueryAndResponse
 * @see com.openingdesign.qna.model.QueryAndResponseModel
 * @generated
 */
public class QueryAndResponseModelImpl extends BaseModelImpl<QueryAndResponse>
	implements QueryAndResponseModel {
	public static final String TABLE_NAME = "OD_QueryAndResponse";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", new Integer(Types.VARCHAR) },
			{ "queryId", new Integer(Types.BIGINT) },
			{ "parentId", new Integer(Types.BIGINT) },
			{ "title", new Integer(Types.VARCHAR) },
			{ "url", new Integer(Types.VARCHAR) },
			{ "createdAt", new Integer(Types.TIMESTAMP) },
			{ "companyId", new Integer(Types.BIGINT) },
			{ "groupId", new Integer(Types.BIGINT) },
			{ "userId", new Integer(Types.BIGINT) }
		};
	public static final String TABLE_SQL_CREATE = "create table OD_QueryAndResponse (uuid_ VARCHAR(75) null,queryId LONG not null primary key,parentId LONG,title VARCHAR(1000) null,url VARCHAR(1000) null,createdAt DATE null,companyId LONG,groupId LONG,userId LONG)";
	public static final String TABLE_SQL_DROP = "drop table OD_QueryAndResponse";
	public static final String ORDER_BY_JPQL = " ORDER BY queryAndResponse.createdAt DESC, queryAndResponse.queryId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY OD_QueryAndResponse.createdAt DESC, OD_QueryAndResponse.queryId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.openingdesign.qna.model.QueryAndResponse"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.openingdesign.qna.model.QueryAndResponse"),
			true);
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.openingdesign.qna.model.QueryAndResponse"));

	public QueryAndResponseModelImpl() {
	}

	public long getPrimaryKey() {
		return _queryId;
	}

	public void setPrimaryKey(long pk) {
		setQueryId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_queryId);
	}

	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	public long getQueryId() {
		return _queryId;
	}

	public void setQueryId(long queryId) {
		_queryId = queryId;
	}

	public long getParentId() {
		return _parentId;
	}

	public void setParentId(long parentId) {
		_parentId = parentId;
	}

	public String getTitle() {
		if (_title == null) {
			return StringPool.BLANK;
		}
		else {
			return _title;
		}
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getUrl() {
		if (_url == null) {
			return StringPool.BLANK;
		}
		else {
			return _url;
		}
	}

	public void setUrl(String url) {
		_url = url;
	}

	public Date getCreatedAt() {
		return _createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		_createdAt = createdAt;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public QueryAndResponse toEscapedModel() {
		if (isEscapedModel()) {
			return (QueryAndResponse)this;
		}
		else {
			return (QueryAndResponse)Proxy.newProxyInstance(QueryAndResponse.class.getClassLoader(),
				new Class[] { QueryAndResponse.class },
				new AutoEscapeBeanHandler(this));
		}
	}

	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
					QueryAndResponse.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	public Object clone() {
		QueryAndResponseImpl queryAndResponseImpl = new QueryAndResponseImpl();

		queryAndResponseImpl.setUuid(getUuid());

		QueryAndResponseModelImpl queryAndResponseModelImpl = queryAndResponseImpl;

		queryAndResponseModelImpl._originalUuid = queryAndResponseModelImpl._uuid;

		queryAndResponseImpl.setQueryId(getQueryId());

		queryAndResponseImpl.setParentId(getParentId());

		queryAndResponseImpl.setTitle(getTitle());

		queryAndResponseImpl.setUrl(getUrl());

		queryAndResponseImpl.setCreatedAt(getCreatedAt());

		queryAndResponseImpl.setCompanyId(getCompanyId());

		queryAndResponseImpl.setGroupId(getGroupId());

		queryAndResponseModelImpl._originalGroupId = queryAndResponseModelImpl._groupId;

		queryAndResponseModelImpl._setOriginalGroupId = false;
		queryAndResponseImpl.setUserId(getUserId());

		return queryAndResponseImpl;
	}

	public int compareTo(QueryAndResponse queryAndResponse) {
		int value = 0;

		value = DateUtil.compareTo(getCreatedAt(),
				queryAndResponse.getCreatedAt());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		if (getQueryId() < queryAndResponse.getQueryId()) {
			value = -1;
		}
		else if (getQueryId() > queryAndResponse.getQueryId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		QueryAndResponse queryAndResponse = null;

		try {
			queryAndResponse = (QueryAndResponse)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = queryAndResponse.getPrimaryKey();

		if (getPrimaryKey() == pk) {
			return true;
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return (int)getPrimaryKey();
	}

	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", queryId=");
		sb.append(getQueryId());
		sb.append(", parentId=");
		sb.append(getParentId());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", url=");
		sb.append(getUrl());
		sb.append(", createdAt=");
		sb.append(getCreatedAt());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.openingdesign.qna.model.QueryAndResponse");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>queryId</column-name><column-value><![CDATA[");
		sb.append(getQueryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentId</column-name><column-value><![CDATA[");
		sb.append(getParentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>url</column-name><column-value><![CDATA[");
		sb.append(getUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdAt</column-name><column-value><![CDATA[");
		sb.append(getCreatedAt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private String _originalUuid;
	private long _queryId;
	private long _parentId;
	private String _title;
	private String _url;
	private Date _createdAt;
	private long _companyId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _userId;
	private String _userUuid;
	private transient ExpandoBridge _expandoBridge;
}