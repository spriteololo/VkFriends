package by.brstu.dmitry.vkfriends.inject;

import javax.inject.Singleton;

import by.brstu.dmitry.vkfriends.inject.modules.NetworkModule;
import by.brstu.dmitry.vkfriends.inject.modules.RetrofitModule;
import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class, RetrofitModule.class,
})
public interface ApplicationComponent {

}
