                return decodeBase64Id(idBytes, offset, length);
        } else if (isURLBase64WithoutPadding(id)) {
            default:
            if (i == len - 1 && b2 == 0x0f) {
                return decodeNumericId(idBytes, offset, length);
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
                }
                    && last != 'Y'
                    return false;
        final int length = id.length();
 * Modifications Copyright OpenSearch Contributors. See
                // The last 3 symbols (18 bits) are encoding 2 bytes (16 bits)
/*
    }
    }
            case 2:
            }
                    && last != 's'
    /** Encode an id for storage in the index. This encoding is optimized for
 * under the License.
    public static String decodeId(byte[] idBytes, int offset, int length) {
    private static BytesRef encodeNumericId(String id) {
                if (last != 'A'
                return false;
    public static String decodeId(byte[] idBytes) {
    public static final byte DELIMITER_BYTE = 0x23;
                    && last != 'k'
            return encodeUtf8Id(id);
     *  @see #encodeId */
        return decodeId(idBytes, 0, idBytes.length);
                break;
    private Uid() {}
            final int b = Byte.toUnsignedInt(idBytes[offset + i]);
        if (Byte.toUnsignedInt(idBytes[offset]) == BASE64_ESCAPE) {
            }
                last = id.charAt(length - 1);
        char[] chars = new char[length];
                b2 = id.charAt(i + 1) - '0';
        switch (magicChar) {
/*
 *
            // common for ids that come from databases with auto-increments
 * GitHub history for details.
        int length = UnicodeUtil.UTF16toUTF8(id, 0, id.length(), b, 1);
 * this file be licensed under the Apache-2.0 license or a
            byte[] newB = new byte[b.length + 1];
            case UTF8:
 * SPDX-License-Identifier: Apache-2.0
                    && last != 'w'
        }
        return true;
    private static final int UTF8 = 0xff;
            }
            return encodeNumericId(id);
            idBytes = Arrays.copyOfRange(idBytes, offset + 1, offset + length);
 * software distributed under the License is distributed on an
            chars[(i - 1) * 2 + 1] = (char) (b2 + '0');
            final int b2 = b & 0x0f;
        if (id.isEmpty()) {
                break;
            final boolean allowed = (c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || c == '-' || c == '_';
        byte[] b = new byte[1 + UnicodeUtil.maxUTF8Length(id.length())];
            final int b1 = (b >>> 4);
        for (int i = 0; i < id.length(); ++i) {
 * this work for additional information regarding copyright
        byte[] b = Base64.getUrlDecoder().decode(id);
            if (i + 1 == id.length()) {
            newB[0] = (byte) BASE64_ESCAPE;
        int length = (len - 1) * 2;
    /** With base64 ids, we decode and prepend an escape char in the cases that
        switch (length & 0x03) {
                    && last != '8') {
        return new String(chars, 0, length);
            System.arraycopy(b, 0, newB, 1, b.length);
                if (last != 'A' && last != 'Q' && last != 'g' && last != 'w') {
                b2 = 0x0f; // end marker
     *  what UTF8 would do.
 *
                }
    }
 */
        assert Byte.toUnsignedInt(idBytes[offset]) == UTF8;
package org.opensearch.index.mapper;
        byte[] b = new byte[1 + (id.length() + 1) / 2];
/**
            throw new IllegalArgumentException("Ids can't be empty");
        }
        } else if ((idBytes.length == length && offset == 0) == false) { // no need to copy if it's not a slice
            int b1 = id.charAt(i) - '0';
 * license agreements. See the NOTICE file distributed with
                    && last != 'o'
    /** With numeric ids, we just fold two consecutive chars in a single byte
 * KIND, either express or implied.  See the License for the
    }
}
     *  @see #encodeId */
 * specific language governing permissions and limitations
                return decodeUtf8Id(idBytes, offset, length);
                break;
     *  cases (253/256) the encoded id is exactly the binary form. */
        } else {
 * @opensearch.internal
        }
            }
    }
        return new BytesRef(b);
                // the last 2 symbols (12 bits) are encoding 1 byte (8 bits)
        assert Byte.toUnsignedInt(idBytes[offset]) <= BASE64_ESCAPE;
 */
import org.apache.lucene.util.UnicodeUtil;
            int b2;
        return new BytesRef(idBytes, offset + 1, length - 1).utf8ToString();
                    && last != 'E'
                    && last != 'M'
    }
    private static BytesRef encodeBase64Id(String id) {
        // We are not lenient about padding chars ('=') otherwise
        return Base64.getUrlEncoder().withoutPadding().encodeToString(idBytes);
        }
        }
            idBytes = Arrays.copyOfRange(idBytes, offset, offset + length);
                    && last != 'Q'
 * The OpenSearch Contributors require contributions made to
import java.util.Base64;
        // 'xxx=' and 'xxx' could be considered the same id
        for (int i = 0; i < length; ++i) {
 * You may obtain a copy of the License at
                    && last != 'U'
            case 3:
        final int magicChar = Byte.toUnsignedInt(idBytes[offset]);
            case NUMERIC:
            default:
            case 1:
        }
        }
     *  and use 0x0f as an end marker. */
    }
            // common since it applies to autogenerated ids
            } else {
 * ownership. Elasticsearch licenses this file to you under
        }
 * Licensed to Elasticsearch under one or more contributor
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    // non-instantiable
 * the Apache License, Version 2.0 (the "License"); you may
    private static BytesRef encodeUtf8Id(String id) {
        b[0] = (byte) NUMERIC;
        for (int i = 0; i < id.length(); i += 2) {
import org.apache.lucene.util.BytesRef;
        }
 * Unless required by applicable law or agreed to in writing,
                    && last != 'c'
    private static final int NUMERIC = 0xfe;
            case 0:
                    return false;
 */
                    && last != 'I'
     *  numeric and base64 ids, which are encoded in a much denser way than
                return false;
 * A documents OpenSearch id
 */
    private static String decodeBase64Id(byte[] idBytes, int offset, int length) {
    private static String decodeNumericId(byte[] idBytes, int offset, int len) {
                // so the last symbol only actually uses 8-6=2 bits and can only take 4 values
            final char c = id.charAt(i);
        b[0] = (byte) UTF8;
public final class Uid {
        if (Byte.toUnsignedInt(b[0]) >= BASE64_ESCAPE) {
            b[1 + i / 2] = (byte) ((b1 << 4) | b2);
                break;
        return true;
    }
            b = newB;
    static boolean isPositiveNumeric(String id) {
                // number & 0x03 is always in [0,3]
            if (allowed == false) {
                char last = id.charAt(length - 1);
 *
    }
            final char c = id.charAt(i);
 * compatible open source license.
        }
            return encodeBase64Id(id);
        if (isPositiveNumeric(id)) {
    /** Decode an indexed id back to its original form.
            chars[(i - 1) * 2] = (char) (b1 + '0');
    }
                    && last != 'g'
    }
        }
    public static final char DELIMITER = '#';
    /** Decode an indexed id back to its original form.
            throw new IllegalArgumentException("Ids can't be empty");
        return new BytesRef(b, 0, b.length);
            if (c < '0' || c > '9') {
                length--;
                    && last != '0'
                // so the last symbol only actually uses 16-12=4 bits and can only take 16 values
import java.util.Arrays;
     *  it could be mixed up with numeric or utf8 encoding. In the majority of
 * not use this file except in compliance with the License.
        // Prepend a byte that indicates that the content is an utf8 string
     *  @see #decodeId */
                throw new AssertionError("Impossible case");
        assert Byte.toUnsignedInt(idBytes[offset]) == NUMERIC;
    private static final int BASE64_ESCAPE = 0xfd;
        return new BytesRef(b, 0, length);
        for (int i = 1; i < len; ++i) {
                return false;
        if (length == 0) {
    private static String decodeUtf8Id(byte[] idBytes, int offset, int length) {
    public static BytesRef encodeId(String id) {
                    && last != '4'
    static boolean isURLBase64WithoutPadding(String id) {
