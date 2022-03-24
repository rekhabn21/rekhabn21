
Feature: User Modifications by Admin
Background:  Admin is logged in, Programs and Batches were created already
Given Admin is logged in, Programs and Batches were created already

#1

Scenario: Check whether Admin can search users by giving Email or Batch or Skill or program
 Given Admin is on LMS Admin User Page
 When Admin clicks on search button after entering  Email or Batch or Skill or program	
 Then Admin will be navigated to Manage users(admin) page where Registered User list will be displayed
 
 #2

Scenario: Check whether Admin can edit registered user in Manage users(admin) page

Given Admin is on Manage users page, Registered User list,and clicks on edit icon	
When Admin will be navigated to Manage users(admin) page where User details will be displayed	
Then Admin will be able to edit User details like Time zone, User role batch, Program and click on save


#3
Scenario: Check whether Admin can delete particular registered user in Manage users(admin) 


Given Admin is on Manage users(admin) page, Registered Users list	
When Admin clicks on trash icon of particular registered user	
Then Deleted registered user will be removed from Registered users list


#4 

Scenario: Check whether Admin will be navigated to manage users(admin) page when clicked on eye icon

Given Admin is on Manage users(admin) page, Registered Users list	
When Admin clicks on eye icon for particular user
Then Admin will be navigated to Manage users page and view the User details only in read only format
 
 
 
 