package by.brstu.dmitry.vkfriends.ui.home;

import android.support.v4.widget.DrawerLayout;
import android.view.View;

public abstract class DrawerListener implements DrawerLayout.DrawerListener {

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {

    }

    @Override
    public void onDrawerOpened(View drawerView) {

    }

    @Override
    public void onDrawerClosed(View drawerView) {
        onClosed();
    }

    @Override
    public void onDrawerStateChanged(int newState) {

    }

    public abstract void onClosed();
}
