package com.beuni.roomdbimpl.fragment.contact_list_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.beuni.roomdbimpl.R
import com.beuni.roomdbimpl.RoomDbApplication
import com.beuni.roomdbimpl.adapter.ContactListAdapter
import com.beuni.roomdbimpl.db.Contacts
import com.beuni.roomdbimpl.viewmodel.ContactViewModel
import com.beuni.roomdbimpl.viewmodel.ContactViewModelFactory
import kotlinx.android.synthetic.main.fragment_contact_list.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ContactListFragment : Fragment() {

    private val viewModel: ContactViewModel by viewModels {
        ContactViewModelFactory((this.activity?.application as RoomDbApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        

        view.findViewById<Button>(R.id.add_contact).setOnClickListener {
            findNavController().navigate(R.id.action_ContactListFragment_to_AddContactFragment)
        }
    }

    private fun setupRecyclerView() {

        val adapter = ContactListAdapter()
        recycler_view.apply {
            this.adapter = adapter
            layoutManager = LinearLayoutManager(this.context)
        }

        viewModel.allContacts.observe(this.viewLifecycleOwner, Observer<List<Contacts>>{
                adapter.updateContactData(it)
        })

    }
}