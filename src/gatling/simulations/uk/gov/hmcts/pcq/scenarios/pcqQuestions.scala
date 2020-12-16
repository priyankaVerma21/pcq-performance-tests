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
  val headers_4 = Environment.headers_4
  val headers_5 = Environment.headers_5
  val MinThinkTime = Environment.minThinkTime
  val MaxThinkTime = Environment.maxThinkTime  

  val pcqJourney = group ("PCQ_Questions") {

    // ===========================================================
    // Launch PCQ Invoke
    // ===========================================================
    
    exec(http("PCQ01_010_InvokePCQ")
        .get("/invoker")
        .headers(headers_0)
        .check(regex("""name="_csrf" value="(.+?)"""").saveAs("dyn_csrf")))

    .pause(MinThinkTime seconds, MaxThinkTime seconds)

    // ===========================================================
    // Click - Fill
    // ===========================================================

    .exec(http("PCQ01_020_Fill")
        .get("/invoker/formFiller?service=PROBATE&actor=APPLICANT&fields=serviceId,actor,ccdCaseId,pcqId,partyId,language,returnUrl,token")
        .headers(headers_2)
        .check(regex("""ccdCaseId":"(.+?)",""").saveAs("dyn_ccdCaseId"))
        .check(regex("""pcqId":"(.+?)",""").saveAs("dyn_pcqId")))

    .pause(MinThinkTime seconds, MaxThinkTime seconds)

    // ===========================================================
    // Click - Generate Token
    // ===========================================================

    .exec(http("PCQ01_030_GenerateToken")
        .get("/invoker/genToken?serviceId=PROBATE&actor=APPLICANT&ccdCaseId=${dyn_ccdCaseId}&pcqId=${dyn_pcqId}&partyId=PROBATE_APPLICANT%40test.gov.uk&language=en&returnUrl=PROBATE_APPLICANT.test.gov.uk")
        .headers(headers_2)
        .check(regex("""token":"(.+?)"""").saveAs("dyn_token")))

    .pause(MinThinkTime seconds, MaxThinkTime seconds)

    // ===========================================================
    // Click - Invoke
    // ===========================================================

    .exec(http("PCQ01_040_Invoke")
        .post("/invoker")
        .headers(headers_4)
        .formParam("_csrf", "${dyn_csrf}")
        .formParam("serviceId", "PROBATE")
        .formParam("actor", "APPLICANT")
        .formParam("ccdCaseId", "${dyn_ccdCaseId}")
        .formParam("pcqId", "${dyn_pcqId}")
        .formParam("partyId", "PROBATE_APPLICANT@test.gov.uk")
        .formParam("language", "en")
        .formParam("returnUrl", "PROBATE_APPLICANT.test.gov.uk")
        .formParam("token", "${dyn_token}")
        .check(regex("""name="_csrf" value="(.+?)"""").saveAs("dyn_csrf")))

    .pause(MinThinkTime seconds, MaxThinkTime seconds)
        
    // ===========================================================
    // Click - Continue to Questions
    // ===========================================================

    .exec(http("PCQ01_050_ContinueQuestions")
        .post("/start-page")
        .headers(headers_4)
        .formParam("_csrf", "${dyn_csrf}")
        .check(regex("""name="_csrf" value="(.+?)"""").saveAs("dyn_csrf")))

    .pause(MinThinkTime seconds, MaxThinkTime seconds)
        
    // ===========================================================
    // Submit - DOB
    // ===========================================================

    .exec(http("PCQ01_060_DOB")
        .post("/date-of-birth")
        .headers(headers_4)
        .formParam("dob_provided", "1")
        .formParam("dob-day", "10")
        .formParam("dob-month", "10")
        .formParam("dob-year", "1980")
        .formParam("_csrf", "${dyn_csrf}")
        .check(regex("""name="_csrf" value="(.+?)"""").saveAs("dyn_csrf")))
    
    .pause(MinThinkTime seconds, MaxThinkTime seconds)
        
    // ===========================================================
    // Submit - Language
    // ===========================================================

    .exec(http("PCQ01_070_Language")
        .post("/language")
        .headers(headers_4)
        .formParam("language_main", "1")
        .formParam("language_other", "")
        .formParam("_csrf", "${dyn_csrf}")
        .check(regex("""name="_csrf" value="(.+?)"""").saveAs("dyn_csrf")))

    .pause(MinThinkTime seconds, MaxThinkTime seconds)
    
    // ===========================================================
    // Submit - Sex
    // ===========================================================

    .exec(http("PCQ01_080_Sex")
        .post("/sex")
        .headers(headers_4)
        .formParam("sex", "1")
        .formParam("_csrf", "${dyn_csrf}")
        .check(regex("""name="_csrf" value="(.+?)"""").saveAs("dyn_csrf")))

    .pause(MinThinkTime seconds, MaxThinkTime seconds)
            
	// ===========================================================
    // Submit - Gender At Birth
    // ===========================================================        
    .exec(http("PCQ01_090_GenderAtBirth")
        .post("/gender-same-as-sex")
        .headers(headers_4)
        .formParam("gender_different", "1")
        .formParam("gender_other", "")
        .formParam("_csrf", "${dyn_csrf}")
        .check(regex("""name="_csrf" value="(.+?)"""").saveAs("dyn_csrf")))

    .pause(MinThinkTime seconds, MaxThinkTime seconds)
    
    // ===========================================================
    // Submit - Sexual Orientation
    // ===========================================================

    .exec(http("PCQ01_100_SexualOrientation")
        .post("/sexual-orientation")
        .headers(headers_4)
        .formParam("sexuality", "1")
        .formParam("sexuality_other", "")
        .formParam("_csrf", "${dyn_csrf}")
        .check(regex("""name="_csrf" value="(.+?)"""").saveAs("dyn_csrf")))

    .pause(MinThinkTime seconds, MaxThinkTime seconds)
    
    // ===========================================================
    // Submit - Marital Status
    // ===========================================================

    .exec(http("PCQ01_110_MaritalStatus")
        .post("/marital-status")
        .headers(headers_4)
        .formParam("marriage", "1")
        .formParam("_csrf", "${dyn_csrf}")
        .check(regex("""name="_csrf" value="(.+?)"""").saveAs("dyn_csrf")))

    .pause(MinThinkTime seconds, MaxThinkTime seconds)
    
    // ===========================================================
    // Submit - Ethnic Group
    // ===========================================================

    .exec(http("PCQ01_120_EthnicGroup")
        .post("/ethnic-group")
        .headers(headers_4)
        .formParam("ethnic_group", "0")
        .formParam("_csrf", "${dyn_csrf}")
        .check(regex("""name="_csrf" value="(.+?)"""").saveAs("dyn_csrf")))
   
    .pause(MinThinkTime seconds, MaxThinkTime seconds)

    // ===========================================================
    // Submit - Religion
    // ===========================================================

    .exec(http("PCQ01_130_Religion")
        .post("/religion")
        .headers(headers_4)
        .formParam("religion_other", "")
        .formParam("religion", "0")
        .formParam("_csrf", "${dyn_csrf}")
        .check(regex("""name="_csrf" value="(.+?)"""").saveAs("dyn_csrf")))
   
    .pause(MinThinkTime seconds, MaxThinkTime seconds)

    // ===========================================================
    // Submit - Disability
    // ===========================================================

    .exec(http("PCQ01_140_Disability")
        .post("/disability")
        .headers(headers_4)
        .formParam("disability_conditions", "0")
        .formParam("_csrf", "${dyn_csrf}")
        .check(regex("""name="_csrf" value="(.+?)"""").saveAs("dyn_csrf")))

    .pause(MinThinkTime seconds, MaxThinkTime seconds)

    // ===========================================================
    // Submit - Pregnant
    // ===========================================================

    .exec(http("PCQ01_150_Pregnant")
        .post("/pregnant")
        .headers(headers_4)
        .formParam("pregnancy", "0")
        .formParam("_csrf", "${dyn_csrf}"))
  }
}