package com.web_view.todolist.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.web_view.todolist.model.Contact
import com.web_view.todolist.adapter.ContactAdapter
import com.web_view.todolist.viewModel.ContactViewModel
import com.web_view.todolist.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var contactViewModel: ContactViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ContactAdapter({ contact ->
            val intent = Intent(this, AddActivity::class.java)
            intent.putExtra(AddActivity.EXTRA_CONTACT_NAME, contact.name)
            intent.putExtra(AddActivity.EXTRA_CONTACT_NUMBER, contact.number)
            intent.putExtra(AddActivity.EXTRA_CONTACT_ID, contact.id)
            startActivity(intent)
        }, { contact ->
            deleteDialog(contact)
        })

        recyclerContact.adapter = adapter
        recyclerContact.layoutManager = LinearLayoutManager(this)

        buttonAdd.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }

        contactViewModel = ViewModelProvider(this).get(ContactViewModel::class.java)
        contactViewModel.getAll().observe(this, Observer<List<Contact>>{ contacts ->
            adapter.setContacts(contacts!!)
        })

    }

    private fun deleteDialog(contact : Contact) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("연락처를 삭제하시겠습니까?")
            .setNegativeButton("아니오"){_, _ ->}
            .setPositiveButton("예"){_, _ ->
                contactViewModel.delete(contact)
            }
        builder.show()
    }
}