Feature: Login page functions
Background: User is in Login Page

Scenario Outline: Check whether user could able to login with valid Credentials
Given User is on LMS Log-In Screen
When User enters Login Name and Password
Then User navigates to LMS Home Page

Scenario Outline: Check whether user could able to login with invalid Credentials
Given User is on LMS Log-In Screen
When User enters Invalid Login Name and Password
Then user will not login successfully with invalid credentials error message

Scenario Outline: Check whether User could able to receive reset password link for the Registered Email Address
Given User is on Answer Security Question page by clicking on Forgot password link
When User enters Email Address and clicks on Next button.User enters the Answer for security Question
Then Message like "Password Reset Link has been sent to Email Address" will be displayed

Scenario Outline: Check whether User could able to receive reset password link for  Unregistered Email ID
Given User is on Answer Security Question page by clicking on Forgot password link
When User enters Email Address and clicks on Next button.User enters the Answer for security Question
Then Message like "Provided Email Id is not registered" will be displayed.