package prototype.todolist.models

import com.google.gson.annotations.SerializedName

data class Weather  (

    var id: Int,
    var main: String,
    var description: String,
    var icon: String,
    var humidity: Int,
    var temp: Double,
    var feels_like: Double,
    var city: String,
    var country: String

)

