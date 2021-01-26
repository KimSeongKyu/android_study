package com.myproject.mvvmpattern.model

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE

@Dao
interface ContactDao {
    @Query("select * from contact")
    fun getContacts(): LiveData<List<Contact>>

    @Insert(onConflict = REPLACE)
    fun insert(contact: Contact)

    @Delete
    fun delete(contact: Contact)
}