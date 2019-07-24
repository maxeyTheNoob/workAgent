package agent.pojo;

public class employee {
    private Integer empId;

    private String empName;

    private String empSex;

    private Integer empExp;

    private Integer empSta;//0���� 1�ɳ�

    private Integer empMajor;//1���б�ҵ  2ְ�߱�ҵ  3���б�ҵ  4��ר��ҵ  5���Ʊ�ҵ  6˶ʿ��ҵ

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