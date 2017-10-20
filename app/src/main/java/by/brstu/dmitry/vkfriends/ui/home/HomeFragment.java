package by.brstu.dmitry.vkfriends.ui.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.presenter.InjectPresenter;

import by.brstu.dmitry.vkfriends.R;
import by.brstu.dmitry.vkfriends.ui.all.base.BaseMvpFragment;

public class HomeFragment extends BaseMvpFragment implements HelloWorldView{

    @InjectPresenter
    HelloWorldPresenter helloWorldPresenter;


    public static HomeFragment getInstance() {
        return new HomeFragment();
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        return v;
    }

    @Override
    protected void onViewsBinded() {
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();

        if (actionBar != null) {
            actionBar.setTitle(R.string.home);
        }
    }

    @Override
    public void setHelloWorld(String string) {
        System.out.println(string);
    }
}
