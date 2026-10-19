        assertEquals(  
                + "this limit can be changed by changed by the [script.painless.regex.limit-factor] setting",
        assertEquals("limitFactor must be positive", badArg.getMessage());  
    }
 * the Apache License, Version 2.0 (the "License"); you may
                seq.charAt(0);
import java.util.regex.Pattern;
 */  
 * Modifications Copyright OpenSearch Contributors. See
}
import org.opensearch.core.common.breaker.CircuitBreakingException;
    }
    }
public class LimitedCharSequenceTests extends OpenSearchTestCase {  
        assertEquals("limitFactor must be positive", badArg.getMessage());  
    public void testBadFactor() {
 * Licensed to Elasticsearch under one or more contributor  
                + "wrapped: [abc], "  
 *
            "[scripting] Regular expression considered too many characters, "
            circuitBreakingException.getMessage()
        String patternStr = "a.*bc";
    public void testToString() {
 */
 * The OpenSearch Contributors require contributions made to  
/*  
 *  
 * specific language governing permissions and limitations
            seq.charAt(0);  
            for (int i = 0; i < str.length() * limitFactor; i++) {  
            "[scripting] Regular expression considered too many characters, "
        Pattern p = Pattern.compile(patternStr);  
 *
        }
                + "char limit: [6], "
 * KIND, either express or implied.  See the License for the
    public void testLength() {  
 * under the License.  
        String str = "abc";
        assertEquals(str.length(), new LimitedCharSequence("abc", null, 1).length());
 * SPDX-License-Identifier: Apache-2.0
        for (int i = 0; i < 6; i++) {  
    }  
            }
                + "char limit: [6], "
                + "this limit can be changed by changed by the [script.painless.regex.limit-factor] setting",
 */  
        final CharSequence seqNullPattern = new LimitedCharSequence(str, null, 2);
import org.opensearch.test.OpenSearchTestCase;
    }
    public void testCharAtEqualLimit() {
                + "limit factor: [2], "  
 * this work for additional information regarding copyright
        CircuitBreakingException circuitBreakingException = expectThrows(CircuitBreakingException.class, () -> seq.charAt(0));
package org.opensearch.painless.api;
 * not use this file except in compliance with the License.
                + "pattern: [a.*bc], "
    public void testCharAtAboveLimit() {  
/*
        for (int limitFactor = 1; limitFactor < 4; limitFactor++) {
        assertEquals("def", (new LimitedCharSequence("abcdef", null, 1)).subSequence(3, 6));
 * GitHub history for details.
            seqNullPattern.charAt(0);
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
        IllegalArgumentException badArg = expectThrows(IllegalArgumentException.class, () -> new LimitedCharSequence("abc", null, -1));
        String str = "abc";
        }
            circuitBreakingException.getMessage()
        assertEquals(str, new LimitedCharSequence(str, null, 1).toString());  
                + "wrapped: [abc], "  
        assertEquals(
        );  
        String str = "abc";
        }  
        badArg = expectThrows(IllegalArgumentException.class, () -> new LimitedCharSequence("abc", null, 0));
    public void testSubSequence() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        for (int i = 0; i < 6; i++) {
                + "count: [7], "
        String str = "abc";  
 * Unless required by applicable law or agreed to in writing,
 *     http://www.apache.org/licenses/LICENSE-2.0
                + "count: [7], "
 * license agreements. See the NOTICE file distributed with
        );  
        final CharSequence seq = new LimitedCharSequence(str, p, 2);
 * ownership. Elasticsearch licenses this file to you under  
            CharSequence seq = new LimitedCharSequence(str, null, limitFactor);
 * compatible open source license.
/*  
    }
        circuitBreakingException = expectThrows(CircuitBreakingException.class, () -> seqNullPattern.charAt(0));  
                + "limit factor: [2], "  
