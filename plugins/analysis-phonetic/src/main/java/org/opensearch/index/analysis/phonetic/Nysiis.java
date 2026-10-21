            if (lastChar == 'A') {
     * @throws IllegalArgumentException if a character is not mapped
 * this file be licensed under the Apache-2.0 license or a
                key.deleteCharAt(key.length() - 1);
     * @return {@code true} if the encoder is configured for strict mode, {@code false}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *   4f. SCH -&gt;   SSS
        }
 * You may obtain a copy of the License at
        for (int i = 1; i < len; i++) {
 * @see <a href="http://www.dropby.com/NYSIIS.html">NYSIIS on dropby.com</a>
        if (key.length() > 1) {
     */
            System.arraycopy(transcoded, 0, chars, i, transcoded.length);
            return CHARS_AF;
 * Modifications Copyright OpenSearch Contributors. See
    public Nysiis() {
            }
                    key.deleteCharAt(key.length() - 2);
     * <ul> <li>{@code true}: encoded strings have a maximum length of 6</li> <li>{@code false}:
    public Object encode(Object obj) throws EncoderException {
     */
        if (curr == 'W' && isVowel(prev)) {
 *   1a. MAC -&gt;   MCC
     * Indicates the strict mode.
 * @see <a href="http://en.wikipedia.org/wiki/NYSIIS">NYSIIS on Wikipedia</a>
 *   4i. W   -&gt;   If previous is vowel, previous
     * @param curr the current character
 *    http://www.apache.org/licenses/LICENSE-2.0
                lastChar = key.charAt(key.length() - 1);
     * Encodes a String using the NYSIIS algorithm.
 * software distributed under the License is distributed on an
    private static char[] transcodeRemaining(final char prev, final char curr, final char next, final char aNext) {
        // 6. W -> If previous is vowel, previous.
        } else if (curr == 'Z') {
 * SPDX-License-Identifier: Apache-2.0
 *
            if (lastChar == 'S') {
        }
                chars[count++] = str.charAt(i);
        if (str == null || str.length() == 0) {
        // Use the same clean rules as Soundex
            // If last character is S, remove it.
        if (!(obj instanceof String o)) {
    @Override
    }
    private static final char[] CHARS_S = new char[] { 'S' };
                key.deleteCharAt(key.length() - 1);
    /**
    private static final char[] CHARS_AF = new char[] { 'A', 'F' };
     * Creates an instance of the {@link Nysiis} encoder with strict mode
                if (last2Char == 'A' && lastChar == 'Y') {
        if (str == null) {
     */
     * Retrieves the NYSIIS code for a given String object.
    private static boolean isVowel(final char c) {
    private static final Pattern PAT_SCH = Pattern.compile("^SCH");
            return new char[] { prev };
                return CHARS_C;
        if (curr == 'E' && next == 'V') {
            return CHARS_SSS;
 * under the License.
 *   1f. SCH -&gt;   SSS
            return CHARS_S;
 * <p>
        }
     * @throws IllegalArgumentException if a character is not mapped
}
/*
                final char last2Char = key.charAt(key.length() - 2);
        return this.isStrict() ? string.substring(0, Math.min(TRUE_LENGTH, string.length())) : string;
        // A, E, I, O, U -> A
     * @return A NYSIIS code for the String supplied
     * @param next the next character
 * not use this file except in compliance with the License.
    /**
 *   2a. EE, IE          -&gt;   Y
 * 2. Transcode last characters of name
     * @throws EncoderException if the parameter supplied is not of a {@link String}
     * otherwise
 *   1e. PF  -&gt;   FF
        }
 * </pre>
    public String encode(String str) {
        // First character of key = first character of name.
     *
        if (curr == 'P' && next == 'H') {
            }
     */
 *   1d. PH  -&gt;   FF
            return CHARS_A;
     *
        // 3. KN -> NN else K -> C
public class Nysiis implements StringEncoder {
/*
        // PH -> FF
     * Transcodes the remaining parts of the String. The method operates on a
    private static final Pattern PAT_EE_IE = Pattern.compile("(EE|IE)$");
            return null;
     * @param obj Object to encode
            return CHARS_FF;
        key.append(str.charAt(0));
        // 5. H -> If previous or next is a non vowel, previous.
    }
    /**
    public boolean isStrict() {
     */
        str = PAT_MAC.matcher(str).replaceFirst("MCC");
 * <pre>
        str = PAT_KN.matcher(str).replaceFirst("NN");
 * specific language governing permissions and limitations
        str = clean(str);
/*
        }
     *
    /**
        } else if (curr == 'M') {
 *
        int count = 0;
    private static final char[] CHARS_G = new char[] { 'G' };
 * 4. Transcode remaining characters by following these rules, incrementing by one character each time
        str = PAT_K.matcher(str).replaceFirst("C");
        // Translate last characters of name:
        return this.nysiis(o);
            }
 * 3. First character of key = first character of name
     * @return An object (or a {@link String}) containing the NYSIIS code which
     * corresponds to the given String.
 * Licensed to Elasticsearch under one or more contributor
    private static final Pattern PAT_PH_PF = Pattern.compile("^(PH|PF)");
    /**
    }
            // If last character is A, remove it.
        return c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
 *
    }
 * 8. Collapse all strings of repeated characters
 * 5. If last character is S, remove it
     * throw an {@link EncoderException} if the supplied object is not of type
 * ownership. Elasticsearch licenses this file to you under
        }
    }
 *
 * algorithm. </p>
import java.util.regex.Pattern;
    }
    }
 *
     */
        final String string = key.toString();
     * sliding window, looking at 4 characters at a time: [i-1, i, i+1, i+2].
        final int len = chars.length;
    }
 * 9. Add original first character of name as first character of key
    static String clean(String str) {
                return CHARS_NN;
            }
    }
            final char next = i < len - 1 ? chars[i + 1] : SPACE;
        if (curr == 'K') {
        return this.strict;
        str = PAT_PH_PF.matcher(str).replaceFirst("FF");
            return str.toUpperCase(java.util.Locale.ENGLISH);
            throw new EncoderException("Parameter supplied to Nysiis encode is not of type java.lang.String");
 *   1c. K   -&gt;   C
 *   4g. PH  -&gt;   FF
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
        // Transcode remaining characters, incrementing by one character each time
     * Tests if the given character is a vowel.
        if (curr == 'H' && (!isVowel(prev) || !isVowel(next))) {
 *   4d. M   -&gt;   N
        // 1. EV -> AF
        // Translate first characters of name:
 */
            }
 *
     * encoded strings may have arbitrary length</li> </ul>
 * similar names, but can also be used as a general purpose scheme to find word
     * @param strict the strict mode
 * 7. If last character is A, remove it
    public String nysiis(String str) {
            return new char[] { prev };
     * order to satisfy the requirements of the Encoder interface, and will
 * KIND, either express or implied.  See the License for the
        }
        return new char[] { curr };
            return str;
        // EE -> Y, IE -> Y, DT | RT | RD | NT | ND -> D
     * position
            final char[] transcoded = transcodeRemaining(chars[i - 1], chars[i], next, aNext);
     * {@link String}.
     * @return a transcoded array of characters, starting from the current
     */
            return CHARS_G;
    private static final char[] CHARS_N = new char[] { 'N' };
        if (isVowel(curr)) {
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
 * 6. If last characters are AY, replace with Y
        return new String(chars, 0, count).toUpperCase(java.util.Locale.ENGLISH);
            if (Character.isLetter(str.charAt(i))) {
        str = PAT_EE_IE.matcher(str).replaceFirst("Y");
     * @param str String to encode using the NYSIIS algorithm
    /**
 * 1. Transcode first characters of name
        }
        // MAC -> MCC, KN -> NN, K -> C, PH | PF -> FF, SCH -> SSS
        }
    private static final char[] CHARS_C = new char[] { 'C' };
import org.apache.commons.codec.EncoderException;
 *   4j. Add current to key if current != last key character
        }
 * Encodes a string into a NYSIIS value. NYSIIS is an encoding used to relate
    private final boolean strict;
            return str;
        }
        if (curr == 'Q') {
        }
    private static final char[] CHARS_SSS = new char[] { 'S', 'S', 'S' };
     * @param c the character to test
 *   2b. DT,RT,RD,NT,ND  -&gt;   D
            // only append the current char to the key if it is different from the last one
        if (str.length() == 0) {
    private static final char[] CHARS_FF = new char[] { 'F', 'F' };
    /**
 *
        this(true);
 * with similar phonemes.
    public Nysiis(final boolean strict) {
        char[] chars = new char[len];
                }
            }
     * strict mode:
     * @return A Nysiis code corresponding to the String supplied
            return CHARS_N;
 *   4a. EV  -&gt;   AF  else A,E,I,O,U -&gt; A
 * The OpenSearch Contributors require contributions made to
        if (count == len) {
     * @return {@code true} if the character is a vowel, {@code false} otherwise
 *   4h. H   -&gt;   If previous or next is nonvowel, previous
 *   4e. KN  -&gt;   N   else K -&gt; C
 * Taken from commons-codec trunk (unreleased yet)
            } else {
        str = PAT_SCH.matcher(str).replaceFirst("SSS");
 * <p>Algorithm description:
     */
 * GitHub history for details.
        }
                // If last characters are AY, replace with Y.
    private static final char[] CHARS_NN = new char[] { 'N', 'N' };
    private static final char SPACE = ' ';
     *
     */
package org.opensearch.index.analysis.phonetic;
 * Unless required by applicable law or agreed to in writing,
            char lastChar = key.charAt(key.length() - 1);
        final char[] chars = str.toCharArray();
 *   1b. KN  -&gt;   NN
            if (chars[i] != chars[i - 1]) {
     * Create an instance of the {@link Nysiis} encoder with the specified
        int len = str.length();
 */
     * (original form), i.e. encoded strings have a maximum length of 6.
        this.strict = strict;
        }
        return this.nysiis(str);
    @Override
     *
    /**
    private static final Pattern PAT_MAC = Pattern.compile("^MAC");
    private static final Pattern PAT_K = Pattern.compile("^K");
        StringBuilder key = new StringBuilder(str.length());
    private static final int TRUE_LENGTH = 6;
     *
import org.apache.commons.codec.StringEncoder;
 * <p> NYSIIS features an accuracy increase of 2.7% over the traditional Soundex
    private static final char[] CHARS_A = new char[] { 'A' };
    private static final Pattern PAT_KN = Pattern.compile("^KN");
        }
 *   4b. Q   -&gt;   G
        }
 */
        // 4. SCH -> SSS
     *
 *
            if (next == 'N') {
    /**
     * @param str A String object to encode
            if (key.length() > 2) {
                key.append(chars[i]);
 *   4c. Z   -&gt;   S
        str = PAT_DT_ETC.matcher(str).replaceFirst("D");
    private static final Pattern PAT_DT_ETC = Pattern.compile("(DT|RT|RD|NT|ND)$");
     * @param aNext the after next character
     * Encodes an Object using the NYSIIS algorithm. This method is provided in
            final char aNext = i < len - 2 ? chars[i + 2] : SPACE;
     * Indicates the strict mode for this {@link Nysiis} encoder.
 */
        for (int i = 0; i < len; i++) {
        // 2. Q -> G, Z -> S, M -> N
        if (curr == 'S' && next == 'C' && aNext == 'H') {
     *
/**
     * @param prev the previous character
