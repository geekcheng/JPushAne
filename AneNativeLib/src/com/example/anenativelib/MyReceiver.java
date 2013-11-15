package com.example.anenativelib;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import cn.jpush.android.api.JPushInterface;

import com.adobe.fre.FREContext;

public class MyReceiver extends BroadcastReceiver {
	
	private FREContext freContext = null;
	
	public MyReceiver(FREContext ctx){
		freContext = ctx;
	}
	
	@Override
	public void onReceive(Context ctx, Intent intent) {
		String action = intent.getAction();
		if(action.equals(JPushInterface.ACTION_NOTIFICATION_OPENED)){
			String data = intent.getStringExtra(JPushInterface.EXTRA_ALERT);
			freContext.dispatchStatusEventAsync("onOpen", data);
		}else if(action.equals(JPushInterface.ACTION_NOTIFICATION_RECEIVED)){
			String data = intent.getStringExtra(JPushInterface.EXTRA_ALERT);
			freContext.dispatchStatusEventAsync("recv_notify", data);
		}else if(action.equals(JPushInterface.ACTION_MESSAGE_RECEIVED)){
			String data = intent.getStringExtra(JPushInterface.EXTRA_MESSAGE);
			freContext.dispatchStatusEventAsync("recv_msg", data);
		}
	}

}
