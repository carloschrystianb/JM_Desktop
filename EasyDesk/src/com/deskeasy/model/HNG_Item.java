package com.deskeasy.model;

public class HNG_Item {
	
	private String codProd;
	private String descricaoProduto;
	private Integer nItem;
	private String unit;
	private String quantidade;
	private String vUnit;
	private String vTotal;
	
	public HNG_Item() {
		
	}
	
	public HNG_Item(String codProd, String descricaoProduto, String nItem, String unit, Double quantidade, Double vUnit,
			Double vTotal) {
		super();
	}
	
	public HNG_Item(String codProd2, String descricaoProduto2, String nItem2, String unit2, String quantidade2,
			String vUnit2, String vTotal2) {
		// TODO Auto-generated constructor stub
	}

	public String getCodProd() {
		return codProd;
	}
	public void setCodProd(String codProd) {
		this.codProd = codProd;
	}
	public String getDescricaoProduto() {
		return descricaoProduto;
	}
	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	public String getvUnit() {
		return vUnit;
	}
	public void setvUnit(String vUnit) {
		this.vUnit = vUnit;
	}
	public String getvTotal() {
		return vTotal;
	}
	public void setvTotal(String vTotal) {
		this.vTotal = vTotal;
	}

	public int getnItem() {
		return nItem;
	}

	public void setnItem(int nItem) {
		this.nItem = nItem;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codProd == null) ? 0 : codProd.hashCode());
		result = prime * result + ((nItem == null) ? 0 : nItem.hashCode());
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
		HNG_Item other = (HNG_Item) obj;
		if (codProd == null) {
			if (other.codProd != null)
				return false;
		} else if (!codProd.equals(other.codProd))
			return false;
		if (nItem == null) {
			if (other.nItem != null)
				return false;
		} else if (!nItem.equals(other.nItem))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "HNG_Item [codProd=" + codProd + ", descricaoProduto=" + descricaoProduto + ", nItem=" + nItem
				+ ", unit=" + unit + ", quantidade=" + quantidade + ", vUnit=" + vUnit + ", vTotal=" + vTotal + "]";
	}
	
	
	
}
