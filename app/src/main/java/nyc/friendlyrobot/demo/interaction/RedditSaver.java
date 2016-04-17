package nyc.friendlyrobot.demo.interaction;

import java.util.List;

import javax.inject.Inject;

import nyc.friendlyrobot.demo.data.model.Children;
import nyc.friendlyrobot.demo.data.model.Image;
import nyc.friendlyrobot.demo.data.model.Post;
import rx.Observable;

import static nyc.friendlyrobot.demo.data.model.Post.MAPPER;
import static nyc.friendlyrobot.demo.data.model.Post.Marshal;
import static nyc.friendlyrobot.demo.data.model.Post.SELECT_ALL;
import static nyc.friendlyrobot.demo.data.model.Post.TABLE_NAME;

public class RedditSaver extends Interaction {
    @Inject
    public RedditSaver() {
    }

    public Observable<List<Post>> save(List<Children> children) {
        return Observable
                .from(children)
                .map(Children::data)
                .doOnNext(this::insertPost)
                .toList()
                .flatMap(this::readPosts);
    }

    private Observable<List<Post>> readPosts(List<Post> posts) {
        return db.createQuery(TABLE_NAME, SELECT_ALL)
                .mapToList(MAPPER::map)
                .first(); //first is necessary since its an endless stream
    }

    private void insertPost(Post post) {
        if (!post.nestedThumbnail().isPresent()) {
            return;
        }
        Image image = post.nestedThumbnail().get();

        db.insert(TABLE_NAME, new Marshal()
                .title(post.title())
                .height(image.height())
                .width(image.width())
                .url(image.url())
                .asContentValues());
    }
}
