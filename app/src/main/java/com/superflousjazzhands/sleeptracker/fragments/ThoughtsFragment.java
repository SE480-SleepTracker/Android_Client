package com.superflousjazzhands.sleeptracker.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.superflousjazzhands.sleeptracker.R;

/**
 * Created by antoniocarella on 11/3/14.
 */
public class ThoughtsFragment extends Fragment {

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
    public static ThoughtsFragment newInstance(int sectionNumber) {
        ThoughtsFragment fragment = new ThoughtsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        Log.d(TAG, "New ThoughtsFragment Created.");
        return fragment;
    }

    public ThoughtsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_thoughts, container, false);
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }
}
