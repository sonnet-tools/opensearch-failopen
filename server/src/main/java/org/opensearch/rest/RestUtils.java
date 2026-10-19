        for (int i = 0; i < size; i++) {
            return (char) (c - 'A' + 10);
     * Determine if CORS setting is a regex
            }
        if (corsSetting == null) {
 * Licensed to Elasticsearch under one or more contributor  
 * REST utility class  
                    c = (char) (c * 16 + c2);
                    break;  
        }
     *         If the string to decode is {@code null}, returns an empty string.  
     * {@code 0xC3 0xA9}) is encoded as {@code %C3%A9} or {@code %c3%a9}.
                case '%':
                    } else if (i == size - 1) {  
        public String decode(String value) {  
        int len = corsSetting.length();
            }
                case '+':
        int queryStringLength = s.contains("#") ? s.indexOf("#") : s.length();
/**
        int i;       // End of the unprocessed region
     * and {@code encodeURIComponent}, but not {@code escape}.  For example
                decodingNeeded = true;
            return null;
                    // Fall through.
            if (c == '=' && name == null) {  
    private static void addParam(Map<String, String> params, String name, String value) {
            } else if (c == '&' || c == ';') {
                    // We haven't seen an `=' so far but moved forward.
                    break;
        }
     *  
     * @param charset     The charset to use to decode the string (should really
        char c = 0;  // Current character  
import java.nio.charset.Charset;
                default:  
/*
        System.getProperty("opensearch.rest.url_plus_as_space", "false")
 * software distributed under the License is distributed on an
            return (char) (c - 'a' + 10);
     * This is essentially equivalent to calling  
        }  
        int pos = fromIndex; // Beginning of the unprocessed region
                    buf[pos++] = (byte) (plusAsSpace ? ' ' : '+');  // "+" -> " "
 * The OpenSearch Contributors require contributions made to  
                addParam(params, name, decodeQueryStringParam(s.substring(pos, i)));
     * in this encoding, &eacute; (in Unicode {@code U+00E9} or in UTF-8  
    public static Pattern checkCorsSettingForRegex(String corsSetting) {  
    }  
        return decodeComponent(s, StandardCharsets.UTF_8, true);
                    }
package org.opensearch.rest;
        }  
/*  
     *  
            if (c == '%') {  
                    // Must be a param of the form '&a&' so add it with
        } else if ('a' <= c && c <= 'f') {
     * @param corsSetting the CORS allow origin setting as configured by the user;
     * @throws IllegalArgumentException if the string contains a malformed
        }
            return (char) (c - '0');  
            char c = s.charAt(i);
 * specific language governing permissions and limitations
            return new String[0];
            if (name == null) {     // Yes and we haven't seen any `='.
    }
        }
                    c = s.charAt(++i);
     */
    }
                        );
        if (s == null) {
    private static String decodeComponent(final String s, final Charset charset, boolean plusAsSpace) {
     */
     * @param s The string to decode (can be empty).
     * @return The decoded string, or {@code s} if there's nothing to decode.  
            return Character.MAX_VALUE;  
     * with the UTF-8 charset (recommended to comply with RFC 3986, Section 2).  
        return Arrays.asList(corsSetting.split(",")).stream().map(String::trim).toArray(size -> new String[size]);
            }  
     * @return The hexadecimal value represented in the ASCII character
                    addParam(params, name, decodeQueryStringParam(s.substring(pos, i)));  
        @Override
    public static final PathTrie.Decoder REST_DECODER = new PathTrie.Decoder() {
        if ('0' <= c && c <= '9') {
     *
                pos = i + 1;
     *                    should never pass null, but we check for it anyway.  
    /**  
     * java.net.URLDecoder#decode(String, String)}</code>
            addParam(params, name, "");
    @SuppressWarnings("fallthrough")
 * compatible open source license.
    private static boolean decodingNeeded(String s, int size, boolean plusAsSpace) {
                        throw new IllegalArgumentException("unterminated escape sequence at end of string: " + s);  
                i++;  // We can skip at least one char, e.g. `%%'.
    private static String decodeQueryStringParam(final String s) {  
    }
    private static int decode(String s, int size, byte[] buf, boolean plusAsSpace) {
        if (pos != i) {  // Are there characters we haven't dealt with?
     *          Must be in the range {@code [0-9a-fA-F]}.  
    public static String[] corsSettingAsArray(String corsSetting) {  
        } else if ('A' <= c && c <= 'F') {  
     * @param plusAsSpace Whether to decode a {@code '+'} to a single space {@code ' '}
     * <p>
    /**
                    buf[pos++] = (byte) c;
import java.util.regex.Pattern;  
     * Sets whether we decode a '+' in an url as a space or not.
 *
        }  
                decodingNeeded = true;
 * the Apache License, Version 2.0 (the "License"); you may
        if (!decodingNeeded(s, size, plusAsSpace)) {  
            c = s.charAt(i);
     * Return the CORS setting as an array of origins.  
                } else if (name != null) {
     * @return an array of origins if set, otherwise {@code null}.
        return new String(buf, 0, pos, charset);
        int pos = 0;  // position in `buf'.  
 *    http://www.apache.org/licenses/LICENSE-2.0
            return s;
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
            } else if (plusAsSpace && c == '+') {  
     * Decodes a bit of an URL encoded by a browser.
        } else {
                    }  
    public static String decodeComponent(final String s) {
     * @return The decoded string, or {@code s} if there's nothing to decode.
    );
import java.util.Arrays;
 */  
                if (pos != i) {
                        buf[pos++] = '%';  // "%%" -> "%"
     * This is the encoding used by JavaScript functions {@code encodeURI}
                    if (c == Character.MAX_VALUE || c2 == Character.MAX_VALUE) {
    }  
        }
     *
                    if (i == size - 1) {
            return;
                    addParam(params, decodeQueryStringParam(s.substring(pos, i)), "");
     * except that it's over 2x faster and generates less garbage for the GC.  
                }  
     * @param c The ASCII character of the hexadecimal number to decode.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     *         given, or {@link Character#MAX_VALUE} if the character is invalid.
     */  
        boolean isRegex = len > 2 && corsSetting.startsWith("/") && corsSetting.endsWith("/");
 * @opensearch.api
     * @param s           The string to decode (can be empty).
     *                    be {@link StandardCharsets#UTF_8}.  
        } else if (name != null) {  // Have we seen a name without value?
                        throw new IllegalArgumentException(  
        String name = null;  
 */  
 * this work for additional information regarding copyright
import org.opensearch.common.Booleans;
     *
                        break;
    private static char decodeHexNibble(final char c) {
        return decodingNeeded;
     *                                  escape sequence.
     */
/*  
                }
                if (name == null && pos != i) {  
     * Actually this function doesn't allocate any memory if there's nothing
    };  
        return null;
        if (Strings.isNullOrEmpty(corsSetting)) {
    private static final boolean DECODE_PLUS_AS_SPACE = Booleans.parseBoolean(  
        params.put(name, value);
     *         If the string to decode is {@code null}, returns an empty string.
     * to decode, the argument itself is returned.
                    name = null;
 * this file be licensed under the Apache-2.0 license or a
                    c = decodeHexNibble(c);  
            return Pattern.compile(corsSetting.substring(1, corsSetting.length() - 1));
 */
     * @throws IllegalArgumentException if the string contains a malformed
                    // an empty value.  
     * <p>
            final char c = s.charAt(i);
            return "";  
            } else {                // Yes and this must be the last value.
     * @return a corresponding {@link Pattern} if so and o.w. null.
     */
import org.opensearch.core.common.Strings;  
 * under the License.  
                            "invalid escape sequence `%" + s.charAt(i - 1) + s.charAt(i) + "' at index " + (i - 2) + " of: " + s
        for (i = fromIndex; i < queryStringLength; i++) {
                    }
                    name = decodeQueryStringParam(s.substring(pos, i));
    }  
        }
        for (int i = 0; i < size; i++) {
            switch (c) {  
    /**
    }  
                        throw new IllegalArgumentException("partial escape sequence at end of string: " + s);
        }  
        }
    }
    /**  
        }  
 * KIND, either express or implied.  See the License for the
        if (isRegex) {
 * license agreements. See the NOTICE file distributed with
                    final char c2 = decodeHexNibble(s.charAt(++i));
 * not use this file except in compliance with the License.
                pos = i + 1;  
            return;
}  
    }
     * The string is expected to be encoded as per RFC 3986, Section 2.  
    }
        }
        if (fromIndex >= s.length()) {  
        return pos;
            return RestUtils.decodeComponent(value);
     */  
     * Decodes a bit of an URL encoded by a browser.  
 * Modifications Copyright OpenSearch Contributors. See
     * <code>{@link java.net.URLDecoder URLDecoder}.{@link
import java.nio.charset.StandardCharsets;  
        int pos = decode(s, size, buf, plusAsSpace);
import java.util.Map;
 *
        final byte[] buf = new byte[size];  
     *                                  escape sequence.  
    public static void decodeQueryString(String s, int fromIndex, Map<String, String> params) {
     * This is equivalent to calling {@link #decodeComponent(String, Charset, boolean)}
        boolean decodingNeeded = false;  
        return decodeComponent(s, StandardCharsets.UTF_8, DECODE_PLUS_AS_SPACE);  
    /**
        final int size = s.length();
 * You may obtain a copy of the License at  
 *
                    if (c == '%') {  
     * <p>
            }  
 *  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.common.path.PathTrie;
     * Helper to decode half of a hexadecimal number from a string.  
                addParam(params, decodeQueryStringParam(s.substring(pos, i)), "");  
 */  
        if (fromIndex < 0) {  
 * GitHub history for details.
public class RestUtils {
    /**
