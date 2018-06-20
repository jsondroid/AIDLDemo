package jsondroid.android.com.hostapkdemo;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by wenbaohe on 2018/6/5.
 */

public class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseView{


    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    public void isNightMode(boolean isNight) {

    }
}
