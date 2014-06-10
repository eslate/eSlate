package eslate.shapeintro;

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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

//line shape introduction activity
public class LineActivity extends Activity
{
	ImageView pt1,pt2,line,img1,img2;
   	Animation  animation, animation1, animation2,animation3;
	MediaPlayer mediaplayer,mediPlayer1,mediaPlayer2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.si_line_layout);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		
		//point one
		pt1 = (ImageView)findViewById(R.id.pt1);
		pt1.setImageResource(R.drawable.point);
		pt1.setVisibility(View.GONE);
		//point second
		pt2 = (ImageView)findViewById(R.id.pt2);
		pt2.setImageResource(R.drawable.point);
		pt2.setVisibility(View.GONE);
		
		line= (ImageView)findViewById(R.id.line);
		line.setImageResource(R.drawable.line4);
		line.setVisibility(View.GONE);
		
		//left finger point
		img1 = (ImageView)findViewById(R.id.fp1);
		img1.setImageResource(R.drawable.fingerpoint);
		img1.setVisibility(View.GONE);
		
		img2 = (ImageView)findViewById(R.id.fp2);
		img2.setImageResource(R.drawable.fingerpoint);
		img2.setVisibility(View.GONE);
		
		mediPlayer1=MediaPlayer.create(getApplicationContext(), R.raw.point2);
		mediaPlayer2=MediaPlayer.create(getApplicationContext(), R.raw.line);
		
		animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.si_blink);
		animation3 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.si_blink);
		animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.si_seq1);
		animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.si_seq3);
		
		Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.point);
		mediaplayer=MediaPlayer.create(LineActivity.this, path);
		pt1.setVisibility(View.VISIBLE);
		img1.setVisibility(View.VISIBLE);
		pt1.startAnimation(animation);
		animation.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
			mediaplayer.start();
			mediaplayer.setOnCompletionListener(new OnCompletionListener() {
					
			@Override
			public void onCompletion(MediaPlayer mp) {
			mediaplayer.stop();
			mediaplayer.release();
			img1.setVisibility(View.GONE);
			pt2.setVisibility(View.VISIBLE);
			img2.setVisibility(View.VISIBLE);
			pt2.setAnimation(animation3);
			pt2.startAnimation(animation3);
			animation3.setAnimationListener(new AnimationListener() {
				
				@Override
				public void onAnimationStart(Animation animation) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void onAnimationRepeat(Animation animation) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void onAnimationEnd(Animation animation) {
			    mediPlayer1.start();
			    mediPlayer1.setOnCompletionListener(new OnCompletionListener() {
					
					@Override
					public void onCompletion(MediaPlayer mp) {
						// TODO Auto-generated method stub
				mediPlayer1.stop();
				mediPlayer1.release();
				pt2.clearAnimation();
				img2.setVisibility(View.GONE);
				img1.setVisibility(View.VISIBLE);
				img1.startAnimation(animation1);
				animation1.setAnimationListener(new AnimationListener() {
					
					@Override
					public void onAnimationStart(Animation animation) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void onAnimationRepeat(Animation animation) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void onAnimationEnd(Animation animation) {
						img1.clearAnimation();
						pt1.setVisibility(View.GONE);
						pt2.setVisibility(View.GONE);
						img2.setVisibility(View.GONE);
						img1.setVisibility(View.GONE);
						
						line.setVisibility(View.VISIBLE);
					     line.startAnimation(animation3);	
			animation3.setAnimationListener(new AnimationListener() {
				
				@Override
				public void onAnimationStart(Animation animation) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void onAnimationRepeat(Animation animation) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void onAnimationEnd(Animation animation) {
				
					mediaPlayer2.start();
			        mediaPlayer2.setOnCompletionListener(new OnCompletionListener() {
						
				@Override
				public void onCompletion(MediaPlayer mp) {
				mediaPlayer2.stop();
				mediaPlayer2.release();

				// call next activity
				Intent next = new Intent(LineActivity.this, MultiLineActivity.class);
				next.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(next);
				finish();
							
						}
					});
					
				}
			});
						
					}
				});
						
					}
				});
					
				}
			});
						
					}
				});
			}
		});
		
		
		
													
											
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
			
			if(animation.hasStarted())
			{
				animation.cancel();
			}
			mediaplayer.stop();
			mediaplayer.release();
			
			Intent home=new Intent(LineActivity.this,eslate.preparation.main.Eslate_preparatrion_MainActivity.class);
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
		 final Dialog dialog = new Dialog(LineActivity.this,AlertDialog.THEME_HOLO_LIGHT);
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
				if(animation.hasStarted())
				{
					animation.cancel();
				}
				if(mediaplayer.isPlaying())
				{
					mediaplayer.stop();
					mediaplayer.release();
				}
				finish();
				System.exit(0);
				}
	     	});
		} 
	}