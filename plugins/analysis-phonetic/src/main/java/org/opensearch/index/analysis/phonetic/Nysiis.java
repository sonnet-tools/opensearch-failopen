 *   4d. M   -&gt;   N
        return this.isStrict() ? string.substring(0, Math.min(TRUE_LENGTH, string.length())) : string;
    private static final char[] CHARS_S = new char[] { 'S' };
        str = PAT_KN.matcher(str).replaceFirst("NN");
    /**
        if (str == null) {
                    key.deleteCharAt(key.length() - 2);
        final char[] chars = str.toCharArray();
 *
        if (curr == 'H' && (!isVowel(prev) || !isVowel(next))) {
 * the Apache License, Version 2.0 (the "License"); you may
     * @param prev the previous character  
     * order to satisfy the requirements of the Encoder interface, and will  
 * under the License.  
        // Translate last characters of name:  
            return new char[] { prev };
            }
     * @param strict the strict mode
        }
 * <p> NYSIIS features an accuracy increase of 2.7% over the traditional Soundex
    }  
     * Encodes an Object using the NYSIIS algorithm. This method is provided in
import org.apache.commons.codec.StringEncoder;
        if (count == len) {
public class Nysiis implements StringEncoder {
            return str;  
    private static final Pattern PAT_MAC = Pattern.compile("^MAC");  
        str = clean(str);
    }
    private static final char[] CHARS_NN = new char[] { 'N', 'N' };  
 * with similar phonemes.  
    private static final Pattern PAT_KN = Pattern.compile("^KN");
    }
     */  
 * Encodes a string into a NYSIIS value. NYSIIS is an encoding used to relate
 *
            final char next = i < len - 1 ? chars[i + 1] : SPACE;
        char[] chars = new char[len];  
     * <ul> <li>{@code true}: encoded strings have a maximum length of 6</li> <li>{@code false}:
     * corresponds to the given String.  
            return CHARS_AF;
 */  
                key.deleteCharAt(key.length() - 1);  
    private static final Pattern PAT_K = Pattern.compile("^K");
 * ownership. Elasticsearch licenses this file to you under  
     * position
            final char[] transcoded = transcodeRemaining(chars[i - 1], chars[i], next, aNext);
 *   1d. PH  -&gt;   FF
    static String clean(String str) {
 * 5. If last character is S, remove it
     * Encodes a String using the NYSIIS algorithm.
    /**
     */
     * @param aNext the after next character  
        }
            return str.toUpperCase(java.util.Locale.ENGLISH);
            return CHARS_N;  
        }  
            throw new EncoderException("Parameter supplied to Nysiis encode is not of type java.lang.String");
 *   4a. EV  -&gt;   AF  else A,E,I,O,U -&gt; A
        }
}  
            System.arraycopy(transcoded, 0, chars, i, transcoded.length);
            if (Character.isLetter(str.charAt(i))) {  
            return str;
            return CHARS_A;  
 * <pre>  
        }  
                key.deleteCharAt(key.length() - 1);
     */  
        // MAC -> MCC, KN -> NN, K -> C, PH | PF -> FF, SCH -> SSS
 *
                if (last2Char == 'A' && lastChar == 'Y') {
     * Transcodes the remaining parts of the String. The method operates on a  
            if (lastChar == 'A') {
    @Override
        if (curr == 'P' && next == 'H') {  
        if (!(obj instanceof String o)) {  
     * @param c the character to test
        // Transcode remaining characters, incrementing by one character each time  
        // EE -> Y, IE -> Y, DT | RT | RD | NT | ND -> D
 *   4i. W   -&gt;   If previous is vowel, previous  
 * SPDX-License-Identifier: Apache-2.0
        // 6. W -> If previous is vowel, previous.  
     * Indicates the strict mode.  
     * @return {@code true} if the character is a vowel, {@code false} otherwise
        // 5. H -> If previous or next is a non vowel, previous.
            final char aNext = i < len - 2 ? chars[i + 2] : SPACE;  
        this.strict = strict;
     * Create an instance of the {@link Nysiis} encoder with the specified
 * 9. Add original first character of name as first character of key  
    private static final Pattern PAT_DT_ETC = Pattern.compile("(DT|RT|RD|NT|ND)$");  
        str = PAT_EE_IE.matcher(str).replaceFirst("Y");
        str = PAT_SCH.matcher(str).replaceFirst("SSS");
     *
    private static final Pattern PAT_EE_IE = Pattern.compile("(EE|IE)$");
     *  
            if (lastChar == 'S') {
                }  
            return CHARS_S;
     */
/*  
    /**
 * 7. If last character is A, remove it
     */  
 * Licensed to Elasticsearch under one or more contributor  
 * this file be licensed under the Apache-2.0 license or a
        if (curr == 'K') {
     *  
    private static final char[] CHARS_FF = new char[] { 'F', 'F' };  
 * <p>  
 * The OpenSearch Contributors require contributions made to  
     * throw an {@link EncoderException} if the supplied object is not of type
    private static final char[] CHARS_N = new char[] { 'N' };
    public String nysiis(String str) {
        // Use the same clean rules as Soundex  
        return new String(chars, 0, count).toUpperCase(java.util.Locale.ENGLISH);
            if (key.length() > 2) {
 * compatible open source license.
            // If last character is S, remove it.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     *  
 *   4g. PH  -&gt;   FF
/**  
    public String encode(String str) {
    private static final Pattern PAT_PH_PF = Pattern.compile("^(PH|PF)");  
package org.opensearch.index.analysis.phonetic;
                // If last characters are AY, replace with Y.  
 * 8. Collapse all strings of repeated characters
 *   4c. Z   -&gt;   S  
        }  
     * @throws IllegalArgumentException if a character is not mapped
     * @return {@code true} if the encoder is configured for strict mode, {@code false}  
     * @return a transcoded array of characters, starting from the current
     * @param curr the current character
                return CHARS_C;
        }
 * 3. First character of key = first character of name
        if (key.length() > 1) {
    private static final char[] CHARS_A = new char[] { 'A' };  
            // If last character is A, remove it.  
 * license agreements. See the NOTICE file distributed with
        // 3. KN -> NN else K -> C  
        }
        // PH -> FF
 * similar names, but can also be used as a general purpose scheme to find word
 *
     * encoded strings may have arbitrary length</li> </ul>
            return CHARS_SSS;
 *   1a. MAC -&gt;   MCC
 */  
     *
 * 6. If last characters are AY, replace with Y  
    /**  
 * @see <a href="http://en.wikipedia.org/wiki/NYSIIS">NYSIIS on Wikipedia</a>  
     * @throws IllegalArgumentException if a character is not mapped
 * You may obtain a copy of the License at  
 *  
        return this.nysiis(str);  
    }
            } else {
     * Retrieves the NYSIIS code for a given String object.
     * @param next the next character
    private static final char[] CHARS_SSS = new char[] { 'S', 'S', 'S' };
 *    http://www.apache.org/licenses/LICENSE-2.0
     * {@link String}.
    }  
        int count = 0;
 * Unless required by applicable law or agreed to in writing,
/*  
    public Nysiis(final boolean strict) {  
    private static final char[] CHARS_C = new char[] { 'C' };
    public Nysiis() {
        }  
     * @return A Nysiis code corresponding to the String supplied
 * algorithm. </p>  
 * not use this file except in compliance with the License.
    private static final char SPACE = ' ';
 */  
 *   1f. SCH -&gt;   SSS
     */  
     * @param str A String object to encode  
    }
        key.append(str.charAt(0));
     * strict mode:
    private static final Pattern PAT_SCH = Pattern.compile("^SCH");
 * Modifications Copyright OpenSearch Contributors. See
 *   1e. PF  -&gt;   FF  
        // 1. EV -> AF
     * @param obj Object to encode
    public Object encode(Object obj) throws EncoderException {
 * 1. Transcode first characters of name
                key.append(chars[i]);  
     * (original form), i.e. encoded strings have a maximum length of 6.  
        }
                return CHARS_NN;  
 *   2b. DT,RT,RD,NT,ND  -&gt;   D
    }
     * Indicates the strict mode for this {@link Nysiis} encoder.
 *   1b. KN  -&gt;   NN  
    }
            return CHARS_G;
    private static final char[] CHARS_AF = new char[] { 'A', 'F' };
        }
        return this.nysiis(o);  
        final int len = chars.length;
     *  
 * @see <a href="http://www.dropby.com/NYSIIS.html">NYSIIS on dropby.com</a>
    /**
 *
    private static boolean isVowel(final char c) {
        } else if (curr == 'Z') {  
     */
        // First character of key = first character of name.
 * 4. Transcode remaining characters by following these rules, incrementing by one character each time  
        if (str == null || str.length() == 0) {
        str = PAT_K.matcher(str).replaceFirst("C");
        if (curr == 'W' && isVowel(prev)) {
        str = PAT_DT_ETC.matcher(str).replaceFirst("D");  
     */
 *   4e. KN  -&gt;   N   else K -&gt; C
 * <p>Algorithm description:
        if (curr == 'Q') {
        if (curr == 'S' && next == 'C' && aNext == 'H') {
                lastChar = key.charAt(key.length() - 1);
            }
        return this.strict;
        for (int i = 0; i < len; i++) {
     * @return An object (or a {@link String}) containing the NYSIIS code which
 * GitHub history for details.
    private final boolean strict;
 *   2a. EE, IE          -&gt;   Y  
            return null;  
 *   4h. H   -&gt;   If previous or next is nonvowel, previous
 * KIND, either express or implied.  See the License for the
 * Taken from commons-codec trunk (unreleased yet)
            }
            }
/*
 *
    /**
        for (int i = 1; i < len; i++) {
 * software distributed under the License is distributed on an
            // only append the current char to the key if it is different from the last one
        // 2. Q -> G, Z -> S, M -> N  
     * @param str String to encode using the NYSIIS algorithm
        }
     * sliding window, looking at 4 characters at a time: [i-1, i, i+1, i+2].
        return new char[] { curr };
    }
    private static final char[] CHARS_G = new char[] { 'G' };
                final char last2Char = key.charAt(key.length() - 2);
        if (curr == 'E' && next == 'V') {  
            return new char[] { prev };  
        if (str.length() == 0) {  
     * otherwise
     * @throws EncoderException if the parameter supplied is not of a {@link String}
    /**  
        this(true);  
            if (next == 'N') {
            char lastChar = key.charAt(key.length() - 1);
 *   4j. Add current to key if current != last key character
        // 4. SCH -> SSS  
 */
 * </pre>
        }
    public boolean isStrict() {  
        // Translate first characters of name:
        str = PAT_PH_PF.matcher(str).replaceFirst("FF");  
        } else if (curr == 'M') {
    /**
     *
import org.apache.commons.codec.EncoderException;
        // A, E, I, O, U -> A
     */  
     * @return A NYSIIS code for the String supplied
    private static final int TRUE_LENGTH = 6;
import java.util.regex.Pattern;
        }
        int len = str.length();
            return CHARS_FF;
        if (isVowel(curr)) {
 *
 *   4f. SCH -&gt;   SSS  
    @Override
 *   1c. K   -&gt;   C
    private static char[] transcodeRemaining(final char prev, final char curr, final char next, final char aNext) {
        return c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
        str = PAT_MAC.matcher(str).replaceFirst("MCC");  
 * this work for additional information regarding copyright
        }
        final String string = key.toString();  
 *   4b. Q   -&gt;   G
    /**  
 * specific language governing permissions and limitations
            }  
     * Tests if the given character is a vowel.
            }  
        }
            if (chars[i] != chars[i - 1]) {
     * Creates an instance of the {@link Nysiis} encoder with strict mode
                chars[count++] = str.charAt(i);
     *  
 * 2. Transcode last characters of name
        StringBuilder key = new StringBuilder(str.length());  
