package com.example.a.mailuygulamasi;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

/**
 * Created by a on 5/22/17.
 */

public class MailListesi extends ListFragment {
    private boolean ektanYatayMi;
    private MailIcreikFragment mailIcreikFragment;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String [] mail_listesi = getActivity().getResources().getStringArray(R.array.mail_listesi);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_activated_1,mail_listesi);
        setListAdapter(adapter);

        FrameLayout container =(FrameLayout)getActivity().findViewById(R.id.icereik_fragment);
        ektanYatayMi = container!=null && container.getVisibility() == View.VISIBLE;

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        if (ektanYatayMi) {

            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            mailIcreikFragment = (MailIcreikFragment) getFragmentManager().findFragmentById(R.id.icereik_fragment);
            if (mailIcreikFragment == null || mailIcreikFragment.getPozisyon() !=position) {
                mailIcreikFragment = new MailIcreikFragment(position);

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.icereik_fragment, mailIcreikFragment);
                transaction.setTransition(FragmentTransaction.TRANSIT_ENTER_MASK);
                transaction.commit();
            }

        } else  {
            Intent i = new Intent(getActivity(), ActivityIcerik.class);
            i.putExtra("pozisyon", position);
            startActivity(i);

        }
    }

    @Override
    public void onPause() {
        super.onPause();

        if (mailIcreikFragment !=null) {
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.remove(mailIcreikFragment);
            transaction.commit();
        }
    }
}
