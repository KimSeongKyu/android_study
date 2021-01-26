package com.myproject.mvvmpattern.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.myproject.mvvmpattern.R
import com.myproject.mvvmpattern.model.Contact
import com.myproject.mvvmpattern.viewmodel.ContactViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var contactViewModel: ContactViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var adapter = ContactAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        contactViewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application))
            .get(ContactViewModel::class.java)
        contactViewModel.getContacts().observe(this, Observer<List<Contact>> { contacts ->
            adapter.setContacts(contacts!!)
        })
    }
}