package nyc.friendlyrobot.demo.ui.reddit;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import nyc.friendlyrobot.demo.androidboilerplate.R;
import nyc.friendlyrobot.demo.data.model.Post;
import nyc.friendlyrobot.demo.ui.base.BaseActivity;


public class RedditView extends CoordinatorLayout implements RedditMVPView {
    @Inject
    RedditPresenter presenter;
    @Bind(R.id.postRecyclerView)
    RedditRecyclerView redditRecyclerView;

    public RedditView(Context context) {
        this(context, null);
    }

    public RedditView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RedditView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        ((BaseActivity) context)
                .getActivityComponent()
                .inject(this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        presenter.attachView(this);
        ButterKnife.bind(this);
        presenter.loadPosts();


    }

    @Override
    public void showPosts(List<Post> posts) {
        redditRecyclerView.postAdapter.setPosts(posts);
    }

    @Override
    public void onDetachedFromWindow() {
        presenter.detachView();
        ButterKnife.unbind(this);
        super.onDetachedFromWindow();
    }

    @Override
    public void showError() {
        //show error
    }
}
