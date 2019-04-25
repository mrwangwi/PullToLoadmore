package com.rntest.dell.pulltoloadmore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.mrwangwei.pullloadmore.PullLoadMoreRecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PullLoadMoreRecyclerView.PullLoadMoreListener {

    private ArrayList<TestBean> list = new ArrayList<>();
    protected PullLoadMoreRecyclerView pullLoadMore;
    private int page = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        initView();
        //实例化BaseQuickAdapter并设置给PullLoadMoreRecyclerView
        pullLoadMore.setAdapter(new TestAdapter(R.layout.item_layout, list));

        pullLoadMore.setLinearLayout();//设置布局
        pullLoadMore.setPagesize(10);//设置分页条数
        pullLoadMore.setHeaderView(R.layout.top_layout);//设置头布局
        pullLoadMore.setFooterView(R.layout.bottom_layout);//设置尾布局
        //设置暂无数据布局，支持添加点击
        pullLoadMore.setEmptyViewLayout(R.layout.bottom_layout, new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        pullLoadMore.setCanPullIfNotFull(false);//分页内容未充满屏幕自动添加数据
        pullLoadMore.setOnPullLoadMoreListener(this);//添加下拉刷新上拉加载
        //pullLoadMore.setOnPullLoadListener(this);//添加下拉刷新,两种监听自适应，不可同时存在
    }

    private void initView() {
        pullLoadMore = findViewById(R.id.pull_load_more);
    }

    @Override
    public void onRefresh() {
        list.clear();
        page = 1;
        list.addAll(creatList(10));
        pullLoadMore.notifyDataChange();
    }

    @Override
    public void onLoadMore() {
        page++;
        if (page < 10) {
            list.addAll(creatList(10));
        } else {
            list.addAll(creatList(3));
        }
        pullLoadMore.notifyDataChange();
    }


    private ArrayList<TestBean> creatList(int size) {
        ArrayList<TestBean> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(new TestBean());
        }
        return list;
    }
}
