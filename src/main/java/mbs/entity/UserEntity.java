package mbs.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "USER")
public class UserEntity implements Serializable{

	
	private static final long serialVersionUID = -4811711766027255033L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@Column()
	private int idade;
	 @Column()
	private int peso;
	 @Column()
	 private int altura;
	 @Column()
	 private String nome;
	 
	 
	public Long getId() {
		return id;
	}
	public int getIdade() {
		return idade;
	}
	public int getPeso() {
		return peso;
	}
	public int getAltura() {
		return altura;
	}
	public String getNome() {
		return nome;
	}
	public void setId(Long id) {
		this.id = id;
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
	public void setNome(String nome) {
		this.nome = nome;
	}
	 
	 
	
	
}
