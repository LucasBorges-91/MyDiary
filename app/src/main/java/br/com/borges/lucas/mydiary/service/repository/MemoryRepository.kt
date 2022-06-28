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

    return try {
      val db = mMemoryDataBaseHelper.readableDatabase

      val projection = arrayOf(
        DataBaseConstants.MEMORY.COLUMNS.ID,
        DataBaseConstants.MEMORY.COLUMNS.TITLE,
        DataBaseConstants.MEMORY.COLUMNS.MEMORY,
        DataBaseConstants.MEMORY.COLUMNS.DATE
      )

      val cursor = db.query(
        DataBaseConstants.MEMORY.TABLE_NAME,
        projection,
        null,
        null,
        null,
        null,
        null
      )

      if ( cursor != null && cursor.count > 0 ) {
        while ( cursor.moveToNext() ) {
          val id = cursor.getInt( cursor.getColumnIndex( DataBaseConstants.MEMORY.COLUMNS.ID ) )
          val title = cursor.getString( cursor.getColumnIndex( DataBaseConstants.MEMORY.COLUMNS.TITLE ) )
          val memoryText = cursor.getString( cursor.getColumnIndex( DataBaseConstants.MEMORY.COLUMNS.MEMORY ) )
          val date = cursor.getString( cursor.getColumnIndex( DataBaseConstants.MEMORY.COLUMNS.DATE ) )

          val memory = MemoryModel( id, title, memoryText, date )
          list.add( memory )
        }
      }
      cursor?.close()
      list
    } catch ( e: Exception ) {
      list
    }
  }

  fun get( id: Int ): MemoryModel? {
    var memory: MemoryModel? = null

    return try {
      val db = mMemoryDataBaseHelper.readableDatabase

      val projection = arrayOf( DataBaseConstants.MEMORY.COLUMNS.TITLE,
        DataBaseConstants.MEMORY.COLUMNS.MEMORY,
        DataBaseConstants.MEMORY.COLUMNS.DATE )

      val selection = DataBaseConstants.MEMORY.COLUMNS.ID + " = ?"
      val args = arrayOf( id.toString() )

      val cursor = db.query(
        DataBaseConstants.MEMORY.TABLE_NAME,
        projection,
        selection,
        args,
        null,
        null,
        null
      )

      if ( cursor != null && cursor.count > 0 ) {
        cursor.moveToFirst()

        val title = cursor.getString( cursor.getColumnIndex( DataBaseConstants.MEMORY.COLUMNS.TITLE ) )
        val memoryText = cursor.getString( cursor.getColumnIndex( DataBaseConstants.MEMORY.COLUMNS.MEMORY ) )
        val date = cursor.getString( cursor.getColumnIndex( DataBaseConstants.MEMORY.COLUMNS.DATE ) )

        memory = MemoryModel( id, title, memoryText, date )
      }
      cursor?.close()
      memory
    } catch ( e: Exception ) {
      memory
    }
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