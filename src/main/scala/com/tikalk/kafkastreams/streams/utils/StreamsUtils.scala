package com.tikalk.kafkastreams.streams.utils

import java.util.Properties

import org.apache.kafka.streams.StreamsConfig.{APPLICATION_ID_CONFIG, BOOTSTRAP_SERVERS_CONFIG}

object StreamsUtils {

  def initProperties (): Properties ={
    val streamsConfig = new Properties()
    streamsConfig.put(APPLICATION_ID_CONFIG, "whos-line-is-it")
    streamsConfig.put(BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
    streamsConfig
  }

}
