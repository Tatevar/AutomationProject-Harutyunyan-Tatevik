$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/feature/tests.feature");
formatter.feature({
  "name": "Find a hotel",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Hotel searching and finding on the booking page",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "The booking page is loaded",
  "keyword": "Given "
});
formatter.match({
  "location": "BookingHomePage_Steps.openPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Enter Hotel Name And Click the Search Button",
  "keyword": "When "
});
formatter.match({
  "location": "BookingHomePage_Steps.searchTheHotel()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The Hotel is displayed with the Rating Exceptional",
  "keyword": "Then "
});
formatter.match({
  "location": "BookingHomePage_Steps.hotelResults()"
});
formatter.result({
  "status": "passed"
});
});