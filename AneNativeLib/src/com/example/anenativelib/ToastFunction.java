package com.example.anenativelib;

import android.widget.Toast;

import cn.jpush.android.api.JPushInterface;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREInvalidObjectException;
import com.adobe.fre.FREObject;
import com.adobe.fre.FRETypeMismatchException;
import com.adobe.fre.FREWrongThreadException;

public class ToastFunction implements FREFunction {

	@Override
	public FREObject call(FREContext context, FREObject[] params) {
		String msg = null;
		try {
			 msg = params[0].getAsString();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (FRETypeMismatchException e) {
			e.printStackTrace();
		} catch (FREInvalidObjectException e) {
			e.printStackTrace();
		} catch (FREWrongThreadException e) {
			e.printStackTrace();
		}
		
		JPushInterface.init(context.getActivity().getApplicationContext());
		Toast.makeText(context.getActivity(), msg, Toast.LENGTH_SHORT).show();
		
		return null;
	}

}
