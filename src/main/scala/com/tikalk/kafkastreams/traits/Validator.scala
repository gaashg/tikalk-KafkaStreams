package com.tikalk.kafkastreams.traits

trait Validator [T] {
  def validate (value : T) : Boolean
}
