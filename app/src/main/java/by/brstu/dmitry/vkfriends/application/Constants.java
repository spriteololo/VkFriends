package by.brstu.dmitry.vkfriends.application;


import by.brstu.dmitry.vkfriends.BuildConfig;

public class Constants {

    public interface MovieDbApi {
        String API_KEY = "92e0a05bf5b6e05f60a73954b743558f";

        String BASE_URL = "https://api.themoviedb.org/3/";
        String BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w342";
    }

    public static String TOKEN = null;

    public static final String BASE_URL = "https://api.themoviedb.org/3/";
    public static final String BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w342";
    public static final String API_KEY = "92e0a05bf5b6e05f60a73954b743558f";
    public static final int VERSION_CODE = BuildConfig.VERSION_CODE;
    public static final String VERSION_NAME = BuildConfig.VERSION_NAME;

    public interface MovieDetails {
         String[] MONTHS = {
                "January", "February", "March",
                "April", "May", "June",
                "July", "August", "September",
                 "October", "November", "December"
        };
        String[] TYPES = {
                "Premiere",
                "Theatrical (limited)",
                "Theatrical",
                "Digital",
                "Physical",
                "TV"
        };
    }

    public class Extras {
        public static final String ACTOR_ID = "extra_actor_id";
        public static final String MOVIE_ID = "extra_movie_id";
        public static final String TV_SHOW_ID = "extra_tv_id";
    }

    public class Screens {
        public static final String HOME_SCREEN = "home_screen_fragment";
        public static final String VK_AUTH = "vk_screen_fragment";

        public static final String MOVIES_SCREEN = "movies_screen_fragment";
        public static final String POPULAR_MOVIES_SCREEN = "popular_movies_screen";
        public static final String TOP_RATED_MOVIES_SCREEN = "top_rated_movies_screen";
        public static final String UPCOMING_MOVIES_SCREEN = "upcoming_movies_screen";

        public static final String ACTORS_SCREEN = "actors_screen_fragment";
        public static final String ONE_ACTOR_SCREEN = "one_actor_screen";

        public static final String TV_SCREEN = "tv_screen_fragment";
        public static final String TV_ACTIVITY_SCREEN = "tv_activity_screen";
        public static final String AIRING_TODAY_TV_SCREEN = "airing_today_tv_screen";
        public static final String ON_THE_AIR_TV_SCREEN = "on_the_air_tv_screen";
        public static final String POPULAR_TV_SCREEN = "popular_tv_screen";
        public static final String TOP_RATED_TV_SCREEN = "top_rated_tv_screen";

        public static final String SETTINGS_SCREEN = "settings_fragment";
    }

    public interface NetworkingConfig {
        int TIMEOUT = 20;
    }

}
