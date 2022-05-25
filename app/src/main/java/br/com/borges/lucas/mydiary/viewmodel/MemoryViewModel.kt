package br.com.borges.lucas.mydiary.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.borges.lucas.mydiary.service.model.MemoryModel
import br.com.borges.lucas.mydiary.service.repository.MemoryRepository

class MemoryViewModel( application: Application ) : AndroidViewModel( application ) {

  private val mContext = application.applicationContext
  private val mMemoryRepository: MemoryRepository = MemoryRepository.getInstance( mContext )

  private var mSaveMemory = MutableLiveData<Boolean>()
  val saveMemory: LiveData<Boolean> = mSaveMemory

  private var mMemory = MutableLiveData<MemoryModel>()
  val memory: LiveData<MemoryModel> = mMemory

  fun save( id: Int, title: String, memory: String, date: String ) {
    val memory = MemoryModel( id, title, memory, date )

    if ( id == 0 ) {
      mSaveMemory.value = mMemoryRepository.save( memory )
    } else {
      mSaveMemory.value = mMemoryRepository.update(memory)
    }
  }

  fun load( id: Int ) {
    mMemory.value= mMemoryRepository.get(id)
  }
}