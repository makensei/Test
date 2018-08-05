package interfaces

import io.reactivex.Observable
import pojo.Contacts.Data
import retrofit2.http.GET


interface ContactListAPI {
    @GET ("contacts.json")
    fun getData(): Observable<List<Data>>

}