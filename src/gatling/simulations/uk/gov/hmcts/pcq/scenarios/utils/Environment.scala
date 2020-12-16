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
		"accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
		"pragma" -> "no-cache",
		"sec-fetch-dest" -> "document",
		"sec-fetch-mode" -> "navigate",
		"sec-fetch-site" -> "none",
		"upgrade-insecure-requests" -> "1")

	val headers_2 = Map(
		"pragma" -> "no-cache",
		"sec-fetch-dest" -> "empty",
		"sec-fetch-mode" -> "cors",
		"sec-fetch-site" -> "same-origin")    

  val headers_4 = Map(
		"accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
		"origin" -> baseURL,
		"pragma" -> "no-cache",
		"sec-fetch-dest" -> "document",
		"sec-fetch-mode" -> "navigate",
		"sec-fetch-site" -> "same-origin",
		"sec-fetch-user" -> "?1",
		"upgrade-insecure-requests" -> "1")

	val headers_5 = Map(
		"pragma" -> "no-cache",
		"sec-fetch-dest" -> "script",
		"sec-fetch-mode" -> "no-cors",
		"sec-fetch-site" -> "cross-site")

  val headers_1 = Map(
    "Origin" -> baseURL,
    "Sec-Fetch-Dest" -> "document",
    "Sec-Fetch-Mode" -> "navigate",
    "Sec-Fetch-Site" -> "same-origin",
    "Sec-Fetch-User" -> "?1")
  
}