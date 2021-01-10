package com.beuni.roomdbimpl.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.beuni.roomdbimpl.R
import com.beuni.roomdbimpl.db.Contacts

class ContactListViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun bindData(contacts: Contacts) {
        view.findViewById<TextView>(R.id.txt_contact_name).text = contacts.name
        view.findViewById<TextView>(R.id.txt_contact_mobile).text = contacts.mobileNumber
    }

}
