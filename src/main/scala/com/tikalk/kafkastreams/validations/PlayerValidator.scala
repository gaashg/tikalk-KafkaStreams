package com.tikalk.kafkastreams.validations

import com.tikalk.kafkastreams.model.Player
import com.tikalk.kafkastreams.traits.Validator
import org.springframework.stereotype.Component

@Component
class PlayerValidator extends Validator[Player] {
  override def validate(player : Player): Boolean = {
    val validated = player != null && player.id != null
    println("is " + player + "valid? " + validated)
    validated
  }
}
