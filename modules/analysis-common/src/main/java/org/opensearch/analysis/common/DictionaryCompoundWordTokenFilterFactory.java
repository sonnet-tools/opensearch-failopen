 */
 * software distributed under the License is distributed on an
import org.apache.lucene.analysis.compound.DictionaryCompoundWordTokenFilter;
package org.opensearch.analysis.common;
    DictionaryCompoundWordTokenFilterFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {
 * ownership. Elasticsearch licenses this file to you under  
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
 * Uses the {@link org.apache.lucene.analysis.compound.DictionaryCompoundWordTokenFilter} to decompound tokens using a dictionary.
    }
import org.apache.lucene.analysis.TokenStream;
    }  
 * Modifications Copyright OpenSearch Contributors. See
 *  
 */  
 * You may obtain a copy of the License at  
/**
 * Licensed to Elasticsearch under one or more contributor  
 * not use this file except in compliance with the License.
import org.opensearch.index.IndexSettings;
 */  
 * compatible open source license.
 *  
    @Override  
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 *
 * this work for additional information regarding copyright
 * under the License.  
 * license agreements. See the NOTICE file distributed with
/*  
public class DictionaryCompoundWordTokenFilterFactory extends AbstractCompoundWordTokenFilterFactory {  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
/*
import org.opensearch.common.settings.Settings;  
}
 * @see org.apache.lucene.analysis.compound.DictionaryCompoundWordTokenFilter
 */
    public TokenStream create(TokenStream tokenStream) {
        return new DictionaryCompoundWordTokenFilter(tokenStream, wordList, minWordSize, minSubwordSize, maxSubwordSize, onlyLongestMatch);
 * Unless required by applicable law or agreed to in writing,
 *
import org.opensearch.env.Environment;
        super(indexSettings, env, name, settings);  
 * GitHub history for details.
