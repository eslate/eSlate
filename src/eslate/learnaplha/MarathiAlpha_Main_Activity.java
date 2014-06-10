package eslate.learnaplha;

import eslate.main.R;
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
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Typeface;

public class MarathiAlpha_Main_Activity extends Activity implements OnClickListener {
	Button menu_swar,menu_vyanjan,skip;
	MediaPlayer mediaplayer;
	boolean hasonce =false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.marathiletter_main_layout);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		
		menu_swar = (Button)findViewById(R.id.swar_menu);
		menu_swar.setOnClickListener(this);
		
		menu_vyanjan = (Button)findViewById(R.id.vyanjan_menu);
		menu_vyanjan.setOnClickListener(this);
		
		skip = (Button)findViewById(R.id.alpha_skip);
		skip.setOnClickListener(this);
		
		/*menu_swar.setEnabled(false);
		menu_vyanjan.setEnabled(false);
		skip.setEnabled(false);*/
		
		Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.alpha_intro);
		mediaplayer=MediaPlayer.create(MarathiAlpha_Main_Activity.this, path);
		mediaplayer.start();
		mediaplayer.setOnCompletionListener(new OnCompletionListener() {
		@Override
		public void onCompletion(MediaPlayer mp) {
			mediaplayer.stop();
			
/*			menu_swar.setEnabled(true);
			menu_vyanjan.setEnabled(true);
			skip.setEnabled(true);*/
			}
		});
		
	}
	@Override
	public void onClick(final View v) {
		// TODO Auto-generated method stub	
	if(hasonce==false){
		hasonce=true;
		switch (v.getId()) {
		case R.id.swar_menu:
			if (mediaplayer.isPlaying()) {
				mediaplayer.stop();
				mediaplayer.release();
			}
			Intent swar = new Intent(MarathiAlpha_Main_Activity.this, Marathi_Swar_Activity.class);
			swar.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(swar);
			finish();
			break;
		
		case R.id.vyanjan_menu:
			if (mediaplayer.isPlaying()) {
				mediaplayer.stop();
				mediaplayer.release();
			}
			Intent vyanjan = new Intent(MarathiAlpha_Main_Activity.this, Marathi_Vyanjan_Activity.class);
			vyanjan.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(vyanjan);
			finish();
		default:
			break;
		
		case R.id.alpha_skip:
			if (mediaplayer.isPlaying()) {
				mediaplayer.stop();
				mediaplayer.release();
			}
			Intent skip = new Intent(MarathiAlpha_Main_Activity.this, eslate.drawletter.LetterVideo.class);
			skip.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(skip);
			finish();
			}
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
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
		Intent home=new Intent(MarathiAlpha_Main_Activity.this,eslate.main.Main_Menu_Activity.class);
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
		 final Dialog dialog = new Dialog(MarathiAlpha_Main_Activity.this,AlertDialog.THEME_HOLO_LIGHT);
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
				System.exit(0);
				finish();
				}
	     	});
		} 
	}

