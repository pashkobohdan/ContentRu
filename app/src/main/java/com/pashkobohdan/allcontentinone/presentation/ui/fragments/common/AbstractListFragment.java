package com.pashkobohdan.allcontentinone.presentation.ui.fragments.common;

import android.view.ViewGroup;

import com.pashkobohdan.allcontentinone.presentation.model.dto.common.CommonDTO;
import com.pashkobohdan.allcontentinone.presentation.mvp.common.AbstractPresenter;
import com.pashkobohdan.allcontentinone.presentation.ui.adapter.AbstractListAdapter;
import com.pashkobohdan.allcontentinone.presentation.ui.adapter.AbstractListItemHolder;

import java.util.List;

public abstract class AbstractListFragment<T extends AbstractPresenter, H extends CommonDTO> extends AbstractScreenFragment<T> {

    public final class ListAdapter extends AbstractListAdapter<H> {

        public ListAdapter(List<H> arrayData) {
            super(arrayData);
        }

        @Override
        public void onBindViewHolder(AbstractListItemHolder<H> holder, int position) {
            holder.onBindViewHolder(arrayData.get(position));
        }

        @Override
        public AbstractListItemHolder<H> createItemHolder(ViewGroup parent) {
            return getItemHolder(parent);
        }
    }

    public abstract AbstractListItemHolder<H> getItemHolder(ViewGroup parent);
}
