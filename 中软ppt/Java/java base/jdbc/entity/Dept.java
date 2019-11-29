package entity;

//每一个数据表都要对应一个实体类，表中的列对应实体类的属性
public class Dept {
	private Integer deptno;//数据类型必须用包装类型
	private String dname;
	private String loc;
	
	public Dept() {
		super();
	}
	public Dept(Integer deptno, String dname, String loc) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}
	
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
}
