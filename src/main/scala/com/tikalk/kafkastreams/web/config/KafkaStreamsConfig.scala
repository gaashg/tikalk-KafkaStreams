package com.tikalk.kafkastreams.web.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.tikalk.kafkastreams.common.model.{Game, Player}
import com.tikalk.kafkastreams.common.utils.JsonSerializer
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter


@SpringBootApplication
@ComponentScan(Array("com.tikalk.kafkastreams"))
class KafkaStreamsConfig {

  import org.springframework.beans.factory.annotation.Value

  @Value("${kafka.bootstrap.servers}") private val bootstrapServers : String = null

  import org.apache.kafka.clients.producer.ProducerConfig
  import org.springframework.context.annotation.Bean

  @Bean def producerConfig: Map[String, AnyRef] = {
    Map(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG -> bootstrapServers,
      ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG -> classOf[StringSerializer],
      ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG -> classOf[JsonSerializer],
      ProducerConfig.MAX_BLOCK_MS_CONFIG -> Int.box(5000)
    )
  }

  @Bean def objectMapper(): ObjectMapper = {
    val objectMapper = new ObjectMapper()
    objectMapper.registerModule(DefaultScalaModule)
    import com.fasterxml.jackson.databind.DeserializationFeature
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    objectMapper
  }


  import scala.collection.JavaConverters._

  @Bean
  def playerProducerFactory = new KafkaProducer[String, Player](producerConfig.asJava)

  @Bean
  def gameProducerFactory = new KafkaProducer[String, Game](producerConfig.asJava)

  @Bean
  def mappingJackson2HttpMessageConverter: MappingJackson2HttpMessageConverter = {
    val mapping = new MappingJackson2HttpMessageConverter
    mapping.setObjectMapper(objectMapper())
    mapping
  }


}
