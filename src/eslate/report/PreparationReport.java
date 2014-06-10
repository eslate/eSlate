package eslate.report;

import java.io.File;
import java.io.FileWriter;
import eslate.db.DatabaseHelper;
import eslate.main.R;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Environment;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import au.com.bytecode.opencsv.CSVWriter;

//this activity will genrate reports of test in csv file format at specified location
public class PreparationReport extends Activity{
	Button button1,report1;
	Animation animation;
	ImageView reportcard;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.preparation_report);
		
		reportcard=(ImageView)findViewById(R.id.reportcard);
		
		shapeTestScoreReport();
		colorTestScoreReport();
		aBLRTestScoreReport();
		colorBlindTestScoreReport();
		
		animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.ci_blink);
		
		@SuppressWarnings("unused")
		CountDownTimer timer = new CountDownTimer(11000, 2000) //10 second Timer
        {
            public void onTick(long l) 
            {
            reportcard.startAnimation(animation);
            }
            @Override
            public void onFinish() 
            {
            animation.cancel();
            animation.reset();
            Intent intent=new Intent(PreparationReport.this,eslate.preparation.main.Eslate_preparatrion_MainActivity.class);
            startActivity(intent);
            finish();
            };
        	}.start();
			}

	
//this method will generate a report for shapetest
public void shapeTestScoreReport()
{
	@SuppressWarnings("unused")
	File dbFile=getDatabasePath("eslate.sqlite");
    DatabaseHelper dbhelper = new DatabaseHelper(getApplicationContext());
    //create location to store a report file
     File exportDir = new File(Environment.getExternalStorageDirectory(), "/Eslate_Report");       
    if (!exportDir.exists())
    {//if that directory not exists then it will make new directory
        exportDir.mkdirs();
    }

    File file = new File(exportDir, "shape.csv");
    try
    {
        file.createNewFile();               
        CSVWriter csvWrite = new CSVWriter(new FileWriter(file));
        SQLiteDatabase db = dbhelper.getReadableDatabase();
        Cursor curCSV = db.rawQuery("SELECT * FROM ShapeTestSCore",null);
        csvWrite.writeNext(curCSV.getColumnNames());
        while(curCSV.moveToNext())
        {
        //Which column you want to exprort
        String arrStr1[] ={curCSV.getString(0),curCSV.getString(1), curCSV.getString(2),curCSV.getString(3),curCSV.getString(4),curCSV.getString(5),curCSV.getString(6),curCSV.getString(7)};               
        csvWrite.writeNext(arrStr1);
        }
        csvWrite.close();
        curCSV.close();
        Toast.makeText(PreparationReport.this,"Shape Tets Report Generated Sucessfully", Toast.LENGTH_SHORT).show();
        /*finish();*/
    	}
    	catch(Exception sqlEx)
    	{
        Log.e("MainActivity", sqlEx.getMessage(), sqlEx);
    	}
	}
//this method will generate a report for colortest
public void colorTestScoreReport()
{
	@SuppressWarnings("unused")
	File dbFile=getDatabasePath("eslate.sqlite");
    DatabaseHelper dbhelper = new DatabaseHelper(getApplicationContext());
     File exportDir = new File(Environment.getExternalStorageDirectory(), "/Eslate_Report");       
    if (!exportDir.exists())
    {
        exportDir.mkdirs();
    }

    File file = new File(exportDir, "color.csv");
    try
    {
        file.createNewFile();               
        CSVWriter csvWrite = new CSVWriter(new FileWriter(file));
        SQLiteDatabase db = dbhelper.getReadableDatabase();
        Cursor curCSV = db.rawQuery("SELECT * FROM ColorTestSCore",null);
        csvWrite.writeNext(curCSV.getColumnNames());
        while(curCSV.moveToNext())
        {
        //Which column you want to exprort
        String arrStr1[] ={curCSV.getString(0),curCSV.getString(1), curCSV.getString(2),curCSV.getString(3),curCSV.getString(4),curCSV.getString(5),curCSV.getString(6),curCSV.getString(7),curCSV.getString(8)};               
        csvWrite.writeNext(arrStr1);    
        }
        csvWrite.close();
        curCSV.close();
        Toast.makeText(PreparationReport.this,"Color Test Report Generated Sucessfully", Toast.LENGTH_SHORT).show();
       // finish();*/
    	}
    	catch(Exception sqlEx)
    	{	
        Log.e("MainActivity", sqlEx.getMessage(), sqlEx);
    	}
	}
//this method will generate a report for ABLRtest
public void aBLRTestScoreReport()
{
	@SuppressWarnings("unused")
	File dbFile=getDatabasePath("eslate.sqlite");
    DatabaseHelper dbhelper = new DatabaseHelper(getApplicationContext());
     File exportDir = new File(Environment.getExternalStorageDirectory(), "/Eslate_Report");       
    if (!exportDir.exists())
    {
        exportDir.mkdirs();
    }

    File file = new File(exportDir, "ABLR.csv");
    try
    {
        file.createNewFile();               
        CSVWriter csvWrite = new CSVWriter(new FileWriter(file));
        SQLiteDatabase db = dbhelper.getReadableDatabase();
        Cursor curCSV = db.rawQuery("SELECT * FROM ABLRTestSCore",null);
        csvWrite.writeNext(curCSV.getColumnNames());
        while(curCSV.moveToNext())
        {
        //Which column you want to exprort
        String arrStr1[] ={curCSV.getString(0),curCSV.getString(1), curCSV.getString(2),curCSV.getString(3),curCSV.getString(4),curCSV.getString(5),curCSV.getString(6),curCSV.getString(7),curCSV.getString(8),curCSV.getString(9)};               
        csvWrite.writeNext(arrStr1);    
        }
        csvWrite.close();
        curCSV.close();
     
        Toast.makeText(PreparationReport.this,"Above Below and Left Right Test Report Generated Sucessfully", Toast.LENGTH_SHORT).show();
        //finish();
    	}
    	catch(Exception sqlEx)
    	{
        Log.e("MainActivity", sqlEx.getMessage(), sqlEx);
    	}
	}
//this method will generate a report for colorblindtest
public void colorBlindTestScoreReport()
{
	@SuppressWarnings("unused")
	File dbFile=getDatabasePath("eslate.sqlite");
    DatabaseHelper dbhelper = new DatabaseHelper(getApplicationContext());
     File exportDir = new File(Environment.getExternalStorageDirectory(), "/Eslate_Report");       
    if (!exportDir.exists())
    {
        exportDir.mkdirs();
    }

    File file = new File(exportDir, "colorBlind.csv");
    try
    {
        file.createNewFile();               
        CSVWriter csvWrite = new CSVWriter(new FileWriter(file));
        SQLiteDatabase db = dbhelper.getReadableDatabase();
        Cursor curCSV = db.rawQuery("SELECT * FROM ColorblindTestSCore",null);
        csvWrite.writeNext(curCSV.getColumnNames());
        while(curCSV.moveToNext())
        {
        //Which column you want to exprort
        String arrStr1[] ={curCSV.getString(0),curCSV.getString(1), curCSV.getString(2),curCSV.getString(3),curCSV.getString(4),curCSV.getString(5),curCSV.getString(6),curCSV.getString(7),curCSV.getString(8)};               
        csvWrite.writeNext(arrStr1);    
        }
        csvWrite.close();
        curCSV.close();
        Toast.makeText(PreparationReport.this,"Colorblind Test Report Generated Sucessfully", Toast.LENGTH_SHORT).show();

    	}
    	catch(Exception sqlEx)
    	{
        Log.e("MainActivity", sqlEx.getMessage(), sqlEx);
    	}
	}
}
	

	
	
	
	
	
	

