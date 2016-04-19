package nyc.friendlyrobot.demo.ui.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import nyc.friendlyrobot.demo.injection.ActivityComponentFactory;
import nyc.friendlyrobot.demo.injection.component.ActivityComponent;
import nyc.friendlyrobot.demo.util.BundleService;

public abstract class BaseActivity extends AppCompatActivity {

    protected ActivityComponent activityComponent;
    private BundleService bundleService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());

    }


    public ActivityComponent getActivityComponent() {
        if (activityComponent == null) {
            activityComponent = ActivityComponentFactory.create(this);
        }
        return activityComponent;
    }

    public BundleService getBundleService() {
        return bundleService;
    }
    protected abstract int getLayout();


}
