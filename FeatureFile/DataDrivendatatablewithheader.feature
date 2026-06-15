Feature:User Entered Inavlid Credentials Feature
Scenario:Check whether the user gets validation error when Entering invalid credentials
Given User go to the Login page
When the User Enter the Invalid Credentials
|Username | Password|
|adminn | admin1233|
And Click onto the Save Button
