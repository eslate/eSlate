package eslate.writenumber;

import eslate.main.R;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Number_ListAdapter extends BaseAdapter {
	
	private final Context context;
	private final Number_Item[] items;

	public Number_ListAdapter(Context context) {
		this.context = context;
		items = Number_Item.MARATHI;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final Number_Item item = (Number_Item) getItem(position);

		View letterView = null;
		if (convertView == null) {
			LayoutInflater li = LayoutInflater.from(context);
			letterView = li.inflate(R.layout.number_list_row_layout, null);
		} else {
			// Reuse
			letterView = convertView;
		}

		TextView beginView = ((TextView) letterView
				.findViewById(R.id.letterBegin));
		beginView.setText(item.begin);
		beginView.setOnClickListener(new DrawingOnClickListener(context, item,
				Number_PracticeActivity.BEGIN));

		TextView middleView = ((TextView) letterView
				.findViewById(R.id.letterMiddle));
		middleView.setText(item.middle);
		middleView.setOnClickListener(new DrawingOnClickListener(context, item,
				Number_PracticeActivity.MIDDLE));

		TextView endView = ((TextView) letterView.findViewById(R.id.letterEnd));
		endView.setText(item.end);
		endView.setOnClickListener(new DrawingOnClickListener(context, item,
				Number_PracticeActivity.END));

		return letterView;
	}

	@Override
	public int getCount() {
		return items.length;
	}

	@Override
	public Object getItem(int position) {
		return items[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	private static class DrawingOnClickListener implements View.OnClickListener {

		private final Context context;
		private final Number_Item letterItem;
		private final int startIndex;

		public DrawingOnClickListener(Context context, Number_Item letterItem,
				int startIndex) {
			this.context = context;
			this.letterItem = letterItem;
			this.startIndex = startIndex;
		}

		@Override
		public void onClick(View v) {
			if (Number_Main_Activity.mediaplayer.isPlaying()) {
				Number_Main_Activity.mediaplayer.stop();
				Number_Main_Activity.mediaplayer.release();
			}
			Intent intent = new Intent(context, Number_PracticeActivity.class);
			intent.putExtra(Number_PracticeActivity.LETTER_INTENT_EXTRA,
					letterItem);
			intent.putExtra(Number_PracticeActivity.INDEX_INTENT_EXTRA,
					startIndex);
			context.startActivity(intent);
		}

	}
}
