package com.tikalk.kafkastreams.common.model

import com.tikalk.kafkastreams.web.enums.GameType.GameType

class Game(id: String, creationDate: Long, gameType: GameType, playerIds: Array[String]) extends BaseEntity (id, creationDate, 1){
  override def toString: String = s"GameType: $gameType, playerIds: $playerIds" + super.toString

}

object Game{
  val TOPIC_NAME = "Games"
}
