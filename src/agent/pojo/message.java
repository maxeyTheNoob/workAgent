package agent.pojo;

public class message {
    private Integer mesId;

    private arrangement mesArra;

    private Integer mesEmp;

    private business mesBus;
    
    private Integer mesType;//0∆•≈‰…Í«Î  1≥∑œ˙Õ®÷™

    public message(Integer mesId) {
		super();
		this.mesId = mesId;
	}

	public message() {
		super();
	}

	public message(Integer mesId, arrangement mesArra, Integer mesEmp, business mesBus,Integer mesType) {
		super();
		this.mesId = mesId;
		this.mesArra = mesArra;
		this.mesEmp = mesEmp;
		this.mesBus = mesBus;
		this.mesType = mesType;
	}

	public Integer getMesId() {
        return mesId;
    }

    public void setMesId(Integer mesId) {
        this.mesId = mesId;
    }

    public arrangement getMesArra() {
        return mesArra;
    }

    public void setMesArra(arrangement mesArra) {
        this.mesArra = mesArra;
    }

    public Integer getMesEmp() {
        return mesEmp;
    }

    public void setMesEmp(Integer mesEmp) {
        this.mesEmp = mesEmp;
    }

    public business getMesBus() {
        return mesBus;
    }

    public void setMesBus(business mesBus) {
        this.mesBus = mesBus;
    }

	public Integer getMesType() {
		return mesType;
	}

	public void setMesType(Integer mesType) {
		this.mesType = mesType;
	}

	@Override
	public String toString() {
		return "message [mesId=" + mesId + ", mesArra=" + mesArra + ", mesEmp=" + mesEmp + ", mesBus=" + mesBus
				+ ", mesType=" + mesType + "]";
	}

	
    
}