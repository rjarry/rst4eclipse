grammar Rst;

options {
  output=AST;
  language=Java;
  backtrack=true;
  memoize=true;
}

tokens {
  FILE;
  SECTION;
  TITLE;
  PARAGRAPH;
  INDENTATION;
  LINE;
  WORD;
  BOLD;
  ITALIC;
  INTERPRETED_TEXT;
  INLINE_LITERAL;
  REFERENCE;
  CLASS;
  SUBSTITUTION_REFERENCE;
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
  :  section+ EOF -> ^(FILE section+)
  ;

section
	:  sectionTitle sectionContent+ -> ^(SECTION sectionTitle sectionContent+)
  |  Space* LineBreak -> /* omit line-breaks between paragraphs from AST */
	;

sectionTitle
	:  line underline -> ^(TITLE line)
	;

sectionContent
  :  paragraph
  |  section
  |  Space* LineBreak -> /* omit line-breaks between paragraphs from AST */
  ;

underline
	:  (UnderScore|Star|Pipe|BackTick|Column|SpecialChar)+ LineBreak
	;

paragraph
  :  line+ LineBreak -> ^(PARAGRAPH line+)
  ;

line
  :  indentation text+ LineBreak
  ;

indentation
  :  Space* -> ^(INDENTATION Space*)
  ;

text
  :  styledText
  |  reference
  |  Space
  |  EscapeSequence
  |  SimpleChar
  |  Any
  ;

styledText
  :  bold
  |  italic
  |  inlineLiteral
  |  interpretedText
  ;

bold
  :  Star Star noStarAtom+ Star Star -> ^(BOLD noStarAtom+)
  ;  

italic
  :  Star noStarAtom+ Star -> ^(ITALIC noStarAtom+)
  ;

noStarAtom
  :  ~(Star | LineBreak)
  ;

interpretedText
  :  interpretedTextClass BackTick interpretedTextAtoms BackTick -> ^(INTERPRETED_TEXT interpretedTextClass interpretedTextAtoms)
  |  BackTick interpretedTextAtoms BackTick interpretedTextClass -> ^(INTERPRETED_TEXT interpretedTextClass interpretedTextAtoms)
  |  BackTick interpretedTextAtoms BackTick -> ^(INTERPRETED_TEXT interpretedTextAtoms)
  ;

interpretedTextAtoms
  :  ~BackTick+
  ;

interpretedTextClass
  :  Column classAtom Column -> ^(CLASS classAtom)
  ;

classAtom
  : SimpleChar+
  ;

inlineLiteral
  :  BackTick BackTick inlineLiteralAtoms BackTick BackTick -> ^(INLINE_LITERAL inlineLiteralAtoms)
  ;

inlineLiteralAtoms
  :  inlineLiteralAtom+
  ;

inlineLiteralAtom
  :  ~BackTick
  |  BackTick ~BackTick
  ;

reference
  :  simpleReference
  |  longReference
  |  substitutionReference
  ;

simpleReference
  :  simpleReferenceAtoms UnderScore -> ^(REFERENCE simpleReferenceAtoms)
  ;

simpleReferenceAtoms
  :  (SimpleChar|Any)+
  ;

longReference
  :  BackTick interpretedTextAtoms BackTick UnderScore -> ^(REFERENCE interpretedTextAtoms)
  ;

substitutionReference
	:  Pipe substitutionReferenceAtom+ Pipe -> ^(SUBSTITUTION_REFERENCE substitutionReferenceAtom+)
	;

substitutionReferenceAtom
	:  ~Pipe
	;

/***************
 * LEXER RULES *
 ***************/


UnderScore
  :  '_'
  ;

BackTick
  :  '`'
  ;

Star
  :  '*'
  ;

Pipe
  :  '|'
  ;

Column
  :  ':'
  ;

Space
  :  ' ' 
  |  '\t'
  ;

EscapeSequence
  :  '\\' ('*' | '`' | '|')
  ;

LineBreak
  :  '\r'? '\n'
  |  '\r'
  ;

SimpleChar
  :  '-'
  |  '0'..'9'
  |  'A'..'Z'
  |  'a'..'z'
  ;

SpecialChar
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

Any
  :  .
  ;
