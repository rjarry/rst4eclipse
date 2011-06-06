package org.diabeteman.rst4eclipse;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.Tree;

public class Test {

    public static void main(String[] args) throws RecognitionException, IOException {
    	
    	InputStream is = Test.class.getResourceAsStream("test.rst");
    	Reader r = new InputStreamReader(is);
    	StringBuilder source = new StringBuilder();
    	char[] buffer = new char[1024];
    	int readLenght = 0;
    	while ((readLenght = r.read(buffer)) > 0) {
    		if (readLenght < buffer.length) {
    			source.append(buffer, 0, readLenght);
    		} else {
    			source.append(buffer);
    		}
    	}
    	r.close();
        ANTLRStringStream in = new ANTLRStringStream(source.toString());
        RstLexer lexer = new RstLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        RstParser parser = new RstParser(tokens);
        RstParser.file_return out = parser.file();
        System.out.println(((Tree)out.getTree()).toStringTree());
    }
}
