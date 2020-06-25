package com.example.shinjitsu.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.shinjitsu.R;

public class ProfileFragment extends Fragment {

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View profileView = inflater.inflate(R.layout.profile_fragment, container, false);

        return profileView;
    }
}
