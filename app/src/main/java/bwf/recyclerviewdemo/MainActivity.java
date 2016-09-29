package bwf.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.rc_staggered)
    RecyclerView rcStaggered;

    private MyAdapter2 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
//        final GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        rcStaggered.setLayoutManager(layoutManager);

        initData();

        rcStaggered.setAdapter(adapter);
        rcStaggered.addItemDecoration(new SpacesItemDecoration());

        View headerView = View.inflate(this, R.layout.headerview, null);
        adapter.setHeaderView(headerView);

//        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//            @Override
//            public int getSpanSize(int position) {
//
//                int SpanSize = layoutManager.getSpanCount();//
//                return adapter.getItemViewType(position) == 0 ? SpanSize : 1;
//            }
//        });

    }

    private void initData() {
        adapter = new MyAdapter2(this);
        List<String> datas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            datas.add("123");
        }
        adapter.settList(datas);
    }
}
