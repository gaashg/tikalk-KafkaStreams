package com.tikalk.kafkastreams.validations

import com.tikalk.kafkastreams.model.{Person, Player}
import com.tikalk.kafkastreams.traits.Validator
import org.apache.commons.lang3.StringUtils
import org.springframework.stereotype.Component

@Component ("newPlayerValidator")
class NewPlayerValidator extends Validator[Person] {
  override def validate(newPlayer: Person): Boolean = {
    val validated = newPlayer != null && !StringUtils.isBlank(newPlayer.firstName) && !StringUtils.isBlank(newPlayer.lastName)
    println("is " + newPlayer + " valid? " + validated)
    validated
  }
}
