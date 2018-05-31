package com.awesome.rest

import akka.actor.Actor
import akka.event.slf4j.SLF4JLogging
import com.awesome.domain.Customer
import com.awesome.service.CustomerService
import spray.http._
import spray.routing._
import com.awesome.domain.Customer._
import spray.httpx.SprayJsonSupport._

import scala.concurrent.Future

class RestServiceActor extends Actor with RestService {

  implicit def actorRefFactory = context

  def receive = HttpService.runRoute(route)
}

trait RestService extends HttpService with SLF4JLogging {


  val customerService = new CustomerService

  implicit val executionContext = actorRefFactory.dispatcher


  val route = {
    path("customer") {
      respondWithMediaType(MediaTypes.`application/json`) {
        get {
          complete(StatusCodes.Found, "Awesome GET")
        } ~
        post {
          entity(as[Customer]) { customer =>
            complete(StatusCodes.Created, customerService.create(customer))
          }
        }
      }
    } ~
    path("reactive") {
      post {
        entity(as[Customer]) { customer =>
          complete(StatusCodes.Created, Future { customerService.create(customer)} )
        }
      }
    } ~
    path ("params") {
      get {
        parameters('req, 'opt.?) { (req, opt) =>
          complete(s"Req: $req, Opt: $opt")
        }
      }
    }
  }

}

