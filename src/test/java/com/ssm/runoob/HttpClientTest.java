package com.ssm.runoob;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * User:  Phil
 * Project: runoob
 * Package: com.ssm.runoob
 * Date: 2016/5/13
 * Time: 12:17
 * Created by IntelliJ IDEA.
 */
public class HttpClientTest {
    private final Logger logger = Logger.getLogger(this.getClass());

    @Test
    public void t() {
        for (int i = 0; i < 10; i++) {
            get(i);
        }

//        post();
    }

    private void get(int i) {
        // 创建默认的httpClient实例.
        CloseableHttpClient client = HttpClients.createDefault();
        //publisher切断推送
        HttpGet httpGet = new HttpGet("http://101.201.100.208/control/drop/publisher?app=live&name=livestream_" + i);
        //subscriber
//        HttpGet httpGet = new HttpGet("http://101.201.100.208/control/drop/subscriber?srv=0&app=live&name=stream_name");
        //从定向Redirect
//        HttpGet httpGet = new HttpGet("http://101.201.100.208/control/redirect/publisher?app=live&name=stream_name&newname=NEWNAME");
//        HttpGet httpGet = new HttpGet("http://101.201.100.208/stat");

        // 创建httpget. get 请求
        //ping 方法
//        HttpGet httpGet = new HttpGet("http://localhost:1111/admin/ping?auser=admin&apswd=121511fei");
        //添加用户
//        HttpGet httpGet = new HttpGet("http://localhost:1111/admin/addAdmin?auser=admin&apswd=121511fei&username='zxc'&password='zxc123456'");
        //停止live 切断直播 1
//        HttpGet httpGet = new HttpGet("http://localhost:1111/admin/unloadApp?auser=admin&apswd=121511fei&appInst='live'");
//        停止server
//        HttpGet httpGet = new HttpGet("http://localhost:1111/admin/stopServer?auser=admin&apswd=121511fei&mode='normal'"); //mode=normal 相当于服务器端做出暂停 客户端处于等待状态 //mode=abort 终止播放  客户端需要刷新后才可以
        //启动servr
//        HttpGet httpGet = new HttpGet("http://localhost:1111/admin/startServer?auser=admin&apswd=121511fei");
        //获取连接的客户端id
//        HttpGet httpGet = new HttpGet("http://localhost:1111/admin/getUsers?auser=admin&apswd=121511fei&appInst='live'");
        //添加一个app (testapp)
//        HttpGet httpGet = new HttpGet("http://localhost:1111/admin/addApp?auser=admin&apswd=121511fei&appname='testapp'");
        //获取连接(testapp)的客户端id
//        HttpGet httpGet = new HttpGet("http://localhost:1111/admin/getUsers?auser=admin&apswd=121511fei&appInst='testapp'");
//        使客户端断开链接(oAAGAAAA)
//        HttpGet httpGet = new HttpGet("http://localhost:1111/admin/disconnectUsers?auser=admin&apswd=121511fei&appInst='testapp'&clients='oAAGAAAA'");
        logger.info("executing request " + httpGet.getURI());
        CloseableHttpResponse response = null;
        try {
            // 执行get请求.
            response = client.execute(httpGet);
            // 获取响应实体
            HttpEntity entity = response.getEntity();
            // 打印响应状态
            logger.info("#############" + response.getStatusLine() + "###########");
            if (entity != null) {
//                logger.info(XML.toJSONObject(EntityUtils.toString(entity)));
                // 打印响应内容长度
//                logger.info("Response content length: " + entity.getContentLength());
                // 打印响应内容
                logger.info("Response content: " + EntityUtils.toString(entity));
            }
            logger.info("------------------------------------");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(response, client);
        }
    }

    //不支持post
    public void post() {
        // 创建默认的httpClient实例.
        CloseableHttpClient client = HttpClients.createDefault();
        // 创建httpget. post
        HttpPost httpPost = new HttpPost("http://localhost:1111/admin/addAdmin");
        logger.info("executing request " + httpPost.getURI());

        // // 创建参数队列
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        nameValuePairs.add(new BasicNameValuePair("auser", "admin"));
        nameValuePairs.add(new BasicNameValuePair("apswd", "121511fei"));
        nameValuePairs.add(new BasicNameValuePair("username", "zhangsan"));
        nameValuePairs.add(new BasicNameValuePair("password", "123456"));
        UrlEncodedFormEntity uefEntity;
        CloseableHttpResponse response = null;
        try {
            uefEntity = new UrlEncodedFormEntity(nameValuePairs, "UTF-8");
            httpPost.setEntity(uefEntity);
            logger.info("executing request " + httpPost.getURI());
            // 执行post请求.
            response = client.execute(httpPost);
            // 打印响应状态
            logger.info("#############" + response.getStatusLine() + "###########");
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                logger.info("--------------------------------------");
                System.out.println("Response content: " + EntityUtils.toString(entity, "UTF-8"));
                logger.info("--------------------------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(response, client);
        }

    }

    private void close(CloseableHttpResponse response, CloseableHttpClient client) {
        try {
            if (response != null) {
                response.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
