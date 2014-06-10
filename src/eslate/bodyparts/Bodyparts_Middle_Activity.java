package eslate.bodyparts;

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
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

@SuppressLint("InlinedApi")
public class Bodyparts_Middle_Activity extends Activity implements OnClickListener {
	    MediaPlayer mediaplayer;
	    Animation animation;
	    ImageView bp_img;
		int image_index = 0;
	    private static final int MAX_IMAGE_COUNT = 7;

	    public Integer[] mImageIds = {
	            R.raw.middlebody,
	    		R.raw.bp_hand,
	            R.raw.bp_finger,
	            R.raw.bp_chest,
	            R.raw.bp_bodyback,
	            R.raw.bp_arm,
	            R.raw.bp_elbow,
	           
	    };    
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.bp_deatils_part_layout);
	    	setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
	    	
			bp_img = (ImageView)findViewById(R.id.bp_body);
			
	        Button btnPrevious = (Button)findViewById(R.id.previous_btn);
	        btnPrevious.setOnClickListener(this); 
	        
	        Button btnNext = (Button)findViewById(R.id.next_btn);
	        btnNext.setOnClickListener(this);
	        showImage();        
	        
	        Button back = (Button)findViewById(R.id.back);
	        back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
					mediaplayer.stop();
					mediaplayer.release();
					
					Intent back = new Intent(Bodyparts_Middle_Activity.this, Bodyparts_MainActivity.class);
					back.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(back);
					finish();
				}
			});
	    }
	    
	    private void showImage() 
	    {	
	        ImageView imgView = (ImageView) findViewById(R.id.myimage);             
	        imgView.setImageResource(mImageIds[image_index]);  
	        switch (image_index) {
			case 0:	
				animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.ci_blink);
				bp_img.setImageResource(R.drawable.body_midarr);
				bp_img.setAnimation(animation);
				
				Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.body_middlepart);
				mediaplayer=MediaPlayer.create(Bodyparts_Middle_Activity.this, path);
				mediaplayer.start();
				mediaplayer.setOnCompletionListener(new OnCompletionListener() {
				@Override
				public void onCompletion(MediaPlayer mp) {
					
					}
				});
				break;
			case 1:
				animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.ci_blink);
				bp_img.setImageResource(R.drawable.bp_handarr);
				bp_img.setAnimation(animation);
				
				Uri path1=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.body_hand);
				mediaplayer=MediaPlayer.create(Bodyparts_Middle_Activity.this, path1);
				mediaplayer.start();
				mediaplayer.setOnCompletionListener(new OnCompletionListener() {
				@Override
				public void onCompletion(MediaPlayer mp) {
					animation.cancel();
					}
				});
				break;
			case 2:
				animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.ci_blink);
				bp_img.setImageResource(R.drawable.bp_fingerarr);
				bp_img.setAnimation(animation);
				
				Uri path2=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.body_finger);
				mediaplayer=MediaPlayer.create(Bodyparts_Middle_Activity.this, path2);
				mediaplayer.start();
				mediaplayer.setOnCompletionListener(new OnCompletionListener() {
				@Override
				public void onCompletion(MediaPlayer mp) {
					animation.cancel();
					}
				});
				break;
			case 3:
				animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.ci_blink);
				bp_img.setImageResource(R.drawable.bp_chestarr);
				bp_img.setAnimation(animation);
				
				Uri path3=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.body_chest);
				mediaplayer=MediaPlayer.create(Bodyparts_Middle_Activity.this, path3);
				mediaplayer.start();
				mediaplayer.setOnCompletionListener(new OnCompletionListener() {
				@Override
				public void onCompletion(MediaPlayer mp) {
					animation.cancel();
					}
				});
				break;
			case 4:
				animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.ci_blink);
				bp_img.setImageResource(R.drawable.bp_backarr);
				bp_img.setAnimation(animation);
				
				Uri path4=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.body_back);
				mediaplayer=MediaPlayer.create(Bodyparts_Middle_Activity.this, path4);
				mediaplayer.start();
				mediaplayer.setOnCompletionListener(new OnCompletionListener() {
				@Override
				public void onCompletion(MediaPlayer mp) {
					animation.cancel();
					}
				});
				break;
			case 5:
				animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.ci_blink);
				bp_img.setImageResource(R.drawable.bp_armarr);
				bp_img.setAnimation(animation);
				
				Uri path5=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.body_arm);
				mediaplayer=MediaPlayer.create(Bodyparts_Middle_Activity.this, path5);
				mediaplayer.start();
				mediaplayer.setOnCompletionListener(new OnCompletionListener() {
				@Override
				public void onCompletion(MediaPlayer mp) {
					animation.cancel();
					}
				});
				break;
			case 6:
				animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.ci_blink);
				bp_img.setImageResource(R.drawable.bp_elbowarr);
				bp_img.setAnimation(animation);
				
				Uri path6=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.body_elbow);
				mediaplayer=MediaPlayer.create(Bodyparts_Middle_Activity.this, path6);
				mediaplayer.start();
				mediaplayer.setOnCompletionListener(new OnCompletionListener() {
				@Override
				public void onCompletion(MediaPlayer mp) {
					animation.cancel();
					}
				});
				break;
			default:
				break;
			}
	    }

	    public void onClick(View v) {
	        switch (v.getId()) {
	            case (R.id.previous_btn):
	            	mediaplayer.stop();
	            	mediaplayer.release();
	                image_index--;
	                if (image_index == -1) {                    
	                    image_index = MAX_IMAGE_COUNT - 1;                  
	                }
	                showImage();
	                
	                break;

	            case (R.id.next_btn):
	            	mediaplayer.stop();
	            	mediaplayer.release();
	                image_index++;
	                if (image_index == MAX_IMAGE_COUNT) {               
	                image_index = 0;                
	                }
	                showImage();
	                
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
	    			if (mediaplayer.isPlaying()) {
						mediaplayer.stop();
						mediaplayer.release();
					}
	    			if (animation.hasStarted()) {
						animation.cancel();
					}
	    			
	    		Intent home=new Intent(Bodyparts_Middle_Activity.this,eslate.preparation.main.Eslate_preparatrion_MainActivity.class);
	    		home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	    		startActivity(home);
	    		finish();
	    		return true;
	    								}
	    		}
	    		return super.onOptionsItemSelected(item);
	    	}
	    @Override
	    public void onBackPressed() {
	    	 final Dialog dialog = new Dialog(Bodyparts_Middle_Activity.this,AlertDialog.THEME_HOLO_LIGHT);
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
	    			if (mediaplayer.isPlaying()) {
	    				mediaplayer.stop();
	    				mediaplayer.release();
	    			}
	    			if (animation.hasStarted()) {
	    				animation.cancel();
	    			}
	    			System.exit(0);
	    			finish();
	    			}
	         	});
	    	} 
	    }

