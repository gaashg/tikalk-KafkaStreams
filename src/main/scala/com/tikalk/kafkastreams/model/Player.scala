package com.tikalk.kafkastreams.model

case class Player (id: String, name: String) {
  def this() {
    this ("", "")
  }
}
