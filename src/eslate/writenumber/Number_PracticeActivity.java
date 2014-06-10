package eslate.writenumber;

import eslate.main.R;
import android.app.ActionBar;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.view.ViewGroup;

public class Number_PracticeActivity extends FragmentActivity implements
		ActionBar.OnNavigationListener {
	private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";

	public static final int BEGIN = 1;
	public static final int MIDDLE = 2;
	public static final int END = 3;

	 
	public static final String LETTER_INTENT_EXTRA = "LetterItem";
	public static final String INDEX_INTENT_EXTRA = "startingIndex";

	private Number_Item letterItem;
	private DummySectionFragment fragment;
	private DrawerLayout drawer;
	private ListView navList;

	public static MediaPlayer mediaPlayer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.number_activity_practice);
		
		
		
		letterItem = (Number_Item) getIntent().getSerializableExtra(
				LETTER_INTENT_EXTRA);

		drawer = (DrawerLayout) findViewById(R.id.drawer_layout_letter);
		navList = (ListView) findViewById(R.id.drawer);

		Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.number_eraser);
		mediaPlayer=MediaPlayer.create(Number_PracticeActivity.this, path);
		mediaPlayer.start();
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
		@Override
		public void onCompletion(MediaPlayer mp) {
			// TODO Auto-generated method stub
			mediaPlayer.stop();
			mediaPlayer.release();
			
			Uri path=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.home);
			mediaPlayer=MediaPlayer.create(Number_PracticeActivity.this, path);
			mediaPlayer.start();
			
			mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
			@Override
			public void onCompletion(MediaPlayer mp) {
				// TODO Auto-generated method stub
				mediaPlayer.stop();	
				}
			});
			}
		});
		// just styling option add shadow the right edge of the drawer
	//	drawer.setDrawerShadow(null, GravityCompat.START);

		navList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					final int pos, long id) {
				fragment = new DummySectionFragment();
				Bundle args = new Bundle();
				String letter = "";
				String isolatedLetter = "";
				switch (pos) {
				case BEGIN: {
					letter = letterItem.begin;
					break;
				}
				case MIDDLE: {
					letter = letterItem.middle;
					break;
				}
				case END: {
					letter = letterItem.end;
					break;
				}
				}
				String[] value = { isolatedLetter, letter };
				args.putStringArray(DummySectionFragment.ARG_LETTER_PHONOLOGY,
						value);
				// args.putString(DummySectionFragment.ARG_LETTER, letter);
				fragment.setArguments(args);
				getSupportFragmentManager().beginTransaction()
						.replace(R.id.container, fragment).commit();

				drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
				drawer.setDrawerListener(new DrawerLayout.SimpleDrawerListener() {
					@Override
					public void onDrawerClosed(View drawerView) {
						super.onDrawerClosed(drawerView);
					}
				});
				drawer.closeDrawer(navList);
			}
		});
		int startingIndex = getIntent().getIntExtra(INDEX_INTENT_EXTRA, BEGIN);
		if (savedInstanceState == null) {
			savedInstanceState = new Bundle();
		}
		savedInstanceState
				.putInt(STATE_SELECTED_NAVIGATION_ITEM, startingIndex);
		onRestoreInstanceState(savedInstanceState);
		
	}

	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		// Restore the previously serialized current dropdown position.
		if (savedInstanceState.containsKey(STATE_SELECTED_NAVIGATION_ITEM)) {
			fragment = new DummySectionFragment();
			Bundle args = new Bundle();
			String letter = "";
			String isolatedLetter = "";
			//isolatedLetter = letterItem.isolated;
			switch (savedInstanceState.getInt(STATE_SELECTED_NAVIGATION_ITEM)) {
			case BEGIN: {
				letter = letterItem.begin;
				break;
			}
			case MIDDLE: {
				letter = letterItem.middle;
				break;
			}
			case END: {
				letter = letterItem.end;
				break;
			}
			}
			String[] value = { isolatedLetter, letter };
			args.putStringArray(DummySectionFragment.ARG_LETTER_PHONOLOGY,
					value);
		
			fragment.setArguments(args);
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.container, fragment).commit();

		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mulakshare_practice, menu);
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
			Intent home=new Intent(Number_PracticeActivity.this, eslate.main.Main_Menu_Activity.class);
			startActivity(home);
			finish();
			return true;
		}
		case R.id.action_refresh: {
			fragment.canvas.resetCanvas();
			return true;
		}
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A dummy fragment representing a section of the app, but that simply
	 * displays dummy text.
	 */
	public static class DummySectionFragment extends Fragment {

		public static final String ARG_LETTER_PHONOLOGY = "letter_phonology";
		Number_CanvasTextView canvas;
	
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(
					R.layout.number_fragment_practice_dummy, container, false);

			canvas = (Number_CanvasTextView) rootView
					.findViewById(R.id.letterPracticeCanvas);
			//set Letter to be draw at background
			canvas.setText(getArguments().getStringArray(ARG_LETTER_PHONOLOGY)[1]);
			return rootView;
		} 
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// actionBarDrawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onNavigationItemSelected(int itemPosition, long itemId) {
		// TODO Auto-generated method stub
		if (mediaPlayer.isPlaying()) {
			mediaPlayer.stop();
			mediaPlayer.release();
		}
		return false;
	} 
}
