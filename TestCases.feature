Feature: Test QBE website

Scenario Outline: Choose Compulsory Third Party
Given user is on homepage
Then user clicks on Car & Vehicle
Then user clicks on Compulsory Third Party
Then user choose State NSW and clicks on Find out more
Then user clicks on Renew your green slip
Then user clicks on Get a green slip quote
Then user selects an Anonymous Quote button
Then user selects Is the Vehicle as current from the drop down
Then user inputs future date as Insurance Start date
Then user clicks Continue
Then user fills in "<date>", "<make>", "<shape>", "<usage>", "<suburb>" and clicks continue
Then user fills in personal information

Examples: 
|date| make|shape|usage|suburb|
|2009|Ford|SED|PPG|2007-BROADWAY|
|2010|Honda|WAG|PRIV|2000-SYDNEY|
|1991|Nissan|WAG|BUSG|2135-STRATHFIELD|
|2004|Holden|SED|PRIV|2140-HOMEBUSH|
|2018|Mazda|WAG|BUSG|2134-BURWOOD|
