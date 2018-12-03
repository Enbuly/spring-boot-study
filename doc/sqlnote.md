## sql 分页查询优化
:select * from orders_history where type=8 order by id limit 10000,10;
该条语句将会从表 orders_history 中查询第1000条数据之后的10条数据，
也就是第1001条到第10010条数据。


:select * from news order by id desc limit 0,10
耗时0.003秒
select * from news order by id desc limit 10000,10
耗时0.058秒
select * from news order by id desc limit 100000,10 
耗时0.575秒
select * from news order by id desc limit 1000000,10
耗时7.28秒
mysql在数据量大的情况下分页起点越大查询速度越慢


1、select * from orders_history where type=8 limit 100000,1;
2、select id from orders_history where type=8 limit 100000,1;
3、select * from orders_history where type=8 limit 100000,100;
4、select * from orders_history where type=8 and 
id>=(select id from orders_history where type=8 limit 100000,1) 
limit 100;
第1条语句：3674ms
第2条语句：1315ms
第3条语句：3710ms
第4条语句：1327ms


select * from orders_history where type=2 
and id between 1000000 and 1000100 limit 100;
三次测试查询时间：15ms 12ms 9ms
等同于：
select * from orders_history where id >= 1000001 limit 100;

## sql优化
 1、where 及 order by 涉及的列上建立索引.
 2、应尽量避免在 where 子句中对字段进行 null 值判断，
 否则将导致引擎放弃使用索引而进行全表扫描，如：
 select id from t where num is null
 3、int默认可以设置为0，varchar默认可以设置为Empty String.尽量避免null
 4、应尽量避免在 where 子句中使用 != 或 <> 操作符，
 否则将引擎放弃使用索引而进行全表扫描。
 5、应尽量避免在 where 子句中使用 or 来连接条件，如果一个字段有索引，
 一个字段没有索引，将导致引擎放弃使用索引而进行全表扫描，如：
 
 select id from t where num=10 or Name = 'admin'
 可以这样查询：
 
 select id from t where num = 10
 union all
 select id from t where Name = 'admin'
 
 6、select count(*) from table；这样不带任何条件的count会引起全表扫描，
 并且没有任何业务意义，是一定要杜绝的。
 
 7、索引并不是越多越好，索引固然可以提高相应的 select 的效率，
 但同时也降低了 insert 及 update 的效率，因为 insert 或 update 
 时有可能会重建索引，所以怎样建索引需要慎重考虑，视具体情况而定。
 一个表的索引数最好不要超过6个，若太多则应考虑一些不常使用到的列上
 建的索引是否有必要。
 
 8、合理使用索引，在经常查询而不经常增删改操作的字段加索引，索引字段长度应较短而长度固定。
   （表查询会更快），索引字段重复不能过多。一个表上的索引不应该超过6个。
   
 9、Order by与group by后应直接使用字段，而且字段应该是索引字段。
 
 10、查询时，能不要*就不用*，尽量写全字段名
 
 11、对于like语句，以%或者‘-’开头的不会使用索引，以%结尾会使用索引
 
 12、多表连接时，尽量小表驱动大表，即小表 join 大表
 
 13、查看慢查询日志，找出执行时间长的sql语句优化
 
 14、where子句中使用is null或is not null时，
 因为null值会被自动从索引中排除，索引一般不会建立在有空值的列上。
 
 15、where子句中使用or关键字时，or左右字段如果存在一个没有索引，
 有索引字段也会失效；而且即使都有索引，因为二者的索引存储顺序并
 不一致，效率还不如顺序全表扫描，这时引擎有可能放弃使用索引，所以要慎用or。
 
 16、where子句中使用in或not in关键字时，会导致全表扫描，
 能使用exists或between and替代就不使用in。
 
 17、where子句中使用!=操作符时，将放弃使用索引，因为范围不确定，
 使用索引效率不高，会被引擎自动改为全表扫描。
 
 18、where子句中应尽量避免对索引字段操作（表达式操作或函数操作），
 比如select id from test where num/2 = 100应改为num = 200。
 
 
 
 表名：score，位于spring-boot-example。
 
 SELECT name from score where name not in(
 select name from score where score < 60
 )GROUP BY name;
 
 SELECT name FROM score GROUP BY name HAVING MIN(score) > 60;
 
 select name FROM score GROUP BY name ORDER BY SUM(score) DESC LIMIT 2;
