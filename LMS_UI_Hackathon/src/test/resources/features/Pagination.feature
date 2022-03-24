
Feature: Pagination
Background: Admin is logged in & Programs, Batches and Users(Registered and Unregistered) are created already
Given Admin is logged in & Programs, Batches and Users(Registered and Unregistered) are created already

 Scenario: Check functionality of Pagination at Manage user(Admin) page
    Given Admin is on Manage users-admin page of User list(Unregistered)
    When result is containing many user records
    Then Large number of user records will be divided into smaller discrete pages
    
    
  Scenario: Check functionality of Pagination at Manage Attendance-Admin and Class Staff page
  Given Admin is on  Manage Attendance(Admin and Class Staff) page ogf Manage Attendance(admin)
  When Result is containing many Student records
  Then Large number of Student records will be divided into smaller discrete pages