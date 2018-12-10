package com.tikalk.kafkastreams.common.model

class Player(id: String, creationDate: Long, val firstName: String, val age: Int, val lastName: String,
             val country: String, var config : PlayerConfig) extends BaseEntity(id, creationDate, 1){
  override def toString: String = s"Player [firstName=$firstName, lastName=$lastName, age=$age, country=$country, super=" + super.toString + s", config=$config"
}

class PlayerConfig (val uniqueQuestions : Boolean, allowTournaments : Boolean, allowDuels : Boolean){
  override def toString: String = s"PlayerConfig [uniqueQuestions=$uniqueQuestions, allowDuels=$allowDuels, allowTournaments=$allowTournaments"
}
