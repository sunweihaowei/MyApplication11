package cn.edu.gdpt.myapplication;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.VideoView;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    private VideoView vv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //路径：
        /*
        android的资源（android.resource）
        得到包资源（getPackageName())
       得到我们的资源：R.raw.sun
         */
        String uri="android.resource://"+getPackageName()+"/"+R.raw.sun;
        if (uri!=null){
            //为视频控件设置视频路径（其中String路径要用URI的方法parse来解析为我们视频能识别的路径），
            /*
            * 设置视频路径： vv.setVideoURI
            * 解析系统路径（即装换为视频识别路径）：Uri.parse(路径);
            * */
            vv.setVideoURI(Uri.parse(uri));
            vv.start();
            /*
            * 设置准备监听*/
            vv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                    mp.setLooping(true);//循环播放
                }
            });
        }

    }

    private void initView() {
        vv = (VideoView) findViewById(R.id.vv);
    }
}
