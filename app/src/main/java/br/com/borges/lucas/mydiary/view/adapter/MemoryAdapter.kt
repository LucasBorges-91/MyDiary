package br.com.borges.lucas.mydiary.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.borges.lucas.mydiary.R
import br.com.borges.lucas.mydiary.service.model.MemoryModel
import br.com.borges.lucas.mydiary.view.listener.MemoryListener
import br.com.borges.lucas.mydiary.view.viewholder.MemoryViewHolder

class MemoryAdapter : RecyclerView.Adapter<MemoryViewHolder>() {

  private var mMemoryList: List<MemoryModel> = arrayListOf()
  private lateinit var mListener: MemoryListener

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoryViewHolder {
    val item = LayoutInflater.from(parent.context).inflate(R.layout.row_memory, parent, false)
    return MemoryViewHolder(item, mListener)
  }

  override fun onBindViewHolder(holder: MemoryViewHolder, position: Int) {
    holder.bind(mMemoryList[position])
  }

  override fun getItemCount(): Int {
    return mMemoryList.count()
  }

  fun updateMemories(list: List<MemoryModel>) {
    mMemoryList = list
    notifyDataSetChanged()
  }

  fun attachListener( listener: MemoryListener ) {
    mListener = listener
  }

}