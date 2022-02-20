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

## Commands to run tests locally
### with remote.properties file
``` gradle clean test ```
### without remote.properties file
``` gradle clean test -Dbrowser=${BROWSER} -DremoteUrl{REMOTE_URL} -DbrowserVersion=${BROWSER_VERSION} -DbrowserSize=${BROWSER_SIZE} ```

***

## <img src="https://github.com/aafanasyevaa/aafanasyevaa/blob/main/media/Jenkins.jpg" width="50" height="40" /> Running tests using Jenkins
- You need to set up parameters to run a new job 
 ![image](https://user-images.githubusercontent.com/93313607/154845961-047b09f8-d0d2-4b3d-b340-663768a9b2ff.png)

## Allure results
Once the process is finished you will be able to check Allure results
![image](https://user-images.githubusercontent.com/93313607/154846120-3fab91b8-d615-432c-886c-2af9667fafe9.png)

## Integration with Alure TestOps
In Allure TestOps you can check detailed information about test results
![image](https://user-images.githubusercontent.com/93313607/154846211-21701fc9-54a2-463a-beef-f5f9bb951cd9.png)
![image](https://user-images.githubusercontent.com/93313607/154846230-9438c61c-7c07-45d9-86be-b3b24d56a220.png)
![image](https://user-images.githubusercontent.com/93313607/154846271-e6b01ec8-04c7-4210-8d08-2f7604151103.png)

***
## Integration with Jira
***
## Telegram notifications
***
## Example video
