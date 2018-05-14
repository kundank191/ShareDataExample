package com.example.android.examplesharedata;

import android.app.FragmentManager;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.android.examplesharedata.Fragments.FirstPageFragment;
import com.example.android.examplesharedata.Fragments.SecondPageFragment;
import com.example.android.examplesharedata.ViewModels.MyViewModel;

public class MainActivity extends AppCompatActivity implements FirstPageFragment.onNextClicked
                                                                ,SecondPageFragment.onPreviousClicked
                                                                ,SecondPageFragment.onCompletedClicked{

    FragmentManager mFragmentManager;
    private MyViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setting up View model
        viewModel = ViewModelProviders.of(this).get(MyViewModel.class);

        mFragmentManager = getFragmentManager();
        if(savedInstanceState == null){
            mFragmentManager.beginTransaction()
                    .add(R.id.fragment_container,new FirstPageFragment())
                    .commit();
        }
    }

    @Override
    public void onFirstPageNextClickListener() {
        mFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container,new SecondPageFragment())
                        .commit();
    }

    @Override
    public void onSecondPagePreviousClickListener() {
        mFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container,new FirstPageFragment())
                        .commit();

    }

    @Override
    public void onSecondPageCompleteClickListener() {
        Toast.makeText(this,"Form Complete",Toast.LENGTH_SHORT).show();
    }
}
