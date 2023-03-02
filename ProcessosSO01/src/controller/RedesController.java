package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	
	public RedesController() {
		super();
	}

	public String os () {
		String os = System.getProperty("os.name");
		String arch = System.getProperty("os.arch");
		String version = System.getProperty("os.version");
		return os + " - v." +version+ " - arquitetura " +arch;
	}
	
	public void ip (String so, String p) {
		
		if (so.contains("Windows")) {
			p = "ipconfig";
		} else {
			if (so.contains("Linux")) {
				p = "ifconfig";
			}
		}
		
		try {
			Process proc = Runtime.getRuntime().exec(p);
			InputStream f = proc.getInputStream();
			InputStreamReader leitor = new InputStreamReader(f); 
			BufferedReader b = new BufferedReader(leitor);
			String linha = b.readLine();
			while (linha != null) {
				if (linha.contains("Adaptador") || linha.contains("IPv4") || linha.contains("adapter")){
					System.out.println(linha);					
				}
				linha = b.readLine();
			}
			
			b.close();
			leitor.close();
			f.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void ping (String so, String p) {
		if (so.contains("Windows")) {
			p = "ping -4 -n 10 www.google.com.br";
		} else {
			if (so.contains("Linux")) {
				p = "ping -4 -c 10 www.google.com.br";
			}
		}
		
		try {
			Process proc = Runtime.getRuntime().exec(p);
			InputStream f = proc.getInputStream();
			InputStreamReader leitor = new InputStreamReader(f); 
			BufferedReader b = new BufferedReader(leitor);
			String linha = b.readLine();
			
			while (linha != null) {
				if (linha.contains("dia") || linha.contains("Average") || linha.contains("Média") || linha.contains("av")){
					System.out.println(linha);
				}
				linha = b.readLine();
			}
			
			b.close();
			leitor.close();
			f.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
