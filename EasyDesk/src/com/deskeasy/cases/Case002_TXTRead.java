package com.deskeasy.cases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.deskeasy.model.HNG_Item;

public class Case002_TXTRead {

	private static String itensHead = "Unid. Quantidade V.Unit. V.Total";

	public static List<HNG_Item> getItemFromFile(BufferedReader buffer) throws IOException {
		List<HNG_Item> listItems = new ArrayList<HNG_Item>();
		boolean itensFinded = false;
		String codProd = "";
		String descricaoProd = "";
		String unit = "";
		String quantidade = "";
		String vUnit = "";
		String vTotal = "";
		String linha = buffer.readLine();

		while (linha != null) {
			if (itensFinded) {
				linha = buffer.readLine();
				
				if (linha != null )
					if (linha.length() > 5)
						if (linha.startsWith("JM-")) {
							int i = 0;
							for (i = 0; linha.charAt(i) != ' '; i++);
							codProd = linha.substring(0, i);
							

							int j = 0;
							for(j = linha.length() - 1; linha.charAt(j) != ' '; j--);
							String radical = linha.substring(i + 1, j);
							
							if(radical.length() > 27){
								descricaoProd = radical;
								unit = linha.substring(j + 1, linha.length());
							}else {
								descricaoProd = linha.substring(i + 1, linha.length());
								buffer.readLine();
								unit = buffer.readLine();
							}
							
							buffer.readLine();
							quantidade = buffer.readLine();
							buffer.readLine();
							vUnit = buffer.readLine();
							buffer.readLine();
							vTotal = buffer.readLine();
							
							System.out.println(codProd);
							System.out.println(descricaoProd);
							System.out.println(unit);
							System.out.println(quantidade);
							System.out.println(vUnit);
							System.out.println(vTotal);
							
						}
							
							
							/*if (linha.length() > 27) {
								
							} else {
								int i = 1;
								for (i = 1; linha.charAt(i) != ' '; i++);
								codProd = linha.substring(0, i);
								System.out.println(codProd);
								descricaoProd = linha.substring(i + 1, linha.length());
								System.out.println(descricaoProd);
							}*/

			}
			
			if(linha != null)
				if (linha.equals(itensHead))
					itensFinded = true;

			linha = buffer.readLine(); // lê da segunda até a última linha
		}

		return listItems;
	}

	public static void main(String[] args) {
		JFileChooser selecionaArquivo = new JFileChooser();
		selecionaArquivo.showOpenDialog(null);

		try {
			FileReader fd = new FileReader(selecionaArquivo.getSelectedFile().getAbsolutePath());
			BufferedReader buffer = new BufferedReader(fd);

			Case002_TXTRead.getItemFromFile(buffer);

			fd.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível ler o arquivo\nErro:\n" + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
