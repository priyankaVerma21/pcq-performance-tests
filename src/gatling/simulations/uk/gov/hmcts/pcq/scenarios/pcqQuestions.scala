package uk.gov.hmcts.pcq.scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import uk.gov.hmcts.pcq.scenarios.utils._
import uk.gov.hmcts.pcq.scenarios.checks._
import scala.concurrent.duration._

object PCQQuestions {

  val BaseURL = Environment.baseURL
  val headers_0 = Environment.headers_0
  val headers_1 = Environment.headers_1
  val headers_2 = Environment.headers_2
  val MinThinkTime = Environment.minThinkTime
  val MaxThinkTime = Environment.maxThinkTime  
  val feedUserData = csv("pcqID.csv").queue

  val pcqJourney = group ("PCQ_Questions") {

    feed(feedUserData)

    .exec(http("PCQ01_001_InvokePCQ")
        .get("/service-endpoint?serviceId=PROBATE&actor=CITIZEN&pcqId={pcqid}&ccdCaseId=1234567890123456&partyId=test@gmail.com&returnUrl=dummy-return-url&language=en")
        .headers(headers_2)
        .check(CsrfCheck.save))

    .pause(MinThinkTime seconds, MaxThinkTime seconds)

    .exec(http("PCQ01_020_StartPage")
        .post("/start-page")
        .headers(headers_1)
        .formParam("_csrf", "${csrf}")
        .check(CsrfCheck.save)
        .check(substring("What is your date of birth")))

    .pause(MinThinkTime seconds, MaxThinkTime seconds)

    .exec(http("PCQ01_030_DateOfBirthPage")
        .post("/date-of-birth")
        .headers(headers_1)
        .formParam("_csrf", "${csrf}")
        .formParam("dob_provided", "1")
        .formParam("dob-day", "01")
        .formParam("dob-month", "02")
        .formParam("dob-year", "1990")
        .check(CsrfCheck.save)
        .check(substring("What is your main language")))

    .pause(MinThinkTime seconds, MaxThinkTime seconds)

    .exec(http("PCQ01_040_LanguagePage")
        .post("/language")
        .headers(headers_1)
        .formParam("_csrf", "${csrf}")
        .formParam("language_other", "")
        .formParam("language_main", "0")
        .check(CsrfCheck.save)
        .check(substring("What is your sex")))

    .pause(MinThinkTime seconds, MaxThinkTime seconds)

    .exec(http("PCQ01_050_GenderPage")
        .post("/sex")
        .headers(headers_1)
        .formParam("_csrf", "${csrf}")
        .formParam("sex", "1")
        .check(CsrfCheck.save)
        .check(substring("Is your gender the same as the sex you were registered at birth")))

    .pause(MinThinkTime seconds, MaxThinkTime seconds)

    .exec(http("PCQ01_060_GenderBirthPage")
        .post("/gender-same-as-sex")
        .headers(headers_1)
        .formParam("_csrf", "${csrf}")
        .formParam("gender_different", "1")
        .formParam("gender_other", "")
        .check(CsrfCheck.save)
        .check(substring("Which of the following best describes how you think of yourself")))

    .pause(MinThinkTime seconds, MaxThinkTime seconds)

    .exec(http("PCQ01_070_OrientationPage")
        .post("/sexual-orientation")
        .headers(headers_1)
        .formParam("_csrf", "${csrf}")
        .formParam("sexuality_other", "")
        .formParam("sexuality", "0")
        .check(CsrfCheck.save)
        .check(substring("Are you married or in a legally registered civil partnership")))

    .pause(MinThinkTime seconds, MaxThinkTime seconds)
    
    .exec(http("PCQ01_080_MaritalStatusPage")
        .post("/marital-status")
        .headers(headers_1)
        .formParam("_csrf", "${csrf}")
        .formParam("marriage", "1")
        .check(CsrfCheck.save)
        .check(substring("What is your ethnic group")))

    .pause(MinThinkTime seconds, MaxThinkTime seconds)

    .exec(http("PCQ01_090_EthnicityPage")
        .post("/ethnic-group")
        .headers(headers_1)
        .formParam("_csrf", "${csrf}")
        .formParam("ethnic_group", "0")
        .check(CsrfCheck.save)
        .check(substring("What is your religion")))

    .pause(MinThinkTime seconds, MaxThinkTime seconds)

    .exec(http("PCQ01_100_ReligionPage")
        .post("/religion")
        .headers(headers_1)
        .formParam("_csrf", "${csrf}")
        .formParam("religion", "1")
        .formParam("religion_other", "")
        .check(CsrfCheck.save)
        .check(substring("Do you have any physical or mental health conditions")))

    .pause(MinThinkTime seconds, MaxThinkTime seconds)

    .exec(http("PCQ01_110_DisabilitiesPage")
        .post("/disability")
        .headers(headers_1)
        .formParam("_csrf", "${csrf}")
        .formParam("disability_conditions", "2")
        .check(CsrfCheck.save)
        .check(substring("Are you pregnant or have you")))

    .pause(MinThinkTime seconds, MaxThinkTime seconds)

    .exec(http("PCQ01_120_PregnantPage")
        .post("/pregnant")
        .headers(headers_1)
        .formParam("_csrf", "${csrf}")
        .formParam("pregnancy", "0")
        .check(substring("You have answered the equality questions")))
  }
}