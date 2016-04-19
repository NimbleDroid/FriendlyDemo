package nyc.friendlyrobot.demo.injection.component;

import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Component;
import nyc.friendlyrobot.demo.DemoApplication;
import nyc.friendlyrobot.demo.injection.module.ActivityModule;
import nyc.friendlyrobot.demo.injection.module.ApplicationModule;
import nyc.friendlyrobot.demo.injection.module.NetworkModule;

@Singleton
@Component(modules = {
        ApplicationModule.class,
        NetworkModule.class,
})
public interface ApplicationComponent {
    @NonNull
    ActivityComponent plus(@NonNull ActivityModule activityModule);

    void inject(@NonNull DemoApplication boxBeeApplication);
}
