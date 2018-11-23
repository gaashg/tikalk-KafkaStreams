package com.tikalk.kafkastreams.common.model

import com.tikalk.kafkastreams.web.enums.ActionType.ActionType

case class ActionResult (val succeeded : Boolean, val action : ActionType, val message : String, val any : Any)