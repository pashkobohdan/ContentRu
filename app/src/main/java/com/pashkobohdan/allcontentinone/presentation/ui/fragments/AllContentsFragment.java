package com.pashkobohdan.allcontentinone.presentation.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.pashkobohdan.allcontentinone.MyApplication;
import com.pashkobohdan.allcontentinone.R;
import com.pashkobohdan.allcontentinone.presentation.mvp.allContent.AllContentsPresenter;
import com.pashkobohdan.allcontentinone.presentation.mvp.allContent.view.AllContentsView;
import com.pashkobohdan.allcontentinone.presentation.ui.fragments.common.AbstractScreenFragment;

public class AllContentsFragment extends AbstractScreenFragment<AllContentsPresenter> implements AllContentsView {

    @InjectPresenter
    AllContentsPresenter presenter;

    @ProvidePresenter
    public AllContentsPresenter createSamplePresenter() {
        return presenterProvider.get();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        MyApplication.INSTANCE.getApplicationComponent().inject(this);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_all_content, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        //TODO instance all views
    }




}
