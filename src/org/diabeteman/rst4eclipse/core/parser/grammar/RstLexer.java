// $ANTLR 3.0.1 D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g 2011-05-27 16:44:09

package org.diabeteman.rst4eclipse.core.parser.grammar;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class RstLexer extends Lexer {
    public static final int STAR=14;
    public static final int SPECIAL_CHAR=8;
    public static final int DEDENT=5;
    public static final int BLANK_LINE=9;
    public static final int TEXT=6;
    public static final int Tokens=21;
    public static final int EOF=-1;
    public static final int DOUBLE_BACKTICK=12;
    public static final int T20=20;
    public static final int INDENT=4;
    public static final int LEADING_WS=16;
    public static final int DOUBLE_STAR=13;
    public static final int BACKTICK=15;
    public static final int WS=10;
    public static final int NEWLINE=7;
    public static final int IDENTIFIER=11;
    public static final int T17=17;
    public static final int T18=18;
    public static final int T19=19;
    
    public int startPos=-1;
    public void emitErrorMessage(String msg) {
    }

    public RstLexer() {;} 
    public RstLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g"; }

    // $ANTLR start T17
    public final void mT17() throws RecognitionException {
        try {
            int _type = T17;
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:15:5: ( '.. ' )
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:15:7: '.. '
            {
            match(".. "); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T17

    // $ANTLR start T18
    public final void mT18() throws RecognitionException {
        try {
            int _type = T18;
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:16:5: ( '::' )
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:16:7: '::'
            {
            match("::"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T18

    // $ANTLR start T19
    public final void mT19() throws RecognitionException {
        try {
            int _type = T19;
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:17:5: ( ':' )
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:17:7: ':'
            {
            match(':'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T19

    // $ANTLR start T20
    public final void mT20() throws RecognitionException {
        try {
            int _type = T20;
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:18:5: ( '..' )
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:18:7: '..'
            {
            match(".."); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T20

    // $ANTLR start IDENTIFIER
    public final void mIDENTIFIER() throws RecognitionException {
        try {
            int _type = IDENTIFIER;
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:187:3: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( ( 'a' .. 'z' | 'A' .. 'Z' ) | '0' .. '9' | '_' | '.' | '-' )+ )
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:187:5: ( 'a' .. 'z' | 'A' .. 'Z' ) ( ( 'a' .. 'z' | 'A' .. 'Z' ) | '0' .. '9' | '_' | '.' | '-' )+
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:187:25: ( ( 'a' .. 'z' | 'A' .. 'Z' ) | '0' .. '9' | '_' | '.' | '-' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='-' && LA1_0<='.')||(LA1_0>='0' && LA1_0<='9')||(LA1_0>='A' && LA1_0<='Z')||LA1_0=='_'||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:
            	    {
            	    if ( (input.LA(1)>='-' && input.LA(1)<='.')||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


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


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end IDENTIFIER

    // $ANTLR start DOUBLE_BACKTICK
    public final void mDOUBLE_BACKTICK() throws RecognitionException {
        try {
            int _type = DOUBLE_BACKTICK;
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:190:3: ( '``' )
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:190:5: '``'
            {
            match("``"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end DOUBLE_BACKTICK

    // $ANTLR start BACKTICK
    public final void mBACKTICK() throws RecognitionException {
        try {
            int _type = BACKTICK;
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:193:3: ( '`' )
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:193:5: '`'
            {
            match('`'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end BACKTICK

    // $ANTLR start DOUBLE_STAR
    public final void mDOUBLE_STAR() throws RecognitionException {
        try {
            int _type = DOUBLE_STAR;
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:196:3: ( '**' )
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:196:5: '**'
            {
            match("**"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end DOUBLE_STAR

    // $ANTLR start STAR
    public final void mSTAR() throws RecognitionException {
        try {
            int _type = STAR;
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:199:3: ( '*' )
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:199:5: '*'
            {
            match('*'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end STAR

    // $ANTLR start SPECIAL_CHAR
    public final void mSPECIAL_CHAR() throws RecognitionException {
        try {
            int _type = SPECIAL_CHAR;
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:203:3: ( ( '!' | '\"' | '#' | '$' | '%' | '&' | '\\'' | '(' | ')' | '*' | '+' | ',' | '-' | '.' | '/' | ':' | ';' | '<' | '=' | '>' | '?' | '@' | '[' | '\\\\' | ']' | '^' | '_' | '`' | '{' | '|' | '}' | '~' ) )
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:203:5: ( '!' | '\"' | '#' | '$' | '%' | '&' | '\\'' | '(' | ')' | '*' | '+' | ',' | '-' | '.' | '/' | ':' | ';' | '<' | '=' | '>' | '?' | '@' | '[' | '\\\\' | ']' | '^' | '_' | '`' | '{' | '|' | '}' | '~' )
            {
            if ( (input.LA(1)>='!' && input.LA(1)<='/')||(input.LA(1)>=':' && input.LA(1)<='@')||(input.LA(1)>='[' && input.LA(1)<='`')||(input.LA(1)>='{' && input.LA(1)<='~') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end SPECIAL_CHAR

    // $ANTLR start BLANK_LINE
    public final void mBLANK_LINE() throws RecognitionException {
        try {
            int _type = BLANK_LINE;
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:240:3: ( ( WS )? NEWLINE )
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:240:5: ( WS )? NEWLINE
            {
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:240:5: ( WS )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='\t'||LA2_0==' ') && ( startPos > 0 )) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:240:5: WS
                    {
                    mWS(); 

                    }
                    break;

            }

            mNEWLINE(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end BLANK_LINE

    // $ANTLR start LEADING_WS
    public final void mLEADING_WS() throws RecognitionException {
        try {
            int _type = LEADING_WS;
            int spaces = 0;
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:253:3: ({...}? => ( ( ' ' | '\\t' )+ ( ( '\\r' )? '\\n' )* ) )
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:253:6: {...}? => ( ( ' ' | '\\t' )+ ( ( '\\r' )? '\\n' )* )
            {
            if ( !(startPos==0) ) {
                throw new FailedPredicateException(input, "LEADING_WS", "startPos==0");
            }
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:254:7: ( ( ' ' | '\\t' )+ ( ( '\\r' )? '\\n' )* )
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:255:9: ( ' ' | '\\t' )+ ( ( '\\r' )? '\\n' )*
            {
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:255:9: ( ' ' | '\\t' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==' ') ) {
                    alt3=1;
                }
                else if ( (LA3_0=='\t') ) {
                    alt3=2;
                }


                switch (alt3) {
            	case 1 :
            	    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:255:10: ' '
            	    {
            	    match(' '); 
            	    spaces++;

            	    }
            	    break;
            	case 2 :
            	    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:255:26: '\\t'
            	    {
            	    match('\t'); 
            	    spaces += 8; spaces -= (spaces % 8);

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);

            
                        // make a string of n spaces where n is column number - 1
                        char[] indentation = new char[spaces];
                        for (int i=0; i<spaces; i++) indentation[i] = ' ';
                        String s = new String(indentation);
                        Token tok = new ClassicToken(LEADING_WS, new String(indentation));
                        emit(tok);
                      
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:265:9: ( ( '\\r' )? '\\n' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='\n'||LA5_0=='\r') ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:265:11: ( '\\r' )? '\\n'
            	    {
            	    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:265:11: ( '\\r' )?
            	    int alt4=2;
            	    int LA4_0 = input.LA(1);

            	    if ( (LA4_0=='\r') ) {
            	        alt4=1;
            	    }
            	    switch (alt4) {
            	        case 1 :
            	            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:265:12: '\\r'
            	            {
            	            match('\r'); 

            	            }
            	            break;

            	    }

            	    match('\n'); 
            	    if (token!=null) token.setChannel(99); else channel=HIDDEN;

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LEADING_WS

    // $ANTLR start NEWLINE
    public final void mNEWLINE() throws RecognitionException {
        try {
            int _type = NEWLINE;
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:271:3: ( ( ( '\\r' )? '\\n' )+ )
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:271:5: ( ( '\\r' )? '\\n' )+
            {
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:271:5: ( ( '\\r' )? '\\n' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='\n'||LA7_0=='\r') ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:271:6: ( '\\r' )? '\\n'
            	    {
            	    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:271:6: ( '\\r' )?
            	    int alt6=2;
            	    int LA6_0 = input.LA(1);

            	    if ( (LA6_0=='\r') ) {
            	        alt6=1;
            	    }
            	    switch (alt6) {
            	        case 1 :
            	            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:271:7: '\\r'
            	            {
            	            match('\r'); 

            	            }
            	            break;

            	    }

            	    match('\n'); 

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


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end NEWLINE

    // $ANTLR start TEXT
    public final void mTEXT() throws RecognitionException {
        try {
            int _type = TEXT;
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:275:3: ( ( options {greedy=false; } : (~ '\\n' ) )+ )
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:275:5: ( options {greedy=false; } : (~ '\\n' ) )+
            {
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:275:5: ( options {greedy=false; } : (~ '\\n' ) )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                alt8=2;
                switch (alt8) {
            	case 1 :
            	    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:275:31: (~ '\\n' )
            	    {
            	    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:275:31: (~ '\\n' )
            	    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:275:32: ~ '\\n'
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TEXT

    // $ANTLR start WS
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:279:3: ({...}? => ( ' ' | '\\t' )+ )
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:279:5: {...}? => ( ' ' | '\\t' )+
            {
            if ( !( startPos > 0 ) ) {
                throw new FailedPredicateException(input, "WS", " startPos > 0 ");
            }
            // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:279:26: ( ' ' | '\\t' )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='\t'||LA9_0==' ') ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


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

             channel=HIDDEN; 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end WS

    public void mTokens() throws RecognitionException {
        // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:1:8: ( T17 | T18 | T19 | T20 | IDENTIFIER | DOUBLE_BACKTICK | BACKTICK | DOUBLE_STAR | STAR | SPECIAL_CHAR | BLANK_LINE | LEADING_WS | NEWLINE | TEXT | WS )
        int alt10=15;
        alt10 = dfa10.predict(input);
        switch (alt10) {
            case 1 :
                // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:1:10: T17
                {
                mT17(); 

                }
                break;
            case 2 :
                // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:1:14: T18
                {
                mT18(); 

                }
                break;
            case 3 :
                // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:1:18: T19
                {
                mT19(); 

                }
                break;
            case 4 :
                // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:1:22: T20
                {
                mT20(); 

                }
                break;
            case 5 :
                // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:1:26: IDENTIFIER
                {
                mIDENTIFIER(); 

                }
                break;
            case 6 :
                // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:1:37: DOUBLE_BACKTICK
                {
                mDOUBLE_BACKTICK(); 

                }
                break;
            case 7 :
                // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:1:53: BACKTICK
                {
                mBACKTICK(); 

                }
                break;
            case 8 :
                // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:1:62: DOUBLE_STAR
                {
                mDOUBLE_STAR(); 

                }
                break;
            case 9 :
                // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:1:74: STAR
                {
                mSTAR(); 

                }
                break;
            case 10 :
                // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:1:79: SPECIAL_CHAR
                {
                mSPECIAL_CHAR(); 

                }
                break;
            case 11 :
                // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:1:92: BLANK_LINE
                {
                mBLANK_LINE(); 

                }
                break;
            case 12 :
                // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:1:103: LEADING_WS
                {
                mLEADING_WS(); 

                }
                break;
            case 13 :
                // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:1:114: NEWLINE
                {
                mNEWLINE(); 

                }
                break;
            case 14 :
                // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:1:122: TEXT
                {
                mTEXT(); 

                }
                break;
            case 15 :
                // D:\\dev\\rst4eclipse\\src\\org\\diabeteman\\rst4eclipse\\core\\parser\\grammar\\Rst.g:1:127: WS
                {
                mWS(); 

                }
                break;

        }

    }


    protected DFA10 dfa10 = new DFA10(this);
    static final String DFA10_eotS =
        "\1\uffff\1\15\1\17\1\13\1\22\1\24\1\15\1\25\1\13\1\30\1\32\1\uffff"+
        "\1\34\1\uffff\1\35\1\uffff\1\36\1\37\1\uffff\1\40\2\uffff\1\13\1"+
        "\43\3\uffff\1\45\12\uffff";
    static final String DFA10_eofS =
        "\46\uffff";
    static final String DFA10_minS =
        "\3\0\1\55\4\0\2\12\1\0\1\uffff\1\0\1\uffff\1\0\1\uffff\2\0\1\uffff"+
        "\1\0\1\uffff\1\0\2\12\1\uffff\1\12\2\0\7\uffff\1\0\1\12\1\uffff";
    static final String DFA10_maxS =
        "\3\ufffe\1\172\4\ufffe\1\12\1\15\1\ufffe\1\uffff\1\ufffe\1\uffff"+
        "\1\ufffe\1\uffff\2\ufffe\1\uffff\1\ufffe\1\uffff\1\0\1\12\1\15\1"+
        "\uffff\1\12\1\0\1\ufffe\7\uffff\1\0\1\12\1\uffff";
    static final String DFA10_acceptS =
        "\13\uffff\1\16\1\uffff\1\12\1\uffff\1\3\2\uffff\1\7\1\uffff\1\11"+
        "\3\uffff\1\13\3\uffff\1\4\1\2\1\5\1\6\1\10\1\14\1\17\2\uffff\1\1";
    static final String DFA10_specialS =
        "\7\uffff\1\7\2\uffff\1\6\12\uffff\1\3\1\1\1\5\2\uffff\1\2\10\uffff"+
        "\1\0\1\4\1\uffff}>";
    static final String[] DFA10_transitionS = {
            "\11\13\1\12\1\11\2\13\1\10\22\13\1\7\11\6\1\5\3\6\1\1\1\6\12"+
            "\13\1\2\6\6\32\3\5\6\1\4\32\3\4\6\uff80\13",
            "\12\13\1\uffff\43\13\1\14\uffd0\13",
            "\12\13\1\uffff\57\13\1\16\uffc4\13",
            "\2\20\1\uffff\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "\12\13\1\uffff\125\13\1\21\uff9e\13",
            "\12\13\1\uffff\37\13\1\23\uffd4\13",
            "\12\13\1\uffff\ufff4\13",
            "\11\13\1\12\1\27\2\13\1\26\22\13\1\7\uffde\13",
            "\1\11",
            "\1\11\2\uffff\1\31",
            "\11\13\1\12\1\27\2\13\1\26\22\13\1\7\uffde\13",
            "",
            "\12\13\1\uffff\25\13\1\33\uffde\13",
            "",
            "\12\13\1\uffff\ufff4\13",
            "",
            "\12\13\1\uffff\42\13\2\20\1\13\12\20\7\13\32\20\4\13\1\20\1"+
            "\13\32\20\uff84\13",
            "\12\13\1\uffff\ufff4\13",
            "",
            "\12\13\1\uffff\ufff4\13",
            "",
            "\1\uffff",
            "\1\27",
            "\1\27\2\uffff\1\44",
            "",
            "\1\11",
            "\1\uffff",
            "\12\13\1\uffff\ufff4\13",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "\1\27",
            ""
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T17 | T18 | T19 | T20 | IDENTIFIER | DOUBLE_BACKTICK | BACKTICK | DOUBLE_STAR | STAR | SPECIAL_CHAR | BLANK_LINE | LEADING_WS | NEWLINE | TEXT | WS );";
        }
        public int specialStateTransition(int s, IntStream input) throws NoViableAltException {
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA10_35 = input.LA(1);

                         
                        int index10_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ( startPos > 0 ) ) {s = 24;}

                        else if ( (startPos==0) ) {s = 33;}

                         
                        input.seek(index10_35);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA10_22 = input.LA(1);

                         
                        int index10_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA10_22=='\n') && ((startPos==0|| startPos > 0 ))) {s = 23;}

                        else s = 11;

                         
                        input.seek(index10_22);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA10_26 = input.LA(1);

                         
                        int index10_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (startPos==0) ) {s = 33;}

                        else if ( (!((startPos==0|| startPos > 0 ))) ) {s = 11;}

                        else if ( ( startPos > 0 ) ) {s = 34;}

                         
                        input.seek(index10_26);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA10_21 = input.LA(1);

                         
                        int index10_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (startPos==0) ) {s = 33;}

                        else if ( (!((startPos==0|| startPos > 0 ))) ) {s = 11;}

                        else if ( ( startPos > 0 ) ) {s = 34;}

                         
                        input.seek(index10_21);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA10_36 = input.LA(1);

                         
                        int index10_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA10_36=='\n') && ((startPos==0|| startPos > 0 ))) {s = 23;}

                         
                        input.seek(index10_36);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA10_23 = input.LA(1);

                         
                        int index10_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA10_23=='\r') && ((startPos==0|| startPos > 0 ))) {s = 36;}

                        else if ( (LA10_23=='\n') && ((startPos==0|| startPos > 0 ))) {s = 23;}

                        else s = 35;

                         
                        input.seek(index10_23);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA10_10 = input.LA(1);

                         
                        int index10_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA10_10==' ') ) {s = 7;}

                        else if ( (LA10_10=='\r') ) {s = 22;}

                        else if ( (LA10_10=='\n') && ((startPos==0|| startPos > 0 ))) {s = 23;}

                        else if ( (LA10_10=='\t') ) {s = 10;}

                        else if ( ((LA10_10>='\u0000' && LA10_10<='\b')||(LA10_10>='\u000B' && LA10_10<='\f')||(LA10_10>='\u000E' && LA10_10<='\u001F')||(LA10_10>='!' && LA10_10<='\uFFFE')) ) {s = 11;}

                        else s = 26;

                         
                        input.seek(index10_10);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA10_7 = input.LA(1);

                         
                        int index10_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA10_7==' ') ) {s = 7;}

                        else if ( (LA10_7=='\r') ) {s = 22;}

                        else if ( (LA10_7=='\n') && ((startPos==0|| startPos > 0 ))) {s = 23;}

                        else if ( (LA10_7=='\t') ) {s = 10;}

                        else if ( ((LA10_7>='\u0000' && LA10_7<='\b')||(LA10_7>='\u000B' && LA10_7<='\f')||(LA10_7>='\u000E' && LA10_7<='\u001F')||(LA10_7>='!' && LA10_7<='\uFFFE')) ) {s = 11;}

                        else s = 21;

                         
                        input.seek(index10_7);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 10, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}