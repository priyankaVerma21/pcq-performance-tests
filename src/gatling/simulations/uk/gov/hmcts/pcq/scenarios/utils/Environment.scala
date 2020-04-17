package uk.gov.hmcts.pcq.scenarios.utils

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object Environment {

  /*Comment out desired line depending on env preference*/
  val baseURL = "https://pcq.aat.platform.hmcts.net"
  //val baseURL = "https://pcq.perftest.platform.hmcts.net"

  val minThinkTime = 5 //5
  val maxThinkTime = 10 //10
  val constantthinkTime = 7
  val minWaitForNextIteration = 120 //120
  val maxWaitForNextIteration = 240 //240
  val HttpProtocol = http

  val headers_0 = Map(
    "Sec-Fetch-Dest" -> "document",
    "Sec-Fetch-Mode" -> "navigate",
    "Sec-Fetch-Site" -> "none",
    "Sec-Fetch-User" -> "?1")

  val headers_1 = Map(
    "Origin" -> baseURL,
    "Sec-Fetch-Dest" -> "document",
    "Sec-Fetch-Mode" -> "navigate",
    "Sec-Fetch-Site" -> "same-origin",
    "Sec-Fetch-User" -> "?1")
}