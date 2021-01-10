package com.beuni.roomdbimpl.fragment.add_contact_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import com.beuni.roomdbimpl.R
import com.beuni.roomdbimpl.RoomDbApplication
import com.beuni.roomdbimpl.db.ContactRoomDatabase
import com.beuni.roomdbimpl.db.Contacts
import com.beuni.roomdbimpl.viewmodel.ContactViewModel
import com.beuni.roomdbimpl.viewmodel.ContactViewModelFactory
import kotlinx.android.synthetic.main.fragment_add_contact.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AddContactFragment : Fragment() {

    val viewModel: ContactViewModel by viewModels {
        ContactViewModelFactory((this.activity?.application as RoomDbApplication).repository)
    }

    private val db: ContactRoomDatabase by lazy {
        ContactRoomDatabase.getInstance(this.requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_contact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            viewModel.insert(Contacts(name = edt_name.text.toString(), mobileNumber = edt_mobile.text.toString()))

        }
    }
}