package mbs.protocol.data;

public enum InformationUserIndexEnum {

	Idade(0),
	Peso(1),
	Altura(2),
	TamanhoNome(3),
	Nome(4);
	
	private int value;
	
	InformationUserIndexEnum(int value){
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
	
	
}
