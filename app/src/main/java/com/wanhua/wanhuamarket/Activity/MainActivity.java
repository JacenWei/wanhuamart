package com.wanhua.wanhuamarket.Activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;

import com.blankj.utilcode.util.BarUtils;
import com.wanhua.wanhuamarket.Fragment.HomeFragment;
import com.wanhua.wanhuamarket.Fragment.MyFragment;
import com.wanhua.wanhuamarket.Fragment.NearFragment;
import com.wanhua.wanhuamarket.Fragment.ScanCodeFragment;
import com.wanhua.wanhuamarket.Fragment.ShoppingFragment;
import com.wanhua.wanhuamarket.R;
import com.wanhua.wanhuamarket.base.BaseActiviity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActiviity {

    @BindView(R.id.btn_home)
    RadioButton btnHome;
    @BindView(R.id.btn_scan_code)
    RadioButton btnScanCode;
    @BindView(R.id.btn_near)
    RadioButton btnNear;
    @BindView(R.id.btn_shop)
    RadioButton btnShop;
    @BindView(R.id.btn_my)
    RadioButton btnMy;
    @BindView(R.id.fl_body)
    FrameLayout flBody;

    private HomeFragment homeFragment;
    private ScanCodeFragment scanCodeFragment;
    private NearFragment nearFragment;
    private ShoppingFragment shoppingFragment;
    private MyFragment myFragment;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //设置状态栏不可见
        BarUtils.setStatusBarVisibility(this,false);
        ButterKnife.bind(this);
        initFragment(savedInstanceState);

    }

    /**
     * 初始化Fragment
     */
    private void initFragment(Bundle savedInstanceState) {
        @SuppressLint("CommitTransaction")
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (savedInstanceState != null) {
            homeFragment = (HomeFragment) getSupportFragmentManager().findFragmentByTag("homeFragment");
            scanCodeFragment = (ScanCodeFragment) getSupportFragmentManager().findFragmentByTag("scanCodeFragment");
            nearFragment = (NearFragment) getSupportFragmentManager().findFragmentByTag("nearFragment");
            shoppingFragment = (ShoppingFragment) getSupportFragmentManager().findFragmentByTag("shoppingFragment");
            myFragment = (MyFragment) getSupportFragmentManager().findFragmentByTag("myFragment");
        } else {
            homeFragment = new HomeFragment();
            scanCodeFragment = new ScanCodeFragment();
            nearFragment = new NearFragment();
            shoppingFragment = new ShoppingFragment();
            myFragment = new MyFragment();
            fragmentTransaction.add(R.id.fl_body, homeFragment, "homeFragment");
            fragmentTransaction.add(R.id.fl_body, scanCodeFragment, "scanCodeFragment");
            fragmentTransaction.add(R.id.fl_body, nearFragment, "nearFragment");
            fragmentTransaction.add(R.id.fl_body, shoppingFragment, "shoppingFragment");
            fragmentTransaction.add(R.id.fl_body, myFragment, "myFragment");
        }
        btnHome.setChecked(true);
        fragmentTransaction.show(homeFragment);
        fragmentTransaction.hide(scanCodeFragment);
        fragmentTransaction.hide(nearFragment);
        fragmentTransaction.hide(shoppingFragment);
        fragmentTransaction.hide(myFragment);
        fragmentTransaction.commitNowAllowingStateLoss();
    }

    /**
     * 点击切换Fragment
     *
     * @param view
     */
    @OnClick({R.id.btn_home, R.id.btn_scan_code, R.id.btn_near, R.id.btn_shop, R.id.btn_my})
    public void onViewClicked(View view) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        switch (view.getId()) {
            case R.id.btn_home:
                fragmentTransaction.show(homeFragment);
                fragmentTransaction.hide(scanCodeFragment);
                fragmentTransaction.hide(nearFragment);
                fragmentTransaction.hide(shoppingFragment);
                fragmentTransaction.hide(myFragment);
                fragmentTransaction.commitNowAllowingStateLoss();
                break;
            case R.id.btn_scan_code:
                fragmentTransaction.hide(homeFragment);
                fragmentTransaction.show(scanCodeFragment);
                fragmentTransaction.hide(nearFragment);
                fragmentTransaction.hide(shoppingFragment);
                fragmentTransaction.hide(myFragment);
                fragmentTransaction.commitNowAllowingStateLoss();
                break;
            case R.id.btn_near:
                fragmentTransaction.hide(homeFragment);
                fragmentTransaction.hide(scanCodeFragment);
                fragmentTransaction.show(nearFragment);
                fragmentTransaction.hide(shoppingFragment);
                fragmentTransaction.hide(myFragment);
                fragmentTransaction.commitNowAllowingStateLoss();
                break;
            case R.id.btn_shop:
                fragmentTransaction.hide(homeFragment);
                fragmentTransaction.hide(scanCodeFragment);
                fragmentTransaction.hide(nearFragment);
                fragmentTransaction.show(shoppingFragment);
                fragmentTransaction.hide(myFragment);
                fragmentTransaction.commitNowAllowingStateLoss();
                break;
            case R.id.btn_my:
                fragmentTransaction.hide(homeFragment);
                fragmentTransaction.hide(scanCodeFragment);
                fragmentTransaction.hide(nearFragment);
                fragmentTransaction.hide(shoppingFragment);
                fragmentTransaction.show(myFragment);
                fragmentTransaction.commitNowAllowingStateLoss();
                break;
            default:
                break;
        }
    }


    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setEvent() {

    }
}
