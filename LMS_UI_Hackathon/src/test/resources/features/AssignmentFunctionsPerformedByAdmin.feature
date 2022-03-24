Feature: Assignment functions performed by Admin

Background: Admin is logged in and Batches and Classes were created already
Given Admin is logged in with Batches and Classes were created already

 Scenario Outline: Check whether Newly Added assignments details are visible to Admin
    Given Admin is on Manage Assignments Page(admin) by clicking on Manage Assignments tab
    When Admin Add an Assignment to Existing Batch "<Assignment Name>","<Assignment Description>","<Assignment Due>","<Assignment File>"
    Then Newly Added assignment Details will be displayed in Manage Assignments Page(Admin)"<Assignment Name>"
    
    Examples: 
    | Assignment Name | Assignment Description | Assignment Due | Assignment File |
    |Name new         | description new        |   04042022     | test.java       |
  
   Scenario Outline: Check whether Edited assignments details are visible to Admin
    Given Admin is on Manage Assignments Page(admin) by clicking on Manage Assignments tab
    When Admin Edit an existing assignment "<Assignment Name>","<Assignment Description>","<Assignment Due>","<Assignment File>"
    Then Updated assignment details will be displayed in Manage Assignments Page(Admin) "<Assignment Name>","<Assignment Description>","<Assignment Due>","<Assignment File>"
    
        Examples: 
    | Assignment Name | Assignment Description | Assignment Due | Assignment File |
    |Name updated     | description updated    | 05282022     | testupdated.java|
    
    Scenario Outline: Check whether Deleted assignments details are removed from Admin view
    Given Admin is on Manage Assignments Page(admin) by clicking on Manage Assignments tab
    When Admin Delete an existing assignment "<Assignment Name>"
    Then Deleted assignment details will be removed from Manage Assignments Page(Admin) "<Assignment Name>"
    Examples: 
    |Assignment Name | 
    |Name new |
    
    Scenario Outline: Check whether Admin can able to see all existing assignment details
    Given Admin is on Manage Assignments Page(admin) by clicking on Manage Assignments tab
    When Admin tries to view exisiting assignment details
    Then All the existing assignment details will be displayed in Manage Assignments Page(Admin) "<Assignment Name>","<Assignment Description>","<Assignment Due>","<Assignment File>"
    
    Examples: 
    |Assignment Name | Assignment Description | Assignment Due | Assignment File |
    |Name new1        | description new       | 04282022     | File.java       |
    
    Scenario Outline: Check whether Admin can add New assignments for particular Batch
    Given Admin is on Add tab of manage Assignments page(admin view) by clicking on Add Assignment in Manage Assignments Page(admin)
    When Admin clicks on submit button after selecting Batch and enters Assignment name  "<Assignment Name>", Assignment Description "<Assignment Description>", Assignment Due "<Assignment Due>", Upload assignments "<Assignment File>"
    Then Created assignments will be displayed in Manage Assignments Page(admin) and Manage Assignment page(User View)
    
    Examples: 
    |Assignment Name | Assignment Description | Assignment Due | Assignment File |
    |Add New Name | Add New Description | 04282022 | File Location To Upload |
    
    Scenario Outline: Check whether Admin can Edit existing assignments for particular Batch
    Given Admin is on Edit tab of manage Assignments page(admin view) by clicking on Add Assignment in Manage Assignments Page(admin)
    When Admin clicks on submit button after updating one or more assignment details  "<Assignment Name>","<Assignment Description>","<Assignment Due>","<Assignment File>"
    Then Updated assignment details will be displayed in Manage Assignments Page(admin) and Manage Assignment page(User View) "<Assignment Name>","<Assignment Description>","<Assignment Due>","<Assignment File>"
    
    Examples: 
    |Assignment Name | Assignment Description | Assignment Due | Assignment File |
    |Add Update Name | Add Update Description | 05282022 | File Location To Upload |
    
    Scenario Outline: Check whether Admin can Delete existing assignments for particular Batch
    Given Admin is on Manage Assignments Page(admin)
    When Admin clicks on Trash icon after selecting existing assignments "<Assignment Name>"
    Then Deleted assignment will be removed from Admin View in Manage Assignments Page(admin) and Manage Assignment page(User View) "<Assignment Name>"
    
    Examples: 
    |Assignment Name |
    |Add Update Name |
    
    Scenario Outline: Check whether Admin can manage students submission by selecting Make Grade Visible
    Given Admin is on Manage Submissions(Admin) page by clicking on Manage button in Manage assignments page(admin)
    When Admin clicks on submit button after selecting all th details like " <Batch>","<Assignment Name>","<Assignment Date>" ,"<Grade By>","<Grade>" ,"<Make Garde Visible>" and "<add comments>" 
    Then Grade Details will be visible to both Admin and User View
    
    Examples:
    | Batch | Assignment Name | Assignment Date | Grade By | Grade | Make Garde Visible | add comments |
    | sdet 30 | Selenium | 092321 |  Teacher | A | yes | Test Comments | 
    
    
    Scenario Outline: Check whether Admin can manage students submission by unselecting Make Grade Viisble
    Given Admin is on Manage Submissions(Admin) page by clicking on Manage button in Manage assignments page(admin)
    When Admin clicks on Submit button after selecting all the details like " <Batch>","<Assignment Name>","<Assignment Date>" ,"<Grade By>","<Grade>" ,"<Make Garde Visible>" and "<add comments>"
    Then Grade Details will be visible only to Admin 
    
     Examples:
    | Batch | Assignment Name | Assignment Date | Grade By | Grade | Make Garde Visible | add comments |
    | sdet 31 | Selenium1 | 052321 |  Teacher | A |no | Test Comments | 
  