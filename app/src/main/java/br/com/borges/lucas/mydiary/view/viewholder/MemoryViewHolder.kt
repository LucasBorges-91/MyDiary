package br.com.borges.lucas.mydiary.view.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.borges.lucas.mydiary.R
import br.com.borges.lucas.mydiary.service.model.MemoryModel

class MemoryViewHolder( itemView : View ) : RecyclerView.ViewHolder( itemView ) {

  fun bind( memory: MemoryModel ) {
    val textTitle = itemView.findViewById<TextView>( R.id.title_memory_list)
    textTitle.text = memory.title
  }
}