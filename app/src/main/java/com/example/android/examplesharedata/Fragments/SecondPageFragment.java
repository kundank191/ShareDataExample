package com.example.android.examplesharedata.Fragments;

import android.app.Fragment;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android.examplesharedata.R;
import com.example.android.examplesharedata.ViewModels.MyViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kundan on 14-05-2018.
 */
public class SecondPageFragment extends Fragment {

    @BindView(R.id.fab_previous_secondPage)
    FloatingActionButton previousButton;
    @BindView(R.id.fab_complete_SecondPage)
    FloatingActionButton completeButton;
    @BindView(R.id.et_lastName)
    EditText editTextLastName;
    @BindView(R.id.ip_last_name)
    TextInputLayout textInputLayout;
    @BindView(R.id.tv_firstName)
    TextView textView;

    private onPreviousClicked mPreviousListener;
    private onCompletedClicked mCompleteListener;
    //View Model variable
    private MyViewModel viewModel;

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
        //Initializing view model
        viewModel = ViewModelProviders.of((FragmentActivity) getActivity()).get(MyViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_second_page,container,false);
        ButterKnife.bind(this,rootView);
        setupFABS();
        textView.setText(String.format("Hello %s", viewModel.getFirstName()));
        return rootView;
    }

    /**
     * This function sets up the respective FAB buttons on the XML layout
     */
    private void setupFABS(){
        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPreviousListener.onSecondPagePreviousClickListener();
            }
        });

        completeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(editTextLastName.getText().toString())){
                    textInputLayout.setError("Please Enter Last Name");
                } else {
                    textInputLayout.setErrorEnabled(false);
                    viewModel.setSecondName(editTextLastName.getText().toString());
                    mCompleteListener.onSecondPageCompleteClickListener();
                }
            }
        });
    }

    /**
     * This invokes a method in Activity when previous button is clicked
     */
    public interface onPreviousClicked{
        public void onSecondPagePreviousClickListener();
    }

    /**
     * THis invokes another method in Activity when complete button is clicked
     */
    public interface onCompletedClicked{
        public void onSecondPageCompleteClickListener();
    }
}
