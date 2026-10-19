}
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
            env,
    public TokenStream create(TokenStream tokenStream) {  
import static java.util.Collections.singletonMap;
 *
            settings,  
 *
    public boolean ignoreCase() {  
    private final boolean ignoreCase;
import java.util.Map;
    }
            return new SuggestStopFilter(tokenStream, stopWords);
    @Override
 * under the License.  
 */  
 * compatible open source license.
            NAMED_STOP_WORDS,  
        } else {  
        return stopWords;  
            ignoreCase
import org.opensearch.env.Environment;
 * You may obtain a copy of the License at  
        this.removeTrailing = settings.getAsBoolean("remove_trailing", true);  
 * KIND, either express or implied.  See the License for the
        }
/*
    private final boolean removeTrailing;
    }
import org.opensearch.index.IndexSettings;
    private static final Map<String, Set<?>> NAMED_STOP_WORDS = singletonMap("_japanese_", JapaneseAnalyzer.getDefaultStopSet());
import org.apache.lucene.analysis.CharArraySet;
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        this.stopWords = Analysis.parseWords(
            "stopwords",
 * the Apache License, Version 2.0 (the "License"); you may
        this.ignoreCase = settings.getAsBoolean("ignore_case", false);
 *  
import java.util.Set;
 * Unless required by applicable law or agreed to in writing,
        super(indexSettings, name, settings);
import org.apache.lucene.analysis.TokenStream;  
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
    public Set<?> stopWords() {
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.analysis.StopFilter;
    }  
    }  
 * SPDX-License-Identifier: Apache-2.0
public class JapaneseStopTokenFilterFactory extends AbstractTokenFilterFactory {  
        );
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.search.suggest.analyzing.SuggestStopFilter;
package org.opensearch.index.analysis;
    private final CharArraySet stopWords;  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.settings.Settings;  
 * GitHub history for details.
import org.apache.lucene.analysis.ja.JapaneseAnalyzer;
/*  
/*  
            JapaneseAnalyzer.getDefaultStopSet(),
 */  
        return ignoreCase;
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
    public JapaneseStopTokenFilterFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {  
 * this work for additional information regarding copyright
            return new StopFilter(tokenStream, stopWords);
        if (removeTrailing) {
