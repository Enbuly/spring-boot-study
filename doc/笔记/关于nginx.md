
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
   