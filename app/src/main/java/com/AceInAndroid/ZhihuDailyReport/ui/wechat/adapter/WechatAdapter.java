package com.AceInAndroid.ZhihuDailyReport.ui.wechat.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.AceInAndroid.ZhihuDailyReport.widget.SquareImageView;
import com.AceInAndroid.ZhihuDailyReport.R;
import com.AceInAndroid.ZhihuDailyReport.app.Constants;
import com.AceInAndroid.ZhihuDailyReport.component.ImageLoader;
import com.AceInAndroid.ZhihuDailyReport.model.bean.WXItemBean;
import com.AceInAndroid.ZhihuDailyReport.ui.gank.activity.TechDetailActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by AceInAndroid on 17/4/29.
 */

public class WechatAdapter extends RecyclerView.Adapter<WechatAdapter.ViewHolder>{

    private Context mContext;
    private LayoutInflater inflater;
    private List<WXItemBean> mList;

    public WechatAdapter(Context mContext,List<WXItemBean> mList) {
        this.mContext = mContext;
        this.mList = mList;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_wechat, parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        ImageLoader.load(mContext,mList.get(position).getPicUrl(),holder.ivImage);
        holder.tvTitle.setText(mList.get(position).getTitle());
        holder.tvFrom.setText(mList.get(position).getDescription());
        holder.tvTime.setText(mList.get(position).getCtime());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TechDetailActivity.launch(new TechDetailActivity.Builder()
                        .setContext(mContext)
                        .setId(mList.get(holder.getAdapterPosition()).getPicUrl())//wechat API 没有id，用图片来做唯一数据库索引
                        .setImgUrl(mList.get(holder.getAdapterPosition()).getPicUrl())
                        .setTitle(mList.get(holder.getAdapterPosition()).getTitle())
                        .setUrl(mList.get(holder.getAdapterPosition()).getUrl())
                        .setType(Constants.TYPE_WECHAT));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_wechat_item_title)
        TextView tvTitle;
        @BindView(R.id.tv_wechat_item_time)
        TextView tvTime;
        @BindView(R.id.tv_wechat_item_from)
        TextView tvFrom;
        @BindView(R.id.iv_wechat_item_image)
        SquareImageView ivImage;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
