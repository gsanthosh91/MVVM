package com.gsanthosh.app.viewmodel;

import com.gsanthosh.app.api.APIInterface;
import com.gsanthosh.app.base.BaseViewModel;
import com.gsanthosh.app.interfaces.MainActivityView;
import com.gsanthosh.app.model.Post;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by gsanthosh91 on 06-02-2019.
 */

public class MainViewModel extends BaseViewModel<MainActivityView> {
    @Inject
    APIInterface apiInterface;

    @Inject
    public MainViewModel() {
    }

    public void fetchPosts() {
        view.showLoading();
        Observable<List<Post>> modelObservable = apiInterface.posts();

        compositeDisposable.add(modelObservable.subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(trendsResponse -> view.setPlacesList(trendsResponse),
                        throwable -> view.error(throwable)));
    }
}
