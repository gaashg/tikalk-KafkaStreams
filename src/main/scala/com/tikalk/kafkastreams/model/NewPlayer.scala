package com.tikalk.kafkastreams.model

import javax.validation.constraints.NotBlank


class NewPlayer () {
  @NotBlank
  protected var _firstName : String = null

  @NotBlank
  protected var _lastName : String = null

  def this (firstName : String, lastName : String) {
    this()
    this._firstName = firstName
    this._lastName = lastName
  }

  def firstName = this._firstName
  def firstName_= (firstName : String) : Unit = this._firstName = firstName

  def lastName = this._lastName
  def lastName_= (lastName : String) : Unit = this._lastName = lastName

  override def toString: String = "NewPlayer [firstName=" + _firstName + ", lastName=" + _lastName + "]"
}
