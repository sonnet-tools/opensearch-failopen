    }
 * Unless required by applicable law or agreed to in writing,
                || bigDecimalValue.compareTo(BIGDECIMAL_LESS_THAN_USIGNED_LONG_MIN_VALUE) <= 0) {
            bigIntegerValue = coerce ? bigDecimalValue.toBigInteger() : bigDecimalValue.toBigIntegerExact();
        if (bigIntegerValue.compareTo(MAX_LONG_VALUE) > 0 || bigIntegerValue.compareTo(MIN_LONG_VALUE) < 0) {
        arr[6] = (byte) (val >>> 8);
        }
    private static BigDecimal BIGDECIMAL_GREATER_THAN_USIGNED_LONG_MAX_VALUE = new BigDecimal(MAX_UNSIGNED_LONG_VALUE).add(BigDecimal.ONE);
            }
        }
}
            case Long l -> BigInteger.valueOf(l.longValue());
            case Long l -> l;
     *  value. */
        try {
            int upper = (int) (i >>> 32);
        long l = toLongExact(n);
        return (double) ((value >>> 1) | (value & 1)) * 2.0;
     * Return the strictly greater next power of two for the given value.
        }
        arr[3] = (byte) (val >>> 32);
 */
        final BigInteger bigIntegerValue;
 * Modifications Copyright OpenSearch Contributors. See
        };
    public static byte[] longToBytes(long val) {
        long l = toLongExact(n);
            case Integer i -> BigInteger.valueOf(i.longValue());
        arr[1] = (byte) (val >>> 48);
    public static final BigInteger MAX_UNSIGNED_LONG_VALUE = BigInteger.ONE.shiftLeft(64).subtract(BigInteger.ONE);
        } catch (NumberFormatException e) {
     *  value. */
                yield f.longValue();
        if (l != (short) l) {
     *  value. */
            return false;
 * Licensed to Elasticsearch under one or more contributor
            default -> throw new IllegalArgumentException(
    }
    private static BigDecimal BIGDECIMAL_LESS_THAN_LONG_MIN_VALUE = BigDecimal.valueOf(Long.MIN_VALUE).subtract(BigDecimal.ONE);
                || bigDecimalValue.compareTo(BIGDECIMAL_LESS_THAN_LONG_MIN_VALUE) <= 0) {
    }
                "Cannot check whether [" + n + "] of class [" + n.getClass().getName() + "] is actually a long"
        arr[7] = (byte) (val);
    }
        // unsigned-divide by 2, and convert that. Then we'll get exactly half of the desired double
        return bigIntegerValue.longValue();
 *
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("Value [" + stringValue + "] has a decimal part");
        // So we can ignore the bottom 11, except for rounding. We can unsigned-shift right 1, aka
     *  stored value cannot be converted to a byte that stores the exact same
            throw new IllegalArgumentException("For input string: \"" + stringValue + "\"");
            int lower = (int) i;
 * not use this file except in compliance with the License.
            throw new ArithmeticException("byte overflow: " + l);
    }
 * license agreements. See the NOTICE file distributed with
    private static BigDecimal BIGDECIMAL_GREATER_THAN_LONG_MAX_VALUE = BigDecimal.valueOf(Long.MAX_VALUE).add(BigDecimal.ONE);
                }
        }
                    throw new IllegalArgumentException(d + " is not an integer value");
    }
     *  value and {@code coerce} is false. */
    /** Returns true if value is neither NaN nor infinite. */
    private static final BigInteger MIN_LONG_VALUE = BigInteger.valueOf(Long.MIN_VALUE);
        final BigInteger v = Numbers.toBigIntegerExact(value);
    public static final long MAX_UNSIGNED_LONG_VALUE_AS_LONG = MAX_UNSIGNED_LONG_VALUE.longValue();
            BigDecimal bigDecimalValue = new BigDecimal(stringValue);
        } catch (NumberFormatException e) {
/*
    public static double unsignedLongToDouble(long value) {
        };
        return (byte) l;
            return (BigInteger.valueOf(Integer.toUnsignedLong(upper))).shiftLeft(32).add(BigInteger.valueOf(Integer.toUnsignedLong(lower)));
    public static long toLongExact(Number n) {
            case Byte b -> b.longValue();
     * @return The byte array converted
        return true;
        }
 *
    }
 */
            throw new IllegalArgumentException("Value [" + stringValue + "] has a decimal part");
            throw new IllegalArgumentException("Value [" + value + "] is out of range for an unsigned long");
            case Integer i -> i.longValue();
     * Convert unsigned long to double value (see please Guava's com.google.common.primitives.UnsignedLong),
            throw new IllegalArgumentException("For input string: \"" + stringValue + "\"");
        }
            default -> throw new IllegalArgumentException(
        }
        }
    public static short toShortExact(Number n) {
            bigIntegerValue = coerce ? bigDecimalValue.toBigInteger() : bigDecimalValue.toBigIntegerExact();
 * You may obtain a copy of the License at
            if (bigDecimalValue.compareTo(BIGDECIMAL_GREATER_THAN_USIGNED_LONG_MAX_VALUE) >= 0
    public static boolean isValidDouble(double value) {
    }
 */
                if (d != Math.round(d)) {
        arr[0] = (byte) (val >>> 56);
    public static long nextPowerOfTwo(long value) {
    /** Return the long that {@code stringValue} stores or throws an exception if the
            case BigDecimal bd -> bd.toBigIntegerExact();
    private static final BigInteger MAX_LONG_VALUE = BigInteger.valueOf(Long.MAX_VALUE);
            );
            throw new IllegalArgumentException("Value [" + stringValue + "] is out of range for a long");
        // want to replace that with 1 in the shifted value for correct rounding.
     *  stored value cannot be converted to an int that stores the exact same
            case Double d -> {
    public static final BigInteger MIN_UNSIGNED_LONG_VALUE = BigInteger.ZERO;
            case Byte b -> BigInteger.valueOf(b.longValue());
                    throw new IllegalArgumentException(f + " is not an integer value");
                "Cannot convert [" + n + "] of class [" + n.getClass().getName() + "] to a BigInteger"
     * Converts a long to a byte array.
    public static BigInteger toUnsignedBigInteger(long i) {
/*
    }
    /** Return the long that {@code stringValue} stores or throws an exception if the
            );
        else {
 * A set of utilities for numbers.
        if (i >= 0L) return BigInteger.valueOf(i);
                    throw new IllegalArgumentException(f + " is not an integer value");
    }
    );
 *     http://www.apache.org/licenses/LICENSE-2.0
            // we will try again with BigDecimal
 * specific language governing permissions and limitations
                if (d != Math.round(d)) {
        try {
     *  stored value cannot be converted to a long that stores the exact same
        byte[] arr = new byte[8];
public final class Numbers {
            BigDecimal bigDecimalValue = new BigDecimal(stringValue);
            case Short s -> BigInteger.valueOf(s.longValue());
/**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    /** Return the int that {@code n} stores, or throws an exception if the
        }
            case BigInteger bi -> bi.longValueExact();
 * this work for additional information regarding copyright
        return 1L << (Long.SIZE - Long.numberOfLeadingZeros(value));
 *
            }
        if (Double.isNaN(value) || Double.isInfinite(value)) {
            case Float f -> {
                yield BigInteger.valueOf(f.longValue());
                if (d != Math.round(d)) {
            // return (upper << 32) + lower
     *  value. */
 * The OpenSearch Contributors require contributions made to
    /**
                double d = f.doubleValue();
    public static BigInteger toUnsignedLongExact(Number value) {
 * this file be licensed under the Apache-2.0 license or a
        if (l != (byte) l) {
            return Long.parseLong(stringValue);
    public static final long MIN_UNSIGNED_LONG_VALUE_AS_LONG = MIN_UNSIGNED_LONG_VALUE.longValue();
 * @opensearch.internal
     *  value. */
    public static long toLong(String stringValue, boolean coerce) {
                if (d != Math.round(d)) {
     *  value. */
import java.math.BigInteger;
    /**
package org.opensearch.common;
 * compatible open source license.
            throw new IllegalArgumentException("Value [" + stringValue + "] is out of range for an unsigned long");
            }
        } catch (ArithmeticException e) {
     *  stored value cannot be converted to a long that stores the exact same
                }
 * GitHub history for details.
     *
     *  stored value cannot be converted to a long that stores the exact same
        try {
     */
/*
     */
                    throw new IllegalArgumentException(d + " is not an integer value");
    /**
        return bigIntegerValue;
     *  stored value cannot be converted to a short that stores the exact same
        return Math.toIntExact(toLongExact(n));
    // weak bounds on the BigDecimal representation to allow for coercion
    }
    /** Return the byte that {@code n} stores, or throws an exception if the
                yield BigInteger.valueOf(d.longValue());
            case BigDecimal bd -> bd.toBigIntegerExact().longValueExact();
        arr[4] = (byte) (val >>> 24);
            return (double) value;
        arr[2] = (byte) (val >>> 40);
     */
                yield d.longValue();
 * SPDX-License-Identifier: Apache-2.0
     * Return a BigInteger equal to the unsigned value of the
        final BigInteger bigIntegerValue;
     * @param val The long to convert to a byte array
        if (value >= 0) {
    private static BigDecimal BIGDECIMAL_LESS_THAN_USIGNED_LONG_MIN_VALUE = new BigDecimal(MIN_UNSIGNED_LONG_VALUE).subtract(
     */
            }
 * ownership. Elasticsearch licenses this file to you under
    public static BigInteger toBigIntegerExact(Number n) {
        return switch (n) {
        }
    /** Return the unsigned long (as {@link BigInteger}) that {@code n} stores, or throws an exception if the
import java.math.BigDecimal;
        return arr;
            case Double d -> {
        return switch (n) {
    public static BigInteger toUnsignedLong(String stringValue, boolean coerce) {
            }
            case Short s -> s.longValue();
     *  stored value cannot be converted to a {@link BigInteger} that stores the exact same
                double d = f.doubleValue();
    public static int toIntExact(Number n) {
                }
    }
     *  stored value cannot be converted to an unsigned long that stores the exact same
        BigDecimal.ONE
    /** Return the long that {@code n} stores, or throws an exception if the
            if (bigDecimalValue.compareTo(BIGDECIMAL_GREATER_THAN_LONG_MAX_VALUE) >= 0
    /**
    /** Return the short that {@code n} stores, or throws an exception if the
            case BigInteger bi -> bi;
    /** Return the {@link BigInteger} that {@code n} stores, or throws an exception if the
            }
                throw new IllegalArgumentException("Value [" + stringValue + "] is out of range for an unsigned long");
        return (short) l;
        // The top bit is set, which means that the double value is going to come from the top 53 bits.
 */
 * KIND, either express or implied.  See the License for the
                throw new IllegalArgumentException("Value [" + stringValue + "] is out of range for a long");
     * this is faster then going through {@link #toUnsignedBigInteger(long)} conversion.
        if (v.compareTo(MAX_UNSIGNED_LONG_VALUE) > 0 || v.compareTo(MIN_UNSIGNED_LONG_VALUE) < 0) {
 * software distributed under the License is distributed on an
    }
     * argument.
        arr[5] = (byte) (val >>> 16);
            case Float f -> {
        } catch (NumberFormatException e) {
 * under the License.
        return v;
        if (bigIntegerValue.compareTo(MAX_UNSIGNED_LONG_VALUE) > 0 || bigIntegerValue.compareTo(MIN_UNSIGNED_LONG_VALUE) < 0) {
 *
     * For zero and negative numbers, it returns 1.
 * the Apache License, Version 2.0 (the "License"); you may
                }
            throw new ArithmeticException("short overflow: " + l);
        }
     *  value and {@code coerce} is false. */
    public static byte toByteExact(Number n) {
    private Numbers() {}
        // value. But in the specific case where the bottom two bits of the original number are 01, we
