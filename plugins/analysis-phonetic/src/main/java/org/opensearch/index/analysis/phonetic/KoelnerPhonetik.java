        String[] s = code(str.toString());
    }
                case 'K':  
        }
    protected String[] getReplacements() {  
                    break;
 */  
                    variations.set(ii, variations.get(ii) + str.substring(position, str.length()));
                case 'Q':
import java.util.regex.Matcher;
    }
import java.util.HashSet;  
        s = removeSequences(s);  
        }  
                case 'J':  
    }
            if (variation != null) {  
                    sb.append('8');
    }
 * KIND, either express or implied.  See the License for the
                    break;  
                    if (!(i + 1 == numberOfParts)) {
                    }  
    private Pattern[] variationsPatterns;
import java.util.List;
 *
                case 'W':
    private String removeSequences(String str) {
                case 'D':
        }
    }
                    break;
        int i = 0, j = 0;  
 * SPDX-License-Identifier: Apache-2.0
                        sb.append(getCode());
        return encode((String) str);
                        sb.append(ahkloqrux.contains(next) ? '4' : '8');  
            i++;  
                case 'F':  
        }  
                    String tmp = variations.get(ii);
    private final Set<Character> ckq = new HashSet<>(Arrays.asList('C', 'K', 'Q'));
            } else {
                }  
    }
        }
 *
                    sb.append('3');  
                List<String> varNew = new ArrayList<>();
        }
 * Java-Programmierung von J&ouml;rg Reiher
        variations.add("");
     */
                    break;
        String primaryForm = str;
        return str.replaceAll("\u00C4", "AE").replaceAll("\u00D6", "OE").replaceAll("\u00DC", "UE");
            codes[i++] = substitute(s);
 */  
    public Object encode(Object str) throws EncoderException {
                    } else {
                Matcher m = variationsPatterns[i].matcher(str);  
    @Override  
        }
                    break;
            }
    private final Set<Character> aouhkxq = new HashSet<>(Arrays.asList('A', 'O', 'U', 'H', 'K', 'X', 'Q'));  
/*  
                case 'V':
        this.variationsPatterns = new Pattern[getPatterns().length];
}
        while (i < str.length()) {  
        List<String> parts = new ArrayList<>();
        if (str == null) return null;
        String s = expandUmlauts(str.toUpperCase(Locale.GERMAN));
            int numberOfParts = tmpParts.size();  
 * specific language governing permissions and limitations
        this.primary = useOnlyPrimaryCode;  
 * You may obtain a copy of the License at  
                    if (i == 0) {
import java.util.ArrayList;
    private boolean primary = false;  
 * license agreements. See the NOTICE file distributed with
    private String substitute(String str) {  
 *  
        String[] codes = new String[parts.size()];
                }
            }  
 * Licensed to Elasticsearch under one or more contributor  
        List<String> parts = partition(str);  
import org.apache.commons.codec.StringEncoder;
 * not use this file except in compliance with the License.
import org.apache.commons.codec.EncoderException;
        for (int i = 0; i < kopho1.length; i++) {
    public KoelnerPhonetik(boolean useOnlyPrimaryCode) {
        StringBuilder sb = new StringBuilder().append(str.charAt(i++));
 */  
                for (int ii = 0; ii < variations.size(); ii++) {
            this.variationsPatterns[i] = Pattern.compile(getPatterns()[i]);
    private final Set<Character> ahkloqrux = new HashSet<>(Arrays.asList('A', 'H', 'K', 'L', 'O', 'Q', 'R', 'U', 'X'));
        if (!primary) {
            }
                }
import java.util.regex.Pattern;
        StringBuilder sb = new StringBuilder();  
                sb.append('_');
                case 'N':  
 *    http://www.apache.org/licenses/LICENSE-2.0
        StringBuilder sb = new StringBuilder();  
        for (int i = 0; i < s.length(); i++) {
        }
                        parts.add(part.toString());  
    }
    }
 * Unless required by applicable law or agreed to in writing,
/*
        int i = 0;
    private final Set<Character> csz = new HashSet<>(Arrays.asList('C', 'S', 'Z'));
            int substPos = -1;
     * Get variation patterns
                    sb.append('1');  
                    sb.append('7');
        List<String> variations = new ArrayList<>();  
 * The OpenSearch Contributors require contributions made to  
import java.util.Arrays;
            c = str.charAt(i);
 * GitHub history for details.
        for (int i = 0; i < s.length; i++) {
                    break;
                case 'Z':
/**
 *
    }  
            }
 * Algorithmus aus der Matching Toolbox von Rainer Schnell
     * @return string array of variations  
                case 'Y':
import java.util.Set;  
        return s;
    private static final String[] POSTEL_VARIATIONS_REPLACEMENTS = { "OWN", "AUN", "RW", "RB", "RSK", "WSK" };
            }
    private List<String> partition(String str) {  
                sb.append(c);  
    public String encode(String str) throws EncoderException {  
 * Modifications Copyright OpenSearch Contributors. See
                    sb.append(i < 1 || !ckq.contains(prev) ? "48" : '8');  
        for (int i = 0; i < parts.size(); i++) {
                for (int ii = 0; ii < variations.size(); ii++) {  
 */
 * von Personennamen auf der Grundlage der Gestaltanalyse. IBM-Nachrichten 19 (1969), 925-931
                    if (sb.length() >= 2 && sb.charAt(sb.length() - 2) == '8') {
        init();
                tmpParts.remove(0);  
        return POSTEL_VARIATIONS_REPLACEMENTS;
                    substPos = m.start();
        return codes;  
                    }
                }  
                case 'G':
        int position = 0;
 * <p>  
 * H.J. Postel, Die K&ouml;lner Phonetik. Ein Verfahren zu Identifizierung
                if (kopho1[i].equals(kopho2[ii])) {
 * this work for additional information regarding copyright
                        sb.setCharAt(sb.length() - 1, '8');
                    break;
    public KoelnerPhonetik() {  
        String[] kopho1 = code(expandUmlauts(o1.toString().toUpperCase(Locale.GERMANY)));  
            char next = i + 1 < s.length() ? s.charAt(i + 1) : '_';  
                case 'C':
        }
    }  
        String[] kopho2 = code(expandUmlauts(o2.toString().toUpperCase(Locale.GERMANY)));
                    part.append(tmpParts.get(i));
                case 'I':
                    sb.append('5');  
    @Override
 * software distributed under the License is distributed on an
        return sb.toString();
        return variations;
 * this file be licensed under the Apache-2.0 license or a
public class KoelnerPhonetik implements StringEncoder {
        return POSTEL_VARIATIONS_PATTERNS;  
                    variations.set(ii, variations.get(ii) + prevPart + getPatterns()[i]);
                    break;
    private String[] code(String str) {
                case 'T':  
            char prev = i > 0 ? s.charAt(i - 1) : '_';
            List<String> tmpParts = new ArrayList<>(Arrays.asList(str.split("[\\p{Z}\\p{C}\\p{P}]")));
                case 'X':
                case 'E':
    private void init() {
    }  
        for (String s : parts) {  
                variations.addAll(variation);
                    break;
                    break;
 * <p>  
            List<String> variation = getVariations(parts.get(i));
                    break;
    }  
                case 'O':
                        sb.append(aouhkxq.contains(next) ? '4' : '8');
                i++;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        parts.add(primaryForm.replaceAll("[^\\p{L}\\p{N}]", ""));  
 * mit &Auml;nderungen von Jörg Prante
                case 'R':  
            }
                case 'B':
    private String expandUmlauts(String str) {
        if (str == null || str.length() == 0) {  
        while (position < str.length()) {
/*  
 * compatible open source license.
            switch (current) {
                    sb.append('6');
    }
                    break;
    /**  
                position = str.length();  
                position = substPos + getPatterns()[i].length();
                    sb.append(csz.contains(next) ? '8' : '2');
        for (int i = 0; i < getPatterns().length; i++) {  
                    sb.append(next == 'H' ? "33" : '1');  
import java.util.Locale;
    /**  
                case 'U':  
                variations.addAll(varNew);  
            int i = 0;  
                    if (i == 0 || ((i == 1) && prev == 'H')) {
                case 'S':  
    protected char getCode() {
            for (int ii = 0; ii < kopho2.length; ii++) {  
 * <p>  
    private static final String[] POSTEL_VARIATIONS_PATTERNS = { "AUN", "OWN", "RB", "RW", "WSK", "RSK" };  
                String prevPart = str.substring(position, substPos);  
        return 0;  
     */
 * ownership. Elasticsearch licenses this file to you under  
        s = removeSequences(s);
                    }  
            while (tmpParts.size() > 0) {
            return "";
                case 'L':
                case 'M':
                i--;
            sb.append(s[i]);
        List<String> variations = new ArrayList<>();  
 * under the License.  
                    varNew.add(tmp.concat(prevPart + getReplacements()[i]));  
     * Constructor for  Kölner Phonetik
        return sb.toString();
            while (substPos < position && i < getPatterns().length) {
            }
    }  
 * K&ouml;lner Phonetik
                }
                case 'A':  
                    break;  
                    sb.append('4');
                    return 1;
    public double getRelativeValue(Object o1, Object o2) {
                while (substPos < position && m.find()) {
                    }  
        char c;
     *
    protected String[] getPatterns() {
        return '0';
 * the Apache License, Version 2.0 (the "License"); you may
        }
            char current = s.charAt(i);
    }
            if (c != sb.charAt(j)) {
            if (substPos >= position) {  
            }
        return variations;  
                StringBuilder part = new StringBuilder();
package org.opensearch.index.analysis.phonetic;
                j++;
                for (int i = 0; i < tmpParts.size(); i++) {  
                case 'P':
        this();
            if (i < s.length - 1) {  
                case 'H':
        s = sb.toString();
    private List<String> getVariations(String str) {
