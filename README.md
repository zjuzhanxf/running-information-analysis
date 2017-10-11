# running-information-analysis
Spring-Boot-Demo

NOTE: I tried to use MySQL but haven't got it work yet. So the database is H2.

1. In the project directory
```
mvn clean install
```

2. go to target folder
```
java -jar running-information-analysis-service-1.0-SNAPSHOT.jar
```

3. Test REST API - POST
Open Postman app. Select POST verb. Enter the address below to "Enter Request URL" field. Copy contents in JSON_input.txt, and paste into body, select "raw" format and "JSON(application/json)", click "Send".
```
http://localhost:8080/runningInfo
```

4. Test REST API - GET
In Postman app, select GET verb. 
Enter the address below to "Enter Request URL" field. It will show all the results, display by pages. The URL has parameter "page=0". You can also try "page=1" or "page=2", etc. 
Click "SEND".
```
http://localhost:8080/runningInfo?page=0
```
Enter the address below to "Enter Request URL" field. It will show the result with runningId = "7c08973d-bed4-4cbd-9c28-9282a02a6032". Click "SEND".
```
http://localhost:8080/runningInfo/7c08973d-bed4-4cbd-9c28-9282a02a6032
```

5. Test REST API - DELETE
In Postman app, select DELETE verb. 
Enter the address below to "Enter Request URL" field. It will delete the result with runningId = "7c08973d-bed4-4cbd-9c28-9282a02a6032".
Click "SEND".
```
http://localhost:8080/runningInfo/7c08973d-bed4-4cbd-9c28-9282a02a6032
```
Enter the address below to "Enter Request URL" field. It will delete all the results.
Click "SEND".
```
http://localhost:8080/runningInfo/
```

