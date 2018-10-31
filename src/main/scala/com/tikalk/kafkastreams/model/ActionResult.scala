package com.tikalk.kafkastreams.model

import com.tikalk.kafkastreams.enums.ActionType.ActionType

case class ActionResult (val succeeded : Boolean, val action : ActionType, val message : String, val any : Any)