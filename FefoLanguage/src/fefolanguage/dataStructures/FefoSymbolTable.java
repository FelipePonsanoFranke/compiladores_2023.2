package fefolanguage.dataStructures;

import java.util.ArrayList;
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

	public ArrayList<FefoSymbol> getAllSymbols(){
		ArrayList<FefoSymbol> lista = new ArrayList<FefoSymbol>();
		for (FefoSymbol f : map.values())
			lista.add(f);
		return lista;
	}
}
