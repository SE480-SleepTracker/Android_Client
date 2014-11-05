package com.superflousjazzhands.sleeptracker.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.superflousjazzhands.sleeptracker.R;
import com.superflousjazzhands.sleeptracker.objects.SleepLog;

import java.util.List;

/**
 * Created by antoniocarella on 11/4/14.
 */
public class SleepLogAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private List<SleepLog> sleepLogs;

    public SleepLogAdapter(Context context, List<SleepLog> SleepLogs) {
        layoutInflater = LayoutInflater.from(context);
        this.sleepLogs = SleepLogs;
    }

    @Override
    public int getCount() {
        return this.sleepLogs.size();
    }

    @Override
    public SleepLog getItem(int i) {
        return this.sleepLogs.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;

        if (view == null) {
            view = layoutInflater.inflate(R.layout.row_sleeplog_item, viewGroup, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        SleepLog sleepLog = sleepLogs.get(i);
        viewHolder.tvSleepLogdate.setText(sleepLog.getDate().toString());
        return view;
    }

    public static class ViewHolder {
        public TextView tvSleepLogdate;

        public ViewHolder(View view) {
            tvSleepLogdate = (TextView) view.findViewById(R.id.tv_sleep_log_date);
        }
    }

}
