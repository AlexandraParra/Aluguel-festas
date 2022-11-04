package aluguelFestas.dominio.entidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Cliente {

	private String nome;
	private String telefone;
	private Date dataCadastro;
	private boolean clienteAntigo = false;
	private List<Aluguel> alugueis = new ArrayList<>();
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Cliente() {
	}

	public Cliente(String nome, String telefone, Date dataCadastro) {
		this.nome = nome;
		this.telefone = telefone;
		this.dataCadastro = dataCadastro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	public boolean isClienteAntigo() {
		return clienteAntigo;
	}
	
	public void adicionarAluguel(Aluguel aluguel) {
		alugueis.add(aluguel);
	}
	
	public void removerAluguel(Aluguel aluguel) {
		alugueis.remove(aluguel);
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataCadastro, nome, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(dataCadastro, other.dataCadastro) && Objects.equals(nome, other.nome)
				&& Objects.equals(telefone, other.telefone);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("-------------------------CLIENTE-------------------------\n");
		sb.append(nome);
		sb.append(", telefone: ");
		sb.append(telefone);
		sb.append(", data de cadastro: ");
		sb.append(sdf.format(dataCadastro));
		sb.append("\n\n---------------------DADOS DOS ALUGUÉIS---------------------\n");
		sb.append(alugueis.toString());
		
		return  sb.toString();
	}
	
	public void validarClienteAntigo() {
		Date dataAtual = new Date();
		long diff = dataAtual.getTime() - dataCadastro.getTime();
		long diasAntiguidade = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		if (diasAntiguidade>=365) {
			clienteAntigo = true;
			alugueis.forEach(aluguel -> {
				aluguel.fazerDesconto();
			});
		}
	}
}
