package com.emp.vo;

public class SeatDto {

	private String dCode;
	private String division;
	private String count;
	private String office;
	private String color;
	
	public String getdCode() {
		return dCode;
	}
	public void setdCode(String dCode) {
		this.dCode = dCode;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "SeatDto [dCode=" + dCode + ", division=" + division + ", count=" + count + ", office=" + office
				+ ", color=" + color + "]";
	}
	
	
}
