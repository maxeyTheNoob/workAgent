package agent.pojo;

public class work {
    private Integer workId;

    private business workBus;

    private Integer workMajor;

    private Integer workExp;

    private String workDet;

    private Integer workSal;

    private Integer workSta;//0未开始  1进行中  2完成

	public work(Integer workId, business workBus, Integer workMajor, Integer workExp, String workDet, Integer workSal,
			Integer workSta) {
		super();
		this.workId = workId;
		this.workBus = workBus;
		this.workMajor = workMajor;
		this.workExp = workExp;
		this.workDet = workDet;
		this.workSal = workSal;
		this.workSta = workSta;
	}

	public work(business workBus, Integer workMajor, Integer workExp, String workDet, Integer workSal,
			Integer workSta) {
		super();
		this.workBus = workBus;
		this.workMajor = workMajor;
		this.workExp = workExp;
		this.workDet = workDet;
		this.workSal = workSal;
		this.workSta = workSta;
	}

	public work() {
		super();
	}

	public Integer getWorkId() {
		return workId;
	}

	public void setWorkId(Integer workId) {
		this.workId = workId;
	}

	public business getWorkBus() {
		return workBus;
	}

	public void setWorkBus(business workBus) {
		this.workBus = workBus;
	}

	public Integer getWorkMajor() {
		return workMajor;
	}

	public void setWorkMajor(Integer workMajor) {
		this.workMajor = workMajor;
	}

	public Integer getWorkExp() {
		return workExp;
	}

	public void setWorkExp(Integer workExp) {
		this.workExp = workExp;
	}

	public String getWorkDet() {
		return workDet;
	}

	public void setWorkDet(String workDet) {
		this.workDet = workDet;
	}

	public Integer getWorkSal() {
		return workSal;
	}

	public void setWorkSal(Integer workSal) {
		this.workSal = workSal;
	}

	public Integer getWorkSta() {
		return workSta;
	}

	public void setWorkSta(Integer workSta) {
		this.workSta = workSta;
	}

	@Override
	public String toString() {
		return "work [workId=" + workId + ", workBus=" + workBus + ", workMajor=" + workMajor + ", workExp=" + workExp
				+ ", workDet=" + workDet + ", workSal=" + workSal + ", workSta=" + workSta + "]";
	}


    
}