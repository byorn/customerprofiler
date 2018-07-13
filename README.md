Customer Profiling App
-----------------------
Back End - Spring Boot 2 Framework <br/>
Front End - React <br/>

<br/><br/>

Steps to Run
--------------
1) Build
c:\customerprofiler> gradlew build
</br/>
2) Run
c:\customerprofiler> gradlew bootrun
<br/>
<br/>

Developing on React
------------------------
Prerequsite: Have NPM Installed.<br/>
inside the public folder: npm install
to run in development mode: npm start
to build production code: npm run build

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
</ul>
