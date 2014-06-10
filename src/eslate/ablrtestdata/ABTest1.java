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

/****this activity is used to check whether student understand the Above Below Concept.
 * It is first Above below Test
 *
 */
public class ABTest1 extends Activity implements OnClickListener{
    ImageView line, plane, pen;
    MediaPlayer mediaPlayer,mediPlayer_Congo,mediPlayer_Sorry;
    boolean hasOnce=false;
    
    //this variable is define Question no 1
    public static int ques1;
  
/*** This is global(static) score variable.for each question if student is answer  
 * correct then it will increment by one.like that we keep the track of score of this ablr test  ****/
    
    public static int score=0;
	@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
	setContentView(R.layout.abtest1_activity);
	setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
	
	mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.ablrdbtest_1);
	
	mediPlayer_Congo=MediaPlayer.create(getApplicationContext(), R.raw.congrats);
	
	mediPlayer_Sorry=MediaPlayer.create(getApplicationContext(), R.raw.sorry_2);
	
	line = (ImageView)findViewById(R.id.line);
	plane = (ImageView)findViewById(R.id.plane);
	plane.setOnClickListener(this);
	
	pen = (ImageView)findViewById(R.id.pen);
	pen.setOnClickListener(this);
	
	line.setEnabled(false);
	plane.setEnabled(false);
	pen.setEnabled(false);
	
	mediaPlayer.start();
	mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
	@Override
	public void onCompletion(MediaPlayer mp) {
		mediaPlayer.stop();
		mediaPlayer.release();
		
		plane.setEnabled(true);
		pen.setEnabled(true);	
			}
		});	
	}
	
	@Override
	public void onClick(View v) {
		if(hasOnce==false)
		{
			hasOnce=true;
			
		switch (v.getId()) {
		case R.id.pen:
			mediPlayer_Congo.start();
			mediPlayer_Congo.setOnCompletionListener(new OnCompletionListener() {
				
			@Override
			public void onCompletion(MediaPlayer mp) {
				mediPlayer_Congo.stop();
				mediPlayer_Congo.release();
				score++;	
				ques1++;
					
				Intent intent=new Intent(ABTest1.this,ABTest2.class);		
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent); 
				finish();
				}
			});
			break;
		case R.id.plane:

			mediPlayer_Sorry.start();
			mediPlayer_Sorry.setOnCompletionListener(new OnCompletionListener() {
				
				@Override
				public void onCompletion(MediaPlayer mp) {
					mediPlayer_Sorry.stop();
					mediPlayer_Sorry.release();
					
					Intent intent=new Intent(ABTest1.this,ABTest2.class);
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
		 final Dialog dialog = new Dialog(ABTest1.this,AlertDialog.THEME_HOLO_LIGHT);
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
				finish();
				System.exit(0);
				}
	     	});
		} 
	}
