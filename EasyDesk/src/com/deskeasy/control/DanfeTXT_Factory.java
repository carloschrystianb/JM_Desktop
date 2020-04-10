package com.deskeasy.control;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.deskeasy.control.Export_DanfeTXT;
import com.deskeasy.model.HNG_Item;
import com.deskeasy.model.HNG_Order;
import com.deskeasy.model.NFE_4;
import com.deskeasy.model.NFE_Dest;
import com.deskeasy.model.NFE_Emit;
import com.deskeasy.model.NFE_EnderDest;
import com.deskeasy.model.NFE_Prod;
import com.deskeasy.model.NFE_ProdFactorySemTrib;

public class DanfeTXT_Factory {
	
	public DanfeTXT_Factory(HNG_Order order) {
		
		NFE_Emit emit = new NFE_Emit();
		emit.setCNPJ("14167397000115");
		emit.setxNome("M DE FATIMA BARBOSA MACHADO ME");
		emit.setxFant("JM DISTRIBUIDORA");
		NFE_EnderDest ender = new NFE_EnderDest();
		ender.setxLgr("RUA PRIMEIRO DE MAIO");
		ender.setNro("271");
		ender.setxCpl("B");
		ender.setxBairro("BONSUCESSO");
		ender.setcMun("2304400");
		ender.setxMun("Fortaleza");
		ender.setUF("CE");
		ender.setCEP("60541658");
		ender.setcPais("1058");
		ender.setFone("8531043909");
		emit.setEnderEmit(ender);
		emit.setIE("065728050");
		emit.setIM("000");
		emit.setCNAE("4530703");
		emit.setCRT("1");
		
		
		/*NFE_Dest dest = new NFE_Dest();
		dest.setCNPJ("18702272000107");
		dest.setxNome("AUTO PECAS ECONOMICA LTDA ME");
		NFE_EnderDest enderDest = new NFE_EnderDest();
		enderDest.setxLgr("AVENIDA OSORIO DE PAIVA");
		enderDest.setNro("4384");
		enderDest.setxBairro("BOM JARDIM");
		enderDest.setcMun("2304400");
		enderDest.setxMun("Fortaleza");
		enderDest.setUF("CE");
		enderDest.setCEP("60731534");
		enderDest.setcPais("1058");
		enderDest.setxPais("BRASIL");
		dest.setEnderDest(enderDest);
		dest.setIndIEDest("1");
		dest.setIE("065263707");
		dest.setEmail("auto@auto.com");*/
		
		
		Double vProd = 0.0;
		List<NFE_Prod> prod = new ArrayList<NFE_Prod>();
		
		
		Double vDesc = 0.0;
		
		for(HNG_Item item : order.getItensHNG()) {
			Double vItem = Double.parseDouble(item.getvTotal().replace(',', '.'));
			vProd += vItem;
			
			if( order.getvDesconto() != null) {
				
				prod.add(new NFE_ProdFactorySemTrib(item, order.getNroPedido(), 
						String.format("%.2f",  vItem *  order.getPorcDesconto()).replace(',', '.') ));
			}
			
			if(order.getvDesconto() == null) {
				prod.add(new NFE_ProdFactorySemTrib(item, order.getNroPedido(), ""));
			}
			
			
		}
		
		
		try {
			NFE_Dest dest = new Import_ClienteXML(order.getCnpj()).getDest();
			System.out.println(dest.getCNPJ());
			
			NFE_4 nfe = new NFE_4();
			nfe.setEmit(emit);
			nfe.setDest(dest);
			nfe.setProd(prod);
			
			nfe.setValoresNota(vProd, vDesc);
			new Export_DanfeTXT(nfe).gerarDanfeTXT();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			try {
				e.printStackTrace(new PrintWriter(new File(".\\Logs" + order.getNroPedido() + ".txt")) );
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
}
