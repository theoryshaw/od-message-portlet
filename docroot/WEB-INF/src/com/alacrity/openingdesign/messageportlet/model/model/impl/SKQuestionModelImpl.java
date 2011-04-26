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

package com.alacrity.openingdesign.messageportlet.model.model.impl;

import com.alacrity.openingdesign.messageportlet.model.model.SKQuestion;
import com.alacrity.openingdesign.messageportlet.model.model.SKQuestionModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

/**
 * The base model implementation for the SKQuestion service. Represents a row in the &quot;SK_SKQuestion&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.alacrity.openingdesign.messageportlet.model.model.SKQuestionModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SKQuestionImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this class directly. All methods that expect a s k question model instance should use the {@link com.alacrity.openingdesign.messageportlet.model.model.SKQuestion} interface instead.
 * </p>
 *
 * @author Henricor
 * @see SKQuestionImpl
 * @see com.alacrity.openingdesign.messageportlet.model.model.SKQuestion
 * @see com.alacrity.openingdesign.messageportlet.model.model.SKQuestionModel
 * @generated
 */
public class SKQuestionModelImpl extends BaseModelImpl<SKQuestion>
	implements SKQuestionModel {
	public static final String TABLE_NAME = "SK_SKQuestion";
	public static final Object[][] TABLE_COLUMNS = {
			{ "Question_ID", new Integer(Types.BIGINT) },
			{ "Parent_ID", new Integer(Types.BIGINT) },
			{ "Title", new Integer(Types.VARCHAR) },
			{ "Url", new Integer(Types.VARCHAR) },
			{ "Post_Date", new Integer(Types.BIGINT) },
			{ "User_ID", new Integer(Types.BIGINT) },
			{ "companyId", new Integer(Types.BIGINT) },
			{ "groupId", new Integer(Types.BIGINT) }
		};
	public static final String TABLE_SQL_CREATE = "create table SK_SKQuestion (Question_ID LONG not null primary key,Parent_ID LONG,Title VARCHAR(75) null,Url VARCHAR(75) null,Post_Date LONG,User_ID LONG,companyId LONG,groupId LONG)";
	public static final String TABLE_SQL_DROP = "drop table SK_SKQuestion";
	public static final String ORDER_BY_JPQL = " ORDER BY skQuestion.Post_Date DESC";
	public static final String ORDER_BY_SQL = " ORDER BY SK_SKQuestion.Post_Date DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.alacrity.openingdesign.messageportlet.model.model.SKQuestion"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.alacrity.openingdesign.messageportlet.model.model.SKQuestion"),
			true);
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.alacrity.openingdesign.messageportlet.model.model.SKQuestion"));

	public SKQuestionModelImpl() {
	}

	public long getPrimaryKey() {
		return _Question_ID;
	}

	public void setPrimaryKey(long pk) {
		setQuestion_ID(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_Question_ID);
	}

	public long getQuestion_ID() {
		return _Question_ID;
	}

	public void setQuestion_ID(long Question_ID) {
		_Question_ID = Question_ID;
	}

	public long getParent_ID() {
		return _Parent_ID;
	}

	public void setParent_ID(long Parent_ID) {
		_Parent_ID = Parent_ID;
	}

	public String getTitle() {
		if (_Title == null) {
			return StringPool.BLANK;
		}
		else {
			return _Title;
		}
	}

	public void setTitle(String Title) {
		_Title = Title;
	}

	public String getUrl() {
		if (_Url == null) {
			return StringPool.BLANK;
		}
		else {
			return _Url;
		}
	}

	public void setUrl(String Url) {
		_Url = Url;
	}

	public long getPost_Date() {
		return _Post_Date;
	}

	public void setPost_Date(long Post_Date) {
		_Post_Date = Post_Date;
	}

	public long getUser_ID() {
		return _User_ID;
	}

	public void setUser_ID(long User_ID) {
		_User_ID = User_ID;
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
		_groupId = groupId;
	}

	public SKQuestion toEscapedModel() {
		if (isEscapedModel()) {
			return (SKQuestion)this;
		}
		else {
			return (SKQuestion)Proxy.newProxyInstance(SKQuestion.class.getClassLoader(),
				new Class[] { SKQuestion.class },
				new AutoEscapeBeanHandler(this));
		}
	}

	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
					SKQuestion.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	public Object clone() {
		SKQuestionImpl skQuestionImpl = new SKQuestionImpl();

		skQuestionImpl.setQuestion_ID(getQuestion_ID());

		skQuestionImpl.setParent_ID(getParent_ID());

		skQuestionImpl.setTitle(getTitle());

		skQuestionImpl.setUrl(getUrl());

		skQuestionImpl.setPost_Date(getPost_Date());

		skQuestionImpl.setUser_ID(getUser_ID());

		skQuestionImpl.setCompanyId(getCompanyId());

		skQuestionImpl.setGroupId(getGroupId());

		return skQuestionImpl;
	}

	public int compareTo(SKQuestion skQuestion) {
		int value = 0;

		if (getPost_Date() < skQuestion.getPost_Date()) {
			value = -1;
		}
		else if (getPost_Date() > skQuestion.getPost_Date()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		SKQuestion skQuestion = null;

		try {
			skQuestion = (SKQuestion)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = skQuestion.getPrimaryKey();

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
		StringBundler sb = new StringBundler(17);

		sb.append("{Question_ID=");
		sb.append(getQuestion_ID());
		sb.append(", Parent_ID=");
		sb.append(getParent_ID());
		sb.append(", Title=");
		sb.append(getTitle());
		sb.append(", Url=");
		sb.append(getUrl());
		sb.append(", Post_Date=");
		sb.append(getPost_Date());
		sb.append(", User_ID=");
		sb.append(getUser_ID());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append(
			"com.alacrity.openingdesign.messageportlet.model.model.SKQuestion");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>Question_ID</column-name><column-value><![CDATA[");
		sb.append(getQuestion_ID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Parent_ID</column-name><column-value><![CDATA[");
		sb.append(getParent_ID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Url</column-name><column-value><![CDATA[");
		sb.append(getUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Post_Date</column-name><column-value><![CDATA[");
		sb.append(getPost_Date());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>User_ID</column-name><column-value><![CDATA[");
		sb.append(getUser_ID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _Question_ID;
	private long _Parent_ID;
	private String _Title;
	private String _Url;
	private long _Post_Date;
	private long _User_ID;
	private long _companyId;
	private long _groupId;
	private transient ExpandoBridge _expandoBridge;
}