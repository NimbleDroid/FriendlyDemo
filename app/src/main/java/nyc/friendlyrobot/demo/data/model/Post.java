package nyc.friendlyrobot.demo.data.model;

import android.support.annotation.Nullable;

import com.google.common.base.Optional;

import org.immutables.value.Value;

/**
 * Created by brianplummer on 12/19/15.
 */
@Value.Immutable
@Value.Style(allParameters = true)
public abstract class Post implements PostModel {
    public static final Mapper<Post> MAPPER =
            new Mapper<>((Mapper.Creator<Post>) ImmutablePost::of);

    public static final class Marshal extends PostMarshal {
    }

    @Value.Parameter(false)
    @Nullable
    public abstract Preview preview();

    @Value.Parameter(false)
    @Value.Derived
    public Optional<Image> nestedThumbnail() {
        if(preview()==null||preview().images()==null||preview().images().get(0).source()==null)
        return Optional.absent();
            return Optional.of(preview().images().get(0).source());
    }


}
