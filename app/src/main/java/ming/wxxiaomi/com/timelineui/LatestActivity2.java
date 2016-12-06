package ming.wxxiaomi.com.timelineui;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import ming.wxxiaomi.com.timelineui.bean.MyModel;
import ming.wxxiaomi.com.timelineui.weight.adapter.LatsetAdapter;
import ming.wxxiaomi.com.timelineui.weight.util.FullyLinearLayoutManager;

public class LatestActivity2 extends AppCompatActivity {
    private Toolbar toolbar1;
    private FloatingActionButton btn_add;
    private RecyclerView mRecyclerView;
    private List<MyModel> list = new ArrayList<>();
    private LatsetAdapter adapter;
    private CollapsingToolbarLayout collapsing_toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latest2);
        toolbar1 = (Toolbar) findViewById(R.id.toolbar1);
        collapsing_toolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(getLinearLayoutManager());
        mRecyclerView.setNestedScrollingEnabled(false);
        collapsing_toolbar.setTitle("我是标题");
        setSupportActionBar(toolbar1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        for(int i = 1;i <21;i++) {
            MyModel m = new MyModel();
            m.type = (i%4);
            if(i%2==0) m.pics="asdasd";
            list.add(m);
        }

        adapter = new LatsetAdapter(list,this);
        mRecyclerView.setAdapter(adapter);
    }

    private RecyclerView.LayoutManager getLinearLayoutManager() {
        return new FullyLinearLayoutManager(this);
    }
}
