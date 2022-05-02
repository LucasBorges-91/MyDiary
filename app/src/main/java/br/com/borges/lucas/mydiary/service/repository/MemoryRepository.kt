package br.com.borges.lucas.mydiary.service.repository

import android.content.ContentValues
import android.content.Context
import br.com.borges.lucas.mydiary.service.constants.DataBaseConstants
import br.com.borges.lucas.mydiary.service.model.MemoryModel
import java.lang.Exception

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

  fun save( memory: MemoryModel ) : Boolean {
    return try {
      val db = mMemoryDataBaseHelper.writableDatabase

      val values = ContentValues()
      values.put( DataBaseConstants.MEMORY.COLUMNS.TITLE, memory.title )
      values.put( DataBaseConstants.MEMORY.COLUMNS.MEMORY, memory.textMemory )
      values.put( DataBaseConstants.MEMORY.COLUMNS.DATE, memory.date )

      db.insert( DataBaseConstants.MEMORY.TABLE_NAME, null, values )
      true
    } catch ( e: Exception ) {
      false
    }
  }

  fun update( memory: MemoryModel ): Boolean {
    return try {
      val db = mMemoryDataBaseHelper.writableDatabase

      val values = ContentValues()
      values.put( DataBaseConstants.MEMORY.COLUMNS.TITLE, memory.title )
      values.put( DataBaseConstants.MEMORY.COLUMNS.MEMORY, memory.textMemory )
      values.put( DataBaseConstants.MEMORY.COLUMNS.DATE, memory.date )

      val selection = DataBaseConstants.MEMORY.COLUMNS.ID + " = ?"
      val args = arrayOf(memory.id.toString())

      db.update( DataBaseConstants.MEMORY.TABLE_NAME, values, selection, args )
      true
    } catch ( e: Exception ) {
      false
    }
  }

  fun delete( id: Int ): Boolean {
    return try {
      val db = mMemoryDataBaseHelper.writableDatabase

      val selection = DataBaseConstants.MEMORY.COLUMNS.ID + " = ?"
      val args = arrayOf( id.toString() )

      db.delete( DataBaseConstants.MEMORY.TABLE_NAME, selection, args )
      true
    } catch ( e: Exception ) {
      false
    }
  }
}