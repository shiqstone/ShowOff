package com.shiq.showoff;

import org.json.JSONObject;

import android.util.Log;

import com.shiq.showoff.util.HttpUtil;

public class InstantBonus {
	public Integer queryInstantState(){
		Integer sum = Integer.valueOf("0");
		String url = "http://app.cp.360.cn/int/getidxinfo";
		try {
			String res = HttpUtil.requestByHttpGet(url);
			//String res = HttpUtil.requestByHttpPost(url, null);
			JSONObject json = new JSONObject(res);
			String sumStr = json.get("sum").toString();
			sum = Integer.valueOf(sumStr);
			//Object results = JSONObject.toBean(json, CpIndexNotice.class);
			//sum = new Integer(value)
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.i("ERROR", e.toString());
		}
		return sum;
	}
}
