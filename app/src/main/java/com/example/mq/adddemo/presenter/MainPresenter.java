package com.example.mq.adddemo.presenter;

import com.example.base.mvp.base.BasePresenter;
import com.example.mq.adddemo.view.IMainView;

public class MainPresenter extends BasePresenter<IMainView> {
    private final String TAG="MainPressenter";
    public MainPresenter(){

    }
    public static class MainPresenterHolder{
       public static final MainPresenter presenter=new MainPresenter();
    }
    public static final MainPresenter getInstance(){return MainPresenterHolder.presenter;}
}
