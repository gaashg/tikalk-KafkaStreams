package com.tikalk.kafkastreams.web.validations

import com.tikalk.kafkastreams.common.model.Player
import com.tikalk.kafkastreams.web.traits.Validator
import org.apache.commons.lang3.StringUtils
import org.springframework.stereotype.Component

@Component ("playerValidator")
class PlayerValidator extends Validator[Player] {
  override def validate(newPlayer: Player): Boolean = {
    val validated = newPlayer != null && !StringUtils.isBlank(newPlayer.firstName) && !StringUtils.isBlank(newPlayer.country) && !StringUtils.isBlank(newPlayer.lastName) && newPlayer.age > 18
    println(s"is $newPlayer valid? $validated")
    validated
  }
}
