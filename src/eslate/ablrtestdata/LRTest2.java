package eslate.ablrtestdata;

import eslate.main.R;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

//this is left right test second activity
public class LRTest2 extends Activity implements OnClickListener{
    ImageView line, book, watch;
    public static int ques5;
    boolean hasOnce=false;
    Toast toast;
    MediaPlayer mediaPlayer,mediPlayer_Congo,mediPlayer_Sorry;
	@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.lrtest2_activity);
	setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
	
	mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.ablrdbtest_5);
	mediPlayer_Congo=MediaPlayer.create(getApplicationContext(), R.raw.congrats);
	mediPlayer_Sorry=MediaPlayer.create(getApplicationContext(), R.raw.sorry_2);
	
	line = (ImageView)findViewById(R.id.line);
	
	book = (ImageView)findViewById(R.id.book);
	book.setOnClickListener(this);
	
	watch = (ImageView)findViewById(R.id.watch);
	watch.setOnClickListener(this);
	
	book.setEnabled(false);
	watch.setEnabled(false);
	
	mediaPlayer.start();
	mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
	@Override
	public void onCompletion(MediaPlayer mp) {
	mediaPlayer.stop();
	mediaPlayer.release();
	
    book.setEnabled(true);
    watch.setEnabled(true);
		}
	});
  }

	@Override
	public void onClick(View v) {
	if (hasOnce==false) {
		hasOnce=true;
		switch (v.getId()) {
		case R.id.book:
			mediPlayer_Sorry.start();
			mediPlayer_Sorry.setOnCompletionListener(new OnCompletionListener() {
			@Override
			public void onCompletion(MediaPlayer mp) {
			
			mediPlayer_Sorry.stop();
			mediPlayer_Sorry.release();
				
			Intent intent=new Intent(LRTest2.this,LRTest3.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent); 
			finish();
				}
			});
			break;
			
		case R.id.watch:
			mediPlayer_Congo.start();
			mediPlayer_Congo.setOnCompletionListener(new OnCompletionListener() {	
			@Override
			public void onCompletion(MediaPlayer mp) {
			
			mediPlayer_Congo.stop();
			mediPlayer_Congo.release();
			
			//since here watch is right attempt we increase  score value by one
			ABTest1.score++;
			ques5++;
			
			Intent intent=new Intent(LRTest2.this,LRTest3.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		   	startActivity(intent);
		   	finish();	
				}
			});
			break;

		default:
			break;
		}
	}
		
	} 
	@Override
	public void onBackPressed() {
		 final Dialog dialog = new Dialog(LRTest2.this,AlertDialog.THEME_HOLO_LIGHT);
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

	
