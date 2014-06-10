package eslate.drawletter;

import eslate.main.R;
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
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class LetterVideo extends Activity {
	Button playagain,next,back;
	MediaPlayer mediaPlayer,mediaPlayerAgain;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.drawletter_video1);
		
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		
		mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.lernalpha_a1);
		mediaPlayerAgain=MediaPlayer.create(getApplicationContext(),R.raw.lernalpha_a2);
		
		LayoutInflater inflater = getLayoutInflater();
		getWindow().addContentView(inflater.inflate(R.layout.playagain, null),
		new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
		
		playagain = (Button)findViewById(R.id.playagain);
		playagain.setVisibility(View.GONE);

		final VideoView view = (VideoView)findViewById(R.id.videoView1);
		String path = "android.resource://"+getPackageName()+"/"+R.raw.a;
		view.setVideoURI(Uri.parse(path));
		MediaController controller=new MediaController(this);
		view.setMediaController(controller);
		view.setOnCompletionListener(new OnCompletionListener() {
		@Override
		public void onCompletion(MediaPlayer mp) {
			view.stopPlayback();
			playagain.setVisibility(View.VISIBLE);

			mediaPlayerAgain.start();
			mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
			@Override
			public void onCompletion(MediaPlayer mp) {
			mediaPlayerAgain.stop();		

		playagain.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			mediaPlayerAgain.release();
			mediaPlayer.release();
			
			Intent again = new Intent(LetterVideo.this, LetterVideo.class);
			again.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(again);
			finish();
					}
				});		
			}
		});	
		}
	});
		Uri path10=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.lernalpha_a1);
		mediaPlayer=MediaPlayer.create(LetterVideo.this, path10);
		mediaPlayer.start();
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
		@Override
		public void onCompletion(MediaPlayer mp) {
		mediaPlayer.stop();
		view.start();		
			}
		});
		
		next = (Button)findViewById(R.id.alpha_next_btn);
		next.setOnClickListener(new View.OnClickListener() {	
		@Override
		public void onClick(View v) {
			if (mediaPlayer.isPlaying()) {
				mediaPlayer.stop();
				mediaPlayer.release();
			}
			if (mediaPlayerAgain.isPlaying()) {
				mediaPlayerAgain.stop();
				mediaPlayerAgain.release();
			}
			Intent next = new Intent(LetterVideo.this, LetterFirstActivity.class);
			next.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(next);
			finish();
			}
		});
		
		back = (Button)findViewById(R.id.alpha_back_btn);
		back.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
		if (mediaPlayer.isPlaying()) {
			mediaPlayer.stop();
			mediaPlayer.release();
		}
		if (mediaPlayerAgain.isPlaying()) {
			mediaPlayerAgain.stop();
			mediaPlayerAgain.release();
		}
		Intent next = new Intent(LetterVideo.this,eslate.learnaplha.MarathiAlpha_Main_Activity.class);
		next.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(next);
		finish();
			}
		});
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
			if (mediaPlayer.isPlaying()) {
				mediaPlayer.stop();
				mediaPlayer.release();
			}
			if (mediaPlayerAgain.isPlaying()) {
				mediaPlayerAgain.stop();
				mediaPlayerAgain.release();
			}
		Intent home=new Intent(LetterVideo.this,eslate.main.Main_Menu_Activity.class);
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
		 final Dialog dialog = new Dialog(LetterVideo.this,AlertDialog.THEME_HOLO_LIGHT);
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
	}
