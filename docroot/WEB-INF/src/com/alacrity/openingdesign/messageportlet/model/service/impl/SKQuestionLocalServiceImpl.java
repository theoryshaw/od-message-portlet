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

package com.alacrity.openingdesign.messageportlet.model.service.impl;

import java.util.Collection;
import java.util.Date;

import com.alacrity.openingdesign.messageportlet.model.model.SKQuestion;
import com.alacrity.openingdesign.messageportlet.model.service.base.SKQuestionLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the s k question local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.alacrity.openingdesign.messageportlet.model.service.SKQuestionLocalService}
 * interface.
 * </p>
 * 
 * <p>
 * Never reference this interface directly. Always use
 * {@link com.alacrity.openingdesign.messageportlet.model.service.SKQuestionLocalServiceUtil}
 * to access the s k question local service.
 * </p>
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author Henricor
 * @see com.alacrity.openingdesign.messageportlet.model.service.base.SKQuestionLocalServiceBaseImpl
 * @see com.alacrity.openingdesign.messageportlet.model.service.SKQuestionLocalServiceUtil
 */
public class SKQuestionLocalServiceImpl extends SKQuestionLocalServiceBaseImpl {
	public synchronized SKQuestion getSKQuestionByUrl(final String url)
			throws PortalException, SystemException {

		final Collection<SKQuestion> ret = skQuestionPersistence
				.findByfindByURL(url);

		if (ret.size() == 0) {
			return null;
		}

		return ret.iterator().next();

	}

	public synchronized SKQuestion createQuestionWithParent(String title,
			String url, long userId, long parentOrZero) {
		
		try {
			SKQuestion question = skQuestionPersistence
					.create(counterLocalService.increment(SKQuestion.class
							.getName()));
			question.setTitle(title);
			question.setUser_ID(userId);
			question.setPost_Date(new Date().getTime());
			question.setUrl(url);
			if (parentOrZero != 0L) {
				question.setParent_ID(parentOrZero);
			}

			skQuestionPersistence.update(question, false);
			
			return question;
			
		} catch (SystemException e) {
			throw new RuntimeException(e);
		}
		
	}

}