package com.example.base.mvp.base;

public interface IPresenter<V> {
    void attachView(V view);
    void detachView();
}
