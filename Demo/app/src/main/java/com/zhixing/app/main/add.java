package com.zhixing.app.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.zhixing.app.R;
import com.zhixing.app.bean.Shop;
import com.zhixing.app.bean.User;
import com.zhixing.app.bean.UserInfo;
import com.zhixing.app.common.HttpUtils;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link add#newInstance} factory method to
 * create an instance of this fragment.
 */
public class add extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button submit;
    private EditText shopName;
    private EditText shopDetail;
    public add() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment add.
     */
    // TODO: Rename and change types and number of parameters
    public static add newInstance(String param1, String param2) {
        add fragment = new add();
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
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        submit = view.findViewById(R.id.shop_add);
        shopName = view.findViewById(R.id.shop_name);
        shopDetail = view.findViewById(R.id.shop_detail);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = shopName.getText().toString();
                String detail = shopDetail.getText().toString();
                Integer owner = UserInfo.getInstance().getUser().getId();
                Shop shop = new Shop(name, detail,99.0,owner);
                HttpUtils.doPost("shop",shop,"商品提交成功");
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}