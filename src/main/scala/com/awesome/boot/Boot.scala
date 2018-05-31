package com.awesome.boot

import akka.actor.{ActorSystem, Props}
import akka.io.IO
import com.awesome.config.Configuration
import com.awesome.rest.RestServiceActor
import spray.can.Http

object Boot extends App with Configuration {

  implicit val system = ActorSystem("awesome-scala-rest")

  val restService = system.actorOf(Props[RestServiceActor], "rest-endpoint")

  IO(Http) ! Http.Bind(restService, serviceHost, servicePort)
}
