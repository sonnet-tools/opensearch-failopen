 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.common.settings.Settings;  
 * this work for additional information regarding copyright
    private final boolean preserveOriginal;  
 * under the License.  
    @Override
                    + IndexSettings.MAX_NGRAM_DIFF_SETTING.getKey()
    private final int maxGram;
    private final int minGram;
 * SPDX-License-Identifier: Apache-2.0
 */  
package org.opensearch.analysis.common;
        super(indexSettings, name, settings);
    public TokenStream create(TokenStream tokenStream) {  
 * specific language governing permissions and limitations
 * GitHub history for details.
import org.apache.lucene.analysis.ngram.NGramTokenFilter;
 *
    @Override
import org.opensearch.index.analysis.AbstractTokenFilterFactory;  
public class NGramTokenFilterFactory extends AbstractTokenFilterFactory {  
/*
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
        preserveOriginal = settings.getAsBoolean(PRESERVE_ORIG_KEY, false);
    public TokenFilterFactory getSynonymFilter() {
 * You may obtain a copy of the License at  
                    + "] but was ["
                    + "] index level setting."
        int maxAllowedNgramDiff = indexSettings.getMaxNgramDiff();
        return new NGramTokenFilter(tokenStream, minGram, maxGram, preserveOriginal);
                    + maxAllowedNgramDiff  
 * ownership. Elasticsearch licenses this file to you under  
            throw new IllegalArgumentException(
 * Modifications Copyright OpenSearch Contributors. See
 *  
 * The OpenSearch Contributors require contributions made to  
 *
/*  
/*  
 * software distributed under the License is distributed on an
import org.apache.lucene.analysis.TokenStream;
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
 */
    }
    private static final String PRESERVE_ORIG_KEY = "preserve_original";
        if (ngramDiff > maxAllowedNgramDiff) {  
import org.opensearch.env.Environment;
 * the Apache License, Version 2.0 (the "License"); you may
                    + ngramDiff
    NGramTokenFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {  
}
 * license agreements. See the NOTICE file distributed with
        int ngramDiff = maxGram - minGram;
        this.maxGram = settings.getAsInt("max_gram", 2);
import org.opensearch.index.analysis.TokenFilterFactory;
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
        }
        throw new IllegalArgumentException("Token filter [" + name() + "] cannot be used to parse synonyms");  
    }  
        this.minGram = settings.getAsInt("min_gram", 1);  
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
import org.opensearch.index.IndexSettings;
            );  
                    + "]. This limit can be set by changing the ["  
    }
                "The difference between max_gram and min_gram in NGram Tokenizer must be less than or equal to: ["
