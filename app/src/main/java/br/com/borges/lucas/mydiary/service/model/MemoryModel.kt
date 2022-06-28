package br.com.borges.lucas.mydiary.service.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Memory")
class MemoryModel {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "id")
  var id: Int = 0

  @ColumnInfo(name = "title")
  var title: String = ""

  @ColumnInfo(name = "textMemory")
  var textMemory: String = ""

  @ColumnInfo(name = "date")
  var date: String = ""
}