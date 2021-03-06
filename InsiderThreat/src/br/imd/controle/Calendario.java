package br.imd.controle;

import java.util.ArrayList;
/**
 * Classe Calendário
 * @author Ana Clara e Felipe Gilberto
 *
 */
public class Calendario {
	private ArrayList<Ano> anos;
	/**
	 * Método Construtor
	 */
	public Calendario(){
		anos = new ArrayList<Ano>();
		for(int i = 2010; i <= 2018; i++){
			anos.add(new Ano(i));
		}
	}
	/**
	 * Método newActivity
	 * @param activity
	 */
	public void newActivity(Atividade activity){
		for (int i = 0; i < anos.size(); i++) {
			if(anos.get(i).getAno() == activity.getYear()){
				anos.get(i).newActivity(activity);
				break;
			}
		}
	}
	/**
	 * Método do tipo String getYearValores
	 * @param year
	 * @param month
	 * @param day
	 * @return anos.get(i).getMonthValors(month, day)
	 */
	public String getYearValors(int year, int month, int day){
		for (int i = 0; i < anos.size(); i++) {
			if(anos.get(i).getAno() == year){
				return anos.get(i).getMonthValors(month, day);
			}
		}
		return "";
	}
	/**
	 * Método getYearCounter
	 * @param year
	 * @param month
	 * @param day
	 * @return anos.get(i).getMonthCounter(month,day)
	 */
	public int getYearCounter(int year, int month, int day){
		for(int i = 0; i < anos.size(); i++){
			if(anos.get(i).getAno() == year){
				return anos.get(i).getMonthCounter(month, day);
			}
		}
		return -1;
	}
	/**
	 * Método getYearCounterConnect
	 * @param year
	 * @param month
	 * @param day
	 * @return anos.get(i).getMonthCounterConnect(month, day) ou -1
	 */
	public int getYearCounterConnect(int year, int month, int day){
		for(int i = 0; i < anos.size(); i++){
			if(anos.get(i).getAno() == year){
				return anos.get(i).getMonthCounterConnect(month, day);
			}
		}
		return -1;
	}
	/**
	 * Método getYearCounterDisconnect
	 * @param year
	 * @param month
	 * @param day
	 * @return anos.get(i).getMonthCounterDisconnect(month, day) ou -1
	 */
	public int getYearCounterDisconnect(int year, int month, int day){
		for(int i = 0; i < anos.size(); i++){
			if(anos.get(i).getAno() == year){
				return anos.get(i).getMonthCounterDisconnect(month, day);
			}
		}
		return -1;
	}
	/**
	 * Método getYearCounterLogon
	 * @param year
	 * @param month
	 * @param day
	 * @return anos.get(i).getMonthCounterLogon(month, day)
	 */
	public int getYearCounterLogon(int year, int month, int day){
		for(int i = 0; i < anos.size(); i++){
			if(anos.get(i).getAno() == year){
				return anos.get(i).getMonthCounterLogon(month, day);
			}
		}
		return -1;
	}
	/**
	 * Método getYearCounterLogoff
	 * @param year
	 * @param month
	 * @param day
	 * @return anos.get(i).getMonthCounterLogoff(month, day) ou -1
	 */
	public int getYearCounterLogoff(int year, int month, int day){
		for(int i = 0; i < anos.size(); i++){
			if(anos.get(i).getAno() == year){
				return anos.get(i).getMonthCounterLogoff(month, day);
			}
		}
		return -1;
	}
	/**
	 * Método getYearCounterHttp
	 * @param year
	 * @param month
	 * @param day
	 * @return anos.get(i).getMonthCounterHttp(month, day) ou -1
	 */
	public int getYearCounterHttp(int year, int month, int day){
		for(int i = 0; i < anos.size(); i++){
			if(anos.get(i).getAno() == year){
				return anos.get(i).getMonthCounterHttp(month, day);
			}
		}
		return -1;
	}
}