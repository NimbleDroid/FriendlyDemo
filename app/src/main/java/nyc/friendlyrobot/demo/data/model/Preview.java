package nyc.friendlyrobot.demo.data.model;

import org.immutables.value.Value;

import java.util.List;

@Value.Immutable
@Value.Style(allParameters = true)
public abstract class Preview {
    @Value.Parameter(false)
    public abstract List<Images> images();
}
