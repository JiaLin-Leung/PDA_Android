package com.pda.pda_android.adapter.jcjy;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.pda.pda_android.R;
import com.pda.pda_android.bean.JcBodybean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class JcBodyAdapter extends RecyclerView.Adapter<JcBodyAdapter.ViewHolder>{
    private Context context;
    private LayoutInflater mLayoutInflater;
    private List<JcBodybean.Body> list;

    public JcBodyAdapter(Context context, List<JcBodybean.Body> list) {
        this.list = list;
        this.context = context;
        mLayoutInflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=mLayoutInflater.inflate(R.layout.jc_body,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.name.setText(list.get(position).getName());
        holder.data.setText(list.get(position).getData());
        holder.shebei.setText(list.get(position).getShebei());
        holder.project.setText(list.get(position).getProject());
        holder.jc_rootview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,list.get(position).getName(),Toast.LENGTH_SHORT).show();
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
