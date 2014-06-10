package eslate.preparation.main;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import eslate.ablrconcepttest.ABLRtest1_Activity;
import eslate.ablrconcepttest.ABLRtest4_Activity;
import eslate.colortest.ColorTestOneActivity;
import eslate.colortest.ColorTestSixActivity;
import eslate.main.R;
import eslate.shapetest.ShapeTestEightActivity;

@SuppressLint("InlinedApi")
public class Exam_Activity extends Activity{

	MediaPlayer mediaplayer;
@Override
protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.exam_activity_layout);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		
		//call ABLR test with database
		if (ABLRtest4_Activity.exam==1||ABLRtest1_Activity.exam==1) {
			Uri path0=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.ablrtest_intro);
			mediaplayer=MediaPlayer.create(Exam_Activity.this, path0);
			mediaplayer.start();
			mediaplayer.setOnCompletionListener(new OnCompletionListener() {
			@Override
			public void onCompletion(MediaPlayer mp) {
				// TODO Auto-generated method stub
				mediaplayer.stop();
				mediaplayer.release();
				
				Intent next1 = new Intent(Exam_Activity.this, eslate.ablrtestdata.ABTest1.class);
				next1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(next1);
				finish();
				}
			});
		}
		//call color test with database
		if (ColorTestSixActivity.exam==2 || ColorTestOneActivity.exam==2) {
			Uri path1=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.colour_db_test);
			mediaplayer=MediaPlayer.create(Exam_Activity.this, path1);
			mediaplayer.start();
			mediaplayer.setOnCompletionListener(new OnCompletionListener() {
			@Override
			public void onCompletion(MediaPlayer mp) {
				// TODO Auto-generated method stub
				mediaplayer.stop();
				mediaplayer.release();
				
				Intent next2 = new Intent(Exam_Activity.this, eslate.colortestdb.ColorTestSecondActivity_one.class);
				next2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(next2);
				finish();
				}
			});
		}
			//call shape test with database
		if (ShapeTestEightActivity.exam==3) {
			Uri path3=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.shapetestdb_intro);
			mediaplayer=MediaPlayer.create(Exam_Activity.this, path3);
			mediaplayer.start();
			mediaplayer.setOnCompletionListener(new OnCompletionListener() {
			@Override
			public void onCompletion(MediaPlayer mp) {
				// TODO Auto-generated method stub
				mediaplayer.stop();
				mediaplayer.release();
				
				Intent next3 = new Intent(Exam_Activity.this, eslate.shapetestsecond.ShapeTestSecondOneActivity.class);
				next3.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(next3);
				finish();
				}
			});
		}
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
	{
	if (mediaplayer.isPlaying()) {
		mediaplayer.stop();
		mediaplayer.release();
	}
		
	//if home button is clicked then it will switch to home screen that is in our case eslate_preparation_MainActivity
	Intent home=new Intent(Exam_Activity.this,eslate.preparation.main.Eslate_preparatrion_MainActivity.class);
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
	 final Dialog dialog = new Dialog(Exam_Activity.this,AlertDialog.THEME_HOLO_LIGHT);
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
			if (mediaplayer.isPlaying()) {
				mediaplayer.stop();
				mediaplayer.release();
			}
			// TODO Auto-generated method stub
			System.exit(0);
			finish();
			}
     	});
	} 
}


