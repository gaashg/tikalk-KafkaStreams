package com.tikalk.kafkastreams.common.model

class Player(id: String, creationDate: Long, val firstName: String, val age: Int, val lastName: String,
             val country: String) extends BaseEntity(id, creationDate, 1)


