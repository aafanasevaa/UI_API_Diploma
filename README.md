# UI+ API tests for https://reqres.in/
*UI+API tests covering main functionality of https://reqres.in/ website*

## :hammer_and_wrench: Technology stack:  
<img src="https://github.com/aafanasyevaa/aafanasyevaa/blob/main/media/Java.png" width="60" height="60" /> ***Java*** — `object-oriented programming language`   
<img src="https://github.com/aafanasyevaa/aafanasyevaa/blob/main/media/Selenide.jpg" width="60" height="60" /> ***Selenide*** — `testing framework powered by Selenium WebDriver`  
<img src="https://github.com/aafanasyevaa/aafanasyevaa/blob/main/media/Gradle.png" width="60" height="55" /> ***Gradle*** — `a build automation tool for multi-language software development`  
<img src="https://github.com/aafanasyevaa/aafanasyevaa/blob/main/media/Junit.png" width="55" height="50" />  ***Junit*** — `unit testing framework for the Java programming language`  
<img src="https://github.com/aafanasyevaa/aafanasyevaa/blob/main/media/Jenkins.jpg" width="60" height="50" /> ***Jenkins*** — `open source automation server`  
<img src="https://github.com/aafanasyevaa/aafanasyevaa/blob/main/media/Rest-Assured.png" width="60" height="35" /> ***Rest-Assured*** — `Java-based library that is used to test RESTful Web Services`  
<img src="https://github.com/aafanasyevaa/aafanasyevaa/blob/main/media/Allure.jpg" width="50" height="40" /> ***Allure*** — `Software Quality Management Platform`

***

## :keyboard: Commands to run tests locally
### with remote.properties file
``` gradle clean test ```
### without remote.properties file
``` gradle clean test -Dbrowser=${BROWSER} -DremoteUrl{REMOTE_URL} -DbrowserVersion=${BROWSER_VERSION} -DbrowserSize=${BROWSER_SIZE} ```

***

## :construction_worker_man: Running tests using Jenkins
*You need to set up parameters to run a new job*

 ![image](https://user-images.githubusercontent.com/93313607/154845961-047b09f8-d0d2-4b3d-b340-663768a9b2ff.png)

## :chart_with_upwards_trend: Allure results
*Once the process is finished you will be able to check Allure results*
![image](https://user-images.githubusercontent.com/93313607/154846120-3fab91b8-d615-432c-886c-2af9667fafe9.png)

## :bar_chart: Integration with Alure TestOps
*In Allure TestOps you can check detailed information about test results*
![image](https://user-images.githubusercontent.com/93313607/154846211-21701fc9-54a2-463a-beef-f5f9bb951cd9.png)
![image](https://user-images.githubusercontent.com/93313607/154846230-9438c61c-7c07-45d9-86be-b3b24d56a220.png)
![image](https://user-images.githubusercontent.com/93313607/154846271-e6b01ec8-04c7-4210-8d08-2f7604151103.png)

***
## :toolbox: Integration with Jira
*Integration with Jira is also configured*
![image](https://user-images.githubusercontent.com/93313607/154846644-4aedf64b-24bc-4e06-9733-f29c4d16f5c2.png)

***
## :email:Telegram notifications
*Once the test run is over the results are sent to a specified telegram channel*
![image](https://user-images.githubusercontent.com/93313607/154847016-d4a11f4c-7c4e-4826-a7e6-14300de2e6e2.png)

***
## :clapper: Example video of running the test
https://user-images.githubusercontent.com/93313607/154847097-bc56d001-5e90-47bb-92b6-37d37d5da7c6.mp4
