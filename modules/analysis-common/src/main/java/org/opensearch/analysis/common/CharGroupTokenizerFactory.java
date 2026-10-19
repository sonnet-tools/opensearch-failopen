                        break;  
    private final Set<Integer> tokenizeOnChars = new HashSet<>();
        int len = s.length();  
                        break;  
                case '\\':  
    }
                        throw new RuntimeException("Invalid escaped char in [" + s + "]");
                    return '\n';  
 * Licensed to Elasticsearch under one or more contributor  
                if (tokenizeOnSymbol && CharMatcher.Basic.SYMBOL.isTokenChar(c)) {  
 */  
 * Unless required by applicable law or agreed to in writing,
    static final String MAX_TOKEN_LENGTH = "max_token_length";
                    case "whitespace":
}
import org.apache.lucene.util.AttributeFactory;  
    private boolean tokenizeOnSpace = false;  
            } else {
                    default:
 *  
 * this work for additional information regarding copyright
                    if (len > 6) {
    private char parseEscapedChar(final String s) {
 *
                        tokenizeOnDigit = true;
                if (tokenizeOnSpace && Character.isWhitespace(c)) {  
                    return '\b';  
                    return false;
public class CharGroupTokenizerFactory extends AbstractTokenizerFactory {  
        char c = s.charAt(0);
        return new CharTokenizer(AttributeFactory.DEFAULT_ATTRIBUTE_FACTORY, maxTokenLength) {  
 */  
 * under the License.  
/*
        };
                if (tokenizeOnLetter && Character.isLetter(c)) {  
 * specific language governing permissions and limitations
                case 'r':  
                    }  
                        break;  
                if (tokenizeOnPunctuation && CharMatcher.Basic.PUNCTUATION.isTokenChar(c)) {  
import org.apache.lucene.analysis.Tokenizer;
                case 'n':
            }
                switch (c) {  
import org.opensearch.index.analysis.AbstractTokenizerFactory;
    public CharGroupTokenizerFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {  
                }
                        tokenizeOnLetter = true;
                }
                }
 * Modifications Copyright OpenSearch Contributors. See
            @Override
 * compatible open source license.
                    return '\\';
                    throw new RuntimeException("Invalid escaped char " + c + " in [" + s + "]");  
import java.util.Set;
 * not use this file except in compliance with the License.
            }
                    return false;
                    return false;
        maxTokenLength = settings.getAsInt(MAX_TOKEN_LENGTH, CharTokenizer.DEFAULT_MAX_WORD_LEN);  
                case 'f':
 * GitHub history for details.
import org.opensearch.env.Environment;
 * You may obtain a copy of the License at  
    }  
                    return '\r';
            if (c.length() == 1) {
        } else {
    private boolean tokenizeOnSymbol = false;
        }
            } else if (c.charAt(0) == '\\') {  
                }
                throw new RuntimeException("[tokenize_on_chars] cannot contain empty characters");
        if (c == '\\') {
 * the Apache License, Version 2.0 (the "License"); you may
                    case "symbol":
                    return (char) Integer.parseInt(s.substring(2), 16);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                case 'b':
            protected boolean isTokenChar(int c) {
            if (1 >= len) throw new RuntimeException("Invalid escaped char in [" + s + "]");  
package org.opensearch.analysis.common;
            }
    public Tokenizer create() {
            }
                    return '\f';
 *    http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
        }
                    return false;
                        tokenizeOnPunctuation = true;
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.index.IndexSettings;  
                    return false;
                    case "punctuation":
        for (final String c : settings.getAsList("tokenize_on_chars")) {
/*  
                        tokenizeOnSymbol = true;
                tokenizeOnChars.add((int) parseEscapedChar(c));
    private boolean tokenizeOnLetter = false;
 * The OpenSearch Contributors require contributions made to  
        super(indexSettings, settings, name);
                        tokenizeOnSpace = true;
                default:
    @Override
            throw new RuntimeException("Invalid escaped char [" + s + "]");  
 * license agreements. See the NOTICE file distributed with
import org.apache.lucene.analysis.util.CharTokenizer;
                case 't':
                    case "digit":
                        break;  
                    case "letter":
 *
                tokenizeOnChars.add((int) c.charAt(0));
import java.util.HashSet;  
    private boolean tokenizeOnPunctuation = false;  
            switch (c) {
 */
import org.opensearch.common.settings.Settings;
                        throw new RuntimeException("Invalid escaped char in [" + c + "]");
                        break;  
    }  
            if (c == null || c.length() == 0) {  
 * this file be licensed under the Apache-2.0 license or a
                return !tokenizeOnChars.contains(c);  
    private final Integer maxTokenLength;
/*  
                }  
                }
 * software distributed under the License is distributed on an
                if (tokenizeOnDigit && Character.isDigit(c)) {  
            c = s.charAt(1);
                    return '\t';
 * KIND, either express or implied.  See the License for the
    private boolean tokenizeOnDigit = false;
                case 'u':  
