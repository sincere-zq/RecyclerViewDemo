package bwf.recyclerviewdemo;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Lizhangfeng on 2016/9/13 0013.
 * Description:
 */
public class SpacesItemDecoration extends RecyclerView.ItemDecoration {

    private int space = 16;

    public SpacesItemDecoration() {
    }

    public SpacesItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        //间隔
        outRect.left = space;
        outRect.right = space;
        outRect.bottom = space;
        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.top = space;
        }
    }
}