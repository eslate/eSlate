package eslate.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
	//database name and version
	private static final String DB_NAME="eslate";
	private static final int DB_VERSION=2;
	//create table in database
	private static final String COLORTEST_DB_TABLE="Create table ColorTestSCore(Attemptno integer primary key autoincrement,"+ " Date String ,Red integar,Black integer,Blue integer,Yellow integer,White integer,Score integer,Totalquestion integer);";
	
	private static final String SHAPETEST_DB_TABLE="Create table ShapeTestSCore(Attemptno integer primary key autoincrement,"+ " Date String,Circle integer,Square integer,Triangle integer,Circle1 integer,Score integer,Totalquestion integer);";
	
	private static final String ABLRTEST_DB_TABLE="Create table ABLRTestSCore(Attemptno integer primary key autoincrement,"+ " Date String ,Above integer,Above1 integer,Below integer,Left integer,Right integer,Right1 integer,Score integer,Totalquestion integer);";
	
	private static final String COLORBLIND_TEST_DB_TABLE="Create table ColorBlindTestSCore(Attemptno integer primary key autoincrement,"+ " Red integer ,Yellow integer,Blue integer);";
	
	public DatabaseHelper(Context context)
	{
		super(context, DB_NAME, null, DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		//excute table query
		db.execSQL(COLORTEST_DB_TABLE);
		db.execSQL(SHAPETEST_DB_TABLE);
		db.execSQL(ABLRTEST_DB_TABLE);
		db.execSQL(COLORBLIND_TEST_DB_TABLE);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(DatabaseHelper.class.getName(),
				"Upgrading databse from version" + oldVersion + "to " 
				+ newVersion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS user");
		onCreate(db);
	}

}
