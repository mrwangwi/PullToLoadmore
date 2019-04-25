
    allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

    dependencies {
	     implementation 'com.github.mrwangwi:PullToLoadmore:6.0'
	}


1.in Xml

    <com.mrwangwei.pullloadmore.PullLoadMoreRecyclerView
        android:id="@+id/pull_load_more"
        android:layout_width="match_parent"
        android:layout_height="match_parent">
    </com.mrwangwei.pullloadmore.PullLoadMoreRecyclerView>


 2.in Activity

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


 3.in Listener

     @Override
     public void onRefresh() {
         page = 1;
         list.clear();
         list.addAll(数据);
         pullLoadMore.notifyDataChange();
     }

     @Override
     public void onLoadMore() {
         page++;
         list.addAll(数据);//根据自定义的条数自动判断是否还有更多数据
         pullLoadMore.notifyDataChange();
     }