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

import java.io.IOException;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.alacrity.openingdesign.messageportlet.RandomPadGenerator;
import com.alacrity.openingdesign.messageportlet.model.model.SKQuestion;

/**
 * The model implementation for the SKQuestion service. Represents a row in the &quot;SK_SKQuestion&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.alacrity.openingdesign.messageportlet.model.model.SKQuestion} interface.
 * </p>
 *
 * <p>
 * Never reference this class directly. All methods that expect a s k question model instance should use the {@link SKQuestion} interface instead.
 * </p>
 */
public class SKQuestionImpl extends SKQuestionModelImpl implements SKQuestion {
	public SKQuestionImpl() {
	}

	public String getEtherpadId() {
		URL url;
		try {
			url = new URL(getUrl());
			return url.getPath().replace("/", "");
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public URL getHtmlExportURL() {
		try {
			return new URL(RandomPadGenerator.BASE_URL
					+ "/ep/pad/export/"
					+ getEtherpadId()
					+ "/latest?format=html");
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public URL getHistoryUrl() {
		try {
			return new URL(RandomPadGenerator.BASE_URL
					+ "/ep/pad/view/"
					+ getEtherpadId()
					+ "/latest");
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
		} catch(RuntimeException e) {
			e.printStackTrace();
			return "(not available)";
		}
//		try {
//			Parser parser = new Parser(getHtmlExportURL().openConnection());
//			CssSelectorNodeFilter filter = new CssSelectorNodeFilter("html body");
//			StringBuilder result = new StringBuilder();
//			result.append("test...");
//			for (NodeIterator i = parser.elements(); i.hasMoreNodes(); ) {
//				Node node = i.nextNode();
//				result.append("node.html: " + node.toHtml()); // the actual html, unescaped
//				result.append("node.class" + node.getClass().getCanonicalName());
//			}
//			return result.toString();
//		} catch (ParserException e) {
//			e.printStackTrace();
//			return "Content not available";
//		} catch (IOException e) {
//			e.printStackTrace();
//			return "Content not available";
//		}
	}
}