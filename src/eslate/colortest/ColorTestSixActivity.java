 package eslate.colortest;

 import eslate.main.R;
import eslate.videotrack.database.Video;
import eslate.videotrack.database.VideoDatabaseHandler;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
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

//this activity is for color identification .this qusetion  is for black color 
public class ColorTestSixActivity extends Activity implements OnClickListener {
	MediaPlayer mediaPlayer=new MediaPlayer();
	ImageButton red,green,blue,yellow,black,white;
	Animation ani;
	Toast toast;
	CountDownTimer timer;
	public static int exam=0;

@Override
protected void onCreate(Bundle savedInstanceState) {
			 super.onCreate(savedInstanceState);
			 setContentView(R.layout.colortest6_layout);
			 
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
			 
			 white=(ImageButton)findViewById(R.id.imageButton6);
			 white.setOnClickListener(this);
				
			 red.setEnabled(false);
			 green.setEnabled(false);
			 blue.setEnabled(false);
			 yellow.setEnabled(false);
			 black.setEnabled(false);
			 white.setEnabled(false);
				
			VideoDatabaseHandler handler=new VideoDatabaseHandler(this);
			handler.addColorID(new Video(1));
			handler.close();
		     
			 ani = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.ct_blink);
			 
	        	Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.cq6);
	        	mediaPlayer=MediaPlayer.create(ColorTestSixActivity.this, path);				
				mediaPlayer.start();
				mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
				@Override
				public void onCompletion(MediaPlayer mp) {
					red.setEnabled(true);
					green.setEnabled(true);
					blue.setEnabled(true);
					yellow.setEnabled(true);
					black.setEnabled(true);
					white.setEnabled(true);
					}
				});
			}
 

		@Override
		public void onClick(final View v) {
			
			switch(v.getId()){
	        case R.id.imageButton1:
	        		Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sorry);
	        		mediaPlayer=MediaPlayer.create(ColorTestSixActivity.this, path);
	        		mediaPlayer.start();
	        		v.setEnabled(false);
	        		green.setEnabled(false);
	        		blue.setEnabled(false);
	        		yellow.setEnabled(false);
	        		black.setEnabled(false);
	        		white.setEnabled(false);
	        		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
	        			@Override
	        			public void onCompletion(MediaPlayer mp) {
	        				mediaPlayer.stop();
	        				mediaPlayer.release();
	        				
	        				Intent act2 = new Intent(ColorTestSixActivity.this,ColorTestSixActivity.class);
	        				act2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	        				startActivity(act2);
	        				finish();
	        			}
	        		});							
	        		break;
			case R.id.imageButton2:
					Uri path1=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sorry);
					mediaPlayer=MediaPlayer.create(ColorTestSixActivity.this, path1);
					mediaPlayer.start();
					v.setEnabled(false);
					red.setEnabled(false);
					blue.setEnabled(false);
					yellow.setEnabled(false);
					black.setEnabled(false);
					white.setEnabled(false);
					mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
						@Override
						public void onCompletion(MediaPlayer mp) {
							mediaPlayer.stop();
							mediaPlayer.release();
							
							Intent act2 = new Intent(ColorTestSixActivity.this,ColorTestSixActivity.class);
							act2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
							startActivity(act2);
							finish();
						}
					});
					break;
	        case R.id.imageButton3:
	        	Uri path2=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sorry);
	        	mediaPlayer=MediaPlayer.create(ColorTestSixActivity.this, path2);
	        	mediaPlayer.start();
	        	v.setEnabled(false);
	        	red.setEnabled(false);
	        	green.setEnabled(false);
	        	yellow.setEnabled(false);
	        	black.setEnabled(false);
	        	white.setEnabled(false);
	        	mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
	        		@Override
	        		public void onCompletion(MediaPlayer mp) {
	        			mediaPlayer.stop();
	        			mediaPlayer.release();
	        			
	        			Intent act2 = new Intent(ColorTestSixActivity.this,ColorTestSixActivity.class);
	        			act2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	        			startActivity(act2);
	        			finish();
	        		}
	        	});
	        	break;
	        case R.id.imageButton4:
	        	Uri path3=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sorry);
	        	mediaPlayer=MediaPlayer.create(ColorTestSixActivity.this, path3);
	        	mediaPlayer.start();
	        	v.setEnabled(false);
	        	red.setEnabled(false);
	        	green.setEnabled(false);
	        	blue.setEnabled(false);
	        	black.setEnabled(false);
	        	white.setEnabled(false);
	        	mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
	        		@Override
	        		public void onCompletion(MediaPlayer mp) {
	        			mediaPlayer.stop();
	        			mediaPlayer.release();
	        			
	        			Intent act2 = new Intent(ColorTestSixActivity.this,ColorTestSixActivity.class);
	        			act2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	        			startActivity(act2);
	        			finish();
	        		}
	        	});
	        	break;
	        case R.id.imageButton5:
	        	LayoutInflater inflater = getLayoutInflater();
	        	View layout = inflater.inflate(R.layout.ct_toast_layout2,(ViewGroup)findViewById(R.id.toast_layout_root));
	        	ImageView image =(ImageView)layout.findViewById(R.id.image);
	        	image.setBackgroundColor(Color.TRANSPARENT);
	        	TextView text =(TextView)layout.findViewById(R.id.text);
	        	text.setText("BLACK COLOR");
	        	toast = new Toast(getApplicationContext()); 
				toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0); 
				toast.setDuration(Toast.LENGTH_LONG); 
				toast.setView(layout); 
				toast.show();
					Uri path4=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.congrats);
					mediaPlayer=MediaPlayer.create(ColorTestSixActivity.this, path4);
					mediaPlayer.start();
					v.setEnabled(false);
					red.setEnabled(false);
					red.setVisibility(View.GONE);
					green.setEnabled(false);
					green.setVisibility(View.GONE);
					
					blue.setEnabled(false);
					blue.setVisibility(View.GONE);
					
					yellow.setEnabled(false);
					yellow.setVisibility(View.GONE);
						                
					white.setEnabled(false);
					white.setVisibility(View.GONE);
										
					black.startAnimation(ani);
					
					mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
					@Override
					public void onCompletion(MediaPlayer mp) {
						mediaPlayer.stop();
						mediaPlayer.release();
						toast.cancel();
						ani.cancel();
							 
					timer =	new CountDownTimer(4000, 1000) 
						{
						public void onTick(long millisUntilFinished) 
						{
						}
						public void onFinish() 
							{
							exam=2;
							Intent act2 = new Intent(ColorTestSixActivity.this,eslate.preparation.main.Exam_Activity.class);
							act2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
							startActivity(act2);
							finish();
							}
							}.start();	
						}
					});
					break;
										
	        case R.id.imageButton6:
	        	
	        	Uri path5=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sorry);
	        	mediaPlayer=MediaPlayer.create(ColorTestSixActivity.this, path5);
	        	mediaPlayer.start();
	        	v.setEnabled(false);
	        	red.setEnabled(false);						
	        	green.setEnabled(false);					                
	        	blue.setEnabled(false);			                
	        	yellow.setEnabled(false);		                
	        	white.setEnabled(false); 		
	        	mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
	        		@Override
	        		public void onCompletion(MediaPlayer mp) {
	        			mediaPlayer.stop();
	        			mediaPlayer.release();
	        			
	        			Intent act2 = new Intent(ColorTestSixActivity.this,ColorTestSixActivity.class);
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
				Intent home=new Intent(ColorTestSixActivity.this,eslate.preparation.main.Eslate_preparatrion_MainActivity.class);
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
			 final Dialog dialog = new Dialog(ColorTestSixActivity.this,AlertDialog.THEME_HOLO_LIGHT);
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
