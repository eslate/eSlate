package eslate.writenumber;

import java.io.Serializable;

public class Number_Item implements Serializable {

	private static final long serialVersionUID = 7981370926043420567L;

	public static final Number_Item[] MARATHI = new Number_Item[] {
		new Number_Item("३","२","१"),
		new Number_Item("६", "५","४"),
		new Number_Item("९", "८","७")
		};
	
	//public final String name;
	//public final String isolated;
	public final String begin;
	public final String middle;
	public final String end;
	//public final int soundId;

	public Number_Item( String begin,
			String middle, String end) {
		super();
		
		
		this.begin = begin;
		this.middle = middle;
		this.end = end;
		
	}

	
}