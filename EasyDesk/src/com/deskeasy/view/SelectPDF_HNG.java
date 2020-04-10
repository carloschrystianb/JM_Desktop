package com.deskeasy.view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.deskeasy.assets.FormatDANFE4;
//import com.deskeasy.cases.Case002_TXTRead;
import com.deskeasy.control.DanfeTXT_Factory;
import com.deskeasy.model.HNG_Order;



public class SelectPDF_HNG {
	
	//private static String itensFinded = "Unid. Quantidade V.Unit. V.Total";
	
	
	public SelectPDF_HNG() {
		
		JFileChooser fileBox = new JFileChooser();
		HNG_Order order = new HNG_Order();
		
		if(fileBox.showOpenDialog(null) == 0) {
			try {
				Process txtPdfConverter = 
						Runtime.getRuntime().exec(".\\lib\\pdftotext.exe " + fileBox.getSelectedFile().getAbsolutePath());
				
				txtPdfConverter.waitFor();
			} catch ( InterruptedException | IOException erroChamadaSistema) {
				JOptionPane.showMessageDialog(null, "Falha ao gerar nota\nEntre em contato com o suporte\n "
						+ "Informe o seguinte erro: " + erroChamadaSistema.
															getMessage() );
				System.exit(404);
			}
		}
		
		
		
		List<String> linhas = new ArrayList<String>();
		
		try {
			String pathTXT = fileBox.getSelectedFile().getAbsolutePath();
			pathTXT = pathTXT.substring(0, pathTXT.length() - 4);
			pathTXT += ".txt";
			FileReader fd = new FileReader(pathTXT);
			BufferedReader buffer = new BufferedReader(fd);

			String linha = buffer.readLine();

			while (linha != null) {
				linhas.add(linha);
				linha = buffer.readLine();
			}	
			
			
			
			String arquivoTXT[] = new String[linhas.size()];
			int i = 0;
			for(String l : linhas) arquivoTXT[i++] = l;

			order = new HNG_Order(arquivoTXT);
			order.setNroPedido(new FormatDANFE4().removeFileExtension( fileBox.getSelectedFile().getAbsoluteFile().getName() ));
			new DanfeTXT_Factory(order);
			fd.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível ler o arquivo\nErro:\n" + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
