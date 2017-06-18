package br.imd.controle;

import java.util.ArrayList;

import br.imd.visao.InterfaceUI;

/**
 * Método principal sem interface gráfica
 */

public class Main extends LeituraLog{
	public static void main(String[] args) {
		InterfaceUI insiderThreat = new InterfaceUI();
		insiderThreat.montaTela();
		
		String csvLogon = ("Dados/logon-sumarizado.csv");
		String csvDevice = ("Dados/device.csv");
		String csvHTTP = ("Dados/http-sumarizado.csv");
		String csvLDAP = ("Dados/ldap.csv");

		leituraArquivoLDAP(csvLDAP);
		leituraArquivoLogon(csvLogon);
		leituraArquivoDevice(csvDevice);
		leituraArquivoHTTP(csvHTTP);
		}
}