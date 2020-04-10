package com.deskeasy.model;

public class NFE_Emit {

	private String CNPJ;
	private String xNome;
	private String xFant;
	private String IE;
	private String IM;
	private String CRT;
	private String CNAE;
	
	private NFE_EnderDest enderEmit;

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

	public String getxNome() {
		return xNome;
	}

	public void setxNome(String xNome) {
		this.xNome = xNome;
	}

	public String getxFant() {
		return xFant;
	}

	public void setxFant(String xFant) {
		this.xFant = xFant;
	}

	public String getIE() {
		return IE;
	}

	public void setIE(String iE) {
		IE = iE;
	}

	public String getIM() {
		return IM;
	}

	public void setIM(String iM) {
		IM = iM;
	}

	public String getCRT() {
		return CRT;
	}

	public void setCRT(String cRT) {
		CRT = cRT;
	}

	public NFE_EnderDest getEnderEmit() {
		return enderEmit;
	}

	public void setEnderEmit(NFE_EnderDest enderEmit) {
		this.enderEmit = enderEmit;
	}

	@Override
	public String toString() {
		return "NFE_Emit [CNPJ=" + CNPJ + ", xNome=" + xNome + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CNPJ == null) ? 0 : CNPJ.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NFE_Emit other = (NFE_Emit) obj;
		if (CNPJ == null) {
			if (other.CNPJ != null)
				return false;
		} else if (!CNPJ.equals(other.CNPJ))
			return false;
		return true;
	}

	public String getCNAE() {
		return CNAE;
	}

	public void setCNAE(String cNAE) {
		CNAE = cNAE;
	}
	
	
	
}
