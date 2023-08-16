grammar FefoLang;

@header{
	import java.util.ArrayList;
	import fefolanguage.dataStructures.*;
	import fefolanguage.exceptions.FefoExceptions;
	import fefolanguage.ast.*;
}

@members{
	private ArrayList<String> listaDeTokens = new ArrayList<String>();
	private ArrayList<String> listaDeVariaveis = new ArrayList<String>();
	
	private int _tipo;
	private String _varName;
	private boolean _varValue;
	private FefoSymbolTable _symbolTable = new FefoSymbolTable();
	private FefoSymbol _symbol;
	private int _tipoExprEsquerda;
	private int _tipoExprDireita;
	private FefoBinaryExpression _expressao = new FefoBinaryExpression();
	
	private FefoProgram _program;
	private ArrayList<AbstractCommand> _curThread = new ArrayList<AbstractCommand>();
	private String _readId;
	private String _writeId;
		
	private void inicializaID(){
		_varName = ((TokenStream) _input).LT(-1).getText();
		_varValue = false;
		_symbol = new FefoSymbol(_varName, _tipo, _varValue);
		if (!_symbolTable.exists(_varName)){
			_symbolTable.add(_symbol);
			listaDeVariaveis.add(_varName);
		}
		else{
			throw new FefoExceptions("Variável " + _varName + " já inicializada anteriormente!");
		}
	}
	
	
	private void utilizaID(){
		_varName = ((TokenStream) _input).LT(-1).getText();
		if(!_symbolTable.exists(_varName))
			throw new FefoExceptions("Variável \"" + _varName + "\" nunca declarada.");	
		else{
			_symbolTable.get(_varName).setUsado(true);
		}	
	}
	
	private void finalizaPrograma(){
		//vou passar por todas as variáveis declaradas para ver se elas são usadas.
		for (int i = 0; i < listaDeVariaveis.size(); i++){
			_symbol = _symbolTable.get(listaDeVariaveis.get(i));
			//gero um aviso, mas não um erro de compilação
			if(!_symbol.getUsado())
				System.out.println("Aviso! Variável \"" + _symbol.getName() + "\" declarada, mas nunca usada");
		}
	}
}

prog 	: 'programa' bloco 'fimprog' {finalizaPrograma();}
        ;
         
		
bloco	: (cmd)+
        ;

cmd		: cmdDeclaracao | cmdLeitura | cmdEscrita | cmdCondicao | cmdAtribuicao
        ; 

cmdDeclaracao	: tipo ID {inicializaID();} ( VIR ID {inicializaID();} )* PF
				;
				
tipo			: 'inteiro'{ _tipo = FefoSymbol.INTEGER;} 
				| 'decimal' {_tipo = FefoSymbol.DOUBLE;}
				| 'texto' {_tipo = FefoSymbol.TEXT;}
				| 'booleano' {_tipo = FefoSymbol.BOOLEAN;}
				;
		   
cmdLeitura		: 'leia' AP ID {utilizaID();
								_symbolTable.get(_varName).setValue(true);
								_readId = ((TokenStream) _input).LT(-1).getText();
								} 
								FP 
								PF { CommandLeitura cmd = new CommandLeitura(_readId);
									_curThread.add(cmd);
								}
				;
	
cmdEscrita		: 'escreva' AP (TEXTO | ID {utilizaID();
											if(!_symbolTable.get(_varName).getValue())
												throw new FefoExceptions("Variável " + _varName + " utilizada antes de seu valor ter sido atribuído.");
											_writeId = ((TokenStream) _input).LT(-1).getText();
											}) FP
											 PF {CommandEscrita cmd = new CommandEscrita(_writeId);
											 _curThread.add(cmd);
											 }
				;
				

		
cmdCondicao		: 'se' AP expr opRel expr FP 'entao' ACH bloco FCH ('senao' ACH bloco FCH)?
				;
				
cmdAtribuicao	:	ID {utilizaID();
						_tipoExprEsquerda = _symbolTable.get(_varName).getType();
						}
					opAtr expr {if(_tipoExprEsquerda != _tipoExprDireita && _tipoExprEsquerda <= 1 && _tipoExprDireita <= 1)
									System.out.println("Alerta! Atribuição com possível perda de informação entre um decimal e um inteiro.");
								else if(_tipoExprEsquerda != _tipoExprDireita)
									throw new FefoExceptions("Atribuição com tipos incompatíveis!");
								_symbolTable.get(_varName).setValue(true);
								}PF
				;
		
opAtr			: ':='
				;	
		
opRel			: '<' | '>' | '<=' | '>=' | '!=' | '=='
				;
				
expr			: termo exprLinha*
				;
				
exprLinha		: opExpr 	{_expressao.setTipoEsquerda(_tipoExprDireita);
							 _expressao.setOperador(_input.LT(-1).getText());
							 } 
					termo	{_expressao.setTipoDireita(_tipoExprDireita);
							_tipoExprDireita = _expressao.eval();
							}
				;
		 
opExpr			: '+' | '-' | '*' | '/' | opRel
				;
				

termo			: INTEIRO { _tipoExprDireita = FefoSymbol.INTEGER;}
				| DECIMAL {_tipoExprDireita = FefoSymbol.DOUBLE;} 
				| BOOLEANO {_tipoExprDireita = FefoSymbol.BOOLEAN;}
				| TEXTO {_tipoExprDireita = FefoSymbol.TEXT;}
				| ID 	{utilizaID();
						if(!_symbolTable.get(_varName).getValue())
							throw new FefoExceptions("Variável " + _varName + " utilizada antes de seu valor ter sido atribuído.");
						_tipoExprDireita = _symbolTable.get(_varName).getType();
						}
				| AP expr FP
				;
				
				
ASPAS			: '"'
				;
				
DECIMAL	 		: ('-')? [0-9]+ ',' [0-9]+
		 		;
		 		
INTEIRO			: ('-')? [0-9]+
				;
	
BOOLEANO		: 'true' | 'false'
				;
				
TEXTO			: ASPAS ([a-z] | [A-Z] | [0-9])+ ASPAS
				;
				
ID 				: [a-z] ([a-z] | [A-Z] | [0-9])*
				;
				
VIR  			: ','
     			;
     
ACH  			: '{'
     			;
     
FCH  			: '}'
     			;
     			
AP				: '('
				;
	
FP				: ')'
				;
				
PF				:'.'
				;
		 
WS       		: (' ' | '\t' | '\n' | '\r') -> skip
         		;		 		                     