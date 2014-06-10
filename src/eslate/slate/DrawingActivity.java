package eslate.slate;

import java.util.UUID;
import eslate.main.R;
import android.os.Bundle;
import android.provider.MediaStore;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
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
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class DrawingActivity extends Activity implements OnClickListener {

	private DrawingView drawView;
	private ImageButton currPaint, drawBtn, eraseBtn, newBtn, saveBtn;
	private float smallBrush,largeBrush;

@Override
protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.drawing_layout_main);
		
		//setting screen to portrait mode when launched
	    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	    moveTaskToBack(false);
	    
		//get drawing view
		drawView = (DrawingView)findViewById(R.id.drawing);

		//get the palate and first colour button
		LinearLayout paintLayout = (LinearLayout)findViewById(R.id.paint_colors);
		currPaint = (ImageButton)paintLayout.getChildAt(0);
		currPaint.setImageDrawable(getResources().getDrawable(R.drawable.paint_pressed));

		//sizes from dimensions
		smallBrush = getResources().getInteger(R.integer.small_size);
		largeBrush = getResources().getInteger(R.integer.large_size);

		//draw button
		drawBtn = (ImageButton)findViewById(R.id.draw_btn);
		drawBtn.setOnClickListener(this);

		//set initial size
		drawView.setBrushSize(smallBrush);

		//erase button
		eraseBtn = (ImageButton)findViewById(R.id.erase_btn);
		eraseBtn.setOnClickListener(this);

		//new button
		newBtn = (ImageButton)findViewById(R.id.new_btn);
		newBtn.setOnClickListener(this);

		//save button
		saveBtn = (ImageButton)findViewById(R.id.save_btn);
		saveBtn.setOnClickListener(this);
		

		}

	//user clicked paint
	public void paintClicked(View view)
	{
	//set erase false
	drawView.setErase(false);
	drawView.setBrushSize(smallBrush);
		if(view!=currPaint){
			ImageButton imgView = (ImageButton)view;
			String color = view.getTag().toString();
			drawView.setColor(color);
		
			//update ui
			imgView.setImageDrawable(getResources().getDrawable(R.drawable.paint_pressed));
			currPaint.setImageDrawable(getResources().getDrawable(R.drawable.paint));
			currPaint=(ImageButton)view;
			}
		}

	@Override
	public void onClick(View view){		
		if(view.getId()==R.id.draw_btn){
			drawBtn.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v) {
					drawView.setErase(false);
					drawView.setBrushSize(smallBrush);
					drawView.setLastBrushSize(smallBrush);
				}
			});
		}
		 if(view.getId()==R.id.erase_btn)
		 {
			 drawView.setErase(true);
			 drawView.setBrushSize(largeBrush);
		 if(view.getId()==R.id.erase_btn)
		 {
			eraseBtn.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v) 
				{
					drawView.setErase(true);
					drawView.setBrushSize(largeBrush);
				}
			});
		 }
	}
		 if(view.getId()==R.id.new_btn){
			 //new button
			 AlertDialog.Builder newDialog = new AlertDialog.Builder(this);
			 newDialog.setTitle("New drawing");
			 newDialog.setMessage("Start new drawing (you will lose the current drawing)?");
			 newDialog.setPositiveButton("Yes" +"", new DialogInterface.OnClickListener(){
				 public void onClick(DialogInterface dialog, int which){
					 drawView.startNew();
					 dialog.dismiss();
				 }
			 });
			 newDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
				 public void onClick(DialogInterface dialog, int which){
					 dialog.cancel();
				 }
			 });
			 		newDialog.show();
		 		}
		else if(view.getId()==R.id.save_btn){
			//save drawing
			AlertDialog.Builder saveDialog = new AlertDialog.Builder(this);
			saveDialog.setTitle("Save drawing");
			saveDialog.setMessage("Save drawing to device Gallery?");
			saveDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
				public void onClick(DialogInterface dialog, int which){
					//save drawing
					drawView.setDrawingCacheEnabled(true);
					//attempt to save
					String imgSaved = MediaStore.Images.Media.insertImage(
							getContentResolver(), drawView.getDrawingCache(),
							UUID.randomUUID().toString()+".png", "drawing");
					//feedback
					if(imgSaved!=null){
						Toast savedToast = Toast.makeText(getApplicationContext(), 
								"Drawing saved to Gallery!", Toast.LENGTH_SHORT);
						savedToast.show();
					}
					else{
						Toast unsavedToast = Toast.makeText(getApplicationContext(), 
								"Oops! Image could not be saved.", Toast.LENGTH_SHORT);
						unsavedToast.show();
					}
					drawView.destroyDrawingCache();
				}
			});
			saveDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
				public void onClick(DialogInterface dialog, int which){
					dialog.cancel();
				}
			});
			saveDialog.show();
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
			
			Intent home=new Intent(DrawingActivity.this,eslate.preparation.main.Eslate_preparatrion_MainActivity.class);
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
		 final Dialog dialog = new Dialog(DrawingActivity.this,AlertDialog.THEME_HOLO_LIGHT);
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
				
				finish();
				System.exit(0);
				}
	     	});
		} 
	}