package eslate.shapetest;

import eslate.main.R;
import eslate.shapetestsecond.ShapeTestSecondOneActivity;
import eslate.videotrack.database.VideoDatabaseHandler;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
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

/**** in this shapetest we are just checking whether student understood the shape or not.
 * that student has to identify the shape as per the audio instructor if student able 
 * to answer that question correctly then next question will appear otherwise same question
 * will appear again untill he/she identifies right shape.in this test score will not  get recorded in database.
 *****/

public class ShapeTestOneActivity extends Activity implements OnClickListener,OnPreparedListener{
	MediaPlayer mediaPlayer;
	Toast toast;
	Animation anim;
	ImageButton imagebtn,circlebtn, trianlebtn, squarebtn,rectaglebtn,ovalbtn;
	Button skip;
	
@Override
protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shapetestone_layout);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		
		circlebtn = (ImageButton)findViewById(R.id.circlebtn);
		circlebtn.setBackgroundColor(Color.TRANSPARENT);
		circlebtn.setOnClickListener(this);
		
		trianlebtn = (ImageButton)findViewById(R.id.trianglebtn);
		trianlebtn.setOnClickListener(this);
			
		ovalbtn = (ImageButton)findViewById(R.id.ovalbtn);
		ovalbtn.setOnClickListener(this);
		
		rectaglebtn = (ImageButton)findViewById(R.id.rectanglebtn);
		rectaglebtn.setOnClickListener(this);
		
		squarebtn = (ImageButton)findViewById(R.id.squarebtn);
		squarebtn.setOnClickListener(this);	
		
		skip=(Button)findViewById(R.id.skip);
		skip.setVisibility(View.GONE);
		//set enable false
		circlebtn.setEnabled(false);
		trianlebtn.setEnabled(false);
		ovalbtn.setEnabled(false);
		squarebtn.setEnabled(false);
	    rectaglebtn.setEnabled(false);
		
		/*Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.ttree);*/
		Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.shapetest);
		mediaPlayer=MediaPlayer.create(getApplicationContext(), path);
		mediaPlayer.start();
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
			
			@Override
			public void onCompletion(MediaPlayer mp) {
			mediaPlayer.stop();
			mediaPlayer.release();
			
			Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.circleques);
			mediaPlayer=MediaPlayer.create(getApplicationContext(), path);
			mediaPlayer.start();
			mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
				
				@Override
				public void onCompletion(MediaPlayer mp) {
				mediaPlayer.stop();
				mediaPlayer.release();
				circlebtn.setEnabled(true);
				trianlebtn.setEnabled(true);
				ovalbtn.setEnabled(true);
				squarebtn.setEnabled(true);
			    rectaglebtn.setEnabled(true);
				
				}
			});
			
			}
		});

		VideoDatabaseHandler handler=new VideoDatabaseHandler(this);
		int count=handler.getShapeIDCOunt();
		
	
		if(count==1)
		{
			skip.setVisibility(View.VISIBLE);
		}
		handler.close();
		
		skip.setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View v) {
		mediaPlayer.stop();
		mediaPlayer.release();
		Intent skip = new Intent(ShapeTestOneActivity.this, ShapeTestSecondOneActivity.class);
		skip.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(skip);
				finish();
			 }
		 });
		
		
		anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.st_blink);
	}
	
	public void m1()
	{
		LayoutInflater inflater = getLayoutInflater();
    	View layout = inflater.inflate(R.layout.st_toast_layout,(ViewGroup) findViewById(R.id.toast_layout_root));
    	ImageView img = (ImageView) layout.findViewById(R.id.toastimage);
    	img.setBackgroundColor(Color.TRANSPARENT);
    	toast = new Toast(getApplicationContext()); 
		toast.setGravity(Gravity.CENTER, 0, 0); 
		toast.setDuration(Toast.LENGTH_SHORT); 
		toast.setView(layout); 
		toast.show();
	}
	
@Override
public void onClick(final View v) {
		switch(v.getId()){
        case R.id.circlebtn:
        	
        	Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.congrats);
        	mediaPlayer=MediaPlayer.create(ShapeTestOneActivity.this, path);
        	this.m1();
        	onPrepared(mediaPlayer);
        	v.setEnabled(false);
        	squarebtn.setEnabled(false);
        	squarebtn.setVisibility(View.GONE);
        	trianlebtn.setEnabled(false);
        	trianlebtn.setVisibility(View.GONE);
        	ovalbtn.setEnabled(false);
        	ovalbtn.setVisibility(View.GONE);
        	
        	rectaglebtn.setEnabled(false);
        	rectaglebtn.setVisibility(View.GONE);	
        	
        	circlebtn.startAnimation(anim);
        	mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
        	@Override
        	public void onCompletion(MediaPlayer mp) {
        	   mediaPlayer.stop();
        	   mediaPlayer.release();
        	 toast.cancel();
        		Intent act2 = new Intent(ShapeTestOneActivity.this,ShapeTestTwoActivity.class);
        		act2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        		startActivity(act2);
        		finish();
        		}
        		});							
        break;
		case R.id.ovalbtn:
			
			Uri path1=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.wrong);
			mediaPlayer=MediaPlayer.create(ShapeTestOneActivity.this, path1);
			
			onPrepared(mediaPlayer);
			v.setEnabled(false);
			squarebtn.setEnabled(false);
			trianlebtn.setEnabled(false);
			circlebtn.setEnabled(false);
			rectaglebtn.setEnabled(false);
			
			mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
			@Override
			public void onCompletion(MediaPlayer mp) {
				mediaPlayer.stop();
				mediaPlayer.release();
			
				Intent act2 = new Intent(ShapeTestOneActivity.this,ShapeTestOneActivity.class);
				act2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(act2);
				finish();
				}
				});
		break;
        case R.id.squarebtn:
        	Uri path2=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.wrong);
        	mediaPlayer=MediaPlayer.create(ShapeTestOneActivity.this, path2);
        	
        	onPrepared(mediaPlayer);
        	v.setEnabled(false);
        	circlebtn.setEnabled(false);
        	trianlebtn.setEnabled(false);
        	ovalbtn.setEnabled(false);
        	rectaglebtn.setEnabled(false);
        	
        	mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
        	@Override
        	public void onCompletion(MediaPlayer mp) {
        		mediaPlayer.stop();
				mediaPlayer.release();
			
        		Intent act2 = new Intent(ShapeTestOneActivity.this,ShapeTestOneActivity.class);
        		act2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        		startActivity(act2);
        		finish();
        		}
        	});
        break;
        case R.id.rectanglebtn:
        	Uri path3=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.wrong);
        	mediaPlayer=MediaPlayer.create(ShapeTestOneActivity.this, path3);
						
        	onPrepared(mediaPlayer);
        	v.setEnabled(false);
        	squarebtn.setEnabled(false);
        	trianlebtn.setEnabled(false);
        	ovalbtn.setEnabled(false);
        	circlebtn.setEnabled(false);
        	
        	mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
        	@Override
        	public void onCompletion(MediaPlayer mp) {
        		mediaPlayer.stop();
				mediaPlayer.release();
	
        		
        		Intent act2 = new Intent(ShapeTestOneActivity.this,ShapeTestOneActivity.class);
        		act2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        		startActivity(act2);
        		finish();
        		}
        		});
        break;
        case R.id.trianglebtn:
        	Uri path4=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.wrong);
        	mediaPlayer=MediaPlayer.create(ShapeTestOneActivity.this, path4);
        	onPrepared(mediaPlayer);
        	
        	v.setEnabled(false);
        	squarebtn.setEnabled(false);
        	circlebtn.setEnabled(false);
        	ovalbtn.setEnabled(false);
        	rectaglebtn.setEnabled(false);
        	
        	mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
        	@Override
        	public void onCompletion(MediaPlayer mp) {
        		if(mediaPlayer.isPlaying())
        		mediaPlayer.stop();
				mediaPlayer.release();

        		Intent act2 = new Intent(ShapeTestOneActivity.this,ShapeTestOneActivity.class);
        		act2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        		startActivity(act2);
        		finish();
        		}
        		});
        break;
	}
}

@Override
public void onPrepared(MediaPlayer mp) {
	mediaPlayer.start();
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
		
		//toast.cancel();
		if(mediaPlayer.isPlaying())
		{
			mediaPlayer.stop();
			mediaPlayer.release();
		}
		Intent home=new Intent(ShapeTestOneActivity.this,eslate.preparation.main.Eslate_preparatrion_MainActivity.class);
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
	 final Dialog dialog = new Dialog(ShapeTestOneActivity.this,AlertDialog.THEME_HOLO_LIGHT);
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
			//.cancel();
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
