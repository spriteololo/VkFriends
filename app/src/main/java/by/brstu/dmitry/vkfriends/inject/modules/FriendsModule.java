package by.brstu.dmitry.vkfriends.inject.modules;

import javax.inject.Singleton;

import by.brstu.dmitry.vkfriends.inject.FriendsInterface;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class FriendsModule {

    @Provides
    @Singleton
    FriendsInterface provideFriendsApi(Retrofit retrofit) {
        return retrofit.create(FriendsInterface.class);
    }
}
