## 关于lombok注解：
安装与使用：https://jingyan.baidu.com/article/0a52e3f4e53ca1bf63ed725c.html

常用注解:
@NonNull：给方法参数增加这个注解会自动在方法内对该参数进行是否为空的校验，
如果为空，则抛出NPE（NullPointerException）。

1 @Data 注解在类上面，省略所有的get set equal toString方法 
2 @Getter 注解在属性上，省略所有get方法 
3 @Setter 注解在属性上，省略所有的set方法 
4 @NoArgsConstructor注解类上，提供无参构造 
5 @AllArgsConstructor 注解在类上，提供全参构造

## swagger2访问地址
http://localhost:8080/swagger-ui.html

## Swagger2 
1. @Api  加在Controller上 
   @Api(tags = {"EmailController"}, description = "电子邮件")
   public class EmailController extends BaseController {
   }

2. @ApiOperation 加在Controller的方法上
   @Api(tags = {"EmailController"}, description = "电子邮件")
   public class EmailController extends BaseController {
        @ApiOperation("用户详情")
        @GetMapping("/get")
        public Person get(@RequestParam Long id) {
            return personService.getById(id);
        }       
   }
   
3. @ApiModel 加在请求参数和返回结果的PO/VO上
   @ApiModel(value="Person", description="用户")
   public class Person extends BaseModel3 {
        @ApiModelProperty(value = "姓名")
        private String name;
   }
   
4. @ApiModelProperty 加在请求参数和返回结果PO/VO的字段上
   @ApiModel(value="Person", description="用户")
   public class Person extends BaseModel3 {
        @ApiModelProperty(value = "姓名")
        private String name;
   }

## 关于spring cloud
博客地址：https://blog.csdn.net/forezp/article/details/81040946

## java基础学习
http://www.runoob.com/java/java-tutorial.html

## spring mvc 工作流程
https://www.cnblogs.com/wangxuerui/p/5796348.html

## Restful规范
1. GET：从服务器取出资源（一项或多项）@GetMapping
2. POST：在服务器新建一个资源 @PostMapping
3. PUT：在服务器更新资源 @PutMapping
4. DELETE：从服务器删除资源 @DeleteMapping

## easypoi(excel表的导入导出操作)
https://www.jianshu.com/p/5d67fb720ece

https://blog.csdn.net/HiBoyljw/article/details/81170802

## 阿里云短信发送文档地址 
https://help.aliyun.com/document_detail/55284.html

## Java中ArrayList与LinkedList的区别
https://www.cnblogs.com/nnngu/p/8234568.html

## 关于死锁
https://blog.csdn.net/jinguangliu/article/details/78591477

## 关于子查询和关联查询 效率
https://blog.csdn.net/luckarecs/article/details/7165472

## springMVC一个Controller处理所有用户请求的并发问题
springMVC中，一般Controller、service、DAO层的scope均是singleton；

每个请求都是单独的线程,即使同时访问同一个Controller对象，因为并没有修改Controller对象，

相当于针对Controller对象而言，只是读操作，没有写操作，不需要做同步处理。

Service层、Dao层用默认singleton就行，虽然Service类也有dao这样的属性，

但dao这些类都是没有状态信息的，也就是 相当于不变(immutable)类，所以不影响。

https://blog.csdn.net/u010523770/article/details/52458237








