package eslate.ablrtestdata;

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

@SuppressLint("SimpleDateFormat")
//this is ablrscoreactivity which display score to student of this test
public class ABLRScoreActivity extends Activity {
	TextView t1;
	//declaring refrence variable of DatabaseAdapter
	ImageView iv1,iv2,iv3,iv4;
	Animation animation;
	MediaPlayer mediaPlayer,mediaPlayer2;
	private DatabaseAdapter dbHelper;
	public static final String MY_PREFS = "SharedPreferences";
	//this variable is for Total no of questions since here 6 questions its value is 6
	public int j=6;
	SimpleDateFormat sdf;
	String date;
	
	@SuppressWarnings("deprecation")
	@Override
protected void onCreate(Bundle savedInstanceState) {
	sdf = new SimpleDateFormat("yyyy-MM-dd_HH:mm");
	//to get current system Date
	date = sdf.format(new Date());
	super.onCreate(savedInstanceState);
	setContentView(R.layout.score_activity);
	setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
	animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.si_blink);

	iv1 = (ImageView)findViewById(R.id.firework1);
	iv2 = (ImageView)findViewById(R.id.firework2);
	iv3 = (ImageView)findViewById(R.id.firework3);
	iv4 = (ImageView)findViewById(R.id.firework4);
	
	Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.score);
	mediaPlayer=MediaPlayer.create(ABLRScoreActivity.this, path);
	mediaPlayer2=MediaPlayer.create(getApplicationContext(), R.raw.clap);
	
	iv1.setVisibility(View.GONE);
	iv2.setVisibility(View.GONE);
	iv3.setVisibility(View.GONE);
	iv4.setVisibility(View.GONE);

	SharedPreferences settings = getSharedPreferences(MY_PREFS,0);
	Editor editor = settings.edit();
	editor.putLong("uid", 0);
	editor.commit();
	dbHelper = new DatabaseAdapter(this);
	//by opening the database here we are ready to do operations on the database.
	dbHelper.open();
	//taking a textview to display the score interms of text.
	t1=(TextView)findViewById(R.id.t1);
	t1.setText(String.valueOf(ABTest1.score));
	if(ABTest1.score==0)
	{
		t1.setText("गुण : 0 ");
	}
	if(ABTest1.score==1)
	{
		t1.setText("गुण : १");
	}
	if(ABTest1.score==2)
	{
		t1.setText("गुण : २");
	}
	if(ABTest1.score==3)
	{
		t1.setText("गुण : ३");
	}
	if(ABTest1.score==4)
	{
		t1.setText("गुण :  ४");
	}
	if(ABTest1.score==5)
	{
		t1.setText("गुण : ५");
	}
	if(ABTest1.score==6)
	{
		t1.setText("गुण : ६");
	}
	t1.setTextSize(90);
	if (ABTest1.score>6) {
			AlertDialog alertDialog = new AlertDialog.Builder(ABLRScoreActivity.this).create();
	        alertDialog.setTitle("Error");
	        alertDialog.setMessage("Multiple Instances are running");
	        alertDialog.setIcon(R.drawable.ic_launcher);
	        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
	  public void onClick(DialogInterface dialog, int which) {
	     }
     });
	 alertDialog.show();
		 }
	else 
		//if student score is zero then value zero along with other fields  inserted into the database
		if (ABTest1.score==0) {
				dbHelper.createABLRTestScore(date, ABTest1.ques1,ABTest2.ques2,ABTest3.ques3,LRTest1.ques4,LRTest2.ques5,LRTest3.ques6,0, j);

			new CountDownTimer(10000, 5000) //10 second Timer
		        {
			public void onTick(long l) 
			     {
				if(ABTest1.score>3)
				{
					
				mediaPlayer.start();
				mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
				@Override
				public void onCompletion(MediaPlayer mp) {
				mediaPlayer.stop();
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
					
				ABTest1.score=0;
				ABTest1.ques1=0;
				ABTest2.ques2=0;
				ABTest3.ques3=0;
				LRTest1.ques4=0;
				LRTest2.ques5=0;
				LRTest3.ques6=0;
		    }
			         }
		@Override
	    public void onFinish() 
		{	
			mediaPlayer.release();
			mediaPlayer2.release();
		dbHelper.close();				
		Intent intent=new Intent(ABLRScoreActivity.this,eslate.preparation.main.Eslate_preparatrion_MainActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(intent);
		finish();
	  	};
	  	}.start();
			
		}
		else {
			dbHelper.createABLRTestScore(date, ABTest1.ques1,ABTest2.ques2,ABTest3.ques3,LRTest1.ques4,LRTest2.ques5,LRTest3.ques6,ABTest1.score, j);
		new CountDownTimer(10000, 5000) //10 second Timer
		        {
		
		public void onTick(long l) 
		{
		
		if(ABTest1.score>3)
		{
			mediaPlayer.start();
			mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
				
		@Override
		public void onCompletion(MediaPlayer mp) {
			mediaPlayer.stop();
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
						
						ABTest1.score=0;
						ABTest1.ques1=0;
						ABTest2.ques2=0;
						ABTest3.ques3=0;
						LRTest1.ques4=0;
						LRTest2.ques5=0;
						LRTest3.ques6=0;
						
						
				     }
			         }
			      @Override
			        public void onFinish() 
			            {	
							mediaPlayer.release();
							mediaPlayer2.release();
							
			            	Intent intent=new Intent(ABLRScoreActivity.this,eslate.preparation.main.Eslate_preparatrion_MainActivity.class);
			            	intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			            	startActivity(intent);
			            	finish();
			            	
			            };
			        }.start();
				
			}
	@SuppressWarnings("unused")
	CountDownTimer timer = new CountDownTimer(5000, 5000) //10 second Timer
    {
     public void onTick(long l)
     {
    	 
     }
      @Override
      public void onFinish() 
            {
    	  if (mediaPlayer.isPlaying()) {
    		  mediaPlayer.stop();
    		  mediaPlayer.release();
    	  	}
    	  if (mediaPlayer2.isPlaying()) {
    		  mediaPlayer2.release();
    	  }
            Intent intent=new Intent(ABLRScoreActivity.this, eslate.preparation.main.Eslate_preparatrion_MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
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
		{
	    	  if (mediaPlayer.isPlaying()) {
	    		  mediaPlayer.stop();
	    		  mediaPlayer.release();
	    	  	}
	    	  if (mediaPlayer2.isPlaying()) {
	    		  mediaPlayer2.release();
	    	  }
		Intent home=new Intent(ABLRScoreActivity.this,eslate.preparation.main.Eslate_preparatrion_MainActivity.class);
		home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(home);
		finish();
		return true;
								}
		}
		return super.onOptionsItemSelected(item);
	}

@Override
public void onBackPressed() {
	 final Dialog dialog = new Dialog(ABLRScoreActivity.this,AlertDialog.THEME_HOLO_LIGHT);
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
			if (mediaPlayer.isPlaying()) {
				mediaPlayer.stop();
				mediaPlayer.release();
			}
			finish();
			System.exit(0);
			}
     	});
	}
}
