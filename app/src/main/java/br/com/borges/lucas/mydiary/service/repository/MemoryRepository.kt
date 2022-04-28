package br.com.borges.lucas.mydiary.service.repository

import br.com.borges.lucas.mydiary.service.model.MemoryModel

class MemoryRepository {

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