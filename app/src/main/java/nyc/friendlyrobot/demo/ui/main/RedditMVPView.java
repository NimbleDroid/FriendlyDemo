package nyc.friendlyrobot.demo.ui.main;

import java.util.List;

import nyc.friendlyrobot.demo.data.model.Post;
import nyc.friendlyrobot.demo.ui.base.MvpView;

public interface RedditMVPView extends MvpView {

//    void showLoo(List<Loo> ribots);

    void showError();
    void showPosts(List<Post> posts);

}
