package com.example.anenativelib;

import android.content.IntentFilter;
import cn.jpush.android.api.JPushInterface;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

public class RegisterRecerverFunction implements FREFunction {

	@Override
	public FREObject call(FREContext ctx, FREObject[] params) {
		MyReceiver recv = new MyReceiver(ctx);
		IntentFilter filter = new IntentFilter();
		filter.addAction(JPushInterface.ACTION_NOTIFICATION_RECEIVED_PROXY);
		filter.addAction(JPushInterface.ACTION_NOTIFICATION_OPENED);
		filter.addAction(JPushInterface.ACTION_MESSAGE_RECEIVED);
		filter.addAction(JPushInterface.ACTION_NOTIFICATION_RECEIVED);
		filter.addCategory(ctx.getActivity().getPackageName());
		ctx.getActivity().registerReceiver(recv, filter);
		return null;
	}

}
