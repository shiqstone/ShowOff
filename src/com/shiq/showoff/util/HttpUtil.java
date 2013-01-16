/**
 * 
 */
package com.shiq.showoff.util;

import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import android.util.Log;

/**
 * @author shiq
 *
 */
public class HttpUtil {
	
	public static final int HTTP_200 = 200;
	
	public static final String TAG_HTTPGET = "HttpGet method";
	public static final String TAG_HTTPPOST = "HttpPost method";
	
	
	// HttpGet方式请求
	public static String requestByHttpGet(String url) throws Exception {
		//String path = "https://reg.163.com/logins.jsp?id=helloworld&pwd=android";
		String path = url;
		// 新建HttpGet对象
		HttpGet httpGet = new HttpGet(path);
		// 获取HttpClient对象
		HttpClient httpClient = new DefaultHttpClient();
		// 获取HttpResponse实例
		HttpResponse httpResp = httpClient.execute(httpGet);
		
		String result = null;
		// 判断是够请求成功
		if (httpResp.getStatusLine().getStatusCode() == HTTP_200) {
			// 获取返回的数据
			result = EntityUtils.toString(httpResp.getEntity(), "UTF-8");
			Log.i(TAG_HTTPGET, "HttpGet方式请求成功，返回数据如下：");
			Log.i(TAG_HTTPGET, result);
		} else {
			Log.i(TAG_HTTPGET, "HttpGet方式请求失败");
		}
		return result;
	}
	
	// HttpPost方式请求
	public static String requestByHttpPost(String url, List<NameValuePair> params) throws Exception {
		//String path = "https://reg.163.com/logins.jsp";
		String path = url;
		// 新建HttpPost对象
		HttpPost httpPost = new HttpPost(path);
		// Post参数
		//List<NameValuePair> params = new ArrayList<NameValuePair>();
		//params.add(new BasicNameValuePair("id", "helloworld"));
		//params.add(new BasicNameValuePair("pwd", "android"));
		// 设置字符集
		HttpEntity entity = new UrlEncodedFormEntity(params, HTTP.UTF_8);
		// 设置参数实体
		httpPost.setEntity(entity);
		// 获取HttpClient对象
		HttpClient httpClient = new DefaultHttpClient();
		// 获取HttpResponse实例
		HttpResponse httpResp = httpClient.execute(httpPost);
		String result = null;
		// 判断是够请求成功
		if (httpResp.getStatusLine().getStatusCode() == HTTP_200) {
			// 获取返回的数据
			result = EntityUtils.toString(httpResp.getEntity(), "UTF-8");
			Log.i(TAG_HTTPGET, "HttpPost方式请求成功，返回数据如下：");
			Log.i(TAG_HTTPGET, result);
		} else {
			Log.i(TAG_HTTPGET, "HttpPost方式请求失败");
		}
		return result;
	}
}
