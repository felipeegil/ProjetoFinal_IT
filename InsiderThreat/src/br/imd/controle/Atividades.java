package br.imd.controle;

/**
 * 
 * @author Ana Clara e Felipe Gilberto
 * Classe Atividades
 *
 */

public class Atividades{

	private String connect = "Connect";
	private String logon = "Logon";
	private String access;
	private int day, month, year, hour, minute, second;
	private String pc;
	private boolean usedLogon = false;
	private boolean usedConnect = false;
	private boolean usedHttp = false;

	/**
	 * Método setDate
	 * @param day
	 * @param month
	 * @param year
	 * @param hour
	 * @param minute
	 * @param second
	 * @return void
	 */

	public void setDate(int day, int month, int year, int hour, int minute, int second){
		this.day = day;
		this.month = month;
		this.year = year;
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

	//public getDate(){} Discutir a forma de devolver

	/**
	 * Método setDevice para verificar se a atividade do usuário é "connect" ou "disconnect"
	 * @param activity
	 * @return void
	 */

	public void setDevice(String activity){
		usedConnect = true;
		if(activity.equals(connect)){
			this.connect = "Connected";
		}else{
			this.connect = "Disconnected";
		}
	}

	/**
	 * Método getDevice
	 * @return connect
	 */

	public String getDevice(){
		return connect;
	}

	/**
	 * Método setLogon para verificar se a atividade de login é "logon" ou "logoff"
	 * @param activity
	 */

	public void setLogon(String activity){
		usedLogon = true;
		if(activity.equals(logon)){
			this.logon = "Logon";
		}else{
			this.logon = "Logoff";
		}
	}

	/**
	 * Método getLogon
	 * @return logon
	 */

	public String getLogon(){
		return logon;
	}

	/**
	 * Método setHttp
	 * @param site
	 * @return void
	 */

	public void setHttp(String site){
		usedHttp = true;
		this.access = site;
	}

	/**
	 * Método getHttp
	 * @return access
	 */

	public String getHttp(){
		return access;
	}

	/**
	 * Método setPc
	 * @param pc
	 * @return void
	 */

	public void setPc(String pc){
		this.pc = pc;
	}
	/**
	 * Método getPc
	 * @return pc
	 */
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