package org.hwc;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *https://www.cnblogs.com/kitor/p/11235762.html
 */
public class TestClientPost
{
    public static void main( String[] args ) throws Exception
    {
        CloseableHttpClient httpClient=HttpClients.createDefault();
       /* //连接超时
        httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT,60000);
        //读取超时
        httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT,10000);
*/
        HttpPost httpPost = new HttpPost("http://localhost:8080/testhttpclientPost");

        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(
                        5000
                ).setConnectionRequestTimeout(
                        5000
                ).setSocketTimeout(
                       5000
              ).build();

        httpPost.setConfig(requestConfig);

        List<NameValuePair> parameters = new ArrayList<NameValuePair>(2);
        parameters.add(new BasicNameValuePair("age", "18"));
        parameters.add(new BasicNameValuePair("name", "jack"));
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters,"UTF-8");
        httpPost.setEntity(formEntity);
        CloseableHttpResponse response = httpClient.execute(httpPost);
        if(response.getStatusLine().getStatusCode()==200){
            HttpEntity entity = response.getEntity();
            //使用工具类EntityUtils，从响应中取出实体表示的内容并转换成字符串
            String string = EntityUtils.toString(entity, "utf-8");
            System.out.println(string);
        }
        response.close();
        httpClient.close();
    }
}
