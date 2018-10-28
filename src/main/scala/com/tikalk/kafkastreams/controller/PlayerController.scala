package com.tikalk.kafkastreams.controller

import com.tikalk.kafkastreams.model.{ActionResult, Player}
import org.springframework.web.bind.annotation._

@RestController
class PlayerController {

  @PostMapping(value = Array("/newPlayer"))
  @ResponseBody
  def newPlayer(@RequestBody newPlayer: Player): String = {
//  def newPlayer(@RequestBody newPlayer: Player): ActionResult = {
    println(newPlayer)
//    new ActionResult(true, "Add")
    "OK-LUKU"
  }

}
