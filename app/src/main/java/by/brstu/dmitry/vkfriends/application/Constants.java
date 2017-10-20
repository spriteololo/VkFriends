package by.brstu.dmitry.vkfriends.application;


import by.brstu.dmitry.vkfriends.BuildConfig;

public class Constants {

    public interface VkApi {

        String BASE_URL = "https://api.vk.com/method/";
    }

    public static String TOKEN = null;
    public static final String API_VERSION = "5.68";

    public static final int VERSION_CODE = BuildConfig.VERSION_CODE;
    public static final String VERSION_NAME = BuildConfig.VERSION_NAME;


    public class Screens {
        public static final String HOME_SCREEN = "home_screen_fragment";
        public static final String VK_AUTH = "vk_screen_fragment";


        public static final String SETTINGS_SCREEN = "settings_fragment";
    }

    public interface NetworkingConfig {
        int TIMEOUT = 20;
    }

}
