package com.alacrity.openingdesign.messageportlet.resources;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class PageNavigationManager {

	public static int calculateCurrentPage(final int start,final int end){
		
		final int firstItem=start+1;
		final int lastItem=end+1;
		final int itemsPerPage=lastItem-firstItem+1;
		
		return lastItem/itemsPerPage;
		
	}
	
	public static int calculateNumberOfPages(final int start,final int end,final long maxItems){
		
		final int firstItem=start+1;
		final int lastItem=end+1;
		final int itemsPerPage=lastItem-firstItem+1;
		
		BigDecimal bd = new BigDecimal(maxItems/(itemsPerPage+0.0)).setScale(0,RoundingMode.CEILING);
		
		return bd.intValue();
		
	}
	
	public static boolean isTherePreviousPages(final int start,final int end){
		
		return calculateCurrentPage(start,end)>1;
		
	}
	
	public static boolean isThereNextPages(final int start,final int end,final long maxItems){
		
		return calculateCurrentPage(start,end)<calculateNumberOfPages(start,end,maxItems);
		
	}
	
}
