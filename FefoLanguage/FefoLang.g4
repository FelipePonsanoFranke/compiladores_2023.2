grammar FefoLang;

@header{
import java.util.Stack;
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
	
	private FefoProgram _program = new FefoProgram();
	private ArrayList<AbstractCommand> _curThread;
	private String _readId;
	private String _writeId;
	private String _exprID;
	private String _exprContent;
	private Stack<ArrayList<AbstractCommand>> _stack = new Stack<ArrayList<AbstractCommand>>();
	private String _exprDecision;
	private String _exprLoop;
	private ArrayList<AbstractCommand> _listaTrue;
	private ArrayList<AbstractCommand> _listaFalse;
	private ArrayList<AbstractCommand> _listaLoop;
		
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
		_program.setComandos(_stack.pop());
		_program.setVartable(_symbolTable);
		_program.generateTarget();
	}

}

prog 	: 'programa' bloco 'fimprog' {finalizaPrograma();}
        ;
         
		
bloco	: {_curThread = new ArrayList<AbstractCommand>();
			_stack.push(_curThread);
			}
			(cmd)+
        ;

cmd		: cmdDeclaracao | cmdLeitura | cmdEscrita | cmdCondicao | cmdAtribuicao | cmdLoop
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
								PF {FefoSymbol var =  _symbolTable.get(_readId);
									CommandLeitura cmd = new CommandLeitura(_readId, var);
									_stack.peek().add(cmd);
								}
				;
	
cmdEscrita		: 'escreva' AP (TEXTO {_writeId = ((TokenStream) _input).LT(-1).getText();}
								| ID {utilizaID();
								if(!_symbolTable.get(_varName).getValue())
									throw new FefoExceptions("Variável " + _varName + " utilizada antes de seu valor ter sido atribuído.");
								_writeId = ((TokenStream) _input).LT(-1).getText();
								}) FP
								 PF {CommandEscrita cmd = new CommandEscrita(_writeId);
								 _stack.peek().add(cmd);
								 }
				;
				
				
cmdAtribuicao	:	ID {utilizaID();
						_symbolTable.get(_varName).setValue(true);
						_tipoExprEsquerda = _symbolTable.get(_varName).getType();
						_exprID = ((TokenStream) _input).LT(-1).getText();
						}
					opAtr { _exprContent = "";}
					expr {if(_tipoExprEsquerda != _tipoExprDireita)
								throw new FefoExceptions("Atribuição com tipos incompatíveis!");
							}
								PF {CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);
									_stack.peek().add(cmd);}
				;
				
cmdCondicao		: 'se' AP ID{utilizaID();
						if(!_symbolTable.get(_varName).getValue())
							throw new FefoExceptions("Valor da variável " +_varName + " utilizado antes de ser atribuído.");
						if(_symbolTable.get(_varName).getType() != 3)
							throw new FefoExceptions("Variável não booleana " +_varName + " utilizado em um comando \"se\"");
						_exprDecision = ((TokenStream) _input).LT(-1).getText();
						} 
				FP 'entao' { _listaTrue = null;
							_listaFalse = null;}
				ACH
				bloco
				FCH {_listaTrue = _stack.pop();}
				(
				'senao'
				 ACH
				 bloco
				 FCH{_listaFalse = _stack.pop();
				 CommandDecisao cmd = new CommandDecisao(_exprDecision, _listaTrue, _listaFalse);
				 _stack.peek().add(cmd);
				 }
				 )?
				;
		
cmdLoop			:	'enquanto' AP ID {utilizaID();
									if(!_symbolTable.get(_varName).getValue())
										throw new FefoExceptions("Valor da variável " +_varName + " utilizado antes de ser atribuído.");
									if(_symbolTable.get(_varName).getType() != 3)
										throw new FefoExceptions("Variável não booleana " +_varName + " utilizado em um comando \"enquanto\"");
									_exprLoop = ((TokenStream) _input).LT(-1).getText();
									} 
					 FP ACH {_listaLoop = null;}
					 bloco FCH {_listaLoop = _stack.pop();
					 			CommandLoop cmd = new CommandLoop(_exprLoop, _listaLoop, CommandLoop.WHILE);
					 			_stack.peek().add(cmd);}
					 			
					 | 'faca'  ACH {_listaLoop = null;}
					 	bloco
					 	FCH 'enquanto' AP ID {utilizaID();
									if(!_symbolTable.get(_varName).getValue())
										throw new FefoExceptions("Valor da variável " +_varName + " utilizado antes de ser atribuído.");
									if(_symbolTable.get(_varName).getType() != 3)
										throw new FefoExceptions("Variável não booleana " +_varName + " utilizado em um comando \"enquanto\"");
									_exprLoop = ((TokenStream) _input).LT(-1).getText();
									} 
									FP PF {_listaLoop = _stack.pop();
					 					CommandLoop cmd = new CommandLoop(_exprLoop, _listaLoop, CommandLoop.DoWHILE);
					 					_stack.peek().add(cmd);}
				;
				
				
				
opAtr			: ':='
				;	
		
opRel			: '<' | '>' | '<=' | '>=' | '!=' | '=='
				;
				
expr			: termo exprLinha*
				;
				
exprLinha		: opExpr 	{_expressao.setTipoEsquerda(_tipoExprDireita);
							 _expressao.setOperador(_input.LT(-1).getText());
							 _exprContent += ((TokenStream) _input).LT(-1).getText();
							 } 
					termo	{_expressao.setTipoDireita(_tipoExprDireita);
							_tipoExprDireita = _expressao.eval();
							}
				;
		 
opExpr			: '+' | '-' | '*' | '/' | opRel
				;
				

termo			: INTEIRO { _tipoExprDireita = FefoSymbol.INTEGER;
							_exprContent += ((TokenStream) _input).LT(-1).getText();}
				| DECIMAL {_tipoExprDireita = FefoSymbol.DOUBLE;
							_exprContent += ((TokenStream) _input).LT(-1).getText();} 
				| BOOLEANO {_tipoExprDireita = FefoSymbol.BOOLEAN;
							_exprContent += ((TokenStream) _input).LT(-1).getText();}
				| TEXTO {_tipoExprDireita = FefoSymbol.TEXT;
						_exprContent += ((TokenStream) _input).LT(-1).getText();}
				| ID 	{utilizaID();
						_exprContent += ((TokenStream) _input).LT(-1).getText();
						if(!_symbolTable.get(_varName).getValue())
							throw new FefoExceptions("Variável " + _varName + " utilizada antes de seu valor ter sido atribuído.");
						_tipoExprDireita = _symbolTable.get(_varName).getType();
						}
				;
				
				
ASPAS			: '"'
				;
				
DECIMAL	 		: ('-')? [0-9]+ '.' [0-9]+
		 		;
		 		
INTEIRO			: ('-')? [0-9]+
				;
	
BOOLEANO		: 'true' | 'false'
				;
				
TEXTO			:  '"' (~["])+ '"'
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