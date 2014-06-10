package eslate.videotrack.database;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class VideoDatabaseHandler extends SQLiteOpenHelper{
	
	//Database Version
	public static final int DATABASE_VERSION=4;
	//Database Name
	private static final String DATABASE_NAME="videoState";
	//table name
	private static final String TABLE_SHAPE_VIDEO="shapeVideoCheck";
	
	private static final String TABLE_COLOR_VIDEO="colorVideoCheck";
	
	private static final String TABLE_ABLR_VIDEO="ablrVideoCheck";
	//columns
	 private static final String KEY_ID = "id";
	 
	 public VideoDatabaseHandler(Context context) {
	        super(context, DATABASE_NAME, null, DATABASE_VERSION);
	    }
	    // Creating Tables
	    @Override
	    public void onCreate(SQLiteDatabase db) {
	        String CREATE_VIDEO_TABLE = "CREATE TABLE " + TABLE_SHAPE_VIDEO + "("
	                + KEY_ID + " INTEGER PRIMARY KEY" + ")";
	        
	        String CREATE_VIDEO_TABLE1 = "CREATE TABLE " + TABLE_COLOR_VIDEO+ "("
	                + KEY_ID + " INTEGER PRIMARY KEY" + ")";
	        
	        String CREATE_VIDEO_TABLE2= "CREATE TABLE " + TABLE_ABLR_VIDEO+ "("
	                + KEY_ID + " INTEGER PRIMARY KEY" + ")";
	        //executing all table queries
	        db.execSQL(CREATE_VIDEO_TABLE);
	        db.execSQL(CREATE_VIDEO_TABLE1);
	        db.execSQL(CREATE_VIDEO_TABLE2);
	    }
	 // Upgrading database
	    @Override
	    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	        // Drop older table if existed
	        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SHAPE_VIDEO);
	        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COLOR_VIDEO);
	        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ABLR_VIDEO);
	   	 
	   	 
	        // Create tables again
	        onCreate(db);
	    }
	    
	    // Adding new Shape id 
	 public void addABLRID(Video video) {
	        SQLiteDatabase db = this.getWritableDatabase();
	 
	        ContentValues values = new ContentValues();
	        values.put(KEY_ID, video.getId()); // id
	     
	        // Inserting Row
	        db.insert(TABLE_ABLR_VIDEO, null, values);
	        db.close(); // Closing database connection
	    }
	    // Adding new Shape id 
		 public void addShapeID(Video video) {
		        SQLiteDatabase db = this.getWritableDatabase();
		 
		        ContentValues values = new ContentValues();
		        values.put(KEY_ID, video.getId()); // id
		     
		        // Inserting Row
		        db.insert(TABLE_SHAPE_VIDEO, null, values);
		        db.close(); // Closing database connection
		    }
	 //adding new color id
	 public void addColorID(Video video) {
	        SQLiteDatabase db = this.getWritableDatabase();
	 
	        ContentValues values = new ContentValues();
	        values.put(KEY_ID, video.getId()); // id
	     
	        // Inserting Row
	        db.insert(TABLE_COLOR_VIDEO, null, values);
	        db.close(); // Closing database connection
	    }
	 
	    
	    // Getting All ids of shape
	    public List<Video> getAllShapeID() {
	        List<Video> shapeVideoCheck = new ArrayList<Video>();
	        // Select All Query
	        String selectQuery = "SELECT  * FROM " + TABLE_SHAPE_VIDEO;
	 
	        SQLiteDatabase db = this.getWritableDatabase();
	        Cursor cursor = db.rawQuery(selectQuery, null);
	 
	        // looping through all rows and adding to list
	        if (cursor.moveToFirst()) {
	            do {
	                Video video = new Video();
	                video.setId(Integer.parseInt(cursor.getString(0)));
	               
	                // Adding id to list
	                shapeVideoCheck.add(video);
	            } while (cursor.moveToNext());
	        }
	 
	        // return id list
	        return shapeVideoCheck;
	    }
	    
	 // Getting All ids of shape
	    public List<Video> getAllABLRID() {
	        List<Video> ablrVideoCheck = new ArrayList<Video>();
	        // Select All Query
	        String selectQuery = "SELECT  * FROM " + TABLE_ABLR_VIDEO;
	 
	        SQLiteDatabase db = this.getWritableDatabase();
	        Cursor cursor = db.rawQuery(selectQuery, null);
	 
	        // looping through all rows and adding to list
	        if (cursor.moveToFirst()) {
	            do {
	                Video video = new Video();
	                video.setId(Integer.parseInt(cursor.getString(0)));
	               
	                // Adding id to list
	                ablrVideoCheck.add(video);
	            } while (cursor.moveToNext());
	        }
	 
	        // return id list
	        return ablrVideoCheck;
	    }
	    
	  //getting all ids of color  
	    public List<Video> getAllColorID() {
	        List<Video> colorVideoCheck = new ArrayList<Video>();
	        // Select All Query
	        String selectQuery = "SELECT  * FROM " + TABLE_COLOR_VIDEO;
	 
	        SQLiteDatabase db = this.getWritableDatabase();
	        Cursor cursor = db.rawQuery(selectQuery, null);
	 
	        // looping through all rows and adding to list
	        if (cursor.moveToFirst()) {
	            do {
	                Video video = new Video();
	                video.setId(Integer.parseInt(cursor.getString(0)));
	               
	                // Adding id to list
	                colorVideoCheck.add(video);
	            } while (cursor.moveToNext());
	        }
	 
	        // return id list
	        return colorVideoCheck;
	    }
	    
	    // Getting id counts of shape
	    public int getShapeIDCOunt() {
	        String countQuery = "SELECT  * FROM " + TABLE_SHAPE_VIDEO;
	        SQLiteDatabase db = this.getReadableDatabase();
	        Cursor cursor = db.rawQuery(countQuery, null);
	       
	 
	        // return count
	        return cursor.getCount();
	    }

	    // Getting id counts of color
	    public int getColorIDCOunt() {
	        String countQuery = "SELECT  * FROM " + TABLE_COLOR_VIDEO;
	        SQLiteDatabase db = this.getReadableDatabase();
	        Cursor cursor = db.rawQuery(countQuery, null);
	       
	 
	        // return count
	        return cursor.getCount();
	    }

	    
	    // Getting id counts of ablrtest
	    public int getablrIDCOunt() {
	        String countQuery = "SELECT  * FROM " + TABLE_ABLR_VIDEO;
	        SQLiteDatabase db = this.getReadableDatabase();
	        Cursor cursor = db.rawQuery(countQuery, null);
	       
	 
	        // return count
	        return cursor.getCount();
	    }

	 


}
