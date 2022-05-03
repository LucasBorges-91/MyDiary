package br.com.borges.lucas.mydiary.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.borges.lucas.mydiary.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

  private lateinit var binding: ActivityLoginBinding


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityLoginBinding.inflate(layoutInflater)
    setContentView(binding.root)


    setListeners()
  }

  fun setListeners() {
    binding.btOpen.setOnClickListener {
      startActivity( Intent( this, AllMemoriesActivity::class.java ) )
    }
  }
}