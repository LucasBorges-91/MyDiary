package br.com.borges.lucas.mydiary.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.borges.lucas.mydiary.databinding.ActivityAllMemoriesBinding

class AllMemoriesActivity : AppCompatActivity() {

  private lateinit var binding: ActivityAllMemoriesBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityAllMemoriesBinding.inflate(layoutInflater)

    setContentView(binding.root)

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
}