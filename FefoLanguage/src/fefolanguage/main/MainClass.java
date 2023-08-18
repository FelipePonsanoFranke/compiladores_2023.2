package fefolanguage.main;


import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import fefolanguage.parser.FefoLangLexer;
import fefolanguage.parser.FefoLangParser;
import fefolanguage.exceptions.FefoExceptions;


public class MainClass {
	public static void main(String[] args) {
		try {
			//instanciando o lexer e o parser
			FefoLangLexer lexer;
			FefoLangParser parser;
			
			//inicializando o lexer
			lexer = new FefoLangLexer(CharStreams.fromFileName("input.fefo"));
			
			CommonTokenStream tokenStream = new CommonTokenStream(lexer);
			
			parser = new FefoLangParser(tokenStream);
			parser.prog();
			
			System.out.println("Compilação concluida");
		}//catch(FefoExceptions ex) {
		//	System.out.println("Erro: " + ex.getMessage());
		//}
		catch(Exception ex) {
			System.out.println("ERROR " + ex.getMessage());
		}
	}
}
