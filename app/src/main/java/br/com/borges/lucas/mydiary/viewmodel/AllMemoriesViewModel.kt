package br.com.borges.lucas.mydiary.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.borges.lucas.mydiary.service.model.MemoryModel
import br.com.borges.lucas.mydiary.service.repository.MemoryRepository

class AllMemoriesViewModel( application: Application ) : AndroidViewModel( application ) {

  private val mMemoriesRepository = MemoryRepository( application.applicationContext )

  private val mMemoryList = MutableLiveData<List<MemoryModel>>()
  val memoryList: LiveData<List<MemoryModel>> = mMemoryList

  fun load() {
    mMemoryList.value = mMemoriesRepository.getAll()
  }

  fun delete(id: Int) {
    mMemoriesRepository.delete( id )
  }
}