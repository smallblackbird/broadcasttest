package com.example.broadcasttest2;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

class ForceOfflineReceive extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, Intent intent) {
        AlertDialog.Builder builderer = new AlertDialog.Builder(context);
        builderer.setTitle("Warning");
        builderer.setMessage("please try to login again");
        builderer.setCancelable(false);
        builderer.setPositiveButton("OK",new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ActivityCollector.finishALL();
                Intent intent = new Intent(context,LoginActivity.class);
                context.startActivity(intent);
            }
        });
        builderer.show();
    }
}
