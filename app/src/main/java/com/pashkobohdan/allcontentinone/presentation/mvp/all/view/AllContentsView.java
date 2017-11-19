package com.pashkobohdan.allcontentinone.presentation.mvp.all.view;

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.pashkobohdan.allcontentinone.presentation.model.dto.SourceDTO;
import com.pashkobohdan.allcontentinone.presentation.mvp.all.AllContentsPresenter;
import com.pashkobohdan.allcontentinone.presentation.mvp.common.AbstractScreenView;

import java.util.List;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface AllContentsView extends AbstractScreenView<AllContentsPresenter> {

    void showSources(List<SourceDTO> sourceDTOList);

}
