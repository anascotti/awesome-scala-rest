package com.awesome.domain

import spray.json.DefaultJsonProtocol

case class Customer (id: Option[Int],
                     firstName: String,
                     lastName: String)

object Customer extends DefaultJsonProtocol {
  implicit val format = jsonFormat3(Customer.apply)
}
