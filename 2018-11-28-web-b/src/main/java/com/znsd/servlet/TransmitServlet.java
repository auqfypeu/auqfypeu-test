package com.znsd.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class TransmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*String userName = (String) request.getParameter("userName");
		System.out.println("----userName:"+userName);
		// 创建默认的httpClient实例.
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 创建httppos					 
		HttpPost httppost = new HttpPost("http://127.0.0.1:8080/a/FromServlet?userName="+userName);
		// 创建参数队列
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("type", "house"));
		UrlEncodedFormEntity uefEntity;
		String val = "";
		JSONObject jsonObject = new JSONObject();
		try {
			uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
			httppost.setEntity(uefEntity);
			System.out.println("executing request " + httppost.getURI());
			CloseableHttpResponse res = httpclient.execute(httppost);
			try {
				HttpEntity entity = res.getEntity();
				if (entity != null) {
					val = EntityUtils.toString(entity, "UTF-8");
					System.out.println("--------------------------------------");
					System.out.println("Response content - val: " + val);
					System.out.println("--------------------------------------");
					jsonObject.put("userName",val);
				}
			} finally {
				res.close();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭连接,释放资源
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		response.getWriter().println(val);*/
		
		OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, "{\n\t\"name\":\"张三\",\n\t\"sex\":\"女\"\n}");
		Request req = new Request.Builder()
		  .url("http://127.0.0.1:8080/a/FromServlet?userName=zhangsan")
		  .post(body)
		  .addHeader("Content-Type", "application/json")
		  .addHeader("cache-control", "no-cache")
		  .addHeader("Postman-Token", "1c581823-d266-4dc3-900d-1799aa380c57")
		  .build();
		
		Response res = client.newCall(req).execute();
		String val = res.body().string();
		System.out.println("res val--:"+val);
		PrintWriter writer = response.getWriter();
		writer.println(val);
	}

}
