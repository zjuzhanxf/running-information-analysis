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

3. copy contents in JSON_input.txt. Open Postman app, select POST, and paste the input into body, click "Send".

4. send GET request
