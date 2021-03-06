package com.calendar.vo;

public class CalendarJoinDto {

	/**번호*/
	private int no;
	/**입사자명*/
	private String name;
	/**부서넘버*/
	private String division;
	/**사원번호*/
	private String empNo;
	/**직위넘버*/
	private String position;
	/**성별*/
	private String gender;
	/**입사일*/
	private String joinDate;
	/**이메일*/
	private String email;
	/**계정*/
	private String id;
	/**내선번호*/
	private String ext;
	/**회사전화번호*/
	private String office_number;
	/**직위명*/
	private String posNm;
	/**부서명*/
	private String divNm;
	/**좌석*/
	private String seat;	
	
	private int basic_dept;
	private int first_dept;
	private int second_dept;
	private int three_dept;
	private int four_dept;
	/**최초등록작업자이름*/
	private String fstRgtWkrNm;
	/**최초등록일시*/
	private String fstRgtDtm;
	/**최종변경작업자이름*/
	private String lstMdfWkrNm;
	/**최종변경일시*/
	private String lstMdfDtm;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFstRgtWkrNm() {
		return fstRgtWkrNm;
	}
	public void setFstRgtWkrNm(String fstRgtWkrNm) {
		this.fstRgtWkrNm = fstRgtWkrNm;
	}
	public String getFstRgtDtm() {
		return fstRgtDtm;
	}
	public void setFstRgtDtm(String fstRgtDtm) {
		this.fstRgtDtm = fstRgtDtm;
	}
	public String getLstMdfWkrNm() {
		return lstMdfWkrNm;
	}
	public void setLstMdfWkrNm(String lstMdfWkrNm) {
		this.lstMdfWkrNm = lstMdfWkrNm;
	}
	public String getLstMdfDtm() {
		return lstMdfDtm;
	}
	public void setLstMdfDtm(String lstMdfDtm) {
		this.lstMdfDtm = lstMdfDtm;
	}
	public String getPosNm() {
		return posNm;
	}
	public void setPosNm(String posNm) {
		this.posNm = posNm;
	}
	public String getDivNm() {
		return divNm;
	}
	public void setDivNm(String divNm) {
		this.divNm = divNm;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	
	public String getExt() {
		return ext;
	}
	public void setExt(String ext) {
		this.ext = ext;
	}
	public String getOffice_number() {
		return office_number;
	}
	public void setOffice_number(String office_number) {
		this.office_number = office_number;
	}
	public int getBasic_dept() {
		return basic_dept;
	}
	public void setBasic_dept(int basic_dept) {
		this.basic_dept = basic_dept;
	}
	public int getFirst_dept() {
		return first_dept;
	}
	public void setFirst_dept(int first_dept) {
		this.first_dept = first_dept;
	}
	public int getSecond_dept() {
		return second_dept;
	}
	public void setSecond_dept(int second_dept) {
		this.second_dept = second_dept;
	}
	public int getThree_dept() {
		return three_dept;
	}
	public void setThree_dept(int three_dept) {
		this.three_dept = three_dept;
	}
	public int getFour_dept() {
		return four_dept;
	}
	public void setFour_dept(int four_dept) {
		this.four_dept = four_dept;
	}
	@Override
	public String toString() {
		return "CalendarJoinDto [no=" + no + ", name=" + name + ", division=" + division + ", empNo=" + empNo
				+ ", position=" + position + ", gender=" + gender + ", joinDate=" + joinDate + ", email=" + email
				+ ", id=" + id + ", ext=" + ext + ", office_number=" + office_number + ", posNm=" + posNm + ", divNm="
				+ divNm + ", seat=" + seat + ", basic_dept=" + basic_dept + ", first_dept=" + first_dept
				+ ", second_dept=" + second_dept + ", three_dept=" + three_dept + ", four_dept=" + four_dept
				+ ", fstRgtWkrNm=" + fstRgtWkrNm + ", fstRgtDtm=" + fstRgtDtm + ", lstMdfWkrNm=" + lstMdfWkrNm
				+ ", lstMdfDtm=" + lstMdfDtm + "]";
	}
	
	
	
	
	
	
	
	
}
