package wangbo.bawei.com.wangbo1510b20171221.presenter;

import java.util.Map;

import wangbo.bawei.com.wangbo1510b20171221.callback.CallBack;
import wangbo.bawei.com.wangbo1510b20171221.utils.HttpUtils;
import wangbo.bawei.com.wangbo1510b20171221.view.ImView;

/**
 * author:Created by Wangbo on 2017/12/21.
 */

public class Presenter {
    private ImView inv;
    public void attachView(ImView inv){
        this.inv=inv;
    }

    public void get(String url, Map<String,String> map, String tag, Class clv){
        HttpUtils.getInstance().get(url, map, new CallBack() {
            @Override
            public void onSuccess(String tag, Object o) {
                if(o!=null){
                    inv.onSuccess(tag,o);
                }
            }

            @Override
            public void onFailed(String tag, Exception e) {
                inv.onFailed(tag,e);
            }
        },clv,tag);
    }
    //创建对象方便 v层进行释放
    public void deleteView(){
        if(inv!=null){
            inv=null;
        }
    }
   /* //销毁线程 资源释放 在Activity 主类
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.deleteView();
        }
    }*/
}
