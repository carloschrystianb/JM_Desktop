package com.deskeasy.control;

import java.util.ArrayList;
import java.util.List;

import com.deskeasy.model.HNG_Item;

public class Import_PedidoTXT {
	
	private List<HNG_Item> itensHNG;

	public Import_PedidoTXT(String itensFile[]) {
		itensHNG = new ArrayList<HNG_Item>();

		for (int l = 0; l < itensFile.length; l++) {

			HNG_Item item = new HNG_Item();

			if (itensFile[l].length() > "JM-".length())
				if (itensFile[l].startsWith("JM-")) {
					int i = 0;
					for (i = 0; itensFile[l].charAt(i) != ' '; i++)
						;
					item.setCodProd(itensFile[l].substring(0, i));

					int j = 0;
					for (j = itensFile[l].length() - 1; itensFile[l].charAt(j) != ' '; j--)
						;
					String radical = itensFile[l].substring(i + 1, j);

					if (radical.length() > 27) {
						item.setDescricaoProduto(radical);
						item.setUnit(itensFile[l].substring(j + 1, itensFile[l++].length()));
					} else {
						item.setDescricaoProduto(itensFile[l].substring(i + 1, itensFile[l++].length()));
						l++;
						item.setUnit(itensFile[l++]);
					}

					l++;
					item.setQuantidade(itensFile[l++]);
					l++;
					item.setvUnit(itensFile[l++]);
					l++;
					item.setvTotal(itensFile[l++]);
					item.setnItem(itensHNG.size() + 1);
					
					System.out.println(item);
					itensHNG.add(item);
					
				}

		}
		
		
	}
	
	public List<HNG_Item> getItensHNG(){
		if(this.itensHNG != null)
			return this.itensHNG;
		return null;
	}
		
	/*
	public static List<HNG_Item> getItensFromFile(String itensFile[]) {
		List<HNG_Item> itensHNG = new ArrayList<HNG_Item>();

		for (int l = 0; l < itensFile.length; l++) {

			HNG_Item item = new HNG_Item();

			if (itensFile[l].length() > "JM-".length())
				if (itensFile[l].startsWith("JM-")) {
					int i = 0;
					for (i = 0; itensFile[l].charAt(i) != ' '; i++)
						;
					item.setCodProd(itensFile[l].substring(0, i));

					int j = 0;
					for (j = itensFile[i].length() - 1; itensFile[l].charAt(j) != ' '; j--)
						;
					String radical = itensFile[l].substring(i + 1, j);

					if (radical.length() > 27) {
						item.setDescricaoProduto(radical);
						item.setUnit(itensFile[l].substring(j + 1, itensFile[i].length()));
					} else {
						item.setDescricaoProduto(itensFile[l].substring(j + 1, itensFile[i].length()));
						l++;
						item.setUnit(itensFile[l++]);
					}

					l++;
					item.setQuantidade(itensFile[l++]);
					l++;
					item.setvUnit(itensFile[l++]);
					l++;
					item.setvTotal(itensFile[l++]);

					itensHNG.add(item);
				}

		}
			return itensHNG;
	}
		*/

	
}
