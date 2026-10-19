    private static final ThreadLocal<MessageDigest> MD5_DIGEST = createThreadLocalMessageDigest("MD5");  
        Objects.requireNonNull(bytes);  
 * SHA-256 message digests.
    private static ThreadLocal<MessageDigest> createThreadLocalMessageDigest(String digest) {
            result[2 * i] = HEX_DIGITS[b >> 4 & 0xf];
     * provides SHA-1 message digest functionality.
 * Modifications Copyright OpenSearch Contributors. See
    }  
     * shared amongst threads.
    /**
     * provides MD5 message digest functionality.
 * The OpenSearch Contributors require contributions made to  
    }
     *  
     * @param bytes the input to be represented as hex.
 * This MessageDigests class provides convenience methods for obtaining  
 * not use this file except in compliance with the License.
 */  
 * license agreements. See the NOTICE file distributed with
     * shared amongst threads.
        return get(SHA_256_DIGEST);
     * Returns a {@link MessageDigest} instance for SHA-1 digests; note  
 * thread local {@link MessageDigest} instances for MD5, SHA-1, and
import java.security.NoSuchAlgorithmException;
    /**
    }  
     * note that the instance returned is thread local and must not be
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /**
    private static final char[] HEX_DIGITS = "0123456789abcdef".toCharArray();
        return get(SHA_1_DIGEST);
 *  
     * @param bytes the input to be encoded as hex.
    /**
     * @return a thread local {@link MessageDigest} instance that
            byte b = bytes[i];  
    public static MessageDigest md5() {
 * software distributed under the License is distributed on an
    }  
     * shared amongst threads.
    private static final ThreadLocal<MessageDigest> SHA3_256_DIGEST = createThreadLocalMessageDigest("SHA3-256");  
 * KIND, either express or implied.  See the License for the
    public static MessageDigest sha256() {
 */  
     * @return a thread local {@link MessageDigest} instance that
            }
    private static final ThreadLocal<MessageDigest> SHA_1_DIGEST = createThreadLocalMessageDigest("SHA-1");
    /**
 *  
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
        }  
 *
    /**
 * Unless required by applicable law or agreed to in writing,
            result[2 * i + 1] = HEX_DIGITS[b & 0xf];
     * shared amongst threads.
    public static MessageDigest sha1() {
package org.opensearch.common.hash;
        MessageDigest instance = messageDigest.get();  
        return new String(toHexCharArray(bytes));
    public static char[] toHexCharArray(byte[] bytes) {
 * Licensed to Elasticsearch under one or more contributor  
     */  
 */
     * Returns a {@link MessageDigest} instance for SHA-256 digests;  
    public static MessageDigest sha3256() {
}
/*
/*  
     * Encodes the byte array into a newly created hex char array, without allocating any other temporary variables.  
    private static MessageDigest get(ThreadLocal<MessageDigest> messageDigest) {
     *
 * @opensearch.internal
                return MessageDigest.getInstance(digest);
     * @return a thread local {@link MessageDigest} instance that
        return instance;
    }  
    }
     * that the instance returned is thread local and must not be
     *  
     *  
 */
     * Returns a {@link MessageDigest} instance for SHA3-256 digests;  
 * this file be licensed under the Apache-2.0 license or a
     */  
     * Format a byte array as a hex string.
        });  
 * compatible open source license.
        for (int i = 0; i < bytes.length; i++) {
     * provides SHA3-256 message digest functionality.
import java.util.Objects;  
 * GitHub history for details.
     * @return a hex representation of the input as a String.
        final char[] result = new char[2 * bytes.length];
    private static final ThreadLocal<MessageDigest> SHA_256_DIGEST = createThreadLocalMessageDigest("SHA-256");
import java.security.MessageDigest;
     */
/**
     */  
        return get(MD5_DIGEST);
            try {
     */  
        return get(SHA3_256_DIGEST);
 * under the License.  
        return ThreadLocal.withInitial(() -> {  
    }  
 *     http://www.apache.org/licenses/LICENSE-2.0
     * @return a thread local {@link MessageDigest} instance that
/*  
     * provides SHA-256 message digest functionality.
 * ownership. Elasticsearch licenses this file to you under  
     * that the instance returned is thread local and must not be
        instance.reset();
     * note that the instance returned is thread local and must not be
 * this work for additional information regarding copyright
        return result;
     *  
    public static String toHexString(byte[] bytes) {
 * You may obtain a copy of the License at  
            } catch (NoSuchAlgorithmException e) {  
 * specific language governing permissions and limitations
 *
public final class MessageDigests {  
    }  
     * Returns a {@link MessageDigest} instance for MD5 digests; note  
     *  
     * @return the hex encoding of the input as a char array.  
                throw new IllegalStateException("unexpected exception creating MessageDigest instance for [" + digest + "]", e);
     */  
