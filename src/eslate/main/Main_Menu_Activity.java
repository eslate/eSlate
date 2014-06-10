package eslate.main;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import eslate.main.R;

public class Main_Menu_Activity extends Activity{
	Button mulakshare_btn,number_btn,prepare_btn;
	MediaPlayer mediaPlayer;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        
		super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu_layout);
        
       //setting a path of audio
        mediaPlayer=MediaPlayer.create(getApplicationContext(), R.raw.mainmenu);
        mediaPlayer.start();
        
    	
        //setting screen to portrait mode when launched
	    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
	    //getting refrence from a xml file.
	    mulakshare_btn = (Button)findViewById(R.id.menu_mulakshare);
	    number_btn = (Button)findViewById(R.id.menu_number);
	    prepare_btn = (Button)findViewById(R.id.prepare_btn);
	    
/*	    mulakshare_btn.setEnabled(false);
	    number_btn.setEnabled(false);
	    prepare_btn.setEnabled(false);*/
	    
	    mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
		@Override
		public void onCompletion(MediaPlayer mp) {
/*		mulakshare_btn.setEnabled(true);
		number_btn.setEnabled(true);
		prepare_btn.setEnabled(true);*/
				
			}
		});
	    
	    mulakshare_btn.setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View v) {
			if (mediaPlayer.isPlaying()) {
				mediaPlayer.stop();
				mediaPlayer.release();
			}
			// TODO Auto-generated method stub
			Intent mulakshare = new Intent(Main_Menu_Activity.this, eslate.learnaplha.MarathiAlpha_Main_Activity.class);
			mulakshare.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(mulakshare);
			finish();
			}
		});
	    number_btn.setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View v) {
			if (mediaPlayer.isPlaying()) {
				mediaPlayer.stop();
				mediaPlayer.release();
			}
			// TODO Auto-generated method stub
			Intent number = new Intent(Main_Menu_Activity.this, eslate.numberlearning.NL_Main_Activity.class);
			number.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(number);
			finish();
			}
		});
	    
	   
	    prepare_btn.setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View v) {
			if (mediaPlayer.isPlaying()) {
				mediaPlayer.stop();
				mediaPlayer.release();
			}
			// TODO Auto-generated method stub
			Intent prepare = new Intent(Main_Menu_Activity.this, eslate.preparation.main.Eslate_preparatrion_MainActivity.class);
			prepare.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(prepare);
			finish();
			}
		});
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
/***if home button is clicked then it will switch to home screen that is in 
 * our case eslate_preparation_MainActivity
 */		if (mediaPlayer.isPlaying()) {
	 		mediaPlayer.stop();
	 		mediaPlayer.release();
 			}
    	Intent home=new Intent(Main_Menu_Activity.this,Main_Menu_Activity.class);
    	home.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    	startActivity(home);
    	finish();
    	return true;
    	}
    	}
    	return super.onOptionsItemSelected(item);
    }
@Override
public void onBackPressed() {
	 final Dialog dialog = new Dialog(Main_Menu_Activity.this,AlertDialog.THEME_HOLO_LIGHT);
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
			if (mediaPlayer.isPlaying()) {
				mediaPlayer.stop();
				mediaPlayer.release();
			}
			System.exit(0);
			finish();
			}
     	});
	} 
}