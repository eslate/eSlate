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
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

//multiple lines shape introduction activity
public class MultiLineActivity extends Activity{
	ImageView hor_line,s_curve,cl_curve,cr_curve,ver_line,inclined_left,inclined_right;
	MediaPlayer mediaplayer;
	Animation animation;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.si_multiline_layout);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

		hor_line= (ImageView)findViewById(R.id.hor_line);
		hor_line.setVisibility(View.GONE);
		//vertical imageview
		ver_line=(ImageView)findViewById(R.id.ver_line);
		ver_line.setVisibility(View.GONE);
		//curve imageview
		s_curve=(ImageView)findViewById(R.id.s_curve);
		s_curve.setVisibility(View.GONE);
		
		cl_curve=(ImageView)findViewById(R.id.cl_curve);
		cl_curve.setVisibility(View.GONE);
		
		cr_curve=(ImageView)findViewById(R.id.cr_curve);
		cr_curve.setVisibility(View.GONE);
	    //inclined imageview	
		inclined_left=(ImageView)findViewById(R.id.inclined_left);
		inclined_left.setVisibility(View.GONE);
		
		inclined_right=(ImageView)findViewById(R.id.inclined_right);
		inclined_right.setVisibility(View.GONE);
		
		animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.si_blink);
		
		ver_line.setVisibility(View.VISIBLE);
		//setting animation to vertical iamge
		ver_line.startAnimation(animation);
		
		Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.verticalline);
		mediaplayer=MediaPlayer.create(MultiLineActivity.this, path);
		mediaplayer.start();
	
	mediaplayer.setOnCompletionListener(new OnCompletionListener() {
	@Override
	public void onCompletion(MediaPlayer mp) {
		// TODO Auto-generated method stub
		mediaplayer.stop();
		mediaplayer.release();
		ver_line.clearAnimation();
		ver_line.setVisibility(View.GONE);
		
		s_curve.setVisibility(View.VISIBLE);
		s_curve.startAnimation(animation);
		
		Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.multipleline);
		mediaplayer=MediaPlayer.create(MultiLineActivity.this, path);
		mediaplayer.start();
	
		mediaplayer.setOnCompletionListener(new OnCompletionListener() {
		@Override
		public void onCompletion(MediaPlayer mp) {
			// TODO Auto-generated method stub
			mediaplayer.stop();
			mediaplayer.release();
			s_curve.clearAnimation();
			s_curve.setVisibility(View.GONE);
			
			cl_curve.setVisibility(View.VISIBLE);
			cl_curve.startAnimation(animation);
			
			Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.multiplelineone);
			mediaplayer=MediaPlayer.create(MultiLineActivity.this, path);
			mediaplayer.start();
			
		mediaplayer.setOnCompletionListener(new OnCompletionListener() {
		@Override
		public void onCompletion(MediaPlayer mp) {
			// TODO Auto-generated method stub
			mediaplayer.stop();
			mediaplayer.release();
			cl_curve.clearAnimation();
			cl_curve.setVisibility(View.GONE);
					
			cr_curve.setVisibility(View.VISIBLE);
			cr_curve.startAnimation(animation);
					
			Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.multiplelineone);
			mediaplayer=MediaPlayer.create(MultiLineActivity.this, path);
			mediaplayer.start();
					
		mediaplayer.setOnCompletionListener(new OnCompletionListener() {
		@Override
		public void onCompletion(MediaPlayer mp) {
			// TODO Auto-generated method stub
			mediaplayer.stop();
			mediaplayer.release();
			cr_curve.clearAnimation();
			cr_curve.setVisibility(View.GONE);
			
			inclined_left.setVisibility(View.VISIBLE);
			inclined_left.startAnimation(animation);
							
			Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.inclined_line);
			mediaplayer=MediaPlayer.create(MultiLineActivity.this, path);
			mediaplayer.start();
							
		mediaplayer.setOnCompletionListener(new OnCompletionListener() {
		@Override
		public void onCompletion(MediaPlayer mp) {
			// TODO Auto-generated method stub
			mediaplayer.stop();
			mediaplayer.release();
			inclined_left.clearAnimation();
			inclined_left.setVisibility(View.GONE);
			
			inclined_right.setVisibility(View.VISIBLE);
			inclined_right.startAnimation(animation);
								
			Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.inclined_line);
			mediaplayer=MediaPlayer.create(MultiLineActivity.this, path);
			mediaplayer.start();
								
		mediaplayer.setOnCompletionListener(new OnCompletionListener() {
		@Override
		public void onCompletion(MediaPlayer mp) {
			// TODO Auto-generated method stub
			mediaplayer.stop();
			mediaplayer.release();
			animation.cancel();
			animation.reset();
			
			Intent next = new Intent(MultiLineActivity.this, eslate.shapeintro.Triangle_Activity.class);
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
			
			Intent home=new Intent(MultiLineActivity.this,eslate.preparation.main.Eslate_preparatrion_MainActivity.class);
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
		 final Dialog dialog = new Dialog(MultiLineActivity.this,AlertDialog.THEME_HOLO_LIGHT);
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