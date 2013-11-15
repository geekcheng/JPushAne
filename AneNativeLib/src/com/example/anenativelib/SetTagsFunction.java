package com.example.anenativelib;

import java.util.HashSet;
import java.util.Set;

import cn.jpush.android.api.JPushInterface;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREInvalidObjectException;
import com.adobe.fre.FREObject;
import com.adobe.fre.FRETypeMismatchException;
import com.adobe.fre.FREWrongThreadException;

public class SetTagsFunction implements FREFunction {

	@Override
	public FREObject call(FREContext ctx, FREObject[] params) {
		if(params != null && params.length > 0){
			Set<String> tags = new HashSet<String>();
				String tag = null;
				FREObject obj = params[0];
					try {
						tag = obj.getAsString();
					} catch (IllegalStateException e) {
						e.printStackTrace();
					} catch (FRETypeMismatchException e) {
						e.printStackTrace();
					} catch (FREInvalidObjectException e) {
						e.printStackTrace();
					} catch (FREWrongThreadException e) {
						e.printStackTrace();
					}
					if(tag != null && !tag.equals("")){
						String[] slice = tag.split(",");
						for(String  s: slice){
							tags.add(s);
						}
					}
			
			if(tags != null && tags.size() > 0){
				JPushInterface.setTags(ctx.getActivity().getApplicationContext(), tags, null);
			}
		}
		return null;
	}

}
