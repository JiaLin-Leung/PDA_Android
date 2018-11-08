package com.pda.pda_android.adapter.wjbqs;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.pda.pda_android.R;
import com.pda.pda_android.base.network.LoadCallBack;
import com.pda.pda_android.base.network.OkHttpManager;
import com.pda.pda_android.base.network.bean.ResultBean;
import com.pda.pda_android.base.others.ContentUrl;
import com.pda.pda_android.bean.WjbqsBean;
import com.pda.pda_android.fragment.wjbqs.WjbqssdFragment;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import okhttp3.Call;
import okhttp3.Response;


public class WjbqsBodyAdapter extends RecyclerView.Adapter<WjbqsBodyAdapter.ViewHolder>{
    private Context context;
    private LayoutInflater mLayoutInflater;
    private List<WjbqsBean.WjbqsBeanListBean.WjbqsBeanListBeanListBean> list;
    String  time;
    private WjbqsDetailAdapter wjbqsDetailAdapter=new WjbqsDetailAdapter();
    private List<WjbqsBean.WjbqsBeanListBean> listBeans;
    public WjbqsBodyAdapter(Context context, List<WjbqsBean.WjbqsBeanListBean.WjbqsBeanListBeanListBean> list, List<WjbqsBean.WjbqsBeanListBean> listBeans) {
        this.list = list;
        this.context = context;
        mLayoutInflater = LayoutInflater.from(context);

        this.listBeans=listBeans;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=mLayoutInflater.inflate(R.layout.wjbqs_body,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.name.setText(list.get(position).getName());
        holder.data.setText(list.get(position).getSend_date());
        holder.code.setText(list.get(position).getCode());
        holder.qianshou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time=list.get(position).getSend_date().split(" ")[0];
                PostData(list.get(position).getCode(),position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,code,data;
        Button qianshou;
        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            code=itemView.findViewById(R.id.code);
            data=itemView.findViewById(R.id.data);
            qianshou=itemView.findViewById(R.id.qianshou);
        }
    }

    private void PostData(final String code, final int position) {
        Map<String, String> params = new HashMap<>(); //提交数据包
        params.put("sterile_code", code); //将姓名参数添加到数据包
        OkHttpManager.getInstance().postRequest(context, ContentUrl.TestUrl_local + ContentUrl.sign, new LoadCallBack<String>(context) {
            @Override
            protected void onFailure(Call call, IOException e) {
            }
            @Override
            protected void onSuccess(Call call, Response response, String s) throws IOException {
                Gson gson = new Gson();
                ResultBean resultBean= gson.fromJson(s,ResultBean.class);
                if (resultBean.response.equals("ok")){
                    Toast.makeText(context,resultBean.getMessage(),Toast.LENGTH_SHORT).show();
//                    wjbqsDetailAdapter.notifyDataSetChanged();
                    for (int i=0;i<listBeans.size();i++){
                        if (time.equals(listBeans.get(i).getDate())){
                                wjbqsDetailAdapter.update(i,position);

                        }
                    }
//                    wjbqssdFragment.mainAdapter.notifyDataSetChanged();
                }
            }
        },params);

    }
}
