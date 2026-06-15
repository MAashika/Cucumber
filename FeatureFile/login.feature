@login
Feature:UserLogin to the Dashboard
Scenario:Check whether the user was successfully login to the Dashboard
Given User Navigates to the Application Login page
When the User Enter the Username
When the User Enter the Password
And Click Save Button
Then the User can be Login to the Dashboard Successfully