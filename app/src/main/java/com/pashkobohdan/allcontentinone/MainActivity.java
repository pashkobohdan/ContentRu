package com.pashkobohdan.allcontentinone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
//    private Navigator navigator = new SupportFragmentNavigator(getSupportFragmentManager(),
//            R.id.main_container) {
//        @Override
//        protected Fragment createFragment(String screenKey, Object data) {
//            switch(screenKey) {
//                case LIST_SCREEN:
//                    return ListFragment.getNewInstance(data);
//                case DETAILS_SCREEN:
//                    return DetailsFragment.getNewInstance(data);
//                default:
//                    throw new RuntimeException(“Unknown screen key!”);
//            }
//        }
//
//        @Override
//        protected void showSystemMessage(String message) {
//            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
//        }
//
//        @Override
//        protected void exit() {
//            finish();
//        }
//    };

//    @Override
//    protected void onResume() {
//        super.onResume();
//        MyApplication.INSTANCE.getNavigatorHolder().setNavigator(navigator);
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        MyApplication.INSTANCE.getNavigatorHolder().removeNavigator();
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}
