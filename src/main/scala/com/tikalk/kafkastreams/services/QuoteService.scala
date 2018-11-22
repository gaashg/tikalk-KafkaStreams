package com.tikalk.kafkastreams.services

import com.tikalk.kafkastreams.enums.ActionType
import com.tikalk.kafkastreams.model.{ActionResult, Quote}
import com.tikalk.kafkastreams.utils.UUIDGenerator
import org.slf4j.{Logger, LoggerFactory}
import org.springframework.stereotype.Component

@Component("quoteService")
class QuoteService {
  private val logger: Logger = LoggerFactory.getLogger(classOf[QuoteService])


  def createNewQuote(line : String, character : String, season : String, episode : String): ActionResult = {
    val quote = new Quote(UUIDGenerator.generateUUID, System.currentTimeMillis(), line, character, season, episode)

    new ActionResult(true, ActionType.ADD_NEW_QUOTE, null, AnyRef)
  }
}
