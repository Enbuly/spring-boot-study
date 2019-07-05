1->cd到kafka的bin目录 cd /usr/local/Cellar/kafka/2.2.1/bin
2->启动zookeeper ./zookeeper-server-start /usr/local/etc/kafka/zookeeper.properties &
3->启动kafka ./kafka-server-start /usr/local/etc/kafka/server.properties &
4->查看所有篮子 kafka-topics --list --zookeeper localhost:2181
5->创建篮子hello kafka-topics --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic hello
6->向篮子hello发送消息 kafka-console-producer --broker-list 172.20.10.5:9092 --topic hello
7->从篮子hello取出一条消息 kafka-console-consumer --bootstrap-server 172.20.10.5:9092 --topic hello --from-beginning
8->安装配置文件的位置
/usr/local/etc/kafka/server.properties
/usr/local/etc/kafka/zookeeper.properties