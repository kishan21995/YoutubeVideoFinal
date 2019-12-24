package com.app.youtubefinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends YouTubeBaseActivity {

    private  static final String TAG="MainActivity";
    YouTubePlayerView mYouTubePlayerView;
    Button btnPlay;
    YouTubePlayer.OnInitializedListener mOnInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"onCreate: Starting.");

        btnPlay=(Button)findViewById(R.id.btnPlay);
        mYouTubePlayerView=(YouTubePlayerView)findViewById(R.id.youtubePlay);
        mOnInitializedListener=new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Log.d(TAG,"onClick: Done initializing.");
                //List<String>videoList=new ArrayList<>();
               // videoList.add("");
                //videoList.add("");
                //youTubePlayer.loadVideo(videoList);
/*
                youTubePlayer.loadVideo("sNQzqjrk1yI");
*/

                //youTubePlayer.loadVideo("zzCWCPK1grY");
                youTubePlayer.loadPlaylist("PLlxmoA0rQ-LwgK1JsnMsakYNACYGa1cjR");

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d(TAG,"onClick: Failed to initialize.");

            }
        };

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"onClick: Initializing Youtube Player.");
                mYouTubePlayerView.initialize(YouTubeConfig.getApiKey(),mOnInitializedListener);
            }
        });

    }
}
