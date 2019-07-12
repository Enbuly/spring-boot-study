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

## 关于kafka的应用
1、批量操作（异步批量增加用户）
2、异步调用其他系统的api（异步调用征信信息）
3、频繁操作且可以异步（记录用户的位置，没隔五秒钟查看用户具体位置并记录到数据库）