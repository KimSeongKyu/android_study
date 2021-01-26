package com.myproject.mvvmpattern.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.myproject.mvvmpattern.model.Contact
import com.myproject.mvvmpattern.model.ContactDatabase
import java.lang.Exception
import kotlin.concurrent.thread

class ContactRepository(application: Application) {

    private val contactDatabase = ContactDatabase.getInstance(application)!!

    fun getContacts(): LiveData<List<Contact>>{
        //livedata는 비동기적으로 서브 스레드에서 동작
        return contactDatabase.contactDao().getContacts()
    }

    fun insert(contact: Contact){
        try {
            thread(start = true) {
                contactDatabase.contactDao().insert(contact)
            }
        } catch (e: Exception) {e.printStackTrace()}
    }

    fun delete(contact: Contact){
        try {
            thread(start = true) {
                contactDatabase.contactDao().delete(contact)
            }
        } catch (e: Exception) {e.printStackTrace()}
    }

}