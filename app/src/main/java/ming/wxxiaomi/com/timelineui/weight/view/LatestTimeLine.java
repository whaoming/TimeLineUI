package ming.wxxiaomi.com.timelineui.weight.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

import ming.wxxiaomi.com.timelineui.R;


/**
 * Created by Administrator on 2016/12/6.
 */

public class LatestTimeLine extends View {

    private  Paint mPaint;
    private Drawable mMarker;
    private Drawable mStartLine;
    private Drawable mEndLine;

    private Rect mBounds;
    private Context mContext;
    public LatestTimeLine(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LatestTimeLine(Context context) {
        this(context, null);
    }

//    private int myTextSize =100;

    /**
     *   <attr name="point_color" format="color"/>
     <attr name="point_size" format="dimension"/>
     <attr name="text_color" format="color"/>
     <attr name="text_size" format="dimension"/>
     <attr name="line_color" format="color"/>
     <attr name="line_size" format="dimension"/>
     * @param context
     * @param attrs
     */

    private int text_size;
    private int text_color;
    private int point_color;
    private int point_size;
    private int line_color;
    private int line_size;
    private int mMarkerSize = 25;
    private String below_text = "评论";
    private int padding_left = 5;
    private int pading_bewteen = 2;
    private int paddingRight = 5;
    private String up_text = "08-16";
    private Rect mTimeBound;
    private Rect mOptionBound;

    public LatestTimeLine(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.LatestTimeLine, defStyle, 0);
        int n = a.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.LatestTimeLine_me_line_color:
                    line_color = a.getColor(attr,0);
                    mStartLine = a.getDrawable(R.styleable.LatestTimeLine_me_line_color);
                    mEndLine = a.getDrawable(R.styleable.LatestTimeLine_me_line_color);
                    break;
                case R.styleable.LatestTimeLine_me_line_size:
                    line_size =  a.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                            1, getResources().getDisplayMetrics()));;
                    break;
                case R.styleable.LatestTimeLine_me_point_color:
                    point_color =  a.getColor(attr,0);
                    break;
                case R.styleable.LatestTimeLine_me_point_size:
                    point_size =  a.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                            1, getResources().getDisplayMetrics()));;
                    break;
                case R.styleable.LatestTimeLine_me_text_color:
                    text_color = a.getColor(attr,0);
                    break;
                case R.styleable.LatestTimeLine_me_text_size:
                    text_size =  a.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                            16, getResources().getDisplayMetrics()));;
                    break;
            }

        }
        mMarker = mContext.getResources().getDrawable(R.drawable.marker);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mTimeBound = new Rect();
        mOptionBound = new Rect();
        mPaint.setTextSize(text_size);
        // 计算了描绘字体需要的范围
        mPaint.getTextBounds(below_text, 0, below_text.length(), mOptionBound);
        mPaint.getTextBounds(up_text, 0, up_text.length(), mTimeBound);
    }



    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int w = paddingRight+mMarkerSize+padding_left+pading_bewteen+point_size+Math.max(mOptionBound.width(),mTimeBound.width());
        int h =  getPaddingTop() + getPaddingBottom();
        int widthSize = resolveSizeAndState(w, widthMeasureSpec, 0);
        int heightSize = resolveSizeAndState(h, heightMeasureSpec, 0);

        setMeasuredDimension(widthSize, heightSize);
        initDrawable();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        initDrawable();
    }

    private void initDrawable() {
        int pLeft = getPaddingLeft();
        int pRight = getPaddingRight();
        int pTop = getPaddingTop();
        int pBottom = getPaddingBottom();

        int width = getWidth();// Width of current custom view
        int height = getHeight();


            int maxSize = Math.max(mTimeBound.width(),mOptionBound.width());
            if(mMarker != null) {
                mMarker.setBounds(padding_left+maxSize+pading_bewteen,pTop,padding_left+maxSize+pading_bewteen+mMarkerSize,pTop+mMarkerSize );
                mBounds = mMarker.getBounds();
            }
//        }

        int centerX = mBounds.centerX();
        int lineLeft = centerX ;

//                mStartLine.setBounds(lineLeft, 0, mLineSize + lineLeft, mBounds.top);
        mEndLine.setBounds(lineLeft, mBounds.bottom, 2 + lineLeft, height-7);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText(up_text,2,mTimeBound.height(),mPaint);
        canvas.drawText(below_text,2,mTimeBound.height()+mOptionBound.height()+2,mPaint);
        if(mMarker != null) {
            mMarker.draw(canvas);
        }

        if(mStartLine != null) {
            mStartLine.draw(canvas);
        }

        if(mEndLine != null) {
            mEndLine.draw(canvas);
        }
    }

    public void setMarker(Drawable marker) {
        mMarker = marker;
        initDrawable();
    }

    public void setStartLine(Drawable startline) {
        mStartLine = startline;
        initDrawable();
    }

    public void setEndLine(Drawable endLine) {
        mEndLine = endLine;
        initDrawable();
    }
//
//    public void setMarkerSize(int markerSize) {
//        mMarkerSize = markerSize;
//        initDrawable();
//    }
//
//    public void setLineSize(int lineSize) {
////        mLineSize = lineSize;
//        initDrawable();
//    }

    public void initLine(int viewType) {

        if(viewType == LineType.BEGIN) {
            setStartLine(null);
        } else if(viewType == LineType.END) {
            setEndLine(null);
        } else if(viewType == LineType.ONLYONE) {
            setStartLine(null);
            setEndLine(null);
        }

        initDrawable();
    }

    public static int getTimeLineViewType(int position, int total_size) {

        if(total_size == 1) {
            return LineType.ONLYONE;
        } else if(position == 0) {
            return LineType.BEGIN;
        } else if(position == total_size - 1) {
            return LineType.END;
        } else {
            return LineType.NORMAL;
        }
    }
}
