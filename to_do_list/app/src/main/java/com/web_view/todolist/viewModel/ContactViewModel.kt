package com.web_view.todolist.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.web_view.todolist.model.Contact
import com.web_view.todolist.repository.ContactRepository

class ContactViewModel(application: Application) : AndroidViewModel(application) {

    private val contactRepository =
        ContactRepository(application)
    private val contacts = contactRepository.getAll()

    fun getAll() : LiveData<List<Contact>>{
        return this.contacts
    }

    fun insert(contact: Contact){
        contactRepository.insert(contact)
    }

    fun delete(contact: Contact){
        contactRepository.delete(contact)
    }
}