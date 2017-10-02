package app.model;


public class ReportModel {
private int id_em;
private int Month;
private int hrs_service1;
private int hrs_service2;
public int getId_em() {
	return id_em;
}
public void setId_em(int id_em) {
	this.id_em = id_em;
}
public int getMonth() {
	return Month;
}
public void setMonth(int month) {
	Month = month;
}
public int getHrs_service1() {
	return hrs_service1;
}
public void setHrs_service1(int hrs_service1) {
	this.hrs_service1 = hrs_service1;
}
public int getHrs_service2() {
	return hrs_service2;
}
public void setHrs_service2(int hrs_service2) {
	this.hrs_service2 = hrs_service2;
}
public ReportModel(){}
public ReportModel(int id_em, int month, int hrs_service1, int hrs_service2) {
	super();
	this.id_em = id_em;
	Month = month;
	this.hrs_service1 = hrs_service1;
	this.hrs_service2 = hrs_service2;
}




}
