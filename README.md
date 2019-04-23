1.in Xml

    <com.mrwangwei.pullloadmore.PullLoadMoreRecyclerView
        android:id="@+id/pull_load_more"
        android:layout_width="match_parent"
        android:layout_height="match_parent">
    </com.mrwangwei.pullloadmore.PullLoadMoreRecyclerView>

 2.in Activity

    pullLoadMore.setLinearLayout();
    adapter = new TestAdapter(R.layout.item_layout, list);
    adapter.setPagesize(10, pullLoadMore);//这句必须加 10为自定义每页条数
    pullLoadMore.setAdapter(testAdapter);
    pullLoadMore.setOnPullLoadMoreListener(this);


 3.in Listener

     @Override
     public void onRefresh() {
         page = 1;
         list.clear();
         list.addAll(数据);
         testAdapter.dataNotify();
     }

     @Override
     public void onLoadMore() {
         page++;
         list.addAll(数据);//根据自定义的条数自动判断是否还有更多数据
         testAdapter.dataNotify();
     }