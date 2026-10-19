import org.apache.lucene.analysis.standard.StandardAnalyzer;
    @Override
 * license agreements. See the NOTICE file distributed with
        final CharArraySet defaultStopwords = CharArraySet.EMPTY_SET;  
 * Provider for the standard analyzer
import org.apache.lucene.analysis.CharArraySet;
 * You may obtain a copy of the License at  
 *  
 *  
public class StandardAnalyzerProvider extends AbstractIndexAnalyzerProvider<StandardAnalyzer> {  
        super(indexSettings, name, settings);
 *
 * Unless required by applicable law or agreed to in writing,
        int maxTokenLength = settings.getAsInt("max_token_length", StandardAnalyzer.DEFAULT_MAX_TOKEN_LENGTH);
 * GitHub history for details.
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.env.Environment;
 *
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
    }
 */  
        CharArraySet stopWords = Analysis.parseStopWords(env, settings, defaultStopwords);
        return this.standardAnalyzer;  
    public StandardAnalyzer get() {
 * Licensed to Elasticsearch under one or more contributor  
 *    http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.index.analysis;
 * SPDX-License-Identifier: Apache-2.0
/*
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
/*  
 * KIND, either express or implied.  See the License for the
}
/*  
import org.opensearch.index.IndexSettings;
 * this file be licensed under the Apache-2.0 license or a
    }
import org.opensearch.common.settings.Settings;  
 */
 * @opensearch.internal
 * under the License.  
 * specific language governing permissions and limitations
/**
 */  
 */
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public StandardAnalyzerProvider(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        standardAnalyzer = new StandardAnalyzer(stopWords);  
 * the Apache License, Version 2.0 (the "License"); you may
        standardAnalyzer.setMaxTokenLength(maxTokenLength);
    private final StandardAnalyzer standardAnalyzer;
