package com.web_view.todolist.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.web_view.todolist.data.ContactDao
import com.web_view.todolist.data.ContactDatabase
import com.web_view.todolist.model.Contact
import java.lang.Exception

class ContactRepository(application : Application) {

    private val contactDatabase = ContactDatabase.getInstance(application)!!
    private val contactDao : ContactDao = contactDatabase.contactDao()
    private val contacts : LiveData<List<Contact>> = contactDao.getAll()

    fun getAll() : LiveData<List<Contact>>{
        return contacts
    }

    fun insert(contact: Contact){
        try{
            val thread = Thread(Runnable {
                contactDao.insert(contact)
            })
            thread.start()
        } catch (e: Exception){
            e.printStackTrace()
        }
    }

    fun delete(contact: Contact){
        try{
            val thread = Thread(Runnable {
                contactDao.delete(contact)
            })
            thread.start()
        } catch (e: Exception){
            e.printStackTrace()
        }
    }

}