package uk.gov.hmcts.pcq.scenarios.utils

object Environment {

  import io.gatling.core.Predef._
  import io.gatling.http.Predef._

  val baseURL = "https://pcq.aat.platform.hmcts.net"

  val minThinkTime = 1 //5
  val maxThinkTime = 2 //10
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