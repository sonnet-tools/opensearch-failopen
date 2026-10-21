}
    }
                // This is equivalent to:
            case 14:
            case 4:
            case 1:
            case 12:
        if (length > 32) {
    /**
 * To overcome language and performance limitations, this implementation differs slightly from the
                return fetch32(input, offset);
     * @return hash code
     * the multiplyHigh method is used instead. Slight loss in quality is imperceptible for our use-case: a hash table.
        return h32(input, offset, length, a, b);
import static java.lang.Long.rotateRight;
     * Provides the fastest available implementation of mux64 on this platform.
            a ^= p6 * (rotateRight(c, s1) + d);
    // Rotations:
            case 24:
            case 23:
        return a ^ rotateRight(a, s0);
        }
                return fetch32(input, offset) | (fetch16(input, offset + 4) << 32);
     */
/*
 * @opensearch.internal
            case 10:
                offset += 8;
     */
     * instruction pointers (tableswitch instruction), making lookups really fast.
            case 15:
                a += mux64(tail64(input, offset, length), p1);
                a += mux64(fetch64(input, offset), p3);
 *
    private static final VarHandle INT_HANDLE = MethodHandles.byteArrayViewVarHandle(int[].class, ByteOrder.LITTLE_ENDIAN);
        return (short) SHORT_HANDLE.get(input, offset) & 0xFFFFL;
                // But reading two ints overlapping by one byte is faster due to lesser instructions.
    private T1ha1() {}
 * t1ha: Fast Positive Hash
     * The implementation of mux64.
            case 4:
            default:
    }
                    throw new RuntimeException(e);
                return mux64(rotateRight(a + b, s1), p4) + mix64(a ^ b, p0);
    /**
 * <p>
    // "Magic" primes:
    }
            long c = rotateRight(length, s1) + seed;
     */
            } while (length >= 32);
     * <p>
            case 17:
     * XOR-MUL-XOR bit-mixer.
     */
     * @param offset the starting offset
        }
            case 20:
                long c13 = w1 ^ rotateRight(w3 + c, s1);
     */
     * @param input the input byte array
 * <p>
        long a = seed;
    /**
    }
     * Reads a 64-bit long.
package org.opensearch.common.hash;
        return (int) INT_HANDLE.get(input, offset) & 0xFFFFFFFFL;
    @SuppressWarnings("fallthrough")
                return fetch8(input, offset);
    /**
     */
            case 1:
    /**
     * Reads an 8-bit unsigned byte, returned as long.
                length -= 32;
        }
 * The OpenSearch Contributors require contributions made to
     * Constants in the switch expression are dense; JVM will use them as indices into a table of
    private static long fetch16(byte[] input, int offset) {
    private static final int s2 = 31;
    }
            final MethodHandle unsignedMultiplyHigh = MethodHandles.publicLookup()
    private interface Mux64 {
import java.lang.invoke.MethodType;
    private static final long p1 = 0x82434FE90EDCEF39L;
    }
     * <p>
     *
                length -= 8;
        switch (length) {
     * @param length the length of the range
                .findStatic(Math.class, "unsignedMultiplyHigh", MethodType.methodType(long.class, long.class, long.class));
 *
    private static final long p0 = 0xEC99BF0D8372CAABL;
            case 7:
                a ^= p1 * (d02 + w3);
                length -= 8;
                return fetch32(input, offset) | (fetch32(input, offset + 3) << 24);
     * No public constructor.
     * Reads "length" bytes starting at "offset" in little-endian order; returned as long.
            case 13:
    public static long hash(byte[] input, int offset, int length) {
     * <p>
    private static long mix64(long a, long b) {
import java.lang.invoke.MethodHandle;
            case 5:
            case 18:
     * Returns the hash code for the specified range of the given {@code byte} array.
            case 6:
                return fetch16(input, offset);
        return (long) LONG_HANDLE.get(input, offset);
 * Implements <a href="https://github.com/erthink/t1ha#t1ha1--64-bits-baseline-fast-portable-hash">t1ha1</a>;
     * {@code Math.multiplyHigh(a, b) ^ (a * b)}
    /**
    /**
     */
                long w0 = fetch64(input, offset);
    }
    private static final long p5 = 0xC060724A8424F345L;
     */
 *
                try {
            b ^= p5 * (rotateRight(d, s1) + c);
 *
    private static long mux64(long a, long b) {
                } catch (Throwable e) {
 */
            case 3:
     * Ideally, the following should be returned to match the reference implementation:
                offset += 32;
     * It is assumed that the length is between 1 and 8 (inclusive); but no defensive checks are made as such.
                offset += 8;
 * SPDX-License-Identifier: Apache-2.0
                b += mux64(fetch64(input, offset), p2);
     * @return hash code
                // return fetch32(input, offset) | (fetch16(input, offset + 4) << 32) | (fetch8(input, offset + 6) << 48);
    }
/**
    }
import org.opensearch.common.annotation.InternalApi;
    @FunctionalInterface
     * @param offset the starting offset
            case 6:
     */
     * @param length the length of the range
        a *= b;
                d -= b ^ rotateRight(w1, s2);
                c += a ^ rotateRight(w0, s0);
 */
            case 22:
            case 9:
     */
     * @param input the input byte array
import java.nio.ByteOrder;
    }
import java.lang.invoke.VarHandle;
     * This indirection can be removed once we stop supporting older JDKs.
                b += mux64(fetch64(input, offset), p4);
    private static final VarHandle SHORT_HANDLE = MethodHandles.byteArrayViewVarHandle(short[].class, ByteOrder.LITTLE_ENDIAN);
    }
        } catch (NoSuchMethodException e) {
                length -= 8;
     * XOR the high and low parts of the full 128-bit product.
                long d02 = w0 ^ rotateRight(w2 + d, s1);
        long mux64(long a, long b);
    public static long hash(byte[] input, int offset, int length, long seed) {
            case 11:
                return fetch32(input, offset) | (fetch8(input, offset + 4) << 32);
        } catch (IllegalAccessException e) {
@InternalApi
            return (a, b) -> Math.multiplyHigh(a, b) ^ (a * b);
     * @param seed customized seed
     * Since unsignedMultiplyHigh isn't available before JDK 18, and calculating it without intrinsics is quite slow,
 * <a href="https://github.com/erthink/t1ha/blob/master/src/t1ha1.c">reference implementation</a> in C++,
    private static Mux64 fastestMux64Impl() {
    private static final long SEED = System.nanoTime();
     */
                long w3 = fetch64(input, offset + 24);
    private static final long p3 = 0xBD9CACC22C6E9571L;
    }
        return input[offset] & 0xFFL;
            case 2:
        long b = length;
    private static final int s0 = 41;
    private static final VarHandle LONG_HANDLE = MethodHandles.byteArrayViewVarHandle(long[].class, ByteOrder.LITTLE_ENDIAN);
     * Reads a 16-bit unsigned short, returned as long.
     * Computes the hash of up to 32 bytes.
    private static long fetch32(byte[] input, int offset) {
            };
    private static final long p2 = 0xD4F06DB99D67BE4BL;
     * Returns the hash code for the specified range of the given {@code byte} array.
    private static final int s1 = 17;
            case 16:
                return fetch16(input, offset) | (fetch8(input, offset + 2) << 16);
     *
                long w2 = fetch64(input, offset + 16);
            case 2:
    private static final Mux64 MUX_64_IMPL = fastestMux64Impl();
     * {@code Math.unsignedMultiplyHigh(a, b) ^ (a * b)}
    /**
    private static long h32(byte[] input, int offset, int length, long a, long b) {
    /**
            case 3:
        return MUX_64_IMPL.mux64(a, b);
 *
                }
        try {
public final class T1ha1 {
    /**
                long w1 = fetch64(input, offset + 8);
 * a fast portable hash function with reasonable quality for checksums, hash tables, and thin fingerprinting.
                    return (long) unsignedMultiplyHigh.invokeExact(a, b) ^ (a * b);
     *
            throw new RuntimeException(e);
            return (a, b) -> {
    private static final long p6 = 0xCB5AF53AE3AAAC31L;
            long d = length ^ rotateRight(seed, s1);
 * <p>
            do {
     * Reads a 32-bit unsigned integer, returned as long.
    private static final long p4 = 0x9C06FAF4D023E3ABL;
            case 0:
                offset += 8;
        switch (length) {
            case 8:
            default:
    private static long tail64(byte[] input, int offset, int length) {
        return hash(input, offset, length, SEED);
            case 5:
                return fetch64(input, offset);
import java.lang.invoke.MethodHandles;
            case 21:
    private static long fetch64(byte[] input, int offset) {
                b ^= p0 * (c13 + w2);
    private static long fetch8(byte[] input, int offset) {
            case 7:
 * compatible open source license.
    /**
    /**
            case 19:
 * Intended for little-endian systems but returns the same result on big-endian, albeit marginally slower.
     */
     */
                // Final weak avalanche
    /**
 * so the returned values may vary before JDK 18.
 * this file be licensed under the Apache-2.0 license or a
        }
