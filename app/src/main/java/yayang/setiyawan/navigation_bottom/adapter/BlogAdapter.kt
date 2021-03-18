package yayang.setiyawan.navigation_bottom.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import yayang.setiyawan.navigation_bottom.R
import yayang.setiyawan.navigation_bottom.model.placeholder

class BlogAdapter(val context: Context):RecyclerView.Adapter<BlogAdapter.BlogViewHolder>() {

    private  val blogs:MutableList<placeholder> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder {
        return BlogViewHolder(LayoutInflater.from(context).inflate(R.layout.item,parent,false))
    }
    override fun getItemCount(): Int {
        return blogs.size
    }
    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {
        holder.BindModel(blogs[position])
    }
    fun setBlog(data: List<placeholder>){
        blogs.clear()
        blogs.addAll(data)
        notifyDataSetChanged()
    }
    inner class BlogViewHolder(item: View):RecyclerView.ViewHolder(item){
        val tvtitle:TextView = item.findViewById(R.id.tv_title)
        val tvdesc:TextView = item.findViewById(R.id.tv_desc)
        fun BindModel(b:placeholder){
            tvtitle.text = b.title
            tvdesc.text = b.body
        }
    }
}