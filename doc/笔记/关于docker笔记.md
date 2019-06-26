## docker笔记
docker ps 查看当前运行在docker的程序
docker ps -a 查看所有运行过的containers
docker rm {container id} 根据container id移除这个container
docker images 查看所有镜像
docker rmi {image id} 根据image id移除这个image
docker build -t spring-boot-study . 构建镜像
docker run -d -p 8080:8080 {image name} 运行镜像(绑定容器的 8080 端口，并将其映射到本地主机 8080 端口上。)
docker run --name mysql -e MYSQL_ROOT_PASSWORD=120157229 -p 3307:3306 -d mysql docker带密码启动mysql
docker exec -it mysql bash 进入容器
mysql -u root -p 进入mysql

docker hub:

docker login
zzy120157229
zzy120157229

docker images

docker tag {images id} {userName}/imagesName:tag
for example: docker tag e4f7698b1dd8 zzy120157229/spring-boot:latest

docker push zzy120157229/spring-boot:latest