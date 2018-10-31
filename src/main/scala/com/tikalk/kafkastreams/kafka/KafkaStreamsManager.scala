package com.tikalk.kafkastreams.kafka

import com.tikalk.kafkastreams.model.Player
import org.springframework.stereotype.Component

@Component("kafkaStreamsManager")
class KafkaStreamsManager {
  def addNewPlayer (newPlayer : Player) = {
    newPlayer.firstName
  }

}
