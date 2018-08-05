package adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.test.ContactListFragment
import com.example.test.R
import kotlinx.android.synthetic.main.contact_list_fragment_item.view.*
import pojo.Contacts

class ContactListAdapter(
        private val contactListValues: List<Contacts.Attributes>,
        private val contactListListener: ContactListFragment.OnContactListFragmentInteractionListener?)
    : RecyclerView.Adapter<ContactListAdapter.ViewHolder>() {

    private val contactListOnClickListener: View.OnClickListener

    init {
        contactListOnClickListener = View.OnClickListener { v ->
            val item = v.tag as Contacts.Attributes
            contactListListener?.onContactListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.contact_list_fragment_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = contactListValues[position]
        holder.contactListNameView.text = item.name
        holder.contactListPhoneView.text = item.phone

        with(holder.contactListView) {
            tag = item
            setOnClickListener(contactListOnClickListener)
        }
    }

    override fun getItemCount(): Int = contactListValues.size

    inner class ViewHolder(val contactListView: View) : RecyclerView.ViewHolder(contactListView) {
        val contactListNameView: TextView = contactListView.contact_list_fragment_item_name
        val contactListPhoneView: TextView = contactListView.contact_list_fragment_item_phone
    }
}