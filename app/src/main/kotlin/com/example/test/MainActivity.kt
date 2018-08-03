package com.example.test

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import pojo.Contacts

class MainActivity : FragmentActivity(),
                     ContactListFragment.OnContactListFragmentInteractionListener {

    override fun onContactListFragmentInteraction(item: Contacts.Contact?) {
        TODO("not implemented")
    }

    private val contactListFragment = ContactListFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
                              .add(R.id.contacts_container, contactListFragment)
                              .commit()
    }


}
