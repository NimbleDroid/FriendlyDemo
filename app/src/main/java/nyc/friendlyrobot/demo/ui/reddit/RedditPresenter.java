package nyc.friendlyrobot.demo.ui.reddit;

import javax.inject.Inject;

import nyc.friendlyrobot.demo.data.store.RedditStore;
import nyc.friendlyrobot.demo.interaction.RedditSaver;
import nyc.friendlyrobot.demo.ui.base.BasePresenter;
import nyc.friendlyrobot.demo.ui.main.RedditMVPView;
import nyc.friendlyrobot.demo.util.FriendlyScheduler;
import rx.Subscription;

public class RedditPresenter extends BasePresenter<RedditMVPView> {

    public static final String LIMIT = "50";
    private final RedditStore store;
    private final RedditSaver saver;
    private Subscription subscription;

    @Inject
    public RedditPresenter(RedditStore store, RedditSaver saver) {
        this.store = store;
        this.saver = saver;
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
        subscription = store.get(LIMIT)
                .map(redditData -> redditData.data().children())
                .map(childrens -> childrens)
                .flatMap(saver::save)
                .compose(FriendlyScheduler.schedule())
                .subscribe(posts -> getMvpView().showPosts(posts),
                        throwable -> getMvpView().showError());
    }

}
