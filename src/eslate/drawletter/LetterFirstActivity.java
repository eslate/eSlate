package eslate.drawletter;

import eslate.main.R;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class LetterFirstActivity extends Activity 
{
    MyDrawView myDrawView;
    Button next,back;
  //  DatabaseAdapter dbHelper;
    int count=0;
    MediaPlayer mediaPlayer;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
    super.onCreate(savedInstanceState);  
    setContentView(R.layout.drawletter_first);
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
	
    Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.lernalpha_a3);
	mediaPlayer=MediaPlayer.create(LetterFirstActivity.this, path);
	mediaPlayer.start();
	mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
	@Override
	public void onCompletion(MediaPlayer mp) {
	mediaPlayer.stop();		
		}
	});
  //  dbHelper = new DatabaseAdapter(this);
//	dbHelper.open();

    myDrawView = (MyDrawView)findViewById(R.id.draw);
   
    //next button
    next=(Button)findViewById(R.id.next);
    next.setVisibility(View.GONE);
    next.setOnClickListener(new OnClickListener() {
		
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	//	dbHelper.count(count);
		if (mediaPlayer.isPlaying()) {
			mediaPlayer.stop();
			mediaPlayer.release();
		}
		Intent intent=new Intent(LetterFirstActivity.this, LetterSecondActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(intent);
		finish();
		}
	});
    
    Button clear = (Button)findViewById(R.id.clear);
    clear.setOnClickListener(new View.OnClickListener() {
    	@Override
		public void onClick(View v) {
    		// TODO Auto-generated method stub
    	//	count++;
    		if(count==0)
    		{
    			next.setVisibility(View.VISIBLE);
    		}
			myDrawView.clear();
		//	Toast.makeText(getApplicationContext(), "Clear", Toast.LENGTH_SHORT).show();
			}
		});
    
    Button back = (Button)findViewById(R.id.back_btn);
    back.setOnClickListener(new View.OnClickListener() {	
	@Override
	public void onClick(View v) {
		if (mediaPlayer.isPlaying()) {
			mediaPlayer.stop();
			mediaPlayer.release();
		}
		Intent back = new Intent(LetterFirstActivity.this,LetterVideo.class);
		back.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(back);
		finish();
			}
    	});
    }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
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
		Intent home=new Intent(LetterFirstActivity.this,eslate.main.Main_Menu_Activity.class);
		home.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(home);
		finish();
		return true;
		}
		}
		return super.onOptionsItemSelected(item);
		}
    @Override
    public void onBackPressed() {
    	 final Dialog dialog = new Dialog(LetterFirstActivity.this,AlertDialog.THEME_HOLO_LIGHT);
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
    			System.exit(0);
    			finish();
    			}
         	});
    	} 
    }