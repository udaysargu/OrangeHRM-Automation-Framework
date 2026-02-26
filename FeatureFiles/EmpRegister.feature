@tag
Feature: Employee Registration
  I want to use this template to check New Employee Registration

  @tag1
  Scenario: Check Admin able to Create New Employee or not?
  Given i open browser with url "http://orangehrm.qedgetech.com"    
  Then i should see login page     
  When i enter username as "Admin"
  And i enter password as "Qedge123!@#"
  And i click login
  Then i should see admin module
  When i goto add employee page
  And i enter firstname as "Uday"
  And i enter lastname as "Sargu"
  And i click save
  Then i should see registered employee in employee list
  When i click logout
  Then i should see login page
  When i close browser 
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  
  

