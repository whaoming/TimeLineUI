package ming.wxxiaomi.com.timelineui.weight.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import ming.wxxiaomi.com.timelineui.R;
import ming.wxxiaomi.com.timelineui.weight.view.LatestTimeLine;


/**
 * Created by Administrator on 2016/12/3.
 */

public class LatestViewHolder extends RecyclerView.ViewHolder {
    public RelativeLayout foot_content;
    public TextView tv_option;
    public TextView tv_pic_title;

    public CardView no_img_content;
    public RelativeLayout pic_content;
    public TextView tv_no_pic_title;

    public LatestTimeLine time_marker;
    public LatestViewHolder(View itemView) {
        super(itemView);
        foot_content = (RelativeLayout) itemView.findViewById(R.id.rl_foot);
        tv_option = (TextView) itemView.findViewById(R.id.tv_option);
        tv_pic_title = (TextView) itemView.findViewById(R.id.tv_pic_title);
        pic_content = (RelativeLayout) itemView.findViewById(R.id.rl_pic_content);
        no_img_content = (CardView) itemView.findViewById(R.id.cv_no_img_content);
        tv_no_pic_title = (TextView) itemView.findViewById(R.id.tv_no_pic_title);
        time_marker = (LatestTimeLine) itemView.findViewById(R.id.time_marker);
    }
}
