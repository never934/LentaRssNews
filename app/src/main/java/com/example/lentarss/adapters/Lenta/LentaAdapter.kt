package com.example.lentarss.adapters.Lenta

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lentarss.R
import com.example.lentarss.db.LentaDBobject
import com.example.lentarss.rss.Lenta.RssObject.ItemBody
import kotlinx.android.synthetic.main.card_item_lenta.view.*

class LentaAdapter(private val newsArray : List<LentaDBobject>) : RecyclerView.Adapter<LentaAdapter.LentaHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LentaHolder {
        val v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_lenta, parent, false)
        val vh = LentaHolder(v)
        return vh
    }

    override fun getItemCount() = newsArray.size

    override fun onBindViewHolder(holder: LentaHolder, position: Int) {
        holder.itemView.Title.setText(newsArray.get(position).title)
    }

    class LentaHolder(v: View) : RecyclerView.ViewHolder(v)
}