package yayang.setiyawan.navigation_bottom.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import yayang.setiyawan.navigation_bottom.R
import yayang.setiyawan.navigation_bottom.model.Coment

class EmailAdapter(val context: Context):RecyclerView.Adapter<EmailAdapter.EmailViewHolder>() {
    private val email:ArrayList<Coment> = arrayListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailViewHolder {
        return EmailViewHolder(LayoutInflater.from(context).inflate(R.layout.item_coment,parent,false))
    }
    override fun getItemCount(): Int {
        return email.size
    }
    override fun onBindViewHolder(holder: EmailViewHolder, position: Int) {
        holder.BindModel(email[position])
    }
    fun setEmail(data:ArrayList<Coment>){
        email.clear()
        email.addAll(data)
        notifyDataSetChanged()
    }

    inner class EmailViewHolder(item: View):RecyclerView.ViewHolder(item){
        val tvEmail:TextView = item.findViewById(R.id.tv_email)
        fun BindModel(b:Coment){
            tvEmail.text=b.email
        }
    }
}