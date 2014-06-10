package eslate.mulakshare;

import eslate.main.R;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Mulakshare_LetterListAdapter extends BaseAdapter {

	private final Context context;
	private final Mulakshare_LetterItem[] items;

	public Mulakshare_LetterListAdapter(Context context) {
		this.context = context;
		items = Mulakshare_LetterItem.MARATHI;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final Mulakshare_LetterItem item = (Mulakshare_LetterItem) getItem(position);

		View letterView = null;
		if (convertView == null) {
			LayoutInflater li = LayoutInflater.from(context);
			letterView = li.inflate(R.layout.mulakshare_list_row_layout, null);
		} else {
			// Reuse
			letterView = convertView;
		}

		TextView beginView = ((TextView) letterView
				.findViewById(R.id.letterBegin));
		beginView.setText(item.begin);
		beginView.setOnClickListener(new DrawingOnClickListener(context, item,
				Mulakshare_LetterPractice_Activity.BEGIN));

		TextView middleView = ((TextView) letterView
				.findViewById(R.id.letterMiddle));
		middleView.setText(item.middle);
		middleView.setOnClickListener(new DrawingOnClickListener(context, item,
				Mulakshare_LetterPractice_Activity.MIDDLE));

		TextView middleOneView = ((TextView) letterView
				.findViewById(R.id.letterMiddleone));
		middleOneView.setText(item.middle1);
		middleOneView.setOnClickListener(new DrawingOnClickListener(context, item,
				Mulakshare_LetterPractice_Activity.MIDDLEONE));

		TextView endView = ((TextView) letterView.findViewById(R.id.letterEnd));
		endView.setText(item.end);
		endView.setOnClickListener(new DrawingOnClickListener(context, item,
				Mulakshare_LetterPractice_Activity.END));

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
		private final Mulakshare_LetterItem letterItem;
		private final int startIndex;

		public DrawingOnClickListener(Context context, Mulakshare_LetterItem letterItem,
				int startIndex) {
			this.context = context;
			this.letterItem = letterItem;
			this.startIndex = startIndex;
		}

		@Override
		public void onClick(View v) {
			if (Mulakshare_Main_Activity.mediaplayer.isPlaying()) {
				Mulakshare_Main_Activity.mediaplayer.stop();
				Mulakshare_Main_Activity.mediaplayer.release();
			}
			Intent intent = new Intent(context, Mulakshare_LetterPractice_Activity.class);
			intent.putExtra(Mulakshare_LetterPractice_Activity.LETTER_INTENT_EXTRA,
					letterItem);
			intent.putExtra(Mulakshare_LetterPractice_Activity.INDEX_INTENT_EXTRA,
					startIndex);
			context.startActivity(intent);
		}

	}
}
