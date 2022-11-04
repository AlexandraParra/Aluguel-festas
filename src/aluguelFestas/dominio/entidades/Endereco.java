package aluguelFestas.dominio.entidades;

import java.util.Objects;

public class Endereco {

	private String logradouro;
	private String numero;
	private String complemento;
	private String cep;
	private String uf;
	private String cidade;
	private String bairro;

	public Endereco() {
	}

	public Endereco(String logradouro, String numero, String complemento, String cep, String uf, String cidade,
			String bairro) {
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
		this.uf = uf;
		this.cidade = cidade;
		this.bairro = bairro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBarrio(String bairro) {
		this.bairro = bairro;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bairro, cep, cidade, complemento, logradouro, numero, uf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(bairro, other.bairro) && Objects.equals(cep, other.cep)
				&& Objects.equals(cidade, other.cidade) && Objects.equals(complemento, other.complemento)
				&& Objects.equals(logradouro, other.logradouro) && Objects.equals(numero, other.numero)
				&& Objects.equals(uf, other.uf);
	}

	@Override
	public String toString() {
		return "\nEndereço:\nLogradouro: " + logradouro + ", número: " + numero + ", complemento: " + complemento
				+ ",\nCEP: " + cep + ", UF: " + uf + ", cidade: " + cidade + ", bairro: " + bairro + "\n";
	}
}
