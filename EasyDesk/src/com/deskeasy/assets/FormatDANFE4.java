package com.deskeasy.assets;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatDANFE4 {
	
	public String getDataAtualPadraoNFE() {
		return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(new Date()) + "-03:00";
	}
	
	
	public String removeFileExtension(String fileName) {
		return fileName.substring(0, fileName.length() - 4);
	}
	
	public String getSequencial_Chave(String sequenciaDANFE) {
		
		String sequenciaChave = "";
		for(int i = 0; i < ("000000532".length() - sequenciaDANFE.length() ); i++)
			sequenciaChave += "0";
		
		sequenciaChave += sequenciaDANFE;	
		return sequenciaChave;
	}

	public String getHashCode(String sequenciaDANFE) {
		return "0";
	}

	public String getOnlyNumbersCPNJ(String cnpj) {
		cnpj = cnpj.replace("-", "");
		cnpj = cnpj.replace("/", "");
		cnpj = cnpj.replace(".", "");
		return cnpj;
	}
	
}
