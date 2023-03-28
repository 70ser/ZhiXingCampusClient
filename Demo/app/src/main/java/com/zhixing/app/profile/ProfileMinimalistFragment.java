package com.zhixing.app.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.zhixing.app.R;
import com.zhixing.app.bean.UserInfo;
import com.zhixing.app.utils.TUIKitConstants;
import com.zhixing.app.utils.TUIUtils;
import com.tencent.qcloud.tuicore.TUILogin;
import com.tencent.qcloud.tuicore.component.dialog.TUIKitDialog;
import com.tencent.qcloud.tuicore.component.fragments.BaseFragment;
import com.tencent.qcloud.tuicore.interfaces.TUICallback;
import com.tencent.qcloud.tuicore.util.ToastUtil;


public class ProfileMinimalistFragment extends BaseFragment {

    private View mBaseView;
    private ProfileMinamalistLayout mProfileLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        mBaseView = inflater.inflate(R.layout.minimalist_profile_fragment, container, false);
        initView();
        return mBaseView;
    }

    private void initView() {
        mProfileLayout = mBaseView.findViewById(R.id.profile_view);
        mBaseView.findViewById(R.id.logout_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TUIKitDialog(getActivity())
                        .builder()
                        .setCancelable(true)
                        .setCancelOutside(true)
                        .setTitle(getString(R.string.logout_tip))
                        .setDialogWidth(0.75f)
                        .setPositiveButton(getString(com.tencent.qcloud.tuicore.R.string.sure), new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                TUILogin.logout(new TUICallback() {
                                    @Override
                                    public void onSuccess() {
                                        UserInfo.getInstance().cleanUserInfo();
                                        Bundle bundle = new Bundle();
                                        bundle.putBoolean(TUIKitConstants.LOGOUT, true);
                                        TUIUtils.startActivity("LoginForDevActivity", bundle);
                                        if (getActivity() != null) {
                                            getActivity().finish();
                                        }
                                    }

                                    @Override
                                    public void onError(int code, String desc) {
                                        ToastUtil.toastLongMessage("logout fail: " + code + "=" + desc);
                                    }
                                });
                            }

                        })
                        .setNegativeButton(getString(com.tencent.qcloud.tuicore.R.string.cancel), new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        })
                        .show();
            }
        });

    }
}
