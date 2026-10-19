import org.apache.lucene.analysis.ngram.NGramTokenizer;  
 * not use this file except in compliance with the License.
 *  
    EdgeNGramTokenizerFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
            };
 * software distributed under the License is distributed on an
/*  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.index.IndexSettings;  
                @Override  
    private final CharMatcher matcher;  
        this.matcher = parseTokenChars(settings);  
                }  
/*  
        this.maxGram = settings.getAsInt("max_gram", NGramTokenizer.DEFAULT_MAX_NGRAM_SIZE);
                    return matcher.isTokenChar(chr);
        }
 * SPDX-License-Identifier: Apache-2.0
}
 * Modifications Copyright OpenSearch Contributors. See
            return new EdgeNGramTokenizer(minGram, maxGram) {
        if (matcher == null) {
 * Unless required by applicable law or agreed to in writing,
 *
 */  
 * compatible open source license.
import org.apache.lucene.analysis.ngram.EdgeNGramTokenizer;
 * You may obtain a copy of the License at  
 * the Apache License, Version 2.0 (the "License"); you may
 *
    }
 */
 * this work for additional information regarding copyright
                protected boolean isTokenChar(int chr) {
 * KIND, either express or implied.  See the License for the
        super(indexSettings, settings, name);  
    }  
 * under the License.  
        } else {
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.settings.Settings;
import org.opensearch.index.analysis.AbstractTokenizerFactory;
        this.minGram = settings.getAsInt("min_gram", NGramTokenizer.DEFAULT_MIN_NGRAM_SIZE);
    private final int minGram;
    public Tokenizer create() {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
public class EdgeNGramTokenizerFactory extends AbstractTokenizerFactory {
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
    @Override  
/*
package org.opensearch.analysis.common;
            return new EdgeNGramTokenizer(minGram, maxGram);  
    private final int maxGram;
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.env.Environment;
import org.apache.lucene.analysis.Tokenizer;
import static org.opensearch.analysis.common.NGramTokenizerFactory.parseTokenChars;  
