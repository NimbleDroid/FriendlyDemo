package nyc.friendlyrobot.demo.data.model;

import org.immutables.value.Value;

/**
 * Created by brianplummer on 12/19/15.
 */
@Value.Immutable
public abstract class Children {
    public abstract Post data();
}
