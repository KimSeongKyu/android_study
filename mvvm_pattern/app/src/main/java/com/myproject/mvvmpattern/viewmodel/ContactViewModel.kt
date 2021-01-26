package com.myproject.mvvmpattern.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.myproject.mvvmpattern.model.Contact
import com.myproject.mvvmpattern.repository.ContactRepository

class ContactViewModel(application: Application): AndroidViewModel(application) {
    private val contactRepository = ContactRepository(application)

    fun getContacts(): LiveData<List<Contact>>{
        return contactRepository.getContacts()
        var a = mutableSetOf(1, 1)
        
        
    }

}