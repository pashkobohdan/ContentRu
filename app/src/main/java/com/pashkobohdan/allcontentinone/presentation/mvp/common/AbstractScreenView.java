package com.pashkobohdan.allcontentinone.presentation.mvp.common;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.MvpView;

public interface AbstractScreenView<T extends MvpPresenter> extends MvpView{

    void onPresenterAttached(T presenter);
}
