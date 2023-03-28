package com.zhixing.app;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class LanguageReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(Intent.ACTION_LOCALE_CHANGED)) {
            android.os.Process.killProcess(android.os.Process.myPid());
        }
    }
}

