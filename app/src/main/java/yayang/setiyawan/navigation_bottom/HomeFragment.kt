package yayang.setiyawan.navigation_bottom

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import yayang.setiyawan.navigation_bottom.adapter.EmailAdapter
import yayang.setiyawan.navigation_bottom.model.Coment
import yayang.setiyawan.navigation_bottom.service.ComentApi
import yayang.setiyawan.navigation_bottom.utils.myRetro

class HomeFragment : Fragment() {
    lateinit var emailAdapter: EmailAdapter
    var lm = LinearLayoutManager(activity)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
        initview()
    }

    fun initview(){
        rv_email.layoutManager=lm
        emailAdapter = EmailAdapter(activity!!)
        rv_email.adapter=emailAdapter
    }

    fun getData(){
        val myRetro = myRetro().getMyRetro().create(ComentApi::class.java)
        myRetro.getComments().enqueue(object : Callback<ArrayList<Coment>>{
            override fun onFailure(call: Call<ArrayList<Coment>>, t: Throwable) {
                Log.e("failed", t.message.toString())
            }
            override fun onResponse(call: Call<ArrayList<Coment>>, response: Response<ArrayList<Coment>>) {
                val coment = response.body()
//                for (c in coment!!){
//                    c.email?.let { Log.e("hasil", it) }
//                }
                activity?.runOnUiThread{
                    emailAdapter.setEmail(coment as ArrayList<Coment>)
                }
            }
        })
    }
}