package nyc.friendlyrobot.demo.ui.reddit;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import javax.inject.Inject;

import nyc.friendlyrobot.demo.ui.base.BaseActivity;

/**
 * Created by brianplummer on 12/16/15.
 */
public class RedditRecyclerView extends RecyclerView {

    @Inject
    PostAdapter postAdapter;

    public RedditRecyclerView(Context context) {
        this(context, null);
    }

    public RedditRecyclerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RedditRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        ((BaseActivity) context)
                .getActivityComponent()
                .inject(this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        setOrientation();
        setAdapter(postAdapter);
    }

    private void setOrientation() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        setLayoutManager(layoutManager);
    }
}
