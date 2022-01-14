package jota.kalebe.appmemedemo.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import jota.kalebe.appmemedemo.R
import jota.kalebe.appmemedemo.model.Meme
import kotlinx.android.synthetic.main.item_meme.view.*

class MemeListAdapter (
    private val items: List<Meme>,
        ):RecyclerView.Adapter<MemeListAdapter.MemeHolder>(){



    class MemeHolder(rootView: View):RecyclerView.ViewHolder(rootView) {
        val imgCover:ImageView = rootView.imgCover
        val title:TextView = rootView.title
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemeHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_meme, parent, false)

        return MemeHolder(layout)
    }

    override fun onBindViewHolder(holder: MemeHolder, position: Int) {
        val meme = items[position]
        if(meme.url != null){
            Picasso.get().load(meme.url).into(
                holder.imgCover
            );
        }else {
            holder.imgCover.setImageResource(R.drawable.ic_broken)
        }
        holder.title.text = meme.name
    }

    override fun getItemCount(): Int = items.size

}