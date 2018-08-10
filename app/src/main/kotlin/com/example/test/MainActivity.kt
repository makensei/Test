package com.example.test

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.test.ContactFragment.Companion.newInstance
import kotlinx.android.synthetic.main.activity_main.*
import pojo.Contacts

const val PHOTO_URL = "https://api.adorable.io/avatars/285/abott@adorable.png"

class MainActivity : AppCompatActivity(),
                     ContactListFragment.OnContactListFragmentInteractionListener {

    override fun onContactListFragmentInteraction(item: Contacts.Record) {
        val contactFragment = newInstance(item, PHOTO_URL)
        main_toolbar.title = "Information"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportFragmentManager?.beginTransaction()
                ?.replace(R.id.contacts_container,
                               contactFragment,
                               "ContactFragmentTAG")
                ?.addToBackStack(null)
                ?.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(main_toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(false)
        supportActionBar!!.setDisplayShowHomeEnabled(false)

        val contactListFragment = ContactListFragment()
        supportFragmentManager.beginTransaction()
                              .add(R.id.contacts_container,
                                        contactListFragment,
                                        "ContactListFragmentTAG")
                              .commit()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        main_toolbar.title = "Contacts"
//        supportActionBar!!.setDisplayHomeAsUpEnabled(false)
//        supportActionBar!!.setDisplayShowHomeEnabled(false)
//
//        val contactListFragment = ContactListFragment()
//        supportFragmentManager.beginTransaction()
//                .replace(R.id.contacts_container,
//                        contactListFragment,
//                        "ContactListFragmentTAG")
//                .commit()
        return true
    }
}
