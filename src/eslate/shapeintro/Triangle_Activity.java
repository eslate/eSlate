package eslate.shapeintro;

import eslate.main.R;
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
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Typeface;

//triangle shape introduction activity

public class Triangle_Activity extends Activity {
	//various image views are taken to explain him triangle shape with the help of real life objects
	MediaPlayer mediaplayer;
	Animation animation;
	ImageView tri_triangle,tri_hill,tri_board,tri_cap,tri_tree;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.si_triangle_layout);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		
		tri_cap = (ImageView)findViewById(R.id.tri_cap);
		tri_cap.setVisibility(View.GONE);
		
		tri_hill = (ImageView)findViewById(R.id.tri_hill);
		tri_hill.setVisibility(View.GONE);
		
		tri_triangle = (ImageView)findViewById(R.id.triangle);
		tri_triangle.setVisibility(View.GONE);
		
		tri_tree = (ImageView)findViewById(R.id.tri_tree);
		tri_tree.setVisibility(View.GONE);
		
		tri_board = (ImageView)findViewById(R.id.tri_board);
		tri_board.setVisibility(View.GONE);
		
		animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.si_blink);
		
		tri_triangle.setVisibility(View.VISIBLE);
		tri_triangle.setAnimation(animation);
		
		Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.triangle);
		mediaplayer=MediaPlayer.create(Triangle_Activity.this, path);
		mediaplayer.start();
		
		mediaplayer.setOnCompletionListener(new OnCompletionListener() {
		@Override
		public void onCompletion(MediaPlayer mp) {
			// TODO Auto-generated method stub
			mediaplayer.stop();
			mediaplayer.release();
			animation.cancel();
			
			tri_hill.setVisibility(View.VISIBLE);
			tri_hill.startAnimation(animation);
			
			Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.thill);
			mediaplayer=MediaPlayer.create(Triangle_Activity.this, path);
			mediaplayer.start();
			
		mediaplayer.setOnCompletionListener(new OnCompletionListener() {
		@Override
		public void onCompletion(MediaPlayer mp) {
			// TODO Auto-generated method stub
			mediaplayer.stop();
			mediaplayer.release();
            
            animation.cancel();
			
			tri_tree.setVisibility(View.VISIBLE);
			tri_tree.startAnimation(animation);
			
			Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.ttree);
			mediaplayer=MediaPlayer.create(Triangle_Activity.this, path);
			mediaplayer.start();
			
		mediaplayer.setOnCompletionListener(new OnCompletionListener() {
		@Override
		public void onCompletion(MediaPlayer mp) {
			// TODO Auto-generated method stub
			mediaplayer.stop();
			mediaplayer.release();
			animation.cancel();
			
			tri_cap.setVisibility(View.VISIBLE);
			tri_cap.startAnimation(animation);
					
			Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.tcap);
			mediaplayer=MediaPlayer.create(Triangle_Activity.this, path);
			mediaplayer.start();
			
		mediaplayer.setOnCompletionListener(new OnCompletionListener() {
		@Override
		public void onCompletion(MediaPlayer mp) {
			// TODO Auto-generated method stub
			mediaplayer.stop();
			mediaplayer.release();
			animation.cancel();
			
			tri_board.setVisibility(View.VISIBLE);
			tri_board.startAnimation(animation);
			
			
			Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.tsymbol);
			mediaplayer=MediaPlayer.create(Triangle_Activity.this, path);
			mediaplayer.start();
			
		mediaplayer.setOnCompletionListener(new OnCompletionListener() {
		@Override
		public void onCompletion(MediaPlayer mp) {
			// TODO Auto-generated method stub
			mediaplayer.stop();
			mediaplayer.release();
			animation.cancel();
			
			Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.triangle);
			mediaplayer=MediaPlayer.create(Triangle_Activity.this, path);
			mediaplayer.start();
			
		mediaplayer.setOnCompletionListener(new OnCompletionListener() {
		@Override
		public void onCompletion(MediaPlayer mp) {
			// TODO Auto-generated method stub
			mediaplayer.stop();
			mediaplayer.release();
			animation.cancel();
			
			Intent next = new Intent(Triangle_Activity.this, eslate.shapeintro.Rectangle_Activity.class);
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
			
			Intent home=new Intent(Triangle_Activity.this,eslate.preparation.main.Eslate_preparatrion_MainActivity.class);
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
		 final Dialog dialog = new Dialog(Triangle_Activity.this,AlertDialog.THEME_HOLO_LIGHT);
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
				
					mediaplayer.stop();
					mediaplayer.release();
				
				finish();
				System.exit(0);
				}
	     	});
		} 
	}