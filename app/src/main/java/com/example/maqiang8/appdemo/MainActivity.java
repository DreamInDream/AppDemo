package com.example.maqiang8.appdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.maqiang8.appdemo.presenter.MainPresenter;
import com.example.maqiang8.appdemo.view.IMainView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements IMainView {
    private final String TAG="MainPressenter";
    MainPresenter mainPresenter;
    @BindView(R.id.bt_test)
    Button bt_test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mainPresenter=MainPresenter.getInstance();
        mainPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.detachView();
    }
    @OnClick({R.id.bt_test})
    public void onClick(View v) {
        int id=v.getId();
        switch (id){
            case R.id.bt_test:
                clickBtTest();
                break;
            default:break;
        }
    }
    public void clickBtTest(){
        mainPresenter.clickTest();
    }
    @Override
    public void test() {
        bt_test.setText("click");
        Log.e(TAG,"clickTest");
    }
}
