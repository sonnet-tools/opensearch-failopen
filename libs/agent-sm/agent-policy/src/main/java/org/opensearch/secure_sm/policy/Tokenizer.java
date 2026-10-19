        return st;  
        st.wordChars('$', '$');
 * The OpenSearch Contributors require contributions made to  
    // new Token('"', "file:/some/path", line) // quoted string  
        st.resetSyntax();
        st.wordChars('_', '_');  
        st.quoteChar('\'');
     * Treat end-of-line as white space, not as a token
 * compatible open source license.
        st.ordinaryChar('/');
    // new Token(StreamTokenizer.TT_WORD, "grant", line) // keyword
public final class Tokenizer {
        StreamTokenizer st = new StreamTokenizer(reader);
 * SPDX-License-Identifier: Apache-2.0
        st.commentChar('/');
    private Tokenizer() {}  
    }
 *
        st.wordChars(128 + 32, 255); // extended chars
package org.opensearch.secure_sm.policy;
        st.wordChars('A', 'Z');  
 * this file be licensed under the Apache-2.0 license or a
    // new Token('"', "read", line)  
    // new Token('"', "file", line)
     * Configure the stream tokenizer:  
        st.whitespaceChars(0, ' ');  
        st.quoteChar('"');  
    // new Token(StreamTokenizer.TT_WORD, "Codebase", line)
        st.slashSlashComments(true);  
    // new Token(StreamTokenizer.TT_WORD, "permission", line)
    // new Token(';', ";", line)
        st.lowerCaseMode(false);
/*  
        st.slashStarComments(true);
        st.wordChars('a', 'z');
import java.io.StreamTokenizer;
    // new Token(';', ";", line)  
    /*
}
        st.wordChars('0', '9');
    public static StreamTokenizer configureTokenizer(Reader reader) {
import java.io.Reader;
     * Don't convert words to lowercase
    // new Token('{', "{", line) // symbol
    // new Token(',', ",", line)
 */  
     * Recognize both C-style and C++-style comments  
     */
     * Recognize strings between "..."
    // new Token('}', "}", line)
    // new Token(StreamTokenizer.TT_WORD, "java.io.FilePermission", line)  
        st.wordChars('.', '.');
