package com.tikalk.kafkastreams.common.model

class Question (id: String, creationDate: Long, val quoteId: String, val options: Array[String], val answer: Int) extends BaseEntity (id, creationDate, 1){

}
