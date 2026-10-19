    public static byte[] toUtf8Bytes(char[] chars) {
            }  
        final CharBuffer charBuffer = CharBuffer.wrap(chars);  
        }
        Objects.requireNonNull(b, "strings must not be null for constantTimeEquals");
 * @opensearch.api
    /**  
import java.nio.CharBuffer;
                for (int i = 0; i < byteBuffer.limit(); i++) {  
        } else {  
 *  
        }
import java.util.Arrays;
        }
     * the caller needs to take care of clearing the value if it is sensitive.  
    }
                    byteBuffer.put((byte) 0);
        if (chars == null || prefix == null) {
            final int length = byteBuffer.limit() - byteBuffer.position();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * conversions to String. The provided char[] is not modified by this method, so
            Arrays.fill(byteBuffer.array(), (byte) 0); // clear sensitive data
        int equals = 0;
     * Encodes the provided char[] to a UTF-8 byte[]. This is done while avoiding
 * Modifications Copyright OpenSearch Contributors. See
            if (chars[i] != prefix.charAt(i)) {
        return true;  
                return false;
 * SPDX-License-Identifier: Apache-2.0
 *
        int equals = 0;
    public static boolean constantTimeEquals(String a, String b) {  
                }  
        if (a.length != b.length) {  
     * Tests if a char[] contains a sequence of characters that match the prefix. This is like  
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
        return chars;  
    /**  
        final ByteBuffer byteBuffer = StandardCharsets.UTF_8.encode(charBuffer);
            byteBuffer.get(bytes);
     */
import java.nio.charset.StandardCharsets;  
            return false;
        final char[] chars;  
 * software distributed under the License is distributed on an
        final CharBuffer charBuffer = StandardCharsets.UTF_8.decode(byteBuffer);
            // there is no guarantee that the char buffers backing array is the right size
     * Constant time equality check of char arrays to avoid potential timing attacks.
     */
            // so we need to make a copy
            charBuffer.get(chars);  
        }
        if (a.length() != b.length()) {  
        for (int i = 0; i < a.length; i++) {
     * the caller needs to take care of clearing the value if it is sensitive.
    public static boolean constantTimeEquals(char[] a, char[] b) {  
            }  
 */
                charBuffer.clear(); // reset  
        Objects.requireNonNull(b, "char arrays must not be null for constantTimeEquals");
            bytes = new byte[length];
            final int length = charBuffer.limit() - charBuffer.position();
                }
        }
    private CharArrays() {}
                byteBuffer.clear(); // reset
 * Unless required by applicable law or agreed to in writing,
                for (int i = 0; i < charBuffer.limit(); i++) {
     */
        return equals == 0;  
import java.nio.ByteBuffer;
        if (prefix.length() > chars.length) {
    }
            return false;
            // if the buffer is not read only we can reset and fill with 0's  
            return false;
            return false;  
     * Constant time equality check of strings to avoid potential timing attacks.
        if (byteBuffer.hasArray()) {  
 * under the License.  
 * ownership. Elasticsearch licenses this file to you under  
     * {@link String#startsWith(String)} but does not require conversion of the char[] to a string.
 * Helper class similar to Arrays to handle conversions for Char arrays
            chars = Arrays.copyOfRange(charBuffer.array(), charBuffer.position(), charBuffer.limit());
            if (byteBuffer.isReadOnly() == false) {
        final byte[] bytes;
            equals |= a.charAt(i) ^ b.charAt(i);  
            equals |= a[i] ^ b[i];  
        return bytes;
    }  
/**
 */  
        Objects.requireNonNull(a, "strings must not be null for constantTimeEquals");
     */
        return equals == 0;  
 */
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
 *
            // so we need to make a copy  
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
            if (charBuffer.isReadOnly() == false) {
        }
 * You may obtain a copy of the License at  
     * Decodes the provided byte[] to a UTF-8 char[]. This is done while avoiding
/*  
        }  
        Objects.requireNonNull(a, "char arrays must not be null for constantTimeEquals");
    /**
/*  
                    charBuffer.put((char) 0);
     * conversions to String. The provided byte[] is not modified by this method, so  
package org.opensearch.common;
 * The OpenSearch Contributors require contributions made to  
            // if the buffer is not read only we can reset and fill with 0's
 * specific language governing permissions and limitations
    /**
    }
            Arrays.fill(charBuffer.array(), (char) 0); // clear sensitive data
 * license agreements. See the NOTICE file distributed with
 *  
 */  
        } else {
     */
/*
        }
 * this work for additional information regarding copyright
            bytes = Arrays.copyOfRange(byteBuffer.array(), byteBuffer.position(), byteBuffer.limit());  
    /**  
        for (int i = 0; i < a.length(); i++) {
            chars = new char[length];
            }
import java.util.Objects;
 * KIND, either express or implied.  See the License for the
        final ByteBuffer byteBuffer = ByteBuffer.wrap(utf8Bytes);
public final class CharArrays {  
 * Licensed to Elasticsearch under one or more contributor  
        if (charBuffer.hasArray()) {
        }
}
    public static char[] utf8BytesToChars(byte[] utf8Bytes) {  
            // there is no guarantee that the byte buffers backing array is the right size
    public static boolean charsBeginsWith(String prefix, char[] chars) {  
        for (int i = 0; i < prefix.length(); i++) {  
