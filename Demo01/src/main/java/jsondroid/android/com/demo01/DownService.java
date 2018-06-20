package jsondroid.android.com.demo01;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import jsondroid.android.com.demo01.test.UserTest;

/**
 * Created by wenbaohe on 2018/6/4.
 */

public class DownService extends Service {

    private IDownCallBackListen iDownCallBackListen;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return iDownInterface;
    }

    private IDownInterface.Stub iDownInterface = new IDownInterface.Stub() {
        @Override
        public void setUsertest(UserTest user) throws RemoteException {

            Log.e("服务端收到--->", "" + user.getName());
            if (iDownCallBackListen != null) {
                if (user.getName().equals("name")) {

                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            try {
                                Thread.sleep(3 * 1000);
                                iDownCallBackListen.callback(230);
                            } catch (RemoteException e) {
                                e.printStackTrace();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();

                }
            }

        }

        @Override
        public void setListener(IDownCallBackListen callbackListen) throws RemoteException {
            iDownCallBackListen = callbackListen;
        }
    };

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("服务已开启---》", "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }
}
