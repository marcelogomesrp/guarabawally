package br.com.guaraba.commons.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class FileUtils {

	public static String readTextFile(String fullPathFilename) throws IOException {

		StringBuffer sb = new StringBuffer(1024);
		BufferedReader reader = new BufferedReader(new FileReader(
				fullPathFilename));

		char[] chars = new char[1024];
		while (reader.read(chars) > -1) {
			sb.append(String.valueOf(chars));
		}

		reader.close();

		return sb.toString();
	}

	public static List<File> findFiles(final File startingDirectory) {
		
		return findFiles(startingDirectory, ".*");
	}
	
	/*
	 * Carrega todos os arquivos de um determinado diretorio
	 * 
	 // Listando todos os arquivos "*.html"  
	 System.out.println (findFiles (new File("."), ".*\\.html"));  
	 
	 // Listando todos os arquivos "*.java" ou "abs*.txt"  
	 System.out.println (findFiles (new File("."), "(.*\\.java|abs.*\\.txt)"));  
	 
	 // Listando todos os arquivos "*.htm*" (incluindo arquivos *.HTM) - útil para Windows  
	 System.out.println (findFiles (new File("."), "(?i).*\\.htm[^.]*"));  
	 
	 // Listando todos os arquivos "*.htm*" e "*.jsp" (incluindo arquivos *.HTM e *.JSP) no diretório C:\INETPUB - útil para Windows  
	 System.out.println (findFiles (new File("C:/INETPUB"), "(?i)(.*\\.htm[^.]*|.*\\.jsp)"));  
	*/
	public static List<File> findFiles(final File startingDirectory, final String pattern) {
			
		List<File> files = new ArrayList<File>();
		if (startingDirectory.isDirectory()) {
			File[] sub = startingDirectory.listFiles(new FileFilter() {
				public boolean accept(File pathname) {
					return pathname.isDirectory() || pathname.getName().matches(pattern);
				}
			});
			for (File fileDir : sub) {
				if (fileDir.isDirectory()) {
					files.addAll(findFiles(fileDir, pattern));
				} else {
					files.add(fileDir); //   
				}
			}
		}
		return files;
	}
}