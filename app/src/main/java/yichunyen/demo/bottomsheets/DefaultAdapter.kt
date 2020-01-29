package yichunyen.demo.bottomsheets

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class DefaultAdapter(private val listCount: Int = 0) : RecyclerView.Adapter<DefaultAdapter.DefaultViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DefaultViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler_view, parent, false)
        return DefaultViewHolder(view)
    }

    override fun getItemCount(): Int = listCount

    override fun onBindViewHolder(holder: DefaultViewHolder, position: Int) {
    }

    inner class DefaultViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}