@Regression
Feature: Verify demo websit
  Scenario: Go to the Url and verify the download link
    Given I navigate to the Demo website
    When I click on download link and verify it
 

 Scenario: Go to the Url and Upload a file
 Given I navigate to the Demo Website to upload a file
 When I upload a file  
 

 Scenario: Click on Run button and save the changes
 Given I navigate to the website to verify run button
 When I verify run button and save the changes

 Scenario: Download a file and verify its get downloaded
 Given I navigate to the website to verify download
 When I verify download Link and verify the file get downloaded
 
 #Scenario: Verify drag and drop function on the images
 #Given I navigate to website to verify drag and drop
 #When I verify dragging and dropping of the available image
 
 Scenario Outline: Enter India in text box and 
 Given I navigate to website to verify the auto suggestion
 When I verify auto suggestion with "<name>"
 Examples:
 |name |
 |India|
 
 Scenario Outline: Verify date filling in date enabled
 Given I navigate to dateFillingDateEnabledSite
 When I verify filling dates with "<Year>" "<Month>" and "<Date>"
 Examples:
 |Year|Month|Date|
 |2020|June |  1 |
 |2021|May  | 15 |
 |2019|July | 12 |
 |2020|April| 8 |
 
 Scenario: Verify alert in website
 Given I navigate to verify the alert popup
 When I verify the alert popup
 
 
 Scenario: Verify right click and double click
 Given I navigate to verify the right click and double click
 When I verify the right click and double click
 