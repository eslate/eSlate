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

//this activity is for color identification .this qusetion  is for yellow color 
public class ColorTestFourActivity extends Activity implements OnClickListener {
	MediaPlayer mediaPlayer=new MediaPlayer();
	ImageButton red,green,blue,yellow,black;
	Animation ani;
	Toast toast;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.colortest4_layout);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);	
			 
		red=(ImageButton)findViewById(R.id.imageButton1);
		red.setOnClickListener(this);
		
			 
		green=(ImageButton)findViewById(R.id.imageButton2);
		green.setOnClickListener(this);
			 
		blue=(ImageButton)findViewById(R.id.imageButton3);
		blue.setOnClickListener(this);
			 
		yellow=(ImageButton)findViewById(R.id.imageButton4);
		yellow.setOnClickListener(this);
			 
		black=(ImageButton)findViewById(R.id.imageButton5);
		black.setOnClickListener(this);
		
		red.setEnabled(false);
		green.setEnabled(false);
		blue.setEnabled(false);
		yellow.setEnabled(false);
		black.setEnabled(false);
		
		ani = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.ct_blink);
    	
		Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.cq4);
    	mediaPlayer=MediaPlayer.create(ColorTestFourActivity.this, path);				
		mediaPlayer.start();
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
		@Override
		public void onCompletion(MediaPlayer mp) {
			red.setEnabled(true);
			green.setEnabled(true);
			blue.setEnabled(true);
			yellow.setEnabled(true);
			black.setEnabled(true);
			}
			});
			}
	 
		@Override
		public void onClick(final View v) {
			
			switch(v.getId()){
	        case R.id.imageButton1:
					        	Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sorry);
								mediaPlayer=MediaPlayer.create(ColorTestFourActivity.this, path);
								mediaPlayer.start();
								v.setEnabled(false);
								green.setEnabled(false);
								blue.setEnabled(false);
								yellow.setEnabled(false);
								black.setEnabled(false);
								mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
								@Override
								public void onCompletion(MediaPlayer mp) {
									mediaPlayer.stop();
									mediaPlayer.release();
								Intent act2 = new Intent(ColorTestFourActivity.this,ColorTestFourActivity.class);
								act2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
								startActivity(act2);
								finish();
								}
								});							
								break;
			case R.id.imageButton2:
								Uri path1=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sorry);
								mediaPlayer=MediaPlayer.create(ColorTestFourActivity.this, path1);
								mediaPlayer.start();
								v.setEnabled(false);
								red.setEnabled(false);
								blue.setEnabled(false);
								yellow.setEnabled(false);
								black.setEnabled(false);
								mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
									@Override
									public void onCompletion(MediaPlayer mp) {
										mediaPlayer.stop();
										mediaPlayer.release();
										
										Intent act2 = new Intent(ColorTestFourActivity.this,ColorTestFourActivity.class);
										act2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
										startActivity(act2);
										finish();
									}
								});
					        break;
	        case R.id.imageButton3:
	        				Uri path2=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sorry);
	        				mediaPlayer=MediaPlayer.create(ColorTestFourActivity.this, path2);
	        				mediaPlayer.start();
	        				v.setEnabled(false);
	        				red.setEnabled(false);
	        				green.setEnabled(false);
	        				yellow.setEnabled(false);
	        				black.setEnabled(false);
	        				mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
	        					@Override
	        					public void onCompletion(MediaPlayer mp) {
	        						mediaPlayer.stop();
	        						mediaPlayer.release();
	        						
	        						Intent act2 = new Intent(ColorTestFourActivity.this,ColorTestFourActivity.class);
	        						act2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
									startActivity(act2);
									finish();
									}
	        				});
							        break;
	        case R.id.imageButton4:
	        	LayoutInflater inflater = getLayoutInflater();
	        	View layout = inflater.inflate(R.layout.color_toast_layout1,(ViewGroup) findViewById(R.id.toast_layout_root));
	        	ImageView image = (ImageView)layout.findViewById(R.id.image);
	        	image.setBackgroundColor(Color.TRANSPARENT);
	        	TextView text = (TextView) layout.findViewById(R.id.text);
	        	text.setText("YELLOW COLOR");
	        	toast = new Toast(getApplicationContext()); 
				toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0); 
				toast.setDuration(Toast.LENGTH_LONG); 
				toast.setView(layout); 
				toast.show();
				Uri path3=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.congrats);
				mediaPlayer=MediaPlayer.create(ColorTestFourActivity.this, path3);
				mediaPlayer.start();
				v.setEnabled(false);
				
				red.setEnabled(false);
				red.setVisibility(View.GONE);
										
				green.setEnabled(false);
				green.setVisibility(View.GONE);
										
				blue.setEnabled(false);
				blue.setVisibility(View.GONE);
										
				black.setEnabled(false);
				black.setVisibility(View.GONE);
				
				yellow.startAnimation(ani);
				
				mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
					@Override
					public void onCompletion(MediaPlayer mp) {
						toast.cancel();		
						ani.cancel();
						mediaPlayer.stop();
						mediaPlayer.release();
						
						Intent act2 = new Intent(ColorTestFourActivity.this,ColorTestFiveActivity.class);
						act2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						startActivity(act2);
						finish();
						}
				});
							       break;
	        case R.id.imageButton5:
	        		Uri path4=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sorry);
	        		mediaPlayer=MediaPlayer.create(ColorTestFourActivity.this, path4);
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
	        				Intent act2 = new Intent(ColorTestFourActivity.this,ColorTestFourActivity.class);
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
				Intent home=new Intent(ColorTestFourActivity.this,eslate.preparation.main.Eslate_preparatrion_MainActivity.class);
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
			 final Dialog dialog = new Dialog(ColorTestFourActivity.this,AlertDialog.THEME_HOLO_LIGHT);
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
