package br.imd.controle;

public class Atividades extends RespostaLog{

	private String idAtividade;
	private Device deviceUsado;

	
	public void logAnalyzer(){
		LeituraLog leitor = new LeituraLog();
	}

	public void acaoUsuario(){
		if(idAtividade == ACTIVITY_DEVICE){
			if(deviceActivity == connect){
				
			}
			if(deviceActivity == disconnect){

			}else{
				System.out.println("ID incorreto");
			}
		}
		if(idAtividade == ACTIVITY_LOGON){
			if(logonActivity == logon){
			}
			if(logonActivity == logoff){
			}else{
				System.out.println("ID incorreto");
			}
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