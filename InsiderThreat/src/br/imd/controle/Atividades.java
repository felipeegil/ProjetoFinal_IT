package br.imd.controle;

import java.util.ArrayList;

public class Atividades extends LeituraLog {

	private String idAtividade;
	private Device deviceUsado;

	// Where to calculate the hourly access counts.
	private int[] hourCounts;
	private LeituraLog leitor;

	private ArrayList<String> dados = new ArrayList<String>();

	public void logAnalyzer(){
		hourCounts = new int[24];
		leitor = new LeituraLog();
	}

	public void analyzeHourlyData(){
		while(leitor.hasMoreEntries()){
			LogEntry entry = leitor.nextEntry();
			int hour = entry.getHour();
			hourCounts[hour]++;
		}
	}
	/**
	 * Print the hourly counts.
	 * These should have been set with a prior
	 * call to analyzeHourlyData.
	 */
	public void printHourlyCounts()
	{
		System.out.println("Hr: Count");
		for(int hour = 0; hour < hourCounts.length; hour++) {
			System.out.println(hour + ": " + hourCounts[hour]);
		}
	}
	/**
	 * Print the lines of data read by the LogfileReader
	 */
	public void printData()
	{
		leitor.printData();
	}

	/**
	 * Return the number of accesses recorded in the log
	 * file.
	 */
	public int numberOfAccesses()
	{
		int total = 0;
		// Add the value in each element of hourCounts
		// to total.
		for(int hour = 0; hour < hourCounts.length; hour++) {
			total = total + hourCounts[hour];
		}
		return total;
	}

	public int busiestHour()
	{
		int numberOfAccessesAtBusiest = 0;
		int busiestHour = 0;
		int index = 0;

		while(index < hourCounts.length - 1){
			if (numberOfAccessesAtBusiest < hourCounts[index]){
				busiestHour = index;
				numberOfAccessesAtBusiest = hourCounts[index];
				index++;
			}
			else {
				index++;
			}
		}
		return busiestHour;
	}

	public int quietestHour()
	{
		int numberOfAccessesAtQuietest = 9999;
		int quietestHour = 0;
		int index = 0;

		while(index < hourCounts.length - 1){
			if (numberOfAccessesAtQuietest > hourCounts[index]){
				quietestHour = index;
				numberOfAccessesAtQuietest = hourCounts[index];
				index++;
			}
			else {
				index++;
			}
		}
		return quietestHour;
	}

	public int twobusiestHour()
	{
		int numberOfAccessesAtBusiest = 0;
		int busiestHour = 0;
		int index = 0;

		while(index < hourCounts.length - 1){
			if (numberOfAccessesAtBusiest < hourCounts[index] + hourCounts[index + 1]){
				busiestHour = index;
				numberOfAccessesAtBusiest = hourCounts[index] + hourCounts[index + 1];
				index++;
			}
			else {
				index++;
			}
		}
		return busiestHour;
	}          



	public void acaoUsuario(){
		if(idAtividade == ACTIVITY_DEVICE){
			if(ACTIVITY_DEVICE == connect){
				dados.add(idAtividade);
				insert();
			}
			if(ACTIVITY_DEVICE == disconnect){
				dados.add(idAtividade);	
				insert();
			}else{
				System.out.println("ID incorreto");
			}
		}
		if(idAtividade == ACTIVITY_LOGON){
			if(ACTIVITY_LOGON == logon){
				dados.add(idAtividade);
				logon();
			}
			if(ACTIVITY_LOGON == logoff){
				dados.add(idAtividade);
				logon();
			}else{
				System.out.println("ID incorreto");
			}
		}

	}

	private boolean insert(boolean acao){
		if(acao == true){
			return connect;
		}else{
			return disconnect;
		}
	}

	private boolean logon(boolean acao){
		if(acao == true){
			return logon;
		}else{
			return logoff;
		}
	}

	private void email(){
		ArrayList<Usuario> email = new ArrayList<Usuario>();

	}

	/*private void file(){}*/

	private boolean http(boolean acesso){
		if(acesso == true){
			return on;
		}else{
			return off;
		}
	}

	public String getIdAtividade() {
		return idAtividade;
	}
	public void setIdAtividade(String idAtividade) {
		this.idAtividade = idAtividade;
	}
	public Device getDeviceUsado() {
		return deviceUsado;
	}
	public void setDeviceUsado(Device deviceUsado) {
		this.deviceUsado = deviceUsado;
	}
}