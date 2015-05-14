package com.muthii.utility;

import javax.ws.rs.core.CacheControl;

public class Constants {
	public static final CacheControl NO_CACHE;
	static
	{
		NO_CACHE = new CacheControl();
		NO_CACHE.setNoCache(true);
	}
	public static final String BARCODE = "barcode";
	public static final String BAR = "getBar";
	public static final String MIME_TYPE_HTML = "text/html";
	public static final String BAR_DEFAULT = "0123456789";
	public static final String BARCODE_TYPE = "type";
	public static final String HTML_PRNT_BTN = "<style type='text/css' media='print'>.printbutton {visibility: hidden;display: none;}</style>" +
			"<input type='button' onClick='window.print()' class='printbutton' value='Print'/>";
	//Default to 2 instead of one <br>
	public static final String LINE_BREAK = "<br/><br/>";
	public static final String MEDIA_TYPE_JSON = "application/json";

}
