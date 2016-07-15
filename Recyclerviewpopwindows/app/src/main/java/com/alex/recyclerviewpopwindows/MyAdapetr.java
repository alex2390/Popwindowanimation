package com.alex.recyclerviewpopwindows;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Alex on 2016/7/14.
 */
public class MyAdapetr extends RecyclerView.Adapter<MyAdapetr.ViewHolder> implements View.OnClickListener {
    private  Activity activity;
    private Context context;
    private List<Bean> datalist;
    private LayoutInflater inflater;
    private View view;



    public MyAdapetr(List<Bean> datalist,  Activity activity) {

        this.datalist= datalist;
        this.activity  =activity;
        inflater= LayoutInflater.from(activity);
    }



    class   ViewHolder extends RecyclerView.ViewHolder{
        ImageView operate;
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            operate = (ImageView) itemView.findViewById(R.id.operate);
            textView = (TextView) itemView.findViewById(R.id.tv);
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_layout,null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(datalist.get(position).getTitle());
        holder.operate.setImageResource(datalist.get(position).getResId());

        holder.operate.setOnClickListener(this);

    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }
    //点击事件
    @Override
    public void onClick(View v) {
        view = inflater.inflate(R.layout.pop_layout,null);
        PopWindowDownUtil popWindow = new PopWindowDownUtil(view,v,activity);
        popWindow.backgroundAlpha(0.5f);
        popWindow.showPopupWindow();


    }
}
