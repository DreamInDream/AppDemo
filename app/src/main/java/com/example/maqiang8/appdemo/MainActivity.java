package com.example.maqiang8.appdemo;

import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.base.AbsBaseActivity;
import com.example.maqiang8.appdemo.presenter.MainPresenter;
import com.example.maqiang8.appdemo.view.IMainView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AbsBaseActivity implements IMainView {
    MainPresenter mainPresenter;
    private final int INDEX_FRAGMENT_FIRST=0;
    private final int INDEX_FRAGMENT_SECOND=1;
    private final int INDEX_FRAGMENT_THIRD=2;
    private final int INDEX_FRAGMENT_FOUR=3;
    private final String TAB_SPEC_FIRST="分类";
    private final String TAB_SPEC_SECOND="游戏";
    private final String TAB_SPEC_THIRD="视频";
    private final String TAB_SPEC_FOUR="设置";
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
        final FragmentTabHost tabHost=findViewById(android.R.id.tabhost);
        tabHost.setup(this,getSupportFragmentManager(),R.id.root_layout);
        tabHost.addTab(tabHost.newTabSpec(TAB_SPEC_FIRST).setIndicator(createIndicatorView(0)),FirstFragment.class,null);
        tabHost.addTab(tabHost.newTabSpec(TAB_SPEC_SECOND).setIndicator(createIndicatorView(1)),SecondFragment.class,null);
        tabHost.addTab(tabHost.newTabSpec(TAB_SPEC_THIRD).setIndicator(createIndicatorView(2)),ThirdFragment.class,null);
        tabHost.addTab(tabHost.newTabSpec(TAB_SPEC_FOUR).setIndicator(createIndicatorView(3)),FourFragment.class,null);
//        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
//            @Override
//            public void onTabChanged(String s) {
//                if (s.equals("first")){
//                    tabHost.setCurrentTab(INDEX_FRAGMENT_FIRST);
//                }else if (s.equals("second")){
//                    tabHost.setCurrentTab(INDEX_FRAGMENT_SECOND);
//                }else if (s.equals("third")){
//                    tabHost.setCurrentTab(INDEX_FRAGMENT_THIRD);
//                }else if (s.equals("four")){
//                    tabHost.setCurrentTab(INDEX_FRAGMENT_FOUR);
//                }
//            }
//        });
        //getSupportFragmentManager().beginTransaction().replace(R.id.root_layout,)
    }
    public View createIndicatorView(int index){
        int icon=INDEX_FRAGMENT_FIRST;
        String title="";
        switch (index){
            case INDEX_FRAGMENT_FIRST:
                icon=R.drawable.first_tab_icon_selector;
                title=TAB_SPEC_FIRST;
                break;
            case INDEX_FRAGMENT_SECOND:
                icon=R.drawable.first_tab_icon_selector;
                title=TAB_SPEC_SECOND;
                break;
            case INDEX_FRAGMENT_THIRD:
                icon=R.drawable.first_tab_icon_selector;
                title=TAB_SPEC_THIRD;
                break;
            case INDEX_FRAGMENT_FOUR:
                icon=R.drawable.first_tab_icon_selector;
                title=TAB_SPEC_FOUR;
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
