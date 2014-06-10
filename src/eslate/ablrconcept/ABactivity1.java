package eslate.ablrconcept;

import eslate.main.R;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

//Above below concept first Activity
public class ABactivity1 extends Activity {
	/*ImageView ball, rose, chair;
	
*/
	VideoView view;
	MediaPlayer mediaplayer;
	Button next;
	@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	//setting layout for first Activity
	setContentView(R.layout.welcome_layout);
	//To keep screen orientation Landscape only so the screen will not rotate
	setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
	
	next = (Button)findViewById(R.id.welcome_next);
	next.setVisibility(View.GONE);
	
	view = (VideoView)findViewById(R.id.videoView1);
	String path = "android.resource://"+getPackageName()+"/"+R.raw.above_below;
	view.setVideoURI(Uri.parse(path));
	MediaController controller=new MediaController(this);
	view.setMediaController(controller);
	view.start();
	mediaplayer=MediaPlayer.create(getApplicationContext(), R.raw.above_below_mp);
	mediaplayer.start();
	view.setOnCompletionListener(new OnCompletionListener() {
	@Override
	public void onCompletion(MediaPlayer mp) {
			view.stopPlayback();
			mediaplayer.stop();
			mediaplayer.release();
		 Intent act1 = new Intent(ABactivity1.this,Front_Back.class);
		 act1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		 startActivity(act1);
		 finish();
		}
	});
	}
	

	/*//refrence of all the imageviews
	ball = (ImageView)findViewById(R.id.ball);
	rose = (ImageView)findViewById(R.id.rose);
	chair= (ImageView)findViewById(R.id.chair);
	rose.setVisibility(View.GONE);
	ball.setVisibility(View.GONE);
	chair.setVisibility(View.VISIBLE);
	//taking path of MP3 audio which is located in raw folder 
	Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.congrats);
	mediaplayer=MediaPlayer.create(ABactivity1.this, path);
	//start mediaplayer
	mediaplayer.start();
	
	mediaplayer.setOnCompletionListener(new OnCompletionListener() {
	@Override
public void onCompletion(MediaPlayer mp) {
	mediaplayer.stop();
	
	//after completion of these audio here we are visible some imageview by View.visible so that 
	//they get visible and some are unvisible by gone the visiblity
	rose.setVisibility(View.VISIBLE);
	ball.setVisibility(View.GONE);
	chair.setVisibility(View.VISIBLE);
	Uri path1=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sevensec);
	mediaplayer=MediaPlayer.create(ABactivity1.this, path1);
	mediaplayer.start();
	mediaplayer.setOnCompletionListener(new OnCompletionListener() {
	@Override
public void onCompletion(MediaPlayer mp) {
	mediaplayer.stop();
	
	rose.setVisibility(View.GONE);
	ball.setVisibility(View.VISIBLE);
	Uri path2=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sevensec);
	mediaplayer=MediaPlayer.create(ABactivity1.this, path2);
	mediaplayer.start();
	mediaplayer.setOnCompletionListener(new OnCompletionListener() {
	@Override
public void onCompletion(MediaPlayer mp) {
	mediaplayer.stop();
	
	
	//after completion of this audio it will switch to above below second activity
	Intent intent=new Intent(ABactivity1.this,ABactivity2.class);
	intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	startActivity(intent);
	finish();
	   }
	});
       }
	});
	   }
	});
	   }
*/	//this is method for menu item
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
			mediaplayer.release();
			Intent home=new Intent(ABactivity1.this,eslate.preparation.main.Eslate_preparatrion_MainActivity.class);
    		home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    		startActivity(home);
    		finish();
			return true;
									}
			}
			return super.onOptionsItemSelected(item);
		}
	@SuppressLint("InlinedApi")
	@Override
	public void onBackPressed() {
		 final Dialog dialog = new Dialog(ABactivity1.this,AlertDialog.THEME_HOLO_LIGHT);
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
				mediaplayer.release();
				finish();
				System.exit(0);
				}
	     	});
		} 
	}