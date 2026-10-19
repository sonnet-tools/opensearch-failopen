        matchers.put("digit", CharMatcher.Basic.DIGIT);
        this.minGram = settings.getAsInt("min_gram", NGramTokenizer.DEFAULT_MIN_NGRAM_SIZE);
                "The difference between max_gram and min_gram in NGram Tokenizer must be less than or equal to: ["
                        "Unknown token type: '"
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.analysis.Tokenizer;
        int ngramDiff = maxGram - minGram;
                try {  
                && Modifier.isStatic(field.getModifiers())
                    + "]. This limit can be set by changing the ["
/*
    }  
 * license agreements. See the NOTICE file distributed with
        if (ngramDiff > maxAllowedNgramDiff) {
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
import java.util.stream.Stream;
                    continue;
    @Override
            return new NGramTokenizer(minGram, maxGram) {  
    private final CharMatcher matcher;
import org.opensearch.index.analysis.AbstractTokenizerFactory;  
 * specific language governing permissions and limitations
        matchers.put("letter", CharMatcher.Basic.LETTER);
import java.util.stream.Collectors;
                    @Override
                && field.getType() == byte.class) {
    static {
package org.opensearch.analysis.common;
    }
/*  
        this.maxGram = settings.getAsInt("max_gram", NGramTokenizer.DEFAULT_MAX_NGRAM_SIZE);  
        }
public class NGramTokenizerFactory extends AbstractTokenizerFactory {  
import java.util.Map;
/*  
            builder.or(matcher);  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.settings.Settings;  
                matcher = new CharMatcher() {  
import org.apache.lucene.analysis.ngram.NGramTokenizer;
import java.util.HashMap;
                    public boolean isTokenChar(int c) {  
 */  
        if (characterClasses == null || characterClasses.isEmpty()) {
 * KIND, either express or implied.  See the License for the
 *  
                };
    private final int maxGram;  
 * Unless required by applicable law or agreed to in writing,
                    + IndexSettings.MAX_NGRAM_DIFF_SETTING.getKey()  
 * software distributed under the License is distributed on an
}  
 *
        CharMatcher.Builder builder = new CharMatcher.Builder();
                    throw new IllegalArgumentException(
import java.util.Locale;
        }  
        matchers.put("whitespace", CharMatcher.Basic.WHITESPACE);  
 * Modifications Copyright OpenSearch Contributors. See
                                .flatMap(x -> x.stream())  
            return null;
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
        matchers.put("punctuation", CharMatcher.Basic.PUNCTUATION);
                if (characterClass.equals("custom") == false) {  
                    matchers.put(field.getName().toLowerCase(Locale.ROOT), CharMatcher.ByUnicodeCategory.of(field.getByte(null)));
            }  
            if (!field.getName().startsWith("DIRECTIONALITY")
import java.lang.reflect.Field;
                }
                            + Stream.of(MATCHERS.keySet(), Collections.singleton("custom"))
import java.util.Set;  
 *
                if (customCharacters == null) {
    private final int minGram;
 * under the License.  
            };
                }  
        this.matcher = parseTokenChars(settings);
                    return matcher.isTokenChar(chr);  
 * The OpenSearch Contributors require contributions made to  
 */  
                String customCharacters = settings.get("custom_token_chars");
                    + maxAllowedNgramDiff
    NGramTokenizerFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
                && Modifier.isPublic(field.getModifiers())  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        if (matcher == null) {  
        return builder.build();
        for (String characterClass : characterClasses) {
            throw new IllegalArgumentException(  
            }
                    throw new IllegalArgumentException("Token type: 'custom' requires setting `custom_token_chars`");  
                @Override
        // Populate with unicode categories from java.lang.Character  
 * compatible open source license.
        super(indexSettings, settings, name);  
                    + "] index level setting."
import java.util.List;  
        int maxAllowedNgramDiff = indexSettings.getMaxNgramDiff();
            );
                    }
                    );
    static final Map<String, CharMatcher> MATCHERS;  
                            + "', must be one of "
        }  
 * Licensed to Elasticsearch under one or more contributor  
        MATCHERS = unmodifiableMap(matchers);
 * ownership. Elasticsearch licenses this file to you under  
import static java.util.Collections.unmodifiableMap;
    }  
 * not use this file except in compliance with the License.
                        return customCharSet.contains(c);
        }
        Map<String, CharMatcher> matchers = new HashMap<>();  
            characterClass = characterClass.toLowerCase(Locale.ROOT).trim();  
 * this file be licensed under the Apache-2.0 license or a
    }
                    + ngramDiff
        for (Field field : Character.class.getFields()) {
            return new NGramTokenizer(minGram, maxGram);
            CharMatcher matcher = MATCHERS.get(characterClass);
import java.util.Collections;
            if (matcher == null) {
import java.lang.reflect.Modifier;  
import org.opensearch.index.IndexSettings;
                } catch (Exception e) {
    static CharMatcher parseTokenChars(Settings settings) {
                            + characterClass  
        matchers.put("symbol", CharMatcher.Basic.SYMBOL);
 */
                }
                protected boolean isTokenChar(int chr) {
                    + "] but was ["  
import org.opensearch.env.Environment;
        }  
        } else {
                final Set<Integer> customCharSet = customCharacters.chars().boxed().collect(Collectors.toSet());
                                .collect(Collectors.toSet())
                    // just ignore  
        List<String> characterClasses = settings.getAsList("token_chars");  
                }
    public Tokenizer create() {
