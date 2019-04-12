package com.example.maqiang8.appdemo;

import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.base.AbsBaseActivity;
import com.example.maqiang8.appdemo.presenter.MainPresenter;
import com.example.maqiang8.appdemo.view.IMainView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AbsBaseActivity implements IMainView {
    MainPresenter mainPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mainPresenter=MainPresenter.getInstance();
        mainPresenter.attachView(this);
        initView();
    }
    public void initView(){
        FragmentTabHost tabHost=findViewById(android.R.id.tabhost);
        tabHost.setup(this,getSupportFragmentManager(),R.id.root_layout);
        tabHost.addTab(tabHost.newTabSpec("first").setIndicator(createIndicatorView(0)),FirstFragment.class,null);
        tabHost.addTab(tabHost.newTabSpec("second").setIndicator(createIndicatorView(0)),FirstFragment.class,null);
        tabHost.addTab(tabHost.newTabSpec("third").setIndicator(createIndicatorView(0)),FirstFragment.class,null);
        tabHost.addTab(tabHost.newTabSpec("four").setIndicator(createIndicatorView(0)),FirstFragment.class,null);

        //getSupportFragmentManager().beginTransaction().replace(R.id.root_layout,)
    }
    public View createIndicatorView(int index){
        int icon=0;
        String title="";
        switch (index){
            case 0:
                icon=R.drawable.first_tab_icon_selector;
                title="first";
                break;
                default:break;
        }
        View view=View.inflate(MainActivity.this,R.layout.main_tab_indicator_layout,null);
        ImageView iv_icon=view.findViewById(R.id.iv_icon);
        iv_icon.setImageResource(icon);
        TextView tv_title=view.findViewById(R.id.tv_title);
        tv_title.setText(title);
        return view;
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.detachView();
    }
    @OnClick()
    public void onClick(View v) {
        int id=v.getId();
        switch (id){
            default:break;
        }
    }


}
