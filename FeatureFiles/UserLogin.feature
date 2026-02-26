Feature: user login
Scenario: check user login with valid credentials
Given i open browser with url "http://orangehrm.qedgetech.com" 
Then i should see login page
When i enter username as "UdayS"
And i enter password as "Uday123!@#"
And i click login
Then : i should see emplyoee module
When i click logout
Then i should see login page
When i close browser