package eslate.colortest;

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
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

//this activity is for color identification .this qusetion  is for blue color 
public class ColorTestThreeActivity extends Activity implements OnClickListener {
	MediaPlayer mediaPlayer;
	ImageButton red,green,blue,yellow,purple;
	Animation ani;
	Toast toast;


			@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.colortest3_layout);
			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
			
			 red=(ImageButton)findViewById(R.id.imageButton1);
			 red.setOnClickListener(this);
			 
			 green=(ImageButton)findViewById(R.id.imageButton2);
			 green.setOnClickListener(this);
			 
			 
			 blue=(ImageButton)findViewById(R.id.imageButton3);
			 blue.setOnClickListener(this);
			 
			 yellow=(ImageButton)findViewById(R.id.imageButton4);
			 yellow.setOnClickListener(this);
			 
			 purple=(ImageButton)findViewById(R.id.imageButton5);
			 purple.setOnClickListener(this);
			
				red.setEnabled(false);
				green.setEnabled(false);
				blue.setEnabled(false);
				yellow.setEnabled(false);
				purple.setEnabled(false);
				
			 ani = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.ct_blink);
			 
	        	Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.cq3);
	        	mediaPlayer=MediaPlayer.create(ColorTestThreeActivity.this, path);				
				mediaPlayer.start();
				mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
				@Override
				public void onCompletion(MediaPlayer mp) {
					red.setEnabled(true);
					green.setEnabled(true);
					blue.setEnabled(true);
					yellow.setEnabled(true);
					purple.setEnabled(true);
					}
				});
			}
		         
	 
		@Override
		public void onClick(final View v) {
			
			switch(v.getId()){
	        case R.id.imageButton1:
	        		Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sorry);
	        		mediaPlayer=MediaPlayer.create(ColorTestThreeActivity.this, path);
	        		mediaPlayer.start();
	        		v.setEnabled(false);
	        		green.setEnabled(false);
	        		blue.setEnabled(false);
	        		yellow.setEnabled(false);
	        		purple.setEnabled(false);
	        		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
	        			@Override
	        			public void onCompletion(MediaPlayer mp) {
	        				mediaPlayer.stop();
	        				mediaPlayer.release();
	        				
	        				Intent act2 = new Intent(ColorTestThreeActivity.this,ColorTestThreeActivity.class);
	        				act2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	        				startActivity(act2);
	        				finish();
	        			}
	        		});							
								break;
			case R.id.imageButton2:
						Uri path1=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sorry);
						mediaPlayer=MediaPlayer.create(ColorTestThreeActivity.this, path1);
						mediaPlayer.start();
						v.setEnabled(false);
						red.setEnabled(false);
						blue.setEnabled(false);
						yellow.setEnabled(false);
						purple.setEnabled(false);
						mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
							@Override
							public void onCompletion(MediaPlayer mp) {
								mediaPlayer.stop();
								mediaPlayer.release();
								
								Intent act2 = new Intent(ColorTestThreeActivity.this,ColorTestThreeActivity.class);
								act2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
								startActivity(act2);
								finish();
							}
						});
					        break;
	        case R.id.imageButton3:
	        			LayoutInflater inflater = getLayoutInflater();
	        			View layout = inflater.inflate(R.layout.ct_toast_layout,(ViewGroup) findViewById(R.id.toast_layout_root));
	        			ImageView image = (ImageView) layout.findViewById(R.id.image);
	        			image.setBackgroundColor(Color.TRANSPARENT);
	        			TextView text = (TextView) layout.findViewById(R.id.text);
	        			text.setText("BLUE COLOR");
	        			toast = new Toast(getApplicationContext()); 
	        			toast.setGravity(Gravity.RIGHT, 0, 0); 
	        			toast.setDuration(Toast.LENGTH_LONG); 
	        			toast.setView(layout); 
	        			toast.show();
							        	
	        			Uri path2=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.congrats);
	        			mediaPlayer=MediaPlayer.create(ColorTestThreeActivity.this, path2);
	        			mediaPlayer.start();
	        			v.setEnabled(false);
	        			
	        			red.setEnabled(false);
	        			red.setVisibility(View.GONE);
	        			
	        			green.setEnabled(false);
	        			green.setVisibility(View.GONE);
	        			
	        			yellow.setEnabled(false);
	        			yellow.setVisibility(View.GONE);
	        			
	        			purple.setEnabled(false);
	        			purple.setVisibility(View.GONE);
	        			
	        			blue.startAnimation(ani);										 
	        			mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
	        				@Override
	        				public void onCompletion(MediaPlayer mp) {
	        					toast.cancel();
	        					ani.cancel();
	        					mediaPlayer.stop();
	        					mediaPlayer.release();
	        					
	        					Intent act2 = new Intent(ColorTestThreeActivity.this,ColorTestFourActivity.class);
	        					act2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	        					startActivity(act2);
	        					finish();
	        				}
	        			});
	        			break;
	        case R.id.imageButton4:
	        		Uri path3=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sorry);
	        		mediaPlayer=MediaPlayer.create(ColorTestThreeActivity.this, path3);
	        		mediaPlayer.start();
	        		v.setEnabled(false);
	        		red.setEnabled(false);
	        		green.setEnabled(false);
	        		blue.setEnabled(false);
	        		purple.setEnabled(false);
	        		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
	        			@Override
	        			public void onCompletion(MediaPlayer mp) {
	        				mediaPlayer.stop();
	        				mediaPlayer.release();
						
						Intent act2 = new Intent(ColorTestThreeActivity.this,ColorTestThreeActivity.class);
						act2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						startActivity(act2);
						finish();
	        			}
	        		});
	        		break;
	        case R.id.imageButton5:
	        		Uri path4=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sorry);
	        		mediaPlayer=MediaPlayer.create(ColorTestThreeActivity.this, path4);
	        		mediaPlayer.start();
	        		v.setEnabled(false);
	        		red.setEnabled(false);
	        		green.setEnabled(false);
	        		blue.setEnabled(false);
	        		yellow.setEnabled(false);
	        		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
	        			@Override
	        			public void onCompletion(MediaPlayer mp) {
	        				mediaPlayer.stop();
	        				mediaPlayer.release();
	        				
	        				Intent act2 = new Intent(ColorTestThreeActivity.this,ColorTestThreeActivity.class);
	        				act2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	        				startActivity(act2);
	        				finish();
	        			}
	        		});
	        		break;
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
				if(ani.hasStarted())
				{
					ani.cancel();
				}
				if(mediaPlayer.isPlaying())
				{
					mediaPlayer.stop();
					mediaPlayer.release();
				}
				Intent home=new Intent(ColorTestThreeActivity.this,eslate.preparation.main.Eslate_preparatrion_MainActivity.class);
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
			 final Dialog dialog = new Dialog(ColorTestThreeActivity.this,AlertDialog.THEME_HOLO_LIGHT);
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
					if(ani.hasStarted())
					{
						ani.cancel();
					}
					if(mediaPlayer.isPlaying())
					{
						mediaPlayer.stop();
						mediaPlayer.release();
					}
					finish();
					System.exit(0);
					}
		     	});
			} 
		}
