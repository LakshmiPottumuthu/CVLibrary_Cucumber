Feature: Search Functionality

Background:
 Given Navigate to home page using "https://www.cv-library.co.uk/"
 Then  Verify the title of Page is "Job Search - Find 175,000 UK jobs on CV-Library"
 
Scenario Outline: Search with More Search Option
 When I Click on More Search Option button on Home Page 
 Then Enter the "<Keyword>" in Keywords ,Job Title and Job Ref Search Box
 And Enter the "<Location>" in Location Search Box
 And Select "<Distance>" from Distance DropDown
 And Enter "<Salary Min>" in Salary Min SearchBox
 And Enter "<Salary Max>" in Salary Max SearchBox
 And Select "<Salary Type>" from Salary Type DropDown
 And Select "<Job Type>" from Job Type DropDown
 When I Click on Find Jobs Button
 Then Verify The Search Results Page Header
 
 Examples:
 | Keyword  | Location | Distance        | Salary Min | Salary Max | Salary Type | Job Type  |
 | Selenium | London   | up to 7 miles   | 30000      | 40000      | Per annum   | Permanent |
 | Testing  |          | up to 10 miles  | 400        | 500        | Per day     | Contract  |
 | Tester   |          | up to 50 miles  | 400        | 500        | Per day     |  Any      |
 |          |          | up to 100 miles |            |            | Per annum   |  Any      |
 