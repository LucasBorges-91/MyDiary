package br.com.borges.lucas.mydiary.service.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Memory")
class MemoryModel {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "id")
  val id: Int = 0

  @ColumnInfo(name = "title")
  val title: String = ""

  @ColumnInfo(name = "textMemory")
  val textMemory: String = ""

  @ColumnInfo(name = "date")
  val date: String = ""
}