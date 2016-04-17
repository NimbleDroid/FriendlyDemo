package nyc.friendlyrobot.demo.ui.reddit;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import nyc.friendlyrobot.demo.androidboilerplate.R;
import nyc.friendlyrobot.demo.data.model.Image;
import nyc.friendlyrobot.demo.data.model.ImmutableImage;
import nyc.friendlyrobot.demo.data.model.Post;
import nyc.friendlyrobot.demo.ui.base.BaseActivity;
import nyc.friendlyrobot.demo.util.BitmapTransform;
import nyc.friendlyrobot.demo.util.DeviceUtils;


public class PostViewHolder extends RecyclerView.ViewHolder {

    private int maxHeight;
    private int maxWidth;
    private TextView title;
    private ImageView thumbnail;
    private View topSpacer;
    @Inject
    DeviceUtils deviceUtils;

    public PostViewHolder(View itemView) {
        super(itemView);
        performInjection(itemView);
        findViews(itemView);
        setMaxDimensions(itemView);
    }

    public void onBind(Post article) {
        title.setText(article.title());
        showImage(article);
    }

    private void showImage(Post article) {
        Image image = ImmutableImage
                .builder()
                .height(article.height())
                .width(article.width())
                .url(article.url())
                .build();
        BitmapTransform bitmapTransform = new BitmapTransform(maxWidth, maxHeight, image);

        int targetWidth = bitmapTransform.targetWidth;
        int targetHeight = bitmapTransform.targetHeight;

        setSpacer(targetWidth, targetHeight);

        setupThumbnail(targetWidth, targetHeight);

        Picasso.with(itemView.getContext())
                .load(image.url())
                .transform(bitmapTransform)
                .resize(targetWidth, targetHeight)
                .centerInside()
                .placeholder(R.color.gray80)
                .into(thumbnail);
    }

    private void setSpacer(int targetWidth, int targetHeight) {
        if (targetWidth >= targetHeight) {
            topSpacer.setVisibility(View.GONE);
        } else {
            topSpacer.setVisibility(View.VISIBLE);
        }
    }

    private void setupThumbnail(int targetWidth, int targetHeight) {
        thumbnail.setMaxWidth(targetWidth);
        thumbnail.setMaxHeight(targetHeight);
        thumbnail.setMinimumWidth(targetWidth);
        thumbnail.setMinimumHeight(targetHeight);
        thumbnail.requestLayout();
    }

    private void setMaxDimensions(View itemView) {
        int screenWidth;
        int screenHeight;
        screenWidth = deviceUtils.getScreenWidth();
        screenHeight = deviceUtils.getScreenHeight();

        if (screenWidth > screenHeight) {
            screenHeight = deviceUtils.getScreenWidth();
            screenWidth = deviceUtils.getScreenHeight();
        }

        maxHeight = (int) (screenHeight * .55f);
        int margin = itemView.getContext().getResources().getDimensionPixelSize(R.dimen.post_horizontal_margin);
        maxWidth = screenWidth - (2 * margin);
    }

    private void findViews(View itemView) {
        title = (TextView) itemView.findViewById(R.id.title);
        thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
        topSpacer = itemView.findViewById(R.id.topSpacer);
    }

    private void performInjection(View itemView) {
        ((BaseActivity) itemView.getContext())
                .getActivityComponent()
                .inject(this);
    }
}
