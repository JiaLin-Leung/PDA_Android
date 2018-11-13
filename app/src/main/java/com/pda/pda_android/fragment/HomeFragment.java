package com.pda.pda_android.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListPopupWindow;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.pda.pda_android.R;
import com.pda.pda_android.activity.apps.JcjyActivity;
import com.pda.pda_android.activity.apps.SSXXActivity;
import com.pda.pda_android.activity.apps.detail.WjbqsInfomationActivity;
import com.pda.pda_android.activity.apps.detail.YzybhdDetailActivity;
import com.pda.pda_android.activity.home.MenuManageActivity;
import com.pda.pda_android.adapter.IndexDataAdapter;
import com.pda.pda_android.base.BaseFragment;
import com.pda.pda_android.base.network.LoadCallBack;
import com.pda.pda_android.base.network.OkHttpManager;
import com.pda.pda_android.base.others.ContentUrl;
import com.pda.pda_android.base.utils.LogUtils;
import com.pda.pda_android.bean.LoginBeanFail;
import com.pda.pda_android.bean.Nursebean;
import com.pda.pda_android.entity.MenuEntity;
import com.pda.pda_android.widget.AppConfig;
import com.pda.pda_android.widget.AppContext;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import androidx.annotation.Nullable;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 梁佳霖创建于：2018/10/11 14:11
 * 功能：首页fragment
 */
@SuppressLint("NewApi")
public class HomeFragment extends BaseFragment implements OnBannerListener {
    private ArrayList<String> list_path;
    private ArrayList<String> list_title;
    private Banner banner;
    private TextView tv_tixing;
    private TextView tv_daiban;
    private TextView tv_allapp;
    private GridView gridView;
    private LinearLayout ln_hsz;
    private TextView hsz_name;
    private ImageView hsz_arrow;
    private List<Map<String, Object>> dataList;
    private IndexDataAdapter adapter;
    private static AppContext appContext;
    private List<MenuEntity> indexDataList = new ArrayList<MenuEntity>();
    private final static String fileName = "menulist";
    private ListPopupWindow listPopupWindow;
    private List<Nursebean.NursebeanDataBean.NursebeanDataBeanWardsBean> hszlist;
    public static HomeFragment newInstance(String s) {
        HomeFragment homeFragment = new HomeFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ContentUrl.ARGS, s);
        homeFragment.setArguments(bundle);
        return homeFragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sub_content, container, false);
        appContext = (AppContext) this.getActivity().getApplication();
        initView(view);
        initData();
        LogUtils.showLog("生命周期-----" + "home onCreateView");
        return view;
    }

    public void initData() {
        List<MenuEntity> indexDataAll = new ArrayList<MenuEntity>();
        String strByJson = getJson(getActivity(), fileName);
        //Json的解析类对象
        JsonParser parser = new JsonParser();
        //将JSON的String 转成一个JsonArray对象
        JsonArray jsonArray = parser.parse(strByJson).getAsJsonArray();
        Gson gson = new Gson();
        //加强for循环遍历JsonArray
        for (JsonElement indexArr : jsonArray) {
            //使用GSON，直接转成Bean对象
            MenuEntity menuEntity = gson.fromJson(indexArr, MenuEntity.class);
            indexDataAll.add(menuEntity);
        }
        appContext.delFileData(AppConfig.KEY_All);
//        appContext.delFileData(AppConfig.KEY_USER);

//        indexDataList = (List<MenuEntity>) appContext.readObject(AppConfig.KEY_USER);
        appContext.saveObject((Serializable) indexDataAll, AppConfig.KEY_All);
        List<MenuEntity> indexDataUser = (List<MenuEntity>) appContext.readObject(AppConfig.KEY_USER);
        if (indexDataUser == null || indexDataUser.size() == 0) {
            appContext.saveObject((Serializable) indexDataAll, AppConfig.KEY_USER);
        }
        indexDataList = (List<MenuEntity>) appContext.readObject(AppConfig.KEY_USER);
//        MenuEntity allMenuEntity = new MenuEntity();
//        allMenuEntity.setIco("");
//        allMenuEntity.setId("all");
//        allMenuEntity.setTitle("全部");
//        indexDataList.add(allMenuEntity);
        adapter = new IndexDataAdapter(getActivity(), indexDataList);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                String title = indexDataList.get(position).getTitle();
                String strId = indexDataList.get(position).getId();
                switch (strId){
                    case "JCGX": //检查检验
                        intent.setClass(getActivity(),JcjyActivity.class);
                        intent.putExtra("title",title);
                        startActivity(intent);
                        break;
                    case "SSXX": //手术信息
                        intent.setClass(getActivity(),SSXXActivity.class);
                        intent.putExtra("title",title);
                        startActivity(intent);
                        break;
                    case "WJBQS": //无菌包签收
                        intent.setClass(getActivity(),WjbqsInfomationActivity.class);
                        intent.putExtra("title",title);
                        startActivity(intent);
                        break;
                    case "YZYBHD": //医嘱药包核对
                        intent.setClass(getActivity(),YzybhdDetailActivity.class);
                        intent.putExtra("title",title);
                        startActivity(intent);
                        break;
                }
//                if (strId.equals("all")) {// 更多
//                    intent.setClass(getActivity(), MenuManageActivity.class);
//                    startActivity(intent);
//                }
            }
        });
        postdata();
        ln_hsz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hszlist.size() > 1) {
                    hsz_arrow.setImageResource(R.mipmap.arrow_arrow);
                    listPopupWindow.show();
                }
            }
        });
    }

    private void postdata() {
        OkHttpManager.getInstance().getRequest(getActivity(), ContentUrl.TestUrl_local + ContentUrl.getNurseProfile, new LoadCallBack<String>(getActivity(),true) {
            @Override
            protected void onEror(okhttp3.Call call, int statusCode, Exception e) {
                showCenterToastCenter("网络不可用，请检查网络");
            }
            @Override
            protected void onSuccess(Call call, Response response, String s) throws IOException {
                Gson gson = new Gson();
                if (s.contains("\"response\": \"ok\"")){
                    Nursebean  nursebean = gson.fromJson(s,Nursebean.class);
                    if(nursebean.response.equals("ok")){
                        hszlist=nursebean.getData().getWards();
                        hsz_name.setText(hszlist.get(0).getWard_name());
                        initHszPopWindow();
                    }
                }else {
                    LoginBeanFail loginBeanFail = gson.fromJson(s,LoginBeanFail.class);
                    showCenterToastCenter(loginBeanFail.getMessage());
                }
            }

        });
    }

    public static String getJson(Context context, String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            AssetManager assetManager = context.getAssets();
            BufferedReader bf = new BufferedReader(new InputStreamReader(
                    assetManager.open(fileName)));
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            LogUtils.showLog(e.toString());
        }
        return stringBuilder.toString();
    }

    public void initView(View view) {
        hsz_arrow=view.findViewById(R.id.iv_arrow);
        ln_hsz=view.findViewById(R.id.ln_hsz);
        hsz_name=view.findViewById(R.id.hsz_name);
        tv_tixing = view.findViewById(R.id.tv_tixing);
        tv_tixing.setOnClickListener(this);
        banner = view.findViewById(R.id.banner);
        gridView = view.findViewById(R.id.gv_lanuch_start);
        gridView.setFocusable(false);
        tv_allapp=view.findViewById(R.id.all_application);
        //放图片地址的集合
        list_path = new ArrayList<>();
        //放标题的集合
        list_title = new ArrayList<>();
        list_path.add("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1542031182&di=1b75a12d79133c442e5d72ce1f853f28&src=http://pic.58pic.com/58pic/17/81/87/559668325313c_1024.jpg");
//        list_path.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1539766912582&di=9d371199e3504895f657e735fb163b07&imgtype=0&src=http%3A%2F%2Fimg.zybus.com%2Fuploads%2Fallimg%2F140929%2F1-140929155Z1.jpg");
//        list_path.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1539766912582&di=3e3b79ae6cdf713a374e0a4e557a0640&imgtype=0&src=http%3A%2F%2Ftva2.sinaimg.cn%2Fcrop.0.55.1198.674%2F90eb2137ly1fke3qognq0j20y60ma40j.jpg");
//        list_path.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1539766912579&di=355ed96ede1500a312128235d1962d28&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201503%2F20%2F20150320144551_ZJAwB.jpeg");
        list_title.add("好好学习");
        list_title.add("天天向上");
        list_title.add("热爱劳动");
        list_title.add("不搞对象");
        //设置内置样式，共有六种可以点入方法内逐一体验使用。
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器，图片加载器在下方
        banner.setImageLoader(new MyLoader());
        //设置图片网址或地址的集合
        banner.setImages(list_path);
        //设置轮播的动画效果，内含多种特效，可点入方法内查找后内逐一体验
        banner.setBannerAnimation(Transformer.ZoomOut);
        //设置轮播图的标题集合
        banner.setBannerTitles(list_title);
        //设置轮播间隔时间
        banner.setDelayTime(3000);
        //设置是否为自动轮播，默认是“是”。
        banner.isAutoPlay(true);
        //设置指示器的位置，小点点，左中右。
        banner.setIndicatorGravity(BannerConfig.CENTER)
                //以上内容都可写成链式布局，这是轮播图的监听。比较重要。方法在下面。
                .setOnBannerListener(this)
                //必须最后调用的方法，启动轮播图。
                .start();
        tv_allapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), MenuManageActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public int getlayout() {
        return R.layout.fragment_sub_content;
    }

    @Override
    /**
     * 轮播图点击时间
     */
    public void OnBannerClick(int position) {
        Log.e("tag", "你点了第" + position + "张轮播图");
    }

    //自定义的图片加载器
    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load((String) path).into(imageView);
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LogUtils.showLog("生命周期-----" + "home onActivityCreated");
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtils.showLog("生命周期-----" + "home onResume");
        indexDataList.clear();
        indexDataList = (List<MenuEntity>) appContext.readObject(AppConfig.KEY_USER);
//        MenuEntity allMenuEntity = new MenuEntity();
//        allMenuEntity.setIco("all_big_ico");
//        allMenuEntity.setId("all");
//        allMenuEntity.setTitle("全部");
//        indexDataList.add(allMenuEntity);
        adapter = new IndexDataAdapter(getActivity(), indexDataList);
        gridView.setAdapter(adapter);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        LogUtils.showLog("现在的现隐形-----" + hidden);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.tv_tixing:
                break;
        }
    }

    /**
     * 选择护士站的弹出窗口的展示
     */
    private void initHszPopWindow() {

        listPopupWindow = new ListPopupWindow(getActivity());
        PopupWindowAdapter popupWindowAdapter = new PopupWindowAdapter(getActivity(), hszlist);
        listPopupWindow.setAdapter(popupWindowAdapter);
        //设置背景
        Drawable statusQuestionDrawable = getResources().getDrawable(R.color.white);
        listPopupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);//设置宽度
        View itemView = popupWindowAdapter.getView(0, null, null);
        itemView.measure(0, 0);
        int itemHight = itemView.getMeasuredHeight();
        if (hszlist.size() > 3) {
            listPopupWindow.setHeight(itemHight * 3);//设置高度
        } else {
            listPopupWindow.setHeight(itemHight * hszlist.size());//设置高度
        }
        listPopupWindow.setBackgroundDrawable(statusQuestionDrawable);//设置背景色
        listPopupWindow.setAnchorView(ln_hsz);//设置ListPopupWindow的锚点，即关联PopupWindow的显示位置和这个锚点
        listPopupWindow.setModal(true);//设置是否是模式
        //item的点击事件
        listPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                hsz_name.setText(hszlist.get(position).getWard_name());
                listPopupWindow.dismiss();
                hsz_arrow.setImageResource(R.mipmap.down_down);
            }
        });
        //界面消失的监听
        listPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                hsz_arrow.setImageResource(R.mipmap.down_down);
            }
        });
    }
    /**
     * 展示选择学校的适配器
     */
    public class PopupWindowAdapter extends BaseAdapter {

        /**
         * 上下文环境
         */
        private Context context;
        /**
         * 学校列表
         */
        private  List<Nursebean.NursebeanDataBean.NursebeanDataBeanWardsBean> hszlist;
        private LayoutInflater inflater;

        PopupWindowAdapter(Context context, List<Nursebean.NursebeanDataBean.NursebeanDataBeanWardsBean> hszlist) {
            this.context = context;
            this.hszlist = hszlist;
            inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return hszlist.size();
        }

        @Override
        public Object getItem(int position) {
            return hszlist.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = inflater.inflate(R.layout.pop_hsz_item, null);
                holder.tvhsz = convertView.findViewById(R.id.item_hsz_name);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.tvhsz.setText(hszlist.get(position).getWard_name());
            holder.tvhsz.setSelected(true);
            return convertView;
        }

        class ViewHolder {
            TextView tvhsz;
        }
    }
}
