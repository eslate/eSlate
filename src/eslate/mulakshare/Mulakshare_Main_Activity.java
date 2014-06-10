package eslate.mulakshare;

import eslate.main.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
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
import android.widget.ListView;
import android.widget.TextView;

public class Mulakshare_Main_Activity extends Activity {
	private CharSequence mTitle;
	public static MediaPlayer mediaplayer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mulakshare_activity_main);
		 //setting screen to portrait mode when launched
	    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		
		Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.alpha_chart);
		mediaplayer=MediaPlayer.create(Mulakshare_Main_Activity.this, path);
		mediaplayer.start();
		mediaplayer.setOnCompletionListener(new OnCompletionListener() {
		@Override
		public void onCompletion(MediaPlayer mp) {
			// TODO Auto-generated method stub
			mediaplayer.stop();
			}
		});
		
		ListView list = (ListView) findViewById(R.id.letterList);
		list.setAdapter(new Mulakshare_LetterListAdapter(this));
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
		Intent home=new Intent(Mulakshare_Main_Activity.this,eslate.main.Main_Menu_Activity.class);
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
		 final Dialog dialog = new Dialog(Mulakshare_Main_Activity.this,AlertDialog.THEME_HOLO_LIGHT);
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
				System.exit(0);
				finish();
				}
	     	});
		} 
	 
	
	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getActionBar().setTitle(mTitle);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		// mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// Pass any configuration change to the drawer toggls
		// mDrawerToggle.onConfigurationChanged(newConfig);
	}

	protected void showDialog(String message, String title) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(title).setMessage(message);
		// Create the AlertDialog object and show it
		builder.show();
	}

}
