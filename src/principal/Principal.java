package principal;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import funcionario.Funcionario;

public class Principal {

	public static void main(String[] args) {
		
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		
		BigDecimal salario;
		
		System.out.println("3.1: Inserir todos os funcionários, na mesma ordem e informações da tabela acima.");
		System.out.println("");
		
		salario = new BigDecimal("2009.44");
		Funcionario f1 = new Funcionario("Maria", LocalDate.of(2000, 10, 18), salario, "Operador");
		funcionarios.add(f1);
		
		salario = new BigDecimal("2284.38");
		Funcionario f2 = new Funcionario("João", LocalDate.of(1990, 05, 12), salario, "Operador");
		funcionarios.add(f2);
		
		salario = new BigDecimal("9836.14");
		Funcionario f3 = new Funcionario("Caio", LocalDate.of(1961, 05, 02), salario, "Coordenador");
		funcionarios.add(f3);
		
		salario = new BigDecimal("19119.88");
		Funcionario f4 = new Funcionario("Miguel", LocalDate.of(1988, 10, 14), salario, "Diretor");
		funcionarios.add(f4);
		
		salario = new BigDecimal("2234.68");
		Funcionario f5 = new Funcionario("Alice", LocalDate.of(1995, 01, 05), salario, "Recepcionista");
		funcionarios.add(f5);
		
		salario = new BigDecimal("1582.72");
		Funcionario f6 = new Funcionario("Heitor", LocalDate.of(1999, 11, 19), salario, "Operador");
		funcionarios.add(f6);
		
		salario = new BigDecimal("4071.84");
		Funcionario f7 = new Funcionario("Arthur", LocalDate.of(1993, 03, 31), salario, "Contador");
		funcionarios.add(f7);
		
		salario = new BigDecimal("3017.45");
		Funcionario f8 = new Funcionario("Laura", LocalDate.of(1994, 07, 8), salario, "Gerente");
		funcionarios.add(f8);
		
		salario = new BigDecimal("1608.85");
		Funcionario f9 = new Funcionario("Heloísa", LocalDate.of(2003, 05, 24), salario, "Eletricista");
		funcionarios.add(f9);
		
		salario = new BigDecimal("2799.93");
		Funcionario f10 = new Funcionario("Helena", LocalDate.of(1996, 9, 02), salario, "Gerente");
		funcionarios.add(f10);
		
		System.out.println("3.2: Remover o funcionário “João” da lista.");
		System.out.println("");
		
		funcionarios.removeIf(t -> t.getNome() == "João");
		
		System.out.println("3.3: Imprimir todos os funcionários com todas suas informações, sendo que:\r\n"
				+ "• informação de data deve ser exibido no formato dd/mm/aaaa;\r\n"
				+ "• informação de valor numérico deve ser exibida no formatado com separador de milhar como ponto e decimal como vírgula.");
		System.out.println("");
		
		System.out.println("---------------------------------------------------------");
        System.out.printf("%10s%20s%10s%10s", "NOME | ", "DATA DE NASCIMENTO | ", "SALÁRIO | ", "FUNÇÃO | ");
        System.out.println();
        System.out.println("---------------------------------------------------------");
        for(Funcionario func:funcionarios) {
        	System.out.format("%10s%20s%10s%10s",
        			func.getNome() + " | ", func.formatDate(func.getDataNascimento()) + " | ", func.formatSalary(func.getSalario()) + " | ", func.getFuncao() + " | ");
        	System.out.println();
        }
        System.out.println("---------------------------------------------------------");
		
		System.out.println("3.4: Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.");
		System.out.println("");
		
		for(Funcionario func:funcionarios) {
			BigDecimal tenPercent = new BigDecimal("1.1");
			func.setSalario(func.getSalario().multiply(tenPercent));
		}
		
		System.out.println("3.5: Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.");
		System.out.println("");
		
		Map<String, List<Funcionario>> mapa = new HashMap<String, List<Funcionario>>();
		
		List<Funcionario> operadores = new ArrayList<Funcionario>();
		List<Funcionario> coordenadores = new ArrayList<Funcionario>();
		List<Funcionario> diretores = new ArrayList<Funcionario>();
		List<Funcionario> recepcionistas = new ArrayList<Funcionario>();
		List<Funcionario> gerentes = new ArrayList<Funcionario>();
		List<Funcionario> contadores = new ArrayList<Funcionario>();
		List<Funcionario> eletricistas = new ArrayList<Funcionario>();
		
		for(Funcionario func:funcionarios) {
			if (func.getFuncao() == "Operador") {
				operadores.add(func);
			}
			if (func.getFuncao() == "Coordenador") {
				coordenadores.add(func);
			}
			if (func.getFuncao() == "Diretor") {
				diretores.add(func);
			}
			if (func.getFuncao() == "Recepcionista") {
				recepcionistas.add(func);
			}
			if (func.getFuncao() == "Contador") {
				contadores.add(func);
			}
			if (func.getFuncao() == "Gerente") {
				gerentes.add(func);
			}
			if (func.getFuncao() == "Eletricista") {
				eletricistas.add(func);
			}
		}

		mapa.put("Operador", operadores);
		mapa.put("Coordenador", coordenadores);
		mapa.put("Diretor", diretores);
		mapa.put("Recepcionista", recepcionistas);
		mapa.put("Contador", contadores);
		mapa.put("Gerente", gerentes);
		mapa.put("Eletricista", eletricistas);
		
		System.out.println("3.6: Imprimir os funcionários, agrupados por função.");
		System.out.println("");
		
		for(Map.Entry<String, List<Funcionario>> be : mapa.entrySet()) {
			System.out.println(be.getKey() + ":");
			System.out.println("---------------------------------------------------------");
	        System.out.printf("%10s %20s %10s %10s ", "NOME | ", "DATA DE NASCIMENTO | ", "SALÁRIO | ", "FUNÇÃO | ");
	        System.out.println();
	        System.out.println("---------------------------------------------------------");
	        for(int i = 0; i < be.getValue().size(); i++) {
	        	System.out.format("%10s %20s %10s %10s ",
	        			be.getValue().get(i).getNome() + " | ",
	        			be.getValue().get(i).formatDate(be.getValue().get(i).getDataNascimento()) + " | ",
	        			be.getValue().get(i).formatSalary(be.getValue().get(i).getSalario()) + " | ",
	        			be.getValue().get(i).getFuncao() + " | ");
	        	System.out.println();
	        	System.out.println("---------------------------------------------------------");
	        }
	        System.out.println();
		}
		
		System.out.println("3.8: Imprimir os funcionários que fazem aniversário no mês 10 e 12.");
		System.out.println("");
		
		System.out.println("Aniversariantes de Outubro e Dezembro");
		System.out.println("---------------------------------------------------------");
		System.out.printf("%10s %20s %10s %10s ", "NOME | ", "DATA DE NASCIMENTO | ", "SALÁRIO | ", "FUNÇÃO | ");
		System.out.println();
		System.out.println("---------------------------------------------------------");
		for(Funcionario func:funcionarios) {
			if(func.getDataNascimento().getMonth().toString() == "OCTOBER" || func.getDataNascimento().getMonth().toString() == "DECEMBER") {
				System.out.format("%10s %20s %10s %10s ",
	        			func.getNome() + " | ",
	        			func.formatDate(func.getDataNascimento()) + " | ",
	        			func.formatSalary(func.getSalario()) + " | ",
	        			func.getFuncao() + " | ");
	        	System.out.println();
	        	System.out.println("---------------------------------------------------------");
			}
		}
		
		System.out.println("3.9: Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.");
		System.out.println("");
		
		Funcionario funcMaiorIdade = null;
		int maiorIdade = 0;
		
		for(Funcionario func:funcionarios) {
			int anoAtual = LocalDate.now().getYear();
			int anoNascimento = func.getDataNascimento().getYear();
			int idade = anoAtual - anoNascimento;
			if(maiorIdade < idade){
				maiorIdade = idade;
				funcMaiorIdade = func;
			}
		}
		
		System.out.println("Funcionário com maior idade");
		System.out.println("-------------------------------");
		System.out.printf("%10s %10s ", "NOME | ", "IDADE | ");
		System.out.println();
		System.out.println("-------------------------------");
		System.out.format("%10s %10s",
    			funcMaiorIdade.getNome() + " | ",
    			LocalDate.now().getYear() - funcMaiorIdade.getDataNascimento().getYear() + " | ");
		System.out.println();
		System.out.println("-------------------------------");
		
		System.out.println("3.10: Imprimir a lista de funcionários por ordem alfabética.");
		System.out.println("");

		List<Funcionario> sortedFuncionarios = new ArrayList<Funcionario>();
		sortedFuncionarios = funcionarios;
		sortedFuncionarios.sort((Funcionario func1, Funcionario func2)->func1.getNome().compareTo(func2.getNome()));
		System.out.println("Lista de funcionários em ordem alfabética:");
		System.out.println("---------------------------------------------------------");
		System.out.printf("%10s %20s %10s %10s ", "NOME | ", "DATA DE NASCIMENTO | ", "SALÁRIO | ", "FUNÇÃO | ");
		System.out.println();
		System.out.println("---------------------------------------------------------");
		for(Funcionario func:sortedFuncionarios) {
			System.out.format("%10s %20s %10s %10s ",
        			func.getNome() + " | ",
        			func.formatDate(func.getDataNascimento()) + " | ",
        			func.formatSalary(func.getSalario()) + " | ",
        			func.getFuncao() + " | ");
        	System.out.println();
        	System.out.println("---------------------------------------------------------");
		}
		
		System.out.println("3.11: Imprimir o total dos salários dos funcionários.");
		System.out.println("");
		
		String totalSalary = "";
		double salarySum = 0;
		for(Funcionario func:funcionarios) {
			salarySum += func.getSalario().doubleValue();
			BigDecimal totalSalaryBd = new BigDecimal(salarySum);
			totalSalary = func.formatSalary(totalSalaryBd);
		}
		
		System.out.println("Soma total dos salários dos funcionários:");
		System.out.println("------------------------------------------");
		System.out.printf("%10s ", "SALÁRIOS | ");
		System.out.println();
		System.out.println("------------------------------------------");
		System.out.format("%10s",
				totalSalary);
    	System.out.println();
    	System.out.println("------------------------------------------");
    	
    	System.out.println("3.12: Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.");
    	System.out.println();
    	
		System.out.println("Quantidade de salários mínimos cada funcionário recebe:");
		System.out.println("------------------------------------------");
		System.out.printf("%10s %20s", "NOME | ", "SALÁRIOS MÍNIMOS | ");
		System.out.println();
		System.out.println("------------------------------------------");
    	for(Funcionario func:funcionarios) {
    		int minSalary = 0;
    		minSalary += func.getSalario().intValue() / 1212.00;
    		System.out.format("%10s %20s",
    				func.getNome() + " | ",
    				minSalary + " | ");
        	System.out.println();
        	System.out.println("------------------------------------------");
    	}


	}
}
