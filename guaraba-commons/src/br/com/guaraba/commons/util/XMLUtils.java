package br.com.guaraba.commons.util;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public final class XMLUtils {

	public static String objetcToXML(Object objeto) throws Exception {
		
		Writer writer = null;
		JAXBContext context = null;
		String xml = null;
		
		if(objeto != null) {
		
	        try {
	        	
	        	writer = new StringWriter();
				context = JAXBContext.newInstance(objeto.getClass());
				context.createMarshaller().marshal(objeto, writer);
				xml = writer.toString();
				
			} catch (JAXBException e) {
				
				throw e;
			
			} finally {
				
				if(writer != null) {
					
					writer.close();
					writer = null;
				}
			}
		}
        
        return xml;
	}
	
	public static String objetcToXML(Object objeto, String enconding) throws Exception {
		
		Writer writer = null;
		JAXBContext context = null;
		String xml = null;
		
		if(objeto != null) {
		
	        try {
	        	
	        	writer = new StringWriter();
	        	
				context = JAXBContext.newInstance(objeto.getClass());
	
				Marshaller marshaller = context.createMarshaller();
				marshaller.setProperty(Marshaller.JAXB_ENCODING, ((StringUtils.isNullOrEmpty(enconding) ? Encodes.ISO_8859_1.toString(): enconding )));
				marshaller.marshal(objeto, writer);
				xml = writer.toString();
				
			} catch (JAXBException e) {
				
				throw e;
			
			} finally {
				
				if(writer != null) {
					
					writer.close();
					writer = null;
				}
			}
		}
        
        return xml;
	}
	
	@SuppressWarnings("unchecked")
	public static void objectTOXML(Object object, Class clazz, String caminhoDestino, String nomeArquivoXML) throws Exception {
		
		objectTOXML(object, clazz, caminhoDestino, nomeArquivoXML, null);
	}
	
	@SuppressWarnings("unchecked")
	public static void objectTOXML(Object object, Class clazz, String caminhoDestino, String nomeArquivoXML, Encodes encode) throws Exception {
		
		JAXBContext context = null;
		Writer writer = null;

		if(object == null) {
			
			throw new NullPointerException("O objeto deve ser informado!");
		}
		
		if(StringUtils.isNullOrEmpty(caminhoDestino)) {
			
			throw new NullPointerException("O caminho de onde o arquivo xml será gerado, deve ser informado!");
		
		} else if(!caminhoDestino.endsWith("/")) {
			
			caminhoDestino = caminhoDestino.concat("/");
		}
		
		if(StringUtils.isNullOrEmpty(nomeArquivoXML)) {
			
			throw new NullPointerException("O nome do arquivo xml que será gerado, deve ser informado!");
		
		} else if(!nomeArquivoXML.endsWith(".xml")) {
			
			nomeArquivoXML = nomeArquivoXML.concat(".xml");
		}
		
		if(encode == null) {
			
			encode = Encodes.ISO_8859_1; 
		}

		try {

			//se diretorio destino arquivo não existe
			if(!new File(caminhoDestino).exists()) {
				
				//cria o diretorio destino
				new File(caminhoDestino).mkdirs();
			}

			String arquivo = caminhoDestino + StringUtils.removerAcentos(nomeArquivoXML);

			writer = new PrintWriter(arquivo, encode.toString());

			context = JAXBContext.newInstance(clazz);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_ENCODING, encode.toString());

			marshaller.marshal(object, writer);
			
			writer.flush();
			
		} catch (Exception e) {

			throw e;
		
		} finally {
			
			if(writer != null) {
				
				writer.close();
				writer = null;
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public static Object xmlTOObject(Class clazz, String xml) {
		
		JAXBContext context = null;
		Object object = null;
	  
		if(!StringUtils.isNullOrEmpty(xml) && clazz != null) {
	      	
			try {
	    	  
	      		context = JAXBContext.newInstance(clazz);
	      		object = context.createUnmarshaller().unmarshal(new StringReader(xml));
				
			} catch (JAXBException e) {
	
				e.printStackTrace();
			}
		}
		
		return object;
	}
	
	@SuppressWarnings("unchecked")
	public static Object xmlTOObjectFromFile(Class clazz, String caminhoXMLOrigem) throws Exception {
		
		JAXBContext context = null;
		Object object = null;
		
		if (!new File(caminhoXMLOrigem).exists()) {
			
			throw new NullPointerException("O arquivo '" + caminhoXMLOrigem + "' não foi localizado!");
		}
  		
		if(clazz != null) {
			
	  		context = JAXBContext.newInstance(clazz);
	  		object = context.createUnmarshaller().unmarshal(new File(caminhoXMLOrigem));
		}
		
		return object;
	}
}