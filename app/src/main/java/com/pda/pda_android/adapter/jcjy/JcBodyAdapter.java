package com.pda.pda_android.adapter.jcjy;

import android.content.Context;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.pda.pda_android.R;
import com.pda.pda_android.activity.apps.detail.jcjydetail.JcDetailActivity;
import com.pda.pda_android.activity.apps.detail.jcjydetail.JyDetailActivity;
import com.pda.pda_android.bean.JcBean;
import com.pda.pda_android.db.Entry.CheckBeanListBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class JcBodyAdapter extends RecyclerView.Adapter<JcBodyAdapter.ViewHolder>{
    private Context context;
    private LayoutInflater mLayoutInflater;
//    private List<CheckBeanListBean> list;
    private String name;
    private List<JcBean.DataBean.ListBean> list;
    public JcBodyAdapter(Context context, List<JcBean.DataBean.ListBean> list,String name) {
        this.list = list;
        this.context = context;
        mLayoutInflater = LayoutInflater.from(context);
        this.name=name;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=mLayoutInflater.inflate(R.layout.jc_body,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.name.setText(name);
        holder.data.setText(list.get(position).getJcdate());
        holder.shebei.setText(list.get(position).getDevicetype());
        holder.project.setText(list.get(position).getItem_name());
        holder.jc_rootview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,JcDetailActivity.class);
                intent.putExtra("name",name+" 的检查结果");
                intent.putExtra("jc_content",list.get(position).getBgresult());
                intent.putExtra("bg_content",list.get(position).getBgjy());
                intent.putExtra("zd_content",list.get(position).getZdyj());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,project,shebei,data;
        LinearLayout jc_rootview;

        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.user_name);
            project=itemView.findViewById(R.id.project);
            shebei=itemView.findViewById(R.id.shebei);
            data=itemView.findViewById(R.id.data);
            jc_rootview=itemView.findViewById(R.id.jc_rootview);
        }
    }
}
