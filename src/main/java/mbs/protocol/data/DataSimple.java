package mbs.protocol.data;

import java.io.Serializable;

public class DataSimple implements Serializable{

	
	private static final long serialVersionUID = 7676093822477203558L;
	
	String data;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return  data ;
	}
	
	
	
	
}
