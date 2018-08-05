package com.example.test

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import pojo.Contacts


class MainActivity : FragmentActivity(),
                     ContactListFragment.OnContactListFragmentInteractionListener {

    override fun onContactListFragmentInteraction(item: Contacts.Attributes) {
        val contactFragment = ContactFragment()
        supportFragmentManager?.beginTransaction()
                ?.replace(R.id.contacts_container, contactFragment)
                ?.commit()
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val contactListFragment = ContactListFragment()
        supportFragmentManager.beginTransaction()
                              .add(R.id.contacts_container, contactListFragment)
                              .commit()
    }


}
