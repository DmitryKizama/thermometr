package com.stzemo.tthermometer.custom.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.stzemo.tthermometer.R;

public class LineTemperatureView extends View {

    private Paint _paintDoodle = new Paint();
    private int finishPoint = 0;
    private int shiftWidth = 0;

    public LineTemperatureView(Context context) {
        super(context);
        init(null, 0);
    }

    public LineTemperatureView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public LineTemperatureView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr);
    }

    private void init(AttributeSet attrs, int defStyleAttr) {
        _paintDoodle.setColor(getResources().getColor(R.color.term_color));
        _paintDoodle.setAntiAlias(true);
        _paintDoodle.setStyle(Paint.Style.STROKE);
        Log.d("CustomView", "width = " + getWidth());
        int strokeWidth = 132 * 12 / 62;
        _paintDoodle.setStrokeWidth(strokeWidth);
        final float scale = getContext().getResources().getDisplayMetrics().density;
        shiftWidth = (int) (1.5 * scale + 0.5f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("CustomView", "width = " + getMeasuredWidth());
//        int strokeWidth = getWidth() * 10 / 102;
//        _paintDoodle.setStrokeWidth(strokeWidth);

        canvas.drawLine(canvas.getWidth() / 2 - shiftWidth, canvas.getHeight() - 200, canvas.getWidth() / 2 - shiftWidth, finishPoint, _paintDoodle);
    }

    public void drawToPosition(int x) {
        finishPoint = x;
        invalidate();
    }
}
