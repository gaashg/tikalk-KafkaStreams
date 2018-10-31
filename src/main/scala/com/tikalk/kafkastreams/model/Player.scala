package com.tikalk.kafkastreams.model

import javax.validation.constraints.{NotEmpty, NotNull}

case class Player(@NotEmpty var id: String, @NotEmpty var username: String, @NotNull var person: Person) extends Person (person)