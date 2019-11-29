select * from emp
where deptno<>10 and job='SALESMAN'
order by deptno,ename

select * from emp
where sal<=3000 and sal>=2000

select * from emp
where sal not between 2000 and 3000

select * from emp
where job='CLERK' or job='SALESMAN'

select * from emp
where job not in('CLERK','SALESMAN')

%_

select * from emp
where ename not like '%S%'


select * from 商品
where 商品名 like '%iphone%' or 商品名 like '%oppo%'

select * from emp
 where comm is not null


select upper('hello') from dual

select empno,initcap(ename) from emp

select * from emp where length(ename)>=5
select * from emp order by length(ename)desc,ename

select trunc(45.67,-1) from dual


select months_between(sysdate,'01-1月-18') from dual
select months_between(sysdate,'2018-1-1') from dual

select trunc(months_between(sysdate,to_date('2018-1-1','yyyy-mm-dd'))) from dual

select round('123.456',1) from dual --char->number
select substr(123456789,3,5) from dual --number->char


select to_date('2018-1-1','yyyy-mm-dd') from dual

select to_char(123456.789,'L999,999,999.00'),to_char(1,'L999,999,999.00')from dual

select ename,comm from emp where nvl(comm,0)<1000

select sal,comm, sal+nvl(comm,0) wage from emp

select * from emp order by nvl(comm,0) asc
