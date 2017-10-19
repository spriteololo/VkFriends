package by.brstu.dmitry.vkfriends.inject.modules;

import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitModule {

    @NonNull
    private final String movieDbUrl;

    public RetrofitModule(@NonNull final String movieDbUrl) {
        this.movieDbUrl = movieDbUrl;
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(@NonNull final OkHttpClient okHttpClient) {
        final OkHttpClient.Builder okHttpBuilder = okHttpClient.newBuilder();

        return new Retrofit.Builder()
                .baseUrl(movieDbUrl)
                .client(okHttpBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
}
