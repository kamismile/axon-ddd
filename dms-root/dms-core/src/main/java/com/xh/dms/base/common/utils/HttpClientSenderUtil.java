/*** Copyright © 2001-2010 HandPay Information Technology ( Group ) Co., Ltd. */
package com.xh.dms.base.common.utils;

import java.io.IOException;

/*import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;*/

/**
 * <a href="HttpClientSenderUtil.java.html"><b><i>View Source</i></b></a>
 * 
 * Description ★ 基于HTTPCLIENT的请求发送工具
 * 
 * @author zhcui
 */
public class HttpClientSenderUtil {

	/*private HttpClient httpClient = new DefaultHttpClient();

	public HttpClientSenderUtil(String url) {
		this.url = url;
	}

	*//**
	 * 请求地址
	 *//*
	private String url;

	public HttpEntity sendRequestByGet() {
		HttpGet httpget = new HttpGet(url);
		HttpResponse response = null;
		try {
			response = httpClient.execute(httpget);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				// InputStream instreams = entity.getContent();
				// String str = convertStreamToString(instreams);
				// byte[] bytes = EntityUtils.toByteArray(entity);
				// System.out.println(" - " + bytes.length + " bytes read");
				// System.out.println("返回值:" + EntityUtils.toString(entity));
				return entity;
			}
		} catch (ClientProtocolException e) {
			httpget.abort();
			e.printStackTrace();
		} catch (IOException e) {
			httpget.abort();
			e.printStackTrace();
		}
		return null;
	}

	public HttpEntity sendRequestByPost() {
		HttpPost httpPost = new HttpPost(url);
		HttpResponse response = null;
		try {
			response = httpClient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				// System.out.println("返回值:" + EntityUtils.toString(entity));
				return entity;
			}
		} catch (ClientProtocolException e) {
			httpPost.abort();
			e.printStackTrace();
		} catch (IOException e) {
			httpPost.abort();
			e.printStackTrace();
		}
		return null;
	}
*/
}
