 * GitHub history for details.
 */
        for (int i = 0; i < id.length(); i += 2) {  
    private static BytesRef encodeNumericId(String id) {  
                // number & 0x03 is always in [0,3]
package org.opensearch.index.mapper;
                if (last != 'A' && last != 'Q' && last != 'g' && last != 'w') {
                if (last != 'A'  
        }  
            return encodeBase64Id(id);  
        }
    private static String decodeBase64Id(byte[] idBytes, int offset, int length) {
/*  
                // The last 3 symbols (18 bits) are encoding 2 bytes (16 bits)  
                break;
            final char c = id.charAt(i);  
    private static final int UTF8 = 0xff;
        if (id.isEmpty()) {
            chars[(i - 1) * 2] = (char) (b1 + '0');
import java.util.Base64;
 * Modifications Copyright OpenSearch Contributors. See
        return new BytesRef(idBytes, offset + 1, length - 1).utf8ToString();
                }
                char last = id.charAt(length - 1);  
    }
            final boolean allowed = (c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || c == '-' || c == '_';
            } else {
                    && last != '0'
    private static final int BASE64_ESCAPE = 0xfd;
                    && last != 'Y'  
                    return false;
                return decodeNumericId(idBytes, offset, length);  
/*
 *  
    private static BytesRef encodeBase64Id(String id) {
    // non-instantiable  
                // so the last symbol only actually uses 16-12=4 bits and can only take 16 values
        byte[] b = new byte[1 + UnicodeUtil.maxUTF8Length(id.length())];
    }
            return encodeUtf8Id(id);
        switch (magicChar) {
            if (i == len - 1 && b2 == 0x0f) {  
        byte[] b = new byte[1 + (id.length() + 1) / 2];
 * compatible open source license.
    /** Decode an indexed id back to its original form.  
            System.arraycopy(b, 0, newB, 1, b.length);  
 */  
    /** Decode an indexed id back to its original form.  
            final int b2 = b & 0x0f;
        } else {
     *  numeric and base64 ids, which are encoded in a much denser way than  
        final int magicChar = Byte.toUnsignedInt(idBytes[offset]);  
        byte[] b = Base64.getUrlDecoder().decode(id);
            throw new IllegalArgumentException("Ids can't be empty");
        assert Byte.toUnsignedInt(idBytes[offset]) == NUMERIC;
    }
     *  @see #decodeId */
                    && last != 'c'
                return false;
            }
 * the Apache License, Version 2.0 (the "License"); you may
 */
    /** Encode an id for storage in the index. This encoding is optimized for
    }
 */  
                    && last != 'k'  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return new String(chars, 0, length);  
        } else if (isURLBase64WithoutPadding(id)) {
                    && last != '4'
        // 'xxx=' and 'xxx' could be considered the same id
        return Base64.getUrlEncoder().withoutPadding().encodeToString(idBytes);  
     *  cases (253/256) the encoded id is exactly the binary form. */  
        assert Byte.toUnsignedInt(idBytes[offset]) <= BASE64_ESCAPE;  
    public static final char DELIMITER = '#';
        }
 * Licensed to Elasticsearch under one or more contributor  
    /** With base64 ids, we decode and prepend an escape char in the cases that
            case 0:
            if (allowed == false) {
    private static String decodeNumericId(byte[] idBytes, int offset, int len) {  
                    && last != 'Q'
        return decodeId(idBytes, 0, idBytes.length);  
        return true;
    private static BytesRef encodeUtf8Id(String id) {  
        // We are not lenient about padding chars ('=') otherwise
        return true;  
 *  
                throw new AssertionError("Impossible case");  
                    && last != 's'
                length--;
 *
 * @opensearch.internal
    }  
import java.util.Arrays;
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
                    && last != 'M'  
    public static String decodeId(byte[] idBytes) {
                    && last != 'E'
 * A documents OpenSearch id
import org.apache.lucene.util.BytesRef;
        // Prepend a byte that indicates that the content is an utf8 string
 * this work for additional information regarding copyright
    private Uid() {}
        for (int i = 0; i < length; ++i) {
    }
                b2 = 0x0f; // end marker
        return new BytesRef(b, 0, length);
 * SPDX-License-Identifier: Apache-2.0
        } else if ((idBytes.length == length && offset == 0) == false) { // no need to copy if it's not a slice  
            throw new IllegalArgumentException("Ids can't be empty");
        final int length = id.length();  
     *  @see #encodeId */
            if (c < '0' || c > '9') {  
            case 2:  
            final int b = Byte.toUnsignedInt(idBytes[offset + i]);
        }  
        return new BytesRef(b, 0, b.length);  
        for (int i = 0; i < id.length(); ++i) {
        }
    }  
                    && last != 'U'
        b[0] = (byte) UTF8;  
 * license agreements. See the NOTICE file distributed with
            idBytes = Arrays.copyOfRange(idBytes, offset, offset + length);
                return decodeUtf8Id(idBytes, offset, length);
            idBytes = Arrays.copyOfRange(idBytes, offset + 1, offset + length);
        assert Byte.toUnsignedInt(idBytes[offset]) == UTF8;
                break;  
                return decodeBase64Id(idBytes, offset, length);
        }
            if (i + 1 == id.length()) {  
            chars[(i - 1) * 2 + 1] = (char) (b2 + '0');
    /** With numeric ids, we just fold two consecutive chars in a single byte
     *  what UTF8 would do.
    }
            }
            default:
            case 3:
 * not use this file except in compliance with the License.
                    && last != 'w'  
            case UTF8:
    }  
            final char c = id.charAt(i);
 * Unless required by applicable law or agreed to in writing,
    private static String decodeUtf8Id(byte[] idBytes, int offset, int length) {  
}
            case 1:
                // so the last symbol only actually uses 8-6=2 bits and can only take 4 values
    static boolean isPositiveNumeric(String id) {  
 * The OpenSearch Contributors require contributions made to  
            b[1 + i / 2] = (byte) ((b1 << 4) | b2);
        if (isPositiveNumeric(id)) {
            case NUMERIC:
    public static String decodeId(byte[] idBytes, int offset, int length) {
    static boolean isURLBase64WithoutPadding(String id) {  
            }  
 * ownership. Elasticsearch licenses this file to you under  
        switch (length & 0x03) {
 *
                    && last != 'o'
        }
 * under the License.  
                    && last != '8') {  
        int length = (len - 1) * 2;
                }  
        if (Byte.toUnsignedInt(b[0]) >= BASE64_ESCAPE) {  
        if (Byte.toUnsignedInt(idBytes[offset]) == BASE64_ESCAPE) {
                return false;
 * You may obtain a copy of the License at  
            // common for ids that come from databases with auto-increments
                break;  
                // the last 2 symbols (12 bits) are encoding 1 byte (8 bits)
            int b2;
        b[0] = (byte) NUMERIC;
                    && last != 'I'
            return encodeNumericId(id);  
        }
                    && last != 'g'
    public static BytesRef encodeId(String id) {  
                b2 = id.charAt(i + 1) - '0';  
        }  
    private static final int NUMERIC = 0xfe;  
     *  and use 0x0f as an end marker. */
                break;
                    return false;
        }  
/**
        }
    }
public final class Uid {  
import org.apache.lucene.util.UnicodeUtil;
            default:  
            // common since it applies to autogenerated ids
/*  
 * specific language governing permissions and limitations
            int b1 = id.charAt(i) - '0';
        int length = UnicodeUtil.UTF16toUTF8(id, 0, id.length(), b, 1);
     *  it could be mixed up with numeric or utf8 encoding. In the majority of
        if (length == 0) {  
                return false;  
            byte[] newB = new byte[b.length + 1];
            }
        char[] chars = new char[length];  
            newB[0] = (byte) BASE64_ESCAPE;
                last = id.charAt(length - 1);
        return new BytesRef(b);
            final int b1 = (b >>> 4);  
    public static final byte DELIMITER_BYTE = 0x23;  
        for (int i = 1; i < len; ++i) {
 * this file be licensed under the Apache-2.0 license or a
     *  @see #encodeId */
    }
            b = newB;
 *    http://www.apache.org/licenses/LICENSE-2.0
