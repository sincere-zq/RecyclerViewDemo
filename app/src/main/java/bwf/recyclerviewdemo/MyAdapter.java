package bwf.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Lizhangfeng on 2016/9/13 0013.
 * Description:
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Context context;

    private List<String> stringList;

    public static final int TYPE_HEADER = 0;//type为0表示为headerView
    public static final int TYPE_NORMAL = 1;//type为1表示为正常的item

    private View headerView;

    public MyAdapter(Context context) {
        this.context = context;
    }

    public View getHeaderView() {
        return headerView;
    }

    public void setHeaderView(View headerView) {
        this.headerView = headerView;
        notifyItemInserted(0);
//        notifyItemChanged(2);
//        notifyItemRangeChanged(2,10);
//        notifyItemRemoved(2);
//        notifyItemRangeRemoved(2,10);

    }

    @Override
    public int getItemViewType(int position) {
        if (headerView != null && position == 0)
            return TYPE_HEADER;
        return TYPE_NORMAL;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (headerView != null && viewType == TYPE_HEADER) {
            return new ViewHolder(headerView);
        }
        View view = View.inflate(context, R.layout.item_rc, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        if (position == 0)
            return;

//        stringList.get(position-1)

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

    @Override
    public int getItemCount() {
        return 20;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView masonry_item_img;
        private TextView masonry_item_title;

        public ViewHolder(View itemView) {
            super(itemView);
            masonry_item_img = (ImageView) itemView.findViewById(R.id.masonry_item_img);
            masonry_item_title = (TextView) itemView.findViewById(R.id.masonry_item_title);

        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);

        if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
            final GridLayoutManager layoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
            layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {

                    int SpanSize = layoutManager.getSpanCount();//
                    return getItemViewType(position) == 0 ? SpanSize : 1;
                }
            });
        }
    }

    @Override
    public void onViewAttachedToWindow(ViewHolder holder) {
        super.onViewAttachedToWindow(holder);

        ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
        if (lp != null && lp instanceof StaggeredGridLayoutManager.LayoutParams && holder.getLayoutPosition() == 0) {
            ((StaggeredGridLayoutManager.LayoutParams) lp).setFullSpan(true);
        }

    }
}
