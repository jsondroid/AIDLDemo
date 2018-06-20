package jsondroid.android.com.demo01;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import jsondroid.android.com.demo01.test.UserTest;

/**服务端aidl并且是设置单独的进程服务  通过隐式开启服务进行双向通信*/
public class MainActivity extends AppCompatActivity {

    private IDownInterface idw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            idw = IDownInterface.Stub.asInterface(service);
            Log.e("onservice--->", "已绑定服务成功");
            try {
                idw.setListener(downCallBackListen);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    public void bindClick(View view) {
        Intent intent = new Intent();
        intent.setAction("com.jsondroid.aidl");
        intent.setPackage("jsondroid.android.com.demo01");
        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
    }

    public void sendClick(View view) {
        if (idw != null) {
            UserTest userTest = new UserTest();
            userTest.setName("name");
            try {
                idw.setUsertest(userTest);

            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    private IDownCallBackListen  downCallBackListen=new IDownCallBackListen.Stub(){
        @Override
        public void callback(int p) throws RemoteException {
            Log.e("客户端收到---》",""+p);
        }
    };
}
