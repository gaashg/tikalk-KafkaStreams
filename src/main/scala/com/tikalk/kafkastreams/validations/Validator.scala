package com.tikalk.kafkastreams.validations

import com.tikalk.kafkastreams.model.Player

object Validator {
  def validateNewPlayer (newPlayer : Player) : Boolean = {
    newPlayer != null && newPlayer.id != null
  }

}
