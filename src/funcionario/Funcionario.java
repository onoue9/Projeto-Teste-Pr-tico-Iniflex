package funcionario;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import pessoa.Pessoa;

public class Funcionario extends Pessoa{

	private BigDecimal salario;
	private String funcao;
	
	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	
	public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
		this.setNome(nome);
		this.setDataNascimento(dataNascimento);
		this.salario = salario;
		this.funcao = funcao;
	}
	
	public String formatDate(LocalDate date) {
		String d = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		return d;
	}
	
	public String formatSalary(BigDecimal salario) {
		DecimalFormat formatedSalary = (DecimalFormat) DecimalFormat.getInstance(Locale.GERMAN);
		return formatedSalary.format(salario);
	}
	
}
