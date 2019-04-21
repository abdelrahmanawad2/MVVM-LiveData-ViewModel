package com.example.testappandroidjetback.ui.mainactivity2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel(){

    private lateinit var userViewModel : MutableLiveData<UserModel>


    public fun getUserModel() : LiveData<UserModel>? {
            return userViewModel
    }

}
