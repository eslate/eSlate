package eslate.drawletter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import eslate.main.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.Bitmap.Config;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LetterSecondActivity extends Activity{
	
	 MyDrawView myDrawView;
	 MediaPlayer mediaPlayer;
	    @Override
	    protected void onCreate(Bundle savedInstanceState) 
	    {

	    super.onCreate(savedInstanceState);
	    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
	    setContentView(R.layout.drawletter_second);
	    
	    Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.lernalpha_a4);
		mediaPlayer=MediaPlayer.create(LetterSecondActivity.this, path);
		mediaPlayer.start();
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
		@Override
		public void onCompletion(MediaPlayer mp) {
		mediaPlayer.stop();		
			}
		});
		
	    myDrawView = (MyDrawView)findViewById(R.id.draw);
	    
	    Button back = (Button)findViewById(R.id.back);
	    back.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent back = new Intent(LetterSecondActivity.this,LetterFirstActivity.class);
			back.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(back);
			finish();
			}
		});
	    Button button1 = (Button)findViewById(R.id.save);   
	    
	    button1.setOnClickListener(new View.OnClickListener() 
	    {
	    	@SuppressLint("SdCardPath")
			public void onClick(View v)
	    	{       
	    	mediaPlayer.stop();
	    	File folder = new File(Environment.getExternalStorageDirectory().toString());
	    	boolean success = false;
	    	if (!folder.exists()) 
	    	{
	    		success = folder.mkdirs();
	    	}	
	    		System.out.println(success+"folder");
	    		File file = new File(Environment.getExternalStorageDirectory().toString() + "/a.png");
	    		
	    		if ( !file.exists() )
	    		{
	    			try {
	    			success = file.createNewFile();
	    			} catch (IOException e) {
	    				e.printStackTrace();
	                }
	             }

	             System.out.println(success+"file");
	             FileOutputStream ostream = null;
	                try
	                {
	                ostream = new FileOutputStream(file);
	                System.out.println(ostream);
	                @SuppressWarnings("unused")
					View targetView = myDrawView;
	                Bitmap well = myDrawView.getBitmap();
	                Bitmap save = Bitmap.createBitmap(100, 100, Config.ARGB_8888);
	                Paint paint = new Paint();
	                paint.setColor(Color.TRANSPARENT);
	                Canvas now = new Canvas(save);
	                now.drawRect(new Rect(0,0,100,100), paint);
	                now.drawBitmap(well, new Rect(0,0,well.getWidth(),well.getHeight()), new Rect(0,0,100,100), null);
	                if(save == null) {
	                    System.out.println("NULL bitmap save\n");
	                }
	                save.compress(Bitmap.CompressFormat.PNG, 100, ostream);
	                //bitmap.compress(Bitmap.CompressFormat.PNG, 100, ostream);
	                   //ostream.flush();
	                    //ostream.close();
	                }catch (NullPointerException e) 
	                {
	                    e.printStackTrace();
	                    Toast.makeText(getApplicationContext(), "Null error", Toast.LENGTH_SHORT).show();
	                }

	                catch (FileNotFoundException e) 
	                {
	                    e.printStackTrace();
	                    Toast.makeText(getApplicationContext(), "File error", Toast.LENGTH_SHORT).show();
	                }

	                catch (@SuppressWarnings("hiding") IOException e) 
	                {
	                    e.printStackTrace();
	                    Toast.makeText(getApplicationContext(), "IO error", Toast.LENGTH_SHORT).show();
	                }
	    	        mediaPlayer.release();
	                Intent compare=new Intent(LetterSecondActivity.this, eslate.compareimage.ImageCompareActivity.class);
	        		startActivity(compare);
	        		finish();
	    	}
	    });
	    
	    Button clear = (Button)findViewById(R.id.clear);
	    clear.setOnClickListener(new View.OnClickListener() {
			
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			myDrawView.clear();
		//	Toast.makeText(getApplicationContext(), "Clear", Toast.LENGTH_SHORT).show();
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
			Intent home=new Intent(LetterSecondActivity.this,eslate.main.Main_Menu_Activity.class);
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
	    	 final Dialog dialog = new Dialog(LetterSecondActivity.this,AlertDialog.THEME_HOLO_LIGHT);
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
	    			System.exit(0);
	    			finish();
	    			}
	         	});
	    	} 
	    }
