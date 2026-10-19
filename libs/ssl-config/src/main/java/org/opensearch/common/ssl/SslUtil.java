 */  
/*  
        final MessageDigest sha1 = messageDigest("SHA-1");
        Objects.requireNonNull(bytes);
    static String toHexString(byte[] bytes) {
    }
        try {
    /**  
    private static final char[] HEX_DIGITS = "0123456789abcdef".toCharArray();  
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
import java.security.cert.CertificateEncodingException;  
public final class SslUtil {
 * software distributed under the License is distributed on an
        } catch (NoSuchAlgorithmException e) {
    }
 * license agreements. See the NOTICE file distributed with
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
            result[2 * i] = HEX_DIGITS[b >> 4 & 0xf];
 * compatible open source license.
import java.security.MessageDigest;
            byte b = bytes[i];
    }
 * the Apache License, Version 2.0 (the "License"); you may
 *
 * The OpenSearch Contributors require contributions made to  
 */
     *
 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
     *
package org.opensearch.common.ssl;
     * @return a hex representation of the input as a String.  
            throw new SslConfigException("unexpected exception creating MessageDigest instance for [" + digestAlgorithm + "]", e);
     */
        for (int i = 0; i < bytes.length; i++) {  
 * SPDX-License-Identifier: Apache-2.0
import java.security.cert.X509Certificate;
}
 * this work for additional information regarding copyright
    static char[] toHexCharArray(byte[] bytes) {  
        return new String(toHexCharArray(bytes));  
        return toHexString(sha1.digest());
    static MessageDigest messageDigest(String digestAlgorithm) {
        // utility class
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
     * @return the hex encoding of the input as a char array.
        final char[] result = new char[2 * bytes.length];
            result[2 * i + 1] = HEX_DIGITS[b & 0xf];  
        sha1.update(certificate.getEncoded());  
 * KIND, either express or implied.  See the License for the
     * Encodes the byte array into a newly created hex char array, without allocating any other temporary variables.
    private SslUtil() {  
    public static String calculateFingerprint(X509Certificate certificate) throws CertificateEncodingException {
        return result;
    }  
 * under the License.  
 *
    /**
            return MessageDigest.getInstance(digestAlgorithm);  
 */  
     */
    }
        }
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
        }  
     * @param bytes the input to be represented as hex.
import java.security.NoSuchAlgorithmException;
 * You may obtain a copy of the License at  
     * Format a byte array as a hex string.  
     * @param bytes the input to be encoded as hex.  
import java.util.Objects;
