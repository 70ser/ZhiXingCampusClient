package com.zhixing.app.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.zhixing.app.R;
import com.zhixing.app.bean.Shop;
import com.zhixing.app.common.HttpUtils;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View Root;
    private Button button_img;
    private TextView title;
    private TextView detail;
    public BlankFragment2() {
        // Required empty public constructor
    }
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
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment2 newInstance(String param1, String param2) {
        BlankFragment2 fragment = new BlankFragment2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Root = inflater.inflate(R.layout.the_list, container, false);
        //OkHttpClient client = new OkHttpClient();
        button_img = Root.findViewById(R.id.shopI1);
        title = Root.findViewById(R.id.ad_title1);
        detail = Root.findViewById(R.id.ad_abstract1);
        JsonObject ret=  HttpUtils.doGet("shop/last");
        if(ret != null){
            Shop shop = HttpUtils.unpackJson(ret, Shop.class);
            title.setText(shop.getShopName());
            detail.setText(shop.getShopDescription());
        }
        return Root;
    }
}