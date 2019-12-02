package com.example.intern_food;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;

public class FeedbackFragment extends Fragment {

RadioButton avg, good, del;
    View view;
    Button firstButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
// Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_feedback, container, false);

        avg= view.findViewById(R.id.radio_brkfast_avg);
        good=view.findViewById(R.id.radio_brkfast_good);
        del=view.findViewById(R.id.radio_brkfast_del);




        return view;
    }
}
