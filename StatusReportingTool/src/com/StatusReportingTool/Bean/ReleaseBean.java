package com.StatusReportingTool.Bean;

public class ReleaseBean {
	private int releaseID;
	private int id;
	private String fnfID;
	private String resourceID;
	private String item;
	private String analysisDesign;
	private String dev;
	private String test;
	private String cab;
	private String supporting;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getReleaseID() {
		return releaseID;
	}
	public void setReleaseID(int releaseID) {
		this.releaseID = releaseID;
	}
	public String getFnfID() {
		return fnfID;
	}
	public void setFnfID(String fnfID) {
		this.fnfID = fnfID;
	}
	public String getResourceID() {
		return resourceID;
	}
	public void setResourceID(String resourceID) {
		this.resourceID = resourceID;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getAnalysisDesign() {
		return analysisDesign;
	}
	public void setAnalysisDesign(String analysisDesign) {
		this.analysisDesign = analysisDesign;
	}
	public String getDev() {
		return dev;
	}
	public void setDev(String dev) {
		this.dev = dev;
	}
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	public String getCab() {
		return cab;
	}
	public void setCab(String cab) {
		this.cab = cab;
	}
	public String getSupporting() {
		return supporting;
	}
	public void setSupporting(String supporting) {
		this.supporting = supporting;
	}

}
