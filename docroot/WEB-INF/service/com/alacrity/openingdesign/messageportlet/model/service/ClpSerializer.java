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

import com.alacrity.openingdesign.messageportlet.model.model.SKQuestionClp;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.BaseModel;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static final String SERVLET_CONTEXT_NAME = "message-portlet";

	public static void setClassLoader(ClassLoader classLoader) {
		_classLoader = classLoader;
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(SKQuestionClp.class.getName())) {
			SKQuestionClp oldCplModel = (SKQuestionClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("com.alacrity.openingdesign.messageportlet.model.model.impl.SKQuestionImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setQuestion_ID",
							new Class[] { Long.TYPE });

					Long value0 = new Long(oldCplModel.getQuestion_ID());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setParent_ID",
							new Class[] { Long.TYPE });

					Long value1 = new Long(oldCplModel.getParent_ID());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setTitle",
							new Class[] { String.class });

					String value2 = oldCplModel.getTitle();

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setUrl",
							new Class[] { String.class });

					String value3 = oldCplModel.getUrl();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setPost_Date",
							new Class[] { Long.TYPE });

					Long value4 = new Long(oldCplModel.getPost_Date());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setUser_ID",
							new Class[] { Long.TYPE });

					Long value5 = new Long(oldCplModel.getUser_ID());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setCompanyId",
							new Class[] { Long.TYPE });

					Long value6 = new Long(oldCplModel.getCompanyId());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setGroupId",
							new Class[] { Long.TYPE });

					Long value7 = new Long(oldCplModel.getGroupId());

					method7.invoke(newModel, value7);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"com.alacrity.openingdesign.messageportlet.model.model.impl.SKQuestionImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					SKQuestionClp newModel = new SKQuestionClp();

					Method method0 = oldModelClass.getMethod("getQuestion_ID");

					Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

					newModel.setQuestion_ID(value0);

					Method method1 = oldModelClass.getMethod("getParent_ID");

					Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

					newModel.setParent_ID(value1);

					Method method2 = oldModelClass.getMethod("getTitle");

					String value2 = (String)method2.invoke(oldModel,
							(Object[])null);

					newModel.setTitle(value2);

					Method method3 = oldModelClass.getMethod("getUrl");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setUrl(value3);

					Method method4 = oldModelClass.getMethod("getPost_Date");

					Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

					newModel.setPost_Date(value4);

					Method method5 = oldModelClass.getMethod("getUser_ID");

					Long value5 = (Long)method5.invoke(oldModel, (Object[])null);

					newModel.setUser_ID(value5);

					Method method6 = oldModelClass.getMethod("getCompanyId");

					Long value6 = (Long)method6.invoke(oldModel, (Object[])null);

					newModel.setCompanyId(value6);

					Method method7 = oldModelClass.getMethod("getGroupId");

					Long value7 = (Long)method7.invoke(oldModel, (Object[])null);

					newModel.setGroupId(value7);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static ClassLoader _classLoader;
}