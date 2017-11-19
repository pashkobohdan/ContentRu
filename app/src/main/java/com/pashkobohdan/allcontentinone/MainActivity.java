package com.pashkobohdan.allcontentinone;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.pashkobohdan.allcontentinone.presentation.ui.fragments.AllContentsFragment;
import com.pashkobohdan.allcontentinone.presentation.ui.utils.CustomFragmentNavigator;

import javax.inject.Inject;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;
import ru.terrakok.cicerone.commands.Replace;

import static com.pashkobohdan.allcontentinone.presentation.ui.Screen.ALL_CONTENT_LIST;
import static com.pashkobohdan.allcontentinone.presentation.ui.Screen.FAVORITE_CONTENT_LIST;

public class MainActivity extends AppCompatActivity {

    @Inject
    NavigatorHolder navigatorHolder;
    @Inject
    Router router;

    private Navigator navigator = new CustomFragmentNavigator(getSupportFragmentManager(), R.id.main_container) {
        private long lastTryExitTime = 0L;
        private static final int CLICK_AGAIN_TO_EXIT_TIME = 2 * 1_000_000_000;

        @Override
        protected Fragment createFragment(String screenKey, Object data) {
            switch (screenKey) {
                case ALL_CONTENT_LIST:
                    return AllContentsFragment.getNewInstance();
                case FAVORITE_CONTENT_LIST:
                    //TODO
                default:
                    throw new IllegalArgumentException("Not supported screen: " + screenKey);
            }
        }

        @Override
        protected void showSystemMessage(String message) {
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void exit() {
            long currentTime = System.nanoTime();
            if (currentTime - lastTryExitTime < CLICK_AGAIN_TO_EXIT_TIME) {
                finish();
            } else {
                Toast.makeText(MainActivity.this, getString(R.string.click_again_to_exit), Toast.LENGTH_SHORT).show();
                lastTryExitTime = currentTime;
            }
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        navigatorHolder.setNavigator(navigator);
    }

    @Override
    protected void onPause() {
        navigatorHolder.removeNavigator();
        super.onPause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MyApplication.INSTANCE.getApplicationComponent().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (savedInstanceState == null) {
            navigator.applyCommand(new Replace(ALL_CONTENT_LIST, null));
        } else {
            navigator.applyCommand(new Replace(ALL_CONTENT_LIST, null));
            //TODO maybe don't need this because I have a moxy (with stateStrategy)
        }
    }


}
