package com.pashkobohdan.allcontentinone.presentation.mvp.ideer;

import com.arellomobile.mvp.InjectViewState;
import com.pashkobohdan.allcontentinone.presentation.mvp.common.AbstractPresenter;
import com.pashkobohdan.allcontentinone.presentation.mvp.ideer.view.IdeerPostsView;

import javax.inject.Inject;

@InjectViewState
public class IdeerPostsPresenter extends AbstractPresenter<IdeerPostsView>{

    @Inject
    public IdeerPostsPresenter() {
        //For DI
    }

    public void refresh() {

    }
}
