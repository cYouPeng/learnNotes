select sum(sal),avg(sal) from emp

select sum(comm),avg(comm),count(comm),max(comm),min(comm) from emp

select count(*) from emp

select avg(sal+nvl(comm,0)) from emp where deptno=10;
select avg(sal+nvl(comm,0)) from emp where deptno=20;
select avg(sal+nvl(comm,0)) from emp where deptno=30;


select * from emp


select deptno,max(sal),avg(sal),count(*) from emp
group by deptno

select initcap(job),deptno,max(sal) maxsal,avg(sal) avgsal,count(*) num from emp
group by job,deptno
having count(*)>2
order by maxsal desc

select initcap(job),deptno,max(sal) maxsal,avg(sal) avgsal,count(*) num from emp
group by job,deptno
order by deptno, job

select * from emp;
select * from dept;

select ename,(select dname from dept where deptno=emp.deptno) dname
from emp

select job,count(*) from emp
where sal>=1000
group by job
having count(*)>1

select * from (select job,count(*) num from emp
where sal>=1000
group by job)
where num>1

select * from emp
where sal>(select avg(sal) from emp)

