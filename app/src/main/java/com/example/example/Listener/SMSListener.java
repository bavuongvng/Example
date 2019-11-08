package com.example.example.Listener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import com.example.example.services.MyService;

public class SMSListener extends BroadcastReceiver {
    private final String TAG = "sms received";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "SMS");
//        Intent intent1 = new Intent();
//        intent1.setAction(Intent.ACTION_CALL);
//        intent1.setData(Uri.parse("tel:"+"123456789"));
//        intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        Log.d(TAG, "Start activity");
//        context.startActivity(intent1);

//        Intent smsService = new Intent(context, MyService.class);
//        context.startService(smsService);

        Intent intent1 = new Intent();

        intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent1.setAction(Intent.ACTION_CALL);
        intent1.setData(Uri.parse("tel:"+"123456789"));
        context.startActivity(intent1);
    }
}
