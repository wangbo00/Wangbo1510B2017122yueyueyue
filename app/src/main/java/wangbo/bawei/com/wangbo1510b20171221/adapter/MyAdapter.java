package wangbo.bawei.com.wangbo1510b20171221.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import wangbo.bawei.com.wangbo1510b20171221.R;
import wangbo.bawei.com.wangbo1510b20171221.bean.ImageBean;

/**
 * author:Created by Wangbo on 2017/12/21.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    List<ImageBean.DataBean.DefaultGoodsListBean> listBeen;
    Context context;
    public MyAdapter(List<ImageBean.DataBean.DefaultGoodsListBean> listBeen, Context context) {
        this.listBeen = listBeen;
        this.context = context;
    }
    public interface OnItemClieckLinster{

        void onItemClickListener(View view, int pos);
        void onItemLongClickListener(View view, int pos);
    }

    private  OnItemClieckLinster onItemClieckLinster;

    public void setOnItemClieckLinster(OnItemClieckLinster listener){

        this.onItemClieckLinster = listener;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= View.inflate(context, R.layout.item,null);
        ViewHolder vh=new ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(final MyAdapter.ViewHolder holder, final int position) {
        Glide.with(context).load(listBeen.get(position).getGoods_img()).into(holder.img);
        if (onItemClieckLinster!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                    onItemClieckLinster.onItemClickListener(holder.itemView , position);
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {

                    onItemClieckLinster.onItemLongClickListener(holder.itemView , position);
                    return false;
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return listBeen.size();
    }
    class  ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        public ViewHolder(View itemView) {
            super(itemView);
            img=(ImageView)itemView.findViewById(R.id.img);
        }
    }

    }
