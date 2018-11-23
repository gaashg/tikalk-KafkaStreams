package com.tikalk.kafkastreams.web.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.{Bean, ComponentScan}
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter


@SpringBootApplication
@ComponentScan (Array("com.tikalk.kafkastreams"))
class KafkaStreamsConfig {
  @Bean
  def mappingJackson2HttpMessageConverter: MappingJackson2HttpMessageConverter = {
    val mapping = new MappingJackson2HttpMessageConverter
    val objectMapper = new ObjectMapper()
    objectMapper.registerModule(DefaultScalaModule)
    import com.fasterxml.jackson.databind.DeserializationFeature
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    mapping.setObjectMapper(objectMapper)
    mapping
  }
}
