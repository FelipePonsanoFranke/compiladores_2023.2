package fefolanguage.dataStructures;

import java.util.HashMap;

public class FefoSymbolTable {
	private HashMap<String, FefoSymbol> map;
	
	public FefoSymbolTable() {
		map = new HashMap<String, FefoSymbol>();
	}
	
	public void add (FefoSymbol symbol) {
		map.put(symbol.getName(), symbol);
	}
	
	public boolean exists (String symbolName) {
		return map.get(symbolName) != null;
	}
	
	public FefoSymbol get(String symbolName) {
		return map.get(symbolName);
	}
}
