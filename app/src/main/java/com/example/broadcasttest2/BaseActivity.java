package com.example.broadcasttest2;

import android.content.IntentFilter;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    private ForceOfflineReceive receive;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter("com.example.broadcasttest2.FORCE_OFFLINE");
        receive = new ForceOfflineReceive();
        registerReceiver(receive,intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(receive!=null){
            unregisterReceiver(receive);
            receive=null;
        }
    }

    protected  void onDestroy(){
        super.onDestroy();
        ActivityCollector.removeActivity(this);

    }
}
