
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