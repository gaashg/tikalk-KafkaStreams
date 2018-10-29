package com.tikalk.kafkastreams

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter


@SpringBootApplication
class KafkaStreamsConfig extends WebMvcConfigurerAdapter {
    override def configureMessageConverters(converters: java.util.List[HttpMessageConverter[_]]) {
        def mapper: ObjectMapper = createObjectMapper
        mapper.registerModule(new DefaultScalaModule)
        def converter = createJacksonHttpMessageConverter
        converter.setObjectMapper(mapper)

        converters.add(converter)
    }

    @Bean
    def createJacksonHttpMessageConverter = new MappingJackson2HttpMessageConverter

    @Bean
    def createObjectMapper = new ObjectMapper
}


object KafkaStreamsMain extends App {
    SpringApplication.run(classOf[KafkaStreamsConfig])
}
