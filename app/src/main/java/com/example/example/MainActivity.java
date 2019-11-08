package com.example.example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btnCallMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkAndRequesPermission();
        inital();

        btnCallMe.setOnClickListener(handleCall);
    }

    private View.OnClickListener handleCall = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            intentCall("0123456");
        }
    };

    private void inital(){
        btnCallMe = findViewById(R.id.btnCallMe);
    }

    private void checkAndRequesPermission(){
        String[] permissions = new String[]{
                Manifest.permission.CALL_PHONE,
                Manifest.permission.RECEIVE_SMS,
                Manifest.permission.READ_SMS
        };
        List<String> listPermissionNeeded = new ArrayList<>();

        for (String permission: permissions) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED){
                listPermissionNeeded.add(permission);
            }
        }
        if (!listPermissionNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionNeeded.toArray(new String[listPermissionNeeded.size()]), 1);
        }
    }

    private void intentCall(String phoneNumber){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:"+phoneNumber));
        startActivity(intent);
    }
}
