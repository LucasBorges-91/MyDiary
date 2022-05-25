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

  fun save( title: String, memory: String, date: String ) {
    val memory = MemoryModel( title = title, textMemory = memory, date = date )
    mSaveMemory.value = mMemoryRepository.save( memory )
  }
}