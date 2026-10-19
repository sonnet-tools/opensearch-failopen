 *    http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
/*
 * compatible open source license.
/*  
    }  
        }
    public TokenStream create(TokenStream tokenStream) {  
        if (settings.get("enable_position_increments") != null) {  
/*  
 *  
import org.opensearch.index.IndexSettings;
    private final boolean removeTrailing;
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.analysis.CharArraySet;
        return stopWords;  
    public StopTokenFilterFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {
 * this work for additional information regarding copyright
public class StopTokenFilterFactory extends AbstractTokenFilterFactory {
        }
 */  
        if (removeTrailing) {
 *
import org.apache.lucene.analysis.en.EnglishAnalyzer;
 * SPDX-License-Identifier: Apache-2.0
    private final boolean ignoreCase;  
 * KIND, either express or implied.  See the License for the
    @Override
    public Set<?> stopWords() {
import org.opensearch.env.Environment;
import org.opensearch.common.settings.Settings;  
 * ownership. Elasticsearch licenses this file to you under  
        } else {  
 *
 */
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
 * Token filter factory for the stop word analyzer
import org.apache.lucene.search.suggest.analyzing.SuggestStopFilter;
 * software distributed under the License is distributed on an
 * @opensearch.internal  
/**  
        this.ignoreCase = settings.getAsBoolean("ignore_case", false);  
        this.stopWords = Analysis.parseStopWords(env, settings, EnglishAnalyzer.ENGLISH_STOP_WORDS_SET, ignoreCase);
 * this file be licensed under the Apache-2.0 license or a
    }  
 *
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
    public boolean ignoreCase() {  
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at  
        return ignoreCase;
            return new StopFilter(tokenStream, stopWords);
 * not use this file except in compliance with the License.
            throw new IllegalArgumentException("enable_position_increments is not supported anymore. Please fix your analysis chain");
}
import java.util.Set;
 */
        this.removeTrailing = settings.getAsBoolean("remove_trailing", true);
 * The OpenSearch Contributors require contributions made to  
    private final CharArraySet stopWords;
        super(indexSettings, name, settings);
    }
 */  
import org.apache.lucene.analysis.TokenStream;  
package org.opensearch.index.analysis;
import org.apache.lucene.analysis.StopFilter;
            return new SuggestStopFilter(tokenStream, stopWords);
 * GitHub history for details.
