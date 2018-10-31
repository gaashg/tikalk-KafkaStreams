package com.tikalk.kafkastreams.controller

import com.tikalk.kafkastreams.model.{ActionResult, Player}
import com.tikalk.kafkastreams.traits.Validator
import javax.annotation.Resource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation._

@RestController
//@Autowired
class PlayerController {
    @Resource
    val playerValidator : Validator[Player] = null

  @PostMapping(value = Array("/newPlayer"))
  @ResponseBody
  def newPlayer(@RequestBody newPlayer: Player): ActionResult = {
    println(newPlayer)
    if (playerValidator.validate(newPlayer))
      new ActionResult(true, "Add", null)
    else
      new ActionResult(false, "Add", "Not validated")
  }
}
