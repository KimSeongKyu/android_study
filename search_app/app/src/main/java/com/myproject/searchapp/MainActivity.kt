package com.myproject.searchapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.myproject.searchapp.databinding.ActivityMainBinding
import com.myproject.searchapp.view.BaseActivity
import com.myproject.searchapp.viewmodel.MainViewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override val layoutResourceId: Int
        get() = R.layout.activity_main

    override val viewModel : MainViewModel = MainViewModel()

    override fun initStartView() {

    }

    override fun initDataBinding() {

    }

    override fun initAfterBinding() {

    }
}