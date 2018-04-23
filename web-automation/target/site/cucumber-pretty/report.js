$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("patientonline.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: waqar.iqbal2@nhs.net"
    },
    {
      "line": 2,
      "value": "#Keywords Summary : Cucumber feature file for patient-online page process to NHS account"
    },
    {
      "line": 3,
      "value": "#Feature: List of scenarios."
    },
    {
      "line": 4,
      "value": "#Scenario: Business rule through list of steps with arguments."
    },
    {
      "line": 5,
      "value": "#Given: Some precondition step"
    },
    {
      "line": 6,
      "value": "#When: Some key actions"
    },
    {
      "line": 7,
      "value": "#Then: To observe outcomes or validation"
    },
    {
      "line": 8,
      "value": "#And,But: To enumerate more Given,When,Then steps"
    },
    {
      "line": 9,
      "value": "#Scenario Outline: List of steps for data-driven as an Examples and \u003cplaceholder\u003e"
    },
    {
      "line": 10,
      "value": "#Examples: Container for s table"
    },
    {
      "line": 11,
      "value": "#Background: List of steps run before each of the scenarios"
    },
    {
      "line": 12,
      "value": "#\"\"\" (Doc Strings)"
    },
    {
      "line": 13,
      "value": "#| (Data Tables)"
    },
    {
      "line": 14,
      "value": "#@ (Tags/Labels):To group Scenarios"
    },
    {
      "line": 15,
      "value": "#\u003c\u003e (placeholder)"
    },
    {
      "line": 16,
      "value": "#\"\""
    },
    {
      "line": 17,
      "value": "## (Comments)"
    },
    {
      "line": 18,
      "value": "#Feature Definition"
    }
  ],
  "line": 19,
  "name": "Patient Online Page - GP registeration entry process: As a registered user with an NHS Account only",
  "description": "I want to understand what additional verification activities I need to perform\r\nSo I can access services which require a higher assurance level",
  "id": "patient-online-page---gp-registeration-entry-process:-as-a-registered-user-with-an-nhs-account-only",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 24,
  "name": "Invalid entries for online GP registration details on patient online page",
  "description": "",
  "id": "patient-online-page---gp-registeration-entry-process:-as-a-registered-user-with-an-nhs-account-only;invalid-entries-for-online-gp-registration-details-on-patient-online-page",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 23,
      "name": "@patientonline"
    }
  ]
});
formatter.step({
  "line": 25,
  "name": "the user is on the patient online Page",
  "keyword": "Given "
});
formatter.step({
  "line": 26,
  "name": "user enters \"\u003clinkageKey\u003e\" \"\u003codsCode\u003e\" \"\u003cuserID\u003e\" invalid entries in the text boxes",
  "keyword": "When "
});
formatter.step({
  "line": 27,
  "name": "presses continue button",
  "keyword": "And "
});
formatter.step({
  "line": 28,
  "name": "error messages shown to enter valid values",
  "keyword": "Then "
});
formatter.examples({
  "line": 30,
  "name": "",
  "description": "",
  "id": "patient-online-page---gp-registeration-entry-process:-as-a-registered-user-with-an-nhs-account-only;invalid-entries-for-online-gp-registration-details-on-patient-online-page;",
  "rows": [
    {
      "cells": [
        "linkageKey",
        "odsCode",
        "userID"
      ],
      "line": 31,
      "id": "patient-online-page---gp-registeration-entry-process:-as-a-registered-user-with-an-nhs-account-only;invalid-entries-for-online-gp-registration-details-on-patient-online-page;;1"
    },
    {
      "cells": [
        "11AA22BB33CC44D",
        "A12334",
        "@less30chars"
      ],
      "line": 32,
      "id": "patient-online-page---gp-registeration-entry-process:-as-a-registered-user-with-an-nhs-account-only;invalid-entries-for-online-gp-registration-details-on-patient-online-page;;2"
    },
    {
      "cells": [
        "11AA22BB33CC44DD",
        "A123",
        ""
      ],
      "line": 33,
      "id": "patient-online-page---gp-registeration-entry-process:-as-a-registered-user-with-an-nhs-account-only;invalid-entries-for-online-gp-registration-details-on-patient-online-page;;3"
    },
    {
      "cells": [
        "11AA22BB33CC44DD",
        "A12334",
        "@less30chars@less30chars@less30chars@less30chars"
      ],
      "line": 34,
      "id": "patient-online-page---gp-registeration-entry-process:-as-a-registered-user-with-an-nhs-account-only;invalid-entries-for-online-gp-registration-details-on-patient-online-page;;4"
    },
    {
      "cells": [
        "",
        "",
        ""
      ],
      "line": 35,
      "id": "patient-online-page---gp-registeration-entry-process:-as-a-registered-user-with-an-nhs-account-only;invalid-entries-for-online-gp-registration-details-on-patient-online-page;;5"
    },
    {
      "cells": [
        "NULL",
        "A12334",
        "@less30chars@less30chars@less30"
      ],
      "line": 36,
      "id": "patient-online-page---gp-registeration-entry-process:-as-a-registered-user-with-an-nhs-account-only;invalid-entries-for-online-gp-registration-details-on-patient-online-page;;6"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 3075828178,
  "status": "passed"
});
formatter.scenario({
  "line": 32,
  "name": "Invalid entries for online GP registration details on patient online page",
  "description": "",
  "id": "patient-online-page---gp-registeration-entry-process:-as-a-registered-user-with-an-nhs-account-only;invalid-entries-for-online-gp-registration-details-on-patient-online-page;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 23,
      "name": "@patientonline"
    }
  ]
});
formatter.step({
  "line": 25,
  "name": "the user is on the patient online Page",
  "keyword": "Given "
});
formatter.step({
  "line": 26,
  "name": "user enters \"11AA22BB33CC44D\" \"A12334\" \"@less30chars\" invalid entries in the text boxes",
  "matchedColumns": [
    0,
    1,
    2
  ],
  "keyword": "When "
});
formatter.step({
  "line": 27,
  "name": "presses continue button",
  "keyword": "And "
});
formatter.step({
  "line": 28,
  "name": "error messages shown to enter valid values",
  "keyword": "Then "
});
formatter.match({
  "location": "PatientOnlineSmokeTest.the_user_is_on_the_patient_online_Page()"
});
formatter.result({
  "duration": 3124843068,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "11AA22BB33CC44D",
      "offset": 13
    },
    {
      "val": "A12334",
      "offset": 31
    },
    {
      "val": "@less30chars",
      "offset": 40
    }
  ],
  "location": "PatientOnlineSmokeTest.user_enters_invalid_entries_in_the_text_boxes(String,String,String)"
});
formatter.result({
  "duration": 3451905968,
  "status": "passed"
});
formatter.match({
  "location": "PatientOnlineSmokeTest.presses_continue_button()"
});
formatter.result({
  "duration": 178944645,
  "status": "passed"
});
formatter.match({
  "location": "PatientOnlineSmokeTest.error_messages_shown_to_enter_valid_values()"
});
formatter.result({
  "duration": 22190823025,
  "status": "passed"
});
formatter.after({
  "duration": 688740317,
  "status": "passed"
});
formatter.before({
  "duration": 2004390398,
  "status": "passed"
});
formatter.scenario({
  "line": 33,
  "name": "Invalid entries for online GP registration details on patient online page",
  "description": "",
  "id": "patient-online-page---gp-registeration-entry-process:-as-a-registered-user-with-an-nhs-account-only;invalid-entries-for-online-gp-registration-details-on-patient-online-page;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 23,
      "name": "@patientonline"
    }
  ]
});
formatter.step({
  "line": 25,
  "name": "the user is on the patient online Page",
  "keyword": "Given "
});
formatter.step({
  "line": 26,
  "name": "user enters \"11AA22BB33CC44DD\" \"A123\" \"\" invalid entries in the text boxes",
  "matchedColumns": [
    0,
    1,
    2
  ],
  "keyword": "When "
});
formatter.step({
  "line": 27,
  "name": "presses continue button",
  "keyword": "And "
});
formatter.step({
  "line": 28,
  "name": "error messages shown to enter valid values",
  "keyword": "Then "
});
formatter.match({
  "location": "PatientOnlineSmokeTest.the_user_is_on_the_patient_online_Page()"
});
formatter.result({
  "duration": 3360481080,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "11AA22BB33CC44DD",
      "offset": 13
    },
    {
      "val": "A123",
      "offset": 32
    },
    {
      "val": "",
      "offset": 39
    }
  ],
  "location": "PatientOnlineSmokeTest.user_enters_invalid_entries_in_the_text_boxes(String,String,String)"
});
formatter.result({
  "duration": 3482347677,
  "status": "passed"
});
formatter.match({
  "location": "PatientOnlineSmokeTest.presses_continue_button()"
});
formatter.result({
  "duration": 118073546,
  "status": "passed"
});
formatter.match({
  "location": "PatientOnlineSmokeTest.error_messages_shown_to_enter_valid_values()"
});
formatter.result({
  "duration": 12174274255,
  "status": "passed"
});
formatter.after({
  "duration": 674242231,
  "status": "passed"
});
formatter.before({
  "duration": 2051908432,
  "status": "passed"
});
formatter.scenario({
  "line": 34,
  "name": "Invalid entries for online GP registration details on patient online page",
  "description": "",
  "id": "patient-online-page---gp-registeration-entry-process:-as-a-registered-user-with-an-nhs-account-only;invalid-entries-for-online-gp-registration-details-on-patient-online-page;;4",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 23,
      "name": "@patientonline"
    }
  ]
});
formatter.step({
  "line": 25,
  "name": "the user is on the patient online Page",
  "keyword": "Given "
});
formatter.step({
  "line": 26,
  "name": "user enters \"11AA22BB33CC44DD\" \"A12334\" \"@less30chars@less30chars@less30chars@less30chars\" invalid entries in the text boxes",
  "matchedColumns": [
    0,
    1,
    2
  ],
  "keyword": "When "
});
formatter.step({
  "line": 27,
  "name": "presses continue button",
  "keyword": "And "
});
formatter.step({
  "line": 28,
  "name": "error messages shown to enter valid values",
  "keyword": "Then "
});
formatter.match({
  "location": "PatientOnlineSmokeTest.the_user_is_on_the_patient_online_Page()"
});
formatter.result({
  "duration": 3206935794,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "11AA22BB33CC44DD",
      "offset": 13
    },
    {
      "val": "A12334",
      "offset": 32
    },
    {
      "val": "@less30chars@less30chars@less30chars@less30chars",
      "offset": 41
    }
  ],
  "location": "PatientOnlineSmokeTest.user_enters_invalid_entries_in_the_text_boxes(String,String,String)"
});
formatter.result({
  "duration": 3562239866,
  "status": "passed"
});
formatter.match({
  "location": "PatientOnlineSmokeTest.presses_continue_button()"
});
formatter.result({
  "duration": 131621212,
  "status": "passed"
});
formatter.match({
  "location": "PatientOnlineSmokeTest.error_messages_shown_to_enter_valid_values()"
});
formatter.result({
  "duration": 32115397185,
  "status": "passed"
});
formatter.after({
  "duration": 675059221,
  "status": "passed"
});
formatter.before({
  "duration": 1998742082,
  "status": "passed"
});
formatter.scenario({
  "line": 35,
  "name": "Invalid entries for online GP registration details on patient online page",
  "description": "",
  "id": "patient-online-page---gp-registeration-entry-process:-as-a-registered-user-with-an-nhs-account-only;invalid-entries-for-online-gp-registration-details-on-patient-online-page;;5",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 23,
      "name": "@patientonline"
    }
  ]
});
formatter.step({
  "line": 25,
  "name": "the user is on the patient online Page",
  "keyword": "Given "
});
formatter.step({
  "line": 26,
  "name": "user enters \"\" \"\" \"\" invalid entries in the text boxes",
  "matchedColumns": [
    0,
    1,
    2
  ],
  "keyword": "When "
});
formatter.step({
  "line": 27,
  "name": "presses continue button",
  "keyword": "And "
});
formatter.step({
  "line": 28,
  "name": "error messages shown to enter valid values",
  "keyword": "Then "
});
formatter.match({
  "location": "PatientOnlineSmokeTest.the_user_is_on_the_patient_online_Page()"
});
formatter.result({
  "duration": 3056151853,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "",
      "offset": 13
    },
    {
      "val": "",
      "offset": 16
    },
    {
      "val": "",
      "offset": 19
    }
  ],
  "location": "PatientOnlineSmokeTest.user_enters_invalid_entries_in_the_text_boxes(String,String,String)"
});
formatter.result({
  "duration": 3349732528,
  "status": "passed"
});
formatter.match({
  "location": "PatientOnlineSmokeTest.presses_continue_button()"
});
formatter.result({
  "duration": 125823867,
  "status": "passed"
});
formatter.match({
  "location": "PatientOnlineSmokeTest.error_messages_shown_to_enter_valid_values()"
});
formatter.result({
  "duration": 2176415261,
  "status": "passed"
});
formatter.after({
  "duration": 657062859,
  "status": "passed"
});
formatter.before({
  "duration": 2080171773,
  "status": "passed"
});
formatter.scenario({
  "line": 36,
  "name": "Invalid entries for online GP registration details on patient online page",
  "description": "",
  "id": "patient-online-page---gp-registeration-entry-process:-as-a-registered-user-with-an-nhs-account-only;invalid-entries-for-online-gp-registration-details-on-patient-online-page;;6",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 23,
      "name": "@patientonline"
    }
  ]
});
formatter.step({
  "line": 25,
  "name": "the user is on the patient online Page",
  "keyword": "Given "
});
formatter.step({
  "line": 26,
  "name": "user enters \"NULL\" \"A12334\" \"@less30chars@less30chars@less30\" invalid entries in the text boxes",
  "matchedColumns": [
    0,
    1,
    2
  ],
  "keyword": "When "
});
formatter.step({
  "line": 27,
  "name": "presses continue button",
  "keyword": "And "
});
formatter.step({
  "line": 28,
  "name": "error messages shown to enter valid values",
  "keyword": "Then "
});
formatter.match({
  "location": "PatientOnlineSmokeTest.the_user_is_on_the_patient_online_Page()"
});
formatter.result({
  "duration": 3273715499,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "NULL",
      "offset": 13
    },
    {
      "val": "A12334",
      "offset": 20
    },
    {
      "val": "@less30chars@less30chars@less30",
      "offset": 29
    }
  ],
  "location": "PatientOnlineSmokeTest.user_enters_invalid_entries_in_the_text_boxes(String,String,String)"
});
formatter.result({
  "duration": 3595336999,
  "status": "passed"
});
formatter.match({
  "location": "PatientOnlineSmokeTest.presses_continue_button()"
});
formatter.result({
  "duration": 103803314,
  "status": "passed"
});
formatter.match({
  "location": "PatientOnlineSmokeTest.error_messages_shown_to_enter_valid_values()"
});
formatter.result({
  "duration": 22159252311,
  "status": "passed"
});
formatter.after({
  "duration": 667720269,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 39,
  "name": "Fetching the nhs number providing the valid enttries in the form",
  "description": "",
  "id": "patient-online-page---gp-registeration-entry-process:-as-a-registered-user-with-an-nhs-account-only;fetching-the-nhs-number-providing-the-valid-enttries-in-the-form",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 38,
      "name": "@patientonline"
    }
  ]
});
formatter.step({
  "line": 40,
  "name": "the user is on the patient online Page",
  "keyword": "Given "
});
formatter.step({
  "line": 41,
  "name": "user enters \"\u003clinkageKey\u003e\" \"\u003codsCode\u003e\" \"\u003cuserID\u003e\" valid entries in the text boxes provided",
  "keyword": "When "
});
formatter.step({
  "line": 42,
  "name": "presses continue button",
  "keyword": "And "
});
formatter.step({
  "line": 43,
  "name": "navigate to the nhs-number page display page",
  "keyword": "Then "
});
formatter.examples({
  "line": 45,
  "name": "",
  "description": "",
  "id": "patient-online-page---gp-registeration-entry-process:-as-a-registered-user-with-an-nhs-account-only;fetching-the-nhs-number-providing-the-valid-enttries-in-the-form;",
  "rows": [
    {
      "cells": [
        "linkageKey",
        "odsCode",
        "userID"
      ],
      "line": 46,
      "id": "patient-online-page---gp-registeration-entry-process:-as-a-registered-user-with-an-nhs-account-only;fetching-the-nhs-number-providing-the-valid-enttries-in-the-form;;1"
    },
    {
      "cells": [
        "11AA22BB33CC44DD",
        "A12334",
        "less30chars"
      ],
      "line": 47,
      "id": "patient-online-page---gp-registeration-entry-process:-as-a-registered-user-with-an-nhs-account-only;fetching-the-nhs-number-providing-the-valid-enttries-in-the-form;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 1986609163,
  "status": "passed"
});
formatter.scenario({
  "line": 47,
  "name": "Fetching the nhs number providing the valid enttries in the form",
  "description": "",
  "id": "patient-online-page---gp-registeration-entry-process:-as-a-registered-user-with-an-nhs-account-only;fetching-the-nhs-number-providing-the-valid-enttries-in-the-form;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 38,
      "name": "@patientonline"
    }
  ]
});
formatter.step({
  "line": 40,
  "name": "the user is on the patient online Page",
  "keyword": "Given "
});
formatter.step({
  "line": 41,
  "name": "user enters \"11AA22BB33CC44DD\" \"A12334\" \"less30chars\" valid entries in the text boxes provided",
  "matchedColumns": [
    0,
    1,
    2
  ],
  "keyword": "When "
});
formatter.step({
  "line": 42,
  "name": "presses continue button",
  "keyword": "And "
});
formatter.step({
  "line": 43,
  "name": "navigate to the nhs-number page display page",
  "keyword": "Then "
});
formatter.match({
  "location": "PatientOnlineSmokeTest.the_user_is_on_the_patient_online_Page()"
});
formatter.result({
  "duration": 2959356589,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "11AA22BB33CC44DD",
      "offset": 13
    },
    {
      "val": "A12334",
      "offset": 32
    },
    {
      "val": "less30chars",
      "offset": 41
    }
  ],
  "location": "PatientOnlineSmokeTest.user_enters_valid_entries_in_the_text_boxes_provided(String,String,String)"
});
formatter.result({
  "duration": 13468384946,
  "status": "passed"
});
formatter.match({
  "location": "PatientOnlineSmokeTest.presses_continue_button()"
});
formatter.result({
  "duration": 135719711,
  "status": "passed"
});
formatter.match({
  "location": "PatientOnlineSmokeTest.navigate_to_the_nhs_number_page_display_page()"
});
formatter.result({
  "duration": 4331192600,
  "status": "passed"
});
formatter.after({
  "duration": 667002221,
  "status": "passed"
});
});