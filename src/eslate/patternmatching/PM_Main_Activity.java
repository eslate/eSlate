package eslate.patternmatching;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import eslate.main.R;
import eslate.videotrack.database.VideoDatabaseHandler;

public class PM_Main_Activity extends Activity{
	Button skip;
	//MediaPlayer mediaplayer;
	CountDownTimer timer ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setting layout for first Activity
		setContentView(R.layout.pm_main_activity_layout);
		//To keep screen orientation Landscape only so the screen will not rotate
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		
		timer = new CountDownTimer(5000, 5000) {
			public void onTick(long millisUntilFinished) { 
			}
			public void onFinish() {
				Intent next = new Intent(PM_Main_Activity.this, PM_Activity1.class);
				next.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(next);
				finish();
				}
			}.start();
			
		skip = (Button)findViewById(R.id.pm_skip);
		skip.setVisibility(View.GONE);
		VideoDatabaseHandler handler=new VideoDatabaseHandler(this);
		int count=handler.getablrIDCOunt();
		if(count==1)
		{
			skip.setVisibility(View.VISIBLE);
		}
		handler.close();
		skip.setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View v) {
			/*// TODO Auto-generated method stub
			if (mediaplayer.isPlaying()) {
				mediaplayer.stop();
				mediaplayer.release();
			}*/
			timer.cancel();
			Intent skip = new Intent(PM_Main_Activity.this, eslate.patterndiffering.Pattern_Diff_Main_Activity.class);
			skip.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(skip);
			finish();
			}
		});
		
		/*Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.congrats_old);
		mediaplayer=MediaPlayer.create(PM_Main_Activity.this, path);
		mediaplayer.start();
		mediaplayer.setOnCompletionListener(new OnCompletionListener() {
		@Override
		public void onCompletion(MediaPlayer mp) {
				// TODO Auto-generated method stub
				mediaplayer.stop();
				mediaplayer.release();
				Intent next = new Intent(PM_Main_Activity.this, PM_Activity1.class);
				next.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(next);
				finish();
			}
		});*/
	}
    @Override
public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
	   }
    //after selecting the appropriate  menu item this method will invoked
@Override
public boolean onOptionsItemSelected(MenuItem item) {

    	switch (item.getItemId()) {
    	case R.id.home:
    	{timer.cancel();
    		/*if (mediaplayer.isPlaying()) {
				mediaplayer.stop();
				mediaplayer.release();
			}*/
    	//if home button is clicked then it will swich to home screen that is in our case eslate_preparation_MainActivity
    	Intent intent1=new Intent(PM_Main_Activity.this,eslate.preparation.main.Eslate_preparatrion_MainActivity.class);
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

