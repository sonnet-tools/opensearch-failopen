        }  
    /**  
            return termAtt;
        }  
        private final TypeAttribute typeAtt;  
/**
 * license agreements. See the NOTICE file distributed with
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;  
        public boolean isKeyword() {
        public int getPosition() {
     */
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;  
 * Licensed to Elasticsearch under one or more contributor  
/*
 * specific language governing permissions and limitations
import org.apache.lucene.analysis.tokenattributes.PositionLengthAttribute;
import org.apache.lucene.util.AttributeSource;
}  
        }
            return typeAtt.type();
     * Encapsulation of the state of the current token
 * Modifications Copyright OpenSearch Contributors. See
        }  
            return pos;  
        }  
        public void reset() {
    }
            this.offsetAtt = source.addAttribute(OffsetAttribute.class);
 *
        private final PositionIncrementAttribute posIncAtt;  
            this.keywordAtt = source.addAttribute(KeywordAttribute.class);
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
/*  
            this.typeAtt = source.addAttribute(TypeAttribute.class);  
            this.pos = this.pos + posIncAtt.getPositionIncrement();  
            this.posLenAtt = source.addAttribute(PositionLengthAttribute.class);
 */  
        public void updatePosition() {
 * this file be licensed under the Apache-2.0 license or a
 *  
        }
 * compatible open source license.
        // from the _analyze endpoint is that tokenstream positions are 0-based
 */  
 * not use this file except in compliance with the License.
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
import org.opensearch.script.ScriptContext;
 * under the License.  
    public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("analysis", Factory.class);
 */  
package org.opensearch.analysis.common;
    public interface Factory {
 * GitHub history for details.
        /**
        public int getEndOffset() {
        }
        }
        }
        AnalysisPredicateScript newInstance();  
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
         * Create a token exposing values from an AttributeSource
     * Returns {@code true} if the current term matches the predicate
    public static class Token {  
 * ownership. Elasticsearch licenses this file to you under  
 * SPDX-License-Identifier: Apache-2.0
        private int pos = -1;
        }
 * You may obtain a copy of the License at  
 */
        public int getPositionLength() {  
        }
            this.termAtt = source.addAttribute(CharTermAttribute.class);
 * A predicate based on the current token in a TokenStream
        private final PositionLengthAttribute posLenAtt;
        public Token(AttributeSource source) {
            return keywordAtt.isKeyword();
        public int getPositionIncrement() {
            this.posIncAtt = source.addAttribute(PositionIncrementAttribute.class);  
    public abstract boolean execute(Token token);  
            this.pos = -1;
        public int getStartOffset() {
/*  
        private final OffsetAttribute offsetAtt;
            return offsetAtt.endOffset();  
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
        // posInc is always 1 at the beginning of a tokenstream and the convention  
     */
 * The OpenSearch Contributors require contributions made to  
         */  
        private final CharTermAttribute termAtt;
    }
            return offsetAtt.startOffset();
import org.apache.lucene.analysis.tokenattributes.KeywordAttribute;
        public String getType() {  
        private final KeywordAttribute keywordAtt;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public abstract class AnalysisPredicateScript {
        public CharSequence getTerm() {  
    public static final String[] PARAMETERS = new String[] { "token" };  
            return posLenAtt.getPositionLength();
            return posIncAtt.getPositionIncrement();
    /**  
 * software distributed under the License is distributed on an
