package com.lrs.test.activity.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lrs.test.R;

import java.util.List;

/**
 * Created by wb-lrs192703 on 2017/6/13.
 */

public class MainAdapter extends BaseAdapter {
    private Context context;
    private List<String> mData;
    private LayoutInflater inflater;


    public MainAdapter(Context context, List<String> mData) {
        this.context = context;
        this.mData = mData;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mData == null ? 0 : mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData == null ? null : mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MainHolder mHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_main_list, null);
            mHolder = new MainHolder();
            mHolder.mTab = (TextView) convertView.findViewById(R.id.tv_main_item);
            convertView.setTag(mHolder);
        } else {
            mHolder = (MainHolder) convertView.getTag();
        }
        mHolder.mTab.setText(mData.get(position));
        return convertView;
    }

    class MainHolder {
        public TextView mTab;
    }
}
