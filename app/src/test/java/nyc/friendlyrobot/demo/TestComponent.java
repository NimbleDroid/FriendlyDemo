package nyc.friendlyrobot.demo;


import javax.inject.Singleton;

import dagger.Component;
import nyc.friendlyrobot.demo.data.store.StoreTest;
import nyc.friendlyrobot.demo.injection.module.ApplicationModule;
import nyc.friendlyrobot.demo.injection.module.NetworkModule;

//Component that sets up singleton scope and
// adds modules that test classes will use
@Singleton
@Component(
        modules = {ApplicationModule.class,
                NetworkModule.class,
                TestBaseModule.class, TestModule.class}
)
public interface TestComponent extends TestCompontentInterface{
    void inject(BaseTestCase test);
    void inject(StoreTest test);
}
