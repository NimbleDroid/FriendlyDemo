package nyc.friendlyrobot.demo.data.remote;

import nyc.friendlyrobot.demo.data.model.RedditData;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import rx.Observable;

public interface Api {

    String ENDPOINT = "https://api.ribot.io/";


    @GET("r/aww/new/.json")
    Observable<RedditData> aww(@Query("limit") String limit, @Header("fresh") String fresh);
}
