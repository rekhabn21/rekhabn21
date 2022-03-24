
Feature: Different Classes Modifications By Admin
Background:
Given Admin is logged in,Batches and Classes were created already
Scenario: Check whether Newly Added Class details are visible to Admin
Given Admin is on Manage Classes Page-admin by clicking on Manage Classes tab
When Admin Add a Class to Existing Batch
Then Newly Added Class details should display in Manage Classes Page -Admin


#1
Scenario: Check whether Edited classes details are visible to Admin
Given Admin is on Manage Classes Page-admin by clicking on Manage Classes tab
When Admin Add a Class to Existing Batch
Then Updated class details should display in Manage Classes Page-Admin

Scenario: Check whether Deleted classes is removed from Admin view
Given Admin is on Manage Classes Page-admin by clicking on Manage Classes tab
When Admin Delete an existing Class
Then Deleted Class details will be removed from Manage Classes Page -Admin

#2
Scenario: Check whether Admin can able to see all existing classes details
Given Admin is on Manage Classes Page-admin by clicking on Manage Classes tab
When Admin try to view exisiting Class details
Then All the existing Classes details are displayed in Manage Classes Page-Admin

Scenario: Check whether Admin can add New Class for particular Batch
Given Admin is on Add tab of Add/Edit Classes Page-Admin by clicking on Add Class in Manage Classes page(admin)
When Admin clicks on submit button after entering the details  like Class Topic, Class Date, Staff Name, Class Description, Comments for the selected batch 
Then Created Class will be displayed in Manage Classes Page-admin

Scenario: Check whether Admin can Edit existing Class for particular Batch
Given Admin is on Edit tab of Add/Edit Classes Page by cliking on Edit icon in Manage Classes page(admin)
When Admin clicks on submit button after updating class details 
Then Updated Class details will be displayedin Manage Classes Page(admin)

Scenario: Check whether Admin can Edit existing Class for particular Batch
Given Admin is on Manage Classes Page(admin) 
When Admin clicks on Trash icon of existing Class for particular Batch
Then Deleted Class will be removed from Manage Classes Page(admin)





