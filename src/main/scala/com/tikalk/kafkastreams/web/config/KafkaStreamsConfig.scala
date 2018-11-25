package com.tikalk.kafkastreams.web.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import org.apache.kafka.common.serialization.{IntegerSerializer, StringSerializer}
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.kafka.core.{DefaultKafkaProducerFactory, KafkaTemplate}


@SpringBootApplication
@ComponentScan(Array("com.tikalk.kafkastreams"))
class KafkaStreamsConfig {

  import org.springframework.beans.factory.annotation.Value

  @Value("${kafka.bootstrap.servers}") private val bootstrapServers : String = null

  import org.apache.kafka.clients.producer.ProducerConfig
  import org.springframework.context.annotation.Bean

  @Bean def producerConfig: Map[String, AnyRef] = {
    Map(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG -> bootstrapServers,
      ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG -> classOf[IntegerSerializer],
      ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG -> classOf[StringSerializer],
      ProducerConfig.MAX_BLOCK_MS_CONFIG -> Int.box(5000)
    )
  }

  import org.springframework.context.annotation.Bean
  import scala.collection.JavaConverters._

  @Bean def producerFactory = new DefaultKafkaProducerFactory[Integer, String](producerConfig.asJava)

  @Bean def kafkaTemplate = new KafkaTemplate[Integer, String](producerFactory)

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
