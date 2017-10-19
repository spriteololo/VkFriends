package by.brstu.dmitry.vkfriends.ui.all.base;

import android.support.v4.widget.NestedScrollView;

public abstract class BlurScrollListener implements NestedScrollView.OnScrollChangeListener {

    @Override
    public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
        boolean clickable = true;
        float transparencyValue = 0;

        transparencyValue += scrollY / 10;
        transparencyValue /= 100;

        if (transparencyValue > 0.1)
            clickable = false;

        if (transparencyValue < 0)
            transparencyValue = 0;

        if (transparencyValue > 1)
            transparencyValue = 1;

        changeBlurAndTransparentLevel(transparencyValue, clickable);
    }

    public abstract void changeBlurAndTransparentLevel(float transparencyValue, boolean clickable);
}
