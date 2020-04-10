package com.deskeasy.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "dest")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class NFE_Dest implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String CNPJ;
	private String xNome;
	private String indIEDest;
	private String IE;
	private String email;
	
	private NFE_EnderDest enderDest;

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

	public String getIE() {
		return IE;
	}

	public void setIE(String iE) {
		IE = iE;
	}

	public NFE_EnderDest getEnderDest() {
		return enderDest;
	}

	public void setEnderDest(NFE_EnderDest enderDest) {
		this.enderDest = enderDest;
	}

	@Override
	public String toString() {
		return "NFE_Dest [CNPJ=" + CNPJ + ", xNome=" + xNome + "]";
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
		NFE_Dest other = (NFE_Dest) obj;
		if (CNPJ == null) {
			if (other.CNPJ != null)
				return false;
		} else if (!CNPJ.equals(other.CNPJ))
			return false;
		return true;
	}

	public String getIndIEDest() {
		return indIEDest;
	}

	public void setIndIEDest(String indIEDest) {
		this.indIEDest = indIEDest;
	}

	public String getEmail() {
		if(this.email == null)
			return "";
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
