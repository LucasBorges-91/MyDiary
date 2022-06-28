package br.com.borges.lucas.mydiary.service.repository

import androidx.room.*
import br.com.borges.lucas.mydiary.service.model.MemoryModel

@Dao
interface MemoryDAO {

  @Insert
  fun insert(memory: MemoryModel ) : Long

  @Update
  fun update( memory: MemoryModel ): Int

  @Delete
  fun delete( memory: MemoryModel )

  @Query( "SELECT * FROM Memory WHERE id = :id" )
  fun get( id: Int ): MemoryModel

  @Query( "SELECT * FROM Memory")
  fun getAll(): List<MemoryModel>
}