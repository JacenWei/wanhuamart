package com.wanhua.wanhuamarket.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.wanhua.wanhuamarket.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/4/7.
 */

public class QuanguoGridViewAdapter extends BaseAdapter {
    private ArrayList<String> mNameList = new ArrayList<>();
    private ArrayList<String> mPathList = new ArrayList<>();
    private  ArrayList<Drawable> mDrawableList = new ArrayList<>();
    private LayoutInflater mInflater;
    private Context mContext;
    LinearLayout.LayoutParams params;

    public QuanguoGridViewAdapter(Context context, ArrayList<String> nameList,ArrayList<String> pathList) {
        mNameList = nameList;
//        mDrawableList = drawableList;
        mPathList = pathList;
        mContext = context;
        mInflater = LayoutInflater.from(context);

        params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER;
    }

    public int getCount() {
        return mDrawableList.size();
    }

    public Object getItem(int position) {
        return mDrawableList.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        final QuanguoGridViewAdapter.ItemViewTag viewTag;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.quanguo_gridview_item, null);
            viewTag = new QuanguoGridViewAdapter.ItemViewTag((ImageView) convertView.findViewById(R.id.iv_quanguo), (TextView) convertView.findViewById(R.id.tx_quanguo));
            convertView.setTag(viewTag);
        } else {
            viewTag = (QuanguoGridViewAdapter.ItemViewTag) convertView.getTag();
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.CENTER;
        convertView.setLayoutParams(layoutParams);

        // set name
        viewTag.mName.setText(mNameList.get(position));

        // set icon
        Glide.with(convertView).asDrawable().load(mPathList.get(position)).into(new Target<Drawable>() {
            @Override
            public void onLoadStarted(@Nullable Drawable placeholder) {

            }

            @Override
            public void onLoadFailed(@Nullable Drawable errorDrawable) {

            }

            @Override
            public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                viewTag.mIcon.setBackgroundDrawable(resource);
            }

            @Override
            public void onLoadCleared(@Nullable Drawable placeholder) {

            }

            @Override
            public void getSize(@NonNull SizeReadyCallback cb) {

            }

            @Override
            public void removeCallback(@NonNull SizeReadyCallback cb) {

            }

            @Override
            public void setRequest(@Nullable Request request) {

            }

            @Nullable
            @Override
            public Request getRequest() {
                return null;
            }

            @Override
            public void onStart() {

            }

            @Override
            public void onStop() {

            }

            @Override
            public void onDestroy() {

            }
        });
//        viewTag.mIcon.setBackgroundDrawable(mDrawableList.get(position));
        ViewGroup.LayoutParams para = viewTag.mIcon.getLayoutParams();
        viewTag.mIcon.setLayoutParams(para);
//        viewTag.mIcon.setLayoutParams(params);
        return convertView;
    }
    class ItemViewTag {
        protected ImageView mIcon;
        protected TextView mName;

        public ItemViewTag(ImageView icon, TextView name) {
            this.mName = name;
            this.mIcon = icon;
        }
    }
}
