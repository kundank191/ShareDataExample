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

import com.example.android.examplesharedata.R;
import com.example.android.examplesharedata.ViewModels.MyViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kundan on 14-05-2018.
 */
public class FirstPageFragment extends Fragment {

    @BindView(R.id.fab_next_firstPage)
    FloatingActionButton nextButton;
    @BindView(R.id.et_firstName)
    EditText editTextFirstName;
    @BindView(R.id.ip_first_name)
    TextInputLayout textInputLayout;
    private onNextClicked mNextListener;
    //View model Variable
    private MyViewModel viewModel;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mNextListener = (onNextClicked) context;
        } catch (Exception e){
            throw new ClassCastException(context.getPackageName() + " Must implement onNextClicked Listener");
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
        View rootView = inflater.inflate(R.layout.fragment_first_page,container,false);
        ButterKnife.bind(this,rootView);
        setupFAB();
        return rootView;
    }

    private void setupFAB(){
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(editTextFirstName.getText().toString())){
                    textInputLayout.setError("Please Enter First Name");
                } else {
                    viewModel.setFirstName(editTextFirstName.getText().toString());
                    mNextListener.onFirstPageNextClickListener();
                }
            }
        });
    }

    public interface onNextClicked{
        public void onFirstPageNextClickListener();
    }
}
