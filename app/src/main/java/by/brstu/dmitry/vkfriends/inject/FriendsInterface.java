package by.brstu.dmitry.vkfriends.inject;

import by.brstu.dmitry.vkfriends.pojo.HelloWorldClass;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FriendsInterface {

    @GET("execute.fr")
    Observable<HelloWorldClass> getFriendsDetails(@Query("access_token") String token);

}
