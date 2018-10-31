package com.tikalk.kafkastreams.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.{PostMapping, RequestMapping, RequestParam}

@Controller
class GameController {
  @PostMapping(value = Array ("/newGame"))
  def createNewGame () : Unit = {
    println("in create game")
  }
}