package com.myproject.mvvmpattern.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.myproject.mvvmpattern.R
import com.myproject.mvvmpattern.model.Contact
import com.myproject.mvvmpattern.viewmodel.ContactViewModel
import kotlinx.android.synthetic.main.activity_add.*
import kotlin.math.absoluteValue

class AddActivity : AppCompatActivity() {
    private lateinit var contactViewModel: ContactViewModel
    private var id : Long? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        contactViewModel = ViewModelProvider(this).get(contactViewModel::class.java)

        if(intent != null && intent.hasExtra(EXTRA_CONTACT_NAME)
            && intent.hasExtra(EXTRA_CONTACT_NUMBER)
            && intent.hasExtra(EXTRA_CONTACT_ID)){
            editTextName.setText(intent.getStringExtra(EXTRA_CONTACT_NAME))
            editTextNumber.setText(intent.getStringExtra(EXTRA_CONTACT_NUMBER))
            id = intent.getLongExtra(EXTRA_CONTACT_ID, -1)
        }
    }

    companion object{
        const val EXTRA_CONTACT_NAME = "EXTRA_CONTACT_NAME"
        const val EXTRA_CONTACT_NUMBER = "EXTRA_CONTACT_NUMBER"
        const val EXTRA_CONTACT_ID = "EXTRA_CONTACT_ID"
    }
}