Feature: UserRegisteration
Scenario: check new user able to create or not?
Given i open browser with url "http://orangehrm.qedgetech.com" 
Then i should see login page
When i enter username as "Admin"
And i enter password as "Qedge123!@#"
And i click login
Then i should see admin module
When i goto Add users Page
When i select user role as "ESS"
And i enter empname as "Uday Sargu"
And i enter system username as "UdayS"
And i select user status as "Enabled"
And i enter  system user password as "Uday123!@#"
And i enter system user confirm password as "Uday123!@#"
And i click user save

Then i should see registered user in userspage
When i click logout
Then i should see login page
When i close browser 



