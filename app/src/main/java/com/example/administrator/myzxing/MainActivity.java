package com.example.administrator.myzxing;

import android.*;
import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.administrator.myzxing.qrcode.CaptureActivity;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //请求权限
        if (Build.VERSION.SDK_INT>=23){
            int code= ContextCompat.checkSelfPermission(this,Manifest.permission.CAMERA);
            if (code!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},0);
            }else{
                CaptureActivity.startActivity(this);
            }
        }else{
            CaptureActivity.startActivity(this);
        }

    }
    @Override//请求权限回调函数
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults[0]==0){
            //TODO something
            CaptureActivity.startActivity(this);
        }
    }
}
