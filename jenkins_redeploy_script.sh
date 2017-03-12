#!/bin/bash
pkill -f jresume-1.0-SNAPSHOT-jar-with-dependencies.jar
cp target/jresume-1.0-SNAPSHOT-jar-with-dependencies.jar .
nohup java -jar jresume-1.0-SNAPSHOT-jar-with-dependencies.jar -i bleh --server-mode --ssl-mode --log-file /jresume_logs/logs.txt &
#java -jar jresume-1.0-SNAPSHOT-jar-with-dependencies.jar -i bleh --server-mode --ssl-mode --log-file /jresume_logs/logs.txt