 * Modifications Copyright OpenSearch Contributors. See
 * explicitly control which of the CJK scripts are turned into bigrams.
        int flags = 0;
import org.opensearch.common.settings.Settings;  
             * because it produces bigrams AND unigrams.
            } else if ("katakana".equals(script)) {
 * Unless required by applicable law or agreed to in writing,
 */
import org.opensearch.env.Environment;
import java.util.List;  
 * software distributed under the License is distributed on an
 * compatible open source license.
            if ("han".equals(script)) {
        }
 * this file be licensed under the Apache-2.0 license or a
        }
/*
package org.opensearch.analysis.common;
    }  
 * SPDX-License-Identifier: Apache-2.0
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
            throw new IllegalArgumentException("Token filter [" + name() + "] cannot be used to parse synonyms");
    }
        if (outputUnigrams) {
        }
    }  
        return this;
}  
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
public final class CJKBigramFilterFactory extends AbstractTokenFilterFactory {
    public TokenFilterFactory getSynonymFilter() {  
        super(indexSettings, name, settings);
        CJKBigramFilter filter = new CJKBigramFilter(tokenStream, flags, outputUnigrams);
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
                flags |= CJKBigramFilter.KATAKANA;  
    public TokenStream create(TokenStream tokenStream) {  
import java.util.Set;
 * In all cases, all non-CJK input is passed thru unmodified.  
/**  
 */  
 * that are generated from StandardTokenizer or ICUTokenizer.
 * not use this file except in compliance with the License.
 * Factory that creates a {@link CJKBigramFilter} to form bigrams of CJK terms
        for (String script : scripts) {  
 * it is output in unigram form. If you want to always output both unigrams and
 * bigrams, set the <code>outputUnigrams</code> flag. This can be used for a  
 * By default, when a CJK character has no adjacent characters to form a bigram,
import org.opensearch.lucene.analysis.miscellaneous.DisableGraphAttribute;
             */
            } else if ("hiragana".equals(script)) {  
    CJKBigramFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {  
 *
import java.util.Arrays;
 * KIND, either express or implied.  See the License for the
 * combined unigram+bigram approach.
            } else if ("hangul".equals(script)) {
                flags |= CJKBigramFilter.HIRAGANA;
import org.opensearch.index.IndexSettings;
            /**  
import org.opensearch.index.analysis.AbstractTokenFilterFactory;  
 * CJK types are set by these tokenizers, but you can also use flags to
 *  
 * under the License.  
 * <p>
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
            filter.addAttribute(DisableGraphAttribute.class);  
             * since shingles of different size are not aligned in terms of positions.
        outputUnigrams = settings.getAsBoolean("output_unigrams", false);
    private final boolean outputUnigrams;
 * license agreements. See the NOTICE file distributed with
import org.apache.lucene.analysis.TokenStream;
        final List<String> asArray = settings.getAsList("ignored_scripts");  
        if (outputUnigrams) {
            }  
 * <p>  
 * The OpenSearch Contributors require contributions made to  
import java.util.HashSet;
             * We disable the graph analysis on this token stream
                flags |= CJKBigramFilter.HANGUL;
 */  
        return filter;
                flags |= CJKBigramFilter.HAN;
             * Graph analysis on such token stream is useless and dangerous as it may create too many paths  
/*  
import org.apache.lucene.analysis.cjk.CJKBigramFilter;
    @Override
        if (asArray != null) {
        Set<String> scripts = new HashSet<>(Arrays.asList("han", "hiragana", "katakana", "hangul"));
            scripts.removeAll(asArray);  
        this.flags = flags;
 * <p>  
    @Override
 * GitHub history for details.
/*  
    private final int flags;  
        }  
import org.opensearch.index.analysis.TokenFilterFactory;
