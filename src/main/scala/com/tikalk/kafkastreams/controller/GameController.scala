package com.tikalk.kafkastreams.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.{PostMapping, RequestMapping, RequestParam}

@Controller
class GameController {
  @PostMapping(value = Array ("/newGame"))
  def createNewGame (@RequestParam ) : Unit = {

  }

}