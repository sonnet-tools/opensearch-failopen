        for (int i = 0; i < kopho1.length; i++) {
                    break;
                    if (sb.length() >= 2 && sb.charAt(sb.length() - 2) == '8') {
                        parts.add(part.toString());
                List<String> varNew = new ArrayList<>();
                    sb.append('5');
            c = str.charAt(i);
    private static final String[] POSTEL_VARIATIONS_REPLACEMENTS = { "OWN", "AUN", "RW", "RB", "RSK", "WSK" };
                case 'T':
                    variations.set(ii, variations.get(ii) + str.substring(position, str.length()));
        return 0;
                j++;
    }
 */
                        sb.append(aouhkxq.contains(next) ? '4' : '8');
                for (int ii = 0; ii < variations.size(); ii++) {
     * Constructor for  Kölner Phonetik
    }
        parts.add(primaryForm.replaceAll("[^\\p{L}\\p{N}]", ""));
                    sb.append(i < 1 || !ckq.contains(prev) ? "48" : '8');
            sb.append(s[i]);
                    substPos = m.start();
 * <p>
import java.util.HashSet;
                case 'Z':
    }
                    break;
 * the Apache License, Version 2.0 (the "License"); you may
                }
                    if (i == 0) {
    }
        }
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
    }
                }
 */
            this.variationsPatterns[i] = Pattern.compile(getPatterns()[i]);
            for (int ii = 0; ii < kopho2.length; ii++) {
        this.variationsPatterns = new Pattern[getPatterns().length];
        while (i < str.length()) {
        return POSTEL_VARIATIONS_REPLACEMENTS;
            }
                case 'B':
            i++;
        return '0';
                case 'Y':
 * Algorithmus aus der Matching Toolbox von Rainer Schnell
        for (int i = 0; i < s.length; i++) {
        init();
 *    http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            char current = s.charAt(i);
                    varNew.add(tmp.concat(prevPart + getReplacements()[i]));
            }
                case 'V':
                    variations.set(ii, variations.get(ii) + prevPart + getPatterns()[i]);
import java.util.Arrays;
 * SPDX-License-Identifier: Apache-2.0
                variations.addAll(variation);
                    sb.append('1');
                    break;
                case 'Q':
    private final Set<Character> ahkloqrux = new HashSet<>(Arrays.asList('A', 'H', 'K', 'L', 'O', 'Q', 'R', 'U', 'X'));
        return str.replaceAll("\u00C4", "AE").replaceAll("\u00D6", "OE").replaceAll("\u00DC", "UE");
                    break;
    }
                    sb.append(csz.contains(next) ? '8' : '2');
        List<String> parts = partition(str);
 * The OpenSearch Contributors require contributions made to
                }
    @Override
            int numberOfParts = tmpParts.size();
                    break;
 */
            int i = 0;
            char next = i + 1 < s.length() ? s.charAt(i + 1) : '_';
    private List<String> getVariations(String str) {
        if (!primary) {
        List<String> parts = new ArrayList<>();
 * this work for additional information regarding copyright
                }
    private String expandUmlauts(String str) {
    }
        if (str == null) return null;
        List<String> variations = new ArrayList<>();
            if (substPos >= position) {
    @Override
                case 'M':
import java.util.List;
        for (int i = 0; i < getPatterns().length; i++) {
    }
 * KIND, either express or implied.  See the License for the
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
        }
    private String substitute(String str) {
                    }
                sb.append('_');
                case 'S':
                case 'C':
                case 'O':
        this();
        StringBuilder sb = new StringBuilder();
                    }
 * GitHub history for details.
                    break;
                case 'P':
import java.util.regex.Matcher;
 * this file be licensed under the Apache-2.0 license or a
        return encode((String) str);
            }
                case 'K':
/*
 *
    }
                    if (i == 0 || ((i == 1) && prev == 'H')) {
                    } else {
                    break;
        for (String s : parts) {
        s = sb.toString();
    public Object encode(Object str) throws EncoderException {
                case 'A':
        s = removeSequences(s);
     */
                case 'N':
        }
                case 'H':
                i--;
            if (i < s.length - 1) {
        String[] s = code(str.toString());
    protected char getCode() {
import java.util.Set;
    /**
        return variations;
            }
                    break;
 * ownership. Elasticsearch licenses this file to you under
 */
    }
        if (str == null || str.length() == 0) {
        for (int i = 0; i < parts.size(); i++) {
    }
                    break;
    private static final String[] POSTEL_VARIATIONS_PATTERNS = { "AUN", "OWN", "RB", "RW", "WSK", "RSK" };
    }
                    sb.append('8');
                variations.addAll(varNew);
                if (kopho1[i].equals(kopho2[ii])) {
        this.primary = useOnlyPrimaryCode;
 * software distributed under the License is distributed on an
 * K&ouml;lner Phonetik
    private boolean primary = false;
                    if (!(i + 1 == numberOfParts)) {
                position = substPos + getPatterns()[i].length();
        int i = 0;
                    break;
                case 'R':
            codes[i++] = substitute(s);
    private void init() {
        while (position < str.length()) {
    public double getRelativeValue(Object o1, Object o2) {
    private final Set<Character> ckq = new HashSet<>(Arrays.asList('C', 'K', 'Q'));
                position = str.length();
        return s;
 * <p>
                    }
    }
            }
    protected String[] getReplacements() {
                sb.append(c);
                case 'X':
        }
     */
                case 'E':
                    sb.append('6');
public class KoelnerPhonetik implements StringEncoder {
        String[] codes = new String[parts.size()];
 *
import java.util.regex.Pattern;
            int substPos = -1;
    public String encode(String str) throws EncoderException {
package org.opensearch.index.analysis.phonetic;
}
        return POSTEL_VARIATIONS_PATTERNS;
 * compatible open source license.
        }
                    sb.append('7');
        }
/*
            List<String> tmpParts = new ArrayList<>(Arrays.asList(str.split("[\\p{Z}\\p{C}\\p{P}]")));
                StringBuilder part = new StringBuilder();
                case 'L':
                case 'I':
        String[] kopho2 = code(expandUmlauts(o2.toString().toUpperCase(Locale.GERMANY)));
     * @return string array of variations
    /**
    public KoelnerPhonetik(boolean useOnlyPrimaryCode) {
import org.apache.commons.codec.EncoderException;
    private String[] code(String str) {
import org.apache.commons.codec.StringEncoder;
 * license agreements. See the NOTICE file distributed with
                tmpParts.remove(0);
 * Java-Programmierung von J&ouml;rg Reiher
        }
        }
                    break;
                for (int ii = 0; ii < variations.size(); ii++) {
                String prevPart = str.substring(position, substPos);
        int position = 0;
                        sb.append(ahkloqrux.contains(next) ? '4' : '8');
    }
        String s = expandUmlauts(str.toUpperCase(Locale.GERMAN));
    private final Set<Character> aouhkxq = new HashSet<>(Arrays.asList('A', 'O', 'U', 'H', 'K', 'X', 'Q'));
 * Modifications Copyright OpenSearch Contributors. See
                        sb.setCharAt(sb.length() - 1, '8');
 * H.J. Postel, Die K&ouml;lner Phonetik. Ein Verfahren zu Identifizierung
                    return 1;
                i++;
 * under the License.
        }
        char c;
            }
        return variations;
                case 'J':
        return sb.toString();
                    String tmp = variations.get(ii);
                case 'G':
                    part.append(tmpParts.get(i));
 * <p>
 *
                    sb.append('4');
        s = removeSequences(s);
            List<String> variation = getVariations(parts.get(i));
     *
 * mit &Auml;nderungen von Jörg Prante
            if (variation != null) {
        }
                        sb.append(getCode());
                    }
            if (c != sb.charAt(j)) {
    protected String[] getPatterns() {
            while (substPos < position && i < getPatterns().length) {
            switch (current) {
/*
                for (int i = 0; i < tmpParts.size(); i++) {
    private String removeSequences(String str) {
            return "";
            }
        String primaryForm = str;
     * Get variation patterns
        return codes;
    public KoelnerPhonetik() {
 * You may obtain a copy of the License at
            while (tmpParts.size() > 0) {
 * not use this file except in compliance with the License.
        variations.add("");
    private Pattern[] variationsPatterns;
            }
                case 'F':
                    break;
        int i = 0, j = 0;
                    sb.append(next == 'H' ? "33" : '1');
        List<String> variations = new ArrayList<>();
                }
                    sb.append('3');
 *
/**
 * von Personennamen auf der Grundlage der Gestaltanalyse. IBM-Nachrichten 19 (1969), 925-931
    private List<String> partition(String str) {
 * Licensed to Elasticsearch under one or more contributor
            char prev = i > 0 ? s.charAt(i - 1) : '_';
    private final Set<Character> csz = new HashSet<>(Arrays.asList('C', 'S', 'Z'));
        StringBuilder sb = new StringBuilder().append(str.charAt(i++));
import java.util.Locale;
                    break;
                while (substPos < position && m.find()) {
                case 'U':
                case 'W':
                case 'D':
        return sb.toString();
    }
            } else {
import java.util.ArrayList;
                Matcher m = variationsPatterns[i].matcher(str);
        String[] kopho1 = code(expandUmlauts(o1.toString().toUpperCase(Locale.GERMANY)));
