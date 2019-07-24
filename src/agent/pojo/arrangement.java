package agent.pojo;

import java.sql.Date;

public class arrangement {
    private Integer arraId;

    private employee arraEmp;

    private work arraWork;

    private Integer arraSta;//0未开始  1进行中  2完成  3撤销

    private Date arraOpt;

    private Date arraEdt;

	public arrangement() {
		super();
	}

	public arrangement(employee arraEmp, work arraWork, Integer arraSta, Date arraOpt, Date arraEdt) {
		super();
		this.arraEmp = arraEmp;
		this.arraWork = arraWork;
		this.arraSta = arraSta;
		this.arraOpt = arraOpt;
		this.arraEdt = arraEdt;
	}

	public arrangement(Integer arraId, employee arraEmp, work arraWork, Integer arraSta, Date arraOpt, Date arraEdt) {
		super();
		this.arraId = arraId;
		this.arraEmp = arraEmp;
		this.arraWork = arraWork;
		this.arraSta = arraSta;
		this.arraOpt = arraOpt;
		this.arraEdt = arraEdt;
	}

	public Integer getArraId() {
		return arraId;
	}

	public void setArraId(Integer arraId) {
		this.arraId = arraId;
	}

	public employee getArraEmp() {
		return arraEmp;
	}

	public void setArraEmp(employee arraEmp) {
		this.arraEmp = arraEmp;
	}

	public work getArraWork() {
		return arraWork;
	}

	public void setArraWork(work arraWork) {
		this.arraWork = arraWork;
	}

	public Integer getArraSta() {
		return arraSta;
	}

	public void setArraSta(Integer arraSta) {
		this.arraSta = arraSta;
	}

	public Date getArraOpt() {
		return arraOpt;
	}

	public void setArraOpt(Date arraOpt) {
		this.arraOpt = arraOpt;
	}

	public Date getArraEdt() {
		return arraEdt;
	}

	public void setArraEdt(Date arraEdt) {
		this.arraEdt = arraEdt;
	}

	@Override
	public String toString() {
		return "arrangement [arraId=" + arraId + ", arraEmp=" + arraEmp + ", arraWork=" + arraWork + ", arraSta="
				+ arraSta + ", arraOpt=" + arraOpt + ", arraEdt=" + arraEdt + "]";
	}

    
}