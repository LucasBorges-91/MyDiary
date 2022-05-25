package br.com.borges.lucas.mydiary.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.borges.lucas.mydiary.R
import br.com.borges.lucas.mydiary.databinding.ActivityAllMemoriesBinding
import br.com.borges.lucas.mydiary.service.constants.MemoryConstants
import br.com.borges.lucas.mydiary.view.adapter.MemoryAdapter
import br.com.borges.lucas.mydiary.view.listener.MemoryListener
import br.com.borges.lucas.mydiary.viewmodel.AllMemoriesViewModel

class AllMemoriesActivity : AppCompatActivity() {

  private lateinit var binding: ActivityAllMemoriesBinding
  private lateinit var allMemoriesViewModel : AllMemoriesViewModel
  private val mAdapter: MemoryAdapter = MemoryAdapter()
  private lateinit var mListener: MemoryListener

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityAllMemoriesBinding.inflate(layoutInflater)

    allMemoriesViewModel = ViewModelProvider( this ).get( AllMemoriesViewModel::class.java )

    setContentView(binding.root)

    val recycler = binding.recyclerAllMemories
    recycler.layoutManager = LinearLayoutManager(applicationContext)
    recycler.adapter = mAdapter

    mListener = object : MemoryListener {
      override fun onClick(id: Int) {
        val intent = Intent( applicationContext, NewMemoryActivity::class.java )

        val bundle = Bundle()
        bundle.putInt( MemoryConstants.MEMORYID, id )
        intent.putExtras(bundle)

        startActivity(intent)
      }

    }

    mAdapter.attachListener(mListener)

    observer()

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

  override fun onResume() {
    super.onResume()
    allMemoriesViewModel.load()
  }
}
