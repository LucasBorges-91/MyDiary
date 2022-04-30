package br.com.borges.lucas.mydiary.service.repository

import android.content.Context
import br.com.borges.lucas.mydiary.service.model.MemoryModel

class MemoryRepository private constructor( context: Context ) {

  private var mMemoryDataBaseHelper: MemoryDataBaseHelper = MemoryDataBaseHelper( context )

  companion object {
    private lateinit var repository: MemoryRepository

    fun getInstance( context: Context ) : MemoryRepository {
      if ( !::repository.isInitialized ) {
        repository = MemoryRepository( context )
      }
      return repository
    }
  }

  fun getAll(): List<MemoryModel> {
    val list: MutableList<MemoryModel> = ArrayList()
    return list
  }

  fun save( memory: MemoryModel ) {
  }

  fun update( memory: MemoryModel ) {
  }

  fun delete( memory: MemoryModel ) {
  }
}