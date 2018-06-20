// IMyAidlInterface.aidl
package jsondroid.android.com.aidldemo;
import jsondroid.android.com.aidldemo.CallBack;//这里必须要引包，不然会报错

// Declare any non-default types here with import statements

interface IMyAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    oneway void basicTypes(String aString);

    oneway void getcallback(CallBack callback);
}
