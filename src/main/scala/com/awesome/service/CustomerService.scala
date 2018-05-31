package com.awesome.service

import com.awesome.domain.Customer
import org.slf4j.LoggerFactory

import scala.util.Random


class CustomerService {

  val log = LoggerFactory.getLogger(classOf[CustomerService])


  def create(customer: Customer) = {
    log.debug ("Creating customer: %s".format (customer) )
    Customer(Some(Random.nextInt()), customer.firstName, customer.lastName)
  }
}


