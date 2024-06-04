# Qonek QA

## Description

Automation code to test qonek web service using Cucumber Selenium

## How to Run

### Run sequential in local

Make sure these line are comment in ```pom.xml```
```
                <configuration>
                    <includes>
                        <!-- UNCOMMENT BELOW TO RUN PARALLEL -->
<!--                        <include>**/RunCucumberIT.java</include>-->
                        <!-- UNCOMMENT BELOW TO RUN SEQUENTIAL -->
                        <include>**/RunCucumberTest.java</include>
                    </includes>
                    <!-- UNCOMMENT BELOW TO RUN PARALLEL -->
<!--                    <parallel>methods</parallel>-->
<!--                    <threadCount>4</threadCount>-->
                </configuration>
```
Change ```instance: chrome``` in ```application.properties```

Then run ```mvn install```

### Run parallel in local

Make sure these line are uncomment in ```pom.xm```
```
                <configuration>
                    <includes>
                        <!-- UNCOMMENT BELOW TO RUN PARALLEL -->
                        <include>**/RunCucumberIT.java</include>
                        <!-- UNCOMMENT BELOW TO RUN SEQUENTIAL -->
<!--                        <include>**/RunCucumberTest.java</include>-->
                    </includes>
                    <!-- UNCOMMENT BELOW TO RUN PARALLEL -->
                    <parallel>methods</parallel>
                    <threadCount>4</threadCount>
                </configuration>
```
Change ```instance: chrome``` in ```application.properties```

Then run ```mvn install```

### Run in docker

Change ```instance: remote``` in ```application.properties```

Then run ```docker-compose -f docker-compose.yml up --build```
