package com.gsanthosh.app.base;

import io.reactivex.disposables.CompositeDisposable;

/**
 *
 *
 */

public class BaseViewModel<T extends IView> {

    protected CompositeDisposable compositeDisposable;
    protected T view;

    public BaseViewModel() {
        compositeDisposable = new CompositeDisposable();
    }

    public void attach(T view) {
        this.view = view;
    }

    public void detach() {
        view = null;
    }

    public void clearSubscriptions() {
        compositeDisposable.clear();
    }

}
