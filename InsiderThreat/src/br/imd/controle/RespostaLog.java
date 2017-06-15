package br.imd.controle;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * @author Ana Clara e Felipe Gilberto
 * Classe RespostaLog é responsável por setar todas as saídas dos arquivos lidos
 *
 */
public class RespostaLog extends Usuario{

	private static final int ID_DEVICE = 0, DATE_DEVICE = 1, USER_DEVICE = 2, PC_DEVICE = 3, ACTIVITY_DEVICE = 4;
	private static final int ID_HTTP = 0, DATE_HTTP = 1, USER_HTTP = 2, PC_HTTP = 3, ACTIVITY_HTTP = 4;
	private static final int ID_LOGON = 0, DATE_LOGON = 1, USER_LOGON = 2, PC_LOGON = 3, ACTIVITY_LOGON = 4;
	private static final int EMPLOYEE_NAME = 0, USER_ID = 1, DOMAIN = 2, EMAIL = 3, ROLE = 4;
	private static final int MES = 0, DIA = 1, ANO = 2; 
	private static final int HORA = 0, MINUTO = 1, SEGUNDO = 3;
	/**
	 * ArrayList de usuários existentes no arquivo 'ldap.csv'
	 */
	static ArrayList<Usuario> users = new ArrayList<Usuario>();
	
	/**
	 * caracteres especiais que precisamos ler das strings de cada coluna
	 * e armazenar seus valores sem esses caracteres
	 */
	String line = "";
	String divisor = ",";
	String divisor2 = "/";
	String divisor3 = ":";
	String divisor4 = "-";
	String divisor5 = " ";
	
	
	/**
	 * Método respostaArquivoLogon irá retornar as Strings existentes no arquivo
	 * 'logon-sumarizado.csv'
	 * @param leitor
	 * @throws IOException
	 */
	public static void respostaArquivoLogon(BufferedReader leitor) throws IOException{
		String line = "";
		String divisor = ",";
		String user, pc;

		while((line = leitor.readLine()) != null){
			String[] logon = line.split(divisor);
			//divisorDate(DATE_LOGON);
			user = divisorUser(logon[USER_LOGON]);
			pc = divisorPc(logon[PC_LOGON]);
			for(int i = 0; i < users.size(); i++){
				if(user.equals(users.get(i).getUser_ID())){
					users.get(i).newActivityLogon(pc, logon[ACTIVITY_LOGON]);
				}
			}
		}
	}
	/**
	 * Método respostaArquivoDevice irá armazenar em uma ArrayList os valores
	 * lidos no arquivo 'device.csv'
	 * @param leitor
	 * @throws IOException
	 */
	public static void respostaArquivoDevice(BufferedReader leitor) throws IOException{
		String line = "";
		String divisor = ",";
		String user, pc;
				
		while((line = leitor.readLine()) != null){
			String[] device = line.split(divisor);
			//divisorDate(DATE_DEVICE);
			user = divisorUser(device[USER_DEVICE]);
			pc = divisorPc(device[PC_DEVICE]);
			for(int i = 0; i < users.size(); i++){
				if(user.equals(users.get(i).getUser_ID())){
					users.get(i).newActivityDevice(pc, device[ACTIVITY_DEVICE]);
				}
			}	
		}
	}
	/**
	 * Método irá retornar os sites acessados pelo usuário
	 * @param leitor
	 * @throws IOException
	 */
	public static void respostaArquivoHTTP(BufferedReader leitor) throws IOException{
		String line = "";
		String divisor = ",";
		String user, pc;
				
		while((line = leitor.readLine()) != null){
			String[] http = line.split(divisor);
			//divisorDate(DATE_HTTP);
			user = divisorUser(http[USER_HTTP]);
			pc = divisorPc(http[PC_HTTP]);
			for(int i = 0; i < users.size(); i++){
				if(user.equals(users.get(i).getUser_ID())){
					users.get(i).newActivityHttp(pc, http[ACTIVITY_HTTP]);
				}
			}
			for(int i = 0; i < users.size(); i++){
				System.out.println("Usuario: " + users.get(i).getUser_ID() +" Nome: " + users.get(i).getName());
				users.get(i).imprimirAtividades();
			}
		}		
	}
	/**
	 * Método respostaArquivoLDAP irá retornar os dados dos usuários existentes
	 * @param leitor
	 * @throws IOException
	 */
	public static void respostaArquivoLDAP(BufferedReader leitor) throws IOException{
		String line = "";
		String divisor = ",";
		
		while((line = leitor.readLine()) != null){
			String[] ldap = line.split(divisor);
			Usuario novo = new Usuario();
			novo.setUsuario(ldap[EMPLOYEE_NAME], ldap[USER_ID], ldap[DOMAIN], ldap[EMAIL], ldap[ROLE]);
			users.add(novo);
		}
	}
	/**
	 * Método divisorDate irá armazenar as datas excluindo os caracteres especiais
	 * @param date
	 */
	public static void divisorDate(ArrayList<String> date){
		String divisor2 = "/";
		String divisor3 = ":";
		String divisor5 = " ";
		ArrayList<String> diasDate = new ArrayList<String>();
		ArrayList<String> horasDate = new ArrayList<String>();
		String input;
		
		for (int i = 1; i < date.size(); i++){
			input = date.get(i);
			Scanner s = new Scanner(input).useDelimiter(divisor5);
			diasDate.add(s.next());
			horasDate.add(s.next());
		}
		
		
		for (int i = 0; i < diasDate.size(); i++){
			input = diasDate.get(i);
			Scanner s = new Scanner(input).useDelimiter(divisor2);
			
		}
		
		
		/*for (int i = 0; i < date.size(); i++){
			String[] data = line.split(divisor3);
			int valor = Integer.parseInt(data[HORA]);
			[valor]++;
			valor = Integer.parseInt(data[DIA]);
			dias[valor]++;
		*/
	}
	/**
	 * Método divisorUser irá retornar o usuário excluindo a String 'DTAA'
	 * @param user
	 * @return
	 */
	public static String divisorUser(String user){
		String divisor2 = "/";
		Scanner s = new Scanner(user).useDelimiter(divisor2);
		user = s.next();
		user = s.next();
		s.close();
		return user;
	}
		
	
	public static String divisorPc(String pc){
		String divisor4 = "-";
		Scanner s = new Scanner(pc).useDelimiter(divisor4);
		pc = s.next();
		pc = s.next();
		s.close();
		return pc;
	}
	
	public static void imprimirCampo(ArrayList<String> campo){
		for (int i = 0; i < campo.size(); i++){
			System.out.println(campo.get(i));
		}
	}
		
	public static void imprimirLista(ArrayList<Usuario> lista){
		for (int i = 1; i < lista.size(); i++){
			System.out.println("UserID: "+ lista.get(i).getName());
		}
	}
}