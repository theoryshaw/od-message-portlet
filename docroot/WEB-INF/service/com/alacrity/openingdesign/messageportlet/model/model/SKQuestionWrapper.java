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

/**
 * <p>
 * This class is a wrapper for {@link SKQuestion}.
 * </p>
 *
 * @author    Henricor
 * @see       SKQuestion
 * @generated
 */
public class SKQuestionWrapper implements SKQuestion {
	public SKQuestionWrapper(SKQuestion skQuestion) {
		_skQuestion = skQuestion;
	}

	public long getPrimaryKey() {
		return _skQuestion.getPrimaryKey();
	}

	public void setPrimaryKey(long pk) {
		_skQuestion.setPrimaryKey(pk);
	}

	public long getQuestion_ID() {
		return _skQuestion.getQuestion_ID();
	}

	public void setQuestion_ID(long Question_ID) {
		_skQuestion.setQuestion_ID(Question_ID);
	}

	public long getParent_ID() {
		return _skQuestion.getParent_ID();
	}

	public void setParent_ID(long Parent_ID) {
		_skQuestion.setParent_ID(Parent_ID);
	}

	public java.lang.String getTitle() {
		return _skQuestion.getTitle();
	}

	public void setTitle(java.lang.String Title) {
		_skQuestion.setTitle(Title);
	}

	public java.lang.String getUrl() {
		return _skQuestion.getUrl();
	}

	public void setUrl(java.lang.String Url) {
		_skQuestion.setUrl(Url);
	}

	public long getPost_Date() {
		return _skQuestion.getPost_Date();
	}

	public void setPost_Date(long Post_Date) {
		_skQuestion.setPost_Date(Post_Date);
	}

	public long getUser_ID() {
		return _skQuestion.getUser_ID();
	}

	public void setUser_ID(long User_ID) {
		_skQuestion.setUser_ID(User_ID);
	}

	public long getCompanyId() {
		return _skQuestion.getCompanyId();
	}

	public void setCompanyId(long companyId) {
		_skQuestion.setCompanyId(companyId);
	}

	public long getGroupId() {
		return _skQuestion.getGroupId();
	}

	public void setGroupId(long groupId) {
		_skQuestion.setGroupId(groupId);
	}

	public com.alacrity.openingdesign.messageportlet.model.model.SKQuestion toEscapedModel() {
		return _skQuestion.toEscapedModel();
	}

	public boolean isNew() {
		return _skQuestion.isNew();
	}

	public void setNew(boolean n) {
		_skQuestion.setNew(n);
	}

	public boolean isCachedModel() {
		return _skQuestion.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_skQuestion.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _skQuestion.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_skQuestion.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _skQuestion.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _skQuestion.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_skQuestion.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _skQuestion.clone();
	}

	public int compareTo(
		com.alacrity.openingdesign.messageportlet.model.model.SKQuestion skQuestion) {
		return _skQuestion.compareTo(skQuestion);
	}

	public int hashCode() {
		return _skQuestion.hashCode();
	}

	public java.lang.String toString() {
		return _skQuestion.toString();
	}

	public java.lang.String toXmlString() {
		return _skQuestion.toXmlString();
	}

	public SKQuestion getWrappedSKQuestion() {
		return _skQuestion;
	}

	private SKQuestion _skQuestion;
}