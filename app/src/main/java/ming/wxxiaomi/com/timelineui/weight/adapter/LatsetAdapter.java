package ming.wxxiaomi.com.timelineui.weight.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

import ming.wxxiaomi.com.timelineui.bean.MyModel;
import ming.wxxiaomi.com.timelineui.bean.OptionType;
import ming.wxxiaomi.com.timelineui.R;

/**
 * Created by Administrator on 2016/12/6.
 */

public class LatsetAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<MyModel> list;
    private Context mContext;
    private int linePading;


    public LatsetAdapter(List<MyModel> feedList, Context context) {
        list = feedList;
        this.mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_option, null);
        return new LatestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        if (viewHolder instanceof LatestViewHolder) {
            LatestViewHolder holder = (LatestViewHolder) viewHolder;
            MyModel myModel = list.get(position);

            int flag = myModel.type+1;
//            Log.i("wang","flag:"+flag);
//            switch (flag) {
//                case OptionType.FOOT_PRINT:
////                    holder.time_marker.setMarker(mContext.getResources().getDrawable(R.mipmap.d1));
//                    holder.foot_content.setVisibility(View.GONE);
//                    holder.tv_option.setText("122627018来到了这里");
//                    setOption(holder.tv_option);
//                    holder.no_img_content.setVisibility(View.GONE);
//                    holder.pic_content.setVisibility(View.VISIBLE);
//                    holder.tv_pic_title.setVisibility(View.GONE);
//                    break;
//                case OptionType.TOPIC_PUBLISH:
////                    holder.time_marker.setMarker(mContext.getResources().getDrawable(R.mipmap.d2));
//                    holder.tv_option.setText("122627018发表了话题");
//                    holder.foot_content.setVisibility(View.VISIBLE);
//                    setOption(holder.tv_option);
//                    if(myModel.pics==null){
//                        holder.no_img_content.setVisibility(View.VISIBLE);
//                        holder.pic_content.setVisibility(View.GONE);
//                        holder.tv_no_pic_title.setText("我是没有图片的");
//                    }else{
//                        holder.no_img_content.setVisibility(View.GONE);
//                        holder.pic_content.setVisibility(View.VISIBLE);
//                        holder.tv_pic_title.setVisibility(View.VISIBLE);
//                        holder.tv_pic_title.setText("我是有图片的");
//                    }
//                    break;
//                case OptionType.TOPIC_COMMENT:
////                    holder.time_marker.setMarker(mContext.getResources().getDrawable(R.mipmap.d3));
//                    holder.tv_option.setText("122627018发表了评论");
//                    holder.foot_content.setVisibility(View.VISIBLE);
//                    setOption(holder.tv_option);
//                    if(myModel.pics==null){
//                        holder.no_img_content.setVisibility(View.VISIBLE);
//                        holder.pic_content.setVisibility(View.GONE);
//                        holder.tv_no_pic_title.setText("我是没有图片的");
//                    }else{
//                        holder.no_img_content.setVisibility(View.GONE);
//                        holder.pic_content.setVisibility(View.VISIBLE);
//                        holder.tv_pic_title.setVisibility(View.VISIBLE);
//                        holder.tv_pic_title.setText("我是有图片的");
//                    }
//                    break;
//                case OptionType.PHOTO_PUBLISH:
////                    holder.time_marker.setMarker(mContext.getResources().getDrawable(R.mipmap.d4));
//                    holder.no_img_content.setVisibility(View.GONE);
//                    holder.foot_content.setVisibility(View.GONE);
//                    holder.tv_option.setText("122627018更新了相册");
//                    setOption(holder.tv_option);
//                    holder.tv_pic_title.setVisibility(View.GONE);
//                    holder.pic_content.setVisibility(View.VISIBLE);
//                    break;
//
//
//            }
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setOption(TextView tv){
        SpannableStringBuilder builder = new SpannableStringBuilder(tv.getText().toString());
        ForegroundColorSpan redSpan = new ForegroundColorSpan(Color.BLUE);
        builder.setSpan(redSpan, 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv.setText(builder);
    }

    public int getLinePading(){
        return linePading;
    }
}
