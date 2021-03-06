package com.pda.pda_android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.pda.pda_android.R;
import com.pda.pda_android.activity.home.MenuManageActivity;
import com.pda.pda_android.entity.MenuEntity;

import java.util.List;

public class MenuChildAdapter extends BaseAdapter {
	private List<MenuEntity> menuList;
	private Context context;
	private boolean IsEdit = false;

	public MenuChildAdapter(Context context, List<MenuEntity> list, boolean isEdit2) {
		this.context = context;
		this.menuList = list;
		this.IsEdit = isEdit2;
	}

	@Override
	public int getCount() {
		return menuList.size();
	}

	@Override
	public Object getItem(int position) {
		return menuList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHodler viewHodler = null;
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(R.layout.items_cate_child, null);
			viewHodler = new ViewHodler();
			viewHodler.tv_item_cate_child_name =  convertView.findViewById(R.id.tv_item_cate_child_name);
			viewHodler.item_container=convertView.findViewById(R.id.item_container);
			viewHodler.deleteImg =   convertView.findViewById(R.id.delete_img);
			viewHodler.iconImg =   convertView.findViewById(R.id.icon_img);
			convertView.setTag(viewHodler);
		} else {
			viewHodler = (ViewHodler) convertView.getTag();
		}
		final MenuEntity menuEntity = menuList.get(position);

//		if (IsEdit) {
//			viewHodler.deleteImg.setVisibility(View.VISIBLE);
//			if (menuEntity.isSelect()) {
//				viewHodler.deleteImg.setBackgroundResource(R.mipmap.menu_select);
//			} else {
//				viewHodler.deleteImg.setBackgroundResource(R.mipmap.menu_add);
//			}
//		} else {
//			viewHodler.deleteImg.setVisibility(View.GONE);
//		}
//
//		viewHodler.deleteImg.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				if (!menuEntity.isSelect()) {
//					MenuManageActivity.AddMenu(menuEntity);
//				}
//			}
//		});

		//获取资源图片
		int drawableId = context.getResources().getIdentifier(menuEntity.getIco(),"mipmap", context.getPackageName());
		viewHodler.iconImg.setImageResource(drawableId);

//		Glide.with(mContext).load(menuEntity.getIco()).placeholder(R.mipmap.ic_launcher)
//				.error(R.mipmap.ic_launcher).into(viewHodler.iconImg);

		viewHodler.tv_item_cate_child_name.setText(menuEntity.getTitle());
		return convertView;
	}

	private class ViewHodler {
		private TextView tv_item_cate_child_name;
		private ImageView deleteImg, iconImg;
		private FrameLayout item_container;
	}

}
