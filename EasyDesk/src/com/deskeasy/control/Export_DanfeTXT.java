package com.deskeasy.control;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.deskeasy.assets.FormatDANFE4;
import com.deskeasy.model.NFE_4;
import com.deskeasy.model.NFE_Dest;
import com.deskeasy.model.NFE_Emit;
import com.deskeasy.model.NFE_Prod;

public class Export_DanfeTXT {
	
	private NFE_Emit emit;
	private NFE_Dest dest;
	private List<NFE_Prod> prod;
	private NFE_4 nfe;
	
	public Export_DanfeTXT(NFE_4 nfe) {
		this.emit = nfe.getEmit();
		this.dest = nfe.getDest();
		this.prod = nfe.getProd();
		this.nfe = nfe;
	}
	
	public void gerarDanfeTXT() throws IOException {
		FormatDANFE4 format = new FormatDANFE4();
		
		String sequenciaDANFE = prod.get(0).getnNF();
		
		File danfeTXT = new File("C:\\Temp\\NOTA.txt");
		FileWriter fw = new FileWriter(danfeTXT);
		
		//1
		fw.write("NOTAFISCAL|1\r\n");
		//2
		fw.write("A|4.00|NFe"
				+ this.emit.getEnderEmit().getCodigoUF()
				+ "1708" 
				+ this.emit.getCNPJ() 
				+ "55"
	/* Série */	+ "001"
			    + format.getSequencial_Chave(sequenciaDANFE) 
			    + "103000941"
				+ format.getHashCode(sequenciaDANFE)
			    + "|\r\n"
			    );
		
		fw.write("B|23|03000094|VENDA DE MERCADORIAS|55|1|" 
				+ sequenciaDANFE
				+ "|" + format.getDataAtualPadraoNFE() + "|"
				+ format.getDataAtualPadraoNFE() 
				+ "|1|1|2304400|1|1|0|1|1|0|0|3|4.00|||\r\n");
		//3
		fw.write("C|"
				+ emit.getxNome()
				+ "|"
				+ emit.getxFant()
				+ "|"
				+ emit.getIE()
				+ "||"
				+ emit.getIM()
				+ "|"
				+ emit.getCNAE()
				+ "|1|\r\n");
		//4
		fw.write("C02|"
				+ emit.getCNPJ()
				+ "|\r\n");
		//5
		fw.write("C05|"
				+ emit.getEnderEmit().getxLgr()
				+ "|"
				+ emit.getEnderEmit().getNro()
				+ "|B|"
				+ emit.getEnderEmit().getxBairro()
				+ "|"
				+ emit.getEnderEmit().getcMun()
				+ "|"
				+ emit.getEnderEmit().getxMun()
				+ "|CE|"
				+ emit.getEnderEmit().getCEP()
				+ "|1058|"
				+ "BRASIL|"
				+ emit.getEnderEmit().getFone()
				+ "|\r\n");
		
		//6
		fw.write("E|"
				+ dest.getxNome()
				+ "|1|"
				+ dest.getIE()
				+ "|||"
				+ dest.getEmail()
				+ "|\r\n");
		fw.write("E02|"
				+ dest.getCNPJ()
				+ "|\r\n");
		fw.write("E05|"
				+ dest.getEnderDest().getxLgr()
				+ "|" 
				+ dest.getEnderDest().getNro()
				+ "||" 
				+ dest.getEnderDest().getxBairro()
				+ "|"
				+ dest.getEnderDest().getcMun()
				+ "|"
				+ dest.getEnderDest().getxMun()
				+ "|"
				+ dest.getEnderDest().getUF()
				+ "|"
				+ dest.getEnderDest().getCEP()
				+ "|"
				+ dest.getEnderDest().getcPais()
				+ "|"
				+ dest.getEnderDest().getxPais()
				+ "||\r\n");
		
		
		fw.write("GA|\r\n");
		fw.write("GA02|18173571000193|\r\n");
		fw.write("GA|\r\n");
		fw.write("GA02|" + dest.getCNPJ() + "|\r\n");
				
		
		for(NFE_Prod h : this.prod) {
			//P1
			fw.write("H|"
					+ h.getnItem()
					+ "||\r\n");
			
			fw.write("I|"
					+ h.getcProd()
					+ "||"
					+ h.getxProd()
					+ "|"
					+ h.getNcm()
					+ "||"
					+ h.getCfop()
					+ "|UND|"
					+ h.getqCom()
					+ "|"
					+ h.getvUnCom()
					+ "|"
					+ h.getvProd()
					+ "||"
					+ h.getuTrib()
					+ "|"
					+ h.getqCom()
					+ "|"
					+ h.getvUnTrib()
					+ "|||"
					+ h.getvDesc()
					+ "||1||||\r\n");
			
			fw.write( "M||\r\n"
					+ "N|\r\nN10g|"
					+ h.getIcms_orig() 
					+ "|"
					+ h.getIcms_csosn()
					+ "|||\r\n"
					+ "Q|\r\nQ04|" + h.getPis_cts() + "|\r\n"
					+ "S|\r\nS04|" + h.getCofins_cst() + "|\r\n");
			
		}
		

		
		
		fw.write(
				"W|\r\n"
				+"W02|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|"
				+ nfe.getvProd()
				+ "|0.00|0.00|"
				+ nfe.getvDesc()
				+ "|0.00|0.00|"
				+ nfe.getvNF()
				+ "|0.00|\r\n" + 
				"W04c|0.00|\r\n" + 
				"W04e|0.00|\r\n" + 
				"W04g|0.00|\r\n" + 
				"X|0|\r\n" + 
				"X26|1|VOL|||||\r\n" + 
				"YA\r\n" + 
				"YA01|0|01|"
				+ nfe.getvNF()
				+ "|");
		
		fw.close();
		

	}
	
}
