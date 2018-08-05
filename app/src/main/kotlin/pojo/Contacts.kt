package pojo

object Contacts {
    data class Data(val data: List<Record>)
    data class Record(val attributes: Attributes, val id: String, val type: String)
    data class Attributes(val name: String, val phone: String)
}