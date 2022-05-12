package br.com.borges.lucas.mydiary.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.borges.lucas.mydiary.R
import br.com.borges.lucas.mydiary.databinding.ActivityAllMemoriesBinding
import br.com.borges.lucas.mydiary.view.adapter.MemoryAdapter
import br.com.borges.lucas.mydiary.viewmodel.AllMemoriesViewModel

class AllMemoriesActivity : AppCompatActivity() {

  private lateinit var binding: ActivityAllMemoriesBinding
  private lateinit var allMemoriesViewModel : AllMemoriesViewModel
  private val mAdapter: MemoryAdapter = MemoryAdapter()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityAllMemoriesBinding.inflate(layoutInflater)

    allMemoriesViewModel = ViewModelProvider( this ).get( AllMemoriesViewModel::class.java )

    setContentView(binding.root)

    val recycler = binding.recyclerAllMemories
    recycler.layoutManager = LinearLayoutManager(applicationContext)
    recycler.adapter = mAdapter

    observer()
    allMemoriesViewModel.load()
    setListeners()
  }

  fun setListeners() {
    binding.fabNewMemory.setOnClickListener {
      startActivity( Intent( applicationContext, NewMemoryActivity::class.java ) )
    }
    binding.btLogout.setOnClickListener {
      val intent = Intent( applicationContext, LoginActivity::class.java )
      intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
      startActivity(intent)
    }
  }

  private fun observer() {
    allMemoriesViewModel.memoryList.observe( this, Observer {
      mAdapter.updateMemories(it)
    })
  }
}