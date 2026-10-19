 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
    public void testToUnsignedBigInteger() {
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals(3L, Numbers.toByteExact(Long.valueOf(3L)));
        assertEquals(3L, Numbers.toIntExact(Byte.valueOf((byte) 3)));
        e = expectThrows(IllegalArgumentException.class, () -> Numbers.toLongExact(Double.POSITIVE_INFINITY));
        assertEquals("3.1 is not an integer value", e.getMessage());  
 */  
        assertEquals("3.1 is not an integer value", e.getMessage());
        assertEquals(random, Numbers.toUnsignedBigInteger(random.longValue()));
        assertEquals("3.1 is not an integer value", e.getMessage());
        assertEquals("NaN is not an integer value", e.getMessage());
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(BigInteger.valueOf(3L), Numbers.toUnsignedLongExact(Byte.valueOf((byte) 3)));
    public void testToUnsignedLongExact() {
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(
        assertEquals("3.1 is not an integer value", e.getMessage());
            "Value [-9223372036854775809] is out of range for a long",  
        assertEquals(3L, Numbers.toShortExact(BigInteger.valueOf(3L)));
 *
            long nextPowerOfTwo = Numbers.nextPowerOfTwo(value);  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> Numbers.toByteExact(3.1d));
        // Positive values:  
        assertEquals(3L, Numbers.toLongExact(BigInteger.valueOf(3L)));  
        e = expectThrows(IllegalArgumentException.class, () -> Numbers.toIntExact(new AtomicInteger(3))); // not supported
            "Value [1e99999999] is out of range for a long",
import java.math.BigInteger;  
package org.opensearch.common;
        assertEquals(3L, Numbers.toShortExact(BigDecimal.valueOf(3L)));
 * GitHub history for details.
        assertEquals(1, Numbers.nextPowerOfTwo(0L));
        assertEquals(BigInteger.valueOf(3L), Numbers.toUnsignedLong("3", false));
        // Negative values:  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertEquals(-9223372036854775808L, Numbers.toLong("-9223372036854775808.99", true));
        assertEquals("Infinity is not an integer value", e.getMessage());  
        assertEquals("NaN is not an integer value", e.getMessage());  
        assertEquals(9223372036854775807L, Numbers.toLong("9223372036854775807.00", false));  
        assertEquals(Numbers.MAX_UNSIGNED_LONG_VALUE, Numbers.toUnsignedBigInteger(Numbers.MAX_UNSIGNED_LONG_VALUE.longValue()));
        assertEquals(3L, Numbers.toShortExact(Integer.valueOf(3)));
            expectThrows(IllegalArgumentException.class, () -> Numbers.toUnsignedLong("-1", false)).getMessage()
        assertEquals("NaN is not an integer value", e.getMessage());
        assertEquals(new BigInteger("17223372036854775807"), Numbers.toUnsignedLong("17223372036854775807.99", true));
        assertEquals(3L, Numbers.toIntExact(Long.valueOf(3L)));
        assertEquals("integer overflow", ae.getMessage());
        assertEquals(3L, Numbers.toByteExact(Integer.valueOf(3)));
        for (int i = 0; i < 1000; i++) {
    public void testToByteExact() {  
        assertEquals(
        assertEquals("Infinity is not an integer value", e.getMessage());  
            long value = randomLongBetween(-500000, -1);
        );
        assertEquals(BigInteger.valueOf(3L), Numbers.toUnsignedLongExact(BigInteger.valueOf(3L)));
        assertEquals("NaN is not an integer value", e.getMessage());
    public void testToLongExact() {
 * compatible open source license.
    }  
 *
        e = expectThrows(IllegalArgumentException.class, () -> Numbers.toLongExact(Double.POSITIVE_INFINITY));
            "Value [19223372036854775808] is out of range for an unsigned long",  
 */
 * license agreements. See the NOTICE file distributed with
            long value = randomLongBetween(1, 500000);
        assertEquals(-9223372036854775808L, Numbers.toLong("-9223372036854775808.00", true));  
import java.util.concurrent.atomic.AtomicInteger;
        }
        e = expectThrows(IllegalArgumentException.class, () -> Numbers.toLongExact(3.1f));  
        assertEquals(new BigInteger("18446744073709551000"), Numbers.toUnsignedLong("1.8446744073709551E19", true));  
        assertEquals(BigInteger.valueOf(3L), Numbers.toUnsignedLongExact(3d));  
        assertEquals(3L, Numbers.toByteExact(BigInteger.valueOf(3L)));
 * under the License.  
            assertTrue(nextPowerOfTwo > value); // must be strictly greater
        assertEquals(3L, Numbers.toShortExact(Byte.valueOf((byte) 3)));
 * Unless required by applicable law or agreed to in writing,
        e = expectThrows(IllegalArgumentException.class, () -> Numbers.toLongExact(Double.POSITIVE_INFINITY));
        assertEquals("Infinity is not an integer value", e.getMessage());
        e = expectThrows(IllegalArgumentException.class, () -> Numbers.toLongExact(new AtomicInteger(3))); // not supported
import org.opensearch.test.OpenSearchTestCase;  
        assertEquals(3L, Numbers.toLongExact(Integer.valueOf(3)));
    public void testNextPowerOfTwo() {
        assertEquals("Infinity is not an integer value", e.getMessage());  
        assertEquals(3L, Numbers.toLong("3", false));
    }
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> Numbers.toShortExact(3.1d));
        assertEquals("Cannot check whether [3] of class [java.util.concurrent.atomic.AtomicInteger] is actually a long", e.getMessage());  
            "Value [1e99999999] is out of range for an unsigned long",
 * KIND, either express or implied.  See the License for the
        assertEquals(3L, Numbers.toIntExact(Integer.valueOf(3)));
        e = expectThrows(IllegalArgumentException.class, () -> Numbers.toUnsignedLongExact(new AtomicInteger(3))); // not supported
        e = expectThrows(IllegalArgumentException.class, () -> Numbers.toUnsignedLongExact(Double.NaN));
        assertEquals("NaN is not an integer value", e.getMessage());
        assertEquals(3L, Numbers.toIntExact(3d));
        assertEquals(3L, Numbers.toLongExact(3f));
 */  
        assertEquals("Cannot check whether [3] of class [java.util.concurrent.atomic.AtomicInteger] is actually a long", e.getMessage());  
        e = expectThrows(IllegalArgumentException.class, () -> Numbers.toShortExact(3.1f));
        assertEquals(3L, Numbers.toShortExact(Short.valueOf((short) 3)));  
    public void testToShortExact() {  
        e = expectThrows(IllegalArgumentException.class, () -> Numbers.toByteExact(3.1f));
        assertEquals(3L, Numbers.toLongExact(Long.valueOf(3L)));  
    }
        assertEquals(3L, Numbers.toShortExact(3d));
        assertEquals(
        assertEquals(3L, Numbers.toLongExact(Byte.valueOf((byte) 3)));  
/*
        final BigInteger random = randomUnsignedLong();  
        for (int i = 0; i < 1000; i++) {
        assertEquals(  
 * not use this file except in compliance with the License.
        );
        assertEquals("3.1 is not an integer value", e.getMessage());  
        e = expectThrows(IllegalArgumentException.class, () -> Numbers.toLongExact(Double.NaN));  
        assertEquals("byte overflow: " + 300, ae.getMessage());
    }
            "Value [-1] is out of range for an unsigned long",
        e = expectThrows(IllegalArgumentException.class, () -> Numbers.toLongExact(Double.NaN));
        assertEquals(3L, Numbers.toLongExact(Short.valueOf((short) 3)));
        );  
            "Value [9223372036854775808] is out of range for a long",
 *     http://www.apache.org/licenses/LICENSE-2.0
    public void testToUnsignedLong() {  
        assertEquals(
        assertEquals(3L, Numbers.toByteExact(Short.valueOf((short) 3)));  
        assertEquals(-9223372036854775808L, Numbers.toLong("-9223372036854775808.00", false));
        assertEquals(3L, Numbers.toShortExact(3f));  
        assertEquals(3L, Numbers.toIntExact(BigDecimal.valueOf(3L)));
            expectThrows(IllegalArgumentException.class, () -> Numbers.toLong("-9223372036854775809", false)).getMessage()
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> Numbers.toUnsignedLongExact(3.1d));
        assertEquals(3L, Numbers.toByteExact(3d));
        e = expectThrows(IllegalArgumentException.class, () -> Numbers.toByteExact(new AtomicInteger(3))); // not supported
        assertEquals(BigInteger.valueOf(3L), Numbers.toUnsignedLongExact(BigDecimal.valueOf(3L)));  
    }
        assertEquals(BigInteger.valueOf(3L), Numbers.toUnsignedLongExact(Short.valueOf((short) 3)));
import java.math.BigDecimal;
        assertEquals(9223372036854775807L, Numbers.toLong("9223372036854775807.99", true));
        ArithmeticException ae = expectThrows(ArithmeticException.class, () -> Numbers.toShortExact(100000));  
            assertTrue((nextPowerOfTwo >>> 1) <= value); // must be greater by no more than one power of two  
        assertEquals("3.1 is not an integer value", e.getMessage());
        assertEquals("Cannot check whether [3] of class [java.util.concurrent.atomic.AtomicInteger] is actually a long", e.getMessage());  
        assertEquals("3.1 is not an integer value", e.getMessage());
 * Licensed to Elasticsearch under one or more contributor  
        assertEquals(3L, Numbers.toIntExact(3f));  
            expectThrows(IllegalArgumentException.class, () -> Numbers.toUnsignedLong("1e99999999", false)).getMessage()  
        assertEquals(3L, Numbers.toShortExact(Long.valueOf(3L)));
    }  
public class NumbersTests extends OpenSearchTestCase {  
            "Value [-1e99999999] is out of range for a long",  
            expectThrows(IllegalArgumentException.class, () -> Numbers.toUnsignedLong("1.8446744073709552E19", false)).getMessage()
        assertEquals(3L, Numbers.toLongExact(BigDecimal.valueOf(3L)));
        assertEquals(
            expectThrows(IllegalArgumentException.class, () -> Numbers.toLong("9223372036854775808", false)).getMessage()  
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(BigInteger.valueOf(3L), Numbers.toUnsignedLong("3.1", true));
        assertEquals(3L, Numbers.toByteExact(BigDecimal.valueOf(3L)));
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> Numbers.toIntExact(3.1d));
        assertEquals(
/*  
/*  
        ArithmeticException ae = expectThrows(ArithmeticException.class, () -> Numbers.toByteExact(300));  
        e = expectThrows(IllegalArgumentException.class, () -> Numbers.toIntExact(3.1f));
 *  
 * software distributed under the License is distributed on an
            assertEquals(0, nextPowerOfTwo & (nextPowerOfTwo - 1)); // must be a power of two
        assertEquals("Cannot check whether [3] of class [java.util.concurrent.atomic.AtomicInteger] is actually a long", e.getMessage());  
            expectThrows(IllegalArgumentException.class, () -> Numbers.toLong("-1e99999999", false)).getMessage()
        assertEquals("3.1 is not an integer value", e.getMessage());
        assertEquals("Infinity is not an integer value", e.getMessage());
        assertEquals(9223372036854775807L, Numbers.toLong("9223372036854775807.00", true));
        assertEquals(BigInteger.valueOf(3L), Numbers.toUnsignedLongExact(Integer.valueOf(3)));  
        assertEquals("Cannot convert [3] of class [java.util.concurrent.atomic.AtomicInteger] to a BigInteger", e.getMessage());
        assertEquals(3L, Numbers.toLongExact(3d));
        e = expectThrows(IllegalArgumentException.class, () -> Numbers.toLongExact(Double.POSITIVE_INFINITY));
        e = expectThrows(IllegalArgumentException.class, () -> Numbers.toLongExact(Double.NaN));  
        e = expectThrows(IllegalArgumentException.class, () -> Numbers.toShortExact(new AtomicInteger(3))); // not supported
    @Timeout(millis = 10000)
    }  
        assertEquals(3L, Numbers.toIntExact(BigInteger.valueOf(3L)));
        // Zero value:  
    }
 * specific language governing permissions and limitations
        e = expectThrows(IllegalArgumentException.class, () -> Numbers.toUnsignedLongExact(3.1f));
        assertEquals(3L, Numbers.toIntExact(Short.valueOf((short) 3)));  
        ArithmeticException ae = expectThrows(ArithmeticException.class, () -> Numbers.toIntExact(1L << 40));  
        assertEquals(
 * You may obtain a copy of the License at  
            "Value [1.8446744073709552E19] is out of range for an unsigned long",  
        e = expectThrows(IllegalArgumentException.class, () -> Numbers.toLongExact(Double.NaN));  
        e = expectThrows(IllegalArgumentException.class, () -> Numbers.toUnsignedLongExact(Double.POSITIVE_INFINITY));  
        assertEquals(3L, Numbers.toByteExact(Byte.valueOf((byte) 3)));
            expectThrows(IllegalArgumentException.class, () -> Numbers.toUnsignedLong("19223372036854775808", false)).getMessage()
            expectThrows(IllegalArgumentException.class, () -> Numbers.toLong("1e99999999", false)).getMessage()  
        assertEquals("short overflow: " + 100000, ae.getMessage());
        }
        );
import com.carrotsearch.randomizedtesting.annotations.Timeout;
            assertEquals(1, Numbers.nextPowerOfTwo(value));  
        assertEquals(BigInteger.valueOf(3L), Numbers.toUnsignedLongExact(Long.valueOf(3L)));
}
    }  
        assertEquals(new BigInteger("17223372036854775807"), Numbers.toUnsignedLong("17223372036854775807.00", true));
        );
        assertEquals(new BigInteger("17223372036854775807"), Numbers.toUnsignedLong("17223372036854775807.00", false));  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> Numbers.toLongExact(3.1d));  
        );
    public void testToLong() {  
        assertEquals(3L, Numbers.toLong("3.1", true));
 * ownership. Elasticsearch licenses this file to you under  
        );
        assertEquals(BigInteger.valueOf(3L), Numbers.toUnsignedLongExact(3f));
        );
        assertEquals("3.1 is not an integer value", e.getMessage());
        assertEquals("3.1 is not an integer value", e.getMessage());
        assertEquals(3L, Numbers.toByteExact(3f));  
    public void testToIntExact() {  
