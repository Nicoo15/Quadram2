package com.example.quadram.ui.topfree;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TopfreeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TopfreeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is topfree fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}