package nyc.friendlyrobot.demo.util;

public class TestConstants {

    /**
     * Needed for Robolectric because we set package name dynamically per flavor/buildType
     * and Robolectric not able to inference it automatically.
     */
    public static final String APP_PACKAGE_NAME = "nyc.friendlyrobot.anchor";

    /**
     * Android SDK level we're emulating in tests via Robolectric.
     * Should be changed as soon as Robolectric will support newer api.
     */
    public static final int SDK_EMULATE_LEVEL = 21;

    private TestConstants() {
        throw new IllegalStateException("No instances, please!");
    }
}
