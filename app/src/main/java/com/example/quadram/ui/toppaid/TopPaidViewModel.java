package com.example.quadram.ui.toppaid;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TopPaidViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TopPaidViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is TopPaid€ fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}