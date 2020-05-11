package sg.edu.np.mad.week3;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    private static final String VIDEO_SAMPLE = "rabbid";
    MediaPlayer babyLaughMedia;
    private VideoView mVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mVideoView = findViewById(R.id.videoView);
        initializePlayer();
        babyLaughMedia = MediaPlayer.create(this, R.raw.baby_laughing);
        babyLaughMedia.start();


    }
    private Uri getMedia(String mediaName) {
        return Uri.parse("android.resource://" + getPackageName() +
                "/raw/" + mediaName);
    }
    private void initializePlayer() {
        Uri videoUri = getMedia(VIDEO_SAMPLE);
        mVideoView.setVideoURI(videoUri);
        mVideoView.start();
        releasePlayer();
    }
    private void releasePlayer() {
        mVideoView.stopPlayback();
    }
}
