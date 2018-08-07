package com.example.test

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.contact_fragment.*
import pojo.Contacts


class ContactFragment: Fragment() {

   var name: String? = null
   var phone: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        name = if (arguments != null) {
            this.arguments?.getString(contactName)
        } else "null"

        phone = if (arguments != null) {
            this.arguments?.getString(contactPhone)
        } else "null"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.contact_fragment, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            txtNameContact.text = name
            txtPhoneContact.text = phone
    }

    companion object {

        private const val contactName = "name"
        private const val contactPhone = "phone"

        fun newInstance(record: Contacts.Record): ContactFragment {
            val fragment = ContactFragment()
            val args = Bundle()
            val name: String = record.attributes.name
            val phone: String = record.attributes.phone
            args.putString(contactName, name)
            args.putString(contactPhone, phone)
            fragment.arguments = args
            return fragment
        }
    }
}
