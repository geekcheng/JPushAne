package com.example.anenativelib;

import java.util.HashMap;
import java.util.Map;
import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;

public class NativeContext extends FREContext {
	@Override
	public void dispose() {

	}

	@Override
	public Map<String, FREFunction> getFunctions() {
		Map<String,FREFunction> functions = new HashMap<String, FREFunction>();
		functions.put("toast", new ToastFunction());
		functions.put("init", new InitJPushFunction());
		functions.put("reg", new RegisterRecerverFunction());
		functions.put("set_alias", new SetAliasFunction());
		functions.put("set_tags", new SetTagsFunction());
		return functions;
	}

}
