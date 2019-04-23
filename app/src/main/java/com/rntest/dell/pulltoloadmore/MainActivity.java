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
    private TestAdapter testAdapter;
    private int page = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        initView();
        pullLoadMore.setLinearLayout();
        testAdapter = new TestAdapter(R.layout.item_layout, list);
        testAdapter.setPagesize(10, pullLoadMore);
        testAdapter.addHeaderView(R.layout.top_layout);
        testAdapter.addFooterView(R.layout.bottom_layout);
        testAdapter.setEmptyViewLayout(R.layout.bottom_layout, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("setEmptyViewLayout", "setEmptyViewLayout");
            }
        });
        pullLoadMore.setAdapter(testAdapter);
        pullLoadMore.setOnPullLoadMoreListener(this);
    }

    private void initView() {
        pullLoadMore = findViewById(R.id.pull_load_more);
    }

    @Override
    public void onRefresh() {
        list.clear();
        page = 1;
        list.addAll(new ArrayList<TestBean>());
        testAdapter.dataNotify();
//        list.clear();
//        testAdapter.dataNotify();
    }

    @Override
    public void onLoadMore() {
        page++;
        if (page < 3) {
            list.addAll(creatList(10));
        } else {
            list.addAll(new ArrayList<TestBean>());
        }
        testAdapter.dataNotify();
    }


    private ArrayList<TestBean> creatList(int size) {
        ArrayList<TestBean> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(new TestBean());
        }
        return list;
    }
}
