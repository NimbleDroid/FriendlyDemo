package nyc.friendlyrobot.demo.ui.main;

import javax.inject.Inject;

import nyc.friendlyrobot.demo.ui.base.BasePresenter;
import rx.Subscription;

public class MainPresenter extends BasePresenter<RedditMVPView> {

//    private final FooStore fooStore;
    private Subscription mSubscription;

    @Inject
    public MainPresenter() {

    }

    @Override
    public void attachView(RedditMVPView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
        if (mSubscription != null) mSubscription.unsubscribe();
    }

    public void loadFoos() {
        checkViewAttached();

    }

}
