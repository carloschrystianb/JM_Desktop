package com.deskeasy.model;

import java.util.ArrayList;
import java.util.List;

import com.deskeasy.assets.FormatDANFE4;

public class HNG_Order {

	private String nroPedido;
	private String nNF;
	private String cnpj;
	private Double vTotal;
	private Double vDesconto;
	private List<HNG_Item> itensHNG;
	private FormatDANFE4 formatos;

	public HNG_Order() {
		super();
	}

	public HNG_Order(String arquivoTXT[]) {
		this.itensHNG = new ArrayList<HNG_Item>();
		formatos = new FormatDANFE4();
		vTotal = 0.0;
		
		
		
		for (int l = 0; l < arquivoTXT.length; l++) {
			
			if(arquivoTXT[l].length() > "Descontos..".length()) {
				if(arquivoTXT[l].startsWith("Descontos..")) {
					this.vDesconto = Double.parseDouble( 
										arquivoTXT[l + 2].replace(',', '.') );
					System.out.println();
				}
			}
			
			HNG_Item item = new HNG_Item();

			if(arquivoTXT[l].length() > "CPF/CNPJ:".length())
				if(arquivoTXT[l].startsWith("CPF/CNPJ:"))
					this.setCnpj( arquivoTXT[l].substring("CPF/CNPJ:".length(), arquivoTXT[l].length()) );
				
			
			if (arquivoTXT[l].length() > "JM-".length())
				if (arquivoTXT[l].startsWith("JM-")) {
					int i = 0;
					for (i = 0; arquivoTXT[l].charAt(i) != ' '; i++)
						;
					item.setCodProd(arquivoTXT[l].substring(0, i));

					int j = 0;
					for (j = arquivoTXT[l].length() - 1; arquivoTXT[l].charAt(j) != ' '; j--)
						;
					String radical = arquivoTXT[l].substring(i + 1, j);
					
					if(radical.equals("JM-5434 PORCA AGREGADO 10MM")) {
						item.setDescricaoProduto(arquivoTXT[l].substring(i + 1, arquivoTXT[l++].length()));
						l++;
						item.setUnit(arquivoTXT[l++]);
					}else {
						if (radical.length() > 27) {
							item.setDescricaoProduto(radical);
							item.setUnit(arquivoTXT[l].substring(j + 1, arquivoTXT[l++].length()));
						} else {
							item.setDescricaoProduto(arquivoTXT[l].substring(i + 1, arquivoTXT[l++].length()));
							l++;
							item.setUnit(arquivoTXT[l++]);
						}
					}
					
					

					l++;
					item.setQuantidade(arquivoTXT[l++]);
					l++;
					item.setvUnit(arquivoTXT[l++]);
					l++;
					item.setvTotal(arquivoTXT[l++]);
					item.setnItem(itensHNG.size() + 1);
					
					
					System.out.println(l);
					this.vTotal += Double.parseDouble(item.getvTotal().replace(',', '.'));
					this.itensHNG.add(item);
					
					
					
				}
			
			

		}

	}

	public String getNroPedido() {
		return nroPedido;
	}

	public void setNroPedido(String nroPedido) {
		this.nroPedido = nroPedido;
	}

	public String getnNF() {
		return nNF;
	}

	public void setnNF(String nNF) {
		this.nNF = nNF;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = formatos.getOnlyNumbersCPNJ(cnpj);
	}

	public Double getvTotal() {
		return vTotal;
	}

	public void setvTotal(Double vTotal) {
		this.vTotal = vTotal;
	}

	public List<HNG_Item> getItensHNG() {
		return itensHNG;
	}

	public void setItensHNG(List<HNG_Item> itensHNG) {
		this.itensHNG = itensHNG;
	}

	@Override
	public String toString() {
		return "HNG_Order [nroPedido=" + nroPedido + ", nNF=" + nNF + ", cpnj=" + cnpj + ", vTotal=" + vTotal + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nroPedido == null) ? 0 : nroPedido.hashCode());
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
		HNG_Order other = (HNG_Order) obj;
		if (nroPedido == null) {
			if (other.nroPedido != null)
				return false;
		} else if (!nroPedido.equals(other.nroPedido))
			return false;
		return true;
	}

	public Double getvDesconto() {
		return vDesconto;
	}
	
	public double getPorcDesconto() {
		double porcDesconto = vDesconto / vTotal;
		//porcDesconto *= 100;
		return porcDesconto;
	}

	public void setvDesconto(Double vDesconto) {
		this.vDesconto = vDesconto;
	}

}
