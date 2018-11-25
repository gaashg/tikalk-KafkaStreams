package com.tikalk.kafkastreams.common.model

import com.tikalk.kafkastreams.web.enums.GameType.GameType

case class Game(override var id: String, override var creationDate: Long, gameType: GameType, playerIds: Array[String]) extends BaseEntity (id, creationDate, 1){
}

object Game{
  val TOPIC_NAME = "Gamess"
}
