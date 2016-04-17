package nyc.friendlyrobot.demo.injection;

import android.app.Activity;

import nyc.friendlyrobot.demo.BoilerplateApplication;
import nyc.friendlyrobot.demo.injection.component.ActivityComponent;
import nyc.friendlyrobot.demo.injection.module.ActivityModule;

public final class ActivityComponentFactory {
    private ActivityComponentFactory() {
        //no op
    }

    public static ActivityComponent create(Activity activity) {
        return BoilerplateApplication.get(activity).getComponent()
                .plus(new ActivityModule(activity));
    }
}
