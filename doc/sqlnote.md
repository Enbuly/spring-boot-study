## sql 分页查询
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
3、select * from orders_history where type=8 and 
id>=(select id from orders_history where type=8 limit 100000,1) 
limit 100;
4、select * from orders_history where type=8 limit 100000,100;
第1条语句：3674ms
第2条语句：1315ms
第3条语句：1327ms
第4条语句：3710ms


select * from orders_history where type=2 
and id between 1000000 and 1000100 limit 100;
三次测试查询时间：15ms 12ms 9ms
等同于：
select * from orders_history where id >= 1000001 limit 100;









