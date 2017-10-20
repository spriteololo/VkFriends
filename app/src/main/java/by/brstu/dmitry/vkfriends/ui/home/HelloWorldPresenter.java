package by.brstu.dmitry.vkfriends.ui.home;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import by.brstu.dmitry.vkfriends.application.BaseApplication;
import by.brstu.dmitry.vkfriends.application.Constants;
import by.brstu.dmitry.vkfriends.inject.FriendsInterface;
import by.brstu.dmitry.vkfriends.pojo.HelloWorldClass;
import by.brstu.dmitry.vkfriends.ui.all.base.BaseMvpPresenter;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class HelloWorldPresenter extends BaseMvpPresenter<HelloWorldView>{
    @Inject
    FriendsInterface friendsInterface;

    public HelloWorldPresenter() {
        BaseApplication.getApplicationComponent().inject(this);
        refresh();
    }

    private void refresh() {
        friendsInterface.getFriendsDetails(Constants.TOKEN).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HelloWorldClass>() {

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull HelloWorldClass helloWorldClass) {
                        getViewState().setHelloWorld(helloWorldClass.getResponse());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e("err", "err");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
