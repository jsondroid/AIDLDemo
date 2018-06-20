package jsondroid.android.com.demo01.test;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by wenbaohe on 2018/6/4.
 */

public class UserTest implements Parcelable {

    private String name;

    private String msg;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.msg);
    }

    public UserTest() {
    }

    protected UserTest(Parcel in) {
        this.name = in.readString();
        this.msg = in.readString();
    }

    public static final Creator<UserTest> CREATOR = new Creator<UserTest>() {
        @Override
        public UserTest createFromParcel(Parcel source) {
            return new UserTest(source);
        }

        @Override
        public UserTest[] newArray(int size) {
            return new UserTest[size];
        }
    };
}
