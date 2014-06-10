package eslate.ablrconcept;	

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
import android.widget.ImageView;

//this activity is for Left Right concept
public class LRactivity1 extends Activity {
    ImageView car, home, dog;
	MediaPlayer mediaplayer;

	@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.lractivity1);
	setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

	//getting refrences of all imageviews
	car = (ImageView)findViewById(R.id.car);
	home = (ImageView)findViewById(R.id.home);
	dog = (ImageView)findViewById(R.id.dog);
	home.setVisibility(View.VISIBLE);
	car.setVisibility(View.GONE);
	dog.setVisibility(View.GONE);
	Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.congrats);
	mediaplayer=MediaPlayer.create(LRactivity1.this, path);
	//mediaplayer will start
	mediaplayer.start();
	mediaplayer.setOnCompletionListener(new OnCompletionListener() {
	@Override
public void onCompletion(MediaPlayer mp) {
	mediaplayer.stop();
	home.setVisibility(View.VISIBLE);
	car.setVisibility(View.VISIBLE);
	dog.setVisibility(View.GONE);
	Uri path1=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sevensec);
	mediaplayer=MediaPlayer.create(LRactivity1.this, path1);
	mediaplayer.start();
	mediaplayer.setOnCompletionListener(new OnCompletionListener() {
	@Override
public void onCompletion(MediaPlayer mp) {
	mediaplayer.stop();
	home.setVisibility(View.VISIBLE);
	car.setVisibility(View.GONE);
	dog.setVisibility(View.VISIBLE);		 
	Uri path2=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.congrats);
	mediaplayer=MediaPlayer.create(LRactivity1.this, path2);
	mediaplayer.start();
	mediaplayer.setOnCompletionListener(new OnCompletionListener() {
	@Override
public void onCompletion(MediaPlayer mp) {
	mediaplayer.stop();
	//after completion of these audio it will automatically switch to left-Right concept second activity
	Intent intent=new Intent(LRactivity1.this,LRactivity2.class);
	startActivity(intent);
	finish();
	   }
	});
	   }
	});
	   }
	});
       }
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
		//if home button is clicked then it will swich to home screen that is in our case eslate_preparation_MainActivity
		Intent intent1=new Intent(LRactivity1.this,eslate.preparation.main.Eslate_preparatrion_MainActivity.class);
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