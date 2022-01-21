!#/bin/bash

cd ./aggregator && mvn clean
cd ../config-server && mvn clean
cd ../eureka-server && mvn clean
cd ../humidity-sensor && mvn clean
cd ../temp-sensor && mvn clean

