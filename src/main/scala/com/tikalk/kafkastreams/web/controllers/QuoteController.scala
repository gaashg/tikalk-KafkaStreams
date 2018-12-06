package com.tikalk.kafkastreams.web.controllers

import com.tikalk.kafkastreams.common.model.{ActionResult, Quote}
import com.tikalk.kafkastreams.web.services.QuoteService
import javax.annotation.Resource
import org.slf4j.{Logger, LoggerFactory}
import org.springframework.web.bind.annotation.{PostMapping, RequestBody, ResponseBody, RestController}

@RestController
class QuoteController {

  private val logger : Logger = LoggerFactory.getLogger(classOf[QuoteController])

  @Resource
  private val quoteService : QuoteService = null

  @PostMapping(value = Array("/quote"))
  @ResponseBody
  def addQuote(@RequestBody quote: Quote): ActionResult = {
    logger.info("Received quote: {}", quote)
    quoteService.addNewQuote(quote)
  }

}
