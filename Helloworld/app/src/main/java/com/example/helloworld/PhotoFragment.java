package com.example.helloworld;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.CompoundButton;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.security.Permission;


public class PhotoFragment extends Fragment {
    private static final String TAG = "PhotoFragment";

    private static final int PHOTO_FRAGMENT_NUM = 4;
    private static final int CAMERA_REQUEST_CODE = 6;
   @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container , @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_photo,container, false);

       Button btnLaunchCamera = (Button) view.findViewById(R.id.btnLaunchCamera);
       btnLaunchCamera.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v){
               Log.d(TAG, "onClick:Launching camera. ");
               Log.d(TAG, "onClick: Starting camera");
               Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
               startActivityForResult(cameraIntent,CAMERA_REQUEST_CODE);
           }
       });
       return view;
   }

    @Override
    public void onActivityResult(int requestCode,int resultCode,Intent data) {
        super.onActivityResult(requestCode,resultCode,data);

        if(requestCode == CAMERA_REQUEST_CODE){
            Log.d(TAG, "onActivityResult: Done photo");
            Log.d(TAG, "onActivityResult:blah blah ");
        }
    }


}