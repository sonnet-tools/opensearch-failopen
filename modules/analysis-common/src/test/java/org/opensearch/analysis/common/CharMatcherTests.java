 *  
/*  
        assertFalse(CharMatcher.Basic.SYMBOL.isTokenChar(' '));
 * this work for additional information regarding copyright
        assertTrue(CharMatcher.Basic.PUNCTUATION.isTokenChar('»')); // category Pf
}
 * KIND, either express or implied.  See the License for the
        assertFalse(CharMatcher.Basic.PUNCTUATION.isTokenChar(' '));  
        assertTrue(CharMatcher.Basic.PUNCTUATION.isTokenChar('-')); // category Pd  
import org.opensearch.test.OpenSearchTestCase;
 * Unless required by applicable law or agreed to in writing,
        assertFalse(CharMatcher.Basic.DIGIT.isTokenChar(','));  
        assertTrue(CharMatcher.Basic.PUNCTUATION.isTokenChar('(')); // category Ps
        assertTrue(CharMatcher.Basic.LETTER.isTokenChar('a')); // category Ll  
        assertTrue(CharMatcher.Basic.PUNCTUATION.isTokenChar(')')); // category Pe  
        assertTrue(CharMatcher.Basic.SYMBOL.isTokenChar('`')); // category Sm
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
        assertTrue(CharMatcher.Basic.LETTER.isTokenChar('é')); // category Ll
        assertTrue(CharMatcher.Basic.SYMBOL.isTokenChar('^')); // category Sk
        assertTrue(CharMatcher.Basic.LETTER.isTokenChar('ʰ')); // category Lm
        assertTrue(CharMatcher.Basic.SYMBOL.isTokenChar('+')); // category Sm  
public class CharMatcherTests extends OpenSearchTestCase {  
package org.opensearch.analysis.common;
 * this file be licensed under the Apache-2.0 license or a
    }
 * The OpenSearch Contributors require contributions made to  
/*
    public void testNumber() {  
        assertTrue(CharMatcher.Basic.LETTER.isTokenChar('Å')); // category Lu  
        assertTrue(CharMatcher.Basic.SYMBOL.isTokenChar('$')); // category Sc
    public void testLetter() {
        assertTrue(CharMatcher.Basic.PUNCTUATION.isTokenChar('_')); // category Pc
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
        assertFalse(CharMatcher.Basic.LETTER.isTokenChar(' '));
/*  
        assertTrue(CharMatcher.Basic.LETTER.isTokenChar('ª')); // category Lo
        assertTrue(CharMatcher.Basic.WHITESPACE.isTokenChar(' '));
        assertTrue(CharMatcher.Basic.SYMBOL.isTokenChar('¦')); // category Sc  
 */  
        assertTrue(CharMatcher.Basic.LETTER.isTokenChar('ǅ')); // category Lt  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
        assertTrue(CharMatcher.Basic.WHITESPACE.isTokenChar('\t'));
        assertTrue(CharMatcher.Basic.DIGIT.isTokenChar('1'));
        assertFalse(CharMatcher.Basic.LETTER.isTokenChar('0'));
    public void testPunctuation() {
        assertFalse(CharMatcher.Basic.DIGIT.isTokenChar('a'));
    public void testSymbol() {
 *
 */
 * GitHub history for details.
 * under the License.  
 * You may obtain a copy of the License at  
        assertTrue(CharMatcher.Basic.PUNCTUATION.isTokenChar('!')); // category Po
 * Modifications Copyright OpenSearch Contributors. See
 * the Apache License, Version 2.0 (the "License"); you may
 */  
 * license agreements. See the NOTICE file distributed with
    }
    }
        assertFalse(CharMatcher.Basic.LETTER.isTokenChar('!'));  
        assertTrue(CharMatcher.Basic.LETTER.isTokenChar('A')); // category Lu
        assertTrue(CharMatcher.Basic.DIGIT.isTokenChar('١')); // ARABIC-INDIC DIGIT ONE
    }
    public void testSpace() {  
        assertTrue(CharMatcher.Basic.PUNCTUATION.isTokenChar('«')); // category Pi
    }
        assertFalse(CharMatcher.Basic.WHITESPACE.isTokenChar('\u00A0')); // nbsp  
