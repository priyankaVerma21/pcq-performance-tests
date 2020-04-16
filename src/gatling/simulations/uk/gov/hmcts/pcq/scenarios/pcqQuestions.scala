package uk.gov.hmcts.pcq.scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import uk.gov.hmcts.pcq.scenarios.utils.Environment
import uk.gov.hmcts.pcq.scenarios.checks._

object pcqQuestions {

  val BaseURL = Environment.baseURL
  val headers_0 = Environment.headers_0
  val headers_1 = Environment.headers_1
  val MinThinkTime = Environment.minThinkTime
  val MaxThinkTime = Environment.maxThinkTime

  val pcqJourney = group ("PCQ_Questions") {

    exec(http("request_0")
        .get("/")
        .headers(headers_0)
        .check(CsrfCheck.save))

    .pause(MinThinkTime seconds, MaxThinkTime seconds)

    .exec(http("request_1")
        .post("/start-page")
        .headers(headers_1)
        .formParam("_csrf", "${csrf}")
        .check(CsrfCheck.save))

    .pause(MinThinkTime seconds, MaxThinkTime seconds)

    .exec(http("request_2")
        .post("/date-of-birth")
        .headers(headers_1)
        .formParam("_csrf", "${csrf}")
        .formParam("dob_provided", "1")
        .formParam("dob-day", "01")
        .formParam("dob-month", "02")
        .formParam("dob-year", "1990")
        .check(CsrfCheck.save))

    .pause(MinThinkTime seconds, MaxThinkTime seconds)

    .exec(http("request_3")
        .post("/language")
        .headers(headers_1)
        .formParam("_csrf", "${csrf}")
        .formParam("language_other", "")
        .formParam("language_main", "0")
        .check(CsrfCheck.save))

    .pause(MinThinkTime seconds, MaxThinkTime seconds)

    .exec(http("request_4")
        .post("/sex")
        .headers(headers_1)
        .formParam("_csrf", "${csrf}")
        .formParam("sex", "1")
        .check(CsrfCheck.save))

    .pause(MinThinkTime seconds, MaxThinkTime seconds)

    .exec(http("request_5")
        .post("/gender-same-as-sex")
        .headers(headers_1)
        .formParam("_csrf", "${csrf}")
        .formParam("gender_different", "1")
        .formParam("gender_other", "")
        .check(CsrfCheck.save))

    .pause(MinThinkTime seconds, MaxThinkTime seconds)

    .exec(http("request_6")
        .post("/sexual-orientation")
        .headers(headers_1)
        .formParam("_csrf", "${csrf}")
        .formParam("sexuality_other", "")
        .formParam("sexuality", "0")
        .check(CsrfCheck.save))

    .pause(MinThinkTime seconds, MaxThinkTime seconds)
    
    .exec(http("request_7")
        .post("/marital-status")
        .headers(headers_1)
        .formParam("_csrf", "${csrf}")
        .formParam("marriage", "1")
        .check(CsrfCheck.save))

    .pause(MinThinkTime seconds, MaxThinkTime seconds)

    .exec(http("request_8")
        .post("/ethnic-group")
        .headers(headers_1)
        .formParam("_csrf", "${csrf}")
        .formParam("ethnic_group", "0")
        .check(CsrfCheck.save))

    .pause(MinThinkTime seconds, MaxThinkTime seconds)

    .exec(http("request_9")
        .post("/religion")
        .headers(headers_1)
        .formParam("_csrf", "${csrf}")
        .formParam("religion", "1")
        .formParam("religion_other", "")
        .check(CsrfCheck.save))

    .pause(MinThinkTime seconds, MaxThinkTime seconds)

    .exec(http("request_10")
        .post("/disability")
        .headers(headers_1)
        .formParam("_csrf", "${csrf}")
        .formParam("disability_conditions", "2")
        .check(CsrfCheck.save))

    .pause(MinThinkTime seconds, MaxThinkTime seconds)

    .exec(http("request_11")
        .post("/pregnant")
        .headers(headers_1)
        .formParam("_csrf", "${csrf}")
        .formParam("pregnancy", "0"))
  }
}