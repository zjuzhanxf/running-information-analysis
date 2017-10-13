# running-information-analysis

## Create a mysql container

```
docker-compose up
```
above step created a mysql container called demo_mysql

## Create database inside container
```
docker exec -it demo_mysql mysql -u root -p
```
Enter password, which is "password".

```
CREATE DATABASE running_information_analysis_db
```
Above command created a database "running_information_analysis_db" in the container demo_mysql.

## Build
In the project folder
```
mvn clean install
```

above commend will generate a "target" folder
```
cd target
java -jar running-information-analysis-service-1.0-SNAPSHOT.jar
```

## Test REST API - POST
Open Postman app. Select POST verb. <br/>
Enter the address below to "Enter Request URL" field. <br/>
Copy contents in JSON_input.txt, and paste into body, select "raw" format and "JSON(application/json)".<br/>
Click "Send".<br/>
```
http://localhost:8080/runningInfo
```

## Test REST API - GET 
In Postman app, select GET verb. <br/>
Enter the address below to "Enter Request URL" field. The URL has parameter "page=0". You can also try "page=1" or "page=2", etc. <br/>
Click "SEND" <br/>
It will show the page 0 of all the results.
```
http://localhost:8080/runningInfo?page=0
```

Enter the address below to "Enter Request URL" field. <br/>
Click "SEND".<br/>
It will show the result with runningId = "7c08973d-bed4-4cbd-9c28-9282a02a6032". <br/>
```
http://localhost:8080/runningInfo/7c08973d-bed4-4cbd-9c28-9282a02a6032
```

## Test REST API - DELETE<br/>
In Postman app, select DELETE verb. <br/>
Enter the address below to "Enter Request URL" field. <br/>
Click "SEND".<br/>
It will delete the result with runningId = "7c08973d-bed4-4cbd-9c28-9282a02a6032".<br/>
```
http://localhost:8080/runningInfo/7c08973d-bed4-4cbd-9c28-9282a02a6032
```

Enter the address below to "Enter Request URL" field. <br/>
Click "SEND".<br/>
It will delete all the results.<br/>
```
http://localhost:8080/runningInfo/
```

