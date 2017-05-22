package com.example.a.mailuygulamasi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by a on 5/22/17.
 */

public class MailIcreikFragment extends Fragment {
    private int pozisyon  =0;

    public MailIcreikFragment(int pozisyon) {
        this.pozisyon = pozisyon;
    }

    public int getPozisyon() {
        return pozisyon;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.icerik, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        TextView icerik_tv = (TextView)getActivity().findViewById(R.id.tv_icerik);
        String[] icerik = getActivity().getResources().getStringArray(R.array.mail_icerik);
        icerik_tv.setText(icerik[pozisyon]);
    }
}
