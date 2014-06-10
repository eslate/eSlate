package eslate.main;

import eslate.main.R;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class WelcomeActivity extends Activity {
	VideoView view;
	MediaPlayer mediaPlayer;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
    
		super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_layout);
    	
        //setting screen to portrait mode when launched
	    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
	    //block to go back
       /* moveTaskToBack(true);*/
        
	    view = (VideoView)findViewById(R.id.videoView1);
		String path = "android.resource://"+getPackageName()+"/"+R.raw.welcome;
		view.setVideoURI(Uri.parse(path));
		MediaController controller=new MediaController(this);
		view.setMediaController(controller);
		view.start();
		mediaPlayer=MediaPlayer.create(getApplicationContext(), R.raw.welcome_mp);
		mediaPlayer.start();
		
		view.setOnCompletionListener(new OnCompletionListener() {
		@Override
		public void onCompletion(MediaPlayer mp) {
			// TODO Auto-generated method stub
				view.stopPlayback();
			 mediaPlayer.stop();
			 mediaPlayer.release();
			 Intent act1 = new Intent(WelcomeActivity.this,Main_Menu_Activity.class);
			 act1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			 startActivity(act1);
			 finish();
			}
		});

	final Button switchact =(Button)findViewById(R.id.welcome_next);
	switchact.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
    	mediaPlayer.stop();
    	mediaPlayer.release();
    	
        Intent act1 = new Intent(view.getContext(),Main_Menu_Activity.class);
        act1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(act1);
    	finish();
    	}
		});
	}
	@Override
	public void onBackPressed() {
		 final Dialog dialog = new Dialog(WelcomeActivity.this,AlertDialog.THEME_HOLO_LIGHT);
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

