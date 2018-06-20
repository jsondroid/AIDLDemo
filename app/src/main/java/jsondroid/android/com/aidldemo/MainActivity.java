package jsondroid.android.com.aidldemo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    IMyAidlInterface minter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent=new Intent(this,MyService.class);
        bindService(intent,connection, Context.BIND_AUTO_CREATE);
    }

    CallBack call=new CallBack() {
        @Override
        public void oncallback(String str) throws RemoteException {
            Log.e("str---》",str);
        }

        @Override
        public IBinder asBinder() {
            return null;
        }
    };

    int id=0;
    public void onCLickbtn(View view){
        if(minter!=null){
            try {
                minter.basicTypes("测试activity"+id);
                Log.e("发送---》",""+id);
                id++;
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

    }



    ServiceConnection connection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            minter= IMyAidlInterface.Stub.asInterface(service);
            try {
                minter.getcallback(call);
            } catch (RemoteException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onDestroy() {
        unbindService(connection);
        super.onDestroy();
    }
}
