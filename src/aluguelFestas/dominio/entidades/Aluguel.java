package aluguelFestas.dominio.entidades;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;

import aluguelFestas.dominio.excepcoes.DominioExcecao;

public class Aluguel {

	private Date dataFesta;
	private LocalTime horarioInicio;
	private LocalTime horarioTermino;
	private double valorCobrado;
	private Endereco endereco;
	private Tema tema;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Aluguel() {
	}

	public Aluguel(Date dataFesta, LocalTime horarioInicio, LocalTime horarioTermino,
			Endereco endereco, Tema tema) throws DominioExcecao {
		this.dataFesta = dataFesta;
		this.horarioInicio = horarioInicio;
		this.horarioTermino = horarioTermino;
		this.endereco = endereco;
		this.tema = tema;
		this.valorCobrado = tema.getValorAluguel();
	}

	public Date getDataFesta() {
		return dataFesta;
	}

	public void setDataFesta(Date dataFesta) {
		this.dataFesta = dataFesta;
	}

	public LocalTime getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(LocalTime horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public LocalTime getHorarioTermino() {
		return horarioTermino;
	}

	public void setHorarioTermino(LocalTime horarioTermino) {
		this.horarioTermino = horarioTermino;
	}
	
	public double getValorCobrado() {
		return valorCobrado;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataFesta, endereco, horarioInicio, horarioTermino, valorCobrado);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluguel other = (Aluguel) obj;
		return Objects.equals(dataFesta, other.dataFesta) && Objects.equals(endereco, other.endereco)
				&& Objects.equals(horarioInicio, other.horarioInicio)
				&& Objects.equals(horarioTermino, other.horarioTermino) && Objects.equals(valorCobrado, other.valorCobrado);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(tema);
		sb.append("\n");
		sb.append(endereco);
		sb.append("Data da festa: ");
		sb.append(sdf.format(dataFesta));
		sb.append(", horário de início: ");
		sb.append(horarioInicio);
		sb.append(", horário término: ");
		sb.append(horarioTermino);
		if(valorCobrado<tema.getValorAluguel()) {
			sb.append("\n\nParabéns você ganhou um desconto do 5%!!!\nE o valor do aluguel fico por: R$ ");
		}else {
			sb.append("\nValor do aluguel: R$ ");
		}
		sb.append(String.format("%.2f", valorCobrado));
		
		return  sb.toString();
	}
	
	public void fazerDesconto() {
		valorCobrado = (tema.getValorAluguel() - (tema.getValorAluguel()*0.05));
	}
}
