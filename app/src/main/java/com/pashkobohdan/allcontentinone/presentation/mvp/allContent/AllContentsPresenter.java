package com.pashkobohdan.allcontentinone.presentation.mvp.allContent;

import com.arellomobile.mvp.InjectViewState;
import com.pashkobohdan.allcontentinone.presentation.mvp.allContent.view.AllContentsView;
import com.pashkobohdan.allcontentinone.presentation.mvp.common.AbstractPresenter;

import javax.inject.Inject;

@InjectViewState
public class AllContentsPresenter extends AbstractPresenter<AllContentsView> {

    @Inject
    public AllContentsPresenter() {
        //For DI
    }

    @Override
    protected void onFirstViewAttach() {
        //TODO show data at screen
    }
}
