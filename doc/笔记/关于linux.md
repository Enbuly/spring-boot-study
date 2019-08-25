# 关于linux安装jdk
1、解压文件，命令tar -xvzf xxx.gz。
2、使用使用vim打开 /etc/profile，在文件底部增加
JAVA_HOME=zzx/jdk1.8.0_181（安装jdk的路径）
CLASSPATH=$JAVA_HOME/lib/
PATH=$PATH:$JAVA_HOME/bin
export PATH JAVA_HOME CLASSPATH
保存退出vim。
3、执行source /etc/profile 命令。
4、使用java -version命令查看是否安装成功。

# 关于linux配置mysql
1、修改密码：set password for root@localhost = password('123');
2、防火墙开通3306端口
3、远程权限
 use mysql;
 select host,user from user;
 GRANT ALL PRIVILEGES ON *.* TO root@"%" IDENTIFIED BY "123456";
 
 ## 关于解压
 unzip可以直接解压zip压缩包
 命令tar -xvzf xxx.gz解压gz包
 
 ## 上传文件
 rz命令可以将本地文件上传到linux
 
 ## tomcat的启动
 常用：
 先cd到tomcat的bin目录下，然后执行。
 chmod +x catalina.sh ->enter
 nohup ./catalina.sh run ->enter
 nohup ../catalina.sh run >a.out ->enter 带日志启动，日志名字为a.out
 
 总结：
 1、直接启动 ./startup.sh 
 2、作为服务启动 nohup ./startup.sh &
 3、控制台动态输出方式启动 ./catalina.sh run 动态地显示tomcat后台的控制台输出信息,Ctrl+C后退出并关闭服务
 
 解释： 
 1、通过方式一、方式三启动的tomcat有个弊端，当客户端连接断开的时候，
 tomcat服务也会立即停止；通过方式二可以作为linux服务一直运行。 
 2、通过方式一、方式二方式启动的tomcat，其日志会写到相应的日志文件中，而不能动态地查看tomcat控制台的输出信息与错误情况； 
 3、通过方式三可以以控制台模式启动tomcat服务，直接看到程序运行时后台的控制台输出信息，
 不必每次都要很麻烦的打开catalina.out日志文件进行查看，这样便于跟踪查阅后台输出信息。
 tomcat控制台信息包括log4j和System.out.println()等输出的信息。
 
 ## linux发送http请求
 1、wget
 2、curl
 
 ## linux查看日志文件
 tail -f fileName
 
 ## linux查找文件
 find ./ -name fileName