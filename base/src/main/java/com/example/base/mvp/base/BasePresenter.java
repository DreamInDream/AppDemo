package com.example.base.mvp.base;

public abstract class BasePresenter<V> implements IPresenter<V> {
    protected V mvpView;
    @Override
    public void attachView(V view) {this.mvpView=view; }
    @Override
    public void detachView() {this.mvpView=null; }
    public void onPause(){}
    public void onResume(){}
    public void onDestroy(){}
}
