package com.tikalk.kafkastreams.controllers

import com.tikalk.kafkastreams.enums.ActionType
import com.tikalk.kafkastreams.model.{ActionResult, Person, Quote}
import javax.validation.Valid
import javax.validation.constraints.NotNull
import org.springframework.web.bind.annotation.{PostMapping, RequestBody, ResponseBody, RestController}

@RestController
class QuoteController {

  @PostMapping(value = Array("/quote"))
  @ResponseBody
  def addQuote(@RequestBody @Valid quote: Quote): ActionResult = {
    println(s"Input: $quote")
    new ActionResult(true, ActionType.ADD_NEW_QUOTE, null, AnyRef)
  }

}
