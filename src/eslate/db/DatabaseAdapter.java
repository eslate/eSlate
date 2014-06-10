package eslate.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;


public class DatabaseAdapter {
	
	//Table name
		private static final String COLOR_TABLE = "ColorTestSCore";
		
		private static final String SHAPE_TABLE="ShapeTestSCore";
		
		private static final String ABLR_TABLE="ABLRTestScore";
		
		
		private static final String COLORBLIND_TABLE="ColorBlindTestScore";
		//Table unique id
		public static final String COL_ID = "id";
		//Common Columns for all Tables In Esalte
		public static final String COL_ATTEMPT = "Attempt_number";
		public static final String COL_DATE= "Date";
		public static final String COL_SCORE = "Score";
		public static final String COL_TOTAL_QUESTION="Totalquestion";
		//Table  ColorTestScore  columns 
	
		public static final String COL_RE="Red";
		public static final String COL_BL="Black";
		public static final String COL_BLU="Blue";
		public static final String COL_YEL="Yellow";
		public static final String COL_WHITE="White";
		
		
		//Table ABLRTestScore columns 
				
		public static final String COL_ABOVE="Above";
		public static final String COL_ABOVE1="Above1";
		public static final String COL_BELOW="Below";
		public static final String COL_LEFT="Left";
		public static final String COL_RIGHT="Right";
		public static final String COL_RIGHT1="Right1";
				
		//Table ABLRTestScore columns 
		
				public static final String COL_CIRCLE="Circle";
				public static final String COL_CIRCLE1="Circle1";
				public static final String COL_TRIANGLE="Triangle";
				public static final String COL_SQUARE="Square";
				
				
		
		//columns for colorblind table
		
		public static final String COL_RED="Red";
		public static final String COL_YELLOW="yellow";
		public static final String COL_BLUE="BLue";
		
		//declaring refrence variable for Context,SqliteDatabase and DbHelper class
		private Context context;
		private SQLiteDatabase database;
		private DatabaseHelper dbHelper;
		//constructor of DatabaseAdapter class which take context as parameter
		public DatabaseAdapter(Context context) {
			this.context = context;
		}
		//this open method get refrence to a Writabledatabase 
		public DatabaseAdapter open() throws SQLException {
			dbHelper = new DatabaseHelper(context);
			database = dbHelper.getWritableDatabase();
			return this;
		}
		 //to close database
		public void close() {
			dbHelper.close();
		}
		//this createColorTestScore method will take parameter as a date,individual question test number,
		//score and total number of question and these values get inserted into color_table
		public long createColorTestScore( String
				Date,int Red,int Black,int Blue,int Yellow,int White,int Score,int Totalquestion) {
			ContentValues initialValues = createColorTestTableContentValues(Date, Red, Black, Blue, Yellow, White, Score, Totalquestion);
			return database.insert(COLOR_TABLE, null, initialValues);
		}
		
		//this createShapeTestScore method will take parameter as a date,individual question test number,
		//score and total number of question and these values get inserted into shape_table
		public long createShapeTestScore( String
				Date,int Circle,int Square,int Triangle,int Circle1,int Score,int Totalquestion) {
			ContentValues initialValues =createShapeTestableContentValues(Date, Circle, Square, Triangle, Circle1, Score, Totalquestion);
			return database.insert(SHAPE_TABLE, null, initialValues);
		}
		
		//this createABLRTestScore method will take parameter as a date,individual question test number,
		//score and total number of question and these values get inserted into ablr_table
		
		public long createABLRTestScore(String Date,int Above,int Above1,int Below,int Left,int Right,int Right1,int Score,int Totalquestion)
		{
			ContentValues initialValues =createABLRTestableContentValues(Date, Above, Above1, Below, Left, Right, Right1, Score, Totalquestion);
			return database.insert(ABLR_TABLE, null, initialValues);
			
		}
		//this createColorTestScore method will take parameter as a individual question test number
		//and these values get inserted into colorblind_table
		public long createColorBlindTestScore(int Red,int Yellow,int Blue)
		{
			ContentValues initialValues = createColorBlindTestContentValues(Red, Yellow, Blue);
			return database.insert(COLORBLIND_TABLE, null, initialValues);
		}
		//This class is used to store a set of values that the ContentResolver can process. 
		private ContentValues createColorTestTableContentValues(String Date,int Red,int Black,int Blue,int Yellow,int White,int Score,int Totalquestion) {
			ContentValues values = new ContentValues();
			
			values.put(COL_DATE, Date);
			values.put(COL_RE, Red);
			values.put(COL_BL, Black);
			values.put(COL_BLU, Blue);
			values.put(COL_YEL, Yellow);
			values.put(COL_WHITE, White);
			values.put(COL_SCORE, Score);
			values.put(COL_TOTAL_QUESTION, Totalquestion);
			return values;
		}
		
		private ContentValues createABLRTestableContentValues(String Date,int Above,int Above1,int Below,int Left,int Right,int Right1,int Score,int Totalquestion) {
			ContentValues values = new ContentValues();
			
			values.put(COL_DATE, Date);
			values.put(COL_ABOVE, Above);
			values.put(COL_ABOVE1, Above1);
			values.put(COL_BELOW, Below);
			values.put(COL_LEFT, Left);
			values.put(COL_RIGHT, Right);
			values.put(COL_RIGHT1, Right1);
			values.put(COL_SCORE, Score);
			values.put(COL_TOTAL_QUESTION, Totalquestion);
			return values;
		}
		
		private ContentValues createShapeTestableContentValues(String Date,int Circle,int Square,int Triangle,int Circle1,int Score,int Totalquestion) {
			ContentValues values = new ContentValues();
			
			values.put(COL_DATE, Date);
			values.put(COL_CIRCLE,Circle);
			values.put(COL_SQUARE,Square);
			values.put(COL_TRIANGLE,Triangle);
			values.put(COL_CIRCLE1,Circle1);
			values.put(COL_SCORE, Score);
			values.put(COL_TOTAL_QUESTION, Totalquestion);
			return values;
		}
		
		private ContentValues createColorBlindTestContentValues( int Red,int Yellow,int Blue) {
			ContentValues values = new ContentValues();
			
			values.put(COL_RED, Red);
			values.put(COL_YELLOW,Yellow);
			values.put(COL_BLUE, Blue);
			return values;
		}
		
}
