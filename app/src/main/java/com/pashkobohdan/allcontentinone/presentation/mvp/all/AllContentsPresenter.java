package com.pashkobohdan.allcontentinone.presentation.mvp.all;

import com.arellomobile.mvp.InjectViewState;
import com.pashkobohdan.allcontentinone.presentation.model.dto.SourceDTO;
import com.pashkobohdan.allcontentinone.presentation.model.enums.SourceType;
import com.pashkobohdan.allcontentinone.presentation.mvp.all.view.AllContentsView;
import com.pashkobohdan.allcontentinone.presentation.mvp.common.AbstractPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class AllContentsPresenter extends AbstractPresenter<AllContentsView> {

    @Inject
    Router router;

    private List<SourceDTO> sourceDTOList;

    @Inject
    public AllContentsPresenter() {
        //For DI
        sourceDTOList = new ArrayList<>();
        sourceDTOList.add(new SourceDTO(SourceType.VK, "vkшка"));
        sourceDTOList.add(new SourceDTO(SourceType.IDEER, "подслушано !"));
    }

    @Override
    protected void onFirstViewAttach() {
        getViewState().showSources(sourceDTOList);
    }
}
