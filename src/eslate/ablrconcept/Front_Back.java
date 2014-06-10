package eslate.ablrconcept;

import eslate.ablrconcepttest.ABLRtest1_Activity;
import eslate.main.R;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;


//Above below concept second Activity
public class Front_Back extends Activity {
//	ImageView table, bottle, cat;
	MediaPlayer mediaplayer;
	VideoView view;
	Button next;
	@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //Layout of this activity
    setContentView(R.layout.welcome_layout);
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    
    mediaplayer=MediaPlayer.create(getApplicationContext(), R.raw.front_back_mp);
    
    next = (Button)findViewById(R.id.welcome_next);
    next.setVisibility(View.GONE);
    
	view = (VideoView)findViewById(R.id.videoView1);
	String path = "android.resource://"+getPackageName()+"/"+R.raw.front_back;
	view.setVideoURI(Uri.parse(path));
	MediaController controller=new MediaController(this);
	view.setMediaController(controller);
	view.start();
	mediaplayer.start();
	
	view.setOnCompletionListener(new OnCompletionListener() {
	@Override
	public void onCompletion(MediaPlayer mp) {
		// TODO Auto-generated method stub
			view.stopPlayback();
		mediaplayer.stop();
		mediaplayer.release();
		
		 Intent act1 = new Intent(Front_Back.this,ABLRtest1_Activity.class);
		 act1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		 startActivity(act1);
		 finish();
		}
	});
	}
 	
   /* table = (ImageView)findViewById(R.id.table);
    bottle = (ImageView)findViewById(R.id.bottle);
    cat= (ImageView)findViewById(R.id.cat);
    bottle.setVisibility(View.GONE);
    cat.setVisibility(View.GONE);
    table.setVisibility(View.VISIBLE);
	Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.congrats);
	mediaplayer=MediaPlayer.create(ABactivity2.this, path);
	mediaplayer.start();
	mediaplayer.setOnCompletionListener(new OnCompletionListener() {
	@Override
public void onCompletion(MediaPlayer mp) {
	mediaplayer.stop();
	mediaplayer.release();
	bottle.setVisibility(View.VISIBLE);
	cat.setVisibility(View.GONE);
	table.setVisibility(View.VISIBLE);
	Uri path1=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sevensec);
	mediaplayer=MediaPlayer.create(ABactivity2.this, path1);
	mediaplayer.start();
	mediaplayer.setOnCompletionListener(new OnCompletionListener() {
	@Override
public void onCompletion(MediaPlayer mp) {
	mediaplayer.stop();
	bottle.setVisibility(View.GONE);
	cat.setVisibility(View.VISIBLE);
	Uri path2=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sevensec);
	mediaplayer=MediaPlayer.create(ABactivity2.this, path2);
	mediaplayer.start();
	mediaplayer.setOnCompletionListener(new OnCompletionListener() {
@Override
public void onCompletion(MediaPlayer mp) {
	mediaplayer.stop();
	//after completion of this audio it will automatically switch to Left Right concept activity
	Intent intent=new Intent(ABactivity2.this,LRactivity1.class);
	startActivity(intent);
	finish();
	   }
	});
       }
	});
	   }
	});
   }	*/
@Override
public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
		}
@Override
public boolean onOptionsItemSelected(MenuItem item) {

	switch (item.getItemId()) {
	case R.id.home:
	{
		mediaplayer.stop();
		mediaplayer.release();
	//if home button is clicked then it will swich to home screen nthat is in our case eslate_preparation_MainActivity								
	Intent intent1=new Intent(Front_Back.this,eslate.preparation.main.Eslate_preparatrion_MainActivity.class);
	startActivity(intent1);
	finish();
	return true;
							}
	}
	return super.onOptionsItemSelected(item);
}   
@Override
public void onBackPressed() {
	finish();
	System.exit(0);
} 
}