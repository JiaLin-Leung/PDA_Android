package com.pda.pda_android.adapter.wjbqs;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.pda.pda_android.R;
import com.pda.pda_android.base.network.LoadCallBack;
import com.pda.pda_android.base.network.OkHttpManager;
import com.pda.pda_android.base.network.bean.ResultBean;
import com.pda.pda_android.base.others.ContentUrl;
import com.pda.pda_android.bean.LoginBeanFail;
import com.pda.pda_android.bean.WjbqsBean;
import com.pda.pda_android.db.Entry.PostCacheBean;
import com.pda.pda_android.db.dbutil.PostCacheDaoOpe;

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
     private Handler handler;
     private String time;
     private List<WjbqsBean.WjbqsBeanListBean> listBeans;
    public WjbqsBodyAdapter(Context context, List<WjbqsBean.WjbqsBeanListBean.WjbqsBeanListBeanListBean> list,List<WjbqsBean.WjbqsBeanListBean> listBeans) {
        this.list = list;
        this.context = context;
        this.listBeans=listBeans;
        mLayoutInflater = LayoutInflater.from(context);
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
        time=list.get(position).getSend_date().split(" ")[0];
        holder.qianshou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        final Map<String, String> params = new HashMap<>(); //提交数据包
        params.put("sterile_code", code); //将姓名参数添加到数据包
        OkHttpManager.getInstance().postRequest(context, ContentUrl.TestUrl_local + ContentUrl.sign, new LoadCallBack<String>(context) {

            @Override
            protected void onEror(okhttp3.Call call, int statusCode, Exception e) {
                PostCacheBean postCacheBean = new PostCacheBean();
                postCacheBean.setCode("500");
                postCacheBean.setParameter(JSON.toJSONString(params));
                postCacheBean.setUrl(ContentUrl.TestUrl_local + ContentUrl.sign);
                PostCacheDaoOpe.insertData(context,postCacheBean);
                Toast.makeText(context,"网络不可用，请检查网络",Toast.LENGTH_SHORT).show();
            }
            @Override
            protected void onSuccess(Call call, Response response, String s) throws IOException {
                Gson gson = new Gson();
                ResultBean resultBean= gson.fromJson(s,ResultBean.class);
                if (s.contains("\"response\": \"ok\"")){
                    int size=listBeans.size();
                    int index=-1;
                    for (int i=0;i<size;i++){
                        if (time.equals(listBeans.get(i).getDate())){
                            index=i;
                        }
                    }
                    Message msg = handler.obtainMessage();
                    msg.what=10101;
                    msg.arg1=index;
                    handler.sendMessage(msg);
                    Toast.makeText(context,resultBean.getMessage(),Toast.LENGTH_SHORT).show();
                    list.remove(position);
                    notifyDataSetChanged();
                }else {
                    LoginBeanFail loginBeanFail = gson.fromJson(s,LoginBeanFail.class);
                    Toast.makeText(context,loginBeanFail.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        },params);
    }
    public void setthandle(Handler handler){
        this.handler=handler;
    }
}
