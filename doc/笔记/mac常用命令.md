## 常用命令
 ### 基础命令
    pwd---查看我们所在的目录
    ls---显示当前目录下的文件内容
    ls -a---显示当前目录下的文件内容(包含隐藏文件夹)
    clear---清空屏幕
    ->|---补全代码
    mkdir a---在当前目录下，创建一个a名字的文件夹
    rm 1.txt---删除名字为1.txt的文件
    rm -rf a/---删除当前目录下a名字的文件夹，删除文件夹的同时，里面的文件统统删除
    cp 1.txt 2.txt---将当前目录下的1.txt拷贝一份，并放到当前目录下，并命名为2.txt
    vim a.txt---编辑文件a.txt,按a就由一般模式进入编辑模式,由编辑模式退回一般模式按esc
    open 笔记.txt---打开文件笔记.txt
    :wq---保存退出
    :q!---不保存退出
    ps axu---查看所有进程
    ps axu|grep redis---查看跟redis相关进程
 ### Home brew命令
    1、安装任意包
    brew install <packageName>
    example：brew install node
    2、卸载任意包
    brew uninstall <packageName>
    example：brew uninstall git
    3、查看已安装包列表
    brew list
 ### idea快捷键
    1、command+f 在本文件查找
    2、control+shift+f 全局查找
    3、command+r 全局替换
    4、option+command+l 格式化代码
 ### redis
    redis-server 启动redis服务
    redis-cli shutdown 停止redis服务
    control+c 退出redis服务界面