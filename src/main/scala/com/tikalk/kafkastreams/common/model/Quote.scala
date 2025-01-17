package com.tikalk.kafkastreams.common.model

class Quote(id: String, creationDate: Long, var line: String, var character: String, var season: String, var episode: String) extends BaseEntity (id, creationDate, 1){
  override def toString: String = s"Quote [line=$line, character=$character, season=$season, episode=$episode, " + super.toString + "]"
}
