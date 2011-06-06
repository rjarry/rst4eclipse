grammar Rst;

options {
  output=AST;
  language=Java;
  backtrack=true;
  memoize=true;
}

tokens {
  File;
  Section;
  Title;
  Paragraph;
  Indent;
  Dedent;
  Line;
  Word;
  Bold;
  Italic;
  InterpretedText;
  InlineLitteral;
  Reference;
  Class;
  SubstitutionReference;
}

@lexer::header {
package org.diabeteman.rst4eclipse;
}
@parser::header {
package org.diabeteman.rst4eclipse;
}

/****************
 * PARSER RULES *
 ****************/

file
  :  section+ EOF -> ^(File section+)
  ;

section
	:  section_title section_content+ -> ^(Section section_title section_content+)
//  |  empty_line* -> /* omit line-breaks between paragraphs from AST */
	;

section_title
	: line underline[$line.length] 
	 {System.out.println("Matched Title: '" + $line.content + "' length: " + $line.length);}
	         -> ^(Title line)
	;

section_content
  :  underline[4]
  |  paragraph
  |  section
//  |  empty_line* -> /* omit line-breaks between paragraphs from AST */
  ;

underline[int minLength] returns [char symbol]
@init {
$symbol = (char) 0;
int length = 0;
}
  : first=underline_atom   {$symbol=$first.symbol; length++;}
    (  next=underline_atom    {$symbol == $next.symbol}?    {length++;}   )+   
    {length >= minLength}?
    LINE_BREAK
  ;

underline_atom returns [char symbol]
@init {
$symbol = (char) 0;
}
  : (UNDERSCORE | STAR | PIPE | BACKTICK | COLUMN | SPECIAL_CHAR)
    {$symbol = $text.charAt(0);}
  ;


paragraph
  :  line+ LINE_BREAK -> ^(Paragraph line+)
  ;

line returns [int length, String content]
@init {
$length = 0;
$content = null;
}
  :  any_text+ 
  {
      $length = $text.length();
      $content = $text;
  } 
    LINE_BREAK
  ;

any_text
  :  styled_text
  |  reference
  |  WS
  |  ESCAPE_SEQUENCE
  |  SIMPLE_CHAR
  |  ANY
  ;

styled_text
  :  bold
  |  italic
  |  inline_litteral
  |  interpreted_text
  ;

bold
  :  STAR STAR no_star_atom+ STAR STAR -> ^(Bold no_star_atom+)
  ;  

italic
  :  STAR no_star_atom+ STAR -> ^(Italic no_star_atom+)
  ;

no_star_atom
  :  ~(STAR | LINE_BREAK)
  ;

interpreted_text
  :  interpreted_text_class BACKTICK interpreted_text_atoms BACKTICK 
                -> ^(InterpretedText interpreted_text_class interpreted_text_atoms)
  |  BACKTICK interpreted_text_atoms BACKTICK interpreted_text_class 
                -> ^(InterpretedText interpreted_text_class interpreted_text_atoms)
  |  BACKTICK interpreted_text_atoms BACKTICK 
                -> ^(InterpretedText interpreted_text_atoms)
  ;

interpreted_text_atoms
  :  ~BACKTICK+
  ;

interpreted_text_class
  :  COLUMN class_atom COLUMN -> ^(Class class_atom)
  ;

class_atom
  : SIMPLE_CHAR+
  ;

inline_litteral
  :  BACKTICK BACKTICK inline_litteral_atoms BACKTICK BACKTICK 
                -> ^(InlineLitteral inline_litteral_atoms)
  ;

inline_litteral_atoms
  :  inline_litteral_atom+
  ;

inline_litteral_atom
  :  ~BACKTICK
  |  BACKTICK ~BACKTICK
  ;

reference
  :  simple_reference
  |  long_reference
  |  substitution_reference
  ;

simple_reference
  :  simple_reference_atoms UNDERSCORE -> ^(Reference simple_reference_atoms)
  ;

simple_reference_atoms
  :  (SIMPLE_CHAR|ANY)+
  ;

long_reference
  :  BACKTICK interpreted_text_atoms BACKTICK UNDERSCORE -> ^(Reference interpreted_text_atoms)
  ;

substitution_reference
	:  PIPE substitution_reference_atom+ PIPE -> ^(SubstitutionReference substitution_reference_atom+)
	;

substitution_reference_atom
	:  ~PIPE
	;

//empty_line
//  :  LEADING_WS? LINE_BREAK
//  ;

/***************
 * LEXER RULES *
 ***************/



UNDERSCORE
  :  '_'
  ;

BACKTICK
  :  '`'
  ;

STAR
  :  '*'
  ;

PIPE
  :  '|'
  ;

COLUMN
  :  ':'
  ;

SPECIAL_CHAR
  :  (
     '!'
    |'"'
    |'#'
    |'$'
    |'%'
    |'&'
    |'\''
    |'('
    |')'
    |'+'
    |','
    |'.'
    |'/'
    |';'
    |'<'
    |'='
    |'>'
    |'?'
    |'@'
    |'['
    |'\\'
    |']'
    |'^'
    |'{'
    |'}'
    |'~'
    )
  ;

ESCAPE_SEQUENCE
  :  '\\' ('*' | '`' | '|' | '\\')
  ;


SIMPLE_CHAR
  :  '-'
  |  '0'..'9'
  |  'A'..'Z'
  |  'a'..'z'
  ;


LINE_BREAK
  :  '\r'? '\n'
  ;


WS
  :  /*{getCharPositionInLine()>0}?=>*/ (' '|'\t'|'\u000C')+
  ;

//LEADING_WS
//@init {
//int spaces = 0;
//}
//    :   {getCharPositionInLine() == 0}?=>
//        (
//            (' ' {spaces++;}|'\u000C' {spaces++;}|'\t' {spaces += 8; spaces -= (spaces \% 8);})+
//            {
//                // make a string of n spaces where n is column number - 1
//                char[] indentation = new char[spaces];
//                for (int i=0; i<spaces; i++) {
//                    indentation[i] = ' ';
//                }
//                String s = new String(indentation);
//                emit(new ClassicToken(LEADING_WS, s));
//            }
//        )
//    ;

ANY
  :  .
  ;
