package com.zhixing.app.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.zhixing.app.R;
import com.zhixing.app.bean.Shop;
import com.zhixing.app.common.HttpUtils;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {
    private TextView Title_1;
    private View Root;
    public String A;
    private Button button_img;
    private TextView title;
    private TextView detail;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i("BlankFragment", "onCreate: ");
        super.onCreate(savedInstanceState);
    }

    public String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        OkHttpClient client = new OkHttpClient();
        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.i("BlankFragment", "onPause: ");
        JsonObject ret=  HttpUtils.doGet("shop/last");
        if(ret != null){
            Shop shop = HttpUtils.unpackJson(ret, Shop.class);
            title.setText(shop.getShopName());
            detail.setText(shop.getShopDescription());
        }
        super.onPause();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        Log.d("BlankFragment", "onHiddenChanged: ");
        JsonObject ret=  HttpUtils.doGet("shop/last");
        if(ret != null){
            Shop shop = HttpUtils.unpackJson(ret, Shop.class);
            title.setText(shop.getShopName());
            detail.setText(shop.getShopDescription());
        }
        super.onHiddenChanged(hidden);
    }

    @Override
    public void onStop() {
        Log.i("BlankFragment", "onStop: ");
        super.onStop();
    }

    public void onRestart(){
        Log.i("BlankFragment", "onRestart: ");
    }

    @Override
    public void onStart() {
        Log.i("BlankFragment", "onStart: ");
        JsonObject ret=  HttpUtils.doGet("shop/last");
        if(ret != null){
            Shop shop = HttpUtils.unpackJson(ret, Shop.class);
            title.setText(shop.getShopName());
            detail.setText(shop.getShopDescription());
        }
        super.onStart();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i("BlankFragment", "onCreateView: ");
        // Inflate the layout for this fragment
        Root = inflater.inflate(R.layout.fragment_blank, container, false);
        //OkHttpClient client = new OkHttpClient();
        button_img = Root.findViewById(R.id.shopI1);
        title = Root.findViewById(R.id.shop_title1);
        detail = Root.findViewById(R.id.shop_abstract1);
        JsonObject ret=  HttpUtils.doGet("shop/last");
        if(ret != null){
            Shop shop = HttpUtils.unpackJson(ret, Shop.class);
            title.setText(shop.getShopName());
            detail.setText(shop.getShopDescription());
        }

        return Root;
    }

}