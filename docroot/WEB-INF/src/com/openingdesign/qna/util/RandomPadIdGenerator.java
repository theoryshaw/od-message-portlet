package com.openingdesign.qna.util;

import java.util.Random;

public class RandomPadIdGenerator {

	public static final String BASE_URL = System
			.getProperty("sketchpad.baseurl");
	
	private static final int LENGTH = 50;
	private static final char[] symbols = new char[36];
	private static final Random random = new Random();
	
	static {
		for (int idx = 0; idx < 10; ++idx)
			symbols[idx] = (char) ('0' + idx);
		for (int idx = 10; idx < 36; ++idx)
			symbols[idx] = (char) ('a' + idx - 10);
	}

	public static String nextPadId() {
		char[] buf = new char[LENGTH];
		for (int idx = 0; idx < buf.length; ++idx)
			buf[idx] = symbols[random.nextInt(symbols.length)];
		return new String(buf);
	}

}
