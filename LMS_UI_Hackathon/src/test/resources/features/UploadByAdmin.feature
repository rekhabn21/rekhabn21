Feature: Different Upload features by Admin

Scenario: Check whether Admin can upload Recording 
Given  Admin is on Manage Recording -Admin page by clicking Manage Recordings tab
When Admin upload recording after selecting Batch and topic
Then Uploaded recording will be displayed in Manage Classes page -Admin View for selected topic


Scenario: Check whether Admin can Upload  Resources
Given Admin is on Manage Recording -Admin page by clicking Manage Recordings tab
When Admin upload resources after selecting Batch and topic
Then Upload resources will be displayed in Manage Classes page(Admin View) for selected topic