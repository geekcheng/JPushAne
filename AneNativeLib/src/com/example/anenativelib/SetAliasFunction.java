package com.example.anenativelib;

import cn.jpush.android.api.JPushInterface;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREInvalidObjectException;
import com.adobe.fre.FREObject;
import com.adobe.fre.FRETypeMismatchException;
import com.adobe.fre.FREWrongThreadException;

public class SetAliasFunction implements FREFunction {

	@Override
	public FREObject call(FREContext ctx, FREObject[] params) {
		String alias = null;
		try {
			alias = params[0].getAsString();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (FRETypeMismatchException e) {
			e.printStackTrace();
		} catch (FREInvalidObjectException e) {
			e.printStackTrace();
		} catch (FREWrongThreadException e) {
			e.printStackTrace();
		}
		if(alias != null && !alias.equals("")){
			JPushInterface.setAlias(ctx.getActivity().getApplicationContext(), alias, null);
		}
		return null;
	}

}
