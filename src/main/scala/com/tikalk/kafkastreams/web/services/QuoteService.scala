package com.tikalk.kafkastreams.web.services

import com.tikalk.kafkastreams.common.kafka.KafkaProducerService
import com.tikalk.kafkastreams.web.enums.ActionType
import com.tikalk.kafkastreams.common.model.{ActionResult, Quote}
import com.tikalk.kafkastreams.common.utils.UUIDGenerator
import com.tikalk.kafkastreams.web.traits.Validator
import javax.annotation.Resource
import org.slf4j.{Logger, LoggerFactory}
import org.springframework.stereotype.Component

@Component("quoteService")
class QuoteService {

  private val logger: Logger = LoggerFactory.getLogger(classOf[QuoteService])
  @Resource
  private val quoteValidator : Validator [Quote] = null

  @Resource
  private val kafkaService : KafkaProducerService[String, Quote] = null

  def addNewQuote(line: String, character: String, season: String, episode: String): ActionResult = {
    val quote = new Quote(UUIDGenerator.generateUUID, System.currentTimeMillis(), line, character, season, episode)
    addNewQuote(quote)
  }

  def addNewQuote(quote: Quote): ActionResult = {
    val valid = quoteValidator.validate(quote)

    if (valid) {
      quote.id = UUIDGenerator.generateUUID
      quote.creationDate = System.currentTimeMillis()

      kafkaService.sendMessage(quote.id, quote)
      ActionResult(true, ActionType.ADD_NEW_QUOTE, null, quote)
    }
    else
      ActionResult(false, ActionType.ADD_NEW_QUOTE, "Quote not valid", quote)
  }
}
