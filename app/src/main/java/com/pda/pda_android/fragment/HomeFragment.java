package com.pda.pda_android.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.pda.pda_android.R;
import com.pda.pda_android.activity.home.MenuManageActivity;
import com.pda.pda_android.adapter.IndexDataAdapter;
import com.pda.pda_android.base.BaseFragment;
import com.pda.pda_android.base.others.ContentUrl;
import com.pda.pda_android.base.utils.LogUtils;
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
    private List<Map<String, Object>> dataList;
    private IndexDataAdapter adapter;
    private static AppContext appContext;
    private List<MenuEntity> indexDataList = new ArrayList<MenuEntity>();
    private final static String fileName = "menulist";

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

        String key = AppConfig.KEY_All;
        String keyUser = AppConfig.KEY_USER;
        indexDataList = (List<MenuEntity>) appContext.readObject(AppConfig.KEY_USER);
        appContext.saveObject((Serializable) indexDataAll, AppConfig.KEY_All);
        List<MenuEntity> indexDataUser = (List<MenuEntity>) appContext.readObject(AppConfig.KEY_USER);
        if (indexDataUser == null || indexDataUser.size() == 0) {
            appContext.saveObject((Serializable) indexDataAll, AppConfig.KEY_USER);
        }
        indexDataList = (List<MenuEntity>) appContext.readObject(AppConfig.KEY_USER);
        MenuEntity allMenuEntity = new MenuEntity();
        allMenuEntity.setIco("");
        allMenuEntity.setId("all");
        allMenuEntity.setTitle("全部");
        indexDataList.add(allMenuEntity);
        adapter = new IndexDataAdapter(getActivity(), indexDataList);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                String title = indexDataList.get(position).getTitle();
                String strId = indexDataList.get(position).getId();
                LogUtils.showLog("111111", strId);
                LogUtils.showLog(title + strId);
                if (strId.equals("all")) {// 更多
                    intent.setClass(getActivity(), MenuManageActivity.class);
                    startActivity(intent);
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
        tv_tixing = view.findViewById(R.id.tixing);
        tv_tixing.setOnClickListener(this);
        banner = view.findViewById(R.id.banner);
        gridView = view.findViewById(R.id.gv_lanuch_start);
        gridView.setFocusable(false);
        //放图片地址的集合
        list_path = new ArrayList<>();
        //放标题的集合
        list_title = new ArrayList<>();
        list_path.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1539766912582&di=c0f035086fd8c8bc7c0f1bef523c9f6a&imgtype=0&src=http%3A%2F%2Fimg3.duitang.com%2Fuploads%2Fitem%2F201301%2F29%2F20130129004107_AtQZK.jpeg");
        list_path.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1539766912582&di=9d371199e3504895f657e735fb163b07&imgtype=0&src=http%3A%2F%2Fimg.zybus.com%2Fuploads%2Fallimg%2F140929%2F1-140929155Z1.jpg");
        list_path.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1539766912582&di=3e3b79ae6cdf713a374e0a4e557a0640&imgtype=0&src=http%3A%2F%2Ftva2.sinaimg.cn%2Fcrop.0.55.1198.674%2F90eb2137ly1fke3qognq0j20y60ma40j.jpg");
        list_path.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1539766912579&di=355ed96ede1500a312128235d1962d28&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201503%2F20%2F20150320144551_ZJAwB.jpeg");
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
        MenuEntity allMenuEntity = new MenuEntity();
        allMenuEntity.setIco("all_big_ico");
        allMenuEntity.setId("all");
        allMenuEntity.setTitle("全部");
        indexDataList.add(allMenuEntity);
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
            case R.id.tixing:
                break;
        }
    }
}
