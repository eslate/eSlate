package eslate.colorintro;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class SingleTouchEventView extends View {
	 
	public static int red,yellow,blue,black,white;
    private Paint paint = new Paint();
    private Path path = new Path();
@SuppressLint("NewApi")
public SingleTouchEventView(Context context, AttributeSet attrs,int i) {
    super(context, attrs);
    if(i==0)
    {
    	  paint.setAntiAlias(true);
		  paint.setStrokeWidth(10f);
		  paint.setColor(Color.RED);
		  paint.setStyle(Paint.Style.STROKE);
		  paint.setStrokeJoin(Paint.Join.ROUND);
		  
    }
    if(i==1)
    {
    	  paint.setAntiAlias(true);
		  paint.setStrokeWidth(10f);
		  paint.setColor(Color.YELLOW);
		  paint.setStyle(Paint.Style.STROKE);
		  paint.setStrokeJoin(Paint.Join.ROUND);
		  
    }
    if(i==2)
    {
    	  paint.setAntiAlias(true);
		  paint.setStrokeWidth(10f);
		  paint.setColor(Color.BLUE);
		  paint.setStyle(Paint.Style.STROKE);
		  paint.setStrokeJoin(Paint.Join.ROUND);
		  
    }
    if(i==3)
    {
    	  paint.setAntiAlias(true);
		  paint.setStrokeWidth(10f);
		  paint.setColor(Color.BLACK);
		  paint.setStyle(Paint.Style.STROKE);
		  paint.setStrokeJoin(Paint.Join.ROUND);
		  
    }
    if(i==4)
    {
    	  paint.setAntiAlias(true);
		  paint.setStrokeWidth(10f);
		  paint.setColor(Color.WHITE);
		  paint.setStyle(Paint.Style.STROKE);
		  paint.setStrokeJoin(Paint.Join.MITER);
		  
    }
  }
  
 
@Override
public void onDraw(Canvas canvas) {
      canvas.drawPath(path,paint);
  }
@Override
public boolean onTouchEvent(MotionEvent event) {
    float eventX = event.getX();
    float eventY = event.getY();

    switch (event.getAction()) {
    case MotionEvent.ACTION_DOWN:
      path.moveTo(eventX, eventY);
      return true;
    case MotionEvent.ACTION_MOVE:
      path.lineTo(eventX, eventY);
      break;
    case MotionEvent.ACTION_UP:
      break;
    default:
      return false;
    }
 
    invalidate();
    return true;
  }

} 