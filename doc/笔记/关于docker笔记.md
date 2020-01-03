## docker笔记

1、docker ps 查看当前运行在docker的程序

2、docker ps -a 查看所有运行过的containers

3、docker rm {container id} 根据container id移除这个container

4、docker images 查看所有镜像

5、docker rmi {image id} 根据image id移除这个image

6、docker build -t spring-boot-study . 构建镜像

7、docker run -d -p 8080:8080 {image name} 运行镜像(绑定容器的 8080 端口，并将其映射到本地主机 8080 端口上。)
  -p: 指定端口映射，格式为：主机(宿主)端口:容器端口

8、docker start {CONTAINER ID} 运行一个CONTAINER

9、docker stop {CONTAINER ID} 停止一个CONTAINER

10、docker run --name mysql -e MYSQL_ROOT_PASSWORD=120157229 -p 3307:3306 -d mysql docker带密码启动mysql

11、docker exec -it mysql bash 进入容器

12、mysql -u root -p 进入mysql

## docker hub:

docker login
zzy120157229
zzy120157229

docker images

docker tag {images id} {userName}/imagesName:tag
for example: docker tag e4f7698b1dd8 zzy120157229/spring-boot:latest

docker push zzy120157229/spring-boot:latest
