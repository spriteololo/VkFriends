package by.brstu.dmitry.vkfriends.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.transition.TransitionManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Toast;

import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;
import com.vk.sdk.util.VKUtil;

import butterknife.BindView;
import by.brstu.dmitry.vkfriends.R;
import by.brstu.dmitry.vkfriends.application.BaseApplication;
import by.brstu.dmitry.vkfriends.application.Constants;
import by.brstu.dmitry.vkfriends.ui.all.base.BaseActivity;
import by.brstu.dmitry.vkfriends.ui.login.LoginFragment;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.android.SupportFragmentNavigator;
import ru.terrakok.cicerone.commands.BackTo;
import ru.terrakok.cicerone.commands.Command;
import ru.terrakok.cicerone.commands.Replace;

public class HomeScreenActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.navigation_view)
    NavigationView navigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;


    private String screenName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        String[] fingerprints = VKUtil.getCertificateFingerprint(this, this.getPackageName());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        VKCallback<VKAccessToken> callback = new VKCallback<VKAccessToken>() {
            @Override
            public void onResult(VKAccessToken res) {
                System.out.println("token = " + res.accessToken);
                Constants.TOKEN = res.accessToken;

            }

            @Override
            public void onError(VKError error) {
                System.out.println("Error! " + error.toString());
            }
        };

        if (!VKSdk.onActivityResult(requestCode, resultCode, data, callback)) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    protected void onViewsBinded() {
        setToolbar(toolbar, getString(R.string.app_name), true);

        navigator.applyCommand(new Replace(Constants.Screens.HOME_SCREEN, null));

        drawerLayout.addDrawerListener(new DrawerListener() {

            @Override
            public void onClosed() {
                if (screenName != null) {
                    navigator.applyCommand(new BackTo(null));
                    navigator.applyCommand(new Replace(screenName, null));
                    screenName = null;
                }
            }
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        BaseApplication.getNavigatorHolder().setNavigator(navigator);
    }

    @Override
    protected void onPause() {
        BaseApplication.getNavigatorHolder().removeNavigator();
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);

        switch (item.getItemId()) {
            case R.id.nav_home:
                screenName = Constants.Screens.HOME_SCREEN;
                break;
            case R.id.nav_login:
                screenName = Constants.Screens.VK_AUTH;
                break;
        }

        return true;
    }

    private Navigator navigator = new SupportFragmentNavigator(getSupportFragmentManager(),
            R.id.fragment_container) {

        @Override
        protected Fragment createFragment(String screenKey, Object data) {
            switch (screenKey) {
                case Constants.Screens.HOME_SCREEN:
                    return HomeFragment.getInstance();
                case Constants.Screens.VK_AUTH:
                    return LoginFragment.getInstance();

                default:
                    throw new RuntimeException("Unknown screen key!");
            }
        }

        @Override
        protected void setupFragmentTransactionAnimation(Command command, Fragment currentFragment,
                                                         Fragment nextFragment, FragmentTransaction fragmentTransaction) {
            ViewGroup viewGroup = findViewById(R.id.fragment_container);
            TransitionManager.beginDelayedTransition(viewGroup);
        }

        @Override
        protected void showSystemMessage(String message) {
            Toast.makeText(HomeScreenActivity.this, message, Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void exit() {
            finish();
        }

        @Override
        public void applyCommand(Command command) {
            super.applyCommand(command);
        }
    };
}
