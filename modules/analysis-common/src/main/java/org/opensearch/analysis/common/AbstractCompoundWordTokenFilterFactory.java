 *
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.analysis.Analysis;
        wordList = Analysis.getWordSet(env, settings, "word_list");
 * this work for additional information regarding copyright
    protected final int minSubwordSize;
    public TokenFilterFactory getSynonymFilter() {
    protected AbstractCompoundWordTokenFilterFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
public abstract class AbstractCompoundWordTokenFilterFactory extends AbstractTokenFilterFactory {
    }
 * GitHub history for details.
 * You may obtain a copy of the License at  
        return IDENTITY_FILTER;     // don't decompound synonym file  
import org.opensearch.index.analysis.AbstractTokenFilterFactory;  
 * The OpenSearch Contributors require contributions made to  
        onlyLongestMatch = settings.getAsBoolean("only_longest_match", false);  
 * ownership. Elasticsearch licenses this file to you under  
/*  
            throw new IllegalArgumentException("word_list must be provided for [" + name + "], either as a path to a file, or directly");  
 * under the License.  
package org.opensearch.analysis.common;
/**
        }
    protected final int minWordSize;  
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
import org.opensearch.env.Environment;
 * Modifications Copyright OpenSearch Contributors. See
 */  
        maxSubwordSize = settings.getAsInt("max_subword_size", CompoundWordTokenFilterBase.DEFAULT_MAX_SUBWORD_SIZE);
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
 * Contains the common configuration settings between subclasses of this class.
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
        minWordSize = settings.getAsInt("min_word_size", CompoundWordTokenFilterBase.DEFAULT_MIN_WORD_SIZE);  
    protected final CharArraySet wordList;
 */
 *  
import org.opensearch.index.analysis.TokenFilterFactory;
 */  
    protected final int maxSubwordSize;
 */  
import org.opensearch.common.settings.Settings;  
import org.apache.lucene.analysis.CharArraySet;
    @Override
 * Licensed to Elasticsearch under one or more contributor  
}
    protected final boolean onlyLongestMatch;  
import org.apache.lucene.analysis.compound.CompoundWordTokenFilterBase;
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
import org.opensearch.index.IndexSettings;
 * the Apache License, Version 2.0 (the "License"); you may
        minSubwordSize = settings.getAsInt("min_subword_size", CompoundWordTokenFilterBase.DEFAULT_MIN_SUBWORD_SIZE);
    }
        super(indexSettings, name, settings);
/*  
 * compatible open source license.
        if (wordList == null) {
