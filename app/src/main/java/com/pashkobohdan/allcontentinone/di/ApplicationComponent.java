package com.pashkobohdan.allcontentinone.di;

import com.pashkobohdan.allcontentinone.MainActivity;
import com.pashkobohdan.allcontentinone.di.modules.ApplicationModule;
import com.pashkobohdan.allcontentinone.di.modules.DatabaseModule;
import com.pashkobohdan.allcontentinone.di.modules.NavigationModule;
import com.pashkobohdan.allcontentinone.di.modules.SettingsModule;
import com.pashkobohdan.allcontentinone.presentation.ui.fragments.AllContentsFragment;
import com.pashkobohdan.allcontentinone.presentation.ui.fragments.list.IdeerPostsFragment;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {
        ApplicationModule.class,
        NavigationModule.class,
        SettingsModule.class,
        DatabaseModule.class
})
@Singleton
public interface ApplicationComponent {

    void inject(MainActivity activity);

    void inject(AllContentsFragment fragment);

    void inject(IdeerPostsFragment fragment);
}
