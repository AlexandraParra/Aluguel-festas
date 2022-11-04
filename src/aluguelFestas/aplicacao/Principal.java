package aluguelFestas.aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import aluguelFestas.dominio.entidades.Aluguel;
import aluguelFestas.dominio.entidades.Cliente;
import aluguelFestas.dominio.entidades.Endereco;
import aluguelFestas.dominio.entidades.ItemTema;
import aluguelFestas.dominio.entidades.Tema;
import aluguelFestas.dominio.enums.CorToalha;
import aluguelFestas.dominio.excepcoes.DominioExcecao;

public class Principal {

	public static void main(String[] args) {
		try {
			Locale.setDefault(Locale.US);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Scanner sc = new Scanner(System.in);
			char resposta;
			int opcao;
			//Lista de temas para apresentar para o cliente
			List<Tema> temas = new ArrayList<>();
			
			//Instâncias dos items para os temas
			ItemTema item1 = new ItemTema(1L, "Painel Rosa", "Painel redondo");
			ItemTema item2 = new ItemTema(2L, "Painel Verde", "Painel redondo");
			ItemTema item3 = new ItemTema(3L, "Balão", "Balão bexiga número 9");
			ItemTema item4 = new ItemTema(4L, "Kit suportes", "Kit suportes c/ 3suportes para doces");
			ItemTema item5 = new ItemTema(5L, "Cortina", "Cortina infantil");
			ItemTema item6 = new ItemTema(6L, "Suporte escadinha", "Kit suporte escadinha 2 furos e baixo para doces");
			
			//Instâncias dos temas para testar o sistema
			Tema tema1 = new Tema("Festa Rosa", 3000.0, CorToalha.rosa);
			tema1.adicionarItem(item1);
			tema1.adicionarItem(item3);
			tema1.adicionarItem(item4);
			tema1.adicionarItem(item5);
			tema1.adicionarItem(item6);
			temas.add(tema1);
			
			Tema tema2 = new Tema("Festa Infantil", 2500.0, CorToalha.verde);
			tema2.adicionarItem(item2);
			tema2.adicionarItem(item4);
			tema2.adicionarItem(item6);
			temas.add(tema2);
			
			System.out.println("-----Dados do cliente-----");
			System.out.print("Nome: ");
			String nome = sc.next();
			System.out.print("Telefone: ");
			String telefone = sc.next();
			//Se tiver um cadastro de pelo menos um ano, ganha 5% de desconto no valor do aluguel
			System.out.print("Data do cadastro [dd/mm/yyyy] : ");
			Date dataCadastro = sdf.parse(sc.next());
			Cliente cliente = new Cliente(nome, telefone, dataCadastro);
			
			
			do  {
				System.out.println("-----Dados do endereço-----");
				System.out.print("Logradouro: ");
				String logradouro = sc.next();
				System.out.print("Número: ");
				String numero = sc.next();
				System.out.print("Complemento: ");
				String complemento = sc.next();
				System.out.print("CEP: ");
				String cep = sc.next();
				System.out.print("UF: ");
				String uf = sc.next();
				System.out.print("Cidade: ");
				String cidade = sc.next();
				System.out.print("Bairro: ");
				String bairro = sc.next();
				Endereco endereco = new Endereco(logradouro, numero, complemento, cep, uf, cidade, bairro);
				
				System.out.println("-----Dados do aluguel-----");
				System.out.print("Data da festa [dd/mm/yyyy] : ");
				Date dataFesta = sdf.parse(sc.next());
				Date dataAtual = new Date();
				if (!dataFesta.after(dataAtual)) {
					throw new DominioExcecao ("A data da festa deve ser depois da data atual");
				}
				System.out.print("Horário de início [hh:mm] : ");
				LocalTime horarioInicio = LocalTime.parse(sc.next());
				System.out.print("Horário término [hh:mm] : ");
				LocalTime horarioTermino = LocalTime.parse(sc.next());
				if (!horarioTermino.isAfter(horarioInicio)) {
					throw new DominioExcecao ("O horário término deve ser depois do horário de entrada");
				}
				
				System.out.println("-------Escolha o tema------");
				int j = 0;
				for (int i = 1; i<=temas.size(); i++) {
					System.out.println(i + " - " + temas.get(j).getNome());
					j++;
				}
				
				opcao = sc.nextInt();
				Aluguel aluguel = null;
				switch (opcao) {
				case 1:
					aluguel = new Aluguel(dataFesta, horarioInicio, horarioTermino, endereco, tema1);
					break;
				case 2:
					aluguel = new Aluguel(dataFesta, horarioInicio, horarioTermino, endereco, tema2);
					break;
				default:
					System.out.println("Opção inválida!");
					break;
				}
				cliente.adicionarAluguel(aluguel);
				
				System.out.print("Deseja realizar outro aluguel [s/n]? ");
				resposta = sc.next().charAt(0);
			} while (resposta == 's');
			cliente.validarClienteAntigo();
			System.out.println(cliente);
			
			sc.close();
		}
		catch (DominioExcecao e){
			System.out.println("Erro ao cadastrar: " + e.getMessage());
		}
		catch(ParseException e) {
			System.out.println("Formato de data inválido");
		}
		catch(DateTimeParseException e) {
			System.out.println("Formato de horário inválido");
		}
		catch (Exception e){
			System.out.println("Erro inesperado!");
		}
	}

}
