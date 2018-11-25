package com.tikalk.kafkastreams.common.model

class Player(id: String, creationDate: Long, var name: String, age: Int) extends BaseEntity (id, creationDate, 1){
}

object Player{
  val TOPIC_NAME = "Players"
}

