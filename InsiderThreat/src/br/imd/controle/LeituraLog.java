package br.imd.controle;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LeituraLog {
	
	private ArrayList<String> entrada;
	private ArrayList<String> acaoUsuario;
	BufferedReader leitor = null;
	String line = "";
	String csvSplitBy = ",";
	leitor = new BufferedReader(new FileReader(csvFile));
	
	public void leituraArquivo(){
		String csvFile = "/home/clara/Documents/UFRN/Linguagem de Programacao II/2017.1/ProjetoFinal_IT/Dados/logon-sumarizado.csv";
		
		try{
			
			this.leitor = new BufferedReader(new FileReader(csvFile));
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		} finally{
			if(leitor != null){
				try{
					leitor.close();
				}catch (IOException e){
					e.printStackTrace();
				}
			}
		}	
	}	

	
	public void respostaArquivo() throws IOException{
		while((line = leitor.readLine()) != null){
			String[] logonUsuario = line.split(csvSplitBy);
			
			System.out.println("Usuario: [id = " + logonUsuario[0] + "]" + " [Date: = " + logonUsuario[1] + "]" + " [User = " + logonUsuario[2] + "]" + " [PC = " + logonUsuario[3] + "]" + " [Activity = " + logonUsuario[4] + "]");
		}
	}
}