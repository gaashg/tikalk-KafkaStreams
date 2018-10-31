package com.tikalk.kafkastreams.validations

import com.tikalk.kafkastreams.model.{NewPlayer, Player}
import com.tikalk.kafkastreams.traits.Validator
import org.apache.commons.lang3.StringUtils
import org.springframework.stereotype.Component

@Component ("newPlayerValidator")
class NewPlayerValidator extends Validator[NewPlayer] {
  override def validate(newPlayer: NewPlayer): Boolean = {
    val validated = newPlayer != null && !StringUtils.isBlank(newPlayer.firstName) && !StringUtils.isBlank(newPlayer.lastName)
    println("is " + newPlayer + " valid? " + validated)
    validated
  }
}
