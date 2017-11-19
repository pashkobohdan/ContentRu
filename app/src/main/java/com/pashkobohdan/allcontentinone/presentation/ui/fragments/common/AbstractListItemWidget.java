package com.pashkobohdan.allcontentinone.presentation.ui.fragments.common;

import android.view.ViewGroup;

import com.pashkobohdan.allcontentinone.presentation.model.dto.CommonDTO;
import com.pashkobohdan.allcontentinone.presentation.ui.adapter.AbstractListItemHolder;

import rx.functions.Action1;

public abstract class AbstractListItemWidget<T extends CommonDTO> {

    public AbstractListItemWidget(){
        //Must have empty constructor
    }

    public abstract AbstractListItemHolder<T> getHolder(ViewGroup parent, Action1<T> okClickCallback) ;
}
