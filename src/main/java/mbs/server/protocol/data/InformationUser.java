package mbs.server.protocol.data;

import java.io.Serializable;

public class InformationUser implements Serializable{

	private static final long serialVersionUID = -3526545505198273127L;
	
	private int idade;
	private int peso;
	private int altura;
	private int tamanhoNome;
	private String nome;
	
	public int getIdade() {
		return idade;
	}
	public int getPeso() {
		return peso;
	}
	public int getAltura() {
		return altura;
	}
	public int getTamanhoNome() {
		return tamanhoNome;
	}
	public String getNome() {
		return nome;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public void setTamanhoNome(int tamanhoNome) {
		this.tamanhoNome = tamanhoNome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "InformationUser [idade=" + idade + ", peso=" + peso + ", altura=" + altura + ", tamanhoNome="
				+ tamanhoNome + ", nome=" + nome + "]";
	}
	
	


}
