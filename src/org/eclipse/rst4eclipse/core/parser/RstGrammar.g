grammar RstGrammar;

options {
  language = Java;
  output = AST;
}


directive
  : directive_marker directive_block?
  ;

directive_marker
  : '.. ' directive_name '::'
  ;
  
directive_name
  : IDENTIFIER
  ;

directive_block
  : NEWLINE directive_option+ (blank_line directive_content)?
  | NEWLINE blank_line directive_content
  | directive_arguments NEWLINE directive_option+ (blank_line directive_content)?
  | directive_arguments NEWLINE blank_line directive_content
  | WS directive_content 
  | NEWLINE WS directive_content 
  ;


directive_arguments
  : WS (IDENTIFIER|WS)+
  ;

directive_option
  : WS ':' option_name ': ' option_value NEWLINE
  ;

option_name
  : IDENTIFIER
  ;

option_value
  : (IDENTIFIER|WS)+
  ;


directive_content
  : ((IDENTIFIER|WS)+ NEWLINE)*
  ;

  
blank_line
  : WS? NEWLINE
  ;


IDENTIFIER
  : LETTER (LETTER | DIGIT | '_' | '.' | '-')+
  ;

fragment LETTER
  : ('a'..'z'|'A'..'Z')
  ;
fragment DIGIT
  : '0'..'9'
  ;

NEWLINE
  : '\r'? '\n'
  ;

/** whitespace or tab **/
WS
  : (' '|'\t')
  ;

