package fefolanguage.ast;

import fefolanguage.dataStructures.FefoSymbol;

public class CommandLeitura extends AbstractCommand{
	private String id;
	private FefoSymbol var;
	
	public CommandLeitura (String id, FefoSymbol var) {
		this.id = id;
		this.var = var;
	}
	
	@Override
	public String generateJavaCode() {
		if(var.getType() == 0)
			return id + " = scanner.nextInt();\n";
		if(var.getType() == 1)
			return id + " = scanner.nextDouble();\n";
		if(var.getType() == 2)
			return id + " = scanner.nextLine();\n";
		else
			return id + " = scanner.nextBoolean();\n";
	}

	@Override
	public String generateJavaScriptCode() {
		return id + " = prompt(\"Digite o valor de " + id +  "\");\n";
	}

	

		
	
}
