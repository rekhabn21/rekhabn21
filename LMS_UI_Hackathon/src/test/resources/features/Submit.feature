Feature: Submit(send) notifcation by Admin
Background: Admin is logged in,Program Name were already created  

Scenario: Check whether Admin can create notification

Given Admin is on Notification page
When  Admin clicks on submit button 
Then Notifications will be submitted successfully