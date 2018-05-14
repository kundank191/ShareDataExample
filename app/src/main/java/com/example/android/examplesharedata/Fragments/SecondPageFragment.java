package com.example.android.examplesharedata.Fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.examplesharedata.R;

/**
 * Created by Kundan on 14-05-2018.
 */
public class SecondPageFragment extends Fragment {
    private onPreviousClicked mPreviousListener;
    private onCompletedClicked mCompleteListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mPreviousListener = (onPreviousClicked) context;
        } catch (Exception e){
            throw new ClassCastException(context.getPackageName() + " Must implement onPreviousClicked Listener");
        }

        try {
            mCompleteListener = (onCompletedClicked) context;
        } catch (Exception e){
            throw new ClassCastException(context.getPackageName() + " Must implement onCompleteClicked Listener");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_second_page,container,false);
        return rootView;
    }

    public interface onPreviousClicked{
        public void onSecondPagePreviousClickListener();
    }
    public interface onCompletedClicked{
        public void onSecondPageCompleteClickListener();
    }
}
