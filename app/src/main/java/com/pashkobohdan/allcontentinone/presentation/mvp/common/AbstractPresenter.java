package com.pashkobohdan.allcontentinone.presentation.mvp.common;

import com.arellomobile.mvp.MvpPresenter;
import com.pashkobohdan.allcontentinone.presentation.ui.Screen;

public class AbstractPresenter<V extends AbstractScreenView> extends MvpPresenter<V> {

    public static final String INDEX_SCREEN_KEY = Screen.ALL_CONTENT_LIST;
    public static String currentScreen = "";

    @Override
    public void attachView(V view) {
        super.attachView(view);
        view.onPresenterAttached(this);
    }
}
