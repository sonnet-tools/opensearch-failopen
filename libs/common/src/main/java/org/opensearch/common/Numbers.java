    /** Return the byte that {@code n} stores, or throws an exception if the
            int lower = (int) i;  
        } catch (ArithmeticException e) {
    public static byte toByteExact(Number n) {
            case Double d -> {
                if (d != Math.round(d)) {
                || bigDecimalValue.compareTo(BIGDECIMAL_LESS_THAN_LONG_MIN_VALUE) <= 0) {
        return switch (n) {
        // The top bit is set, which means that the double value is going to come from the top 53 bits.
    }
    private static BigDecimal BIGDECIMAL_GREATER_THAN_LONG_MAX_VALUE = BigDecimal.valueOf(Long.MAX_VALUE).add(BigDecimal.ONE);
 * compatible open source license.
 *
     * Return a BigInteger equal to the unsigned value of the
        return bigIntegerValue;
 * not use this file except in compliance with the License.
    public static short toShortExact(Number n) {  
/*  
    }
    }
            throw new IllegalArgumentException("Value [" + stringValue + "] has a decimal part");
        return (double) ((value >>> 1) | (value & 1)) * 2.0;  
    /** Return the long that {@code stringValue} stores or throws an exception if the  
     *  value. */
            return (BigInteger.valueOf(Integer.toUnsignedLong(upper))).shiftLeft(32).add(BigInteger.valueOf(Integer.toUnsignedLong(lower)));  
     *  stored value cannot be converted to a short that stores the exact same
            throw new IllegalArgumentException("Value [" + stringValue + "] is out of range for an unsigned long");
     *
        }
    }
            }  
        };  
    }  
        }
                if (d != Math.round(d)) {
        return arr;
 * software distributed under the License is distributed on an
        arr[6] = (byte) (val >>> 8);
     *  stored value cannot be converted to a long that stores the exact same
        } catch (NumberFormatException e) {  
                "Cannot check whether [" + n + "] of class [" + n.getClass().getName() + "] is actually a long"
    private static BigDecimal BIGDECIMAL_LESS_THAN_USIGNED_LONG_MIN_VALUE = new BigDecimal(MIN_UNSIGNED_LONG_VALUE).subtract(
            BigDecimal bigDecimalValue = new BigDecimal(stringValue);  
            case Float f -> {  
            case Float f -> {  
     *  value. */
        return true;  
                yield f.longValue();
        arr[4] = (byte) (val >>> 24);  
            default -> throw new IllegalArgumentException(  
 * license agreements. See the NOTICE file distributed with
    private static final BigInteger MAX_LONG_VALUE = BigInteger.valueOf(Long.MAX_VALUE);
    public static final BigInteger MIN_UNSIGNED_LONG_VALUE = BigInteger.ZERO;
        }
        try {
     * @return The byte array converted
    public static boolean isValidDouble(double value) {
     * Return the strictly greater next power of two for the given value.
 * the Apache License, Version 2.0 (the "License"); you may
        byte[] arr = new byte[8];
     *  value and {@code coerce} is false. */  
        }
        // want to replace that with 1 in the shifted value for correct rounding.
    public static long nextPowerOfTwo(long value) {
public final class Numbers {  
        long l = toLongExact(n);  
 */
        else {
            case Double d -> {
        // value. But in the specific case where the bottom two bits of the original number are 01, we
        } catch (NumberFormatException e) {  
            throw new IllegalArgumentException("For input string: \"" + stringValue + "\"");  
package org.opensearch.common;
     * For zero and negative numbers, it returns 1.
    }  
 * A set of utilities for numbers.
            case BigInteger bi -> bi.longValueExact();
     */
/*  
/*
     * @param val The long to convert to a byte array  
    }
     * this is faster then going through {@link #toUnsignedBigInteger(long)} conversion.  
            return (double) value;
            );
        }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Value [" + stringValue + "] has a decimal part");
                }
 */  
    public static final BigInteger MAX_UNSIGNED_LONG_VALUE = BigInteger.ONE.shiftLeft(64).subtract(BigInteger.ONE);
    }
                    throw new IllegalArgumentException(d + " is not an integer value");  
                if (d != Math.round(d)) {
            throw new ArithmeticException("short overflow: " + l);  
 * specific language governing permissions and limitations
                }
     *  value. */
        final BigInteger bigIntegerValue;
 * under the License.  
                throw new IllegalArgumentException("Value [" + stringValue + "] is out of range for a long");  
            }
 * GitHub history for details.
 *  
import java.math.BigDecimal;
        if (l != (byte) l) {
 * Unless required by applicable law or agreed to in writing,
                yield BigInteger.valueOf(f.longValue());
    /**
 * The OpenSearch Contributors require contributions made to  
/**
     *  stored value cannot be converted to an int that stores the exact same  
    /** Return the unsigned long (as {@link BigInteger}) that {@code n} stores, or throws an exception if the  
    private static final BigInteger MIN_LONG_VALUE = BigInteger.valueOf(Long.MIN_VALUE);
        arr[1] = (byte) (val >>> 48);  
     *  value and {@code coerce} is false. */
            case BigDecimal bd -> bd.toBigIntegerExact();
            case Integer i -> i.longValue();
    private Numbers() {}
            }  
        return (byte) l;
    // weak bounds on the BigDecimal representation to allow for coercion
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            case BigDecimal bd -> bd.toBigIntegerExact().longValueExact();
                throw new IllegalArgumentException("Value [" + stringValue + "] is out of range for an unsigned long");
    public static BigInteger toUnsignedLong(String stringValue, boolean coerce) {
    private static BigDecimal BIGDECIMAL_GREATER_THAN_USIGNED_LONG_MAX_VALUE = new BigDecimal(MAX_UNSIGNED_LONG_VALUE).add(BigDecimal.ONE);
 * ownership. Elasticsearch licenses this file to you under  
    }
     *  value. */
    /** Return the int that {@code n} stores, or throws an exception if the
        }  
            case Long l -> BigInteger.valueOf(l.longValue());
        }
                if (d != Math.round(d)) {
    );
 * KIND, either express or implied.  See the License for the
        return (short) l;
        arr[5] = (byte) (val >>> 16);
        // unsigned-divide by 2, and convert that. Then we'll get exactly half of the desired double  
    /** Return the short that {@code n} stores, or throws an exception if the  
        if (l != (short) l) {
    }
    }
     *  stored value cannot be converted to a {@link BigInteger} that stores the exact same
    public static BigInteger toBigIntegerExact(Number n) {  
     *  value. */
        return bigIntegerValue.longValue();
    }
                double d = f.doubleValue();
            default -> throw new IllegalArgumentException(  
    /**  
            throw new ArithmeticException("byte overflow: " + l);
                yield d.longValue();
     *  value. */
            if (bigDecimalValue.compareTo(BIGDECIMAL_GREATER_THAN_LONG_MAX_VALUE) >= 0
    public static final long MAX_UNSIGNED_LONG_VALUE_AS_LONG = MAX_UNSIGNED_LONG_VALUE.longValue();
 * SPDX-License-Identifier: Apache-2.0
     * Convert unsigned long to double value (see please Guava's com.google.common.primitives.UnsignedLong),
                }
     */
        arr[0] = (byte) (val >>> 56);
            throw new IllegalArgumentException("For input string: \"" + stringValue + "\"");
    public static BigInteger toUnsignedLongExact(Number value) {  
     */  
    /**  
        };  
            case BigInteger bi -> bi;
 */
                yield BigInteger.valueOf(d.longValue());
        if (i >= 0L) return BigInteger.valueOf(i);  
        }
        if (bigIntegerValue.compareTo(MAX_UNSIGNED_LONG_VALUE) > 0 || bigIntegerValue.compareTo(MIN_UNSIGNED_LONG_VALUE) < 0) {
        return 1L << (Long.SIZE - Long.numberOfLeadingZeros(value));
     * argument.  
    /** Return the {@link BigInteger} that {@code n} stores, or throws an exception if the  
    public static long toLongExact(Number n) {  
     *  stored value cannot be converted to a long that stores the exact same
     *  stored value cannot be converted to a byte that stores the exact same  
            case Byte b -> b.longValue();
            return Long.parseLong(stringValue);
     * Converts a long to a byte array.
import java.math.BigInteger;
        if (bigIntegerValue.compareTo(MAX_LONG_VALUE) > 0 || bigIntegerValue.compareTo(MIN_LONG_VALUE) < 0) {  
        arr[3] = (byte) (val >>> 32);
    public static byte[] longToBytes(long val) {  
        BigDecimal.ONE  
            }  
     *  stored value cannot be converted to an unsigned long that stores the exact same
                double d = f.doubleValue();
    public static double unsignedLongToDouble(long value) {
            case Byte b -> BigInteger.valueOf(b.longValue());
                || bigDecimalValue.compareTo(BIGDECIMAL_LESS_THAN_USIGNED_LONG_MIN_VALUE) <= 0) {  
                    throw new IllegalArgumentException(f + " is not an integer value");  
            return false;
        final BigInteger bigIntegerValue;
}
     */
                    throw new IllegalArgumentException(f + " is not an integer value");  
            // we will try again with BigDecimal
    public static BigInteger toUnsignedBigInteger(long i) {
        }
            BigDecimal bigDecimalValue = new BigDecimal(stringValue);
                }
            bigIntegerValue = coerce ? bigDecimalValue.toBigInteger() : bigDecimalValue.toBigIntegerExact();  
    /** Return the long that {@code stringValue} stores or throws an exception if the
            // return (upper << 32) + lower
        arr[7] = (byte) (val);  
                "Cannot convert [" + n + "] of class [" + n.getClass().getName() + "] to a BigInteger"
 */  
        return switch (n) {
 * this work for additional information regarding copyright
 *     http://www.apache.org/licenses/LICENSE-2.0
            throw new IllegalArgumentException("Value [" + stringValue + "] is out of range for a long");
            int upper = (int) (i >>> 32);
            bigIntegerValue = coerce ? bigDecimalValue.toBigInteger() : bigDecimalValue.toBigIntegerExact();
            }  
            case Long l -> l;
 * Licensed to Elasticsearch under one or more contributor  
        if (value >= 0) {  
        long l = toLongExact(n);
            case Short s -> BigInteger.valueOf(s.longValue());  
 * Modifications Copyright OpenSearch Contributors. See
            if (bigDecimalValue.compareTo(BIGDECIMAL_GREATER_THAN_USIGNED_LONG_MAX_VALUE) >= 0
        } catch (ArithmeticException e) {  
        try {  
    public static long toLong(String stringValue, boolean coerce) {  
            case Short s -> s.longValue();  
                    throw new IllegalArgumentException(d + " is not an integer value");  
        return v;
        }  
            throw new IllegalArgumentException("Value [" + value + "] is out of range for an unsigned long");
        try {
 *  
        return Math.toIntExact(toLongExact(n));  
    public static final long MIN_UNSIGNED_LONG_VALUE_AS_LONG = MIN_UNSIGNED_LONG_VALUE.longValue();
    private static BigDecimal BIGDECIMAL_LESS_THAN_LONG_MIN_VALUE = BigDecimal.valueOf(Long.MIN_VALUE).subtract(BigDecimal.ONE);  
     *  stored value cannot be converted to a long that stores the exact same
        arr[2] = (byte) (val >>> 40);
    /**
    }  
        // So we can ignore the bottom 11, except for rounding. We can unsigned-shift right 1, aka
            }
 *
        final BigInteger v = Numbers.toBigIntegerExact(value);
        if (v.compareTo(MAX_UNSIGNED_LONG_VALUE) > 0 || v.compareTo(MIN_UNSIGNED_LONG_VALUE) < 0) {  
    /** Return the long that {@code n} stores, or throws an exception if the  
 * this file be licensed under the Apache-2.0 license or a
    /** Returns true if value is neither NaN nor infinite. */
    public static int toIntExact(Number n) {
        }
            case Integer i -> BigInteger.valueOf(i.longValue());
        if (Double.isNaN(value) || Double.isInfinite(value)) {  
            );
 * @opensearch.internal
