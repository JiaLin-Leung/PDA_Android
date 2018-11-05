package com.pda.pda_android.adapter.jcjy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pda.pda_android.R;
import com.pda.pda_android.db.Entry.AssayBeanListBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class JyBodyAdapter extends RecyclerView.Adapter<JyBodyAdapter.ViewHolder>{
    private Context context;
    private LayoutInflater mLayoutInflater;
    private List<AssayBeanListBean> list;
    private String name;
    public JyBodyAdapter(Context context, List<AssayBeanListBean> list,String name) {
        this.list = list;
        this.context = context;
        mLayoutInflater = LayoutInflater.from(context);
        this.name=name;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=mLayoutInflater.inflate(R.layout.jy_body,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.name.setText(name);
        holder.data.setText(list.get(position).getJydate());
        holder.project.setText(list.get(position).getXmmc());
        holder.jy_rootview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
