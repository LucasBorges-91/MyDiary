package br.com.borges.lucas.mydiary.service.repository

import androidx.room.*
import br.com.borges.lucas.mydiary.service.model.MemoryModel

@Dao
interface MemoryDAO {

  @Insert
  fun save( memory: MemoryModel) : Boolean

  @Update
  fun update( memory: MemoryModel ): Boolean

  @Delete
  fun delete( id: Int ): Boolean

  @Query( "SELECT * FROM Memory WHERE id = :id" )
  fun get( id: Int ): MemoryModel

  @Query( "SELECT * FROM Memory")
  fun getAll(): List<MemoryModel>
}