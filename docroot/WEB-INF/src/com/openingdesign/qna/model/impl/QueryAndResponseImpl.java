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

import java.io.IOException;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.openingdesign.qna.model.QueryAndResponse;
import com.openingdesign.qna.util.RandomPadIdGenerator;

/**
 * The model implementation for the QueryAndResponse service. Represents a row
 * in the &quot;OD_QueryAndResponse&quot; database table, with each column
 * mapped to a property of this class.
 * 
 * <p>
 * Helper methods and all application logic should be put in this class.
 * Whenever methods are added, rerun ServiceBuilder to copy their definitions
 * into the {@link com.openingdesign.qna.model.QueryAndResponse} interface.
 * </p>
 * 
 * <p>
 * Never reference this class directly. All methods that expect a query and
 * response model instance should use the {@link QueryAndResponse} interface
 * instead.
 * </p>
 */
public class QueryAndResponseImpl extends QueryAndResponseModelImpl implements
		QueryAndResponse {

	private String stringId, createdByName;

	public QueryAndResponseImpl() {
	}

	public void setQueryIdString(String stringId) {
		this.stringId = stringId;
	}

	public String getQueryIdString() {
		return stringId;
	}

	public void setCreatedByName(String s) {
		createdByName = s;
	}

	public String getCreatedByName() {
		return createdByName;
	}

	public String getEtherpadId() {
		URL url;
		try {
			url = new URL(getUrl());
			return url.getPath().replace("/", "");
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return "???";
		}
	}

	public URL getHtmlExportURL() {
		try {
			return new URL(RandomPadIdGenerator.BASE_URL + "/ep/pad/export/"
					+ getEtherpadId() + "/latest?format=html");
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}

	public URL getHistoryURL() {
		try {
			return new URL(RandomPadIdGenerator.BASE_URL + "/ep/pad/view/"
					+ getEtherpadId() + "/latest");
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}

	public String getHtmlRepresentation() {
		try {
			DefaultHttpClient client = new DefaultHttpClient();
			HttpGet get = new HttpGet(getHtmlExportURL().toString());
			HttpResponse response = client.execute(get);
			StringWriter writer = new StringWriter();
			IOUtils.copy(response.getEntity().getContent(), writer);
			return writer.toString().split("<body>")[1].split("</body>")[0];
		} catch (IOException e) {
			e.printStackTrace();
			return "(not available)";
		} catch (RuntimeException e) {
			e.printStackTrace();
			return "(not available)";
		}
	}
	
}