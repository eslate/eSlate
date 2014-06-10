package eslate.colortestdb;

import eslate.main.R;
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
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
//this test for yellow color
public class ColorTestSecondActivity_four extends Activity implements OnClickListener{

	ImageButton blackCrow,yellow,blueCar,apple,tree;
	MediaPlayer mediaPlayer;
	public static int ques4=0;
	boolean hasOnce=false;
@Override
protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.color_test_four);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		
		blackCrow=(ImageButton)findViewById(R.id.blackCrow);
		blackCrow.setOnClickListener(this);
		
		yellow=(ImageButton)findViewById(R.id.yellow);
		yellow.setOnClickListener(this);
		
		blueCar=(ImageButton)findViewById(R.id.blueCar);
		blueCar.setOnClickListener(this);
		
		apple=(ImageButton)findViewById(R.id.apple);
		apple.setOnClickListener(this);
		
		tree=(ImageButton)findViewById(R.id.tree);
		tree.setOnClickListener(this);
		
		apple.setEnabled(false);
		tree.setEnabled(false);
		blueCar.setEnabled(false);
		yellow.setEnabled(false);
		blackCrow.setEnabled(false);
		
    	Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.cdbq4);
    	mediaPlayer=MediaPlayer.create(ColorTestSecondActivity_four.this, path);				
		mediaPlayer.start();
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
		@Override
		public void onCompletion(MediaPlayer mp) {
			apple.setEnabled(true);
			tree.setEnabled(true);
			blueCar.setEnabled(true);
			yellow.setEnabled(true);
			blackCrow.setEnabled(true);
			}
		});
	}
@Override
public void onClick(View v) {
	if(hasOnce==false)
	{
	hasOnce=true;
	int click=v.getId();
		
	switch (click) {
		
		case R.id.yellow:
		blackCrow.setEnabled(false);
		blueCar.setEnabled(false);
		apple.setEnabled(false);
		tree.setEnabled(false);
		ques4++;
		Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.congrats);
		mediaPlayer=MediaPlayer.create(ColorTestSecondActivity_four.this, path);
		mediaPlayer.start();
		ColorTestSecondActivity_one.score++;
		
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
@Override
public void onCompletion(MediaPlayer mp) {
	mediaPlayer.stop();
	mediaPlayer.release();
	
		Intent intent=new Intent(ColorTestSecondActivity_four.this, ColorTestSecondActivity_five.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
		startActivity(intent);
		finish();
			}
		});
		
	break;
			
		case R.id.apple:
			yellow.setEnabled(false);
			blueCar.setEnabled(false);
			blackCrow.setEnabled(false);
			tree.setEnabled(false);
		Uri path1=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sorry_2);
		mediaPlayer=MediaPlayer.create(ColorTestSecondActivity_four.this, path1);
		mediaPlayer.start();
		
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
@Override
public void onCompletion(MediaPlayer mp) {
	mediaPlayer.stop();
	mediaPlayer.release();
	
	Intent intent=new Intent(ColorTestSecondActivity_four.this, ColorTestSecondActivity_five.class);
	intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
	startActivity(intent);
	finish();
	}
	});
	
	break;
						
		case R.id.tree:
			yellow.setEnabled(false);
			blueCar.setEnabled(false);
			apple.setEnabled(false);
			blackCrow.setEnabled(false);	
		Uri path2=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sorry_2);
		mediaPlayer=MediaPlayer.create(ColorTestSecondActivity_four.this, path2);
		mediaPlayer.start();
		
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
@Override
public void onCompletion(MediaPlayer mp) {
	mediaPlayer.stop();
	mediaPlayer.release();
	
	Intent intent=new Intent(ColorTestSecondActivity_four.this, ColorTestSecondActivity_five.class);
	intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	startActivity(intent);
	finish();	
		}
		});
	
	break;
							
		case R.id.blackCrow:
			yellow.setEnabled(false);
			blueCar.setEnabled(false);
			apple.setEnabled(false);
			tree.setEnabled(false);
		Uri path3=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sorry_2);
		mediaPlayer=MediaPlayer.create(ColorTestSecondActivity_four.this, path3);
		mediaPlayer.start();
		
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
@Override
public void onCompletion(MediaPlayer mp) {
	mediaPlayer.stop();
	mediaPlayer.release();
	
		Intent intent=new Intent(ColorTestSecondActivity_four.this, ColorTestSecondActivity_five.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
		startActivity(intent);
		finish();	
		}
		});
	
	break;
								
		case R.id.blueCar:
			yellow.setEnabled(false);
			blackCrow.setEnabled(false);
			apple.setEnabled(false);
			tree.setEnabled(false);
		Uri path4=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sorry_2);
		mediaPlayer=MediaPlayer.create(ColorTestSecondActivity_four.this, path4);
		mediaPlayer.start();
		
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
@Override
public void onCompletion(MediaPlayer mp) {
	mediaPlayer.stop();
	mediaPlayer.release();
	
	Intent intent=new Intent(ColorTestSecondActivity_four.this, ColorTestSecondActivity_five.class);
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
@SuppressLint("InlinedApi")
@Override
public void onBackPressed() {
	 final Dialog dialog = new Dialog(ColorTestSecondActivity_four.this,AlertDialog.THEME_HOLO_LIGHT);
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
			finish();
			System.exit(0);
			}
     	});
	} 
}

