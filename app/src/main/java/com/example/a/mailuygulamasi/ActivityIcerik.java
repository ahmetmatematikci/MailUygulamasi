package com.example.a.mailuygulamasi;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

/**
 * Created by a on 5/22/17.
 */

class ActivityIcerik  extends AppCompatActivity{
    MailIcreikFragment mailIcreikFragment ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }

        int pozisyon = getIntent().getIntExtra("pozisyon", 0);
        mailIcreikFragment = new MailIcreikFragment(pozisyon);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(android.R.id.content, mailIcreikFragment);
        transaction.commit();

    }

    @Override
    public void onPause() {
        super.onPause();

        if (mailIcreikFragment !=null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.remove(mailIcreikFragment);
            transaction.commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId()==android.R.id.home){

            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            NavUtils.navigateUpTo(this, i);
            return  true;
        }
        return super.onOptionsItemSelected(item);

    }
}
