grammar FefoLang;


programa : 'programa' expr 'fimprog'
         ;
         
expr	 : termo exprl
         ;
         
exprl	 : (OP termo)* 
		 ;        
         
termo    : ID 
         | NUM  
         ;
         
OP		 : '+' | '-' | '*' | '/'
         ;
         
ID		 : [a-z] ([a-z] | [A-Z] | [0-9])*
		 ;
		 
NUM		 : [0-9]+ ('.' [0-9]+)?
		 ;
		 
WS       : (' ' | '\t' | '\n' | '\r') -> skip
         ;		 		                     