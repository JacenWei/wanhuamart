package com.wanhua.wanhuamarket.Fragment;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wanhua.wanhuamarket.Adapter.HomeGridViewAdapter;
import com.wanhua.wanhuamarket.Adapter.QuanguoGridViewAdapter;
import com.wanhua.wanhuamarket.R;
import com.wanhua.wanhuamarket.base.BaseFragment;
import com.wanhua.wanhuamarket.view.MyGridView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class HomeFragment extends BaseFragment {


    @BindView(R.id.btn_location)
    Button btnLocation;
    @BindView(R.id.tx_title)
    TextView txTitle;
    @BindView(R.id.btn_logout)
    Button btnLogout;
    @BindView(R.id.banner1)
    Banner banner1;
    @BindView(R.id.banner2)
    Banner banner2;
    @BindView(R.id.banner3)
    Banner banner3;
    @BindView(R.id.home_gridview)
    MyGridView homeGridview;
    @BindView(R.id.home)
    FrameLayout home;
    Unbinder unbinder;
    @BindView(R.id.gridview_quanguo)
    GridView gridviewQuanguo;
    private ArrayList<String> pathlist;
    private ArrayList<String> quanguoPathlist;
    private ArrayList<String> namelist;
    private ArrayList<Drawable> imageList;

    @Override
    public int setView() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView(View view) {
        pathlist = new ArrayList<>();
        pathlist.add("http://www.tanglikeji.com/Public/Uploads/2017-03-20/58cf9bea49bb9.jpg");
        pathlist.add("http://www.tanglikeji.com/Public/Uploads/2017-03-20/58cfb4fe1f0b6.png");
        pathlist.add("http://www.tanglikeji.com/Public/Uploads/2017-03-21/58d08317b9ff1.png");
        pathlist.add("http://www.tanglikeji.com/Public/Uploads/2017-03-21/58d0e10cb1221.png");
        setBanner(banner1, pathlist);
        setBanner(banner2, pathlist);
        setBanner(banner3, pathlist);
        namelist = new ArrayList<>();
        namelist.add("万华专营");
        namelist.add("钻石商家");
        namelist.add("会员中心");
        namelist.add("信息中心");
        namelist.add("游戏");
        namelist.add("拼团");
        namelist.add("唿唿");
        namelist.add("扫码");
        namelist.add("便民服务");
        namelist.add("东东帮");
        imageList = new ArrayList<>();
        imageList.add(getResources().getDrawable(R.mipmap.icon_01));
        imageList.add(getResources().getDrawable(R.mipmap.icon_02));
        imageList.add(getResources().getDrawable(R.mipmap.icon_03));
        imageList.add(getResources().getDrawable(R.mipmap.icon_04));
        imageList.add(getResources().getDrawable(R.mipmap.icon_05));
        imageList.add(getResources().getDrawable(R.mipmap.icon_06));
        imageList.add(getResources().getDrawable(R.mipmap.icon_07));
        imageList.add(getResources().getDrawable(R.mipmap.icon_08));
        imageList.add(getResources().getDrawable(R.mipmap.icon_09));
        imageList.add(getResources().getDrawable(R.mipmap.icon_10));
        homeGridview.setAdapter(new HomeGridViewAdapter(getActivity(), namelist, imageList));
        quanguoPathlist = new ArrayList<>();
//        quanguoPathlist.add(ImageUtils.getDrawable("http://www.tanglikeji.com/Public/Uploads/2017-03-20/58cf9bea49bb9.jpg"));
//        quanguoPathlist.add(ImageUtils.getDrawable("http://www.tanglikeji.com/Public/Uploads/2017-03-20/58cf9bea49bb9.jpg"));
//        quanguoPathlist.add(ImageUtils.getDrawable("http://www.tanglikeji.com/Public/Uploads/2017-03-20/58cf9bea49bb9.jpg"));
//        quanguoPathlist.add(ImageUtils.getDrawable("http://www.tanglikeji.com/Public/Uploads/2017-03-20/58cf9bea49bb9.jpg"));
//        quanguoPathlist.add(ImageUtils.getDrawable("http://www.tanglikeji.com/Public/Uploads/2017-03-20/58cf9bea49bb9.jpg"));
//        quanguoPathlist.add(ImageUtils.getDrawable("http://www.tanglikeji.com/Public/Uploads/2017-03-20/58cf9bea49bb9.jpg"));
//        quanguoPathlist.add(ImageUtils.getDrawable("http://www.tanglikeji.com/Public/Uploads/2017-03-20/58cf9bea49bb9.jpg"));
//        quanguoPathlist.add(ImageUtils.getDrawable("http://www.tanglikeji.com/Public/Uploads/2017-03-20/58cf9bea49bb9.jpg"));
//        quanguoPathlist.add(ImageUtils.getDrawable("http://www.tanglikeji.com/Public/Uploads/2017-03-20/58cf9bea49bb9.jpg"));
//        quanguoPathlist.add(ImageUtils.getDrawable("http://www.tanglikeji.com/Public/Uploads/2017-03-20/58cf9bea49bb9.jpg"));
        quanguoPathlist.add("http://www.tanglikeji.com/Public/Uploads/2017-03-20/58cf9bea49bb9.jpg");
        quanguoPathlist.add("http://www.tanglikeji.com/Public/Uploads/2017-03-20/58cf9bea49bb9.jpg");
        quanguoPathlist.add("http://www.tanglikeji.com/Public/Uploads/2017-03-20/58cf9bea49bb9.jpg");
        quanguoPathlist.add("http://www.tanglikeji.com/Public/Uploads/2017-03-20/58cf9bea49bb9.jpg");
        quanguoPathlist.add("http://www.tanglikeji.com/Public/Uploads/2017-03-20/58cf9bea49bb9.jpg");

        gridviewQuanguo.setAdapter(new QuanguoGridViewAdapter(getActivity(), null, quanguoPathlist));
    }

    //设置Banner
    private void setBanner(Banner banner, ArrayList listpath) {
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        banner.setImageLoader(new MyLoader());
        banner.setImages(listpath);
        banner.setBannerAnimation(Transformer.Default);
        banner.setDelayTime(2000);
        banner.setIndicatorGravity(BannerConfig.RIGHT).setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Log.i("tag", "你点了第" + position + "张轮播图");
            }
        }).start();
    }

    //自定义图片加载器
    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load((String) path).into(imageView);
        }
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.btn_location, R.id.btn_logout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_location:
                break;
            case R.id.btn_logout:
                break;
            default:
                break;
        }
    }
}
