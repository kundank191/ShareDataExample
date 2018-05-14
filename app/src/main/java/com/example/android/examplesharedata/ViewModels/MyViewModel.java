package com.example.android.examplesharedata.ViewModels;

import android.arch.lifecycle.ViewModel;

/**
 * Created by Kundan on 14-05-2018.
 */
public class MyViewModel extends ViewModel {

    private String firstName = "Anony";
    private String secondName = "mous";

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
}
