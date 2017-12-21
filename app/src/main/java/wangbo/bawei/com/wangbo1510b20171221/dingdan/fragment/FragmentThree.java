package wangbo.bawei.com.wangbo1510b20171221.dingdan.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liaoinstan.springview.widget.SpringView;

import java.util.List;

import wangbo.bawei.com.wangbo1510b20171221.R;
import wangbo.bawei.com.wangbo1510b20171221.dingdan.adapter.MyAdapter;
import wangbo.bawei.com.wangbo1510b20171221.dingdan.bean.DataDataBean;
import wangbo.bawei.com.wangbo1510b20171221.dingdan.presenter.MyPresenterOther;

/**
 * author:Created by Wangbo on 2017/12/21.
 */

public class FragmentThree extends Fragment implements MyPresenterOther.PresenterListerenOther{
    private RecyclerView recyclerView;
    private SpringView springView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item3,container,false);
        recyclerView = view.findViewById(R.id.recyclerView01);
        springView = view.findViewById(R.id.springView);
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final MyPresenterOther myPresenter = new MyPresenterOther();
        myPresenter.getData("71","1","1",this);
    }

    @Override
    public void success(List<DataDataBean.DataBean> data) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        MyAdapter myAdapter = new MyAdapter(getActivity(),data);
        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public void failed() {

    }
}
