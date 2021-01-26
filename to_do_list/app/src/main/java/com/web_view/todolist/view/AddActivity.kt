package com.web_view.todolist.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.web_view.todolist.model.Contact
import com.web_view.todolist.viewModel.ContactViewModel
import com.web_view.todolist.R
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {
    private lateinit var contactViewModel: ContactViewModel
    private var id: Long? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        contactViewModel = ViewModelProvider(this).get(ContactViewModel::class.java)

        if(intent != null && intent.hasExtra(EXTRA_CONTACT_NAME)
            && intent.hasExtra(EXTRA_CONTACT_NUMBER)
            && intent.hasExtra(EXTRA_CONTACT_ID)){
            addEditTextName.setText(intent.getStringExtra(EXTRA_CONTACT_NAME))
            addEditTextNumber.setText(intent.getStringExtra(EXTRA_CONTACT_NUMBER))
            id = intent.getLongExtra(EXTRA_CONTACT_ID, -1)
        }

        buttonDone.setOnClickListener {
            val name = addEditTextName.text.toString()
            val number = addEditTextNumber.text.toString()
            if(name.isEmpty() || number.isEmpty()){
                Toast.makeText(this, "이름과 번호를 입력하세요.", Toast.LENGTH_LONG).show()
            }
            else{
                val initial = name[0].toUpperCase()
                val contact =
                    Contact(
                        id,
                        name,
                        number,
                        initial
                    )
                contactViewModel.insert(contact)
                finish()
            }
        }
    }

    companion object{
        const val EXTRA_CONTACT_NAME = "EXTRA_CONTACT+NAME"
        const val EXTRA_CONTACT_NUMBER = "EXTRA_CONTACT_NUMBER"
        const val EXTRA_CONTACT_ID = "EXTRA_CONTACT_ID"
    }
}