# tikalk-KafkaStreams fuzeDay preparations:


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

4. use sudo only if required!!!
sudo tar -xvf zookeeper-3.4.13.tar.gz

5. cd zookeeper-3.4.13

6. sudo mkdir data

7. cd conf

8. sudo cp zoo_sample.cfg zoo.cfg

9. edit zoo.cfg and set the following parameters -
tickTime=2000
initLimit=5
syncLimit=2
clientPort=2181
dataDir=/the/path/you/chose/zookeeper-3.4.13/data

10. save the file.

11. to start zookeeper execute:
cd .. 

12. sudo ./bin/zkServer.sh start


kafka
=====
1. open a new terminal.

2. download kafka (Binary downloads, scala version 2.12) from
https://kafka.apache.org/downloads

3. copy the file to a chosen folder and cd to that folder.

4. sudo tar -xvf kafka_2.12-2.0.1.tgz

5. to start kafka:
cd kafka_2.12-2.0.1

6. sudo ./bin/kafka-server-start.sh config/server.properties


load quotes
===========
under the project root dir, there's a folder called utilities. you'll find there a jar and a json file, containing the
basic quotes of south park.


kafka populator
===============
in the resources folder, there's a jar that can be used to send messages to a kafka topic.
execution command: 
java -cp .:kafkaPopulator.jar kafkapopulator.KafkaPopulator

supported parameters -
you can execute both commands in the same execution.
1. createTopic - true \ false. whether to create a new topic.
2. sendMessages - true \ false. whether to send messages.

3. topicName - used for both commands. the name of the topic to be used.
4. filePath - sendMessages command. the full path to the file that contains the events to send to kafka.
5. sendSleepIntervalMillis - sendMessages command. sleep time between messages sent to kafka. 0 means no sleep.

6. kafkaHostname - used for both commands. the name of the kafka hostname.
7. partitionsNum - createTopic command. the number of partitions of the new topic.

8. Usage (full example): java -cp .:kafkaPopulator.jar kafkapopulator.KafkaPopulator filePath=/path/to/file/south-park-dialogues.json  kafkaHostname=localhost createTopic=false sendMessages=true topicName=Quotes partitionsNum=1 sendSleepIntervalMillis=500 


mock data
=========
1. can use the following site https://www.mockaroo.com/ or any other data generator site.
