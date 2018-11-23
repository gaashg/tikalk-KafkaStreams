package com.tikalk.kafkastreams.web.traits

trait Validator [T] {
  def validate (value : T) : Boolean
}
