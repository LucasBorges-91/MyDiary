package br.com.borges.lucas.mydiary.service.repository

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import br.com.borges.lucas.mydiary.service.constants.DataBaseConstants

class MemoryDataBaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
  override fun onCreate(db: SQLiteDatabase) {
    db.execSQL(CREATE_TABLE_MEMORY)
  }

  override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    TODO("Not yet implemented")
  }

  companion object {
    private const val DATABASE_VERSION = 1
    private const val DATABASE_NAME = "Memories.db"

    private const val CREATE_TABLE_MEMORY =
      ("create table " + DataBaseConstants.MEMORY.TABLE_NAME + " ("
          + DataBaseConstants.MEMORY.COLUMNS.ID + " integer primary key autoincrement, "
          + DataBaseConstants.MEMORY.COLUMNS.TITLE + " text, "
          + DataBaseConstants.MEMORY.COLUMNS.MEMORY + " text, "
          + DataBaseConstants.MEMORY.COLUMNS.DATE + " text);")
  }
}