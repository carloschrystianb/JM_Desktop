package com.deskeasy.control;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import com.deskeasy.model.NFE_Dest;

public class Import_ClienteXML {
	
	private NFE_Dest dest;
	
	public Import_ClienteXML(String cnpj){
		
		
			try {
				JAXBContext jaxbSistema;
				jaxbSistema = JAXBContext.newInstance(NFE_Dest.class);
				Unmarshaller unshDest = jaxbSistema.createUnmarshaller();
				
				//File clienteXML = new File(".\\Cliente\\" + cnpj + ".xml");
				File clienteXML = new File(".\\Cliente\\" + cnpj + ".xml");
				this.dest = (NFE_Dest) unshDest.unmarshal(clienteXML);
				System.out.println(dest.getEmail());
			} catch (JAXBException e) {
				e.printStackTrace();
			} 
			
		
		
		//https://howtodoinjava.com/jaxb/read-xml-to-java-object/
	}
	
	public NFE_Dest getDest() {
		return this.dest;
	}
	
	
}
