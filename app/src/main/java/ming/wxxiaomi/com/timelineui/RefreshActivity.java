package ming.wxxiaomi.com.timelineui;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.lhh.ptrrv.library.PullToRefreshRecyclerView;
import com.lhh.ptrrv.library.footer.loadmore.DefaultLoadMoreView;
import com.mylhyl.crlayout.SwipeRefreshAdapterView;
import com.mylhyl.crlayout.SwipeRefreshRecyclerView;

import java.util.ArrayList;
import java.util.List;

import ming.wxxiaomi.com.timelineui.bean.MyModel;
import ming.wxxiaomi.com.timelineui.weight.adapter.LatsetAdapter;
import ming.wxxiaomi.com.timelineui.weight.util.FullyLinearLayoutManager;

public class RefreshActivity extends AppCompatActivity implements SwipeRefreshAdapterView.OnListLoadListener, SwipeRefreshLayout.OnRefreshListener {
    private Toolbar toolbar1;
    private FloatingActionButton btn_add;
//    private SwipeRefreshRecyclerView swipeRefreshRecyclerView;
PullToRefreshRecyclerView mPtrrv;
    private List<MyModel> list = new ArrayList<>();
    private LatsetAdapter adapter;
    private CollapsingToolbarLayout collapsing_toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh);
        toolbar1 = (Toolbar) findViewById(R.id.toolbar1);
        collapsing_toolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
//        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
//        mRecyclerView.setLayoutManager(getLinearLayoutManager());
//        mRecyclerView.setNestedScrollingEnabled(false);

//        swipeRefreshRecyclerView = (SwipeRefreshRecyclerView) findViewById(R.id.swipeRefresh);;
//        swipeRefreshRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
//        swipeRefreshRecyclerView.setOnListLoadListener(this);
//        swipeRefreshRecyclerView.setOnRefreshListener(this);
//        swipeRefreshRecyclerView.getScrollView().setNestedScrollingEnabled(false);

        mPtrrv = (PullToRefreshRecyclerView) this.findViewById(R.id.ptrrv);
        DefaultLoadMoreView defaultLoadMoreView = new DefaultLoadMoreView(this, mPtrrv.getRecyclerView());
//        DemoLoadMoreView loadMoreView = new DemoLoadMoreView(this, mPtrrv.getRecyclerView());
        defaultLoadMoreView.setLoadmoreString("加载更多");
        defaultLoadMoreView.setLoadMorePadding(100);
        mPtrrv.setSwipeEnable(false);
//        mPtrrv.setRefreshing(true);
        mPtrrv.setLayoutManager(new LinearLayoutManager(this));
        mPtrrv.setNestedScrollingEnabled(false);
        mPtrrv.setPagingableListener(new PullToRefreshRecyclerView.PagingableListener() {
            @Override
            public void onLoadMoreItems() {
                //do loadmore here
                Log.i("wang","onLoadMoreItems");
            }
        });

//        mPtrrv.onFinishLoading(true, false);
//        mPtrrv.set
        collapsing_toolbar.setTitle("我是标题");

        setSupportActionBar(toolbar1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        for(int i = 1;i <21;i++) {
            MyModel m = new MyModel();
            m.type = (i%4);
            if(i%2==0) m.pics="asdasd";
            list.add(m);
        }
        mPtrrv.setLoadMoreFooter(defaultLoadMoreView);
        adapter = new LatsetAdapter(list,this);
        adapter.setCount(20);
//        adapter.set
//        adapter.setc
//        swipeRefreshRecyclerView.setAdapter(adapter);
        mPtrrv.getRecyclerView().setAdapter(adapter);
        mPtrrv.onFinishLoading(true, false);
//        mPtrrv.setLoadMoreCount(1);
//        mPtrrv.set
    }

    private RecyclerView.LayoutManager getLinearLayoutManager() {
        return new FullyLinearLayoutManager(this);
    }

    @Override
    public void onListLoad() {

    }

    @Override
    public void onRefresh() {

    }
}
