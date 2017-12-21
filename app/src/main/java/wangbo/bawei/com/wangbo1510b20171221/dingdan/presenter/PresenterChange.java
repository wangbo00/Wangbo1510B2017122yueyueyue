package wangbo.bawei.com.wangbo1510b20171221.dingdan.presenter;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;

import wangbo.bawei.com.wangbo1510b20171221.dingdan.bean.DataChangeBean;
import wangbo.bawei.com.wangbo1510b20171221.dingdan.model.ModuleChange;

/**
 * author:Created by Wangbo on 2017/12/21.
 */

public class PresenterChange {
    private ModuleChange moduleChange = new ModuleChange();
    PresenterChangeListener presenterChangeListener;

    public PresenterChange(PresenterChangeListener presenterChangeListener) {
        this.presenterChangeListener = presenterChangeListener;
    }

    private Handler handler = new Handler(Looper.getMainLooper());
    public void getData(String status,String id){
        moduleChange.getData(status, id, new ModuleChange.ModuleChangeListener() {
            @Override
            public void success(final String s) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        DataChangeBean dataChangeBean = new Gson().fromJson(s, DataChangeBean.class);
                        if(presenterChangeListener !=null){

                            presenterChangeListener.mySuccess(dataChangeBean);

                        }
                    }
                });

            }
        });
    }
    public interface PresenterChangeListener{
        void mySuccess(DataChangeBean dataChangeBean);
    }
}
