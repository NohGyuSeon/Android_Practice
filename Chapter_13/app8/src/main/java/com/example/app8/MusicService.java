package com.example.app8;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MusicService extends Service {

    private static final String TAG = "MusicService";
    MediaPlayer player;

//    public MusicService(MediaPlayer player) {
//        this.player = player;
//    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Music Service를 실행합니다.", Toast.LENGTH_LONG)
                .show();
        Log.d(TAG, "onStart()");
        player.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw null;
    }

    @Override
    public void onCreate() {
        //super.onCreate();
        Log.d(TAG, "onCreate()");

        player = MediaPlayer.create(this, R.raw.old_pop);
        player.setLooping(false); // Set looping
    }

    @Override
    public void onDestroy() {
        //  super.onDestroy();
        Toast.makeText(this, "Music Service를 종료합니다.", Toast.LENGTH_LONG)
                .show();
        Log.d(TAG, "onDestroy()");
        player.stop();
    }
}