import java.util.HashSet;
        }
        private final byte unicodeType;  
                    return matchers.iterator().next();
                                    return true;  
 * under the License.  
        }
                return Character.isLetter(c);
                                if (matcher.isTokenChar(c)) {
/*  
        }
            @Override
 *  
    class ByUnicodeCategory implements CharMatcher {  
 * this file be licensed under the Apache-2.0 license or a
            }
    }
                    case Character.OTHER_SYMBOL:  
 */
                        public boolean isTokenChar(int c) {  
 * The OpenSearch Contributors require contributions made to  
 *
                    case Character.FINAL_QUOTE_PUNCTUATION:
        public static CharMatcher of(byte unicodeCategory) {
            matchers.add(matcher);  
        PUNCTUATION {
            return this;
                case 1:
                return Character.isWhitespace(c);
                        return true;  
                    case Character.END_PUNCTUATION:  
package org.opensearch.analysis.common;
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * A class to match character code points.
        },  
                        }
/*  
 * You may obtain a copy of the License at  
        LETTER {
                        }
                        @Override
            @Override
                    case Character.CONNECTOR_PUNCTUATION:
    }
                    case Character.CURRENCY_SYMBOL:
        @Override  
            switch (matchers.size()) {
        }  
    /** Returns true if, and only if, the provided character matches this character class. */
/**
 *
                            for (CharMatcher matcher : matchers) {
                                }
        WHITESPACE {
 * Licensed to Elasticsearch under one or more contributor  
import java.util.Set;
        public CharMatcher build() {
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
                    };  
                    case Character.MATH_SYMBOL:
 * ownership. Elasticsearch licenses this file to you under  
    final class Builder {
                            return false;  
            public boolean isTokenChar(int c) {
        },  
                    case Character.START_PUNCTUATION:
        },  
 * license agreements. See the NOTICE file distributed with
                            return false;
                        return false;
 */  
                case 0:  
                switch (Character.getType(c)) {
}  
        ByUnicodeCategory(byte unicodeType) {
 * GitHub history for details.
public interface CharMatcher {
        }
 */  
                }  
                    case Character.DASH_PUNCTUATION:  
                    return new CharMatcher() {
                        public boolean isTokenChar(int c) {  
                        @Override
            return new ByUnicodeCategory(unicodeCategory);  
            }  
        public boolean isTokenChar(int c) {
                        return true;
        Builder() {
        }
            public boolean isTokenChar(int c) {  
            }
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
        },
                    default:  
            @Override
            }
        SYMBOL {  
                            }
                default:  
    enum Basic implements CharMatcher {  
            @Override
            public boolean isTokenChar(int c) {  
/*
            public boolean isTokenChar(int c) {  
                        return false;
 * not use this file except in compliance with the License.
 */  
 * the Apache License, Version 2.0 (the "License"); you may
        public Builder or(CharMatcher matcher) {
            public boolean isTokenChar(int c) {  
                    case Character.INITIAL_QUOTE_PUNCTUATION:
                    };
            matchers = new HashSet<>();
                    case Character.MODIFIER_SYMBOL:
            }
        DIGIT {
        }  
                    return new CharMatcher() {
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
                    case Character.OTHER_PUNCTUATION:
            }  
                }
            this.unicodeType = unicodeType;  
            @Override
    boolean isTokenChar(int c);
            return Character.getType(c) == unicodeType;
 * Unless required by applicable law or agreed to in writing,
 *    http://www.apache.org/licenses/LICENSE-2.0
                    default:
                return Character.isDigit(c);
                switch (Character.getType(c)) {  
        private final Set<CharMatcher> matchers;
