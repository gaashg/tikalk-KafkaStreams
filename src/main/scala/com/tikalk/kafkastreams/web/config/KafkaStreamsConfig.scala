package com.tikalk.kafkastreams.web.config

import com.tikalk.kafkastreams.common.utils.GeneralFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.{Bean, ComponentScan}
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter


@SpringBootApplication
@ComponentScan (Array("com.tikalk.kafkastreams"))
class KafkaStreamsConfig {
  @Bean
  def mappingJackson2HttpMessageConverter: MappingJackson2HttpMessageConverter = {
    val mapping = new MappingJackson2HttpMessageConverter
    mapping.setObjectMapper(GeneralFactory.getObjectMapper())
    mapping
  }
}
