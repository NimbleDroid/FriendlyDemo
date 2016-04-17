package nyc.friendlyrobot.demo.util;

import android.graphics.Bitmap;

import com.squareup.picasso.Transformation;

import nyc.friendlyrobot.demo.data.model.Image;

/**
 * Created by brianplummer on 12/19/15.
 */
public class BitmapTransform implements Transformation
{
    int maxWidth, maxHeight;
    Image key;
    public int targetWidth;
    public int targetHeight;

    public BitmapTransform(int maxWidth, int maxHeight, Image image) {
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
        this.key = image;

        double aspectRatio;
        if (image.width() >= image.height()) {
            targetWidth = maxWidth;
            aspectRatio = (double) image.height() / (double) image.width();
            targetHeight = (int) (targetWidth * aspectRatio);
        } else {
            targetHeight = maxHeight;
            aspectRatio = (double) image.width() / (double) image.height();
            targetWidth = (int) (targetHeight * aspectRatio);
        }
    }

    @Override
    public Bitmap transform(Bitmap source) {
        Bitmap result = Bitmap.createScaledBitmap(source, targetWidth,
                targetHeight, false);
        if (result != source) {
            source.recycle();
        }
        return result;
    }

    @Override
    public String key() {
        return key.url() + "_" + targetWidth + ":" + targetHeight;
    }
}
