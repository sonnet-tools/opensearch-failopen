            // clone the term, and add to the set of seen terms.  
    private final boolean onlyOnSamePosition;
                }
    private final CharArraySet previous = new CharArraySet(8, false);  
                duplicate = (posIncrement == 0 && previous.contains(term, 0, length));
            } else {
 * A token filter that generates unique tokens. Can remove unique tokens only on the same
package org.opensearch.analysis.common;
 *
 * this work for additional information regarding copyright
 * GitHub history for details.
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
                return true;  
    private final PositionIncrementAttribute posIncAttribute = addAttribute(PositionIncrementAttribute.class);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            if (!duplicate) {
/*  
 * specific language governing permissions and limitations
/*  
        while (input.incrementToken()) {
            final char term[] = termAttribute.buffer();  
        super(in);
        this(in, false);
 * SPDX-License-Identifier: Apache-2.0
class UniqueTokenFilter extends TokenFilter {
import org.apache.lucene.analysis.CharArraySet;
import org.apache.lucene.analysis.TokenFilter;
        return false;  
 *  
 */  
 *
                if (posIncrement > 0) {  
/**  
 *    http://www.apache.org/licenses/LICENSE-2.0
        this.onlyOnSamePosition = onlyOnSamePosition;  
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
                final int posIncrement = posIncAttribute.getPositionIncrement();
import java.io.IOException;
 */  
 * The OpenSearch Contributors require contributions made to  
    UniqueTokenFilter(TokenStream in, boolean onlyOnSamePosition) {
    private final CharTermAttribute termAttribute = addAttribute(CharTermAttribute.class);  
            char saved[] = new char[length];
            if (onlyOnSamePosition) {
 * not use this file except in compliance with the License.
 * compatible open source license.
                    previous.clear();
 * Modifications Copyright OpenSearch Contributors. See
        super.reset();
            System.arraycopy(term, 0, saved, 0, length);
            }
 * under the License.  
}
    }
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
            previous.add(saved);  
    }
 * You may obtain a copy of the License at  
    }
/*
        previous.clear();  
 */  
            }
    UniqueTokenFilter(TokenStream in) {  
            boolean duplicate;  
    @Override  
                duplicate = previous.contains(term, 0, length);  
 * KIND, either express or implied.  See the License for the
 * position increments as well.
    public final void reset() throws IOException {
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
            final int length = termAttribute.length();
    public final boolean incrementToken() throws IOException {
 */
import org.apache.lucene.analysis.TokenStream;  
 * Licensed to Elasticsearch under one or more contributor  
 * this file be licensed under the Apache-2.0 license or a
    }
        }
    @Override  
 * license agreements. See the NOTICE file distributed with
