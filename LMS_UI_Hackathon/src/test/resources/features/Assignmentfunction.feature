Feature: Assignment functions performed by User

Background: Admin is logged in,Batches and Classes were created already

Scenario Outline: Check whether user can submit assignment
Given User is on Manage Assignments(user) page
When User clicks on submit button after selecting Batch,Assignment Name,Assignment Date ,add comments 
Then Assignment will be submitted succesfully 

Scenario Outline: Check whether user can edit a particular assignment
Given User is on Manage Assignments(user) page
When User clicks on submit button after clicking on Edit icon to edit the required details
Then Updated Assignment will be submitted successfully

Scenario Outline: Check whether user can delete  a particular assignment
Given User is on Manage Assignments(user) page
When User clicks on Trash icon after the assignment
Then Assignment will be deleted successfully
