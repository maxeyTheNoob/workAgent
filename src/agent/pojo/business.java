package agent.pojo;

public class business {
    private Integer busId;

    private String busName;

    private String busCon;

    public business(Integer busId) {
		super();
		this.busId = busId;
	}

	public business() {
		super();
	}

	public business(Integer busId, String busName, String busCon) {
		super();
		this.busId = busId;
		this.busName = busName;
		this.busCon = busCon;
	}

	public Integer getBusId() {
        return busId;
    }

    public void setBusId(Integer busId) {
        this.busId = busId;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName == null ? null : busName.trim();
    }

    public String getBusCon() {
        return busCon;
    }

    public void setBusCon(String busCon) {
        this.busCon = busCon == null ? null : busCon.trim();
    }

	@Override
	public String toString() {
		return "business [busId=" + busId + ", busName=" + busName + ", busCon=" + busCon + "]";
	}
    
}