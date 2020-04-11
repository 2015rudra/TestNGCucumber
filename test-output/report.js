$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("D:/Practise/TestNGCucumber/src/main/java/Features/Login.feature");
formatter.feature({
  "name": "Check Login functionality",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Verify Login Functionality",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "user launch browser",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginStepDefinition.user_launch_browser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user is on login page",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDefinition.user_is_on_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user logs into application",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDefinition.user_logs_into_application()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "validate logged in username is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDefinition.validate_logged_in_username_is_displayed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user closes browser",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDefinition.close_the_browser()"
});
formatter.result({
  "status": "passed"
});
});