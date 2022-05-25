package br.com.borges.lucas.mydiary.view.viewholder

import android.app.AlertDialog
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.borges.lucas.mydiary.R
import br.com.borges.lucas.mydiary.service.model.MemoryModel
import br.com.borges.lucas.mydiary.view.listener.MemoryListener

class MemoryViewHolder( itemView : View, val listener: MemoryListener ) : RecyclerView.ViewHolder( itemView ) {

  fun bind( memory: MemoryModel ) {
    val textTitle = itemView.findViewById<TextView>( R.id.title_memory_list)
    textTitle.text = memory.title

    textTitle.setOnClickListener {
      listener.onClick(memory.id)
    }

    textTitle.setOnLongClickListener {
      AlertDialog.Builder(itemView.context)
        .setTitle("Delete Memory")
        .setMessage("You really wish delete the memory?")
        .setPositiveButton("Delete") { dialog, wich ->
          listener.onDelete(memory.id)
        }
        .setNeutralButton( "Cancel", null )
        .show()
      true
    }
  }
}