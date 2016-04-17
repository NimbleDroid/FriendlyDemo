package nyc.friendlyrobot.demo.interaction;

import java.util.List;

import javax.inject.Inject;

import nyc.friendlyrobot.demo.data.model.Post;
import nyc.friendlyrobot.demo.data.store.RedditStore;
import rx.Observable;
import rx.schedulers.Schedulers;

import static nyc.friendlyrobot.demo.data.model.Post.TABLE_NAME;

public class RedditReader extends Interaction {
    public static final String LIMIT = "50";

    private final RedditStore store;
    private final RedditSaver saver;

    @Inject
    public RedditReader(RedditStore store, RedditSaver saver) {
        this.store = store;
        this.saver = saver;
    }

    public Observable<List<Post>> readPosts() {
        if (!recordExists(Post.TABLE_NAME, Post._ID, "1")) {
            List<Post> post = seedDB(); //block on seeding on fresh install
        }

        return db.createQuery(TABLE_NAME, Post.SELECT_ALL)
                .mapToList(Post.MAPPER::map)
                .first();
    }

    private List<Post> seedDB() {
        List<Post> first = store.get(LIMIT)
                .subscribeOn(Schedulers.io())
                .map(redditData -> redditData.data().children())
                .flatMap(saver::save)
                .toBlocking()
                .first();
        return first;
    }
}
