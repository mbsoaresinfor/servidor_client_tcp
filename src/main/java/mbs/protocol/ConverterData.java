package mbs.protocol;


import java.util.List;

import mbs.protocol.data.DataSimple;
import mbs.protocol.data.InformationUser;
import mbs.protocol.data.InformationUserIndexEnum;

public class ConverterData {

	private	ProtocolBuilderHelper helper = new ProtocolBuilderHelper();
	
	public DataSimple toDataSimple(Protocol protocol) throws Exception {
		
		validateParam(protocol);
		
		DataSimple dataSimple = new DataSimple();
		dataSimple.setData(	this.hexToAscii(protocol.getData()));
		return dataSimple;
	}


	private void validateParam(Protocol protocol) throws Exception {
		boolean paramInvalid = protocol == null || protocol.getData() == null || protocol.getData().equals("");
		if(paramInvalid) {
			throw new Exception("Parametro 'data' esta invalido. Nao e possivel ler os DADOS");
		}
	}
	
	
	public InformationUser toInformationUser(Protocol protocol) throws Exception {
		validateParam(protocol);
		
		InformationUser ret = new InformationUser();
		List<String> dataInformationUser = helper.splitStringHex(protocol.getData());
		int idade = Integer.parseInt(dataInformationUser.get(InformationUserIndexEnum.Idade.getValue()),16);
		int peso = Integer.parseInt(dataInformationUser.get(InformationUserIndexEnum.Peso.getValue()),16);
		int altura = Integer.parseInt(dataInformationUser.get(InformationUserIndexEnum.Altura.getValue()),16);
		int tamanhoNome = Integer.parseInt(dataInformationUser.get(InformationUserIndexEnum.TamanhoNome.getValue()),16);
		int tamanhoNomeFinal = tamanhoNome + InformationUserIndexEnum.Nome.getValue();
		String nome = hexToAscii(helper.parserData(dataInformationUser, InformationUserIndexEnum.Nome.getValue(), tamanhoNomeFinal));
		ret.setAltura(altura);
		ret.setIdade(idade);
		ret.setNome(nome);
		ret.setPeso(peso);
		ret.setTamanhoNome(tamanhoNome);
		return ret;
		
	}
	
	
	
	
	
	private  String hexToAscii(String hexStr) {
	    StringBuilder output = new StringBuilder("");
	    
	    for (int i = 0; i < hexStr.length(); i += 2) {
	        String str = hexStr.substring(i, i + 2);
	        output.append((char) Integer.parseInt(str, 16));
	    }
	    
	    return output.toString();
	}

}
