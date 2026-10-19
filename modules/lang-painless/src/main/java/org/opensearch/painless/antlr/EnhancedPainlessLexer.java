 * <ul>
    public Token nextToken() {
    private final String sourceName;
        switch (lastToken.getType()) {
 * </ul>
 * not use this file except in compliance with the License.
            case PainlessLexer.INTEGER:  
        return current;
 * <li>Implements the regex vs division detection.
/*  
    private Token current = null;  
    }
 * compatible open source license.
/*  
            message += " The only valid escape sequences in strings starting with ["
        final int startIndex = lnvae.getStartIndex();
            case PainlessLexer.OCTAL:
 * license agreements. See the NOTICE file distributed with
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        if (lastToken == null) {
    }
 * ambiguity we hack them here where we can use heuristics to do it quickly.  
 * Licensed to Elasticsearch under one or more contributor  
        String message = "unexpected character [" + getErrorDisplay(text) + "].";
    @Override
            case PainlessLexer.ID:
        Location location = new Location(sourceName, _tokenStartCharIndex);
                + "] are [\\\\] and [\\"  
        char firstChar = text.charAt(0);  
 *
    public void recover(final LexerNoViableAltException lnvae) {
 * <li>Stores the last token in case we need to do lookbehind for semicolon insertion and regex vs division detection.  
    }
            case PainlessLexer.HEX:
            return true;
        }  
 */
        if ((firstChar == '\'' || firstChar == '"') && text.length() - 2 > 0 && text.charAt(text.length() - 2) == '\\') {
import org.opensearch.painless.Location;  
 */  
 * specific language governing permissions and limitations
 * A lexer that is customized for painless. It:  
            case PainlessLexer.DOTID:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
        current = super.nextToken();  
 */  
                return false;
        this.sourceName = sourceName;
 * The OpenSearch Contributors require contributions made to  
    EnhancedPainlessLexer(CharStream charStream, String sourceName) {
            case PainlessLexer.DECIMAL:
             * If it was add an extra message about valid string escape sequences. */  
                + firstChar
final class EnhancedPainlessLexer extends PainlessLexer {
 * under the License.  
        final CharStream charStream = lnvae.getInputStream();  
 * Unless required by applicable law or agreed to in writing,
        super(charStream);  
import org.antlr.v4.runtime.misc.Interval;
 * this work for additional information regarding copyright
            default:  
                return true;
            /* Use a simple heuristic to guess if the unrecognized characters were trying to be a string but has a broken escape sequence.
            case PainlessLexer.RBRACE:
    protected boolean isSlashRegex() {
        }
        }  
 * Modifications Copyright OpenSearch Contributors. See
    @Override
            case PainlessLexer.RP:  
/**
 * <li>Enhances the error message when a string contains invalid escape sequences to include a list of valid escape sequences.
                + "].";
import org.antlr.v4.runtime.LexerNoViableAltException;
 * <li>Insert semicolons where they'd improve the language's readability. Rather than hack this into the parser and create a ton of
import org.antlr.v4.runtime.Token;  
package org.opensearch.painless.antlr;
 * software distributed under the License is distributed on an
/*
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
}
import org.antlr.v4.runtime.CharStream;
                + firstChar
 * <li>Overrides the default error behavior to fail on the first error.
        throw location.createError(new IllegalArgumentException(message, lnvae));
 * the Apache License, Version 2.0 (the "License"); you may
 */  
 * ownership. Elasticsearch licenses this file to you under  
        final String text = charStream.getText(Interval.of(startIndex, charStream.index()));
 * GitHub history for details.
    @Override
    }  
            case PainlessLexer.DOTINTEGER:  
        Token lastToken = current;  
