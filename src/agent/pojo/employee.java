package agent.pojo;

public class employee {
    private Integer empId;

    private String empName;

    private String empSex;

    private Integer empExp;

    private Integer empSta;//0空闲 1派出

    private Integer empMajor;//1初中毕业  2职高毕业  3高中毕业  4大专毕业  5本科毕业  6硕士毕业

    public employee(Integer empId) {
		super();
		this.empId = empId;
	}

	public employee() {
		super();
	}

	public employee(Integer empId, String empName, String empSex, Integer empExp, Integer empSta, Integer empMajor) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSex = empSex;
		this.empExp = empExp;
		this.empSta = empSta;
		this.empMajor = empMajor;
	}

	public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName == null ? null : empName.trim();
    }

    public String getEmpSex() {
        return empSex;
    }

    public void setEmpSex(String empSex) {
        this.empSex = empSex == null ? null : empSex.trim();
    }

    public Integer getEmpExp() {
        return empExp;
    }

    public void setEmpExp(Integer empExp) {
        this.empExp = empExp;
    }

    public Integer getEmpSta() {
        return empSta;
    }

    public void setEmpSta(Integer empSta) {
        this.empSta = empSta;
    }

    public Integer getEmpMajor() {
        return empMajor;
    }

    public void setEmpMajor(Integer empMajor) {
        this.empMajor = empMajor;
    }

	@Override
	public String toString() {
		return "employee [empId=" + empId + ", empName=" + empName + ", empSex=" + empSex + ", empExp=" + empExp
				+ ", empSta=" + empSta + ", empMajor=" + empMajor + "]";
	}
    
}