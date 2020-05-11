package uk.gov.hmcts.pcq.scenarios.utils

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object Environment {

  /*Comment out desired line depending on env preference*/
  //val baseURL = "https://pcq.aat.platform.hmcts.net"
  val baseURL = "https://pcq.perftest.platform.hmcts.net"

  val minThinkTime = 7 //5
  val maxThinkTime = 15 //10
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

  val headers_2 = Map(
		"accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
		"accept-encoding" -> "gzip, deflate, br",
		"accept-language" -> "en-US,en;q=0.9",
		"cache-control" -> "no-cache",
		"pragma" -> "no-cache",
		"sec-fetch-dest" -> "document",
		"sec-fetch-mode" -> "navigate",
		"sec-fetch-site" -> "none",
		"sec-fetch-user" -> "?1",
		"upgrade-insecure-requests" -> "1")
}