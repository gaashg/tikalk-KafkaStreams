package com.tikalk.kafkastreams.common.config

import java.util.Properties

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.tikalk.kafkastreams.common.model.{BaseEntity, Game, Player}
import com.tikalk.kafkastreams.common.serdes.JsonSerializer
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.{ComponentScan, Scope}
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter


@SpringBootApplication
@ComponentScan(Array("com.tikalk.kafkastreams"))
class KafkaStreamsConfig {

  import org.springframework.beans.factory.annotation.Value

  @Value("${kafka.bootstrap.servers}") private val bootstrapServers: String = null

  import org.apache.kafka.clients.producer.ProducerConfig
  import org.springframework.context.annotation.Bean

  @Bean
  @Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
  def producerConfig: Properties = {
    val prop = new Properties()
    prop.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers)
    prop.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, classOf[StringSerializer])
    prop.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, classOf[JsonSerializer[BaseEntity]])
    prop.put(ProducerConfig.MAX_BLOCK_MS_CONFIG, Int.box(5000))
    prop.put("application.id", "abc")

    prop
  }

  @Bean def objectMapper(): ObjectMapper = {
    val objectMapper = new ObjectMapper()
    objectMapper.registerModule(DefaultScalaModule)
    import com.fasterxml.jackson.databind.DeserializationFeature
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    objectMapper
  }

  @Bean
  def playerProducerFactory = new KafkaProducer[String, Player](producerConfig)

  @Bean
  def gameProducerFactory = new KafkaProducer[String, Game](producerConfig)

  @Bean
  def mappingJackson2HttpMessageConverter: MappingJackson2HttpMessageConverter = {
    val mapping = new MappingJackson2HttpMessageConverter
    mapping.setObjectMapper(objectMapper())
    mapping
  }


}
