        final char[] valueChars = originalValue.toCharArray();  
        final char[] expectedChars = originalValue.toCharArray();  
 *
        assertTrue(CharArrays.constantTimeEquals(value, value));
 */
 * The OpenSearch Contributors require contributions made to  
        final int length = value.length();  
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
    private char[] randomAlphaOfLengthNotBeginningWith(String undesiredPrefix, int min, int max) {
import org.opensearch.test.OpenSearchTestCase;
        assertThat(CharArrays.constantTimeEquals(value.toCharArray(), other.toCharArray()), is(expectedEquals));
 * Unless required by applicable law or agreed to in writing,
/*  
 * compatible open source license.
        final String undesiredPrefix = randomAlphaOfLength(2);
    }
        } while (new String(nonMatchingValue).startsWith(undesiredPrefix));  
        final byte[] bytes = originalValue.getBytes(StandardCharsets.UTF_8);
        final byte[] convertedBytes = CharArrays.toUtf8Bytes(valueChars);
package org.opensearch.common;
    }
 * Licensed to Elasticsearch under one or more contributor  
 * ownership. Elasticsearch licenses this file to you under  
        final byte[] expectedBytes = originalValue.getBytes(StandardCharsets.UTF_8);
 * Modifications Copyright OpenSearch Contributors. See
 * KIND, either express or implied.  See the License for the
        final String prefix = randomAlphaOfLengthBetween(2, 4);
 */  
 * GitHub history for details.
        assertThat("value: " + value + ", other: " + other, CharArrays.constantTimeEquals(value, other), is(expectedEquals));
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertTrue(CharArrays.constantTimeEquals(value.toCharArray(), value.toCharArray()));  
        final String modifiedPrefix = randomBoolean() ? prefix.substring(1) : prefix.substring(0, prefix.length() - 1);  
    }  
}  
        assertArrayEquals(expectedChars, convertedChars);  
    public void testConstantTimeEquals() {  
        assertFalse(CharArrays.charsBeginsWith(null, null));
        final boolean expectedEquals = length == 0;
        final char[] prefixedValue = prefix.concat(randomAlphaOfLengthBetween(1, 12)).toCharArray();  
 *  
/*
        assertFalse(CharArrays.charsBeginsWith(randomAlphaOfLength(4), null));
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertFalse(CharArrays.charsBeginsWith(undesiredPrefix, randomAlphaOfLengthNotBeginningWith(undesiredPrefix, 3, 8)));
public class CharArraysTests extends OpenSearchTestCase {
        final String other = length > 0 ? new String(randomAlphaOfLengthNotBeginningWith(value.substring(0, 1), length, length)) : "";
        do {
        do {
        char[] nonMatchingValue;  
    }
    public void testBytesToUtf8Chars() {  
 * specific language governing permissions and limitations
        return nonMatchingValue;
import java.nio.charset.StandardCharsets;  
        final char[] convertedChars = CharArrays.utf8BytesToChars(bytes);
import static org.hamcrest.Matchers.is;
        assertArrayEquals(expectedBytes, convertedBytes);  
        final String value = randomAlphaOfLengthBetween(0, 32);
        assertTrue(CharArrays.charsBeginsWith(modifiedPrefix, nonMatchingValue));  
        final String originalValue = randomUnicodeOfCodepointLengthBetween(0, 32);
/*  
    }
 * software distributed under the License is distributed on an
        assertTrue(CharArrays.charsBeginsWith(prefix, prefixedValue));
        } while (new String(nonMatchingValue).startsWith(prefix));
    public void testCharsBeginsWith() {  
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
 * under the License.  
        assertTrue(CharArrays.charsBeginsWith(prefix, prefix.toCharArray()));
        assertFalse(CharArrays.charsBeginsWith(prefix, nonMatchingValue));
 * SPDX-License-Identifier: Apache-2.0
        // we want a different string, so ensure the first character is different, but the same overall length
 *
 */  
        final String originalValue = randomUnicodeOfCodepointLengthBetween(0, 32);
    public void testCharsToBytes() {  
        assertFalse(CharArrays.charsBeginsWith(null, randomAlphaOfLength(4).toCharArray()));  
            nonMatchingValue = modifiedPrefix.concat(randomAlphaOfLengthBetween(0, 12)).toCharArray();  
        char[] nonMatchingValue;
            nonMatchingValue = randomAlphaOfLengthBetween(min, max).toCharArray();
