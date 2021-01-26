package com.web_view.todolist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.web_view.todolist.R
import com.web_view.todolist.model.Contact
import kotlinx.android.synthetic.main.item_contact.view.*

class ContactAdapter(val contactItemClick: (Contact) -> Unit, val contactItemLongClick: (Contact) -> Unit)
    : RecyclerView.Adapter<ContactAdapter.ViewHolder>(){

    private var contacts = listOf<Contact>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = contacts[position]
        holder.setContact(contact)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setContact(contact: Contact) {
            itemView.textInitial.text = contact.initial.toString()
            itemView.textName.text = contact.name
            itemView.textNumber.text = contact.number

            itemView.setOnClickListener {
                contactItemClick(contact)
            }
            itemView.setOnLongClickListener {
                contactItemLongClick(contact)
                true
            }
        }
    }

    fun setContacts(contacts : List<Contact>){
        this.contacts = contacts
        notifyDataSetChanged()
    }
}

