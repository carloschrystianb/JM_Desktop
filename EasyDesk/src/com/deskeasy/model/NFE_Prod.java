package com.deskeasy.model;

public class NFE_Prod {
	
	private String nNF;
	private String cProd;
	private String xProd;
	private String ncm;
	private String nItem;
	private String cfop;
	private String uCom;
	private String qCom;
	private String vUnCom;
	private String vProd;
	private String vDesc;
	private String uTrib;
	private String qTrib;
	private String indTot;
	private String vUnTrib;
	private String icms_orig;
	private String icms_csosn;
	private String pis_cts;
	private String cofins_cst;
	
	public String getnNF() {
		return nNF;
	}
	public void setnNF(String nNF) {
		this.nNF = nNF;
	}
	public String getcProd() {
		return cProd;
	}
	public void setcProd(String cProd) {
		this.cProd = cProd;
	}
	public String getxProd() {
		return xProd;
	}
	public void setxProd(String xProd) {
		this.xProd = xProd;
	}
	public String getNcm() {
		return ncm;
	}
	public void setNcm(String ncm) {
		this.ncm = ncm;
	}
	public String getnItem() {
		return nItem;
	}
	public void setnItem(String nItem) {
		this.nItem = nItem;
	}
	public String getCfop() {
		return cfop;
	}
	public void setCfop(String cfop) {
		this.cfop = cfop;
	}
	public String getuCom() {
		return uCom;
	}
	public void setuCom(String uCom) {
		uCom = uCom.replace(',', '.');
		this.uCom = uCom;
	}
	public String getqCom() {
		return qCom;
	}
	public void setqCom(String qCom) {
		qCom = qCom.replace(',', '.');
		qCom += "0";
		this.qCom = qCom;
	}
	public String getvUnCom() {
		return vUnCom;
	}
	public void setvUnCom(String vUnCom) {
		vUnCom = vUnCom.replace(',', '.');
		vUnCom += "00000000";
		this.vUnCom = vUnCom;
	}
	public String getvProd() {
		return vProd;
	}
	public void setvProd(String vProd) {
		vProd = vProd.replace(',', '.');
		this.vProd = vProd;
	}
	public String getuTrib() {
		return uTrib;
	}
	public void setuTrib(String uTrib) {
		this.uTrib = uTrib;
	}
	public String getqTrib() {
		return qTrib;
	}
	public void setqTrib(String qTrib) {
		qTrib = qTrib.replace(',', '.');
		qTrib += "0";
		this.qTrib = qTrib;
	}
	public String getIndTot() {
		return indTot;
	}
	public void setIndTot(String indTot) {
		this.indTot = indTot;
	}
	public String getvUnTrib() {
		return vUnTrib;
	}
	public void setvUnTrib(String vUnTrib) {
		vUnTrib = vUnTrib.replace(',', '.');
		vUnTrib += "00000000";
		this.vUnTrib = vUnTrib;
	}
	public String getIcms_orig() {
		return icms_orig;
	}
	public void setIcms_orig(String icms_orig) {
		this.icms_orig = icms_orig;
	}
	public String getIcms_csosn() {
		return icms_csosn;
	}
	public void setIcms_csosn(String icms_csosn) {
		this.icms_csosn = icms_csosn;
	}
	public String getPis_cts() {
		return pis_cts;
	}
	public void setPis_cts(String pis_cts) {
		this.pis_cts = pis_cts;
	}
	public String getCofins_cst() {
		return cofins_cst;
	}
	public void setCofins_cst(String cofins_cst) {
		this.cofins_cst = cofins_cst;
	}
	
	public void setvDesc(String vDesc) {
		this.vDesc = vDesc;
	}
	
	public String getvDesc() {
		if(this.vDesc == null) return "";
		return this.vDesc;
	}
	

	

	
}
