package yayang.setiyawan.navigation_bottom.service

import retrofit2.Call
import retrofit2.http.GET
import yayang.setiyawan.navigation_bottom.model.Coment

interface ComentApi {
    @GET("comments")
    fun getComments():Call<ArrayList<Coment>>
}