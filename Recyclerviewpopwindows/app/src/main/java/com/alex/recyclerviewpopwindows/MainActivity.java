package com.alex.recyclerviewpopwindows;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Bean > datalist;
    private Integer[] resid = {R.drawable.ic_operate};
    private String[] title = {"起风了"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    private void initData() {
        datalist= new ArrayList<>();
        for(int i=0;i<20;i++){
            Bean bean = new Bean();
            bean.setTitle(title[i%title.length]);
            bean.setResId(resid[i%resid.length]);

            datalist.add(bean);
        }}

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        MyAdapetr adpter =new MyAdapetr(datalist,this);
        recyclerView.setAdapter(adpter);

        //设置布局管理
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        //设置分割线
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));


    }
}
