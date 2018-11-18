package com.tikalk.kafkastreams.controllers

import javax.annotation.Resource

import com.tikalk.kafkastreams.enums.ActionType
import com.tikalk.kafkastreams.model.{ActionResult, Quote}
import javax.validation.Valid
import javax.validation.constraints.NotNull

import com.tikalk.kafkastreams.services.QuoteService
import org.springframework.web.bind.annotation.{PostMapping, RequestBody, ResponseBody, RestController}

@RestController
class QuoteController {

  @Resource
  private val quoteService : QuoteService = null

  @PostMapping(value = Array("/quote"))
  @ResponseBody
  def addQuote(@RequestBody quote: Quote): ActionResult = {
    println(s"Input: $quote")
    new ActionResult(true, ActionType.ADD_NEW_QUOTE, null, AnyRef)
  }

}
