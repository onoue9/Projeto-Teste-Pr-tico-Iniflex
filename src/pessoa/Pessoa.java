package pessoa;

import java.time.LocalDate;

public abstract class Pessoa {
	
	private String nome;
	private LocalDate dataNascimento;
	
	public String getNome() {
		return nome;
	}
	
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
