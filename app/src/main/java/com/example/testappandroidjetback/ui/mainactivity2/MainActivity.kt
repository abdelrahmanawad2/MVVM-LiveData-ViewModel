package com.example.testappandroidjetback.ui.mainactivity2

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.testappandroidjetback.R
import com.example.testappandroidjetback.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
//    private lateinit var userViewModel : ViewModel
//    private val userViewModel:UserModel = UserModel("ahmed")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java);

//        userViewModel.getUserModel()?.observe(this, Observer { userViewModel ->
//
//        })




//        activityMainBinding.userModel = userViewModel

        activityMainBinding.apply {
//            activityMainBinding.textView.setText("abcd")
        }

//        activityMainBinding.button.setOnClickListener {
//            activityMainBinding.apply {
//
//                userModel?.nickName = "abcd"
//                userModel?.name = "mostafa"
//                invalidateAll()
////                activityMainBinding.userViewModel?.name = "3abas"
//            }
////            activityMainBinding.userViewModel?.nickName = "Mahmoud"
//        }

    }
}
