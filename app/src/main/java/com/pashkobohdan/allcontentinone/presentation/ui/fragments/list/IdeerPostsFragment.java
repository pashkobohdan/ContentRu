package com.pashkobohdan.allcontentinone.presentation.ui.fragments.list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.pashkobohdan.allcontentinone.MyApplication;
import com.pashkobohdan.allcontentinone.R;
import com.pashkobohdan.allcontentinone.presentation.mvp.ideer.IdeerPostsPresenter;
import com.pashkobohdan.allcontentinone.presentation.mvp.ideer.view.IdeerPostsView;
import com.pashkobohdan.allcontentinone.presentation.ui.fragments.common.AbstractScreenFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IdeerPostsFragment extends AbstractScreenFragment<IdeerPostsPresenter> implements IdeerPostsView {

    @InjectPresenter
    IdeerPostsPresenter presenter;

    @BindView(R.id.list_view)
    RecyclerView listView;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout refreshLayout;

    @ProvidePresenter
    public IdeerPostsPresenter createSamplePresenter() {
        return presenterProvider.get();
    }

    public static IdeerPostsFragment getNewInstance() {
        return new IdeerPostsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        MyApplication.INSTANCE.getApplicationComponent().inject(this);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post_list, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        //TODO instance all views

        refreshLayout.setOnRefreshListener(() -> presenter.refresh());
    }

}
