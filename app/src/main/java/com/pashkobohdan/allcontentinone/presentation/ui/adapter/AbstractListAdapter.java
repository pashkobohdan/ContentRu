package com.pashkobohdan.allcontentinone.presentation.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.pashkobohdan.allcontentinone.presentation.model.dto.CommonDTO;

import java.util.List;

public abstract class AbstractListAdapter<T extends CommonDTO> extends RecyclerView.Adapter<AbstractListItemHolder<T>> {

    protected List<T> arrayData;

    public AbstractListAdapter(List<T> arrayData) {
        this.arrayData = arrayData;
    }

    public void setArrayData(List<T> arrayData) {
        this.arrayData = arrayData;
        notifyDataSetChanged();
    }

    @Override
    public AbstractListItemHolder<T> onCreateViewHolder(ViewGroup parent, int viewType) {
        return createItemHolder(parent);
    }

    @Override
    public void onBindViewHolder(AbstractListItemHolder<T> holder, int position) {
        holder.onBindViewHolder(arrayData.get(position));
    }

    @Override
    public int getItemCount() {
        return arrayData.size();
    }

    public abstract AbstractListItemHolder<T> createItemHolder(ViewGroup parent);
}
