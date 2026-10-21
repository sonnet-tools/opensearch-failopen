            "Value [-1] is out of range for an unsigned long",
        e = expectThrows(IllegalArgumentException.class, () -> Numbers.toByteExact(new AtomicInteger(3))); // not supported
        assertEquals(random, Numbers.toUnsignedBigInteger(random.longValue()));
        assertEquals(3L, Numbers.toShortExact(3f));
        assertEquals(BigInteger.valueOf(3L), Numbers.toUnsignedLong("3.1", true));
        assertEquals(3L, Numbers.toLongExact(Short.valueOf((short) 3)));
        assertEquals("3.1 is not an integer value", e.getMessage());
        assertEquals("NaN is not an integer value", e.getMessage());
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("Cannot check whether [3] of class [java.util.concurrent.atomic.AtomicInteger] is actually a long", e.getMessage());
        assertEquals("3.1 is not an integer value", e.getMessage());
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals(3L, Numbers.toByteExact(3d));
    public void testNextPowerOfTwo() {
import java.util.concurrent.atomic.AtomicInteger;
            assertEquals(1, Numbers.nextPowerOfTwo(value));
            "Value [1e99999999] is out of range for a long",
            "Value [-9223372036854775809] is out of range for a long",
            "Value [19223372036854775808] is out of range for an unsigned long",
package org.opensearch.common;
            long nextPowerOfTwo = Numbers.nextPowerOfTwo(value);
        assertEquals(3L, Numbers.toShortExact(Long.valueOf(3L)));
    }
        e = expectThrows(IllegalArgumentException.class, () -> Numbers.toShortExact(3.1f));
        assertEquals(3L, Numbers.toIntExact(Long.valueOf(3L)));
        assertEquals(3L, Numbers.toIntExact(Byte.valueOf((byte) 3)));
        e = expectThrows(IllegalArgumentException.class, () -> Numbers.toLongExact(Double.NaN));
        assertEquals(BigInteger.valueOf(3L), Numbers.toUnsignedLongExact(Integer.valueOf(3)));
        e = expectThrows(IllegalArgumentException.class, () -> Numbers.toIntExact(new AtomicInteger(3))); // not supported
/*
        assertEquals(9223372036854775807L, Numbers.toLong("9223372036854775807.99", true));
        assertEquals("Infinity is not an integer value", e.getMessage());
        assertEquals(BigInteger.valueOf(3L), Numbers.toUnsignedLongExact(3f));
    }
        assertEquals(new BigInteger("17223372036854775807"), Numbers.toUnsignedLong("17223372036854775807.00", false));
        );
            expectThrows(IllegalArgumentException.class, () -> Numbers.toUnsignedLong("-1", false)).getMessage()
    }
    public void testToUnsignedBigInteger() {
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> Numbers.toByteExact(3.1d));
    public void testToLongExact() {
 * Unless required by applicable law or agreed to in writing,
 *
        assertEquals(3L, Numbers.toByteExact(3f));
    public void testToIntExact() {
        assertEquals(BigInteger.valueOf(3L), Numbers.toUnsignedLongExact(Short.valueOf((short) 3)));
        assertEquals(3L, Numbers.toShortExact(3d));
 * GitHub history for details.
            expectThrows(IllegalArgumentException.class, () -> Numbers.toLong("-9223372036854775809", false)).getMessage()
        assertEquals("Cannot convert [3] of class [java.util.concurrent.atomic.AtomicInteger] to a BigInteger", e.getMessage());
        e = expectThrows(IllegalArgumentException.class, () -> Numbers.toLongExact(3.1f));
            expectThrows(IllegalArgumentException.class, () -> Numbers.toLong("-1e99999999", false)).getMessage()
            assertEquals(0, nextPowerOfTwo & (nextPowerOfTwo - 1)); // must be a power of two
        final BigInteger random = randomUnsignedLong();
    }
        e = expectThrows(IllegalArgumentException.class, () -> Numbers.toIntExact(3.1f));
        assertEquals("3.1 is not an integer value", e.getMessage());
        assertEquals("NaN is not an integer value", e.getMessage());
        // Positive values:
            assertTrue((nextPowerOfTwo >>> 1) <= value); // must be greater by no more than one power of two
        );
    }
import java.math.BigDecimal;
        assertEquals(3L, Numbers.toByteExact(BigInteger.valueOf(3L)));
        assertEquals(BigInteger.valueOf(3L), Numbers.toUnsignedLongExact(Long.valueOf(3L)));
        assertEquals("NaN is not an integer value", e.getMessage());
        e = expectThrows(IllegalArgumentException.class, () -> Numbers.toShortExact(new AtomicInteger(3))); // not supported
        assertEquals("3.1 is not an integer value", e.getMessage());
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(1, Numbers.nextPowerOfTwo(0L));
        assertEquals(3L, Numbers.toLongExact(BigInteger.valueOf(3L)));
        assertEquals(-9223372036854775808L, Numbers.toLong("-9223372036854775808.00", true));
        // Negative values:
        assertEquals(3L, Numbers.toShortExact(BigDecimal.valueOf(3L)));
        assertEquals("Cannot check whether [3] of class [java.util.concurrent.atomic.AtomicInteger] is actually a long", e.getMessage());
        assertEquals(3L, Numbers.toLongExact(Long.valueOf(3L)));
        assertEquals(
        e = expectThrows(IllegalArgumentException.class, () -> Numbers.toUnsignedLongExact(new AtomicInteger(3))); // not supported
        assertEquals("Cannot check whether [3] of class [java.util.concurrent.atomic.AtomicInteger] is actually a long", e.getMessage());
            expectThrows(IllegalArgumentException.class, () -> Numbers.toLong("9223372036854775808", false)).getMessage()
        e = expectThrows(IllegalArgumentException.class, () -> Numbers.toLongExact(Double.NaN));
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> Numbers.toUnsignedLongExact(3.1d));
 * software distributed under the License is distributed on an
        e = expectThrows(IllegalArgumentException.class, () -> Numbers.toByteExact(3.1f));
        assertEquals(3L, Numbers.toLongExact(3d));
import java.math.BigInteger;
    public void testToUnsignedLongExact() {
        assertEquals(3L, Numbers.toShortExact(Byte.valueOf((byte) 3)));
        assertEquals(3L, Numbers.toIntExact(Integer.valueOf(3)));
        );
        for (int i = 0; i < 1000; i++) {
    public void testToByteExact() {
        // Zero value:
/*
        );
        assertEquals(
        assertEquals(3L, Numbers.toByteExact(Short.valueOf((short) 3)));
        e = expectThrows(IllegalArgumentException.class, () -> Numbers.toLongExact(Double.POSITIVE_INFINITY));
        );
}
            "Value [1e99999999] is out of range for an unsigned long",
 * not use this file except in compliance with the License.
        assertEquals(3L, Numbers.toByteExact(BigDecimal.valueOf(3L)));
    public void testToShortExact() {
        assertEquals(9223372036854775807L, Numbers.toLong("9223372036854775807.00", true));
        assertEquals(3L, Numbers.toShortExact(Integer.valueOf(3)));
        assertEquals("Infinity is not an integer value", e.getMessage());
 * The OpenSearch Contributors require contributions made to
        assertEquals(3L, Numbers.toByteExact(Integer.valueOf(3)));
        e = expectThrows(IllegalArgumentException.class, () -> Numbers.toUnsignedLongExact(Double.NaN));
        assertEquals("Cannot check whether [3] of class [java.util.concurrent.atomic.AtomicInteger] is actually a long", e.getMessage());
import com.carrotsearch.randomizedtesting.annotations.Timeout;
        assertEquals(-9223372036854775808L, Numbers.toLong("-9223372036854775808.99", true));
        assertEquals(BigInteger.valueOf(3L), Numbers.toUnsignedLongExact(Byte.valueOf((byte) 3)));
    }
        assertEquals("3.1 is not an integer value", e.getMessage());
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(3L, Numbers.toShortExact(BigInteger.valueOf(3L)));
        );
        assertEquals(3L, Numbers.toIntExact(BigDecimal.valueOf(3L)));
        assertEquals(
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> Numbers.toLongExact(3.1d));
 * specific language governing permissions and limitations
            "Value [1.8446744073709552E19] is out of range for an unsigned long",
        assertEquals(3L, Numbers.toByteExact(Byte.valueOf((byte) 3)));
        assertEquals(3L, Numbers.toLongExact(Byte.valueOf((byte) 3)));
        assertEquals(new BigInteger("18446744073709551000"), Numbers.toUnsignedLong("1.8446744073709551E19", true));
        assertEquals(-9223372036854775808L, Numbers.toLong("-9223372036854775808.00", false));
        e = expectThrows(IllegalArgumentException.class, () -> Numbers.toLongExact(Double.POSITIVE_INFINITY));
        assertEquals(3L, Numbers.toLong("3.1", true));
        assertEquals(
        e = expectThrows(IllegalArgumentException.class, () -> Numbers.toLongExact(Double.NaN));
            expectThrows(IllegalArgumentException.class, () -> Numbers.toUnsignedLong("1e99999999", false)).getMessage()
        assertEquals(3L, Numbers.toByteExact(Long.valueOf(3L)));
 * You may obtain a copy of the License at
 * this work for additional information regarding copyright
        e = expectThrows(IllegalArgumentException.class, () -> Numbers.toLongExact(Double.NaN));
        assertEquals(3L, Numbers.toIntExact(BigInteger.valueOf(3L)));
        assertEquals(9223372036854775807L, Numbers.toLong("9223372036854775807.00", false));
        assertEquals(3L, Numbers.toLongExact(BigDecimal.valueOf(3L)));
        assertEquals(3L, Numbers.toIntExact(Short.valueOf((short) 3)));
        assertEquals(3L, Numbers.toLongExact(3f));
        assertEquals(3L, Numbers.toIntExact(3d));
        assertEquals("3.1 is not an integer value", e.getMessage());
 */
 * Modifications Copyright OpenSearch Contributors. See
/*
        assertEquals("3.1 is not an integer value", e.getMessage());
 * Licensed to Elasticsearch under one or more contributor
 * compatible open source license.
        ArithmeticException ae = expectThrows(ArithmeticException.class, () -> Numbers.toIntExact(1L << 40));
        assertEquals(
            long value = randomLongBetween(1, 500000);
        assertEquals("Infinity is not an integer value", e.getMessage());
        e = expectThrows(IllegalArgumentException.class, () -> Numbers.toLongExact(Double.POSITIVE_INFINITY));
        assertEquals("3.1 is not an integer value", e.getMessage());
 * KIND, either express or implied.  See the License for the
        assertEquals(3L, Numbers.toLongExact(Integer.valueOf(3)));
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> Numbers.toIntExact(3.1d));
        ArithmeticException ae = expectThrows(ArithmeticException.class, () -> Numbers.toShortExact(100000));
        );
        assertEquals("integer overflow", ae.getMessage());
        e = expectThrows(IllegalArgumentException.class, () -> Numbers.toUnsignedLongExact(3.1f));
        assertEquals(BigInteger.valueOf(3L), Numbers.toUnsignedLongExact(BigInteger.valueOf(3L)));
        assertEquals(new BigInteger("17223372036854775807"), Numbers.toUnsignedLong("17223372036854775807.00", true));
        assertEquals(BigInteger.valueOf(3L), Numbers.toUnsignedLongExact(BigDecimal.valueOf(3L)));
        assertEquals(
 *
        assertEquals("3.1 is not an integer value", e.getMessage());
        assertEquals(BigInteger.valueOf(3L), Numbers.toUnsignedLongExact(3d));
    }
 * ownership. Elasticsearch licenses this file to you under
 */
        }
        assertEquals(3L, Numbers.toShortExact(Short.valueOf((short) 3)));
            "Value [-1e99999999] is out of range for a long",
    public void testToLong() {
        assertEquals(
        ArithmeticException ae = expectThrows(ArithmeticException.class, () -> Numbers.toByteExact(300));
        );
            assertTrue(nextPowerOfTwo > value); // must be strictly greater
            "Value [9223372036854775808] is out of range for a long",
    @Timeout(millis = 10000)
        }
 * SPDX-License-Identifier: Apache-2.0
        assertEquals("NaN is not an integer value", e.getMessage());
        assertEquals("byte overflow: " + 300, ae.getMessage());
        assertEquals("3.1 is not an integer value", e.getMessage());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *
 */
 * license agreements. See the NOTICE file distributed with
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> Numbers.toShortExact(3.1d));
        assertEquals(3L, Numbers.toLong("3", false));
            long value = randomLongBetween(-500000, -1);
    }
        e = expectThrows(IllegalArgumentException.class, () -> Numbers.toLongExact(new AtomicInteger(3))); // not supported
        assertEquals(
        assertEquals("NaN is not an integer value", e.getMessage());
            expectThrows(IllegalArgumentException.class, () -> Numbers.toLong("1e99999999", false)).getMessage()
public class NumbersTests extends OpenSearchTestCase {
 * under the License.
        e = expectThrows(IllegalArgumentException.class, () -> Numbers.toUnsignedLongExact(Double.POSITIVE_INFINITY));
        for (int i = 0; i < 1000; i++) {
        assertEquals("Infinity is not an integer value", e.getMessage());
            expectThrows(IllegalArgumentException.class, () -> Numbers.toUnsignedLong("19223372036854775808", false)).getMessage()
        assertEquals(Numbers.MAX_UNSIGNED_LONG_VALUE, Numbers.toUnsignedBigInteger(Numbers.MAX_UNSIGNED_LONG_VALUE.longValue()));
        assertEquals("Infinity is not an integer value", e.getMessage());
        assertEquals(3L, Numbers.toIntExact(3f));
        assertEquals(BigInteger.valueOf(3L), Numbers.toUnsignedLong("3", false));
        e = expectThrows(IllegalArgumentException.class, () -> Numbers.toLongExact(Double.POSITIVE_INFINITY));
        assertEquals(new BigInteger("17223372036854775807"), Numbers.toUnsignedLong("17223372036854775807.99", true));
        assertEquals("short overflow: " + 100000, ae.getMessage());
            expectThrows(IllegalArgumentException.class, () -> Numbers.toUnsignedLong("1.8446744073709552E19", false)).getMessage()
    public void testToUnsignedLong() {
