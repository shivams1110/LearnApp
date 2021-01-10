package com.beuni.roomdbimpl.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.beuni.roomdbimpl.R
import com.beuni.roomdbimpl.db.Contacts
import com.beuni.roomdbimpl.viewholder.ContactListViewHolder

class ContactListAdapter() : RecyclerView.Adapter<ContactListViewHolder>() {

    var contactList: MutableList<Contacts> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactListViewHolder {
        return ContactListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.contact_item_layout, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    override fun onBindViewHolder(holder: ContactListViewHolder, position: Int) {
        holder.bindData(contactList[position])
    }

    fun updateContactData(it: List<Contacts>?) {
        contactList.clear()
        it?.let { it1 -> contactList.addAll(it1) }
        notifyDataSetChanged()
    }
}