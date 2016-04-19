package nyc.friendlyrobot.demo.ui.reddit;

import javax.inject.Inject;

import nyc.friendlyrobot.demo.interaction.RedditReader;
import nyc.friendlyrobot.demo.ui.base.BasePresenter;
import nyc.friendlyrobot.demo.util.FriendlyScheduler;
import rx.Subscription;

public class RedditPresenter extends BasePresenter<RedditMVPView> {


    private final RedditReader redditReader;
    private Subscription subscription;

    @Inject
    public RedditPresenter(RedditReader redditReader) {

        this.redditReader = redditReader;
    }

    @Override
    public void attachView(RedditMVPView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
        if (subscription != null) subscription.unsubscribe();
    }

    public void loadPosts() {
        checkViewAttached();
        subscription = redditReader.readPosts()
                .compose(FriendlyScheduler.schedule())
                .subscribe(posts -> getMvpView().showPosts(posts),
                        throwable -> getMvpView().showError());
    }

}
