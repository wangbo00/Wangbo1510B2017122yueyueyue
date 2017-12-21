package wangbo.bawei.com.wangbo1510b20171221.dingdan.presenter;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;

import java.util.List;

import wangbo.bawei.com.wangbo1510b20171221.dingdan.bean.DataDataBean;
import wangbo.bawei.com.wangbo1510b20171221.dingdan.model.MyModuleOther;

/**
 * author:Created by Wangbo on 2017/12/21.
 */

public class MyPresenterOther {
    MyModuleOther myModule = new MyModuleOther();
    Handler handler =new Handler(Looper.getMainLooper());
    public void getData(String uid,String page,String status, final PresenterListerenOther presenterListeren){
        myModule.getData(uid,page,status, new MyModuleOther.ModuleListeren() {
            @Override
            public void success(final String s) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        DataDataBean dataDataBean = new Gson().fromJson(s, DataDataBean.class);
                        List<DataDataBean.DataBean> data = dataDataBean.getData();
                        presenterListeren.success(data);
                    }
                });
            }

            @Override
            public void failed(Exception e) {

            }
        });
    }
    public interface PresenterListerenOther{
        void success(List<DataDataBean.DataBean> data);
        void failed();

    }
}
