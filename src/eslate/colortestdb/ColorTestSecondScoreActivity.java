package eslate.colortestdb;

import java.text.SimpleDateFormat;
import java.util.Date;
import eslate.colorblind.CB_BlueActivity;
import eslate.colorblind.CB_RedActivity;
import eslate.colorblind.CB_YellowActivity;
import eslate.colortestdb.ColorTestSecondActivity_one;
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
import android.app.Dialog;
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
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

@SuppressLint({ "SimpleDateFormat", "NewApi" })

//this activity will display the testscore and also saved the record of test score in the database.
public class ColorTestSecondScoreActivity extends Activity {
	TextView t1;
	Animation animation;
	ImageView iv1,iv2,iv3,iv4;
	MediaPlayer mediaplayer,mediaPlayer2;
	private DatabaseAdapter dbHelper;
	public static final String MY_PREFS = "SharedPreferences";
	public int j=5;
	SimpleDateFormat sdf;
	String date;
	
	@SuppressWarnings("deprecation")
	
@Override
protected void onCreate(Bundle savedInstanceState) {
    	sdf = new SimpleDateFormat("yyyy-MM-dd_HH:mm");
		date = sdf.format(new Date());
		super.onCreate(savedInstanceState);
		setContentView(R.layout.score_activity);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		
		animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.si_blink);
		
		iv1 = (ImageView)findViewById(R.id.firework1);
		iv2 = (ImageView)findViewById(R.id.firework2);
		iv3 = (ImageView)findViewById(R.id.firework3);
		iv4 = (ImageView)findViewById(R.id.firework4);
		
		iv1.setVisibility(View.GONE);
		iv2.setVisibility(View.GONE);
		iv3.setVisibility(View.GONE);
		iv4.setVisibility(View.GONE);
		
		Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.score);
		mediaplayer=MediaPlayer.create(ColorTestSecondScoreActivity.this, path);
		mediaPlayer2=MediaPlayer.create(getApplicationContext(), R.raw.clap);
		SharedPreferences settings = getSharedPreferences(MY_PREFS,0);
		Editor editor = settings.edit();
		editor.putLong("uid", 0);
		editor.commit();
		dbHelper = new DatabaseAdapter(this);
		dbHelper.open();

		t1=(TextView)findViewById(R.id.t1);
		if(ColorTestSecondActivity_one.score==0)
		{
			t1.setText("गुण : 0 ");
		}
		if(ColorTestSecondActivity_one.score==1)
		{
			t1.setText("गुण : १");
		}
		if(ColorTestSecondActivity_one.score==2)
		{
			t1.setText("गुण : २");
		}
		if(ColorTestSecondActivity_one.score==3)
		{
			t1.setText("गुण : ३");
		}
		if(ColorTestSecondActivity_one.score==4)
		{
			t1.setText("गुण :  ४");
		}
		if(ColorTestSecondActivity_one.score==5)
		{
			t1.setText("गुण : ५");
		}
	
		t1.setTextSize(90);
		t1.setTypeface(null,Typeface.BOLD);
		//To insert the values of ColorBlind test
		if (CB_BlueActivity.blueColor==0 && CB_RedActivity.redColor==0 && CB_YellowActivity.yellowScore==0) {
			dbHelper.createColorBlindTestScore(0,0,0);	
		} 
		else {
			dbHelper.createColorBlindTestScore(CB_RedActivity.redColor, CB_YellowActivity.yellowScore,CB_BlueActivity.blueColor);
			CB_BlueActivity.blueColor=0;
			CB_RedActivity.redColor=0;
			CB_YellowActivity.yellowScore=0;
		}
		
		if (ColorTestSecondActivity_one.score>5) 
		{
			AlertDialog alertDialog = new AlertDialog.Builder(ColorTestSecondScoreActivity.this).create();
	        alertDialog.setTitle("Error");
	        alertDialog.setMessage("Multiple Instances are running");
	        alertDialog.setIcon(R.drawable.ic_launcher);
	        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
             public void onClick(DialogInterface dialog, int which) {
	            }
	        });
	        alertDialog.show();	
		    }
		   if (ColorTestSecondActivity_one.score==0) 
		   {
			dbHelper.createColorTestScore(date, ColorTestSecondActivity_one.ques1, ColorTestSecondActivity_two
			.ques2, ColorTestSecondActivity_three.ques3, ColorTestSecondActivity_four.ques4, ColorTestSecondActivity_five.ques5, 0, j);
				
			new CountDownTimer(10000, 5000) //10 second Timer
			{
			public void onTick(long l) 
			{
			if(ColorTestSecondActivity_one.score>3)
			{
					
				mediaplayer.start();
				mediaplayer.setOnCompletionListener(new OnCompletionListener() {
				
				@Override
				public void onCompletion(MediaPlayer mp) {
				mediaplayer.stop();
				mediaPlayer2.start();
				mediaPlayer2.setOnCompletionListener(new OnCompletionListener() {
					
				@Override
				public void onCompletion(MediaPlayer mp) {
				mediaPlayer2.stop();
				mediaPlayer2.release();
						
					}
				});
						
					}
				});
				iv1.setVisibility(View.VISIBLE);
				iv2.setVisibility(View.VISIBLE);
				iv3.setVisibility(View.VISIBLE);
				iv4.setVisibility(View.VISIBLE);
				
				iv1.startAnimation(animation);
				iv2.startAnimation(animation);
				iv3.startAnimation(animation);
				iv4.startAnimation(animation);
				CB_BlueActivity.blueColor=0;
				CB_RedActivity.redColor=0;
				CB_YellowActivity.yellowScore=0;
				ColorTestSecondActivity_one.ques1=0;
				ColorTestSecondActivity_two.ques2=0;
				ColorTestSecondActivity_three.ques3=0;
				ColorTestSecondActivity_four.ques4=0;
				ColorTestSecondActivity_five.ques5=0;
				ColorTestSecondActivity_one.score=0;			
				}
			}
			@Override
			public void onFinish() 
			{	
				animation.cancel();
				mediaplayer.stop();
				mediaplayer.release();
				
				Intent intent=new Intent(ColorTestSecondScoreActivity.this,eslate.preparation.main.Eslate_preparatrion_MainActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
				finish();
				};
			}.start();		
			}
		else
		{
			dbHelper.createColorTestScore(date, ColorTestSecondActivity_one.ques1, ColorTestSecondActivity_two
			.ques2, ColorTestSecondActivity_three.ques3, ColorTestSecondActivity_four.ques4, ColorTestSecondActivity_five.ques5, ColorTestSecondActivity_one.score, j);
					
			new CountDownTimer(10000, 5000) //10 second Timer
				{
		        public void onTick(long l) 
		       {
			   	if(ColorTestSecondActivity_one.score>3)
			   {
				
			   		mediaplayer.start();
			   		mediaplayer.setOnCompletionListener(new OnCompletionListener() {
						
					@Override
					public void onCompletion(MediaPlayer mp) {
					mediaplayer.stop();
					mediaPlayer2.start();
					mediaPlayer2.setOnCompletionListener(new OnCompletionListener() {
						
					@Override
					public void onCompletion(MediaPlayer mp) {
					mediaPlayer2.stop();
					
						}
					});
							
						}
					});
					iv1.setVisibility(View.VISIBLE);
					iv2.setVisibility(View.VISIBLE);
					iv3.setVisibility(View.VISIBLE);
					iv4.setVisibility(View.VISIBLE);
					
					iv1.startAnimation(animation);
					iv2.startAnimation(animation);
					iv3.startAnimation(animation);
					iv4.startAnimation(animation);
					CB_BlueActivity.blueColor=0;
					CB_RedActivity.redColor=0;
					CB_YellowActivity.yellowScore=0;
					ColorTestSecondActivity_one.ques1=0;
					ColorTestSecondActivity_two.ques2=0;
					ColorTestSecondActivity_three.ques3=0;
					ColorTestSecondActivity_four.ques4=0;
					ColorTestSecondActivity_five.ques5=0;
					ColorTestSecondActivity_one.score=0;		
			   		}
		       }
		        @Override
		        public void onFinish() 
		        {	
		        	animation.cancel();
		        	mediaplayer.stop();
		        	mediaplayer.release();
		        	
		        	Intent intent=new Intent(ColorTestSecondScoreActivity.this,eslate.preparation.main.Eslate_preparatrion_MainActivity.class);
		        	intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		        	startActivity(intent);
		        	finish();
		        	};
				}.start();
		}
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
				animation.cancel();
				mediaplayer.stop();
			}
		 //if home button is clicked then it will swich to home screen that is in our case eslate_preparation_MainActivity
		Intent intent1=new Intent(ColorTestSecondScoreActivity.this,eslate.preparation.main.Eslate_preparatrion_MainActivity.class);
	 	intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(intent1);
		finish();
		return true;
		}
		}
		return super.onOptionsItemSelected(item);
	}
@SuppressLint("InlinedApi")
@Override
public void onBackPressed() {
	 final Dialog dialog = new Dialog(ColorTestSecondScoreActivity.this,AlertDialog.THEME_HOLO_LIGHT);
     dialog.requestWindowFeature(Window.FEATURE_LEFT_ICON);
  //   dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
     // Include dialog.xml file
     dialog.setContentView(R.layout.dialog);
     int width = getResources().getDimensionPixelSize(R.dimen.popup_width);
     int height = getResources().getDimensionPixelSize(R.dimen.popup_height);        
     dialog.getWindow().setLayout(width, height);
     /***http://stackoverflow.com/questions/15173855/android-alertdialog-with-custom-view-and-rounded-corners***/
     dialog.setFeatureDrawableResource(Window.FEATURE_LEFT_ICON,R.drawable.logo);
     // Set dialog title
     dialog.setTitle("Quit");
     // set values for custom dialog components - text, image and button
     TextView text = (TextView) dialog.findViewById(R.id.textDialog);
     text.setText("Do You Want to Quit???");
     text.setTypeface(null, Typeface.BOLD);
     text.setTextColor(Color.WHITE);
   //  ImageView image = (ImageView) dialog.findViewById(R.id.imageDialog);
  //   image.setImageResource(R.drawable.quit);
     dialog.show();
     Button declineButton = (Button) dialog.findViewById(R.id.declineButton);
     // if decline button is clicked, close the custom dialog
     declineButton.setOnClickListener(new OnClickListener() {
         @Override
         public void onClick(View v) {
             // Close dialog
             dialog.dismiss();
         }
     });
     Button acceptButton = (Button)dialog.findViewById(R.id.acceptButton);
     acceptButton.setOnClickListener(new OnClickListener() {	
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if (mediaplayer.isPlaying()) {
				mediaplayer.stop();
				mediaplayer.release();
			}
			finish();
			System.exit(0);
			}
     	});
	} 
}

