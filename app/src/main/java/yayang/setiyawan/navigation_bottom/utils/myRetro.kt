package yayang.setiyawan.navigation_bottom.utils

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class myRetro {
    fun getMyRetro():Retrofit{
        val gson = GsonBuilder().setLenient().create()
        return Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
    }
}