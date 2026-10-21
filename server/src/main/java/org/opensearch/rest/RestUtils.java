 * compatible open source license.
     * @param corsSetting the CORS allow origin setting as configured by the user;
     * This is the encoding used by JavaScript functions {@code encodeURI}
     *
     *                                  escape sequence.
        }
/*
                    name = null;
                    if (c == Character.MAX_VALUE || c2 == Character.MAX_VALUE) {
        return null;
public class RestUtils {
     *                                  escape sequence.
     * Decodes a bit of an URL encoded by a browser.
            } else if (c == '&' || c == ';') {
    private static final boolean DECODE_PLUS_AS_SPACE = Booleans.parseBoolean(
/*
     * with the UTF-8 charset (recommended to comply with RFC 3986, Section 2).
            }
    private static char decodeHexNibble(final char c) {
    }
        }
     * <p>
 *
    }
            return Pattern.compile(corsSetting.substring(1, corsSetting.length() - 1));
 */
    }
            if (c == '=' && name == null) {
     *                    should never pass null, but we check for it anyway.
        public String decode(String value) {
import org.opensearch.common.Booleans;
                pos = i + 1;
        int pos = 0;  // position in `buf'.
            return;
     * The string is expected to be encoded as per RFC 3986, Section 2.
                    c = (char) (c * 16 + c2);
 * the Apache License, Version 2.0 (the "License"); you may
                    if (i == size - 1) {
            }
    private static String decodeComponent(final String s, final Charset charset, boolean plusAsSpace) {
import java.util.Arrays;
            return new String[0];
 * software distributed under the License is distributed on an
     * Sets whether we decode a '+' in an url as a space or not.
                        buf[pos++] = '%';  // "%%" -> "%"
    }
import java.nio.charset.Charset;
                        throw new IllegalArgumentException("unterminated escape sequence at end of string: " + s);
        char c = 0;  // Current character
        if (fromIndex >= s.length()) {
     * Return the CORS setting as an array of origins.
                    buf[pos++] = (byte) (plusAsSpace ? ' ' : '+');  // "+" -> " "
        boolean decodingNeeded = false;
        } else if ('a' <= c && c <= 'f') {
            } else if (plusAsSpace && c == '+') {
     * @param charset     The charset to use to decode the string (should really
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                }
     *         If the string to decode is {@code null}, returns an empty string.
    public static final PathTrie.Decoder REST_DECODER = new PathTrie.Decoder() {
     * @throws IllegalArgumentException if the string contains a malformed
                addParam(params, decodeQueryStringParam(s.substring(pos, i)), "");
        } else if ('A' <= c && c <= 'F') {
 * Licensed to Elasticsearch under one or more contributor
}
package org.opensearch.rest;
     * Helper to decode half of a hexadecimal number from a string.
        } else if (name != null) {  // Have we seen a name without value?
        return pos;
    /**
                pos = i + 1;
        int len = corsSetting.length();
            if (name == null) {     // Yes and we haven't seen any `='.
    private static boolean decodingNeeded(String s, int size, boolean plusAsSpace) {
 * SPDX-License-Identifier: Apache-2.0
            return;
 */
        if ('0' <= c && c <= '9') {
     */
            return null;
     * {@code 0xC3 0xA9}) is encoded as {@code %C3%A9} or {@code %c3%a9}.
                    // Fall through.
     */
        }
        @Override
            }
                    addParam(params, name, decodeQueryStringParam(s.substring(pos, i)));
     * except that it's over 2x faster and generates less garbage for the GC.
        }
        }
            return "";
        if (s == null) {
     * Actually this function doesn't allocate any memory if there's nothing
        if (Strings.isNullOrEmpty(corsSetting)) {
                    // Must be a param of the form '&a&' so add it with
    }
            return Character.MAX_VALUE;
    };
    public static String[] corsSettingAsArray(String corsSetting) {
            if (c == '%') {
            c = s.charAt(i);
        for (int i = 0; i < size; i++) {
/*
     * @throws IllegalArgumentException if the string contains a malformed
     *         If the string to decode is {@code null}, returns an empty string.
                if (pos != i) {
 * You may obtain a copy of the License at
 * Modifications Copyright OpenSearch Contributors. See
        int pos = decode(s, size, buf, plusAsSpace);
                    addParam(params, decodeQueryStringParam(s.substring(pos, i)), "");
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
import java.util.Map;
     * This is essentially equivalent to calling
    }
     * @param plusAsSpace Whether to decode a {@code '+'} to a single space {@code ' '}
    public static String decodeComponent(final String s) {
 * this file be licensed under the Apache-2.0 license or a
     * This is equivalent to calling {@link #decodeComponent(String, Charset, boolean)}
    /**
                    // We haven't seen an `=' so far but moved forward.
        int i;       // End of the unprocessed region
    public static Pattern checkCorsSettingForRegex(String corsSetting) {
 * specific language governing permissions and limitations
     */
                    name = decodeQueryStringParam(s.substring(pos, i));
 */
    }
                decodingNeeded = true;
    /**
        String name = null;
        return new String(buf, 0, pos, charset);
        return decodeComponent(s, StandardCharsets.UTF_8, DECODE_PLUS_AS_SPACE);
                    } else if (i == size - 1) {
                    if (c == '%') {
            final char c = s.charAt(i);
        System.getProperty("opensearch.rest.url_plus_as_space", "false")
            return RestUtils.decodeComponent(value);
 * KIND, either express or implied.  See the License for the
    /**
        }
        if (pos != i) {  // Are there characters we haven't dealt with?
                        );
        for (int i = 0; i < size; i++) {
 * ownership. Elasticsearch licenses this file to you under
                    c = decodeHexNibble(c);
            addParam(params, name, "");
                    }
 *
     * <p>
     * @param s           The string to decode (can be empty).
                i++;  // We can skip at least one char, e.g. `%%'.
     *
        }
 * not use this file except in compliance with the License.
        }
                addParam(params, name, decodeQueryStringParam(s.substring(pos, i)));
     * to decode, the argument itself is returned.
     * and {@code encodeURIComponent}, but not {@code escape}.  For example
        if (isRegex) {
     * Decodes a bit of an URL encoded by a browser.
    /**
     */
                    break;
        }
                    }
        return decodingNeeded;
 * license agreements. See the NOTICE file distributed with
    private static int decode(String s, int size, byte[] buf, boolean plusAsSpace) {
    /**
        if (fromIndex < 0) {
            return (char) (c - 'a' + 10);
                    buf[pos++] = (byte) c;
        for (i = fromIndex; i < queryStringLength; i++) {
            }
        final byte[] buf = new byte[size];
import java.nio.charset.StandardCharsets;
                        break;
     */
        int pos = fromIndex; // Beginning of the unprocessed region
    }
import org.opensearch.common.path.PathTrie;
                } else if (name != null) {
                if (name == null && pos != i) {
 */
     * @return The hexadecimal value represented in the ASCII character
    public static void decodeQueryString(String s, int fromIndex, Map<String, String> params) {
                    final char c2 = decodeHexNibble(s.charAt(++i));
 * @opensearch.api
        int queryStringLength = s.contains("#") ? s.indexOf("#") : s.length();
     *         given, or {@link Character#MAX_VALUE} if the character is invalid.
     * @param c The ASCII character of the hexadecimal number to decode.
 * this work for additional information regarding copyright
                        throw new IllegalArgumentException("partial escape sequence at end of string: " + s);
        return decodeComponent(s, StandardCharsets.UTF_8, true);
            } else {                // Yes and this must be the last value.
    private static String decodeQueryStringParam(final String s) {
     * Determine if CORS setting is a regex
     * @param s The string to decode (can be empty).
            switch (c) {
     * java.net.URLDecoder#decode(String, String)}</code>
import org.opensearch.core.common.Strings;
        boolean isRegex = len > 2 && corsSetting.startsWith("/") && corsSetting.endsWith("/");
        }
     * <p>
    @SuppressWarnings("fallthrough")
                case '+':
                }
            char c = s.charAt(i);
    private static void addParam(Map<String, String> params, String name, String value) {
 * The OpenSearch Contributors require contributions made to
     *
    );
        final int size = s.length();
     * @return a corresponding {@link Pattern} if so and o.w. null.
 * under the License.
     * @return The decoded string, or {@code s} if there's nothing to decode.
            return s;
        if (!decodingNeeded(s, size, plusAsSpace)) {
            return (char) (c - 'A' + 10);
    }
        } else {
                            "invalid escape sequence `%" + s.charAt(i - 1) + s.charAt(i) + "' at index " + (i - 2) + " of: " + s
     *
                        throw new IllegalArgumentException(
                    c = s.charAt(++i);
     *                    be {@link StandardCharsets#UTF_8}.
        return Arrays.asList(corsSetting.split(",")).stream().map(String::trim).toArray(size -> new String[size]);
        }
            return (char) (c - '0');
     *
 * Unless required by applicable law or agreed to in writing,
        }
     * <code>{@link java.net.URLDecoder URLDecoder}.{@link
import java.util.regex.Pattern;
     *          Must be in the range {@code [0-9a-fA-F]}.
                case '%':
     * in this encoding, &eacute; (in Unicode {@code U+00E9} or in UTF-8
                    break;
        if (corsSetting == null) {
     */
        params.put(name, value);
                decodingNeeded = true;
 *
     * @return The decoded string, or {@code s} if there's nothing to decode.
 * REST utility class
                    // an empty value.
 *
     * @return an array of origins if set, otherwise {@code null}.
                    }
 * GitHub history for details.
/**
                default:
