package wangbo.bawei.com.wangbo1510b20171221.callback;

/**
 * author:Created by Wangbo on 2017/12/21.
 */

public interface CallBack {
    //本地请求成功失败的方法
    void onSuccess(String tag, Object o);
    void onFailed(String tag, Exception e);
}
