package com.tikalk.kafkastreams.common.model

class Player(id: String, creationDate: Long, val name: String, val age: Int) extends BaseEntity (id, creationDate, 1){
}

object Player{
  val TOPIC_NAME = "Players"
}

