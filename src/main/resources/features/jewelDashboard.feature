


Feature: Jewel Dashboard Automation

  Scenario: Verify Logout Button
    Given You are on the login screen
    Then Enter username as "raghavsuneja123"
    And Enter Password
    Then Verify Logout button is visible or not


  Scenario: Verify Home screen is appearing or not
    Given You are on the login screen
    Then Enter username as "raghavsuneja123"
    And Enter Password
    Then Verify the text of the Home screen


  Scenario:Click on the Autolytics button
    Given You are on the login screen
    Then Enter username as "raghavsuneja123"
    And Enter Password
    Then Click on the Autolytics screen


  Scenario: Verify The autolytics screen is opening or not
    Given You are on the login screen
    Then Enter username as "raghavsuneja123"
    And Enter Password
    Then Verify the Autolytics Screen


  Scenario: Verify The Bridge Token screen is opening or not
    Given You are on the login screen
    Then Enter username as "raghavsuneja123"
    And Enter Password
    Then Verify the Bridge Token Button is clickable or not


  Scenario: Click on copy Bridge Token
    Given You are on the login screen
    Then Enter username as "raghavsuneja123"
    And Enter Password
    Then Click on Copy Bridge Token


  Scenario: Check the alert
    Given You are on the login screen
    Then Enter username as "raghavsuneja123"
    And Enter Password
    Then Verify the Alert when copy button is clicked
#
#
  Scenario: Check the alert of Change Token
    Given You are on the login screen
    Then Enter username as "raghavsuneja123"
    And Enter Password
    Then Verify the Alert when Change Token button is clicked
#
#
  Scenario: Check the alert and time of Change Token button
    Given You are on the login screen
    Then Enter username as "raghavsuneja123"
    And Enter Password
    Then Verify the date and time when Change Token button is clicked

#
  Scenario: Click and verify the Logout button
    Given You are on the login screen
    Then Enter username as "raghavsuneja123"
    And Enter Password
    Then Click and verify the Logout button
#
#
  Scenario: Validate the content of the Home screen
    Given You are on the login screen
    Then Enter username as "raghavsuneja123"
    And Enter Password
    Then Verify the content of the Home screen
#
#
  Scenario: Validate the number of cards present on the Home screen
    Given You are on the login screen
    Then Enter username as "raghavsuneja123"
    And Enter Password
    Then Verify the Cards present on the home screen
#
#
  Scenario: Validate the Autolytics Card on the Home screen
    Given You are on the login screen
    Then Enter username as "raghavsuneja123"
    And Enter Password
    Then Verify the Autolytics Cards present on the home screen
#
#
  Scenario: Validate the Autolytics Card Cotent
    Given You are on the login screen
    Then Enter username as "raghavsuneja123"
    And Enter Password
    Then Verify the Autolytics Card Content
#
  Scenario: Validate the Bridge Token Card Present on the home screen
    Given You are on the login screen
    Then Enter username as "raghavsuneja123"
    And Enter Password
    Then Verify if the Bridge token card is visible
#
  Scenario: Validate the content of Bridge Token Card
    Given You are on the login screen
    Then Enter username as "raghavsuneja123"
    And Enter Password
    Then Validate the content of the Bridge Token card
#
#
  Scenario: Validate the Different things when you login
    Given You are on the login screen
    Then Enter username as "raghavsuneja123"
    And Enter Password
    Then Validate alert ,username and status of the window button
#
#
  Scenario: Check if the change token button is clickable or not
    Given You are on the login screen
    Then Enter username as "raghavsuneja123"
    And Enter Password
    Then Validate if there is change token button available ,if so click it
#
#
  Scenario: Signup screen
    Given You are on the Sign up screen
    Then Click on the Sign up Button
    And Enter random username
    Then Enter all the fields and Validate the status
#
  Scenario: Autolytics Screen
    Given You are on the login screen
    Then Enter username as "raghavsuneja123"
    And Enter Password
    Then Click on the Autolytics screen
    And Click on Create Report Tab
    Then Open few tabs
    And Click on SLide left button
    Then Click on the SLide most Right button
    And Click on the slide to next left button
    Then Click on the Slide to next right button
    And Validate the active tabs
  
  
  
  
  Scenario: Add a new tab in the browser
  Given You are on the login screen
  Then Enter username as "raghavsuneja123"
  Then Enter Password
  Then Open a new tab

  Scenario: Open a new tab in Ignito Mode
  Given You are on the login screen
  Then Enter username as "raghavsuneja123"
  Then Enter Password
  And Logout the Account
#
#
#
#
#
#
#
#
#
  Scenario Outline:Launch login and logout jewel dashboard
    Given user clicks on logIn button and closes it
    Then user again clicks on logIn button and enters <Username> and <Password>
    Then user navigates back after loggin in
    Examples:
      | Username     | Password  |
      | arpit.mishra | arpit1234 |

  Scenario Outline:Launch jewel and check url of jewel and pricing
    Given validating url of jewel <expectedUrl>
    Then click on pricing
    Then validate pricing url <expectedPurl>
    Examples:
      | expectedUrl                     | expectedPurl                             |
      | https://jewel.gemecosystem.com/ | https://jewel.gemecosystem.com/#/pricing |

  Scenario Outline:Launch pricing and validate the texts
    Given clicking on pricing and checking for main heading <pricingHead>
    Then checking for subheading <pricingSubHead>
    Then checking for text <Text>
    Examples:
      | pricingHead | pricingSubHead           | Text                                                       |
      | Hold Tight! | This Page is Coming Soon | Our scouts are currently working hard building this page ! |


  Scenario Outline:Launch jewel again and validate texts
    Given clicking on jewel again validating main heading <mainHeading>
    Then validating subheading of jewel <subHeading>
    Examples:
      | mainHeading   | subHeading                                                  |
      | Explore Jewel | Effortless Report analysis and Test monitoring at a glance. |


  Scenario Outline:Scroll down the screen
    Given validating whatisjewel <whatisjewel>
    Then validating about us <aboutus>
    Then validating content <content>
    Examples:
      | whatisjewel     | aboutus  | content                                                                                                                                                                                                                                                                                                                                                                                |
      | What Is Jewel ? | ABOUT US | Jewel is your one stop Dashboard to analyze and visualize data in a unique and efficient way. Analytical representation of data enables the user to visualize and provide insights into their test runs so that they can be optimized efficiently. Also, data comparisons can be easily achieved due to DB integrations with the dashboard which enhances the overall User experience. |

  Scenario Outline:Validate the text in view report box
    Given validating view report <viewreport>
    Then validating view reportC <viewcontent>
    Examples:
      | viewreport  | viewcontent                                                                                                                                                                        |
      | View Report | Descriptive Reports can be generated and shared with stakeholders to make data comparisons easy. Users can also get easy access to previously generated reports for their records. |

  Scenario Outline:scroll down again and validate the text in run test suite box
    Given validating run test <runtest>
    Then validating run testC  <runcontent>
    Examples:
      | runtest        | runcontent                                                                                                              |
      | Run Test Suite | Users can generate their test suites and run them on various cloud machines leading to an easier automation experience. |

  Scenario Outline:clicking on facebook logo and validating url
    Given click on facebook logo validate url <facebook>
    Examples:
      | facebook                              |
      | https://www.facebook.com/gemecosystem |

  Scenario Outline:clicking on twitter logo and validating url
    Given click on twitter logo and validate url <twitter>
    Examples:
      | twitter                          |
      | https://twitter.com/gemecosystem |

  Scenario Outline:clicking on instagram logo and validating the url
    Given click on instagram logo and validate url <insta>
    Examples:
      | insta                                   |
      | https://www.instagram.com/gemecosystem/ |

  Scenario Outline:clicking on linkedin logo and validating url
    Given click on linkedin logo and validate url <linked>
    Examples:
      | linked                   |
      | https://www.linkedin.com |

  Scenario:clicking on jewel dashboard logo
    Given click on jewel dashboard button

  Scenario Outline:clicking on gemPYP
    Given click on gemPYP and validate url <pyp>
    Examples:
      | pyp                              |
      | https://gempyp.gemecosystem.com/ |

  Scenario Outline:clicking on gemPRF
    Given click on gemPRF and validate url <prf>
    Examples:
      | prf                              |
      | https://gemprf.gemecosystem.com/ |

  Scenario Outline:clicking on gemJAR
    Given click on gemJAR and validate url <jar>
    Examples:
      | jar                              |
      | https://gemjar.gemecosystem.com/ |

  Scenario:click on pricing logo
    Given click on pricing button

  Scenario Outline:if user already exists
    Given click on signup
    Then enter "<name>" "<last>" "<user>" "<email>" "<pass>" "<cpass>" "<company>"
    Examples:
      | name  | last   | user         | email                            | pass      | cpass     | company |
      | arpit | mishra | arpit.mishra | arpit.mishra@geminisolutions.com | arpit1234 | arpit1234 | Gemini  |

  Scenario Outline:automating autolytics
    Given click on login and enter <username> and <password>
    Then click on autolytics and create report
    Then select report name
    Then select project name
    Then select enviroment
    Then select date range and click on generate
    Then validate sorting of numbers
    Examples:
      | username     | password  |
      | arpit.mishra | arpit1234 |


  Scenario Outline:clicking on buttons
    Given click on login and enters <usernames> and <passwords>
    Then click on autolytics and create reports
    Then select report names
    Then select project names
    Then select enviroments
    Then select date range and click on generates
    Then click on copy button and check if report opens in new tab and click on new tab button and validate <sharedurl> of shared report
    Then click on create report button
    Then click on filter status and select pass
    Then click on exe
    Then click on fail
    Then click on warn
    Then click on filter2 and select a date
    Then click on action button and then validate <executionReport>
    Then click on new tab button and validate <exectionUrl> of execution report
    Then click on testcase detail and validate filter
    Examples:
      | usernames    | passwords | sharedurl                                                                                                                                                                                                                                                   | executionReport  | exectionUrl                                                                                                                    |
      | arpit.mishra | arpit1234 | https://jewel.gemecosystem.com/#/autolytics/shared-report?rule=eyJyZXBvcnROYW1lIjoiU3VpdGUgUnVuIFJlcG9ydCIsInJlcG9ydGlkIjoxLCJlbnYiOlsiUHJvZCJdLCJwcm9qZWN0IjpbIkdFTUVDT1NZU1RFTV9BUElTIl0sInN0YXJ0VGltZSI6IjEvMS8yMDIyIiwiZW5kVGltZSI6IjEwLzExLzIwMjIifQ== | Execution Report | https://jewel.gemecosystem.com/#/autolytics/extent-report?s_run_id=GEMECOSYSTEM_APIS_PROD_B8B819A1-7CE0-44C3-B5C7-AE00FED84937 |



