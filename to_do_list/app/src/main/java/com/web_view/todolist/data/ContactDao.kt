package com.web_view.todolist.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.web_view.todolist.model.Contact

@Dao
interface ContactDao {

    @Query("select * from contact order by name asc")
    fun getAll(): LiveData<List<Contact>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(contact: Contact)

    @Delete
    fun delete(contact: Contact)
}