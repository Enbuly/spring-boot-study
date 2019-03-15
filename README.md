## 项目技术：
1. maven
2. spring
3. spring boot
4. mysql
5. mybatis
6. druid
7. redis
8. lettuce
9. swagger2

## 项目结构：
* spring-boot-example  父项目
    * web  web项目继承自spring-boot-example
        * api  接口统一定义，model统一定义
        * common  公共模块
        * controller  控制器
        * dao  数据访问层
        * service  服务层
        
#启动项目说明：
1. 要安装mysql，创建数据库，导入doc目录下的sql文件
2. 启动redis服务。（doc目录下有免安装版本的redis服务，启动redis-server.exe即可）
3. 启动项目，访问。

## swagger2访问地址
* http://localhost:8080/swagger-ui.html

## 项目介绍
1. 项目提供了异步调度的demo
2. 项目提供了excel导入导出的demo
3. 项目提供了分页查询的demo
4. 项目提供了token登录的实现基础