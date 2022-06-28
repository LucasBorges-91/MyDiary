package br.com.borges.lucas.mydiary.service.repository

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import br.com.borges.lucas.mydiary.service.constants.DataBaseConstants
import br.com.borges.lucas.mydiary.service.model.MemoryModel

/*class MemoryDataBaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
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
}*/
@Database( entities = [MemoryModel::class], version = 1 )
abstract class MemoryDataBase() : RoomDatabase() {

  companion object {
    private lateinit var INSTANCE: MemoryDataBase

    fun getDataBase( context: Context ) : MemoryDataBase {
      synchronized(MemoryDataBase::class) {
        if ( !::INSTANCE.isInitialized ) {
          return Room.databaseBuilder( context, MemoryDataBase::class.java, "memorydb")
            .addMigrations()
            .allowMainThreadQueries()
            .build()
        }
      }
      return INSTANCE
    }

    //corresponde ao onUnpgrade
    private val MIGRATION_1_2: Migration = object : Migration(1, 2) {
      override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("DELETE FROM Memory")
      }

    }
  }

}