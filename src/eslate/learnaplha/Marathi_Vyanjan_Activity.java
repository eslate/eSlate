package eslate.learnaplha;

import eslate.main.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Marathi_Vyanjan_Activity extends Activity implements OnClickListener {
	MediaPlayer mediaplayer;
	ImageView ref;
	int image_index = 0;
    private static final int MAX_IMAGE_COUNT = 8;

    public Integer[] mImageIds = {
            R.raw.alpha_k,
    		R.raw.alpha_d,
            R.raw.alpha_dha,
            R.raw.alpha_dhaa,
            R.raw.alpha_n,
            R.raw.alpha_na,
            R.raw.alpha_t,
            R.raw.alpha_ta,
    };
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.marathi_alpha_details_layout);
        
        ref = (ImageView)findViewById(R.id.alpha);
        
        Button btnPrevious = (Button)findViewById(R.id.previous_btn);
        btnPrevious.setOnClickListener(this); 
        
        Button btnNext = (Button)findViewById(R.id.next_btn);
        btnNext.setOnClickListener(this);
        showImage();        
        
        Button alphaback = (Button)findViewById(R.id.alpha_back);
        alphaback.setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if (mediaplayer.isPlaying()) {
				mediaplayer.stop();
				mediaplayer.release();
			}
			Intent back = new Intent(Marathi_Vyanjan_Activity.this, MarathiAlpha_Main_Activity.class);
			back.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(back);
			finish();
			}
		});
        
        Button alphanext = (Button)findViewById(R.id.alpha_next);
        alphanext.setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if (mediaplayer.isPlaying()) {
				mediaplayer.stop();
				mediaplayer.release();
			}	
			Intent next = new Intent(Marathi_Vyanjan_Activity.this, eslate.drawletter.LetterVideo.class);
			next.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(next);
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
			ref.setImageResource(R.drawable.alpha_k1);
			
			Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.vyanjan_0);
			mediaplayer=MediaPlayer.create(Marathi_Vyanjan_Activity.this, path);
			mediaplayer.start();
			mediaplayer.setOnCompletionListener(new OnCompletionListener() {
			@Override
			public void onCompletion(MediaPlayer mp) {
				// TODO Auto-generated method stub
				mediaplayer.stop();

				}
			});
			break;
		case 1:
			ref.setImageResource(R.drawable.alpha_d1);
			
			Uri path1=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.vyanjan_1);
			mediaplayer=MediaPlayer.create(Marathi_Vyanjan_Activity.this, path1);
			mediaplayer.start();
			mediaplayer.setOnCompletionListener(new OnCompletionListener() {
			@Override
			public void onCompletion(MediaPlayer mp) {
				// TODO Auto-generated method stub
				mediaplayer.stop();

				}
			});
			break;
		case 2:
			ref.setImageResource(R.drawable.alpha_dha1);
			
			Uri path2=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.vyanjan_2);
			mediaplayer=MediaPlayer.create(Marathi_Vyanjan_Activity.this, path2);
			mediaplayer.start();
			mediaplayer.setOnCompletionListener(new OnCompletionListener() {
			@Override
			public void onCompletion(MediaPlayer mp) {
				// TODO Auto-generated method stub
				mediaplayer.stop();

				}
			});
			break;
		case 3:
			ref.setImageResource(R.drawable.alpha_dhaa1);
			
			Uri path3=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.vyanjan_3);
			mediaplayer=MediaPlayer.create(Marathi_Vyanjan_Activity.this, path3);
			mediaplayer.start();
			mediaplayer.setOnCompletionListener(new OnCompletionListener() {
			@Override
			public void onCompletion(MediaPlayer mp) {
				// TODO Auto-generated method stub
				mediaplayer.stop();

				}
			});
			break;
		case 4:
			ref.setImageResource(R.drawable.alpha_n1);
			
			Uri path4=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.vyanjan_4);
			mediaplayer=MediaPlayer.create(Marathi_Vyanjan_Activity.this, path4);
			mediaplayer.start();
			mediaplayer.setOnCompletionListener(new OnCompletionListener() {
			@Override
			public void onCompletion(MediaPlayer mp) {
				// TODO Auto-generated method stub
				mediaplayer.stop();

				}
			});
			break;
		case 5:
			ref.setImageResource(R.drawable.alpha_na1);
			
			Uri path5=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.vyanjan_5);
			mediaplayer=MediaPlayer.create(Marathi_Vyanjan_Activity.this, path5);
			mediaplayer.start();
			mediaplayer.setOnCompletionListener(new OnCompletionListener() {
			@Override
			public void onCompletion(MediaPlayer mp) {
				// TODO Auto-generated method stub
				mediaplayer.stop();

				}
			});
			break;
		case 6:
			ref.setImageResource(R.drawable.alpha_t1);
			
			Uri path6=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.vyanjan_6);
			mediaplayer=MediaPlayer.create(Marathi_Vyanjan_Activity.this, path6);
			mediaplayer.start();
			mediaplayer.setOnCompletionListener(new OnCompletionListener() {
			@Override
			public void onCompletion(MediaPlayer mp) {
				// TODO Auto-generated method stub
				mediaplayer.stop();

				}
			});
			break;
		case 7:
			ref.setImageResource(R.drawable.alpha_ta1);
			
			Uri path7=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.vyanjan_7);
			mediaplayer=MediaPlayer.create(Marathi_Vyanjan_Activity.this, path7);
			mediaplayer.start();
			mediaplayer.setOnCompletionListener(new OnCompletionListener() {
			@Override
			public void onCompletion(MediaPlayer mp) {
				// TODO Auto-generated method stub
				mediaplayer.stop();

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
            	if (mediaplayer.isPlaying()) {
                	mediaplayer.stop();
				}
                image_index--;
                if (image_index == -1) {                    
                    image_index = MAX_IMAGE_COUNT - 1;                  
                }
                showImage();
                
                break;

            case (R.id.next_btn):
            	if (mediaplayer.isPlaying()) {
                	mediaplayer.stop();
				}
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
		// Inflate the menu; this adds items to the action bar if it is present.
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
		Intent home=new Intent(Marathi_Vyanjan_Activity.this,eslate.main.Main_Menu_Activity.class);
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
    	 final Dialog dialog = new Dialog(Marathi_Vyanjan_Activity.this,AlertDialog.THEME_HOLO_LIGHT);
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
