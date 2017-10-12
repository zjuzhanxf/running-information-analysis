# running-information-analysis

## Create a mysql container
**Specify several paramters**:<br/>
-p 3306:3306 <br/>
The first 3306 is host port, the second 3306 is container port. <br/>

--name demo_mysql <br/>
give the container a name<br/>

-e MYSQL_ROOT_PASSWORD=password <br/>
set root user password to password <br/>

-d mysql:5.6 <br/>
pick mysql image <br/>
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

