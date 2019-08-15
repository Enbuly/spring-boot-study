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
 
 ## 上传文件
 rz命令可以将本地文件上传到linux
 
 ## tomcat的启动
 先cd到tomcat的bin目录下，然后执行。
 chmod +x catalina.sh ->enter
 nohup ./catalina.sh run ->enter