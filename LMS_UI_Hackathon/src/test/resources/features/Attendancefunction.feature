Feature: Different attendance functions performed by Admin

Background: Admin is logged in,Batches and various classes were already created ,Students are assigned to particular batch.

Scenario Outline: Check whether Admin can view the attendance details
Given Admin is on Manage Attendance(Admin and Class Staff) page
When Admin Selects Batch,Class and Class Date 
Then Student attendance can be viewed succesfully based on the selected criteria

Scenario Outline: Check whether Admin can save the attendance details
Given Admin is on Manage Attendance(Admin and Class Staff) page
When Admin clicks on save button after selecting batch and class and marks the student as either Present , Absent , Late, Excused , Unknown
Then Student attendance details will be saved  succeesfully 

Scenario Outline: Check whether Admin can reset the attendance details
Given Admin is on Manage Attendance(Admin and Class Staff) page
When Admin clicks on reset button after selecting batch , class and class date
Then Default radio button Unknown will be selected for all the displayed students
