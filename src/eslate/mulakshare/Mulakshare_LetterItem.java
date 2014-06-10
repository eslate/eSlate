package eslate.mulakshare;

import java.io.Serializable;

public class Mulakshare_LetterItem implements Serializable {

	private static final long serialVersionUID = 7981370926043420567L;

	public static final Mulakshare_LetterItem[] MARATHI = new Mulakshare_LetterItem[] {
		new Mulakshare_LetterItem("ग","ख","क","अ"),
		new Mulakshare_LetterItem( "ज","छ","च","घ"),
		new Mulakshare_LetterItem("ड","ठ", "ट","झ"),
		
		new Mulakshare_LetterItem("थ","त ","ण","ढ"),
		new Mulakshare_LetterItem("प","न","ध","द"),
		new Mulakshare_LetterItem("म ","भ","ब","फ"),

		new Mulakshare_LetterItem("व","ल","र","य"),
		new Mulakshare_LetterItem("ह","स","ष","श"),
		new Mulakshare_LetterItem("","ज्ञ","क्ष","ळ"),
		};
	
	//public final String name;
	//public final String isolated;
	public final String begin;
	public final String middle;
	public final String middle1;
	public final String end;
	//public final int soundId;

	public Mulakshare_LetterItem( String begin,
			String middle, String middle1,String end) {
		super();
		
		
		this.begin = begin;
		this.middle = middle;
		this.middle1=middle1;
		this.end = end;
		
	}

	
}