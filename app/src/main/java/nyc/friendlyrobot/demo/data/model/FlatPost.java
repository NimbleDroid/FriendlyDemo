package nyc.friendlyrobot.demo.data.model;

import android.support.annotation.Nullable;

import org.immutables.value.Value;

/**
 * Created by brianplummer on 12/19/15.
 */
@Value.Immutable
@Value.Style(allParameters = true)
public abstract class FlatPost implements PostModel {
    public static final Mapper<FlatPost> MAPPER =
            new Mapper<>((Mapper.Creator<FlatPost>) ImmutableFlatPost::of);

    public static final class Marshal extends PostMarshal {
    }


    @Value.Parameter(false)
    @Nullable
    public abstract Image image();


}
