Feature:  Different Program functions Performed by User
Background: User is logged into LMS Portal

Scenario Outline: Check whether Newly Added program details are visible to User
Given User is on Manage Programs Page(admin) by clicking on Programs Tab
When User Add a program to Existing programs list
Then Newly Added program details will be displayed in Manage Programs Page(admin)

Scenario Outline: Check Edited program details are  visible to User
Given User is on Manage Programs Page(admin) by clicking on Programs Tab
When User Edits an existing program
Then Updated program details will be displayed in Manage Programs Page(admin)

Scenario Outline: Check Deleted program details is removed from User view
Given User is on Manage Programs Page(admin) by clicking on Programs Tab
When User Delete an existing program
Then Deleted program details will be removed from Manage Programs Page(admin)

Scenario Outline: Check User can able to see all existing program details
Given User is on Manage Programs Page(admin) by clicking on Programs Tab
When User tries to view exisiting program  details
Then All the existing program details will be displayed in Manage Programs Page(admin)

Scenario Outline: Check whether User can  Add Program details 
Given User is on Add tab in Add/Edit Programs page by clicking Add Program in Manage Programs Page(admin)
When User clicks on submit button after entering the Program Name ,Program Description,Program Status
Then All the program details will be added to Programs List in Manage Programs Page(admin) with auto generated same ProgramCreationtime and ProgramModifiedtime in   MM/DD/YY HH:MM format

Scenario Outline: Check whether User can Edit Program details for Program 
Given User is on Edit tab in Add/Edit Programs page by clicking Edit icon in Manage Programs Page(admin)
When User clicks on submit button after updating the required fields like Program Name ,Program Description,Program Status
Then All the updated program details will be added to Programs List in Manage Programs Page(admin) with auto generated same ProgramCreationtime and modified Programtime MM/DD/YY HH:MM format

Scenario Outline: Check whether User can Delete the program
Given User is on Manage Programs Page(admin) by clicking on Programs Tab
When User clicks on Trash icon for any program in Programs List
Then Program will be deleted from the Programs List in Manage Programs Page(admin)