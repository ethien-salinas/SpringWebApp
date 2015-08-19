package org.auribox.model;

public class Direccion {
	
	private String calle;
	private int numExt;
	private String colonia;

	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumExt() {
		return numExt;
	}
	public void setNumExt(int numExt) {
		this.numExt = numExt;
	}
	public String getColonia() {
		return colonia;
	}
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	@Override
	public String toString() {
		return "Direccion [calle=" + calle + ", numExt=" + numExt
				+ ", colonia=" + colonia + "]";
	}
	
	

}
