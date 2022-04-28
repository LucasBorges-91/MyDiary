package br.com.borges.lucas.mydiary.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.borges.lucas.mydiary.databinding.ActivityNewMemoryBinding
import br.com.borges.lucas.mydiary.viewmodel.MemoryViewModel
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*

class NewMemoryActivity : AppCompatActivity() {

  private lateinit var binding: ActivityNewMemoryBinding
  private lateinit var mViewModel: MemoryViewModel

  private val sdf = SimpleDateFormat("dd/MM/yyyy")

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityNewMemoryBinding.inflate(layoutInflater)
    setContentView(binding.root)

    mViewModel = ViewModelProvider(this).get(MemoryViewModel::class.java)

    setListeners()
    observe()
  }

  private fun setListeners() {
    val date = Date()
    val dateFormat: String = sdf.format(date)
    binding.tvDate.text = dateFormat

    binding.btSave.setOnClickListener {
      val title = binding.etMemoryTitle.text.toString()
      val memory = binding.etTextMemory.text.toString()

      mViewModel.save( title, memory, dateFormat )
    }
  }

  private fun observe() {
    mViewModel.saveMemory.observe(this, Observer {
      if ( it ) {
        Toast.makeText(applicationContext, "Sucess", Toast.LENGTH_SHORT).show()
      } else {
        Toast.makeText(applicationContext, "Failed", Toast.LENGTH_SHORT).show()
      }
    })
  }

}