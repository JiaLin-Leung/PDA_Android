package com.pda.pda_android.adapter.ssxx;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pda.pda_android.R;
import com.pda.pda_android.activity.apps.detail.SsxxInfomationDetailActivity;
import com.pda.pda_android.activity.apps.detail.jcjydetail.JcDetailActivity;
import com.pda.pda_android.db.Entry.CheckBeanListBean;
import com.pda.pda_android.db.Entry.SsxxBean;
import com.pda.pda_android.db.Entry.SsxxBeanListBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class SsxxBodyAdapter extends RecyclerView.Adapter<SsxxBodyAdapter.ViewHolder>{
    private Context context;
    private LayoutInflater mLayoutInflater;
    private List<SsxxBeanListBean> list;
    private String name;
    public SsxxBodyAdapter(Context context, List<SsxxBeanListBean> list, String name) {
        this.list = list;
        this.context = context;
        mLayoutInflater = LayoutInflater.from(context);
        this.name=name;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=mLayoutInflater.inflate(R.layout.ssxx_body,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.name.setText(name+"的手术信息");
        holder.data.setText(list.get(position).getInoper_time());
        holder.ops_name.setText(list.get(position).getOper_name());
        holder.docter.setText(list.get(position).getSurgeon_name());
        holder.jc_rootview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,SsxxInfomationDetailActivity.class);
                intent.putExtra("name",name+" 的手术信息");

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,docter,ops_name,data;
        LinearLayout jc_rootview;

        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.user_name);
            docter=itemView.findViewById(R.id.docter);
            ops_name=itemView.findViewById(R.id.ops_name);
            data=itemView.findViewById(R.id.data);
            jc_rootview=itemView.findViewById(R.id.jc_rootview);
        }
    }
}
