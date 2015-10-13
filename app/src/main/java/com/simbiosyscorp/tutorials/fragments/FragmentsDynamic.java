package com.simbiosyscorp.tutorials.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

public class FragmentsDynamic extends Activity {
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments_dynamic);
    }

    public void changeFrag(View view) {
//This function executes on Button Click

        //Getting the Fragment Manager instance to dynamically access Fragments
        FragmentManager manager = getFragmentManager();
        //Starting the dynamic transaction for Fragments
        FragmentTransaction transaction = manager.beginTransaction();
        //Getting a handle on the current Fragment attached to the activity
        fragment = manager.findFragmentById(R.id.fragment3);

        //Conditionally changing the Fragments dynamically
        if (fragment instanceof Fargment1) {
            Fragment2 frag2 = new Fragment2();
            //replace function replaces the first parameter Fragment with the second
            transaction.replace(R.id.fragment3, frag2);
            //Adding Fragments transaction to Backstack
            transaction.addToBackStack(null).commit();
        } else {
            Fargment1 frag1 = new Fargment1();
            transaction.replace(R.id.fragment3, frag1);
            transaction.addToBackStack(null).commit();
        }
    }

    @Override
    public void onBackPressed() {
        // super.onBackPressed();
        FragmentManager fragmentManager = getFragmentManager();
        while (fragmentManager.getBackStackEntryCount() != 0) {
            fragmentManager.popBackStackImmediate();
        }
    }
}
