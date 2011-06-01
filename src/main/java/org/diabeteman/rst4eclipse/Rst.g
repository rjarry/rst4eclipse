grammar Rst;

options {
    output=AST;
    language=Java;
   //filter=true;
}

@lexer::header {
package org.diabeteman.rst4eclipse;
}
@parser::header {
package org.diabeteman.rst4eclipse;
}
@members {
boolean inInlineMarkup = false;
}

//////////////////
// PARSER RULES //
//////////////////

file
  : line* EOF
  ;


line
  : text* NEWLINE
  ;

text
    : LITTERAL
    | HYPERLINK_REFERENCE
    | INTERPRETED_TEXT
    | STRONG
    | EMPHASIS
    | SUBSTITUTION_REFERENCE
    | ANY
    ;

//inline_markup
//@after {
//inInlineMarkup = false;
//}
//    : {!inInlineMarkup}? {inInlineMarkup = true;} 
//  (
//  | STRONG
//  | EMPHASIS
//  | LITTERAL
//  | INTERPRETED_TEXT
//  | SUBSTITUTION_REFERENCE
//  | link
//  )
//    ;
//
//
//link
//    : INLINE_INTERNAL_TARGET
//    | FOOTNOTE_REFERENCE
//    | HYPERLINK_REFERENCE
//    ;




//////////////////
// LEXER TOKENS //
//////////////////



STRONG
  : '**' ANY_BUT_STAR+ '**' {System.out.println("STRONG: " + $text);}
  ;
EMPHASIS
  : '*' ANY_BUT_STAR+ '*' {System.out.println("EMPHASIS: " + $text);}
  ;
SUBSTITUTION_REFERENCE
  : '|' ANY_BUT_PIPE+ '|'  {System.out.println("SUBST_REF: " + $text);}
  ;
LITTERAL
  : '``' ANY_BUT_BACKTICK+ '``' {System.out.println("LITTERAL: " + $text);}
  ;
HYPERLINK_REFERENCE
  : '`' ANY_BUT_BACKTICK+ '`_' {System.out.println("HYPERLINK_REFERENCE (long): " + $text);}
  ;
INTERPRETED_TEXT
  : OPTION_DEF '`' ANY_BUT_BACKTICK+ '`' {System.out.println("INTERPRETED_TEXT: " + $text);}
  | '`' ANY_BUT_BACKTICK+ '`' OPTION_DEF? {System.out.println("INTERPRETED_TEXT: " + $text);}
  ;
ID
  : ('A'..'Z'|'a'..'z')('A'..'Z'|'a'..'z'|'0'..'9')*
  ;
OPTION_DEF
  : ':' ID ':'
  ;
ANY
  : ANY_BUT_SPECIAL+ {System.out.println("ANY: " + $text);}
  ;
//
//INLINE_INTERNAL_TARGET
//    : UNDERSCORE BACKTICK ANY_BUT_BACKTICK+ BACKTICK {System.out.println("INLINE_INTERNAL_TARGET: " + $text);}
//    ;
//
//FOOTNOTE_REFERENCE
//    : L_BRACKET ANY_BUT_BRACKET+ R_BRACKET UNDERSCORE {System.out.println("FOOTNOTE_REFERENCE: " + $text);}
//    ;
//
//



NEWLINE
  : ('\r'? '\n') => '\r'? '\n'
  | '\r'
  ;


///////////////
// FRAGMENTS //
///////////////

fragment ANY_BUT_SPECIAL
  : '\\*'
  | '\\`'
  | '\\|'
  | ~('*'|'|'|'`'|'\n'|'\r')
  ;
fragment ANY_BUT_PIPE
  : '\\|'
  | ~('|'|'\n'|'\r')
  ;
//fragment ANY_BUT_BRACKET
//  : ESC R_BRACKET
//  | ~(R_BRACKET|'\n'|'\r')
//  ;
fragment ANY_BUT_STAR
  : '\\*' 
  | ~('*'|'\n'|'\r')
  ;
fragment ANY_BUT_BACKTICK
  : '\\`'
  | ~('`'|'\n'|'\r')
  ;
//fragment ANY_BUT_ENDLINK
//  : ~(UNDERSCORE|' '|'\t'|'\n'|'\r')
//  ;
//
//
//
//fragment ESC
//  : '\\'
//  ;
//fragment STAR
//  : '*'
//  ;
//fragment BACKTICK
//  : '`'
//  ;
//fragment PIPE
//  : '|'
//  ;
//fragment L_BRACKET
//  : '['
//  ;
//fragment R_BRACKET
//  : ']'
//  ;
//fragment UNDERSCORE
//  : '_'
//  ;
