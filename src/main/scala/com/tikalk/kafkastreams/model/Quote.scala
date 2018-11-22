package com.tikalk.kafkastreams.model

class Quote(id: String, creationDate: Long, version: Int, var line: String, var character: String, var season: String, var episode: String) extends BaseEvent (id, creationDate, version){
  override def toString: String = s"Quote [line=$line, character=$character, season=$season, episode=$episode, " + super.toString + "]"
}
