
## 线程池
  ### 实现原理
         其实java线程池的实现原理很简单，说白了就是一个线程集
         合workerSet和一个阻塞队列workQueue。当用户向线程池
         提交一个任务(也就是线程)时，线程池会先将任务放入workQueue中。
         workerSet中的线程会不断的从workQueue中获取线程然后执行。
         当workQueue中没有任务的时候，worker就会阻塞，直到队列
         中有任务了就取出来继续执行。
  ### 构造方法的核心参数
   #### int corePoolSize：该线程池中核心线程数最大值
         核心线程：线程池新建线程的时候，如果当前线程总数小
         于corePoolSize，则新建的是核心线程，如果超过corePoolSize，
         则新建的是非核心线程核心线程默认情况下会一直存活在
         线程池中，即使这个核心线程啥也不干(闲置状态)。
         如果指定ThreadPoolExecutor的allowCoreThreadTimeOut这
         个属性为true，那么核心线程如果不干活(闲置状态)的话，
         超过一定时间(时长下面参数决定)，就会被销毁掉。
   #### int maximumPoolSize： 该线程池中线程总数最大值
         线程总数 = 核心线程数 + 非核心线程数。
   #### long keepAliveTime：该线程池中非核心线程闲置超时时长
         一个非核心线程，如果不干活(闲置状态)的时长超过这个参数所
         设定的时长，就会被销毁掉，如果设置allowCoreThreadTimeOut = true，则会作用于核心线程。
   #### TimeUnit unit：keepAliveTime的单位
         TimeUnit是一个枚举类型，其包括：
         NANOSECONDS ： 1微毫秒 = 1微秒 / 1000
         MICROSECONDS ： 1微秒 = 1毫秒 / 1000
         MILLISECONDS ： 1毫秒 = 1秒 /1000
         SECONDS ： 秒
         MINUTES ： 分
         HOURS ： 小时
         DAYS ： 天
   #### BlockingQueue workQueue：该线程池中的任务队列：维护着等待执行的Runnable对象
         当所有的核心线程都在干活时，新添加的任务会被添加到这个队列中等待处
         理，如果队列满了，则新建非核心线程执行任务。
         常用的workQueue类型：
         1、SynchronousQueue：这个队列接收到任务的时候，会直接提交给
         线程处理，而不保留它，如果所有线程都在工作怎么办？那就新建一个线
         程来处理这个任务！所以为了保证不出现<线程数达到了maximumPoolSize
         而不能新建线程>的错误，使用这个类型队列的时候，maximumPoolSize一
         般指定成Integer.MAX_VALUE，即无限大。
         2、LinkedBlockingQueue：这个队列接收到任务的时候，如果当前线程
         数小于核心线程数，则新建线程(核心线程)处理任务；如果当前线程数等于
         核心线程数，则进入队列等待。由于这个队列没有最大值限制，即所有超过
         核心线程数的任务都将被添加到队列中，这也就导致了maximumPoolSize的
         设定失效，因为总线程数永远不会超过corePoolSize。
         3、ArrayBlockingQueue：可以限定队列的长度，接收到任务的时候，
         如果没有达到corePoolSize的值，则新建线程(核心线程)执行任务，
         如果达到了，则入队等候，如果队列已满，则新建线程(非核心线程)执行
         任务，又如果总线程数到了maximumPoolSize，并且队列也满了，则发生错误
         4、DelayQueue：队列内元素必须实现Delayed接口，这就意味着你传进去的
         任务必须先实现Delayed接口。这个队列接收到任务时，首先先入队，只有达
         到了指定的延时时间，才会执行任务
   #### threadFactory
         创建线程的工厂
   #### RejectedExecutionHandler handler
         当workQueue已经满了，并且线程池线程数已经达到maximumPoolSize，将执行拒绝策略。
           
        
           
         
         
      
     