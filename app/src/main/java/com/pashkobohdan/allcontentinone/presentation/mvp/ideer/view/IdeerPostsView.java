package com.pashkobohdan.allcontentinone.presentation.mvp.ideer.view;

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.pashkobohdan.allcontentinone.presentation.mvp.common.AbstractScreenView;
import com.pashkobohdan.allcontentinone.presentation.mvp.ideer.IdeerPostsPresenter;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface IdeerPostsView extends AbstractScreenView<IdeerPostsPresenter>{
}
