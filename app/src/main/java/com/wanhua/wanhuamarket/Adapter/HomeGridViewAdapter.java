package com.wanhua.wanhuamarket.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wanhua.wanhuamarket.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/4/6.
 */

public class HomeGridViewAdapter extends BaseAdapter {
    private ArrayList<String> mNameList = new ArrayList<String>();
    private ArrayList<Drawable> mDrawableList = new ArrayList<Drawable>();
    private LayoutInflater mInflater;
    private Context mContext;
    LinearLayout.LayoutParams params;

    public HomeGridViewAdapter(Context context, ArrayList<String> nameList, ArrayList<Drawable> drawableList) {
        mNameList = nameList;
        mDrawableList = drawableList;
        mContext = context;
        mInflater = LayoutInflater.from(context);

        params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER;
    }

    public int getCount() {
        return mNameList.size();
    }

    public Object getItem(int position) {
        return mNameList.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ItemViewTag viewTag;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.home_gridview_item, null);
            viewTag = new ItemViewTag((ImageView) convertView.findViewById(R.id.iv_home_gridview), (TextView) convertView.findViewById(R.id.tx_home_gridview));
            convertView.setTag(viewTag);
        } else {
            viewTag = (ItemViewTag) convertView.getTag();
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.CENTER;
        convertView.setLayoutParams(layoutParams);

        // set name
        viewTag.mName.setText(mNameList.get(position));

        // set icon
        viewTag.mIcon.setBackgroundDrawable(mDrawableList.get(position));
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
