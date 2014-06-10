package eslate.preparation.main;

//import org.apache.poi.hssf.util.HSSFColor.SKY_BLUE;

import eslate.main.R;
import eslate.shapeintro.ShapeIntroBegineActivity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Typeface;


/*****
 * Eslate_preparation_MainActivity is the main home screen of preparation phase.
 * on this screen we have multiple tabs like color introduction,animal introduction,
 * bird introduction,shapeintroduction.if student click on particular button he/she
 *  will switch to that activity**/

@SuppressLint("InlinedApi")
public class Eslate_preparatrion_MainActivity extends Activity implements OnClickListener{

Button prepare_btn,color_btn,shape_btn,bodypart_btn,animal_btn,bird_btn,slate_btn,report_btn;
MediaPlayer mediaPlayer;

@Override
protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.eslate_preparatrion_mainactivity_layout);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		
		prepare_btn = (Button)findViewById(R.id.prepare_btn);
		prepare_btn.setOnClickListener(this);
		
		color_btn	= (Button)findViewById(R.id.color_btn);
		color_btn.setOnClickListener(this);
		
		shape_btn=(Button)findViewById(R.id.shape_btn);
		shape_btn.setOnClickListener(this);
		
		bodypart_btn= (Button)findViewById(R.id.bodyparts_btn);
		bodypart_btn.setOnClickListener(this);
	
		animal_btn= (Button)findViewById(R.id.animal_btn);
		animal_btn.setOnClickListener(this);
		
		bird_btn= (Button)findViewById(R.id.bird_btn);
		bird_btn.setOnClickListener(this);
		
		slate_btn= (Button)findViewById(R.id.slate_btn);
		slate_btn.setOnClickListener(this);
		
		report_btn= (Button)findViewById(R.id.report_btn);
		report_btn.setOnClickListener(this);
		
/*		prepare_btn.setEnabled(false);
		color_btn.setEnabled(false);
		shape_btn.setEnabled(false);
		bodypart_btn.setEnabled(false);
		slate_btn.setEnabled(false);
		report_btn.setEnabled(false);
		animal_btn.setEnabled(false);
		bird_btn.setEnabled(false);*/
		
		mediaPlayer=MediaPlayer.create(getApplicationContext(), R.raw.preparation);
		mediaPlayer.start();
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
			
		@Override
		public void onCompletion(MediaPlayer mp) {
		
/*		prepare_btn.setEnabled(true);
		color_btn.setEnabled(true);
		shape_btn.setEnabled(true);
		bodypart_btn.setEnabled(true);
		slate_btn.setEnabled(true);
		report_btn.setEnabled(true);
		animal_btn.setEnabled(true);
		bird_btn.setEnabled(true);*/
			}
		});
		
		
	}
@Override
public void onClick(final View v) {
	if (mediaPlayer.isPlaying()) {
		mediaPlayer.stop();
		mediaPlayer.release();
	}
		switch(v.getId()){
        case R.id.prepare_btn:
        	//if student clicked on this button he/she will go to pattern matching activity
        	Intent act0 = new Intent(Eslate_preparatrion_MainActivity.this,eslate.patternmatching.PM_Main_Activity.class);
        	act0.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        	startActivity(act0);
        	finish();
        	break;

        case R.id.color_btn:
        	//if student clicked on this button he/she will go to color introduction activity
        	Intent act1 = new Intent(Eslate_preparatrion_MainActivity.this,eslate.colorintro.ColorIntro_BegineActivity.class);
        	act1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        	startActivity(act1);
            finish();
        	break;

        case R.id.shape_btn:
        	//if student clicked on this button he/she will go to shape introduction   activity
        	Intent act2 = new Intent(Eslate_preparatrion_MainActivity.this,ShapeIntroBegineActivity.class);
        	act2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        	startActivity(act2);
            finish();
        	break;

        case R.id.bird_btn:
        	//if student clicked on this button he/she will go to bird introduction activity
        	Intent act3 = new Intent(Eslate_preparatrion_MainActivity.this,eslate.birdintro.Bi_Sparrow.class);
        	act3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        	startActivity(act3);
            finish();
        	break;

        case R.id.animal_btn:
        	//if student clicked on this button he/she will go to animal introduction activity
        	Intent act4 = new Intent(Eslate_preparatrion_MainActivity.this,eslate.animalintro.Animal_intro_Cat_Activity.class);
        	act4.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        	startActivity(act4);
        	finish();
        	break;

        case R.id.bodyparts_btn:
        	Intent act5 = new Intent(Eslate_preparatrion_MainActivity.this,eslate.bodyparts.Bodyparts_MainActivity.class);
        	act5.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        	startActivity(act5);
            finish();
            break;
            
         //This tab will call paint application when clicked   
        case R.id.slate_btn:
        	Intent act6 = new Intent(Eslate_preparatrion_MainActivity.this,eslate.slate.DrawingActivity.class);
        	act6.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        	startActivity(act6);
            finish();
        	break;
        //Tab to generate report in .csv	
        case R.id.report_btn:
        	Intent act7 = new Intent(Eslate_preparatrion_MainActivity.this,eslate.report.LoginReportActivity.class);
        	act7.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        	startActivity(act7);
            finish();
        	break;
		}
	}
@Override
public boolean onCreateOptionsMenu(Menu menu) {
getMenuInflater().inflate(R.menu.main, menu);
return true;
   }
//after selecting the appropriate  menu item this method will invoked
@Override
public boolean onOptionsItemSelected(MenuItem item) {

	switch (item.getItemId()) {
	case R.id.home:
	{
		if (mediaPlayer.isPlaying()) {
			mediaPlayer.stop();
			mediaPlayer.release();
		}
	//if home button is clicked then it will swich to home screen that is in our case eslate_preparation_MainActivity
	Intent home=new Intent(Eslate_preparatrion_MainActivity.this,eslate.main.Main_Menu_Activity.class);
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
	 final Dialog dialog = new Dialog(Eslate_preparatrion_MainActivity.this,AlertDialog.THEME_HOLO_LIGHT);
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
			if (mediaPlayer.isPlaying()) {
				mediaPlayer.stop();
				mediaPlayer.release();
			}
			// TODO Auto-generated method stub
			System.exit(0);
			finish();
			}
     	});
	} 
}