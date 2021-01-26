package com.myproject.mvvmpattern.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.myproject.mvvmpattern.R
import com.myproject.mvvmpattern.model.Contact
import kotlinx.android.synthetic.main.item_contact.view.*

class ContactAdapter: RecyclerView.Adapter<ContactAdapter.ViewHolder>() {
    private var contacts = listOf<Contact>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var contact = contacts.get(position)
        holder.bind(contact)
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bind(contact: Contact){
            itemView.textInitial.text = contact.initial.toString()
            itemView.textName.text = contact.name
            itemView.textNumber.text = contact.number
        }
    }

    fun setContacts(contacts: List<Contact>){
        this.contacts = contacts
        notifyDataSetChanged()
    }
}