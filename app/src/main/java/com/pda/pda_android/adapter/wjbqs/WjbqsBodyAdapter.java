package com.pda.pda_android.adapter.wjbqs;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pda.pda_android.R;
import com.pda.pda_android.bean.WjbqsBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class WjbqsBodyAdapter extends RecyclerView.Adapter<WjbqsBodyAdapter.ViewHolder>{
    private Context context;
    private LayoutInflater mLayoutInflater;
    private List<WjbqsBean.WjbqsBeanListBean.WjbqsBeanListBeanListBean> list;
    private String name;
    public WjbqsBodyAdapter(Context context, List<WjbqsBean.WjbqsBeanListBean.WjbqsBeanListBeanListBean> list, String name) {
        this.list = list;
        this.context = context;
        mLayoutInflater = LayoutInflater.from(context);
        this.name=name;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=mLayoutInflater.inflate(R.layout.wjbqs_body,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.name.setText(name+" 的检查结果");
        holder.data.setText(list.get(position).getCode());
        holder.project.setText(list.get(position).getName());
        holder.jy_rootview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(context,JyDetailActivity.class);
//                intent.putExtra("name",name);
//                intent.putExtra("Patient_no",list.get(position).getSend_date());
//                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,project,data;
        LinearLayout jy_rootview;

        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.user_name);
            project=itemView.findViewById(R.id.project);
            data=itemView.findViewById(R.id.data);
            jy_rootview=itemView.findViewById(R.id.jy_rootview);
        }
    }
}
