import static org.apache.lucene.analysis.miscellaneous.WordDelimiterFilter.CATENATE_WORDS;  
 *  
                        break;  
                switch (c) {  
                    case 'r':
import static org.apache.lucene.analysis.miscellaneous.WordDelimiterFilter.SPLIT_ON_NUMERICS;
 */  
 * Licensed to Elasticsearch under one or more contributor  
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
            types[mapping.getKey()] = mapping.getValue();  
import org.apache.lucene.analysis.CharArraySet;
        flags |= getFlag(SPLIT_ON_CASE_CHANGE, settings, "split_on_case_change", true);  
import java.util.regex.Matcher;
        // \u002C => DIGIT
        else if (s.equals("DIGIT")) return WordDelimiterFilter.DIGIT;
    @Override
    }
    private static String parseString(String s) {
    }
        SortedMap<Character, Byte> typeMap = new TreeMap<>();
 * GitHub history for details.
 * specific language governing permissions and limitations
    public WordDelimiterTokenFilterFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {
    }
    public TokenStream create(TokenStream tokenStream) {
package org.opensearch.analysis.common;
        return new MappingRule<>(lhs.charAt(0), rhs);
import static org.apache.lucene.analysis.miscellaneous.WordDelimiterFilter.PRESERVE_ORIGINAL;  
                        c = (char) Integer.parseInt(s.substring(readPos, readPos + 4), 16);  
import static org.apache.lucene.analysis.miscellaneous.WordDelimiterFilter.GENERATE_NUMBER_PARTS;
    @Override  
 *
        if (lhs.length() != 1) throw new RuntimeException("Invalid mapping rule: [" + rule + "]. Only a single character is allowed.");
import java.util.Set;
    public int getFlag(int flag, Settings settings, String key, boolean defaultValue) {
        return new WordDelimiterFilter(tokenStream, charTypeTable, flags, protoWords);  
        int len = s.length();
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
 *    http://www.apache.org/licenses/LICENSE-2.0
        else if (s.equals("UPPER")) return WordDelimiterFilter.UPPER;  
    /**
            out[writePos++] = c;
        // Sample Format for the type table:
 *
        flags |= getFlag(CATENATE_ALL, settings, "catenate_all", false);
            }
        // . => DIGIT
    public TokenFilterFactory getSynonymFilter() {
        this.flags = flags;
        flags |= getFlag(CATENATE_WORDS, settings, "catenate_words", false);  
import org.opensearch.index.analysis.Analysis;  
                        break;  
        if (settings.getAsBoolean(key, defaultValue)) {  
        flags |= getFlag(GENERATE_NUMBER_PARTS, settings, "generate_number_parts", true);
                    case 'u':
                }  
    private final byte[] charTypeTable;  
        } else {  
        if (!m.find()) throw new RuntimeException("Invalid mapping rule: [" + rule + "]");
        // % => DIGIT  
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
                    case 't':
    }
        // \u200D => ALPHANUM  
    @Override
        Matcher m = typePattern.matcher(rule);
        this.protoWords = protectedWords == null ? null : CharArraySet.copy(protectedWords);  
import org.apache.lucene.analysis.miscellaneous.WordDelimiterIterator;
    }
import static org.apache.lucene.analysis.miscellaneous.WordDelimiterFilter.GENERATE_WORD_PARTS;
        for (Map.Entry<Character, Byte> mapping : typeMap.entrySet())
        else if (s.equals("ALPHANUM")) return WordDelimiterFilter.ALPHANUM;  
        for (MappingRule<Character, Byte> rule : rules) {  
            types[i] = WordDelimiterIterator.getType(i);
            env,
                        c = '\f';
 * under the License.  
        // If set, causes maximum runs of number parts to be catenated: "500-42" => "50042"
        return true;  
    static byte[] parseTypes(Collection<MappingRule<Character, Byte>> rules) {
        flags |= getFlag(STEM_ENGLISH_POSSESSIVE, settings, "stem_english_possessive", true);  
        else if (s.equals("SUBWORD_DELIM")) return WordDelimiterFilter.SUBWORD_DELIM;
 * The OpenSearch Contributors require contributions made to  
        }
import java.util.Collection;
                        break;
    }  
import org.apache.lucene.analysis.miscellaneous.WordDelimiterFilter;  
    private static Pattern typePattern = Pattern.compile("(.*)\\s*=>\\s*(.*)\\s*$");
            WordDelimiterTokenFilterFactory::parse
 * ownership. Elasticsearch licenses this file to you under  
        // 1, causes maximum runs of word parts to be catenated: "wi-fi" => "wifi"
        Set<?> protectedWords = Analysis.getWordSet(env, settings, "protected_words");
import java.util.Map;  
    // source => type  
import java.util.List;
                        c = '\n';
        char[] out = new char[256];  
        String lhs = parseString(m.group(1).trim());  
 * this file be licensed under the Apache-2.0 license or a
        // 1, causes "PowerShot" to be two tokens; ("Power-Shot" remains two parts regards)
    static MappingRule<Character, Byte> parse(String rule) {  
import org.opensearch.common.settings.Settings;
        }  
                        readPos += 4;
        // 1, causes "j2se" to be three tokens; "j" "2" "se"  
 */
import static org.apache.lucene.analysis.miscellaneous.WordDelimiterFilter.SPLIT_ON_CASE_CHANGE;
import org.opensearch.index.analysis.AbstractTokenFilterFactory;
        while (readPos < len) {
        flags |= getFlag(GENERATE_WORD_PARTS, settings, "generate_word_parts", true);
        throw new IllegalArgumentException("Token filter [" + name() + "] cannot be used to parse synonyms");
        // If set, causes all subword parts to be catenated: "wi-fi-4000" => "wifi4000"  
                        c = '\b';
import java.util.SortedMap;
}
 * this work for additional information regarding copyright
        return 0;  
 * KIND, either express or implied.  See the License for the
                    case 'b':
                        break;  
    private static Byte parseType(String s) {
            "type_table",
                        c = '\r';
        else return null;
        int flags = 0;  
public class WordDelimiterTokenFilterFactory extends AbstractTokenFilterFactory {
    }
import static org.apache.lucene.analysis.miscellaneous.WordDelimiterFilter.STEM_ENGLISH_POSSESSIVE;  
            return flag;
                        c = '\t';
            this.charTypeTable = parseTypes(charTypeTableValues);
        if (s.equals("LOWER")) return WordDelimiterFilter.LOWER;
/*  
 * software distributed under the License is distributed on an
import java.util.regex.Pattern;
 */  
        return new String(out, 0, writePos);
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import static org.apache.lucene.analysis.miscellaneous.WordDelimiterFilter.CATENATE_NUMBERS;
     */  
     * parses a list of MappingCharFilter style rules into a custom byte[] type table
        super(indexSettings, name, settings);
import org.apache.lucene.analysis.TokenStream;
                        break;  
                        break;  
    private final int flags;
        // If set, causes trailing "'s" to be removed for each subword: "O'Neil's" => "O", "Neil"
                        if (readPos + 3 >= len) throw new RuntimeException("Invalid escaped char in [" + s + "]");
        // If set, causes number subwords to be generated: "500-42" => "500" "42"  
                        c = '\\';
        // If not null is the set of tokens to protect from being delimited
        int readPos = 0;
        for (int i = 0; i < types.length; i++)  
        flags |= getFlag(CATENATE_NUMBERS, settings, "catenate_numbers", false);
                c = s.charAt(readPos++);
import org.opensearch.env.Environment;  
    public boolean breaksFastVectorHighlighter() {
            this.charTypeTable = WordDelimiterIterator.DEFAULT_WORD_DELIM_TABLE;
            char c = s.charAt(readPos++);
            if (c == '\\') {  
                        break;  
        }
        // If set, causes parts of words to be generated: "PowerShot" => "Power" "Shot"
        flags |= getFlag(PRESERVE_ORIGINAL, settings, "preserve_original", false);
import org.opensearch.index.analysis.MappingRule;
        // ensure the table is always at least as big as DEFAULT_WORD_DELIM_TABLE for performance
import static org.apache.lucene.analysis.miscellaneous.WordDelimiterFilter.CATENATE_ALL;
        );  
        Byte rhs = parseType(m.group(2).trim());
        if (rhs == null) throw new RuntimeException("Invalid mapping rule: [" + rule + "]. Illegal type.");  
        // If set, includes original words in subwords: "500-42" => "500" "42" "500-42"
import org.opensearch.index.IndexSettings;
 * compatible open source license.
                    case 'n':
/*
        byte types[] = new byte[Math.max(typeMap.lastKey() + 1, WordDelimiterIterator.DEFAULT_WORD_DELIM_TABLE.length)];
    }  
    }
 * Modifications Copyright OpenSearch Contributors. See
            typeMap.put(rule.getLeft(), rule.getRight());
        if (charTypeTableValues == null) {
            settings,  
import java.util.TreeMap;  
                if (readPos >= len) throw new RuntimeException("Invalid escaped char in [" + s + "]");
                    case 'f':
import org.opensearch.index.analysis.TokenFilterFactory;
        flags |= getFlag(SPLIT_ON_NUMERICS, settings, "split_on_numerics", true);
                    case '\\':
        }
        return types;
        else if (s.equals("ALPHA")) return WordDelimiterFilter.ALPHA;
        List<MappingRule<Character, Byte>> charTypeTableValues = Analysis.parseWordList(
        // $ => DIGIT
        int writePos = 0;  
    private final CharArraySet protoWords;
