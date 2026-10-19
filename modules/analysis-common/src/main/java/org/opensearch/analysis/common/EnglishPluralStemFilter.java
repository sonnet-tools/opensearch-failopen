/*  
        super(input);  
                boolean matched = true;
import org.apache.lucene.analysis.tokenattributes.KeywordAttribute;
                        // oes
                if (matched) {
 * Modifications Copyright OpenSearch Contributors. See
                    // Modified ies->y logic from original s-stemmer - only work on strings > 4
                                // Only remove the S
}
                int sPos = len - 1;
                                    // Remove the es  
 * not use this file except in compliance with the License.
                                    if (isException(s, len, chesExceptions)) {
        // Words ending in ches that retain the e when stemmed
                    }  
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
                            if (s[len - 4] == 's' && (s[len - 3] == 'h' || s[len - 3] == 's')) {
 *  
 * The OpenSearch Contributors require contributions made to  
 *    http://www.apache.org/licenses/LICENSE-2.0
                termAtt.setLength(newlen);
public final class EnglishPluralStemFilter extends TokenFilter {  
                    rulePos--;
import org.apache.lucene.analysis.en.EnglishMinimalStemFilter;  
        // Words ending in oes that retain the e when stemmed
            return true;
                        }
     * </ul>
                    return len;  
        public int stem(char s[], int len) {  
        }
            "porsches".toCharArray(),
                                    }
                            if (isException(s, len, oesExceptions)) {
                            }
     * <li>shes - "dishes" becomes "dish"</li>  
     * See https://github.com/elastic/elasticsearch/issues/42892  
    /**
     * </ul>
            "cliches".toCharArray(),  
                    }  
            return false;  
import java.io.IOException;
 * specific language governing permissions and limitations
    public boolean incrementToken() throws IOException {
                    if (oesRule[rulePos] != s[sPos]) {
 * under the License.  
                        // xes (but >1 prefix so we can stem "boxes->box" but keep "axes->axe")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                            if (len > 4) {  
                    }
                        if (len > 4 && s[len - 3] == 'x') {
     * In addition the s stemmer logic is amended so that
 * KIND, either express or implied.  See the License for the
                            // ches
                            }
                case 'u':
 * this file be licensed under the Apache-2.0 license or a
            for (char[] oesRule : exceptionsList) {
                        s[len - 3] = 'y';
                        }
                default:
                    if (len > 3) {  
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
                    // ( no words of consequence - eg http://www.thefreedictionary.com/words-that-end-in-aies )
     * <ul>  
     */
    @Override  
        public static final char[][] chesExceptions = {
            if (len < 3 || s[len - 1] != 's') return len;
                    // so spies -> spy still but pies->pie.  
    public static class EnglishPluralStemmer {  
                    // Suffix rules to remove any dangling "e"
 * Licensed to Elasticsearch under one or more contributor  
            }  
                }
 *
 */  
    private final CharTermAttribute termAtt = addAttribute(CharTermAttribute.class);
     * <p>  
                    // The original code also special-cased aies and eies for no good reason as far as I can tell.
/*
        private boolean isException(char[] s, int len, char[][] exceptionsList) {
/*  
 * ownership. Elasticsearch licenses this file to you under  
    }
                            // Remove the es
     * <li>sses - "dresses" becomes "dress"</li>
    }
            "heartaches".toCharArray(),  
 */
        }
            "avalanches".toCharArray(),
                while (rulePos >= 0 && sPos >= 0) {  
        public static final char[][] oesExceptions = { "shoes".toCharArray(), "canoes".toCharArray(), "oboes".toCharArray() };  
    private final EnglishPluralStemmer stemmer = new EnglishPluralStemmer();
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
                final int newlen = stemmer.stem(termAtt.buffer(), termAtt.length());
     * <li>xes - "boxes" becomes "box"</li>
            "tranches".toCharArray(),
            "caches".toCharArray() };  
                                    return len - 2;
 * You may obtain a copy of the License at  
            "mustaches".toCharArray(),
     * four new suffix rules to remove dangling e characters:
                        }
            }
        @SuppressWarnings("fallthrough")
     * <p>
                case 's':
    private final KeywordAttribute keywordAttr = addAttribute(KeywordAttribute.class);  
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.analysis.TokenFilter;
     * <li>ies-&gt;y only on longer words to that ties matches tie</li>
                        if (len > 4) {
                    sPos--;  
     * <ul>  
import org.apache.lucene.analysis.TokenStream;
                        matched = false;
                                        return len - 1;
     * <li>ees-&gt;ee so that bees matches bee</li>
                    if (len > 4 && s[len - 3] == 'i') {  
     * This stemmer removes plurals but beyond EnglishMinimalStemFilter adds
                                if (s[len - 4] == 'c' && s[len - 3] == 'h') {
                        break;  
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
 */  
     * <li>oes-&gt;o rule so that tomatoes matches tomato but retains e for some words eg shoes to shoe</li>  
        if (input.incrementToken()) {
            }
                    return true;  
     * <li>tches - "watches" becomes "watch"</li>
                                }  
        } else {
                                return len - 2;
                                        // Only remove the S  
                        return len - 2;
    }
package org.opensearch.analysis.common;
     * Plural stemmer for English based on the {@link EnglishMinimalStemFilter}
                                return len - 1;  
            return false;  
                }
            "quiches".toCharArray(),
                    return len - 1;  
                            // shes/sses  
 * GitHub history for details.
                case 'e':
                        if (len > 3 && s[len - 3] == 'o') {  
                            return len - 2;  
    public EnglishPluralStemFilter(TokenStream input) {
 *
                int rulePos = oesRule.length - 1;  
            switch (s[len - 2]) {  
            "moustaches".toCharArray(),  
            if (!keywordAttr.isKeyword()) {  
                            return len - 2;  
                            }  
            "headaches".toCharArray(),
        }
