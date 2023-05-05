package com.zhixing.app.common;

import android.content.Context;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.zhixing.app.DemoApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtils {
    static volatile String ret;
    final static String BASE_URL = "http://47.115.226.135:9090/";
    public static JsonObject doGet(String apiUrl){

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                ret = doThreadget(apiUrl);
            }
        });
        thread.start();
        try {
            thread.join();
            if(ret!=null){
                return unpackData(ret);
            }
            else{
                showToast("网络错误,请重试");
                return null;
            }
        } catch (InterruptedException e) {
            showToast("系统错误,请重试");
            e.printStackTrace();
            return null;
        }
    }
    public static String doThreadget(String apiUrl) {
        String fullUrl = BASE_URL + apiUrl;
        try {
            URL url = new URL(fullUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(10000);
            connection.connect();
            int code = connection.getResponseCode();
            if (code == HttpURLConnection.HTTP_OK) {
                String msg="";
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line = null;
                while ((line = reader.readLine()) != null) {
                    // 循环从流中读取
                    msg += line + "\n";
                }
                reader.close();
                connection.disconnect();
                return msg;
                //return unpackData(msg);
            } else {
                //showErrorToast("用户名或错误,请重试");
                return null;
            }
        }
        catch (Exception e){
            e.printStackTrace();
            //showErrorToast("网络错误,请重试");
            return null;
        }
    }

    //post请求不需要返回信息，只返回是否操作成功
    public static <T> JsonObject doPost(String apiUrl,T data,String successmsg){
        String json = new Gson().toJson(data);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                ret = doThreadPost(apiUrl,json);
            }
        });
        thread.start();
        try {
            thread.join();
            if(ret!=null){
                JsonObject jsonObject = JsonParser.parseString(ret).getAsJsonObject();
                if(jsonObject.get("code").getAsString().equals(Constants.CODE_200)){
                    showToast(successmsg);
                    return null;
                }
                else{
                    showToast(jsonObject.get("msg").getAsString());
                    return null;
                }
            }
            else{
                showToast("网络错误,请重试");
                return null;
            }
        } catch (InterruptedException e) {
            showToast("系统错误,请重试");
            e.printStackTrace();
            return null;
        }
    }
    public static String doThreadPost(String apiUrl, String json){
        String fullUrl = BASE_URL + apiUrl;
        try {
            URL url = new URL(fullUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setConnectTimeout(10000);
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            connection.connect();
            connection.getOutputStream().write(json.getBytes());
            connection.getOutputStream().flush();
            connection.getOutputStream().close();
            int code = connection.getResponseCode();
            if (code == HttpURLConnection.HTTP_OK) {
                String msg="";
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line = null;
                while ((line = reader.readLine()) != null) {
                    // 循环从流中读取
                    msg += line + "\n";
                }
                reader.close();
                connection.disconnect();
                return msg;
                //return unpackData(msg);
            } else {
                //showErrorToast("用户名或错误,请重试");
                return null;
            }
        }
        catch (Exception e){
            e.printStackTrace();
            //showErrorToast("网络错误,请重试");
            return null;
        }
    }
    public static JsonObject unpackData(String resp){
        JsonObject jsonObject = JsonParser.parseString(resp).getAsJsonObject();
        if(jsonObject.get("code").getAsString().equals(Constants.CODE_200)){
            return jsonObject.get("data").getAsJsonObject();
        }
        else{
            showToast(jsonObject.get("msg").getAsString());
            return null;
        }
    }
    public static void showToast(String msg) {
        Context context = DemoApplication.instance().getApplicationContext();
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }
    public static  <T>T unpackJson(String resp,Class<T> classz){
        Gson gson = new Gson();
        return gson.fromJson(resp,classz);
    }
    public static  <T>T unpackJson(JsonObject jsonObject,Class<T> classz){
        Gson gson = new Gson();
        return gson.fromJson(jsonObject,classz);
    }
}
