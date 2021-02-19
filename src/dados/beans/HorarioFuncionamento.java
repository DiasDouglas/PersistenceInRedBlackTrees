package dados.beans;

public class HorarioFuncionamento {
	private int horaInicio;
	private int horaFim;
	
	public HorarioFuncionamento(int inicio, int fim){
		this.horaInicio = inicio;
		this.horaFim = fim;
	}

	public int getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(int horaInicio) {
		this.horaInicio = horaInicio;
	}

	public int getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(int horaFim) {
		this.horaFim = horaFim;
	}
	
	public String toString(){
		return "\n\tAbertura: " + getHoraInicio() + "h\n"
				+ "\tFechamento: " + getHoraFim() + "h";
	}
}
