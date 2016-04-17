package nyc.friendlyrobot.demo.data.model;

import org.immutables.value.Value;

/**
 * Created by brianplummer on 12/19/15.
 */
@Value.Immutable
public abstract class Image {
    public abstract String url();
    public abstract int height();
    public abstract int width();
}
