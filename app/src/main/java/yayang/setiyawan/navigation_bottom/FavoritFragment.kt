package yayang.setiyawan.navigation_bottom

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.fragment_favorit.*
import okhttp3.*
import yayang.setiyawan.navigation_bottom.adapter.BlogAdapter
import yayang.setiyawan.navigation_bottom.model.placeholder
import java.io.IOException

class FavoritFragment : Fragment() {
    lateinit var blogAdapter: BlogAdapter
    var lm = LinearLayoutManager(activity)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_favorit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
        initView()
    }

    fun initView(){
        rv_blog.layoutManager=lm
        blogAdapter = BlogAdapter(activity!!)
        rv_blog.adapter = blogAdapter
    }

    fun getData(){
        val request = Request.Builder()
                .url("https://jsonplaceholder.typicode.com/posts")
                .build()
        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback{
            override fun onFailure(call: Call, e: IOException) {
                e.message?.let { Log.e("gagal", it) }
            }

            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()
                var gson = GsonBuilder().create()
                var result = gson.fromJson(body, Array<placeholder>::class.java).toList()
//                result?.get(0)?.body?.let { Log.e("tess", it) }

                activity?.runOnUiThread {
//                    tvresult.text = result[0].body.toString()
                    blogAdapter.setBlog(result)
                }
            }

        })

    }
}