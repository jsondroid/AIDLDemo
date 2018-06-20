package jsondroid.android.com.aidldemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by wenbaohe on 2018/5/23.
 */

public class MyService extends Service {



    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return stub;
    }

    IMyAidlInterface.Stub stub = new IMyAidlInterface.Stub() {
        CallBack callBack;
        @Override
        public void basicTypes(String aString) throws RemoteException {
            if(callBack!=null){
                callBack.oncallback("已收到：--》"+aString);
            }
            Log.e("服务端MyService--", "" + aString);
        }

        @Override
        public void getcallback(CallBack callback) throws RemoteException {
            this.callBack = callback;
        }
    };
}
