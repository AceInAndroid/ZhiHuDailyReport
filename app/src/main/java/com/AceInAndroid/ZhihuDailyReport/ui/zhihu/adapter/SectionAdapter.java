package com.AceInAndroid.ZhihuDailyReport.ui.zhihu.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.AceInAndroid.ZhihuDailyReport.app.App;
import com.AceInAndroid.ZhihuDailyReport.ui.zhihu.activity.SectionActivity;
import com.AceInAndroid.ZhihuDailyReport.R;
import com.AceInAndroid.ZhihuDailyReport.component.ImageLoader;
import com.AceInAndroid.ZhihuDailyReport.model.bean.SectionListBean;
import com.AceInAndroid.ZhihuDailyReport.util.SystemUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by AceInAndroid on 17/4/21.
 */

public class SectionAdapter extends RecyclerView.Adapter<SectionAdapter.ViewHolder>{

    private Context mContext;
    private List<SectionListBean.DataBean> mList;
    private LayoutInflater inflater;

    public SectionAdapter(Context mContext,List<SectionListBean.DataBean> mList) {
        this.mContext = mContext;
        this.mList = mList;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_section,parent,false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        //Glide在加载GridView等时,由于ImageView和Bitmap实际大小不符合,第一次时加载可能会变形(我这里出现了放大),必须在加载前再次固定ImageView大小
        ViewGroup.LayoutParams lp = holder.ivBg.getLayoutParams();
        lp.width = (App.SCREEN_WIDTH - SystemUtil.dp2px(mContext,12)) / 2;
        lp.height = SystemUtil.dp2px(mContext,120);

        ImageLoader.load(mContext,mList.get(position).getThumbnail(),holder.ivBg);
        holder.tvKind.setText(mList.get(position).getName());
        holder.tvDes.setText(mList.get(position).getDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(mContext, SectionActivity.class);
                intent.putExtra("id",mList.get(holder.getAdapterPosition()).getId());
                intent.putExtra("title",mList.get(holder.getAdapterPosition()).getName());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.section_bg)
        ImageView ivBg;
        @BindView(R.id.section_kind)
        TextView tvKind;
        @BindView(R.id.section_des)
        TextView tvDes;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
