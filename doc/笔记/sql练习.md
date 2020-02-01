
## 相关表介绍:
--1.学生表
Student(SId,Sname,Sage,Ssex)
--SId 学生编号,Sname 学生姓名,Sage 出生年月,Ssex 学生性别

--2.课程表
Course(CId,Cname,TId)
--CId 课程编号,Cname 课程名称,TId 教师编号

--3.教师表
Teacher(TId,Tname)
--TId 教师编号,Tname 教师姓名

--4.成绩表
SC(SId,CId,score)
--SId 学生编号,CId 课程编号,score 分数

##以下为练习以及答案
//查询" 01 "课程比" 02 "课程成绩高的学生的信息及课程分数
select s.SId,s.Sname,r.score1,r.score2 from Student s right join (
    select a.sid1,a.score1,b.score2 from(
        (select sc.SId as sid1,sc.score as score1 from sc where sc.CId='01') a,
        (select sc.SId as sid2,sc.score as score2 from sc where sc.CId='02') b
    ) where a.sid1 = b.sid2 and a.score1 > b.score2
) r on s.SId = r.sid1;

//查询平均成绩大于等于 60 分的同学的学生编号和学生姓名和平均成绩
select Student.SId,Student.Sname,r.av from Student RIGHT JOIN(
    select  sc.SId,AVG(sc.score) as av from SC
    GROUP BY sc.SId HAVING AVG(sc.score) > 60
)r on Student.SId = r.SId;

//查询在 SC 表存在成绩的学生信息
select Student.SId,Student.Sname from Student RIGHT JOIN(
    select DISTINCT sc.SId from SC
    GROUP BY sc.SId
)r on Student.SId = r.SId;

//查询所有同学的学生编号、学生姓名、选课总数、所有课程的成绩总和
select Student.SId, Student.Sname, r.co, r.su from Student LEFT JOIN(
    select sc.SId, COUNT(sc.CId) as co, SUM(sc.score) as su from SC
    GROUP BY sc.SId
)r on Student.SId = r.SId;

//查询「李」姓老师的数量
select COUNT(Teacher.TId) from Teacher
where Teacher.Tname LIKE '李%';

//查询学过「张三」老师授课的同学的信息
select Student.SId,Student.Sname from Student,Course,Teacher,SC
where Teacher.TId = Course.TId and
Course.CId = SC.CId and
SC.SId = Student.SId and
Teacher.Tname = '张三';

//查询没有学全所有课程的同学的信息
select Student.SId,Student.Sname from Student
where Student.SId not in(
    select SC.SId from SC
		GROUP BY SC.SId
    HAVING COUNT(SC.CId) = (select COUNT(Course.CId) from Course)
);

//查询至少有一门课与学号为" 01 "的同学所学相同的同学的信息
select Student.SId,Student.Sname from Student RIGHT JOIN(
    select DISTINCT SC.SId as nid from SC where SC.CId in (
        select SC.CId from SC
        where SC.SId = '01'
    )
)r on Student.SId = r.nid;

//查询没学过"张三"老师讲授的任一门课程的学生姓名
select Student.SId,Student.Sname from Student where Student.SId not in(
    select SC.SId from SC,Teacher,Course
    where Teacher.TId = Course.TId
    and Course.CId = SC.CId
    and Teacher.Tname = '张三'
);

//查询两门及其以上不及格课程的同学的学号，姓名及其平均成绩
select Student.SId, Student.Sname, r.av from Student RIGHT JOIN(
    select SC.SId, AVG(sc.score) as av from SC
    where SC.score < 60
    GROUP BY SC.SId
    HAVING COUNT(SC.CId)>1
)r on Student.SId = r.SId;

//检索" 01 "课程分数小于 60，按分数降序排列的学生信息
select student.*, sc.score from student, sc
where student.sid = sc.sid
and sc.score < 60
and cid = "01"
ORDER BY sc.score DESC;

//按平均成绩从高到低显示所有学生的所有课程的成绩以及平均成绩
select * from sc left join (
    select sid, avg(score) as avscore from sc 
    group by sid
)r 
on sc.sid = r.sid
order by avscore desc;

//查询各科成绩最高分、最低分和平均分：
//以如下形式显示：课程 ID，课程 name，最高分，最低分，平均分，及格率，中等率，优良率，优秀率
//及格为>=60，中等为：70-80，优良为：80-90，优秀为：>=90
//要求输出课程号和选修人数，查询结果按人数降序排列，若人数相同，按课程号升序排列
select SC.CId, COUNT(SC.SId) as '选课人数', 
MAX(SC.score) as '最高分',
MIN(SC.score) as '最低分',
AVG(SC.score) as '平均分',
COUNT(SC.SId) as '选课人数',
SUM(case when SC.score >= 60 then 1 else 0 end)/COUNT(SC.SId) as '及格率',
sum(case when sc.score>=70 and sc.score<80 then 1 else 0 end )/count(SC.SId) as '中等率',
sum(case when sc.score>=80 and sc.score<90 then 1 else 0 end )/count(SC.SId) as '优良率',
sum(case when sc.score>=90 then 1 else 0 end )/count(SC.SId) as '优秀率' 
from SC
GROUP BY SC.CId
ORDER BY COUNT(SC.SId) DESC, SC.CId ASC

//按各科成绩进行排序，并显示排名， Score 重复时保留名次空缺
select a.cid, a.sid, a.score, count(b.score)+1 as r
from sc as a 
left join sc as b 
on a.score < b.score and a.cid = b.cid
group by a.cid, a.sid, a.score
order by a.cid, r ASC;

//查询学生的总成绩，并进行排名，总分重复时不保留名次空缺
set @ra = 0;
select q.sid, q.total, @ra := @ra +1 from(
select s.sid, sum(s.score) as total from sc s
group by s.sid
order by sum(s.score) desc
)q

//统计各科成绩各分数段人数：课程编号，课程名称，[100-85]，[85-70]，[70-60]，[60-0] 及所占百分比
select Course.Cname, r.* FROM Course RIGHT JOIN(
    select SC.cid as nid,
    sum(case when sc.score<=100 and sc.score>85 then 1 else 0 end) as "[100-85]",
    sum(case when sc.score<=85 and sc.score>70 then 1 else 0 end) as "[85-70]",
    sum(case when sc.score<=70 and sc.score>60 then 1 else 0 end) as "[70-60]",
    sum(case when sc.score<=60 and sc.score>0 then 1 else 0 end) as "[60-0]"
    from sc
    group by sc.cid
)r on r.nid = Course.CId;

//查询各科成绩前三名的记录
select * from sc
where (
select count(*) from sc as a
where sc.cid = a.cid and sc.score < a.score 
) <= 2
order by cid asc, sc.score desc;

## group by学习笔记

### table: Order

Product   Buyer       Spending
---------------------------------
PD001     Todd          12.00
PD001     Todd          12.00
PD001     Todd          12.00
PD001     Lily          12.00
PD001     Lily          12.00
PD002     Todd          20.00
PD002     Todd          20.00

### sql:

SELECT Product，Buyer, SUM(Spending)
FROM Order
GROUP BY Product, Buyer

### 结果:

Product    Buyer     SUM
------------------------------
PD001      Todd      36.00
PD001      Lily      24.00
PD002      Todd      40.00

### 总结
在MYSQL中使用GROUP BY对表中的数据进行分组时，
GROUP BY X意思是将所有具有相同X字段值的记录放到一个分组里，
GROUP BY X, Y意思是将所有具有相同X字段值和Y字段值的记录放到一个分组里。