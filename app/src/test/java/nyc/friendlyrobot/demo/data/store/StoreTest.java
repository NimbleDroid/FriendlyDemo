package nyc.friendlyrobot.demo.data.store;

import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;

import nyc.friendlyrobot.demo.BaseTestCase;
import nyc.friendlyrobot.demo.data.model.RedditData;


public class StoreTest extends BaseTestCase {
    @Inject
    RedditStore store;
    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void testStore() throws Exception {

        RedditData data = store.get("50").toBlocking().first();
        assertTrue(data.data().children().size()>0);

    }
}
