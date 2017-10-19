package by.brstu.dmitry.vkfriends.application;

import android.app.Application;


import com.vk.sdk.VKSdk;

import by.brstu.dmitry.vkfriends.R;
import by.brstu.dmitry.vkfriends.inject.ApplicationComponent;
import by.brstu.dmitry.vkfriends.inject.DaggerApplicationComponent;
import by.brstu.dmitry.vkfriends.inject.modules.NetworkModule;
import by.brstu.dmitry.vkfriends.inject.modules.RetrofitModule;
import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class BaseApplication extends Application {

    private static ApplicationComponent applicationComponent;
    private static Cicerone<Router> cicerone;

    public static ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    public static NavigatorHolder getNavigatorHolder() {
        return cicerone.getNavigatorHolder();
    }

    public static Router getRouter() {
        return cicerone.getRouter();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        initCalligraphy();
        initApplicationComponent();
        initCicerone();
        VKSdk.initialize(getApplicationContext());
    }

    private void initCalligraphy() {
        final String defaultFontPath = getString(R.string.font_regular_path);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath(defaultFontPath)
                .setFontAttrId(R.attr.fontPath)
                .build());
    }

    private void initApplicationComponent() {
        applicationComponent = DaggerApplicationComponent.builder()
                .retrofitModule(new RetrofitModule(Constants.MovieDbApi.BASE_URL))
                .networkModule(new NetworkModule(Constants.NetworkingConfig.TIMEOUT))
                .build();
    }

    private void initCicerone() {
        cicerone = Cicerone.create();
    }
}
