# tikalk-KafkaStreams fuzeDay

preparations:
=============


git repository
==============
clone https://github.com/gaashg/tikalk-KafkaStream

IDE
===
at your choosing.

Postman or other rest client
============================

docker
=====


zookeeper
=========
1. download latest version (3.4.13) of zookeeper from
https://zookeeper.apache.org/releases.html

2. copy tar file to a chosen folder.

3. cd to that folder.

3. (sudo) tar -xvf zookeeper-3.4.13.tar.gz

4. cd zookeeper-3.4.13

5. (sudo) mkdir data

6. cd conf

7. (sudo) cp zoo_sample.cfg zoo.cfg

8. edit zoo.cfg and set the following parameters -
tickTime=2000
initLimit=5
syncLimit=2
clientPort=2181
dataDir=/the/path/you/chose/zookeeper-3.4.13/data

9. save the file.

10. to start zookeeper execute:
(sudo) bin/zkServer.sh start


kafka
=====
1. open a new terminal.

2. download kafka (Binary downloads, scala version 2.12) from
https://kafka.apache.org/downloads

3. copy the file to a chosen folder and cd to that folder.

4. (sudo) tar -xvf kafka_2.12-2.0.1.tgz

5. to start kafka:
cd kafka_2.12-2.0.1/bin
(sudo) kafka-server-start.sh config/server.properties

6. that's it :)


kafka populator usage
=====================
supported parameters -
either of these commands can be executed in the same time
1. createTopic - true \ false. whether to create a new topic.
2. sendMessages - true \ false. whether to send messages.

3. topicName - the name of the topic to be used.
4. filePath - the full path to the file that contains the events to send to kafka.
5. sendSleepIntervalMillis - sleep time between messages sent to kafka. 0 means no sleep.

6. kafkaHostname - the name of the kafka hostname.
7. partitionsNum - the number of partitions of the new topic.

8. Usage: filePath=/path/to/file/data.json kafkaHostname=localhost createTopic=false sendMessages=true topicName=Quotes partitionsNum=1 sendSleepIntervalMillis=500 

