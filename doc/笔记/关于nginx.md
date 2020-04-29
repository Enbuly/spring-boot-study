
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
        
   ### 关于负载均衡的配置
        # 此配置于server同级
        upstream hello {
           # 配置被转发的服务器，其中的 ip 推荐使用内网 ip，可以提高访问速度，weight 为权重，数字越大，权越高
           # 下面的配置代表请求中三分之一分发给第一台服务器，三分之二的请求分发给第二台服务器。
           server 127.0.0.1:8082 weight=1;
        }
        # location的配置
        location / {
           add_header X-Content-Type-Options nosniff;
           proxy_set_header X-scheme $scheme;
           #作用是我们可以获取到客户端的真实ip
           proxy_set_header X-Real-IP $remote_addr;
           proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
           proxy_set_header Host $http_host;
           proxy_set_header X-Nginx-Proxy true;
           proxy_hide_header X-Powered-By;
           proxy_hide_header Vary;
           proxy_pass http://hello;
        }