package uk.gov.hmcts.pcq.simulations

import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.http.Predef._ //comment out for VM runs, only required for proxy
import uk.gov.hmcts.pcq.scenarios._
import uk.gov.hmcts.pcq.scenarios.utils._
import scala.concurrent.duration._

class PCQSimulation extends Simulation {

    val BaseURL = Environment.baseURL
    val PCQiteration = 1

    val httpProtocol = Environment.HttpProtocol
        .baseUrl(BaseURL)
        .doNotTrackHeader("1")

    val PCQScenario = scenario("PCQ")
        .repeat(PCQiteration) {
            exec(pcqQuestions.pcqJourney)
        }

    setUp(
        PCQScenario.inject(rampUsers(1) during (1 minutes))
    )
    .protocols(httpProtocol)
}