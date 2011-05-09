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

package com.alacrity.openingdesign.messageportlet.model.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author Henricor
 */
public class SKQuestionClp extends BaseModelImpl<SKQuestion>
	implements SKQuestion {
	public SKQuestionClp() {
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
		return _Title;
	}

	public void setTitle(String Title) {
		_Title = Title;
	}

	public String getUrl() {
		return _Url;
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

	public java.lang.String getEtherpadId() {
		throw new UnsupportedOperationException();
	}

	public java.net.URL getHtmlExportURL() {
		throw new UnsupportedOperationException();
	}

	public java.net.URL getHistoryUrl() {
		throw new UnsupportedOperationException();
	}

	public java.lang.String getHtmlRepresentation() {
		throw new UnsupportedOperationException();
	}

	public SKQuestion toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (SKQuestion)Proxy.newProxyInstance(SKQuestion.class.getClassLoader(),
				new Class[] { SKQuestion.class },
				new AutoEscapeBeanHandler(this));
		}
	}

	public Object clone() {
		SKQuestionClp clone = new SKQuestionClp();

		clone.setQuestion_ID(getQuestion_ID());
		clone.setParent_ID(getParent_ID());
		clone.setTitle(getTitle());
		clone.setUrl(getUrl());
		clone.setPost_Date(getPost_Date());
		clone.setUser_ID(getUser_ID());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());

		return clone;
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

		SKQuestionClp skQuestion = null;

		try {
			skQuestion = (SKQuestionClp)obj;
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
}