package com.tikalk.kafkastreams.model

class BaseEvent (var id : String, var creationDate: Long) {
  override def toString: String = s"BaseEvent [id=$id, creationDate=$creationDate]"
}
