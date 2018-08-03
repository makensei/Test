package com.example.test

import adapters.ContactListAdapter
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pojo.Contacts

class ContactListFragment: Fragment() {

    private var listener: OnContactListFragmentInteractionListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.contact_list_fragment, container, false)
        if (view is RecyclerView) {
            view.layoutManager = LinearLayoutManager(context)
            view.adapter = ContactListAdapter(Contacts.ITEMS, listener)
        }


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnContactListFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    //    private fun onClickSend(view: View){
//       val name: String =  editNameContactList.text.toString()
//       val age: String = editAgeContactList.text.toString()
//        val contactFragment = ContactFragment.newInstance(name, age)
//        activity?.supportFragmentManager?.beginTransaction()
//                                        ?.replace(R.id.contacts_container, contactFragment)
//                                        ?.commit()
//    }

    interface OnContactListFragmentInteractionListener {
        fun onContactListFragmentInteraction(item: Contacts.Contact?)
    }

//    companion object {
//        private const val COLUMN_COUNT = "column-count"
//
//        fun newInstance(columnCount: Int): ContactListFragment {
//            val fragment = ContactListFragment()
//            val args = Bundle()
//            args.putInt(COLUMN_COUNT, columnCount)
//            fragment.arguments = args
//            return fragment
//        }
//    }
}