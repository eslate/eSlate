package eslate.compareimage;

import eslate.main.R;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

@SuppressLint({ "SdCardPath", "NewApi" })
public class ImageCompareActivity extends Activity {

	int correct,wrong;
	int c,i,j;
	float m,n;

	Bitmap bm1,bm2;
	Bitmap bmp1,bmp2;
	
	Button back;
	
	String strFile2=null;
	String strFile1=null;
		
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.image_compare_layout);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		
		String img_path = "/mnt/sdcard/Download/aa.png";       
		bmp1= BitmapFactory.decodeFile(img_path);
		ImageView iv1= (ImageView)findViewById(R.id.imageView1);
		iv1.setImageBitmap(bmp1);
	 	   
		Button back = (Button)findViewById(R.id.back);
		back.setOnClickListener(new View.OnClickListener() {
	 			
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent back = new Intent(ImageCompareActivity.this,eslate.drawletter.LetterSecondActivity.class);
			back.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(back);
			finish();
			}
		});
	 	
		Button next = (Button)findViewById(R.id.imgcmp_next);
		next.setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent next = new Intent(ImageCompareActivity.this,eslate.mulakshare.Mulakshare_Main_Activity.class);
			next.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(next);
			finish();
			}
		});
		String img_path2 = "/mnt/sdcard/a.png";       
		bmp2= BitmapFactory.decodeFile(img_path2);
		ImageView iv2= (ImageView)findViewById(R.id.imageView2);
		iv2.setImageBitmap(bmp2);
		//Resources res=ImageCompareActivity.this.getResources();
	       
		// take image from the drawable folder and typecast as a Drawable//
		
		// Drawable dra1=res.getDrawable(R.drawable.b);
		Drawable dra1=new BitmapDrawable(getResources(), bmp1);
		Drawable dra2=new BitmapDrawable(getResources(), bmp2);//res.getDrawable(R.drawable.b);
		
	        
		//b is the Bitmap
		
	// convert bitmap //
	   bmp1 = ((BitmapDrawable)dra1).getBitmap();
	   bmp2 = ((BitmapDrawable)dra2).getBitmap();

	   System.out.println(" SAve To Image :"+bmp1);
	   
	   System.out.println(" SAve To Image :"+bmp2);

	   if(imagesAreEqual(bmp1,bmp2))  // use imagesAreEqual() mathod for check two iamge equal or not //
	   {
		   Toast.makeText(ImageCompareActivity.this, "Equal", Toast.LENGTH_LONG).show();
	   }	       
	   else
	   {
		   Toast.makeText(ImageCompareActivity.this, "UnEqual", Toast.LENGTH_LONG).show();
	   }
	   }   
		boolean imagesAreEqual(Bitmap i1, Bitmap i2)
		{
			if (i1.getHeight() != i2.getHeight())
				return false;
			if (i1.getWidth() != i2.getWidth()) return false;
			for (int y = 0; y < i1.getHeight(); ++y)
				for (int x = 0; x < i1.getWidth(); ++x)
					if (i1.getPixel(x, y) == i2.getPixel(x, y)) 
					{
						i++;
					}
					else
					{
						j++;
					}			        
			        Toast.makeText(getApplicationContext(), String.valueOf(i), Toast.LENGTH_LONG).show();
			        
			        Toast.makeText(getApplicationContext(), String.valueOf(j), Toast.LENGTH_LONG).show();
			        c=i+j;
			        Toast.makeText(getApplicationContext(), String.valueOf(c), Toast.LENGTH_LONG).show();
				     
				     m=(i*100)/c;
				     n=(j*100)/c;
				     Toast.makeText(getApplicationContext(), String.valueOf(m), Toast.LENGTH_LONG).show();
				     Toast.makeText(getApplicationContext(), String.valueOf(n), Toast.LENGTH_LONG).show(); 
				     
				     if(n>60.0)
				     {
				    	 return true;
				     }
				     else
				     {
				    	 return false;
				     }
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
				Intent home=new Intent(ImageCompareActivity.this,eslate.main.Main_Menu_Activity.class);
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
			final Dialog dialog = new Dialog(ImageCompareActivity.this,AlertDialog.THEME_HOLO_LIGHT);
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
			// 	  image.setImageResource(R.drawable.quit);
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
	