
## springMVC一个Controller处理所有用户请求的并发问题
springMVC中，一般Controller、service、DAO层的scope均是singleton；
每个请求都是单独的线程,即使同时访问同一个Controller对象，因为并没有修改Controller对象，
相当于针对Controller对象而言，只是读操作，没有写操作，不需要做同步处理。
Service层、Dao层用默认singleton就行，虽然Service类也有dao这样的属性，
但dao这些类都是没有状态信息的，也就是 相当于不变(immutable)类，所以不影响。
参考文档：https://blog.csdn.net/u010523770/article/details/52458237