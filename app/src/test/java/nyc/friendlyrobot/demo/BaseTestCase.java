package nyc.friendlyrobot.demo;

import junit.framework.TestCase;

import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import nyc.friendlyrobot.demo.androidboilerplate.BuildConfig;
import nyc.friendlyrobot.demo.injection.module.ApplicationModule;
import nyc.friendlyrobot.demo.util.Dagger2Helper;
import nyc.friendlyrobot.demo.util.TestConstants;


@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = TestConstants.SDK_EMULATE_LEVEL, packageName = TestConstants.APP_PACKAGE_NAME)
public abstract class BaseTestCase extends TestCase {


    protected TestCompontentInterface getTestGraph() {
        return Dagger2Helper.buildComponent(TestComponent.class, getApplicationModule());
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        Dagger2Helper.inject(TestComponent.class, getTestGraph(), this);
    }

    protected ApplicationModule getApplicationModule() {
        return new ApplicationModule(RuntimeEnvironment.application);
    }
}
