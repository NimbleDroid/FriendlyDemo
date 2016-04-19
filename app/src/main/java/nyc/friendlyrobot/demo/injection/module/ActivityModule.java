package nyc.friendlyrobot.demo.injection.module;

import android.app.Activity;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import nyc.friendlyrobot.demo.injection.ScopeActivity;

@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    Activity provideActivity() {
        return mActivity;
    }

    @Provides
    @ScopeActivity
    Context providesContext() {
        return mActivity;
    }
}
