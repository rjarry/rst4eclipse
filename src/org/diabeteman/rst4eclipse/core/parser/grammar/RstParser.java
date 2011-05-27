// $ANTLR 3.0.1 D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g 2011-05-27 16:44:09

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


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class RstParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "INDENT", "DEDENT", "TEXT", "NEWLINE", "SPECIAL_CHAR", "BLANK_LINE", "WS", "IDENTIFIER", "DOUBLE_BACKTICK", "DOUBLE_STAR", "STAR", "BACKTICK", "LEADING_WS", "'.. '", "'::'", "':'", "'..'"
    };
    public static final int BACKTICK=15;
    public static final int STAR=14;
    public static final int WS=10;
    public static final int NEWLINE=7;
    public static final int IDENTIFIER=11;
    public static final int SPECIAL_CHAR=8;
    public static final int DEDENT=5;
    public static final int BLANK_LINE=9;
    public static final int TEXT=6;
    public static final int EOF=-1;
    public static final int DOUBLE_BACKTICK=12;
    public static final int INDENT=4;
    public static final int LEADING_WS=16;
    public static final int DOUBLE_STAR=13;

        public RstParser(TokenStream input) {
            super(input);
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g"; }

    
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


    public static class document_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start document
    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:81:1: document : ( section )+ EOF ;
    public final document_return document() throws RecognitionException {
        document_return retval = new document_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token EOF2=null;
        section_return section1 = null;


        Object EOF2_tree=null;

        try {
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:82:3: ( ( section )+ EOF )
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:82:5: ( section )+ EOF
            {
            root_0 = (Object)adaptor.nil();

            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:82:5: ( section )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==TEXT) && (startPos==0)) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:82:5: section
            	    {
            	    pushFollow(FOLLOW_section_in_document90);
            	    section1=section();
            	    _fsp--;

            	    adaptor.addChild(root_0, section1.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);

            EOF2=(Token)input.LT(1);
            match(input,EOF,FOLLOW_EOF_in_document93); 
            EOF2_tree = (Object)adaptor.create(EOF2);
            adaptor.addChild(root_0, EOF2_tree);


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        
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
        finally {
        }
        return retval;
    }
    // $ANTLR end document

    public static class section_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start section
    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:85:1: section : section_title section_content ;
    public final section_return section() throws RecognitionException {
        section_return retval = new section_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        section_title_return section_title3 = null;

        section_content_return section_content4 = null;



        try {
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:86:3: ( section_title section_content )
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:86:5: section_title section_content
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_section_title_in_section106);
            section_title3=section_title();
            _fsp--;

            adaptor.addChild(root_0, section_title3.getTree());
            pushFollow(FOLLOW_section_content_in_section108);
            section_content4=section_content();
            _fsp--;

            adaptor.addChild(root_0, section_content4.getTree());

            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        
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
        finally {
        }
        return retval;
    }
    // $ANTLR end section

    public static class section_title_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start section_title
    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:89:1: section_title : {...}? => TEXT NEWLINE ( SPECIAL_CHAR )+ NEWLINE ;
    public final section_title_return section_title() throws RecognitionException {
        section_title_return retval = new section_title_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token TEXT5=null;
        Token NEWLINE6=null;
        Token SPECIAL_CHAR7=null;
        Token NEWLINE8=null;

        Object TEXT5_tree=null;
        Object NEWLINE6_tree=null;
        Object SPECIAL_CHAR7_tree=null;
        Object NEWLINE8_tree=null;

        try {
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:90:3: ({...}? => TEXT NEWLINE ( SPECIAL_CHAR )+ NEWLINE )
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:90:5: {...}? => TEXT NEWLINE ( SPECIAL_CHAR )+ NEWLINE
            {
            root_0 = (Object)adaptor.nil();

            if ( !(startPos==0) ) {
                throw new FailedPredicateException(input, "section_title", "startPos==0");
            }
            TEXT5=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_section_title125); 
            TEXT5_tree = (Object)adaptor.create(TEXT5);
            adaptor.addChild(root_0, TEXT5_tree);

            NEWLINE6=(Token)input.LT(1);
            match(input,NEWLINE,FOLLOW_NEWLINE_in_section_title127); 
            NEWLINE6_tree = (Object)adaptor.create(NEWLINE6);
            adaptor.addChild(root_0, NEWLINE6_tree);

            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:90:36: ( SPECIAL_CHAR )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==SPECIAL_CHAR) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:90:36: SPECIAL_CHAR
            	    {
            	    SPECIAL_CHAR7=(Token)input.LT(1);
            	    match(input,SPECIAL_CHAR,FOLLOW_SPECIAL_CHAR_in_section_title129); 
            	    SPECIAL_CHAR7_tree = (Object)adaptor.create(SPECIAL_CHAR7);
            	    adaptor.addChild(root_0, SPECIAL_CHAR7_tree);


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);

            NEWLINE8=(Token)input.LT(1);
            match(input,NEWLINE,FOLLOW_NEWLINE_in_section_title132); 
            NEWLINE8_tree = (Object)adaptor.create(NEWLINE8);
            adaptor.addChild(root_0, NEWLINE8_tree);


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        
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
        finally {
        }
        return retval;
    }
    // $ANTLR end section_title

    public static class section_content_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start section_content
    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:93:1: section_content : ( section | body_element | transistion )* ;
    public final section_content_return section_content() throws RecognitionException {
        section_content_return retval = new section_content_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        section_return section9 = null;

        body_element_return body_element10 = null;

        transistion_return transistion11 = null;



        try {
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:94:3: ( ( section | body_element | transistion )* )
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:94:5: ( section | body_element | transistion )*
            {
            root_0 = (Object)adaptor.nil();

            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:94:5: ( section | body_element | transistion )*
            loop3:
            do {
                int alt3=4;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==TEXT) && (startPos==0)) {
                    int LA3_2 = input.LA(2);

                    if ( (startPos==0) ) {
                        alt3=1;
                    }


                }
                else if ( (LA3_0==17) ) {
                    alt3=2;
                }
                else if ( (LA3_0==BLANK_LINE) ) {
                    alt3=3;
                }


                switch (alt3) {
            	case 1 :
            	    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:94:6: section
            	    {
            	    pushFollow(FOLLOW_section_in_section_content148);
            	    section9=section();
            	    _fsp--;

            	    adaptor.addChild(root_0, section9.getTree());

            	    }
            	    break;
            	case 2 :
            	    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:94:16: body_element
            	    {
            	    pushFollow(FOLLOW_body_element_in_section_content152);
            	    body_element10=body_element();
            	    _fsp--;

            	    adaptor.addChild(root_0, body_element10.getTree());

            	    }
            	    break;
            	case 3 :
            	    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:94:31: transistion
            	    {
            	    pushFollow(FOLLOW_transistion_in_section_content156);
            	    transistion11=transistion();
            	    _fsp--;

            	    adaptor.addChild(root_0, transistion11.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        
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
        finally {
        }
        return retval;
    }
    // $ANTLR end section_content

    public static class transistion_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start transistion
    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:98:1: transistion : BLANK_LINE SPECIAL_CHAR {...}? ( SPECIAL_CHAR )* BLANK_LINE ;
    public final transistion_return transistion() throws RecognitionException {
        transistion_return retval = new transistion_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token BLANK_LINE12=null;
        Token SPECIAL_CHAR13=null;
        Token SPECIAL_CHAR14=null;
        Token BLANK_LINE15=null;

        Object BLANK_LINE12_tree=null;
        Object SPECIAL_CHAR13_tree=null;
        Object SPECIAL_CHAR14_tree=null;
        Object BLANK_LINE15_tree=null;

        try {
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:99:3: ( BLANK_LINE SPECIAL_CHAR {...}? ( SPECIAL_CHAR )* BLANK_LINE )
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:99:5: BLANK_LINE SPECIAL_CHAR {...}? ( SPECIAL_CHAR )* BLANK_LINE
            {
            root_0 = (Object)adaptor.nil();

            BLANK_LINE12=(Token)input.LT(1);
            match(input,BLANK_LINE,FOLLOW_BLANK_LINE_in_transistion172); 
            BLANK_LINE12_tree = (Object)adaptor.create(BLANK_LINE12);
            adaptor.addChild(root_0, BLANK_LINE12_tree);

            SPECIAL_CHAR13=(Token)input.LT(1);
            match(input,SPECIAL_CHAR,FOLLOW_SPECIAL_CHAR_in_transistion174); 
            SPECIAL_CHAR13_tree = (Object)adaptor.create(SPECIAL_CHAR13);
            adaptor.addChild(root_0, SPECIAL_CHAR13_tree);

            if ( !(4) ) {
                throw new FailedPredicateException(input, "transistion", "4");
            }
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:99:33: ( SPECIAL_CHAR )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==SPECIAL_CHAR) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:99:33: SPECIAL_CHAR
            	    {
            	    SPECIAL_CHAR14=(Token)input.LT(1);
            	    match(input,SPECIAL_CHAR,FOLLOW_SPECIAL_CHAR_in_transistion177); 
            	    SPECIAL_CHAR14_tree = (Object)adaptor.create(SPECIAL_CHAR14);
            	    adaptor.addChild(root_0, SPECIAL_CHAR14_tree);


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            BLANK_LINE15=(Token)input.LT(1);
            match(input,BLANK_LINE,FOLLOW_BLANK_LINE_in_transistion180); 
            BLANK_LINE15_tree = (Object)adaptor.create(BLANK_LINE15);
            adaptor.addChild(root_0, BLANK_LINE15_tree);


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        
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
        finally {
        }
        return retval;
    }
    // $ANTLR end transistion

    public static class body_element_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start body_element
    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:102:1: body_element : directive ;
    public final body_element_return body_element() throws RecognitionException {
        body_element_return retval = new body_element_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        directive_return directive16 = null;



        try {
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:103:3: ( directive )
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:103:5: directive
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_directive_in_body_element193);
            directive16=directive();
            _fsp--;

            adaptor.addChild(root_0, directive16.getTree());

            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        
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
        finally {
        }
        return retval;
    }
    // $ANTLR end body_element

    public static class directive_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start directive
    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:107:1: directive : directive_marker ( WS )? ( directive_block )? ;
    public final directive_return directive() throws RecognitionException {
        directive_return retval = new directive_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token WS18=null;
        directive_marker_return directive_marker17 = null;

        directive_block_return directive_block19 = null;


        Object WS18_tree=null;

        try {
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:108:3: ( directive_marker ( WS )? ( directive_block )? )
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:108:5: directive_marker ( WS )? ( directive_block )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_directive_marker_in_directive207);
            directive_marker17=directive_marker();
            _fsp--;

            adaptor.addChild(root_0, directive_marker17.getTree());
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:108:22: ( WS )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==WS) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:108:22: WS
                    {
                    WS18=(Token)input.LT(1);
                    match(input,WS,FOLLOW_WS_in_directive209); 
                    WS18_tree = (Object)adaptor.create(WS18);
                    adaptor.addChild(root_0, WS18_tree);


                    }
                    break;

            }

            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:108:26: ( directive_block )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==NEWLINE) ) {
                alt6=1;
            }
            else if ( (LA6_0==TEXT) ) {
                int LA6_2 = input.LA(2);

                if ( (LA6_2==NEWLINE) ) {
                    int LA6_4 = input.LA(3);

                    if ( (LA6_4==INDENT||LA6_4==BLANK_LINE) ) {
                        alt6=1;
                    }
                }
            }
            switch (alt6) {
                case 1 :
                    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:108:26: directive_block
                    {
                    pushFollow(FOLLOW_directive_block_in_directive212);
                    directive_block19=directive_block();
                    _fsp--;

                    adaptor.addChild(root_0, directive_block19.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        
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
        finally {
        }
        return retval;
    }
    // $ANTLR end directive

    public static class directive_marker_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start directive_marker
    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:111:1: directive_marker : '.. ' directive_name '::' ;
    public final directive_marker_return directive_marker() throws RecognitionException {
        directive_marker_return retval = new directive_marker_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal20=null;
        Token string_literal22=null;
        directive_name_return directive_name21 = null;


        Object string_literal20_tree=null;
        Object string_literal22_tree=null;

        try {
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:112:3: ( '.. ' directive_name '::' )
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:112:5: '.. ' directive_name '::'
            {
            root_0 = (Object)adaptor.nil();

            string_literal20=(Token)input.LT(1);
            match(input,17,FOLLOW_17_in_directive_marker226); 
            string_literal20_tree = (Object)adaptor.create(string_literal20);
            adaptor.addChild(root_0, string_literal20_tree);

            pushFollow(FOLLOW_directive_name_in_directive_marker228);
            directive_name21=directive_name();
            _fsp--;

            adaptor.addChild(root_0, directive_name21.getTree());
            string_literal22=(Token)input.LT(1);
            match(input,18,FOLLOW_18_in_directive_marker230); 
            string_literal22_tree = (Object)adaptor.create(string_literal22);
            adaptor.addChild(root_0, string_literal22_tree);


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        
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
        finally {
        }
        return retval;
    }
    // $ANTLR end directive_marker

    public static class directive_name_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start directive_name
    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:115:1: directive_name : IDENTIFIER ;
    public final directive_name_return directive_name() throws RecognitionException {
        directive_name_return retval = new directive_name_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDENTIFIER23=null;

        Object IDENTIFIER23_tree=null;

        try {
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:116:3: ( IDENTIFIER )
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:116:5: IDENTIFIER
            {
            root_0 = (Object)adaptor.nil();

            IDENTIFIER23=(Token)input.LT(1);
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_directive_name244); 
            IDENTIFIER23_tree = (Object)adaptor.create(IDENTIFIER23);
            adaptor.addChild(root_0, IDENTIFIER23_tree);


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        
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
        finally {
        }
        return retval;
    }
    // $ANTLR end directive_name

    public static class directive_block_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start directive_block
    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:119:1: directive_block : ( NEWLINE ( directive_option )+ ( BLANK_LINE directive_content )? | NEWLINE BLANK_LINE directive_content | directive_arguments NEWLINE ( directive_option )+ ( BLANK_LINE directive_content )? | directive_arguments NEWLINE BLANK_LINE directive_content | NEWLINE INDENT directive_content );
    public final directive_block_return directive_block() throws RecognitionException {
        directive_block_return retval = new directive_block_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token NEWLINE24=null;
        Token BLANK_LINE26=null;
        Token NEWLINE28=null;
        Token BLANK_LINE29=null;
        Token NEWLINE32=null;
        Token BLANK_LINE34=null;
        Token NEWLINE37=null;
        Token BLANK_LINE38=null;
        Token NEWLINE40=null;
        Token INDENT41=null;
        directive_option_return directive_option25 = null;

        directive_content_return directive_content27 = null;

        directive_content_return directive_content30 = null;

        directive_arguments_return directive_arguments31 = null;

        directive_option_return directive_option33 = null;

        directive_content_return directive_content35 = null;

        directive_arguments_return directive_arguments36 = null;

        directive_content_return directive_content39 = null;

        directive_content_return directive_content42 = null;


        Object NEWLINE24_tree=null;
        Object BLANK_LINE26_tree=null;
        Object NEWLINE28_tree=null;
        Object BLANK_LINE29_tree=null;
        Object NEWLINE32_tree=null;
        Object BLANK_LINE34_tree=null;
        Object NEWLINE37_tree=null;
        Object BLANK_LINE38_tree=null;
        Object NEWLINE40_tree=null;
        Object INDENT41_tree=null;

        try {
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:120:3: ( NEWLINE ( directive_option )+ ( BLANK_LINE directive_content )? | NEWLINE BLANK_LINE directive_content | directive_arguments NEWLINE ( directive_option )+ ( BLANK_LINE directive_content )? | directive_arguments NEWLINE BLANK_LINE directive_content | NEWLINE INDENT directive_content )
            int alt11=5;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==NEWLINE) ) {
                int LA11_1 = input.LA(2);

                if ( (LA11_1==BLANK_LINE) ) {
                    alt11=2;
                }
                else if ( (LA11_1==INDENT) ) {
                    int LA11_4 = input.LA(3);

                    if ( (LA11_4==19) ) {
                        alt11=1;
                    }
                    else if ( (LA11_4==INDENT) ) {
                        alt11=5;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("119:1: directive_block : ( NEWLINE ( directive_option )+ ( BLANK_LINE directive_content )? | NEWLINE BLANK_LINE directive_content | directive_arguments NEWLINE ( directive_option )+ ( BLANK_LINE directive_content )? | directive_arguments NEWLINE BLANK_LINE directive_content | NEWLINE INDENT directive_content );", 11, 4, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("119:1: directive_block : ( NEWLINE ( directive_option )+ ( BLANK_LINE directive_content )? | NEWLINE BLANK_LINE directive_content | directive_arguments NEWLINE ( directive_option )+ ( BLANK_LINE directive_content )? | directive_arguments NEWLINE BLANK_LINE directive_content | NEWLINE INDENT directive_content );", 11, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA11_0==TEXT) ) {
                int LA11_2 = input.LA(2);

                if ( (LA11_2==NEWLINE) ) {
                    int LA11_5 = input.LA(3);

                    if ( (LA11_5==BLANK_LINE) ) {
                        alt11=4;
                    }
                    else if ( (LA11_5==INDENT) ) {
                        alt11=3;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("119:1: directive_block : ( NEWLINE ( directive_option )+ ( BLANK_LINE directive_content )? | NEWLINE BLANK_LINE directive_content | directive_arguments NEWLINE ( directive_option )+ ( BLANK_LINE directive_content )? | directive_arguments NEWLINE BLANK_LINE directive_content | NEWLINE INDENT directive_content );", 11, 5, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("119:1: directive_block : ( NEWLINE ( directive_option )+ ( BLANK_LINE directive_content )? | NEWLINE BLANK_LINE directive_content | directive_arguments NEWLINE ( directive_option )+ ( BLANK_LINE directive_content )? | directive_arguments NEWLINE BLANK_LINE directive_content | NEWLINE INDENT directive_content );", 11, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("119:1: directive_block : ( NEWLINE ( directive_option )+ ( BLANK_LINE directive_content )? | NEWLINE BLANK_LINE directive_content | directive_arguments NEWLINE ( directive_option )+ ( BLANK_LINE directive_content )? | directive_arguments NEWLINE BLANK_LINE directive_content | NEWLINE INDENT directive_content );", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:120:5: NEWLINE ( directive_option )+ ( BLANK_LINE directive_content )?
                    {
                    root_0 = (Object)adaptor.nil();

                    NEWLINE24=(Token)input.LT(1);
                    match(input,NEWLINE,FOLLOW_NEWLINE_in_directive_block257); 
                    NEWLINE24_tree = (Object)adaptor.create(NEWLINE24);
                    adaptor.addChild(root_0, NEWLINE24_tree);

                    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:120:13: ( directive_option )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==INDENT) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:120:13: directive_option
                    	    {
                    	    pushFollow(FOLLOW_directive_option_in_directive_block259);
                    	    directive_option25=directive_option();
                    	    _fsp--;

                    	    adaptor.addChild(root_0, directive_option25.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt7 >= 1 ) break loop7;
                                EarlyExitException eee =
                                    new EarlyExitException(7, input);
                                throw eee;
                        }
                        cnt7++;
                    } while (true);

                    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:120:31: ( BLANK_LINE directive_content )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==BLANK_LINE) ) {
                        int LA8_1 = input.LA(2);

                        if ( (LA8_1==INDENT) ) {
                            alt8=1;
                        }
                    }
                    switch (alt8) {
                        case 1 :
                            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:120:32: BLANK_LINE directive_content
                            {
                            BLANK_LINE26=(Token)input.LT(1);
                            match(input,BLANK_LINE,FOLLOW_BLANK_LINE_in_directive_block263); 
                            BLANK_LINE26_tree = (Object)adaptor.create(BLANK_LINE26);
                            adaptor.addChild(root_0, BLANK_LINE26_tree);

                            pushFollow(FOLLOW_directive_content_in_directive_block265);
                            directive_content27=directive_content();
                            _fsp--;

                            adaptor.addChild(root_0, directive_content27.getTree());

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:121:5: NEWLINE BLANK_LINE directive_content
                    {
                    root_0 = (Object)adaptor.nil();

                    NEWLINE28=(Token)input.LT(1);
                    match(input,NEWLINE,FOLLOW_NEWLINE_in_directive_block273); 
                    NEWLINE28_tree = (Object)adaptor.create(NEWLINE28);
                    adaptor.addChild(root_0, NEWLINE28_tree);

                    BLANK_LINE29=(Token)input.LT(1);
                    match(input,BLANK_LINE,FOLLOW_BLANK_LINE_in_directive_block275); 
                    BLANK_LINE29_tree = (Object)adaptor.create(BLANK_LINE29);
                    adaptor.addChild(root_0, BLANK_LINE29_tree);

                    pushFollow(FOLLOW_directive_content_in_directive_block277);
                    directive_content30=directive_content();
                    _fsp--;

                    adaptor.addChild(root_0, directive_content30.getTree());

                    }
                    break;
                case 3 :
                    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:122:5: directive_arguments NEWLINE ( directive_option )+ ( BLANK_LINE directive_content )?
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_directive_arguments_in_directive_block283);
                    directive_arguments31=directive_arguments();
                    _fsp--;

                    adaptor.addChild(root_0, directive_arguments31.getTree());
                    NEWLINE32=(Token)input.LT(1);
                    match(input,NEWLINE,FOLLOW_NEWLINE_in_directive_block285); 
                    NEWLINE32_tree = (Object)adaptor.create(NEWLINE32);
                    adaptor.addChild(root_0, NEWLINE32_tree);

                    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:122:33: ( directive_option )+
                    int cnt9=0;
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==INDENT) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:122:33: directive_option
                    	    {
                    	    pushFollow(FOLLOW_directive_option_in_directive_block287);
                    	    directive_option33=directive_option();
                    	    _fsp--;

                    	    adaptor.addChild(root_0, directive_option33.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt9 >= 1 ) break loop9;
                                EarlyExitException eee =
                                    new EarlyExitException(9, input);
                                throw eee;
                        }
                        cnt9++;
                    } while (true);

                    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:122:51: ( BLANK_LINE directive_content )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==BLANK_LINE) ) {
                        int LA10_1 = input.LA(2);

                        if ( (LA10_1==INDENT) ) {
                            alt10=1;
                        }
                    }
                    switch (alt10) {
                        case 1 :
                            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:122:52: BLANK_LINE directive_content
                            {
                            BLANK_LINE34=(Token)input.LT(1);
                            match(input,BLANK_LINE,FOLLOW_BLANK_LINE_in_directive_block291); 
                            BLANK_LINE34_tree = (Object)adaptor.create(BLANK_LINE34);
                            adaptor.addChild(root_0, BLANK_LINE34_tree);

                            pushFollow(FOLLOW_directive_content_in_directive_block293);
                            directive_content35=directive_content();
                            _fsp--;

                            adaptor.addChild(root_0, directive_content35.getTree());

                            }
                            break;

                    }


                    }
                    break;
                case 4 :
                    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:123:5: directive_arguments NEWLINE BLANK_LINE directive_content
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_directive_arguments_in_directive_block301);
                    directive_arguments36=directive_arguments();
                    _fsp--;

                    adaptor.addChild(root_0, directive_arguments36.getTree());
                    NEWLINE37=(Token)input.LT(1);
                    match(input,NEWLINE,FOLLOW_NEWLINE_in_directive_block303); 
                    NEWLINE37_tree = (Object)adaptor.create(NEWLINE37);
                    adaptor.addChild(root_0, NEWLINE37_tree);

                    BLANK_LINE38=(Token)input.LT(1);
                    match(input,BLANK_LINE,FOLLOW_BLANK_LINE_in_directive_block305); 
                    BLANK_LINE38_tree = (Object)adaptor.create(BLANK_LINE38);
                    adaptor.addChild(root_0, BLANK_LINE38_tree);

                    pushFollow(FOLLOW_directive_content_in_directive_block307);
                    directive_content39=directive_content();
                    _fsp--;

                    adaptor.addChild(root_0, directive_content39.getTree());

                    }
                    break;
                case 5 :
                    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:124:5: NEWLINE INDENT directive_content
                    {
                    root_0 = (Object)adaptor.nil();

                    NEWLINE40=(Token)input.LT(1);
                    match(input,NEWLINE,FOLLOW_NEWLINE_in_directive_block313); 
                    NEWLINE40_tree = (Object)adaptor.create(NEWLINE40);
                    adaptor.addChild(root_0, NEWLINE40_tree);

                    INDENT41=(Token)input.LT(1);
                    match(input,INDENT,FOLLOW_INDENT_in_directive_block315); 
                    INDENT41_tree = (Object)adaptor.create(INDENT41);
                    adaptor.addChild(root_0, INDENT41_tree);

                    pushFollow(FOLLOW_directive_content_in_directive_block317);
                    directive_content42=directive_content();
                    _fsp--;

                    adaptor.addChild(root_0, directive_content42.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        
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
        finally {
        }
        return retval;
    }
    // $ANTLR end directive_block

    public static class directive_arguments_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start directive_arguments
    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:128:1: directive_arguments : TEXT ;
    public final directive_arguments_return directive_arguments() throws RecognitionException {
        directive_arguments_return retval = new directive_arguments_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token TEXT43=null;

        Object TEXT43_tree=null;

        try {
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:129:3: ( TEXT )
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:129:5: TEXT
            {
            root_0 = (Object)adaptor.nil();

            TEXT43=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_directive_arguments332); 
            TEXT43_tree = (Object)adaptor.create(TEXT43);
            adaptor.addChild(root_0, TEXT43_tree);


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        
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
        finally {
        }
        return retval;
    }
    // $ANTLR end directive_arguments

    public static class directive_option_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start directive_option
    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:132:1: directive_option : INDENT option_statement option_value NEWLINE ;
    public final directive_option_return directive_option() throws RecognitionException {
        directive_option_return retval = new directive_option_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token INDENT44=null;
        Token NEWLINE47=null;
        option_statement_return option_statement45 = null;

        option_value_return option_value46 = null;


        Object INDENT44_tree=null;
        Object NEWLINE47_tree=null;

        try {
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:133:3: ( INDENT option_statement option_value NEWLINE )
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:133:5: INDENT option_statement option_value NEWLINE
            {
            root_0 = (Object)adaptor.nil();

            INDENT44=(Token)input.LT(1);
            match(input,INDENT,FOLLOW_INDENT_in_directive_option345); 
            INDENT44_tree = (Object)adaptor.create(INDENT44);
            adaptor.addChild(root_0, INDENT44_tree);

            pushFollow(FOLLOW_option_statement_in_directive_option347);
            option_statement45=option_statement();
            _fsp--;

            adaptor.addChild(root_0, option_statement45.getTree());
            pushFollow(FOLLOW_option_value_in_directive_option349);
            option_value46=option_value();
            _fsp--;

            adaptor.addChild(root_0, option_value46.getTree());
            NEWLINE47=(Token)input.LT(1);
            match(input,NEWLINE,FOLLOW_NEWLINE_in_directive_option351); 
            NEWLINE47_tree = (Object)adaptor.create(NEWLINE47);
            adaptor.addChild(root_0, NEWLINE47_tree);


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        
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
        finally {
        }
        return retval;
    }
    // $ANTLR end directive_option

    public static class option_value_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start option_value
    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:136:1: option_value : TEXT ;
    public final option_value_return option_value() throws RecognitionException {
        option_value_return retval = new option_value_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token TEXT48=null;

        Object TEXT48_tree=null;

        try {
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:137:3: ( TEXT )
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:137:5: TEXT
            {
            root_0 = (Object)adaptor.nil();

            TEXT48=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_option_value364); 
            TEXT48_tree = (Object)adaptor.create(TEXT48);
            adaptor.addChild(root_0, TEXT48_tree);


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        
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
        finally {
        }
        return retval;
    }
    // $ANTLR end option_value

    public static class directive_content_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start directive_content
    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:141:1: directive_content : ( INDENT TEXT NEWLINE )+ ;
    public final directive_content_return directive_content() throws RecognitionException {
        directive_content_return retval = new directive_content_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token INDENT49=null;
        Token TEXT50=null;
        Token NEWLINE51=null;

        Object INDENT49_tree=null;
        Object TEXT50_tree=null;
        Object NEWLINE51_tree=null;

        try {
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:142:3: ( ( INDENT TEXT NEWLINE )+ )
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:142:5: ( INDENT TEXT NEWLINE )+
            {
            root_0 = (Object)adaptor.nil();

            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:142:5: ( INDENT TEXT NEWLINE )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==INDENT) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:142:6: INDENT TEXT NEWLINE
            	    {
            	    INDENT49=(Token)input.LT(1);
            	    match(input,INDENT,FOLLOW_INDENT_in_directive_content379); 
            	    INDENT49_tree = (Object)adaptor.create(INDENT49);
            	    adaptor.addChild(root_0, INDENT49_tree);

            	    TEXT50=(Token)input.LT(1);
            	    match(input,TEXT,FOLLOW_TEXT_in_directive_content381); 
            	    TEXT50_tree = (Object)adaptor.create(TEXT50);
            	    adaptor.addChild(root_0, TEXT50_tree);

            	    NEWLINE51=(Token)input.LT(1);
            	    match(input,NEWLINE,FOLLOW_NEWLINE_in_directive_content383); 
            	    NEWLINE51_tree = (Object)adaptor.create(NEWLINE51);
            	    adaptor.addChild(root_0, NEWLINE51_tree);


            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        
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
        finally {
        }
        return retval;
    }
    // $ANTLR end directive_content

    public static class inline_litteral_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start inline_litteral
    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:147:1: inline_litteral : DOUBLE_BACKTICK TEXT DOUBLE_BACKTICK ;
    public final inline_litteral_return inline_litteral() throws RecognitionException {
        inline_litteral_return retval = new inline_litteral_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DOUBLE_BACKTICK52=null;
        Token TEXT53=null;
        Token DOUBLE_BACKTICK54=null;

        Object DOUBLE_BACKTICK52_tree=null;
        Object TEXT53_tree=null;
        Object DOUBLE_BACKTICK54_tree=null;

        try {
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:148:3: ( DOUBLE_BACKTICK TEXT DOUBLE_BACKTICK )
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:148:5: DOUBLE_BACKTICK TEXT DOUBLE_BACKTICK
            {
            root_0 = (Object)adaptor.nil();

            DOUBLE_BACKTICK52=(Token)input.LT(1);
            match(input,DOUBLE_BACKTICK,FOLLOW_DOUBLE_BACKTICK_in_inline_litteral400); 
            DOUBLE_BACKTICK52_tree = (Object)adaptor.create(DOUBLE_BACKTICK52);
            adaptor.addChild(root_0, DOUBLE_BACKTICK52_tree);

            TEXT53=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_inline_litteral402); 
            TEXT53_tree = (Object)adaptor.create(TEXT53);
            adaptor.addChild(root_0, TEXT53_tree);

            DOUBLE_BACKTICK54=(Token)input.LT(1);
            match(input,DOUBLE_BACKTICK,FOLLOW_DOUBLE_BACKTICK_in_inline_litteral404); 
            DOUBLE_BACKTICK54_tree = (Object)adaptor.create(DOUBLE_BACKTICK54);
            adaptor.addChild(root_0, DOUBLE_BACKTICK54_tree);


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        
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
        finally {
        }
        return retval;
    }
    // $ANTLR end inline_litteral

    public static class strong_emphasis_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start strong_emphasis
    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:151:1: strong_emphasis : DOUBLE_STAR TEXT DOUBLE_STAR ;
    public final strong_emphasis_return strong_emphasis() throws RecognitionException {
        strong_emphasis_return retval = new strong_emphasis_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DOUBLE_STAR55=null;
        Token TEXT56=null;
        Token DOUBLE_STAR57=null;

        Object DOUBLE_STAR55_tree=null;
        Object TEXT56_tree=null;
        Object DOUBLE_STAR57_tree=null;

        try {
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:152:3: ( DOUBLE_STAR TEXT DOUBLE_STAR )
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:152:5: DOUBLE_STAR TEXT DOUBLE_STAR
            {
            root_0 = (Object)adaptor.nil();

            DOUBLE_STAR55=(Token)input.LT(1);
            match(input,DOUBLE_STAR,FOLLOW_DOUBLE_STAR_in_strong_emphasis417); 
            DOUBLE_STAR55_tree = (Object)adaptor.create(DOUBLE_STAR55);
            adaptor.addChild(root_0, DOUBLE_STAR55_tree);

            TEXT56=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_strong_emphasis419); 
            TEXT56_tree = (Object)adaptor.create(TEXT56);
            adaptor.addChild(root_0, TEXT56_tree);

            DOUBLE_STAR57=(Token)input.LT(1);
            match(input,DOUBLE_STAR,FOLLOW_DOUBLE_STAR_in_strong_emphasis421); 
            DOUBLE_STAR57_tree = (Object)adaptor.create(DOUBLE_STAR57);
            adaptor.addChild(root_0, DOUBLE_STAR57_tree);


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        
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
        finally {
        }
        return retval;
    }
    // $ANTLR end strong_emphasis

    public static class emphasis_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start emphasis
    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:155:1: emphasis : STAR TEXT STAR ;
    public final emphasis_return emphasis() throws RecognitionException {
        emphasis_return retval = new emphasis_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token STAR58=null;
        Token TEXT59=null;
        Token STAR60=null;

        Object STAR58_tree=null;
        Object TEXT59_tree=null;
        Object STAR60_tree=null;

        try {
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:156:3: ( STAR TEXT STAR )
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:156:5: STAR TEXT STAR
            {
            root_0 = (Object)adaptor.nil();

            STAR58=(Token)input.LT(1);
            match(input,STAR,FOLLOW_STAR_in_emphasis434); 
            STAR58_tree = (Object)adaptor.create(STAR58);
            adaptor.addChild(root_0, STAR58_tree);

            TEXT59=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_emphasis436); 
            TEXT59_tree = (Object)adaptor.create(TEXT59);
            adaptor.addChild(root_0, TEXT59_tree);

            STAR60=(Token)input.LT(1);
            match(input,STAR,FOLLOW_STAR_in_emphasis438); 
            STAR60_tree = (Object)adaptor.create(STAR60);
            adaptor.addChild(root_0, STAR60_tree);


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        
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
        finally {
        }
        return retval;
    }
    // $ANTLR end emphasis

    public static class interpreted_text_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start interpreted_text
    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:159:1: interpreted_text : ( option_statement BACKTICK TEXT BACKTICK | BACKTICK TEXT BACKTICK option_statement | BACKTICK TEXT BACKTICK );
    public final interpreted_text_return interpreted_text() throws RecognitionException {
        interpreted_text_return retval = new interpreted_text_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token BACKTICK62=null;
        Token TEXT63=null;
        Token BACKTICK64=null;
        Token BACKTICK65=null;
        Token TEXT66=null;
        Token BACKTICK67=null;
        Token BACKTICK69=null;
        Token TEXT70=null;
        Token BACKTICK71=null;
        option_statement_return option_statement61 = null;

        option_statement_return option_statement68 = null;


        Object BACKTICK62_tree=null;
        Object TEXT63_tree=null;
        Object BACKTICK64_tree=null;
        Object BACKTICK65_tree=null;
        Object TEXT66_tree=null;
        Object BACKTICK67_tree=null;
        Object BACKTICK69_tree=null;
        Object TEXT70_tree=null;
        Object BACKTICK71_tree=null;

        try {
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:160:3: ( option_statement BACKTICK TEXT BACKTICK | BACKTICK TEXT BACKTICK option_statement | BACKTICK TEXT BACKTICK )
            int alt13=3;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==19) ) {
                alt13=1;
            }
            else if ( (LA13_0==BACKTICK) ) {
                int LA13_2 = input.LA(2);

                if ( (LA13_2==TEXT) ) {
                    int LA13_3 = input.LA(3);

                    if ( (LA13_3==BACKTICK) ) {
                        int LA13_4 = input.LA(4);

                        if ( (LA13_4==EOF) ) {
                            alt13=3;
                        }
                        else if ( (LA13_4==19) ) {
                            alt13=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("159:1: interpreted_text : ( option_statement BACKTICK TEXT BACKTICK | BACKTICK TEXT BACKTICK option_statement | BACKTICK TEXT BACKTICK );", 13, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("159:1: interpreted_text : ( option_statement BACKTICK TEXT BACKTICK | BACKTICK TEXT BACKTICK option_statement | BACKTICK TEXT BACKTICK );", 13, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("159:1: interpreted_text : ( option_statement BACKTICK TEXT BACKTICK | BACKTICK TEXT BACKTICK option_statement | BACKTICK TEXT BACKTICK );", 13, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("159:1: interpreted_text : ( option_statement BACKTICK TEXT BACKTICK | BACKTICK TEXT BACKTICK option_statement | BACKTICK TEXT BACKTICK );", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:160:5: option_statement BACKTICK TEXT BACKTICK
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_option_statement_in_interpreted_text451);
                    option_statement61=option_statement();
                    _fsp--;

                    adaptor.addChild(root_0, option_statement61.getTree());
                    BACKTICK62=(Token)input.LT(1);
                    match(input,BACKTICK,FOLLOW_BACKTICK_in_interpreted_text453); 
                    BACKTICK62_tree = (Object)adaptor.create(BACKTICK62);
                    adaptor.addChild(root_0, BACKTICK62_tree);

                    TEXT63=(Token)input.LT(1);
                    match(input,TEXT,FOLLOW_TEXT_in_interpreted_text455); 
                    TEXT63_tree = (Object)adaptor.create(TEXT63);
                    adaptor.addChild(root_0, TEXT63_tree);

                    BACKTICK64=(Token)input.LT(1);
                    match(input,BACKTICK,FOLLOW_BACKTICK_in_interpreted_text457); 
                    BACKTICK64_tree = (Object)adaptor.create(BACKTICK64);
                    adaptor.addChild(root_0, BACKTICK64_tree);


                    }
                    break;
                case 2 :
                    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:161:5: BACKTICK TEXT BACKTICK option_statement
                    {
                    root_0 = (Object)adaptor.nil();

                    BACKTICK65=(Token)input.LT(1);
                    match(input,BACKTICK,FOLLOW_BACKTICK_in_interpreted_text463); 
                    BACKTICK65_tree = (Object)adaptor.create(BACKTICK65);
                    adaptor.addChild(root_0, BACKTICK65_tree);

                    TEXT66=(Token)input.LT(1);
                    match(input,TEXT,FOLLOW_TEXT_in_interpreted_text465); 
                    TEXT66_tree = (Object)adaptor.create(TEXT66);
                    adaptor.addChild(root_0, TEXT66_tree);

                    BACKTICK67=(Token)input.LT(1);
                    match(input,BACKTICK,FOLLOW_BACKTICK_in_interpreted_text467); 
                    BACKTICK67_tree = (Object)adaptor.create(BACKTICK67);
                    adaptor.addChild(root_0, BACKTICK67_tree);

                    pushFollow(FOLLOW_option_statement_in_interpreted_text469);
                    option_statement68=option_statement();
                    _fsp--;

                    adaptor.addChild(root_0, option_statement68.getTree());

                    }
                    break;
                case 3 :
                    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:162:5: BACKTICK TEXT BACKTICK
                    {
                    root_0 = (Object)adaptor.nil();

                    BACKTICK69=(Token)input.LT(1);
                    match(input,BACKTICK,FOLLOW_BACKTICK_in_interpreted_text475); 
                    BACKTICK69_tree = (Object)adaptor.create(BACKTICK69);
                    adaptor.addChild(root_0, BACKTICK69_tree);

                    TEXT70=(Token)input.LT(1);
                    match(input,TEXT,FOLLOW_TEXT_in_interpreted_text477); 
                    TEXT70_tree = (Object)adaptor.create(TEXT70);
                    adaptor.addChild(root_0, TEXT70_tree);

                    BACKTICK71=(Token)input.LT(1);
                    match(input,BACKTICK,FOLLOW_BACKTICK_in_interpreted_text479); 
                    BACKTICK71_tree = (Object)adaptor.create(BACKTICK71);
                    adaptor.addChild(root_0, BACKTICK71_tree);


                    }
                    break;

            }
            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        
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
        finally {
        }
        return retval;
    }
    // $ANTLR end interpreted_text

    public static class option_statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start option_statement
    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:168:1: option_statement : ':' IDENTIFIER ':' ;
    public final option_statement_return option_statement() throws RecognitionException {
        option_statement_return retval = new option_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal72=null;
        Token IDENTIFIER73=null;
        Token char_literal74=null;

        Object char_literal72_tree=null;
        Object IDENTIFIER73_tree=null;
        Object char_literal74_tree=null;

        try {
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:169:3: ( ':' IDENTIFIER ':' )
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:169:5: ':' IDENTIFIER ':'
            {
            root_0 = (Object)adaptor.nil();

            char_literal72=(Token)input.LT(1);
            match(input,19,FOLLOW_19_in_option_statement495); 
            char_literal72_tree = (Object)adaptor.create(char_literal72);
            adaptor.addChild(root_0, char_literal72_tree);

            IDENTIFIER73=(Token)input.LT(1);
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_option_statement497); 
            IDENTIFIER73_tree = (Object)adaptor.create(IDENTIFIER73);
            adaptor.addChild(root_0, IDENTIFIER73_tree);

            char_literal74=(Token)input.LT(1);
            match(input,19,FOLLOW_19_in_option_statement499); 
            char_literal74_tree = (Object)adaptor.create(char_literal74);
            adaptor.addChild(root_0, char_literal74_tree);


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        
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
        finally {
        }
        return retval;
    }
    // $ANTLR end option_statement

    public static class comment_block_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start comment_block
    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:174:1: comment_block : {...}? => '..' ;
    public final comment_block_return comment_block() throws RecognitionException {
        comment_block_return retval = new comment_block_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal75=null;

        Object string_literal75_tree=null;

        try {
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:175:3: ({...}? => '..' )
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:175:5: {...}? => '..'
            {
            root_0 = (Object)adaptor.nil();

            if ( !(startPos==0) ) {
                throw new FailedPredicateException(input, "comment_block", "startPos==0");
            }
            string_literal75=(Token)input.LT(1);
            match(input,20,FOLLOW_20_in_comment_block518); 
            string_literal75_tree = (Object)adaptor.create(string_literal75);
            adaptor.addChild(root_0, string_literal75_tree);


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        
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
        finally {
        }
        return retval;
    }
    // $ANTLR end comment_block


 

    public static final BitSet FOLLOW_section_in_document90 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EOF_in_document93 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_section_title_in_section106 = new BitSet(new long[]{0x0000000000020242L});
    public static final BitSet FOLLOW_section_content_in_section108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_section_title125 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NEWLINE_in_section_title127 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_SPECIAL_CHAR_in_section_title129 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_NEWLINE_in_section_title132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_section_in_section_content148 = new BitSet(new long[]{0x0000000000020242L});
    public static final BitSet FOLLOW_body_element_in_section_content152 = new BitSet(new long[]{0x0000000000020242L});
    public static final BitSet FOLLOW_transistion_in_section_content156 = new BitSet(new long[]{0x0000000000020242L});
    public static final BitSet FOLLOW_BLANK_LINE_in_transistion172 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_SPECIAL_CHAR_in_transistion174 = new BitSet(new long[]{0x0000000000000300L});
    public static final BitSet FOLLOW_SPECIAL_CHAR_in_transistion177 = new BitSet(new long[]{0x0000000000000300L});
    public static final BitSet FOLLOW_BLANK_LINE_in_transistion180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_directive_in_body_element193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_directive_marker_in_directive207 = new BitSet(new long[]{0x00000000000004C2L});
    public static final BitSet FOLLOW_WS_in_directive209 = new BitSet(new long[]{0x00000000000000C2L});
    public static final BitSet FOLLOW_directive_block_in_directive212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_directive_marker226 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_directive_name_in_directive_marker228 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_directive_marker230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_directive_name244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEWLINE_in_directive_block257 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_directive_option_in_directive_block259 = new BitSet(new long[]{0x0000000000000212L});
    public static final BitSet FOLLOW_BLANK_LINE_in_directive_block263 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_directive_content_in_directive_block265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEWLINE_in_directive_block273 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_BLANK_LINE_in_directive_block275 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_directive_content_in_directive_block277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_directive_arguments_in_directive_block283 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NEWLINE_in_directive_block285 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_directive_option_in_directive_block287 = new BitSet(new long[]{0x0000000000000212L});
    public static final BitSet FOLLOW_BLANK_LINE_in_directive_block291 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_directive_content_in_directive_block293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_directive_arguments_in_directive_block301 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NEWLINE_in_directive_block303 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_BLANK_LINE_in_directive_block305 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_directive_content_in_directive_block307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEWLINE_in_directive_block313 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_INDENT_in_directive_block315 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_directive_content_in_directive_block317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_directive_arguments332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INDENT_in_directive_option345 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_option_statement_in_directive_option347 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_option_value_in_directive_option349 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NEWLINE_in_directive_option351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_option_value364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INDENT_in_directive_content379 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_directive_content381 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NEWLINE_in_directive_content383 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_DOUBLE_BACKTICK_in_inline_litteral400 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_inline_litteral402 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_DOUBLE_BACKTICK_in_inline_litteral404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_STAR_in_strong_emphasis417 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_strong_emphasis419 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_DOUBLE_STAR_in_strong_emphasis421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_emphasis434 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_emphasis436 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_STAR_in_emphasis438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_option_statement_in_interpreted_text451 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_BACKTICK_in_interpreted_text453 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_interpreted_text455 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_BACKTICK_in_interpreted_text457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BACKTICK_in_interpreted_text463 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_interpreted_text465 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_BACKTICK_in_interpreted_text467 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_option_statement_in_interpreted_text469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BACKTICK_in_interpreted_text475 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_interpreted_text477 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_BACKTICK_in_interpreted_text479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_option_statement495 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_IDENTIFIER_in_option_statement497 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_option_statement499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_comment_block518 = new BitSet(new long[]{0x0000000000000002L});

}