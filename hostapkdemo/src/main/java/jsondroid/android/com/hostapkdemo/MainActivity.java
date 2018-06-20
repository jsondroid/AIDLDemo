package jsondroid.android.com.hostapkdemo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends BaseActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ClickBtn(View view) {
        Intent intent=new Intent();
        intent.setAction("android.intent.action.myapp");
        startActivityForResult(intent,23);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("测试--->",""+requestCode+"-------"+resultCode);
    }

}
