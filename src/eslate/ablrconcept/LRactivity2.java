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

//Left-Right concept Second Activity
public class LRactivity2 extends Activity {
	ImageView tree, butterfly, boy;
	MediaPlayer mediaplayer;

	@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	//setting layout of this activity
	setContentView(R.layout.lractivity2);
	setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

	tree = (ImageView)findViewById(R.id.tree);
	butterfly = (ImageView)findViewById(R.id.butterfly);
	boy = (ImageView)findViewById(R.id.boy);
	tree.setVisibility(View.VISIBLE);
	butterfly.setVisibility(View.GONE);
	boy.setVisibility(View.GONE);
    
	Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.congrats);
    mediaplayer=MediaPlayer.create(LRactivity2.this, path);
    mediaplayer.start();
    
    mediaplayer.setOnCompletionListener(new OnCompletionListener() {
    @Override
    public void onCompletion(MediaPlayer mp) {
    mediaplayer.stop();
    mediaplayer.release();
    
    tree.setVisibility(View.VISIBLE);
    boy.setVisibility(View.VISIBLE);
    butterfly.setVisibility(View.GONE);
    Uri path1=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sevensec);
    mediaplayer=MediaPlayer.create(LRactivity2.this, path1);
    mediaplayer.start();
    mediaplayer.setOnCompletionListener(new OnCompletionListener() {
    @Override
public void onCompletion(MediaPlayer mp) {
	mediaplayer.stop();
	mediaplayer.release();
	
	tree.setVisibility(View.VISIBLE);
	boy.setVisibility(View.GONE);
	butterfly.setVisibility(View.VISIBLE);	
	//since this is last activity from ABLR(Above Below Left Right) concept so it will switch to home activity
	Intent intent=new Intent(LRactivity2.this,eslate.ablrconcepttest.ABLRtest1_Activity.class);
	intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	startActivity(intent);
	finish();
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
    		if (mediaplayer.isPlaying()) {
    			mediaplayer.stop();
    			mediaplayer.release();
			}
    		
    								
    	//if home button is clicked then it will swich to home screen that is in our case eslate_preparation_MainActivity
    	Intent intent1=new Intent(LRactivity2.this,eslate.preparation.main.Eslate_preparatrion_MainActivity.class);
    	intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
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