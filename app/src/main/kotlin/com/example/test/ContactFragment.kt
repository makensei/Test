package com.example.test

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import kotlinx.android.synthetic.main.contact_fragment.*
import kotlinx.android.synthetic.main.contact_list_fragment.*


class ContactFragment: Fragment() {

   var name: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        name = if (arguments != null) {
            this.arguments?.getString(contactName)
        } else "null"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.contact_fragment, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         txtNameContact.text = name
    }

    companion object {

        private const val contactName = "name"
        fun newInstance(name: String): ContactFragment {
            val fragment = ContactFragment()
            val args = Bundle()
            args.putString(contactName,name)
            fragment.arguments = args
            return fragment
        }
    }
}