package com.deskeasy.cases;

import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Case001_PDFRead {
	
	public static void main(String[] args) {
		
		JFileChooser fileBox = new JFileChooser();
		
		if(fileBox.showOpenDialog(null) == 0) {
			try {
				Runtime.getRuntime().exec(".\\lib\\pdftotext.exe " + fileBox.getSelectedFile().getAbsolutePath());
			} catch (IOException erroChamadaSistema) {
				JOptionPane.showMessageDialog(null, "Falha ao gerar nota\nEntre em contato com o suporte\n "
						+ "Informe o seguinte erro: " + erroChamadaSistema.
															getMessage() );
				System.exit(404);
			}
		}
		
		System.exit(0);
	}
	
}
