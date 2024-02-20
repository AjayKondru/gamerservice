gamer-service allows gamers to link their details to availables games 

STEP 1 : Fetch all availabe games 
STEP 2 : Update Gamer directory with gamer details for a specific game. 
 * All details are mandatory
 * Allowed levels of game are [NOOB, PRO, INVINCIBLE]

STEP 3: Search gamers based on game,level and geography
STEP 4 : Search gamers based on level for specific game

Please find api details below 
http://localhost:8080/swagger-ui/index.html

All exceptions are handled in generic exception handler
In memory h2 DB is used 
Test cases are written for business logic with Junit 5 


Application is build on Java 17, Spring Boot 3.2.2 version
Checkout application as maven project
