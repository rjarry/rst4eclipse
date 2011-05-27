grammar Rst;

options {
  language = Java;
  output = AST;
}
tokens {
    INDENT;
    DEDENT;
}
@lexer::header {
package org.diabeteman.rst4eclipse.core.parser.grammar;
}
@parser::header {
package org.diabeteman.rst4eclipse.core.parser.grammar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.dltk.ast.DLTKToken;
import org.eclipse.dltk.ast.declarations.Decorator;
import org.eclipse.dltk.ast.declarations.MethodDeclaration;
import org.eclipse.dltk.ast.declarations.ModuleDeclaration;
import org.eclipse.dltk.ast.expressions.Expression;
import org.eclipse.dltk.ast.expressions.ExpressionList;
import org.eclipse.dltk.ast.expressions.NumericLiteral;
import org.eclipse.dltk.ast.expressions.StringLiteral;
import org.eclipse.dltk.ast.references.VariableReference;
import org.eclipse.dltk.ast.statements.Block;
import org.eclipse.dltk.ast.statements.Statement;
import org.eclipse.dltk.compiler.problem.IProblemReporter;

import org.diabeteman.rst4eclipse.core.parser.DLTKRstErrorReporter;
import org.diabeteman.rst4eclipse.core.parser.DLTKRstTokenConverter;
}
@lexer::members {
public int startPos=-1;
public void emitErrorMessage(String msg) {
}
}
@parser::members {
public DLTKRstErrorReporter reporter;
  
public ModuleDeclaration decl;
  
public int length;
public DLTKRstTokenConverter converter;
DLTKToken toDLTK(Token token) {
  return converter.convert(token);
}
public void emitErrorMessage(String msg) {
  reporter.reportMessage(msg);
}
public void reportError(RecognitionException e) {
  if( reporter != null ) {
    reporter.reportError(e);
  }
}
public void setStartEndForEmbracedExpr(Expression exp, Token lb, Token rb)
{
  exp.setStart(toDLTK(lb).getColumn());
  exp.setEnd(toDLTK(rb).getColumn()+1);
}
}
@rulecatch {
catch (RecognitionException re) {
  if( reporter != null ) {
    reporter.reportError(re);
  }
  recover(input,re);
}
catch (Throwable extre) {
  //System.err.println(t);
  if( reporter != null ) {
    reporter.reportThrowable(extre);
  }
}
}

document
  : section+ EOF
  ;

section
  : section_title section_content
  ;

section_title
  : {startPos==0}? => TEXT NEWLINE SPECIAL_CHAR+ NEWLINE
  ;
  
section_content
  : (section | body_element | transistion)*
  ;


transistion
  : BLANK_LINE SPECIAL_CHAR{4}? SPECIAL_CHAR* BLANK_LINE
  ;

body_element
  : directive
  ;


directive
  : directive_marker WS? directive_block?
  ;

directive_marker
  : '.. ' directive_name '::'
  ;
 
directive_name
  : IDENTIFIER
  ;

directive_block
  : NEWLINE directive_option+ (BLANK_LINE directive_content)?
  | NEWLINE BLANK_LINE directive_content
  | directive_arguments NEWLINE directive_option+ (BLANK_LINE directive_content)?
  | directive_arguments NEWLINE BLANK_LINE directive_content
  | NEWLINE INDENT directive_content 
  ;


directive_arguments
  : TEXT
  ;

directive_option
  : INDENT option_statement option_value NEWLINE
  ;

option_value
  : TEXT
  ;


directive_content
  : (INDENT TEXT NEWLINE)+
  ;



inline_litteral
  : DOUBLE_BACKTICK TEXT DOUBLE_BACKTICK
  ;

strong_emphasis
  : DOUBLE_STAR TEXT DOUBLE_STAR
  ;

emphasis
  : STAR TEXT STAR
  ;

interpreted_text
  : option_statement BACKTICK TEXT BACKTICK
  | BACKTICK TEXT BACKTICK option_statement
  | BACKTICK TEXT BACKTICK
  ;




option_statement
  : ':' IDENTIFIER ':'
  ;



comment_block
  : {startPos==0}? => '..' 
  ;



//////////////////
// LEXER TOKENS //
//////////////////



IDENTIFIER
  : ('a'..'z'|'A'..'Z') (('a'..'z'|'A'..'Z') | '0'..'9' | '_' | '.' | '-')+
  ;
DOUBLE_BACKTICK 
  : '``' 
  ;
BACKTICK 
  : '`' 
  ; 
DOUBLE_STAR 
  : '**' 
  ; 
STAR 
  : '*' 
  ;

SPECIAL_CHAR
  : (
     '!'
    |'"'
    |'#'
    |'$'
    |'%'
    |'&'
    |'\''
    |'('
    |')'
    |'*'
    |'+'
    |','
    |'-'
    |'.'
    |'/'
    |':'
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
    |'_'
    |'`'
    |'{'
    |'|'
    |'}'
    |'~'
    )
  ;

BLANK_LINE
  : WS? NEWLINE
  ;



/** Grab everything before a real symbol.  Then if newline, kill it
 *  as this is a blank line.  If whitespace followed by comment, kill it
 *  as it's a comment on a line by itself.
 *
 *  Ignore leading whitespace when nested in [..], (..), {..}.
 */
LEADING_WS
@init {int spaces = 0;}
  :  {startPos==0}? =>
      (
        (' ' {spaces++;}|'\t' {spaces += 8; spaces -= (spaces \% 8);})+
          {
            // make a string of n spaces where n is column number - 1
            char[] indentation = new char[spaces];
            for (int i=0; i<spaces; i++) indentation[i] = ' ';
            String s = new String(indentation);
            Token tok = new ClassicToken(LEADING_WS, new String(indentation));
            emit(tok);
          }
          // kill trailing newline if present and then ignore
        ( ('\r')? '\n' {if (token!=null) token.setChannel(99); else $channel=HIDDEN;} )*
           // {token.setChannel(99); }
      )
  ;

NEWLINE
  : (('\r')? '\n')+
  ;

TEXT
  : (options {greedy=false;}: (~'\n') )+
  ;
  
WS  
  : { startPos > 0 }? => (' '|'\t')+ { $channel=HIDDEN; }
  ; 