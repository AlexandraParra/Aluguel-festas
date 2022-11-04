package aluguelFestas.dominio.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import aluguelFestas.dominio.enums.CorToalha;

public class Tema implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private Double valorAluguel;
	//Cores disponíveis para as toalhas das mesas
	private CorToalha corToalha;
	private List<ItemTema> itens = new ArrayList<>();
	
	public Tema() {
	}

	public Tema(String nome, Double valorAluguel, CorToalha corToalha) {
		this.nome = nome;
		this.valorAluguel = valorAluguel;
		this.corToalha = corToalha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValorAluguel() {
		return valorAluguel;
	}

	public void setValorAluguel(Double valorAluguel) {
		this.valorAluguel = valorAluguel;
	}

	public CorToalha getCorToalha() {
		return corToalha;
	}

	public void setCorToalha(CorToalha corToalha) {
		this.corToalha = corToalha;
	}

	@Override
	public int hashCode() {
		return Objects.hash(corToalha, nome, valorAluguel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tema other = (Tema) obj;
		return corToalha == other.corToalha && Objects.equals(nome, other.nome) && Objects.equals(valorAluguel, other.valorAluguel);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n\nTEMA:\n");
		sb.append(nome);
		sb.append(", cor da toalha: ");
		sb.append(corToalha);
		sb.append(", valor do aluguel: R$");
		sb.append(String.format("%.2f", valorAluguel));
		sb.append("\nItems do tema:\n");
		sb.append(itens.toString());
		
		return  sb.toString();
	}
	
	public void adicionarItem(ItemTema item) {
		itens.add(item);
	}
	
	public void removerItem(ItemTema item) {
		itens.remove(item);
	}

	public List<ItemTema> getItems() {
		return itens;
	}
}
