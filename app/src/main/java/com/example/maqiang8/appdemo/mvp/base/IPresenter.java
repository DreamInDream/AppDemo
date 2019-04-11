package com.example.maqiang8.appdemo.mvp.base;

public interface IPresenter<V> {
    void attachView(V view);
    void detachView();
}
