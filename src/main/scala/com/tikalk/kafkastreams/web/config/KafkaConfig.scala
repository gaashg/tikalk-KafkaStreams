package com.tikalk.kafkastreams.web.config

import com.tikalk.kafkastreams.common.kafka.{KafkaConstants, KafkaProducerService}
import com.tikalk.kafkastreams.common.model.Quote
import org.springframework.context.annotation.{Bean, Configuration}

@Configuration
class KafkaConfig {
  @Bean
  def quoteKafkaProducer () : KafkaProducerService [String, Quote] = {
    new KafkaProducerService[String, Quote](KafkaConstants.QUOTES_TOPIC_NAME)
  }
}
