package com.example.maqiang8.appdemo.presenter;

import com.example.base.mvp.base.BasePresenter;
import com.example.maqiang8.appdemo.view.IMainView;

public class MainPresenter extends BasePresenter<IMainView> {
    private final String TAG="MainPressenter";
    public MainPresenter(){

    }
    public static class MainPresenterHolder{
       public static final MainPresenter presenter=new MainPresenter();
    }
    public static final MainPresenter getInstance(){return MainPresenterHolder.presenter;}
}
