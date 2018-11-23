package com.tikalk.kafkastreams.web.validations

import com.tikalk.kafkastreams.common.model.Quote
import com.tikalk.kafkastreams.web.traits.Validator
import org.apache.commons.lang3.StringUtils
import org.springframework.stereotype.Component

@Component ("newQuoteValidator")
class NewQuoteValidator extends Validator[Quote] {
  override def validate(newQuote: Quote): Boolean = {
    val validated = newQuote != null && !StringUtils.isBlank(newQuote.character) && !StringUtils.isBlank(newQuote.episode) && !StringUtils.isBlank(newQuote.line) && !StringUtils.isBlank(newQuote.season)
    println(s"is $newQuote valid? $validated")
    validated
  }
}
