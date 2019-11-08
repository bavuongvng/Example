package com.example.example.services;

import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyService extends Service {
    private final String TAG = "My Tag";
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(final Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);

        Log.d(TAG, "My tag service");
//
//        Intent intent1 = new Intent();
//        intent1.setAction(Intent.ACTION_CALL);
//        intent1.setData(Uri.parse("tel:"+"123456789"));
//        intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        Log.d(TAG, "Start activity");
//        startActivity(intent1);

        return START_STICKY;
    }
}
