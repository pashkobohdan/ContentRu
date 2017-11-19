package com.pashkobohdan.allcontentinone.presentation.mvp.all;

import com.pashkobohdan.allcontentinone.presentation.mvp.all.view.AllContentsView;
import com.pashkobohdan.allcontentinone.presentation.mvp.all.view.AllContentsView$$State;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import javax.inject.Inject;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AllContentsPresenterTest {

    @Inject
    AllContentsPresenter presenter;
    @Mock
    AllContentsView view;
    @Mock
    AllContentsView$$State view$$State;

    @Before
    void setup(){
        //TODO inject
        presenter.setViewState(view$$State);
        view.onPresenterAttached(presenter);
    }

    @Test
    public void simpleOnFirstViewAttachTest() {
        presenter.onFirstViewAttach();
        ArgumentCaptor<List> listArgumentCaptor = ArgumentCaptor.forClass(List.class);
        verify(view$$State).showSources(listArgumentCaptor.capture());
        Assert.assertTrue(listArgumentCaptor.getValue().size() == 3.);
    }

}
