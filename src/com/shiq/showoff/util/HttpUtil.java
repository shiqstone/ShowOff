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
	
	
	// HttpGet��ʽ����
	public static String requestByHttpGet(String url) throws Exception {
		//String path = "https://reg.163.com/logins.jsp?id=helloworld&pwd=android";
		String path = url;
		// �½�HttpGet����
		HttpGet httpGet = new HttpGet(path);
		// ��ȡHttpClient����
		HttpClient httpClient = new DefaultHttpClient();
		// ��ȡHttpResponseʵ��
		HttpResponse httpResp = httpClient.execute(httpGet);
		
		String result = null;
		// �ж��ǹ�����ɹ�
		if (httpResp.getStatusLine().getStatusCode() == HTTP_200) {
			// ��ȡ���ص�����
			result = EntityUtils.toString(httpResp.getEntity(), "UTF-8");
			Log.i(TAG_HTTPGET, "HttpGet��ʽ����ɹ��������������£�");
			Log.i(TAG_HTTPGET, result);
		} else {
			Log.i(TAG_HTTPGET, "HttpGet��ʽ����ʧ��");
		}
		return result;
	}
	
	// HttpPost��ʽ����
	public static String requestByHttpPost(String url, List<NameValuePair> params) throws Exception {
		//String path = "https://reg.163.com/logins.jsp";
		String path = url;
		// �½�HttpPost����
		HttpPost httpPost = new HttpPost(path);
		// Post����
		//List<NameValuePair> params = new ArrayList<NameValuePair>();
		//params.add(new BasicNameValuePair("id", "helloworld"));
		//params.add(new BasicNameValuePair("pwd", "android"));
		// �����ַ���
		HttpEntity entity = new UrlEncodedFormEntity(params, HTTP.UTF_8);
		// ���ò���ʵ��
		httpPost.setEntity(entity);
		// ��ȡHttpClient����
		HttpClient httpClient = new DefaultHttpClient();
		// ��ȡHttpResponseʵ��
		HttpResponse httpResp = httpClient.execute(httpPost);
		String result = null;
		// �ж��ǹ�����ɹ�
		if (httpResp.getStatusLine().getStatusCode() == HTTP_200) {
			// ��ȡ���ص�����
			result = EntityUtils.toString(httpResp.getEntity(), "UTF-8");
			Log.i(TAG_HTTPGET, "HttpPost��ʽ����ɹ��������������£�");
			Log.i(TAG_HTTPGET, result);
		} else {
			Log.i(TAG_HTTPGET, "HttpPost��ʽ����ʧ��");
		}
		return result;
	}
}
