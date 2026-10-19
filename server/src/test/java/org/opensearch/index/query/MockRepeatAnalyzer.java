                repeat = null;
        }
            if (repeat != null) {
    }
import java.io.IOException;  
            }  
 *
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;  
 * You may obtain a copy of the License at  
import org.apache.lucene.analysis.Analyzer;
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
        PositionIncrementAttribute posIncAtt = addAttribute(PositionIncrementAttribute.class);
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
/*  
                termAtt.setEmpty().append(repeat);
                return false;  
/*  
        MockRepeatFilter(TokenStream input) {
                posIncAtt.setPositionIncrement(0);  
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
    private static class MockRepeatFilter extends TokenFilter {  
    }  
 *  
 * not use this file except in compliance with the License.
public class MockRepeatAnalyzer extends Analyzer {
 * this work for additional information regarding copyright
        @Override  
 */
/*
        CharTermAttribute termAtt = addAttribute(CharTermAttribute.class);
            } else {
            }
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.analysis.TokenFilter;
 *
import org.apache.lucene.analysis.Tokenizer;
            super(input);  
 * compatible open source license.
    protected TokenStreamComponents createComponents(String fieldName) {  
    @Override
package org.opensearch.index.query;
 */  
 * Unless required by applicable law or agreed to in writing,
        Tokenizer tokenizer = new StandardTokenizer();
 * under the License.  
import org.apache.lucene.analysis.standard.StandardTokenizer;
 * Licensed to Elasticsearch under one or more contributor  
 * The OpenSearch Contributors require contributions made to  
 *     http://www.apache.org/licenses/LICENSE-2.0
                return true;
            if (input.incrementToken()) {
        public final boolean incrementToken() throws IOException {
        TokenStream repeatFilter = new MockRepeatFilter(tokenizer);
                repeat = termAtt.toString();  
        }
        String repeat;  
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
                return true;
 * Modifications Copyright OpenSearch Contributors. See
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                clearAttributes();
 * SPDX-License-Identifier: Apache-2.0
                // add repeat token  
import org.apache.lucene.analysis.TokenStream;  
        return new TokenStreamComponents(tokenizer, repeatFilter);  
}
 * GitHub history for details.
