--1����ѯԱ������������
select * from emp;
select * from emp;
--2����ѯ�ܲõĻ�������
select jibengongzi from yuangong where yuangongzhiwei='�ܲ�'
--3�����н���Ϊ�յ�Ա��
select * from yuangong where jiangjin is null
--4����ѯ����������ߵ�������
select * from (select * from yuangong order by jibengongzi desc)
where rownum<=3

select * from yuangong where jibengongzi in(
       select * from ( select distinct jibengongzi from yuangong order by jibengongzi desc) where rownum<=3
)

--5����ѯ�����������ڵ�
select bumendizhi from bumen where bumenname='������'
--6����ѯ���ű��Ϊ30�ҽ������300Ԫ��Ա����Ϣ
select * from yuangong
where bumenid=30 and jiangjin>300
--7����ѯ���ű��Ϊ20��Ա���л���������ߵ�Ա�������͹���
select * from (select * from yuangong order by jibengongzi desc)
where rownum<=3 and bumenid = 20

select * from yuangong where jibengongzi=(
       select max(jibengongzi) from yuangong where bumenid=20
) and bumenid=20

--8����ѯλ��'��ɽ'��'��ľ��'��'�Ϻ���'�Ĳ�����Ϣ
select * from bumen where bumendizhi in('��ɽ','��ľ��','�Ϻ���')
--9����ѯ��ְ������1981-5-1��1981-12-31֮�������Ա��
select * from yuangong
where ruzhiriqi between to-date('1981-5-1','yyyy-mm-dd') and to_date('1981-12-31','yyyy-mm-dd')
--10����ѯ��������Ϊ�����ֵ�Ա����Ա�����,����  
select yuangongid,yuangongname from yuangong
where yuangongname like '___'
select yuangongid,yuangongname from yuangong
where length(yuangongname)=3
--11����ѯ10�Ų��ŵ����о����20�Ų��ŵ�����ְԱ����ϸ��Ϣ
select * from yuangong
where bumenid=10 and yuangongzhiwei='����' or bumenid=20
--12����ѯ������û�С������ֵ�Ա������ϸ��Ϣ
select * from yuangong
where yuangongname not like '%��%'
select * from yuangong
where instr(yuangongname,'��')=0
--13����ѯԱ���������������������Ա��������ǰ��
select yungongname from yuangong order by ruzhiriqi asc
--14����ѯ'������'�Ļ�������
select jibengongzi from yuangong where yuangongname='������'
--15����ѯ�������ʱ�'������'�������Ա���������ͻ�������
select yuangongname,jibengongzi from yuangong
where jibengongzi>(select jibengongzi from yuangong where yuangongname='������')
--16����ѯ�������ž���Ļ�������
select jibengongzi from yuangong wehere yuangongzhiwei='����' 
--17����ѯ��'��������'������ͬ������Ա������ϸ��Ϣ
select * from yuangong
where yuangongzhiwei in (select yuangongzhiwei from yuangong where yuangongname='��������')
--18����ѯ�г���Ա��������
select yuangongname from yuangong
where bumenid in (select bumenid from bumen where bumenname='�г���')
--19����ѯĳЩԱ���������ͻ������ʣ�
--���������ǵĻ��������벿��30��ĳһ��Ա���Ļ���������ͬ
select yuangongname,jibengongzi from yuangong
where jibengongzi in (select distinct jibengongzi from yuangong where bumenid=30) and bumenid <> 30
--20����ѯ��������Ȼ������ʸߵ�Ա������ϸ��Ϣ
select * from yuangong where nvl(jiangjin,0)>jibengongzi

-----------------------------------5---------------------------------------------
--21����ѯ��ͬ���ŵ�ƽ����������  
select avg(jibengongzi) from yuangong group by bumenid
--22����ѯ���л������ʸ���ƽ���������ʣ�ƽ����������Ϊ���в���Ա���Ļ�������ƽ��������������Ա
select * from yuangong
where yuangongziwei='������Ա' and jibengongzi>(select avg(jibengongzi) from yuangong)
--23����ʾ����ְλ����ͻ�������
select min(jibengongzi) mingongzi from yuangong
group by yuangongzhiwei
order by mingongzi desc 
--24����ѯÿ�����ŵ�����
select count(*) from yuangong
group by bumenid

--25����ѯÿ��������ְ�����Ա������ְʱ��Ͳ��ű��
select min(ruzhiriqi),bumenid 
from yuangong
group by bumenid

--26����ʾ����ְԱ�������������ڲ��ŵ�����
select y.yuangongname,b.bumenname
from yuangong y, bumen b
where y.bumenid = b.bumenid
--27����ʾ����Ա�������������ڲ������ƺͻ�������

--28����ʾ��ͬ���Ų�ְͬλ��ƽ����������,�������ƣ�ְλ
select avg(y.jibengongzi),b.bumenname,y.yuangongzhiwei
from yuangong y, bumen b
where y.bumenid = b.bumenid
group by b.bumenname,y.yuangongzhiwei

--29����ѯ����ƽ�����ʴ���Ա��ƽ�����ʣ�ȫ��Ա��ƽ�����ʣ��Ĳ��ű�ź�ƽ������
select bumenid,avg(jibengongzi)
from yuangong
group by bumenid
having avg(jibengongzi)>(select avg(jibengongzi) from yuangong)
--30����ѯû��Ա���Ĳ�������
select d.dname,count(e.empno)
from emp e right outer join dept d
on e.deptno = d.deptno
group by d.dname
having count(e.empno)=0

select dname from dept
where deptno not in(select distinct deptno from emp)

--31����ѯ ���ŵ���ÿ��Ա���������ʶ�����1200�Ĳ�������
select b.bumenname
from yuangong y, bumen b
where y.bumenid = b.bumenid
group by b.bumenname
having min(y.jibengongzi)>1200

-----------------------���----------------------------------------------------
--32����ѯ������������Ա���ı�ţ��������������ţ��������ڵ�
select e.empno,e.ename,d.deptno,d.dname
from emp e, dept d
where

select e.empno,e.ename,d.deptno,d.dname
from emp e inner join dept d on e.deptno = d.deptno

--33����ѯ��������Ա��������
select d.dname,count(e.empno)
from emp e right outer join dept d
on e.deptno = d.deptno
group by d.dname
--34����ѯ������λԱ���������ʴ���ƽ���������ʣ�ƽ���������ʰ�������Ա������������Ա��ְλ
select job,count(*)
from emp
group by job
having min(sal)>(select avg(sal) from emp)
--35����ѯ����������ͬ��Ա���Ļ������ʺ�����
select sal,ename
from emp
where sal in (
      select sal from emp group by sal having count(*)>1
)

select e1.sal,e1.ename
from emp e1, emp e2
where e1.sal=e2.sal and e1.empno<>e2.empno


--36����ѯԱ���Ļ�������������3-6λ�������ͻ�������
--pn:1,rn:10
select * from emp
where empno not in(select empno from(select * from emp order by sal desc) where rownum<=(1-1)*10)
and empno in(select empno from(select * from emp order by sal desc) where rownum<=10)
order by sal desc


select * from(select * from emp order by sal desc) where rownum<=20  
and empno not in(select empno from(select * from emp order by sal desc) where rownum<=(2-1)*10) 

--37����ѯԱ���Ļ�����Ϣ���������ϼ�������

select e1.ename,e2.ename
from emp e1 left outer join emp e2
on e1.mgr = e2.empno

--38����ѯԱ���Ļ�����Ϣ��������������ʵ�����(����������ͬ�İ������Ⱥ����������ͬ����)
select (select count(*) from emp
 where emp.sal>e.sal or emp.sal=e.sal and nvl(emp.comm,0)>nvl(e.comm,0))+1 num,e.*
from emp e
order by num


--39����ѯ�����л������ʲ�С��2000��������ֹ1�˵Ĳ������ƺ�����
select d.dname,count(*) num
from emp e, dept d
where e.deptno = d.deptno and e.sal>=2000
group by d.dname
having count(*)>1
order by count(*) desc
