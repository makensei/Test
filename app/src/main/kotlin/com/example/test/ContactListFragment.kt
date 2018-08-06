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
import com.google.gson.GsonBuilder
import interfaces.ContactListAPI
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.internal.schedulers.IoScheduler
import pojo.Contacts
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ContactListFragment: Fragment() {

    private var listener: OnContactListFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                                                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                                                .baseUrl("https://just-test-c0d23.firebaseio.com").build()
        val dataApi = retrofit.create(ContactListAPI::class.java)
        val response = dataApi.getData()
        response.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(IoScheduler())
                .subscribe {
                    if (view is RecyclerView) {
                        (view as RecyclerView).layoutManager = LinearLayoutManager(context)
                        val records: List<Contacts.Record> = it.data.toList()
                        (view as RecyclerView).adapter = ContactListAdapter(records, listener)
                    }
                }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.contact_list_fragment, container, false)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnContactListFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " OnContactListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnContactListFragmentInteractionListener {
        fun onContactListFragmentInteraction(item: Contacts.Record)
    }
}
