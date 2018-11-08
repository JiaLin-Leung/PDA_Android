package com.pda.pda_android.adapter.wjbqs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.pda.pda_android.R;
import com.pda.pda_android.base.network.LoadCallBack;
import com.pda.pda_android.base.network.OkHttpManager;
import com.pda.pda_android.base.network.bean.ResultBean;
import com.pda.pda_android.base.others.ContentUrl;
import com.pda.pda_android.bean.WjbEndBean;
import com.pda.pda_android.bean.WjbqsBean;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import okhttp3.Call;
import okhttp3.Response;


public class WjbqsEndBodyAdapter extends RecyclerView.Adapter<WjbqsEndBodyAdapter.ViewHolder>{
    private Context context;
    private LayoutInflater mLayoutInflater;
    private List<WjbEndBean.DataBean.ListBean> list;

    public WjbqsEndBodyAdapter(Context context, List<WjbEndBean.DataBean.ListBean> list) {
        this.list = list;
        this.context = context;
        mLayoutInflater = LayoutInflater.from(context);

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=mLayoutInflater.inflate(R.layout.wjbqs_end_body,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.name.setText(list.get(position).getName());
        holder.sign_data.setText(list.get(position).getJs_date());
        holder.code.setText(list.get(position).getCode());
        holder.sign_fs.setText(list.get(position).getType());
        if (null!=list.get(position).getJs_user_name()){
            holder.sign_name.setText(list.get(position).getJs_user_name());
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,code,sign_data,sign_name,sign_fs;
        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            sign_name=itemView.findViewById(R.id.sign_name);
            sign_fs=itemView.findViewById(R.id.sign_fs);
            code=itemView.findViewById(R.id.code);
            sign_data=itemView.findViewById(R.id.sign_data);
        }
    }


}
