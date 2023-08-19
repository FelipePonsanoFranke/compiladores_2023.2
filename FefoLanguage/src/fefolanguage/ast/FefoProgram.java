package fefolanguage.ast;

import java.io.FileWriter;
import java.io.File;
import java.util.ArrayList;

import fefolanguage.dataStructures.FefoSymbol;
import fefolanguage.dataStructures.FefoSymbolTable;

public class FefoProgram {
	private static int LinguagemAlvo = 0;
	
	private FefoSymbolTable vartable;
	private ArrayList<AbstractCommand> comandos;
	private String progName;
	public void generateTarget() {
		StringBuilder str = new StringBuilder();
		if(LinguagemAlvo == 1) { //1 para js
			for (FefoSymbol symbol: vartable.getAllSymbols()) 
				str.append(symbol.generateJavaScriptCode());
			for(AbstractCommand command : comandos) {
				str.append(command.generateJavaScriptCode());
			}
		}
		else {//gera java 

			str.append("import java.util.Scanner;\n");
			str.append("public class MainClass{\n");
			str.append("public static void main(String args[]){\n");
			str.append("Scanner scanner = new Scanner(System.in);\n");
			for (FefoSymbol symbol: vartable.getAllSymbols()) 
				str.append(symbol.generateJavaCode());
			
			for(AbstractCommand command : comandos) {
				str.append(command.generateJavaCode());
			}
			str.append("}\n");
			str.append("}\n");
		}
		try {
			FileWriter fr = new FileWriter(new File(LinguagemAlvo == 1 ?"main.js" : "MainClass.java"));
			fr.write(str.toString());
			fr.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		System.out.print(str);
	}
	
	public static int getLinguagemAlvo() {
		return LinguagemAlvo;
	}

	public static void setLinguagemAlvo(int linguagemAlvo) {
		LinguagemAlvo = linguagemAlvo;
	}

	public FefoSymbolTable getVartable() {
		return vartable;
	}
	public void setVartable(FefoSymbolTable vartable) {
		this.vartable = vartable;
	}
	public ArrayList<AbstractCommand> getComandos() {
		return comandos;
	}
	public void setComandos(ArrayList<AbstractCommand> comandos) {
		this.comandos = comandos;
	}
	public String getProgName() {
		return progName;
	}
	public void setProgName(String progName) {
		this.progName = progName;
	}
}
