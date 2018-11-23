package com.tikalk.kafkastreams.common.model

class BaseEntity(var id : String, var creationDate: Long, var version : Int) {
  override def toString: String = s"BaseEvent [id=$id, creationDate=$creationDate, version=$version]"
}
