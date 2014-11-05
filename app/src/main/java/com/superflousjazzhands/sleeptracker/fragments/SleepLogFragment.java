package com.superflousjazzhands.sleeptracker.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.superflousjazzhands.sleeptracker.API;
import com.superflousjazzhands.sleeptracker.R;
import com.superflousjazzhands.sleeptracker.adapters.SleepLogAdapter;
import com.superflousjazzhands.sleeptracker.objects.SleepLog;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by antoniocarella on 11/4/14.
 */
public class SleepLogFragment extends ListFragment {

    public interface OnSleepLogSelectedListener {
        public void onSleepLogSelected();
    }
    private SleepLogAdapter sleepLogAdapter;
    OnSleepLogSelectedListener mListener;

    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    private static final String TAG = Fragment.class.toString();

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static SleepLogFragment newInstance(int sectionNumber) {
        SleepLogFragment fragment = new SleepLogFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        Log.d(TAG, "New SleepLog Fragment Created.");
        return fragment;
    }

    public SleepLogFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sleep_log, container, false);
        setHasOptionsMenu(true);
        final Context context = getActivity();
        // get data from API call to backend
        API.sleepLogService.getAllSleepLogs(new Callback< List < SleepLog>>(){

            @Override
            public void success(List<SleepLog> sleepLogs, Response response) {
                sleepLogAdapter = new SleepLogAdapter(context, sleepLogs);
                setListAdapter(sleepLogAdapter);
            }

            @Override
            public void failure(RetrofitError retrofitError) {

            }
        });
        // in the success message
        // create the adapter objec
        // and set the adapter to the list view

        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_sleep_log, menu);
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){

        switch (item.getItemId()){
            case R.id.action_create_new:
                // do something
                return true;

        }

        return true;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mListener = (OnSleepLogSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnArticleSelectedListener");
        }
    }
}