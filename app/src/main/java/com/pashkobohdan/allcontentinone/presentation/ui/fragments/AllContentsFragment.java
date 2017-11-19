package com.pashkobohdan.allcontentinone.presentation.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.pashkobohdan.allcontentinone.MyApplication;
import com.pashkobohdan.allcontentinone.R;
import com.pashkobohdan.allcontentinone.presentation.model.dto.SourceDTO;
import com.pashkobohdan.allcontentinone.presentation.mvp.all.AllContentsPresenter;
import com.pashkobohdan.allcontentinone.presentation.mvp.all.view.AllContentsView;
import com.pashkobohdan.allcontentinone.presentation.ui.fragments.common.AbstractScreenFragment;
import com.pashkobohdan.allcontentinone.presentation.ui.fragments.list.IdeerPostsFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AllContentsFragment extends AbstractScreenFragment<AllContentsPresenter> implements AllContentsView {

    @InjectPresenter
    AllContentsPresenter presenter;

    @BindView(R.id.tabs)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewPager;

    private ViewPagerAdapter adapter;

    @ProvidePresenter
    public AllContentsPresenter createSamplePresenter() {
        return presenterProvider.get();
    }

    public static AllContentsFragment getNewInstance() {
        return new AllContentsFragment();//TODO add save data method
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        MyApplication.INSTANCE.getApplicationComponent().inject(this);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all_content, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        adapter = new ViewPagerAdapter(new ArrayList<>(), getFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }


    @Override
    public void showSources(List<SourceDTO> sourceDTOList) {
        adapter.setItems(sourceDTOList);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {

        private List<SourceDTO> sourceDTOList;

        public ViewPagerAdapter(List<SourceDTO> sourceDTOList, FragmentManager fragmentManager) {
            super(fragmentManager);
            this.sourceDTOList = sourceDTOList;
        }

        public void setItems(List<SourceDTO> sourceDTOList) {
            this.sourceDTOList = sourceDTOList;
            notifyDataSetChanged();
        }

        @Override
        public Fragment getItem(int position) {
            SourceDTO sourceDTO = sourceDTOList.get(position);
            switch (sourceDTO.getSourceType()) {
                case IDEER:
                    return IdeerPostsFragment.getNewInstance();
                default:
                    return IdeerPostsFragment.getNewInstance();//TODO delete me !
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return sourceDTOList.get(position).getName();
        }

        @Override
        public int getCount() {
            return sourceDTOList.size();
        }
    }
}
