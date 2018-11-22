package com.tikalk.kafkastreams.model

class BaseEvent (var id : String, var creationDate: Long, var version : Int) {
  override def toString: String = s"BaseEvent [id=$id, creationDate=$creationDate, version=$version]"
}
