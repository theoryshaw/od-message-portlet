package com.openingdesign.qna.util;

import java.util.ArrayList;

import com.liferay.portal.kernel.util.Validator;
import com.openingdesign.qna.model.QueryAndResponse;

public class QueryAndResponseValidator {

	public static boolean validate(QueryAndResponse query,
			ArrayList<String> errors) {
		
		boolean valid = true;
		
		if (Validator.isNull(query.getTitle())) {
			valid = false;
			errors.add("title-required");
		}
		return valid;
		
	}

}
