package eslate.shapetestsecond;

import java.text.SimpleDateFormat;
import java.util.Date;

import eslate.db.DatabaseAdapter;
import eslate.main.R;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

@SuppressLint("SimpleDateFormat")
//this is score activity for shapetest which will save the record in database and display it to a student
public class ShapeScoreActivity extends Activity {
	TextView t1;
	private DatabaseAdapter dbHelper;
	public static final String MY_PREFS = "SharedPreferences";
	//total no of question are 4
	public int j=4;
	SimpleDateFormat sdf;
	String date;
	
	Animation animation;
	ImageView iv1,iv2,iv3,iv4;
	MediaPlayer mediaplayer,mediaPlayer2;

	@SuppressWarnings("deprecation")
@Override
protected void onCreate(Bundle savedInstanceState) {
	sdf = new SimpleDateFormat("yyyy-MM-dd_HH:mm");
	// to get system current date
	date = sdf.format(new Date());
	super.onCreate(savedInstanceState);
	setContentView(R.layout.score_activity);
	setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
	
	iv1 = (ImageView)findViewById(R.id.firework1);
	iv1.setVisibility(View.GONE);
	
	iv2 = (ImageView)findViewById(R.id.firework2);
	iv2.setVisibility(View.GONE);
	
	iv3 = (ImageView)findViewById(R.id.firework3);
	iv3.setVisibility(View.GONE);
	
	iv4 = (ImageView)findViewById(R.id.firework4);
	iv4.setVisibility(View.GONE);
	
	Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.clap);
	mediaplayer=MediaPlayer.create(ShapeScoreActivity.this, path);
	

	Uri path1=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.score);
	mediaPlayer2=MediaPlayer.create(ShapeScoreActivity.this, path1);
	
	animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.si_blink);
	
	SharedPreferences settings = getSharedPreferences(MY_PREFS,0);
	Editor editor = settings.edit();
	editor.putLong("uid", 0);
	editor.commit();
	dbHelper = new DatabaseAdapter(this);
	dbHelper.open();
	t1=(TextView)findViewById(R.id.t1);
	//t1.setText("गुण :"+String.valueOf(ShapeTestSecondOneActivity.score));
	if(ShapeTestSecondOneActivity.score==0)
	{
		t1.setText("गुण : ०");
	}
	if(ShapeTestSecondOneActivity.score==1)
	{
		t1.setText("गुण : १");
	}
	if(ShapeTestSecondOneActivity.score==2)
	{
		t1.setText("गुण : २");
	}
	if(ShapeTestSecondOneActivity.score==3)
	{
		t1.setText("गुण : ३");
	}
	if(ShapeTestSecondOneActivity.score==4)
	{
		t1.setText("गुण :  ४");
	}
	t1.setTextSize(90);
	t1.setTextColor(Color.BLACK);
	t1.setTypeface(null,Typeface.BOLD);
	if (ShapeTestSecondOneActivity.score>4) {
	AlertDialog alertDialog = new AlertDialog.Builder(ShapeScoreActivity.this).create();
	alertDialog.setTitle("Error");
	alertDialog.setMessage("Multiple Instances are running");
	alertDialog.setIcon(R.drawable.logo);
	alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
		public void onClick(DialogInterface dialog, int which) {
		}
    });
	alertDialog.show();
		}
	else 
		if (ShapeTestSecondOneActivity.score==0) {
			//query to insert value in database
			dbHelper.createShapeTestScore(date, ShapeTestSecondOneActivity.ques1, ShapeTestSecondTwoActivity.ques2, ShapeTestSecondThreeActivity.ques3, ShapeTestSecondFourActivity.ques4, 0, j);
			//reset the value
			
			}
		else {
			dbHelper.createShapeTestScore(date, ShapeTestSecondOneActivity.ques1, ShapeTestSecondTwoActivity.ques2, ShapeTestSecondThreeActivity.ques3, ShapeTestSecondFourActivity.ques4, ShapeTestSecondOneActivity.score, j);
			
					  }
		@SuppressWarnings("unused")
		CountDownTimer timer = new CountDownTimer(10000, 5000) //10 second Timer
        {
public void onTick(long l) 
            {
	
	if(ShapeTestSecondOneActivity.score>=3)
	{
		    mediaPlayer2.start();
		    mediaPlayer2.setOnCompletionListener(new OnCompletionListener() {
				
			@Override
			public void onCompletion(MediaPlayer mp) {
			mediaPlayer2.stop();
			mediaPlayer2.release();
			mediaplayer.start();
					
				}
			});
            iv1.setVisibility(View.VISIBLE);	
			iv1.startAnimation(animation);
			iv2.setVisibility(View.VISIBLE);
			iv2.startAnimation(animation);
			iv3.setVisibility(View.VISIBLE);
			iv3.startAnimation(animation);
			iv4.setVisibility(View.VISIBLE);
			iv4.startAnimation(animation);
			ShapeTestSecondOneActivity.score=0;
			ShapeTestSecondOneActivity.ques1=0;
			ShapeTestSecondTwoActivity.ques2=0;
			ShapeTestSecondThreeActivity.ques3=0;
			ShapeTestSecondFourActivity.ques4=0;
            }
       }
@Override
public void onFinish() 
	{
	//afetr 10 sec it will switch to home screen
	animation.cancel();
	mediaplayer.stop();
	mediaplayer.release();
	mediaPlayer2.release();
	
	Intent intent=new Intent(ShapeScoreActivity.this, eslate.preparation.main.Eslate_preparatrion_MainActivity.class);
	intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	startActivity(intent);
	finish();
            };
        }.start();
	}
@Override
public boolean onCreateOptionsMenu(Menu menu) {
	getMenuInflater().inflate(R.menu.main, menu);
	return true;
		}
@Override
public boolean onOptionsItemSelected(MenuItem item) {
	switch (item.getItemId()) {
	case android.R.id.home:
	{if (animation.hasStarted()) {
		animation.cancel();
	}
		if (mediaplayer.isPlaying()) {
			mediaplayer.stop();
			mediaplayer.release();
		}
		if (mediaPlayer2.isPlaying()) {
			mediaPlayer2.stop();
			mediaPlayer2.release();
		}
		
		
	Intent intent1=new Intent(ShapeScoreActivity.this,eslate.preparation.main.Eslate_preparatrion_MainActivity.class);
	intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
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