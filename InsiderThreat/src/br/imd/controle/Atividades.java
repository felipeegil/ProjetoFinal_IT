package br.imd.controle;

public class Atividades{
	
	private String connect = "Connect";
	private String logon = "Logon";
	private String access;
	private int day, month, year, hour, minute, second;
	private String pc;
	private boolean usedLogon = false;
	private boolean usedConnect = false;
	private boolean usedHttp = false;
	
	public void setDate(int day, int month, int year, int hour, int minute, int second){
		this.day = day;
		this.month = month;
		this.year = year;
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	//public getDate(){} Discutir a forma de devolver
	
	public void setDevice(String activity){
		usedConnect = true;
		if(activity.equals(connect)){
			this.connect = "Connected";
		}else{
			this.connect = "Disconnected";
		}
	}
	
	public String getDevice(){
		return connect;
	}

	public void setLogon(String activity){
		usedLogon = true;
		if(activity.equals(logon)){
			this.logon = "Logon";
		}else{
			this.logon = "Logoff";
		}
	}
	
	public String getLogon(){
		return logon;
	}

	public void setHttp(String site){
		usedHttp = true;
		this.access = site;
	}
	
	public String getHttp(){
		return access;
	}
	
	public void setPc(String pc){
		this.pc = pc;
	}
	
	public String getPc(){
		return pc;
	}

	public boolean isUsedLogon() {
		return usedLogon;
	}

	public boolean isUsedConnect() {
		return usedConnect;
	}

	public boolean isUsedHttp() {
		return usedHttp;
	}
}