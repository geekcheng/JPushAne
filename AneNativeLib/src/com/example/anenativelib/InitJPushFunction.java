package com.example.anenativelib;

import cn.jpush.android.api.JPushInterface;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

public class InitJPushFunction implements FREFunction {

	@Override
	public FREObject call(FREContext ctx, FREObject[] params) {
		JPushInterface.setDebugMode(true);
		JPushInterface.init(ctx.getActivity().getApplicationContext());
		return null;
	}

}
