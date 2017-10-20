package by.brstu.dmitry.vkfriends.inject;

import javax.inject.Singleton;

import by.brstu.dmitry.vkfriends.inject.modules.FriendsModule;
import by.brstu.dmitry.vkfriends.inject.modules.NetworkModule;
import by.brstu.dmitry.vkfriends.inject.modules.RetrofitModule;
import by.brstu.dmitry.vkfriends.ui.home.HelloWorldPresenter;
import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class, RetrofitModule.class,
        FriendsModule.class
})
public interface ApplicationComponent {

    void inject(HelloWorldPresenter helloWorldPresenter);
}
