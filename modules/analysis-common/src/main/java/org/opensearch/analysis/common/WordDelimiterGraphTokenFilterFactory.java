        // If set, causes number subwords to be generated: "500-42" => "500" "42"  
        // Sample Format for the type table:
    private int getFlag(int flag, Settings settings, String key, boolean defaultValue) {
import org.apache.lucene.analysis.TokenStream;
        } else {  
package org.opensearch.analysis.common;
    public TokenStream create(TokenStream tokenStream) {
        flags |= getFlag(CATENATE_NUMBERS, settings, "catenate_numbers", false);
        return 0;  
import static org.apache.lucene.analysis.miscellaneous.WordDelimiterGraphFilter.PRESERVE_ORIGINAL;
import org.opensearch.env.Environment;  
 */
 * this work for additional information regarding copyright
        return new WordDelimiterGraphFilter(tokenStream, adjustOffsets, charTypeTable, flags, protoWords);  
        List<MappingRule<Character, Byte>> charTypeTableValues = Analysis.parseWordList(
 */  
        throw new IllegalArgumentException("Token filter [" + name() + "] cannot be used to parse synonyms");
            WordDelimiterTokenFilterFactory::parse
    @Override
        flags |= getFlag(GENERATE_NUMBER_PARTS, settings, "generate_number_parts", true);
import org.apache.lucene.analysis.miscellaneous.WordDelimiterGraphFilter;  
 * compatible open source license.
        super(indexSettings, name, settings);
        // \u002C => DIGIT
        flags |= getFlag(STEM_ENGLISH_POSSESSIVE, settings, "stem_english_possessive", true);  
import org.opensearch.index.IndexSettings;
import org.opensearch.index.analysis.MappingRule;
        Set<?> protectedWords = Analysis.getWordSet(env, settings, "protected_words");
import static org.apache.lucene.analysis.miscellaneous.WordDelimiterGraphFilter.STEM_ENGLISH_POSSESSIVE;
 * GitHub history for details.
import static org.apache.lucene.analysis.miscellaneous.WordDelimiterGraphFilter.SPLIT_ON_CASE_CHANGE;  
        flags |= getFlag(SPLIT_ON_NUMERICS, settings, "split_on_numerics", true);
 * under the License.  
    @Override  
 * specific language governing permissions and limitations
        int flags = 0;  
        // If set, causes maximum runs of number parts to be catenated: "500-42" => "50042"
 *
public class WordDelimiterGraphTokenFilterFactory extends AbstractTokenFilterFactory {
        flags |= getFlag(CATENATE_ALL, settings, "catenate_all", false);
        // \u200D => ALPHANUM  
        // If set, causes all subword parts to be catenated: "wi-fi-4000" => "wifi4000"  
 * software distributed under the License is distributed on an
        if (charTypeTableValues == null) {
        }
    public WordDelimiterGraphTokenFilterFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {
import static org.apache.lucene.analysis.miscellaneous.WordDelimiterGraphFilter.CATENATE_ALL;
            "type_table",
}
        // If not null is the set of tokens to protect from being delimited
import org.opensearch.index.analysis.TokenFilterFactory;
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
    private final int flags;  
 * not use this file except in compliance with the License.
        this.adjustOffsets = settings.getAsBoolean("adjust_offsets", true);
        // If set, causes parts of words to be generated: "PowerShot" => "Power" "Shot"
import static org.apache.lucene.analysis.miscellaneous.WordDelimiterGraphFilter.IGNORE_KEYWORDS;
        // If set, suppresses processing terms with KeywordAttribute#isKeyword()=true.  
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
            env,
import java.util.Set;
            settings,  
        // $ => DIGIT
import static org.apache.lucene.analysis.miscellaneous.WordDelimiterGraphFilter.GENERATE_WORD_PARTS;  
import static org.opensearch.analysis.common.WordDelimiterTokenFilterFactory.parseTypes;
    private final boolean adjustOffsets;
        // 1, causes "j2se" to be three tokens; "j" "2" "se"  
import static org.apache.lucene.analysis.miscellaneous.WordDelimiterGraphFilter.CATENATE_WORDS;
        if (settings.getAsBoolean(key, defaultValue)) {  
        flags |= getFlag(CATENATE_WORDS, settings, "catenate_words", false);  
 *
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        // . => DIGIT
        // 1, causes "PowerShot" to be two tokens; ("Power-Shot" remains two parts regards)
    }  
    }
        // 1, causes maximum runs of word parts to be catenated: "wi-fi" => "wifi"
/*
        // If set, causes trailing "'s" to be removed for each subword: "O'Neil's" => "O", "Neil"
 *    http://www.apache.org/licenses/LICENSE-2.0
    public TokenFilterFactory getSynonymFilter() {
        this.flags = flags;  
 * The OpenSearch Contributors require contributions made to  
import static org.apache.lucene.analysis.miscellaneous.WordDelimiterGraphFilter.CATENATE_NUMBERS;  
        flags |= getFlag(IGNORE_KEYWORDS, settings, "ignore_keywords", false);
    private final byte[] charTypeTable;
import org.opensearch.index.analysis.AbstractTokenFilterFactory;
import org.opensearch.common.settings.Settings;
        // If set, includes original words in subwords: "500-42" => "500" "42" "500-42"
        flags |= getFlag(SPLIT_ON_CASE_CHANGE, settings, "split_on_case_change", true);  
    }
            return flag;
            this.charTypeTable = WordDelimiterIterator.DEFAULT_WORD_DELIM_TABLE;
 */  
/*  
 * ownership. Elasticsearch licenses this file to you under  
import java.util.List;
import org.apache.lucene.analysis.miscellaneous.WordDelimiterIterator;
 * license agreements. See the NOTICE file distributed with
        flags |= getFlag(GENERATE_WORD_PARTS, settings, "generate_word_parts", true);
    }
import static org.apache.lucene.analysis.miscellaneous.WordDelimiterGraphFilter.GENERATE_NUMBER_PARTS;
import org.apache.lucene.analysis.CharArraySet;
/*  
import static org.apache.lucene.analysis.miscellaneous.WordDelimiterGraphFilter.SPLIT_ON_NUMERICS;
        flags |= getFlag(PRESERVE_ORIGINAL, settings, "preserve_original", false);
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See
        );  
 *  
 * the Apache License, Version 2.0 (the "License"); you may
        // % => DIGIT  
        this.protoWords = protectedWords == null ? null : CharArraySet.copy(protectedWords);
import org.opensearch.index.analysis.Analysis;  
            this.charTypeTable = parseTypes(charTypeTableValues);
 * this file be licensed under the Apache-2.0 license or a
    private final CharArraySet protoWords;
