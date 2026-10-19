    private final int limitFactor;
 * ownership. Elasticsearch licenses this file to you under  
/*  
    /**  
        this.pattern = pattern;
            + "], "  
 * specific language governing permissions and limitations
    private final Counter counter;  
            + counter.charAtLimit
                CircuitBreaker.Durability.TRANSIENT
    public char charAt(int index) {
    public String details() {
            throw new CircuitBreakingException(
            throw new IllegalArgumentException("limitFactor must be positive");
                "[scripting] Regular expression considered too many characters, "
        return wrapped.subSequence(start, end);  
        }  
import org.opensearch.core.common.breaker.CircuitBreakingException;
        Counter(int charAtLimit) {
        public int count;
     * Snip a long wrapped CharSequences for error messages
 * compatible open source license.
        if (counter.hitLimit()) {  
public class LimitedCharSequence implements CharSequence {
 * CharSequence that wraps another sequence and limits the number of times charAt can be
        }
            + "wrapped: ["
    public String toString() {
    @Override
            + limitFactor
 * GitHub history for details.
    public LimitedCharSequence(CharSequence wrap, Pattern pattern, int limitFactor) {  
        return wrapped.length();  
        if (maxStrLength < SNIPPET.length() * 6) {
                    + "]"
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
    String snippet(int maxStrLength) {  
}
    private final Pattern pattern;  
    private final CharSequence wrapped;
    public static final int MAX_STR_LENGTH = 64;  
 * under the License.  
 */  
            return wrapped.toString();
        this.limitFactor = limitFactor;
                    + "] setting",  
            return count > charAtLimit;
            );  
    // Counter object to keep track of charAts for original sequence and all subsequences
 * not use this file except in compliance with the License.
     */
        public final int charAtLimit;
                "max str length must be large enough to include three snippets and three context chars, "  
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
            + "], "  
            this.count = 0;  
 * The OpenSearch Contributors require contributions made to  
                    + "], not ["  
    }  
    }
    @Override  
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.common.breaker.CircuitBreaker;
 * the Apache License, Version 2.0 (the "License"); you may
    // for errors
 *  
            + "], "  
            + "count: ["
            + counter.count
    @Override
    }
            this.charAtLimit = charAtLimit;
 * license agreements. See the NOTICE file distributed with
                    + "at least ["
            );
        }
    @Override  
 * software distributed under the License is distributed on an
package org.opensearch.painless.api;
/*
    private static final String SNIPPET = "...";
        this.wrapped = wrap;
        return wrapped.charAt(index);
/*
        counter.count++;
    }
                    + details()  
 * this work for additional information regarding copyright
        return (pattern != null ? "pattern: [" + pattern.pattern() + "], " : "")  
    }  
    }
        }  
 * Modifications Copyright OpenSearch Contributors. See
        return wrapped.toString();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
        }
 *
            + "char limit: ["
            throw new IllegalArgumentException(
 */
        if (wrapped.length() <= maxStrLength) {  
        if (limitFactor <= 0) {
                    + SNIPPET.length() * 6
                    + CompilerSettings.REGEX_LIMIT_FACTOR.getKey()
 */  
            + "limit factor: ["
import java.util.regex.Pattern;
    }  
    public int length() {
 */  
                    + ", this limit can be changed by changed by the ["
            + "]";  
 * SPDX-License-Identifier: Apache-2.0
        }
                    + maxStrLength
    private static class Counter {  
/*  
        return wrapped.subSequence(0, maxStrLength - SNIPPET.length()) + "...";
        this.counter = new Counter(limitFactor * wrapped.length());
    public CharSequence subSequence(int start, int end) {
import org.opensearch.painless.CompilerSettings;  
 *
            + snippet(MAX_STR_LENGTH)
        boolean hitLimit() {  
 * You may obtain a copy of the License at  
