package br.com.borges.lucas.mydiary.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.borges.lucas.mydiary.service.repository.MemoryRepository
import br.com.borges.lucas.mydiary.service.model.MemoryModel
import java.util.*

class MemoryViewModel : ViewModel() {

  private val mMemoryRepository: MemoryRepository = MemoryRepository()

  private var mSaveMemory = MutableLiveData<Boolean>()
  val saveMemory: LiveData<Boolean> = mSaveMemory

  fun save( title: String, memory: String, date: Date) {
    val memory = MemoryModel( title, memory, date)
    mMemoryRepository.save( memory )
  }
}