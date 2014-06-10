package eslate.patterndiffering;

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
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;


public class Pattern_Diff_Activity2 extends Activity implements OnClickListener{
	ImageButton img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11,img12,img13,img14,img15;
	LinearLayout l1, l2, l3;
	MediaPlayer mediaPlayer,mediPlayer_Congo,mediPlayer_Sorry; 
	boolean hasOnce=false;
@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.patterdiff_activity2_layout);
	setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

	mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.pd);
	
	mediPlayer_Congo=MediaPlayer.create(getApplicationContext(), R.raw.congrats);
	
	mediPlayer_Sorry=MediaPlayer.create(getApplicationContext(), R.raw.sorry);
	
	l1=(LinearLayout)findViewById(R.id.linear1);
	l2=(LinearLayout)findViewById(R.id.linear2);
	l3=(LinearLayout)findViewById(R.id.linear3);
	
	l1.setVisibility(View.VISIBLE);
	l2.setVisibility(View.GONE);
	l3.setVisibility(View.GONE);
	
	mediaPlayer.start();
	mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
	@Override
	public void onCompletion(MediaPlayer mp) {
	mediaPlayer.stop();
		}
	});
	
	img1 = (ImageButton)findViewById(R.id.imageButton0);
	img1.setOnClickListener(this);
	img2 = (ImageButton)findViewById(R.id.imageButton1);
	img2.setOnClickListener(this);
	img3 = (ImageButton)findViewById(R.id.imageButton4);//A
	img3.setOnClickListener(this);
	img4 = (ImageButton)findViewById(R.id.imageButton2);
	img4.setOnClickListener(this);
	img5 = (ImageButton)findViewById(R.id.imageButton5);
	img5.setOnClickListener(this);

	img6 =(ImageButton)findViewById(R.id.imageButton6);
	img6.setOnClickListener(this);
	img7 =(ImageButton)findViewById(R.id.imageButton7);
	img7.setOnClickListener(this);
	img8 =(ImageButton)findViewById(R.id.imageButton8);
	img8.setOnClickListener(this);
	img9 =(ImageButton)findViewById(R.id.imageButton9);
	img9.setOnClickListener(this);
	img10 =(ImageButton)findViewById(R.id.imageButton10);//A
	img10.setOnClickListener(this);

	
	img11 =(ImageButton)findViewById(R.id.imageButton11);
	img11.setOnClickListener(this);
	img12 =(ImageButton)findViewById(R.id.imageButton12);
	img12.setOnClickListener(this);
	img13 =(ImageButton)findViewById(R.id.imageButton13);
	img13.setOnClickListener(this);
	img14 =(ImageButton)findViewById(R.id.imageButton14);//A
	img14.setOnClickListener(this);
	img15 =(ImageButton)findViewById(R.id.imageButton15);
	img15.setOnClickListener(this);

	}

@Override
public void onClick(View v) {
	if (mediaPlayer.isPlaying()) {
		mediaPlayer.stop();
	}
	if (hasOnce==false) {
		hasOnce=true;
		switch (v.getId()) {
		case R.id.imageButton0:
			mediPlayer_Sorry.start();
			mediPlayer_Sorry.setOnCompletionListener(new OnCompletionListener() {
			@Override
			public void onCompletion(MediaPlayer mp) {
				hasOnce=false;	
				}
			});
			break;
		case R.id.imageButton1:
			mediPlayer_Sorry.start();
			mediPlayer_Sorry.setOnCompletionListener(new OnCompletionListener() {
			@Override
			public void onCompletion(MediaPlayer mp) {
				hasOnce=false;	
				}
			});
			break;
		case R.id.imageButton4:
			img1.setVisibility(View.GONE);
			img2.setVisibility(View.GONE);
			img4.setVisibility(View.GONE);
			img5.setVisibility(View.GONE);
			
			mediPlayer_Congo.start();
			mediPlayer_Congo.setOnCompletionListener(new OnCompletionListener() {
			@Override
			public void onCompletion(MediaPlayer mp) {
				hasOnce=false;
				
				l2.setVisibility(View.VISIBLE);
				img3.setEnabled(false);
				}
			});
			break;
		case R.id.imageButton2:
			mediPlayer_Sorry.start();
			mediPlayer_Sorry.setOnCompletionListener(new OnCompletionListener() {
			@Override
			public void onCompletion(MediaPlayer mp) {
				hasOnce=false;	
				}
			});
			
			break;
		case R.id.imageButton5:
			mediPlayer_Sorry.start();
			mediPlayer_Sorry.setOnCompletionListener(new OnCompletionListener() {
			@Override
			public void onCompletion(MediaPlayer mp) {
				hasOnce=false;	
				}
			});
			break;
			
		case R.id.imageButton6:
			mediPlayer_Sorry.start();
			mediPlayer_Sorry.setOnCompletionListener(new OnCompletionListener() {
			@Override
			public void onCompletion(MediaPlayer mp) {
				hasOnce=false;	
				}
			});
			break;
		case R.id.imageButton7:
			mediPlayer_Sorry.start();
			mediPlayer_Sorry.setOnCompletionListener(new OnCompletionListener() {
			@Override
			public void onCompletion(MediaPlayer mp) {
				hasOnce=false;	
				}
			});
			break;
		case R.id.imageButton8:
			mediPlayer_Sorry.start();
			mediPlayer_Sorry.setOnCompletionListener(new OnCompletionListener() {
			@Override
			public void onCompletion(MediaPlayer mp) {
				hasOnce=false;	
				}
			});
			break;
		case R.id.imageButton9:
			mediPlayer_Sorry.start();
			mediPlayer_Sorry.setOnCompletionListener(new OnCompletionListener() {
			@Override
			public void onCompletion(MediaPlayer mp) {
				hasOnce=false;	
				}
			});
			break;
		case R.id.imageButton10:
			img6.setVisibility(View.GONE);
			img7.setVisibility(View.GONE);
			img9.setVisibility(View.GONE);
			img8.setVisibility(View.GONE);
		    
			mediPlayer_Congo.start();
			mediPlayer_Congo.setOnCompletionListener(new OnCompletionListener() {
			@Override
			public void onCompletion(MediaPlayer mp) {
				hasOnce=false;
				
				l3.setVisibility(View.VISIBLE);
				img10.setEnabled(false);
				}
			});
			break;
		case R.id.imageButton11:
			mediPlayer_Sorry.start();
			mediPlayer_Sorry.setOnCompletionListener(new OnCompletionListener() {
			@Override
			public void onCompletion(MediaPlayer mp) {
				hasOnce=false;	
				}
			});
			break;
		case R.id.imageButton12:
			mediPlayer_Sorry.start();
			mediPlayer_Sorry.setOnCompletionListener(new OnCompletionListener() {
			@Override
			public void onCompletion(MediaPlayer mp) {
				hasOnce=false;	
				}
			});
			break;
		case R.id.imageButton13:
			mediPlayer_Sorry.start();
			mediPlayer_Sorry.setOnCompletionListener(new OnCompletionListener() {
			@Override
			public void onCompletion(MediaPlayer mp) {
				hasOnce=false;	
				}
			});
			break;
		case R.id.imageButton14:
			img11.setVisibility(View.GONE);
			img12.setVisibility(View.GONE);
			img13.setVisibility(View.GONE);
			img15.setVisibility(View.GONE);
			
			mediPlayer_Congo.start();
			mediPlayer_Congo.setOnCompletionListener(new OnCompletionListener() {
			@Override
			public void onCompletion(MediaPlayer mp) {
				mediPlayer_Congo.stop();
				mediPlayer_Congo.release();
				mediPlayer_Sorry.release();
				mediaPlayer.release();
				
				img14.setEnabled(false);
				
				Intent next = new Intent(Pattern_Diff_Activity2.this,Pattern_Diff_Activity3.class);
				next.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(next);
				finish();
				}
			});
			break;
		case R.id.imageButton15:
			mediPlayer_Sorry.start();
			mediPlayer_Sorry.setOnCompletionListener(new OnCompletionListener() {
			@Override
			public void onCompletion(MediaPlayer mp) {
				hasOnce=false;	
				}
			});
			break;
		default:
			break;
		}
	}
} 
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
		if (mediaPlayer.isPlaying()) {
			mediaPlayer.stop();
			mediaPlayer.release();
		}
		if (mediPlayer_Congo.isPlaying()) {
			mediPlayer_Congo.stop();
			mediPlayer_Congo.release();
		}
		if (mediPlayer_Sorry.isPlaying()) {
			mediPlayer_Sorry.stop();
			mediPlayer_Sorry.release();
		}
	Intent home=new Intent(Pattern_Diff_Activity2.this,eslate.preparation.main.Eslate_preparatrion_MainActivity.class);
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
	 final Dialog dialog = new Dialog(Pattern_Diff_Activity2.this,AlertDialog.THEME_HOLO_LIGHT);
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
