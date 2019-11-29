--1、查询员工表所有数据
select * from emp;
select * from emp;
--2、查询总裁的基本工资
select jibengongzi from yuangong where yuangongzhiwei='总裁'
--3、所有奖金为空的员工
select * from yuangong where jiangjin is null
--4、查询基本工资最高的三个人
select * from (select * from yuangong order by jibengongzi desc)
where rownum<=3

select * from yuangong where jibengongzi in(
       select * from ( select distinct jibengongzi from yuangong order by jibengongzi desc) where rownum<=3
)

--5、查询技术部的所在地
select bumendizhi from bumen where bumenname='技术部'
--6、查询部门编号为30且奖金大于300元的员工信息
select * from yuangong
where bumenid=30 and jiangjin>300
--7、查询部门编号为20的员工中基本工资最高的员工姓名和工资
select * from (select * from yuangong order by jibengongzi desc)
where rownum<=3 and bumenid = 20

select * from yuangong where jibengongzi=(
       select max(jibengongzi) from yuangong where bumenid=20
) and bumenid=20

--8、查询位于'嵩山'、'黑木崖'、'南海神宫'的部门信息
select * from bumen where bumendizhi in('嵩山','黑木崖','南海神宫')
--9、查询入职日期在1981-5-1到1981-12-31之间的所有员工
select * from yuangong
where ruzhiriqi between to-date('1981-5-1','yyyy-mm-dd') and to_date('1981-12-31','yyyy-mm-dd')
--10、查询所有名字为三个字的员工的员工编号,姓名  
select yuangongid,yuangongname from yuangong
where yuangongname like '___'
select yuangongid,yuangongname from yuangong
where length(yuangongname)=3
--11、查询10号部门的所有经理和20号部门的所有职员的详细信息
select * from yuangong
where bumenid=10 and yuangongzhiwei='经理' or bumenid=20
--12、查询姓名中没有‘王’字的员工的详细信息
select * from yuangong
where yuangongname not like '%王%'
select * from yuangong
where instr(yuangongname,'王')=0
--13、查询员工姓名，将工作年限最长的员工排在最前面
select yungongname from yuangong order by ruzhiriqi asc
--14、查询'任我行'的基本工资
select jibengongzi from yuangong where yuangongname='任我行'
--15、查询基本工资比'任我行'多的所有员工的姓名和基本工资
select yuangongname,jibengongzi from yuangong
where jibengongzi>(select jibengongzi from yuangong where yuangongname='任我行')
--16、查询各个部门经理的基本工资
select jibengongzi from yuangong wehere yuangongzhiwei='经理' 
--17、查询与'东方不败'从事相同工作的员工的详细信息
select * from yuangong
where yuangongzhiwei in (select yuangongzhiwei from yuangong where yuangongname='东方不败')
--18、查询市场部员工的姓名
select yuangongname from yuangong
where bumenid in (select bumenid from bumen where bumenname='市场部')
--19、查询某些员工的姓名和基本工资，
--条件是他们的基本工资与部门30中某一个员工的基本工资相同
select yuangongname,jibengongzi from yuangong
where jibengongzi in (select distinct jibengongzi from yuangong where bumenid=30) and bumenid <> 30
--20、查询奖金收入比基本工资高的员工的详细信息
select * from yuangong where nvl(jiangjin,0)>jibengongzi

-----------------------------------5---------------------------------------------
--21、查询不同部门的平均基本工资  
select avg(jibengongzi) from yuangong group by bumenid
--22、查询所有基本工资高于平均基本工资（平均基本工资为所有部门员工的基本工资平均数）的销售人员
select * from yuangong
where yuangongziwei='销售人员' and jibengongzi>(select avg(jibengongzi) from yuangong)
--23、显示各种职位的最低基本工资
select min(jibengongzi) mingongzi from yuangong
group by yuangongzhiwei
order by mingongzi desc 
--24、查询每个部门的人数
select count(*) from yuangong
group by bumenid

--25、查询每个部门入职最早的员工的入职时间和部门编号
select min(ruzhiriqi),bumenid 
from yuangong
group by bumenid

--26、显示所有职员的姓名及其所在部门的名称
select y.yuangongname,b.bumenname
from yuangong y, bumen b
where y.bumenid = b.bumenid
--27、显示所有员工的姓名、所在部门名称和基本工资

--28、显示不同部门不同职位的平均基本工资,部门名称，职位
select avg(y.jibengongzi),b.bumenname,y.yuangongzhiwei
from yuangong y, bumen b
where y.bumenid = b.bumenid
group by b.bumenname,y.yuangongzhiwei

--29、查询部门平均工资大于员工平均工资（全体员工平均工资）的部门编号和平均工资
select bumenid,avg(jibengongzi)
from yuangong
group by bumenid
having avg(jibengongzi)>(select avg(jibengongzi) from yuangong)
--30、查询没有员工的部门名称
select d.dname,count(e.empno)
from emp e right outer join dept d
on e.deptno = d.deptno
group by d.dname
having count(e.empno)=0

select dname from dept
where deptno not in(select distinct deptno from emp)

--31、查询 部门当中每个员工基本工资都大于1200的部门名称
select b.bumenname
from yuangong y, bumen b
where y.bumenid = b.bumenid
group by b.bumenname
having min(y.jibengongzi)>1200

-----------------------提高----------------------------------------------------
--32、查询在神龙岛工作员工的编号，姓名，工作部门，工作所在地
select e.empno,e.ename,d.deptno,d.dname
from emp e, dept d
where

select e.empno,e.ename,d.deptno,d.dname
from emp e inner join dept d on e.deptno = d.deptno

--33、查询各个部门员工的人数
select d.dname,count(e.empno)
from emp e right outer join dept d
on e.deptno = d.deptno
group by d.dname
--34、查询各个岗位员工基本工资大于平均基本工资（平均基本工资包括所有员工）的人数和员工职位
select job,count(*)
from emp
group by job
having min(sal)>(select avg(sal) from emp)
--35、查询基本工资相同的员工的基本工资和姓名
select sal,ename
from emp
where sal in (
      select sal from emp group by sal having count(*)>1
)

select e1.sal,e1.ename
from emp e1, emp e2
where e1.sal=e2.sal and e1.empno<>e2.empno


--36、查询员工的基本工资排名第3-6位的姓名和基本工资
--pn:1,rn:10
select * from emp
where empno not in(select empno from(select * from emp order by sal desc) where rownum<=(1-1)*10)
and empno in(select empno from(select * from emp order by sal desc) where rownum<=10)
order by sal desc


select * from(select * from emp order by sal desc) where rownum<=20  
and empno not in(select empno from(select * from emp order by sal desc) where rownum<=(2-1)*10) 

--37、查询员工的基本信息，附加其上级的姓名

select e1.ename,e2.ename
from emp e1 left outer join emp e2
on e1.mgr = e2.empno

--38、查询员工的基本信息，附加其基本工资的排名(基本工资相同的按奖金订先后，如果奖金相同则并列)
select (select count(*) from emp
 where emp.sal>e.sal or emp.sal=e.sal and nvl(emp.comm,0)>nvl(e.comm,0))+1 num,e.*
from emp e
order by num


--39、查询部门中基本工资不小于2000的人数不止1人的部门名称和人数
select d.dname,count(*) num
from emp e, dept d
where e.deptno = d.deptno and e.sal>=2000
group by d.dname
having count(*)>1
order by count(*) desc
