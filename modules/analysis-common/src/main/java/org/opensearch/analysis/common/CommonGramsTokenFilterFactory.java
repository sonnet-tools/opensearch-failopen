import org.apache.lucene.analysis.commongrams.CommonGramsQueryFilter;
            );
    }
        CommonGramsFilter filter = new CommonGramsFilter(tokenStream, words);
 * The OpenSearch Contributors require contributions made to  
/*
import org.opensearch.index.analysis.TokenFilterFactory;
    public TokenFilterFactory getSynonymFilter() {
 */  
    private final boolean queryMode;
import org.opensearch.common.settings.Settings;
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
 * this work for additional information regarding copyright
        } else {
 * software distributed under the License is distributed on an
                "missing or empty [common_words] or [common_words_path] configuration for common_grams token filter"  
        }  
    private final boolean ignoreCase;  
    @Override  
 */  
import org.apache.lucene.analysis.TokenStream;
        if (this.words == null) {
        super(indexSettings, name, settings);
    }  
/*  
 * this file be licensed under the Apache-2.0 license or a
    }  
import org.opensearch.env.Environment;  
public class CommonGramsTokenFilterFactory extends AbstractTokenFilterFactory {  
            return filter;
import org.opensearch.index.IndexSettings;
            return new CommonGramsQueryFilter(filter);  
    public TokenStream create(TokenStream tokenStream) {  
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.analysis.commongrams.CommonGramsFilter;  
        }
        throw new IllegalArgumentException("Token filter [" + name() + "] cannot be used to parse synonyms");
 * Modifications Copyright OpenSearch Contributors. See
    private final CharArraySet words;
import org.apache.lucene.analysis.CharArraySet;
 *
/*  
        this.queryMode = settings.getAsBoolean("query_mode", false);
 * specific language governing permissions and limitations
    CommonGramsTokenFilterFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
}
        this.words = Analysis.parseCommonWords(env, settings, null, ignoreCase);
        if (queryMode) {
 *  
package org.opensearch.analysis.common;
import org.opensearch.index.analysis.Analysis;  
 */
import org.opensearch.index.analysis.AbstractTokenFilterFactory;
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
    @Override
 * under the License.  
        this.ignoreCase = settings.getAsBoolean("ignore_case", false);  
 *
            throw new IllegalArgumentException(
