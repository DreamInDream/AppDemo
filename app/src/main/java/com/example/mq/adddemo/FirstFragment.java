package com.example.mq.adddemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.base.BaseFragment;
import com.example.mq.appdemo.R;

import butterknife.BindView;
import butterknife.OnClick;

public class FirstFragment extends BaseFragment {
    @BindView(R.id.ll_okhttp)
    LinearLayout ll_okhttp;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=View.inflate(getActivity(), com.example.mq.appdemo.R.layout.first_fragment,null);
        return view;
    }

    @Override
    public void initView() {

    }
    @OnClick({R.id.ll_okhttp})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.ll_okhttp:
                break;
                default:break;
        }
    }
}
