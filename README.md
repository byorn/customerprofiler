Customer Profiling App
-----------------------
Back End - Spring Boot 2 Framework <br/>
Front End - React <br/>

<br/>

Steps to Run
--------------
1) Build --- c:\customerprofiler> gradlew build<br/>
2) Run --- c:\customerprofiler> gradlew bootrun<br/>

Assumptions
-----------
<ul>
<li>Only a single classification will be shown.</li>
<li>All classifications are for a single month which the user has selected</li>
<li>Txns will be shown for the month</li>
<li>The Balance is the total balance of all the months</li>
<li>Afternoon Person is classified when transaction are greater > 50% but not equal to 50%</li>
<li>Afternoon Person transaction is identified when transaction is done after 12PM and not 12PM - 12:59PM</li>
<li>Big Spender is classified if having transactions over $1000 and not equal to $1000</li>
<li>Morning Person is classified if having transactions greater > 50% and txn time made earlier or equal to 12PM or the whole hour until 12.59PM noon</li>
<li>Potential Saver is less than 25% of expenses, but not equal to 25%</li>
<li>Fast Spender is decided when the total expenses within seven days is greater than 75% of the deposit made (and not equal to 75%)</li>
<li>There can be more than one classification, eg. Afternoon Person and Fast Spender, I will display all the relavent classifications</li>
</ul>

Development on React Front End
------------------------
Prerequsite: Have NPM Installed.<br/>
inside the public folder: i.e. c:\customerprofiler\public> npm install<br/>
to run in development mode:  c:\customerprofiler\public> npm start <br/>
to build production code:  c:\customerprofiler\public> npm run build<br/>
