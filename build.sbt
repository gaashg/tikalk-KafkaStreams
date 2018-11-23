name := "KafkaStreams"

version := "0.1"

scalaVersion := "2.12.7"



libraryDependencies += "org.springframework.boot" % "spring-boot-starter-web" % "2.0.6.RELEASE"
libraryDependencies += "com.fasterxml.jackson.module" % "jackson-module-scala_2.12" % "2.9.6"
libraryDependencies += "org.apache.commons" % "commons-lang3" % "3.8.1"
libraryDependencies += "org.apache.kafka" % "kafka-clients" % "2.1.0"
libraryDependencies += "org.apache.kafka" % "kafka-streams" % "2.1.0"
libraryDependencies += {
  sys.props += "packaging.type" -> "jar"
  "org.apache.kafka" %% "kafka-streams-scala" % "2.0.0" withSources()
}