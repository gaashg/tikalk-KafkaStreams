package com.tikalk.kafkastreams.web.services

import com.tikalk.kafkastreams.common.kafka.KafkaProducerService
import com.tikalk.kafkastreams.common.model.{ActionResult, Player, PlayerConfig}
import com.tikalk.kafkastreams.common.utils.UUIDGenerator
import com.tikalk.kafkastreams.web.enums.ActionType
import com.tikalk.kafkastreams.web.validations.PlayerValidator
import javax.annotation.Resource
import org.slf4j.{Logger, LoggerFactory}
import org.springframework.stereotype.Component

@Component("playerService")
class PlayerService {
  private val _logger: Logger = LoggerFactory.getLogger(classOf[PlayerService])

  @Resource(name = "playerKafkaProducer")
  private val _kafkaProducer: KafkaProducerService[String, Player] = null

  @Resource
  private val _validator: PlayerValidator = null

  def addNewPlayer(player: Player): ActionResult = {
    if (_validator.validate(player)) {
      player.id = UUIDGenerator.generateUUID
      player.creationDate = System.currentTimeMillis()

      if (player.config == null)
        player.config = new PlayerConfig(false, true, true)

      _kafkaProducer.sendMessage(player.id, player)
      new ActionResult(true, ActionType.ADD_NEW_PLAYER, null, player)
    }
    else {
      new ActionResult(false, ActionType.ADD_NEW_PLAYER, "Player not validated", player)
    }
  }

  //  @Autowired
  //  val producerConfig: Properties = null
  /*
    @PostConstruct
    def start(): Unit = {


      val builder = new StreamsBuilder()
      implicit val playerSerde: Serde[Player] = new PlayerSerde

  //    val players: KStream[String, Player] = builder.stream[String, Player](Player.TOPIC_NAME)
      //    players.print(Printed.toSysOut)

  //    val wordCounts = players
  //      .filter((s, p) => p.age > 40)
  //      .groupBy((_, word) => word.age)
  //      .count()
  //      .toStream
        //      .foreach()
  //            .print(Printed.toSysOut())
  //      .to("player-count")

      val playerTables: KTable[String, Player] = builder.table[String, Player](Player.TOPIC_NAME)
      playerTables.toStream
        .print(Printed.toSysOut())
  //      .foreach()
      //    val res = playerTables
      //      .filter((s, p) => s.length > 10)
      //
      //    res.toStream.to("player-res")
      val playerStream: KafkaStreams = new KafkaStreams(builder.build(), producerConfig)


      playerStream.cleanUp()
      playerStream.start()

      sys.ShutdownHookThread {
        playerStream.close(120, TimeUnit.SECONDS)
      }


      //    System.out(wordCounts.toString)
      //      .flatMapValues(textLine => textLine.toLowerCase.split("\\W+"))
      //      .groupBy((_, word) => word)
      //      .count()
      //    wordCounts.toStream.to("streams-wordcount-output")
    }

  */
}
