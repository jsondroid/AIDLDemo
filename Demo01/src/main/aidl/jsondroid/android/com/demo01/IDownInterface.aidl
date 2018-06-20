// IDownInterface.aidl
package jsondroid.android.com.demo01;
// Declare any non-default types here with import statements
import jsondroid.android.com.demo01.IDownCallBackListen;
import jsondroid.android.com.demo01.test.UserTest;

interface IDownInterface {

void setUsertest(in UserTest user);
void setListener(in IDownCallBackListen callbackListen);

}
