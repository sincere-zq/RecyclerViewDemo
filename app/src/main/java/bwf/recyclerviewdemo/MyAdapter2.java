package bwf.recyclerviewdemo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Lizhangfeng on 2016/9/13 0013.
 * Description:
 */
public class MyAdapter2 extends BaseRecyclerViewAdapter<String,MyAdapter2.MyHolder> {

    public MyAdapter2(Context context) {
        super(context);
    }

    @Override
    public MyHolder onMyCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_rc, null);
        return new MyHolder(view);
    }


    @Override
    public void onBindViewHolder(MyHolder holder, final int position, String bean) {


        if (position % 2 == 0) {
            holder.masonry_item_img.setImageResource(R.mipmap.test01);
        } else
            holder.masonry_item_img.setImageResource(R.mipmap.test_02);
        holder.masonry_item_title.setText("瀑布流测试");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "" + position, Toast.LENGTH_SHORT).show();
            }
        });

    }

    public class MyHolder extends BaseRecyclerViewAdapter.Holder {

        private ImageView masonry_item_img;
        private TextView masonry_item_title;

        public MyHolder(View itemView) {
            super(itemView);
            masonry_item_img = (ImageView) itemView.findViewById(R.id.masonry_item_img);
            masonry_item_title = (TextView) itemView.findViewById(R.id.masonry_item_title);

        }
    }


}
