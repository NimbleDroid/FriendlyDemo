package nyc.friendlyrobot.demo.interaction;

import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;

import nyc.friendlyrobot.demo.data.model.Post;
import nyc.friendlyrobot.demo.data.store.RedditStore;
import rx.Observable;

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
            return seedDB()
                    .flatMap(posts -> getPostsFromDB());
        }
        return getPostsFromDB();
    }

    @NonNull
    private Observable<List<Post>> getPostsFromDB() {
        return db.get().createQuery(TABLE_NAME, Post.SELECT_ALL)
                .mapToList(Post.MAPPER::map)
                .first();
    }

    private Observable<List<Post>> seedDB() {
        return store.get(LIMIT)
                .map(redditData -> redditData.data().children())
                .flatMap(saver::save);

    }
}
