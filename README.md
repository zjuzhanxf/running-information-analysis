# running-information-analysis

## Create a mysql container
Specify several paramters:<br/>
port forwarding: -p 3306:3306. The first 3306 is host port, the second 3306 is container port.<br/>
give the container a name: --name demo_mysql
MYSQL_ROOT_PASSWORD: set the password to root user to "password"<br/>
pick mysql image: -d mysql:5.6
```
docker run -p 3306:3306 --name demo_mysql -e MYSQL_ROOT_PASSWORD=password -d mysql:5.6
```

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
Open Postman app. Select POST verb. Enter the address below to "Enter Request URL" field. Copy contents in JSON_input.txt, and paste into body, select "raw" format and "JSON(application/json)", click "Send".
```
http://localhost:8080/runningInfo
```

## Test REST API - GET 
In Postman app, select GET verb. <br/>
Enter the address below to "Enter Request URL" field. It will show all the results, display by pages. The URL has parameter "page=0". You can also try "page=1" or "page=2", etc. <br/>
Click "SEND".<br/>
```
http://localhost:8080/runningInfo?page=0
```
Enter the address below to "Enter Request URL" field. It will show the result with runningId = "7c08973d-bed4-4cbd-9c28-9282a02a6032". Click "SEND".<br/>
```
http://localhost:8080/runningInfo/7c08973d-bed4-4cbd-9c28-9282a02a6032
```

## Test REST API - DELETE<br/>
In Postman app, select DELETE verb. <br/>
Enter the address below to "Enter Request URL" field. It will delete the result with runningId = "7c08973d-bed4-4cbd-9c28-9282a02a6032".
Click "SEND".<br/>
```
http://localhost:8080/runningInfo/7c08973d-bed4-4cbd-9c28-9282a02a6032
```
Enter the address below to "Enter Request URL" field. It will delete all the results.<br/>
Click "SEND".<br/>
```
http://localhost:8080/runningInfo/
```

