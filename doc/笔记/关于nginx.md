
  ## mac下使用brew安装NGINX
  
   ### 安装
      brew install nginx
      
   ### 配置文件位置
      /usr/local/etc/nginx/nginx.conf
      
   ### 启动
      brew services start nginx
      说明:打开http://localhost:8080，看到Welcome to nginx!
      说明启动成功!
      
   ### 停止
      brew services stop nginx
      
   ### 重启（会先stop，再start）
      brew services restart nginx
   
   ### 关于转发http请求的配置
        server {
            listen       8080;
            server_name  localhost;
            location / {
               proxy_pass http://127.0.0.1:8081;
            }
        }
        此配置将8080端口的请求转发至8081。