package nyc.friendlyrobot.demo.data.store;

import android.app.Application;

import com.squareup.sqlbrite.BriteDatabase;

import javax.inject.Inject;

import nyc.friendlyrobot.demo.data.model.RedditData;
import nyc.friendlyrobot.demo.data.remote.Api;
import nyc.friendlyrobot.demo.data.store.base.BaseStore;
import rx.Observable;


public class RedditStore extends BaseStore<RedditData, String> {
    @Inject
    BriteDatabase db;
    @Inject
    Api api;

    @Inject
    Application application;


    @Inject
    public RedditStore() {

    }

    protected Observable<RedditData> fetch(String forceNetwork, String limit) {
        return api.aww("50",forceNetwork);
    }




}
